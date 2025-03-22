package CallGenerateAPI;

import com.priortest.generator.generatorAPI.StepGenerator;

public class stepGenerate {

    public static void main(String[] args)
    {
        String currentWorkingDirectory = System.getProperty("user.dir");

        String stepDefinition = currentWorkingDirectory+"/src/main/resources/step-definitions.json";
        String outputStep = currentWorkingDirectory+"/src/test/java/stepFiles/";
        StepGenerator.stepGenerateAPI(stepDefinition,outputStep);

    }
}
