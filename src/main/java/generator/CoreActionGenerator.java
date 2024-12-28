package generator;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CoreActionGenerator {

    // Method to build parameters from the JSON object
    private static String buildParameters(String parameterName, boolean includeTypeAndLocator) {
        StringBuilder parameters = new StringBuilder();
        try {
            JSONObject param = new JSONObject(parameterName);
            String paramType = param.getString("type");
            int paramCount = param.getInt("number");

            // Optionally include type and locator
            if (includeTypeAndLocator) {
                parameters.append("String type, String locator");
            }

            // Add dynamic parameters based on the number field
            for (int j = 0; j < paramCount; j++) {
                if (parameters.length() > 0) {
                    parameters.append(", "); // Add comma for separating parameters
                }
                parameters.append(paramType).append(" param").append(j + 1);
            }
        } catch (Exception e) {
            if (includeTypeAndLocator) {
                parameters.append("String type, String locator"); // Fallback for invalid JSON
            }
        }
        return parameters.toString();
    }
    public static void main(String[] args) {
        String INPUT_FILE_PATH = "D:\\testCaseGenerator\\testCaseGenerator\\src\\main\\resources\\coreActions.json";
        String OUTPUT_DIR_PATH = "D:\\testCaseGenerator\\testCaseGenerator\\src\\main\\java\\stepFiles\\CoreActions.java";

        try {
            // Read the JSON file
            String content = new String(Files.readAllBytes(Paths.get(INPUT_FILE_PATH)));
            JSONArray jsonArray = new JSONArray(content);

            System.out.println("Number of methods read from JSON: " + jsonArray.length());

            // Generate CoreAction.java
            String generatedCode = generateCoreActionClass(jsonArray);

            String[] generatedMethods = generatedCode.split("public ");
            System.out.println("Number of methods generated: " + (generatedMethods.length - 3));

            for (int i = 1; i < generatedMethods.length; i++) {
                System.out.println("Method " + i + ": " + generatedMethods[i].split("\\{")[0].trim());
            }

            // Write to the output file
            writeToFile(OUTPUT_DIR_PATH, generatedCode);

            System.out.println("CoreAction.java has been generated successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String generateCoreActionClass(JSONArray jsonArray) {
        StringBuilder classBuilder = new StringBuilder();
        // Class Header
        classBuilder.append("package stepFiles;\n").append("import org.openqa.selenium.By;\n").append("import org.openqa.selenium.WebDriver;\n")
                .append("import org.openqa.selenium.WebElement;\n").append("import org.openqa.selenium.support.ui.Select;\n")
                .append("import java.util.List;\n\n")
                .append("import org.openqa.selenium.interactions.Actions;\n\n")
                .append("public class CoreActions {\n\n")
                .append("    private WebDriver driver;\n\n").append("    public CoreActions(WebDriver driver) {\n")
                .append("        this.driver = driver;\n").append("    }\n\n")
                .append("    private WebElement findElement(String type, String value) {\n")
                .append("        switch (type) {\n")
                .append("            case \"id\":\n").append("                return driver.findElement(By.id(value));\n")
                .append("            case \"className\":\n").append("                return driver.findElement(By.className(value));\n")
                .append("            case \"name\":\n").append("                return driver.findElement(By.name(value));\n")
                .append("            case \"partialLinkText\":\n")
                .append("                return driver.findElement(By.partialLinkText(value));\n")
                .append("            case \"tagName\":\n")
                .append("                return driver.findElement(By.tagName(value));\n")
                .append("            case \"xpath\":\n")
                .append("                return driver.findElement(By.xpath(value));\n")
                .append("            case \"cssSelector\":\n")
                .append("                return driver.findElement(By.cssSelector(value));\n")
                .append("            case \"linkText\":\n").append("                return driver.findElement(By.linkText(value));\n")
                .append("            default:\n").append("                throw new IllegalArgumentException(\"Invalid locator type: \" + type);\n")
                .append("        }\n").append("    }\n\n").append("    private List<WebElement> findElements(String type, String value) {\n")
                .append("        switch (type) {\n").append("            case \"id\":\n").append("                return driver.findElements(By.id(value));\n")
                .append("            case \"className\":\n").append("                return driver.findElements(By.className(value));\n")
                .append("            case \"name\":\n").append("                return driver.findElements(By.name(value));\n")
                .append("            case \"partialLinkText\":\n").append("                return driver.findElements(By.partialLinkText(value));\n")
                .append("            case \"tagName\":\n").append("                return driver.findElements(By.tagName(value));\n").append("            case \"xpath\":\n")
                .append("                return driver.findElements(By.xpath(value));\n").append("            case \"cssSelector\":\n")
                .append("                return driver.findElements(By.cssSelector(value));\n").append("            case \"linkText\":\n")
                .append("                return driver.findElements(By.linkText(value));\n").append("            default:\n")
                .append("                throw new IllegalArgumentException(\"Invalid locator type: \" + type);\n").append("        }\n")
                .append("    }\n\n");

        // Generate Methods
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);

            String methodName = jsonObject.getString("methodName");
            String seleniumAction = jsonObject.getString("seleniumAction");
            String parameterName = jsonObject.optString("parameterName", null);
            String description = jsonObject.getString("description");
            String returnType = jsonObject.optString("return", "void"); // Default to "void" if not provided

            // Append JavaDoc for the method
            classBuilder.append("    /**\n").append("     * ").append(description).append("\n").append("     */\n");

            // Method Signature
            if (returnType.equalsIgnoreCase("string")) {
                classBuilder.append("    public String ").append(methodName).append("(");
            } else if (returnType.equalsIgnoreCase("boolean")) {
                classBuilder.append("    public boolean ").append(methodName).append("(");
            } else if (returnType.equalsIgnoreCase("int")) {
                classBuilder.append("    public int ").append(methodName).append("(");
            } else {
                classBuilder.append("    public void ").append(methodName).append("(");
            }

            // Handle method parameters based on "parameterName"
            // Main logic for handling parameter generation
            if ("basic".equals(parameterName)) {
                classBuilder.append("String type, String locator");
            } else if ("ImplicitWait".equals(methodName)) {
                // Special case for ImplicitWait: No type and locator
                classBuilder.append(buildParameters(parameterName, false));}
            else if ("openWebPage".equals(methodName)){
                classBuilder.append("String param1");
               // no basic String type, and String locator for openWebPage
            } else if (parameterName != null) {
                // General case: Include type and locator
                classBuilder.append(buildParameters(parameterName, true));
            }
            // Closing the method signature
            classBuilder.append(") {\n");

            // Method Body based on seleniumAction
            switchToGenerateMethodBody(classBuilder,seleniumAction);

            classBuilder.append("    }\n\n");
        }

        // Class Footer
        classBuilder.append("}\n");

        return classBuilder.toString();
    }

    public static void switchToGenerateMethodBody(StringBuilder classBuilder, String seleniumAction){
    switch (seleniumAction) {
        case "get":
            classBuilder.append("        driver.get(param1);\n");
            break;
        case "getCurrentUrl":
            classBuilder.append("        return driver.getCurrentUrl();\n");
            break;
        case "getTitle":
            classBuilder.append("        return driver.getTitle();\n");
            break;
        case "getElementTagName":
            classBuilder.append("        WebElement element = findElement(type, locator);\n").append("        return element.getTagName();\n");
            break;
        case "getElementText":
            classBuilder.append("        WebElement element = findElement(type, locator);\n").append("        return element.getText();\n");
            break;
        case "sendKeys":
            classBuilder.append("        WebElement element = findElement(type, locator);\n")
                    .append("        for (char c : param1.toCharArray()) {\n" +
                    "            element.sendKeys(String.valueOf(c));\n" +
                    "        }\n");
            break;
        case "click":
            classBuilder.append("        WebElement element = findElement(type, locator);\n").append("        element.click();\n");
            break;
        case "submit":
            classBuilder.append("        WebElement element = findElement(type, locator);\n").append("        element.submit();\n");
            break;
        case "clear":
            classBuilder.append("        WebElement element = findElement(type, locator);\n").append("        element.clear();\n");
            break;
        case "hyperLink":
            classBuilder.append("        WebElement linkElement = findElement(type, locator);\n").append("        boolean hyperLinkStatus = linkElement.getTagName().equalsIgnoreCase(\"a\") && linkElement.getAttribute(\"href\") != null;\n").append("        return hyperLinkStatus ;\n");
            break;
        case "partialText":
            classBuilder.append("        WebElement linkElement = findElement(type, locator);\n").append("        boolean hyperLinkStatus = linkElement.getTagName().equalsIgnoreCase(\"a\") && linkElement.getAttribute(\"href\") != null;\n").append("        return hyperLinkStatus ;\n");
            break;
        case "verifiedText":
            classBuilder.append("        WebElement element = findElement(type, locator);\n").append("        String actualText = element.getText();\n").append("        return actualText.contentEquals(param1) ;\n");
            break;
        case "verifiedMultipleText":
            classBuilder.append("       WebElement element = findElement(type, locator);\n").append("        String actualText = element.getText();\n").append("        for (String expectedText : param1) {\n").append("           if (actualText.contentEquals(expectedText)) {\n").append("               System.out.println(\"actualText does not match expectedText\" ); \n").append("                return false;\n").append("            }\n").append("        }\n").append("        return true;\n");
            break;
        case "ImplicitWait":
            classBuilder.append("        driver.manage().timeouts().implicitlyWait(param1, java.util.concurrent.TimeUnit.SECONDS);\n");
            break;
        case "quit":
            classBuilder.append("        driver.quit();\n");
            break;
        case "close":
            classBuilder.append("        driver.close();\n");
            break;
        case "getAttribute":
            classBuilder.append("        WebElement element = findElement(type, locator);\n").append("        return element.getAttribute(param1);\n");
            break;
        case "isDisplayed":
            classBuilder.append("        WebElement element = findElement(type, locator);\n").append("        return element.isDisplayed();\n");
            break;
        case "isSelected":
            classBuilder.append("        WebElement element = findElement(type, locator);\n").append("        return element.isSelected();\n");
            break;
        case "isEnabled":
            classBuilder.append("        WebElement element = findElement(type, locator);\n").append("        return element.isEnabled();\n");
            break;
        case "waitForElement":
            classBuilder.append("        WebDriverWait wait = new WebDriverWait(driver, 10);\n").append("        WebElement element = wait.until(driver -> driver.findElement(By.xpath(locator)));\n").append("        return element;\n");
            break;

        case "deSelectAllCheckBox":
            classBuilder.append("        List<WebElement> checkBoxes = findElements(type, locator);\n").append("        for (WebElement checkBox  : checkBoxes) {\n").append("            if (checkBox.isSelected()) {\n").append("                checkBox.click();\n").append("            }\n").append("        }\n");
            break;

        case "selectAllCheckBox":
            classBuilder.append("        List<WebElement> checkBoxes = findElements(type, locator);\n").append("        for (WebElement checkBox  : checkBoxes) {\n").append("            if (!checkBox.isSelected()) {\n").append("                checkBox.click();\n").append("            }\n").append("        }\n");
            break;

        case "selectAllOptionsFromDropDown":
            classBuilder.append("        WebElement selectElement = findElement(type, locator);\n").append("        Select select = new Select(selectElement);\n").append("        List<WebElement> options = select.getOptions();\n").append("        for (WebElement option : options) {\n").append("            if (!option.isSelected()) {\n").append("                option.click();\n").append("            }\n").append("        }\n");
            break;
        case "selectOptionByText":
            classBuilder.append("        WebElement element = findElement(type, locator);\n").append("        new Select(element).selectByVisibleText(param1);\n");
            break;
        case "selectOptionById":
            classBuilder.append("        WebElement element = findElement(type, locator);\n").append("        new Select(element).selectByIndex(param1);\n");
            break;
        case "selectOptionByValue":
            classBuilder.append("        WebElement element = findElement(type, locator);\n").append("        new Select(element).selectByValue(param1);\n");
            break;
        case "unSelectOptionByText":
            classBuilder.append("        WebElement element = findElement(type, locator);\n").append("        Select select = new Select(element);\n").append("        select.deselectByVisibleText(param1);\n");
            break;
        case "unSelectAllOptions":
            classBuilder.append("        WebElement element = findElement(type, locator);\n").append("        Select select = new Select(element);\n").append("        select.deselectAll();\n");
            break;
        case "unSelectOptionById":
            classBuilder.append("        WebElement element = findElement(type, locator);\n").append("        Select select = new Select(element);\n").append("        select.deselectByIndex(param1);\n");
            break;
        case "unSelectOptionByValue":
            classBuilder.append("        WebElement element = findElement(type, locator);\n").append("        Select select = new Select(element);\n").append("        select.deselectByValue(param1);\n");
            break;
        case "handOver":
            classBuilder.append("        WebElement element = findElement(type, locator);\n").append("        Actions actions = new Actions(driver);\n")
                    .append("            actions.moveToElement(element).perform();\n").append("        try {\n" +
                            "            Thread.sleep(10000);\n" +
                            "        } catch (InterruptedException e) {\n" +
                            "            throw new RuntimeException(e);\n" +
                            "        \n}");
            break;

        default:
            classBuilder.append("        // Add custom logic for seleniumAction: ").append(seleniumAction).append("\n");
            break;
    }
    }

    private static void writeToFile(String filePath, String content) throws IOException {
        File file = new File(filePath);
        FileWriter writer = new FileWriter(file);
        writer.write(content);
        writer.close();
    }
}
