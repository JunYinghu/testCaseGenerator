package CallGenerateAPI;

import generator.TestCaseGenerator;

public class caseGenerate {


    public static void main(String[] args)
    {
        String currentWorkingDirectory = System.getProperty("user.dir");
        String[] stepDefinitionJsonPath = new String[]{currentWorkingDirectory+"/src/main/resources/step-definitions.json",currentWorkingDirectory+"/src/main/resources/step-definitions_project.json"};
        String featureFilePath = currentWorkingDirectory+"/src/test/resources/testCaseFeature/project.feature";
        //String featureFilePath = "/src/test/resources/testCaseFeature/testCase.feature";
        //String featureFilePath = "D:/testCaseGenerator/testCaseGenerator/src/test/resources/testCaseFeature/registerTest.feature";
        String outputFilePath = currentWorkingDirectory+"/src/test/java/testCases/";
        TestCaseGenerator.generateAPI(stepDefinitionJsonPath,featureFilePath,outputFilePath);

    }

}
