package generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.json.JSONArray;

public class StepGenerator {

    private static final String INPUT_FILE_PATH = "D:/testCaseGenerator/testCaseGenerator/src/main/resources/step-definitions.json";
    private static final String OUTPUT_DIR_PATH = "D:/testCaseGenerator/testCaseGenerator/src/main/java/stepFiles/";

    public static void main(String[] args) {
        try {
            // Read JSON file
            String content = new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(INPUT_FILE_PATH)));
            JSONObject root = new JSONObject(content);

            // Process each page (e.g., logonPage, welcomePage, etc.)
            root.keySet().forEach(pageKey -> {
                JSONObject page = root.getJSONObject(pageKey);
                // Create or overwrite file for the page
                String filePath = OUTPUT_DIR_PATH + capitalizeFirstLetter(pageKey) + ".java";
                File file = new File(filePath);

                try (FileWriter writer = new FileWriter(file, false)) { // Open FileWriter in overwrite mode
                    // Write package declaration and imports
                    writer.append("package stepFiles;\n\n");
                    writer.append("import org.openqa.selenium.WebDriver;\n");
                    writer.append("import com.priortest.annotation.TestStepApi;\n");
                    writer.append("import org.testng.Assert;\n\n");
                    writer.append("import org.apache.logging.log4j.LogManager;\n");
                    writer.append("import org.apache.logging.log4j.Logger;\n\n");

                    // Write Class declaration
                    writer.append("public class " + capitalizeFirstLetter(pageKey) + " {\n\n");
                    writer.append("    private static final Logger log = LogManager.getLogger(" + capitalizeFirstLetter(pageKey) + ".class);\n");
                    // Add CoreActions as a global instance
                    writer.append("    private CoreActions coreAction;\n\n");
                    writer.append("    public " + capitalizeFirstLetter(pageKey) + "(WebDriver driver) {\n");
                    writer.append("        this.coreAction = new CoreActions(driver);\n");
                    writer.append("    }\n\n");

                    Set<String> generatedMethods = new HashSet<>(); // Track generated methods to avoid duplicates

                    // Process each step in the page
                    page.keySet().forEach(stepKey -> {
                        JSONObject step = page.getJSONObject(stepKey);
                        String methodName = "step" + capitalizeFirstLetter(stepKey);

                        // Check if the method has already been generated for this class
                        if (!generatedMethods.contains(methodName)) {
                            generateStepMethod(writer, stepKey, step);
                            generatedMethods.add(methodName); // Mark this method as generated
                        }
                    });

                    writer.append("}\n\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generateStepMethod(FileWriter writer, String stepName, JSONObject step) {
        // Prepare the method names and parameters
        String methodName = "step" + capitalizeFirstLetter(stepName);
        String stepDesc = step.getString("desc");
        String method = step.getString("method");
        JSONArray parameters = step.optJSONArray("parameters"); // Use optJSONArray to handle null gracefully
        JSONObject element = step.getJSONObject("element");

        // Generate method signature
        StringBuilder methodSignature = new StringBuilder("    public void " + methodName + "(");

        // If parameters are provided, add them to the method signature
        if (parameters != null) {
            parameters.forEach(param -> {
                String type = ((JSONObject) param).getString("type");
                methodSignature.append(type).append(" param, ");
            });
            if (methodSignature.toString().endsWith(", ")) {
                methodSignature.setLength(methodSignature.length() - 2); // Remove trailing comma
            }
        }

        methodSignature.append(") {");

        // Generate method body
        StringBuilder methodBody = new StringBuilder();
        methodBody.append("        boolean stepSuccess = false;\n");
        methodBody.append("        try {\n");
        if (method.toLowerCase().contains("verify")) {
            // Add CoreActions method call and assertion for verification steps
            methodBody.append("            boolean result = coreAction." + method + "(\"" + element.getString("type") + "\", \"" + element.getString("value") + "\"");
            // Add parameters to the method call
            if (parameters != null) {
                parameters.forEach(param -> {
                    methodBody.append(", param"); // Add parameter variable
                });
            }
            methodBody.append(");\n");
            methodBody.append("            Assert.assertTrue(result, \"Verification failed for " + stepName + "\");\n");
        } else if (element.isEmpty()) {
            methodBody.append("            coreAction." + method + "(");
            // Add parameters to the method call
            if (parameters != null) {
                parameters.forEach(param -> {
                    methodBody.append("param"); // Add parameter variable
                });
            }
            methodBody.append(");\n");

        } else {
            // Add CoreActions method call for actions like click, input, etc.
            methodBody.append("            coreAction." + method + "(\"" + element.getString("type") + "\", \"" + element.getString("value") + "\"");

            // Add parameters to the method call
            if (parameters != null) {
                parameters.forEach(param -> {
                    methodBody.append(", param"); // Add parameter variable
                });
            }
            methodBody.append(");\n");
        }

        methodBody.append("            stepSuccess = true;\n");
        methodBody.append("        } catch (Exception e) {\n");
        methodBody.append("            log.info(\"An error occurred: \" + e.getMessage());\n");
        methodBody.append("            throw e;\n");
        methodBody.append("        } finally {\n");
        methodBody.append("            if (!stepSuccess) {\n");
        methodBody.append("                throw new RuntimeException(\"Step Failed: " + methodName);
        if (parameters != null) {
            parameters.forEach(param -> {
                methodBody.append(" with parameter: \" + param"); // Add parameter variable
            });
        } else {
            methodBody.append("\"");
        }
        methodBody.append(");\n");
        methodBody.append("            }\n");
        methodBody.append("        }\n");
        methodBody.append("    }\n");

        // Write method to file
        try {
            writer.append("    @TestStepApi(stepDesc = \"" + stepDesc + "\" ,issueId=\" \")\n");
            writer.append(methodSignature.toString() + "\n");
            writer.append(methodBody.toString());
            writer.append("\n\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String capitalizeFirstLetter(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
