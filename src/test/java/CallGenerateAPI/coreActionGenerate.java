package CallGenerateAPI;

import com.priortest.generator.generatorAPI.CoreActionGenerator;

public class coreActionGenerate {

    public static void main(String[] args)
    {

        String currentWorkingDirectory = System.getProperty("user.dir");
        String INPUT_FILE_PATH = currentWorkingDirectory + "/src/main/java/com/priortest/generator/resource/coreActions.json";
        String OUTPUT_DIR_PATH = currentWorkingDirectory + "/src/main/java/com/priortest/generator/coreAction/CoreActions.java";
        CoreActionGenerator.coreActionGeneratorAPI(INPUT_FILE_PATH,OUTPUT_DIR_PATH);

    }
}
