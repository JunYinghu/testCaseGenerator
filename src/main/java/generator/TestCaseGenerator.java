package generator;

import org.json.JSONObject;

import java.io.*;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestCaseGenerator {

    private StringBuilder classLevel;
    private ArrayList<String> classNames = new ArrayList<>(); // Initialize the list;

    public static void main(String[] args) {
        // Define feature file path and step definition JSON
        String stepDefinitionJsonPath = "D:/testCaseGenerator/testCaseGenerator/src/main/resources/step-definitions.json";
        String featureFilePath = "D:/testCaseGenerator/testCaseGenerator/src/test/resources/testCaseFeature/LoginTest.feature";
        String outputFilePath = "D:/testCaseGenerator/testCaseGenerator/src/test/java/testCases/";

        // get generated java file as per given feature file name
        String featureFileName = Paths.get(featureFilePath).getFileName().toString();
        featureFileName = featureFileName.substring(0, featureFileName.lastIndexOf('.')); // used for class name

        String generatedTestCaseFileName = featureFileName + "FeatureTestCase.java";
        String generatedJavaTestFileFullPath = outputFilePath + generatedTestCaseFileName;

        TestCaseGenerator generator = new TestCaseGenerator();
        generator.generateTestCases(featureFilePath, stepDefinitionJsonPath, generatedJavaTestFileFullPath,featureFileName);
    }

    public void generateTestCases(String featureFilePath, String stepDefinitionJsonPath, String generatedJavaTestFileFullPath, String featureFileName) {
        // Read the step definition JSON file content
        String stepDefContent = readFileContent(stepDefinitionJsonPath);

        // Parse the step definition JSON
        JSONObject stepDef = new JSONObject(stepDefContent);

        // Parse the feature file using Cucumber or regular parsing method
        List<Scenario> scenarios = getScenariosFromFeature(featureFilePath);

        // Create a test case file based on the Feature line
        String featureName = getFeatureNameFromFile(featureFilePath);
        StringBuilder testCase = new StringBuilder();

        // Initialize classLevel to hold instance variables (class-level setup)
        classLevel = new StringBuilder();

        // Start the Java file with necessary
        testCase.append("import config.BasicSetup;\n")
                .append("import org.testng.annotations.Test;\n")
                .append("import org.testng.annotations.BeforeClass;\n")
                .append("import org.testng.annotations.*;\n")
                .append("import static org.testng.Assert.*;\n\n")
                .append("import org.openqa.selenium.WebDriver;\n\n")
                .append("import utils.WebDriverSingleton;\n\n")
                .append("import com.priortest.annotation.TestCaseApi;\n\n")
                .append("import com.priortest.api.PriorTestAPIAdapter;\n\n")
                .append("import com.priortest.config.PTApiConfig;\n\n")
                .append("import com.priortest.config.PTApiFieldSetup;\n\n");

        // Start the public class (named after the feature name)
        testCase.append("@Listeners({ PriorTestAPIAdapter.class })");
        testCase.append("\n");
        testCase.append("public class ").append(featureFileName+"FeatureTestCase").append(" extends BasicSetup {\n\n");

        testCase.append("    private WebDriver driver;\n\n");

        // Loop through scenarios and generate test cases
        for (Scenario scenario : scenarios) {
            if (scenario instanceof ScenarioOutline) {
                ScenarioOutline scenarioOutline = (ScenarioOutline) scenario;
                for (Example example : scenarioOutline.getExamples()) {
                    String testCaseName = scenarioOutline.getName().replace(" ", "") + "_" + example.getTestCaseName();
                    generateTestCase(testCase, scenarioOutline, example, testCaseName,featureName, stepDef);  // Pass stepDef here
                }
            }
        }

        // Before class
        testCase.append("    @BeforeClass\n");
        testCase.append("    public void setUp(){" );
        testCase.append("\n");
        testCase.append("       driver = WebDriverSingleton.getDriver(WebDriverSingleton.BrowserType.FIREFOX);" );
        testCase.append("\n");
        ArrayList<String> importedClass = getSetupClassName();
        for (String name : importedClass){
            testCase.append("       "+getInstanceName(name) +  "= new " + name+"(driver);");
            testCase.append("\n");
        }
        // closed Before class
        testCase.append ("\n      }\n\n");

        testCase.append("    @AfterClass\n");
        testCase.append("    public void setDown(){" );
        testCase.append("\n");
        testCase.append("       WebDriverSingleton.quitDriver();" );
        testCase.append ("\n      }\n\n");

        testCase.insert(0, imports.toString());
        testCase.insert(0, "package testCases;\n");
        testCase.append(classLevel.toString()+";");
        // Close the class
        testCase.append("\n}\n");

        // Write the generated test case content to a Java file
        writeToFile(generatedJavaTestFileFullPath, testCase.toString());
    }

    private String readFileContent(String filePath) {
        StringBuilder content = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    private List<Scenario> getScenariosFromFeature(String featureFilePath) {
        List<Scenario> scenarios = new ArrayList<>();
        Scenario currentScenario = null;
        List<String> examples = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(featureFilePath));
            String line;
            while ((line = reader.readLine()) != null) {

                line = line.trim();
                if (line.startsWith("Scenario Outline:")) {
                    // Start of Scenario Outline
                    if (currentScenario != null) {
                        if (currentScenario instanceof ScenarioOutline) {
                            ((ScenarioOutline) currentScenario).setExamples(parseExamples(examples));
                        }
                        scenarios.add(currentScenario);
                    }
                    currentScenario = new ScenarioOutline(line.substring(17).trim());
                    examples.clear();
                } else if (line.startsWith("Scenario:")) {
                    // Start of regular Scenario
                    if (currentScenario != null) {
                        if (currentScenario instanceof ScenarioOutline) {
                            ((ScenarioOutline) currentScenario).setExamples(parseExamples(examples));
                        }
                        scenarios.add(currentScenario);
                    }
                    currentScenario = new Scenario(line.substring(9).trim());

                } else if (line.startsWith("Examples:")) {
                    // Start of Examples block
                    examples.clear();
                    continue;
                } else if (line.startsWith("|")) {
                    examples.add(line);
                } else if (!line.isEmpty()){
                    // Regular step line
                    if (currentScenario != null) {
                        Step step = new Step();
                        step.setDescription(line);
                        currentScenario.addStep(step);
                    }
                }

            }
            if (currentScenario != null) {
                if (currentScenario instanceof ScenarioOutline) {
                    ((ScenarioOutline) currentScenario).setExamples(parseExamples(examples));
                }
                scenarios.add(currentScenario);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return scenarios;
    }

    private List<Example> parseExamples(List<String> examples) {
        List<Example> parsedExamples = new ArrayList<>();
        if (!examples.isEmpty()) {
            String headerLine = examples.get(0); // The first line is the header for the examples
            String[] headers = headerLine.substring(1, headerLine.length() - 1).split("\\|");

            for (int i = 1; i < examples.size(); i++) {
                String exampleLine = examples.get(i).substring(1, examples.get(i).length() - 1).trim();
                String[] values = exampleLine.split("\\|");
                Example example = new Example();
                for (int j = 0; j < headers.length; j++) {
                    example.addParameter(headers[j].trim(), values[j].trim());
                }
                example.setTestCaseName(example.getParameter("testCaseName"));
                parsedExamples.add(example);
            }
        }
        return parsedExamples;
    }

    private void generateTestCase(StringBuilder testCase, ScenarioOutline scenarioOutline, Example example, String testCaseName,String featureName, JSONObject stepDef) {
        String methodName = "testCase_" + testCaseName;
        String feature = scenarioOutline.getName().replaceAll("\\s+", "");
        String priority = example.getParameter("priority");
        String severity = example.getParameter("severity");
        String caseCategory = example.getParameter("caseCategory");
        String automationId = feature+"_"+example.getParameter("automationId");
        // Add @Test and @TestCaseApi annotation to the method
        testCase.append("    @Test\n");
        testCase.append("    @TestCaseApi(feature = \""+featureName)
                .append("\", priority = \"")
                .append(priority)
                .append("\", severity = \"")
                .append(severity)
                .append("\", caseCategory = \"")
                .append(caseCategory)
                .append("\", automationId = \"")
                .append(automationId)
                .append("\", issueId = {})");
        testCase.append("\n");
        // Define the test method with the generated name
        testCase.append("    public void ").append(methodName).append("() {\n");

        // Loop through each step in the scenario outline
        for (Step step : scenarioOutline.getSteps()) {
            String stepDesc = step.getDescription();

            // Clean up the step description (remove keywords like Given, When, etc.)
            stepDesc = removeCucumberKeywords(stepDesc);
            stepDesc = removeParameters(stepDesc);  // Remove parameters enclosed in < >

            if (stepDesc.isEmpty()) {
                continue; // Skip this step if it's empty after removing keywords and parameters
            }
            if (stepDesc.startsWith("Wait")){
                testCase.append("        try { Thread.sleep(5000);} catch (InterruptedException e) {throw new RuntimeException(e);}");

            }
            // Look up the step definition using the cleaned-up description
            JSONObject stepDefMethod = findStepDefinition(stepDesc, stepDef);

            if (stepDefMethod != null) {
                // Step definition found
                String classNameInDef = stepDefMethod.getString("class");
                String methodNameInDef = "step"+stepDefMethod.getString("stepMethod");
                String instanceName = classNameInDef.substring(0, 1).toLowerCase() + classNameInDef.substring(1);

                handleClassImport(classNameInDef); // Call modified import handler
                // Handle parameters from the example for the step
                String param = example.getParameterForStep(step);

                // Generate the method call with the parameter if required
                if (param != null && !param.isEmpty()) {
                    testCase.append("        ").append(instanceName).append(".")
                            .append(methodNameInDef).append("(").append("\""+param+"\"").append(");\n");
                } else {
                    // If no parameter is needed, just call the method without parameters
                    testCase.append("        ").append(instanceName).append(".")
                            .append(methodNameInDef).append("();\n");
                }
            } else {
                // If no step definition is found, add a placeholder
                testCase.append("        // Auto-generated method: ").append(stepDesc).append("\n")
                        .append("        // Placeholder for method: ").append(generateMethodName(stepDesc)).append("();\n");
            }
        }

        // Close the test method
        testCase.append("    }\n\n");
    }

    private Set<String> importedClasses = new HashSet<>();
    private StringBuilder imports = new StringBuilder();

    private void handleClassImport(String className) {
        // Assuming the package is provided as part of the class name (e.g., "com.example.LoginPage")
        String classNameWithPackage = "stepFiles." + className; // Modify as per actual package name

        // Check if the class is already imported
        if (!importedClasses.contains(className)) {
            // Add import statement
            imports.append("import ").append(classNameWithPackage).append(";\n");

            // Track imported class
            importedClasses.add(className);

            // Add code to instantiate the class
            // This will create a line in the test case like: private ClassName className = new ClassName();
            // Note: Using className.toLowerCase() as the variable name.
            String instanceName = className.substring(0, 1).toLowerCase() + className.substring(1);
            classLevel.append("    private ").append(className).append(" ").append(instanceName).append(";").append("\n");
            setupClassName(className);
        }
    }

    private String getInstanceName(String className){
        return className.substring(0, 1).toLowerCase() + className.substring(1);
    }
    private void setupClassName(String className){
        classNames.add(className); // Add the className to the list
    }

    private ArrayList<String> getSetupClassName(){
        return classNames; // Return the list
    }

    // Removes Cucumber keywords (Given, When, Then, And)
    private String removeCucumberKeywords(String stepDesc) {
        return stepDesc.replaceAll("^(Given|When|Then|And)\\s+", "").trim();
    }

    // Removes parameters inside angle brackets, e.g., <url> becomes an empty string
    private String removeParameters(String stepDesc) {
        return stepDesc.replaceAll("<[^>]*>", "").trim();
    }

    private JSONObject findStepDefinition(String stepDesc, JSONObject stepDef) {
        for (String className : stepDef.keySet()) {
            JSONObject classDef = stepDef.getJSONObject(className);
            for (String stepMethod : classDef.keySet()) {
                JSONObject stepDetails = classDef.getJSONObject(stepMethod);
                // Match the step description with the step definition
                if (stepDetails.getString("desc").equalsIgnoreCase(stepDesc)) {
                    stepDetails.put("stepMethod", stepMethod);  // Add stepMethod to the step definition
                    stepDetails.put("class", className);  // Add class name to the step definition
                    return stepDetails;
                }
            }
        }
        return null; // No matching step found
    }

    private String generateMethodName(String stepDesc) {
        // Convert step description to camel case for method name
        String[] words = stepDesc.split(" ");
        StringBuilder methodName = new StringBuilder();
        for (String word : words) {
            methodName.append(word.substring(0, 1).toUpperCase()).append(word.substring(1).toLowerCase());
        }
        return methodName.toString();
    }

    private void writeToFile(String fileName, String content) {
        try {
            File file = new File(fileName);
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getFeatureNameFromFile(String featureFilePath) {
        String featureName = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(featureFilePath));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Feature:")) {
                    featureName = line.substring(8).trim();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return featureName;
    }

    // Placeholder classes for the feature parsing logic
    static class Scenario {
        String name;
        List<Step> steps = new ArrayList<>();

        public Scenario(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public List<Step> getSteps() {
            return steps;
        }

        public void addStep(Step step) {
            steps.add(step);
        }
    }

    static class ScenarioOutline extends Scenario {
        List<Example> examples = new ArrayList<>();

        public ScenarioOutline(String name) {
            super(name);
        }

        public List<Example> getExamples() {
            return examples;
        }

        public void setExamples(List<Example> examples) {
            this.examples = examples;
        }
    }

    static class Step {
        String description;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

    static class Example {
        Map<String, String> parameters = new HashMap<>();
        String testCaseName;
        private String parameterValue;

        public void addParameter(String name, String value) {
            parameters.put(name, value);
        }

        public String getParameter(String name) {
            return parameters.get(name);
        }

        public void setTestCaseName(String testCaseName) {
            this.testCaseName = testCaseName;
        }

        public String getTestCaseName() {
            return testCaseName;
        }

        public String getParameterForStep(Step step) {
            parameterValue =null;
            String description = step.getDescription();
            Pattern pattern = Pattern.compile("<(.*?)>");
            Matcher matcher = pattern.matcher(description);
            if (matcher.find()) {
                String key = matcher.group(1); // Extract the key, e.g., "password"
                parameterValue =  parameters.getOrDefault(key, "");
            }
            return parameterValue;
        }
    }
}
