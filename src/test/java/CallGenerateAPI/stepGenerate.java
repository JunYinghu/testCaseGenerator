package CallGenerateAPI;

import generator.StepGenerator;
import generator.TestCaseGenerator;

public class stepGenerate {

    public static void main(String[] args)
    {
        String currentWorkingDirectory = System.getProperty("user.dir");

        String stepDefinition = currentWorkingDirectory+"/src/main/resources/step-definitions_project.json";
        String outputStep = currentWorkingDirectory+"/src/test/java/stepFiles/";
        StepGenerator.stepGenerateAPI(stepDefinition,outputStep);

    }
}
