package config;

import com.priortest.config.PTApiConfig;
import com.priortest.config.PTConstant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

public class BasicSetup {
    private static final Logger log = LogManager.getLogger(BasicSetup.class);

    /**
     * basicSetup: parameters read from testng.xml which is can be set/read from jenkins pipeline
     * <p>
     * enablePriorTestApi : true - trigger PriorTest Automation API - false - does not trigger PriorTest Automation API
     * setTestCycleTitle : string - to create test cycle
     * if test cycle title exist in PriorTest system , will not re-create
     * if test cycle title does not exist in PriorTest system, will create
     * - if test cycle is null , will proceed with a default test cycle <version_platform_env>
     * - if test cycle title is not null, will proceed with the test cycle title
     * browser - UI test browser driver type: CHROME,FIREFOX,SAFARI,EDGE
     * <p>
     * setPriorTestRelease : 1: set current run is released version
     * setPriorTestCurrentRelease: 1: set current run is current released version
     * <p>
     * Running Config
     * setPriorTestApi -- string:  PriorTest Automation Base API
     * setPriorTestProjectId -- string: PriorTest Automation Project Id
     * setPriorTestToken -- string: Request API token accessing PriorTest Automation
     * setPriorTestEmail -- string: Request API email accessing PriorTest Automation
     * setPriorTestSignOff -- true : Generate sign off report, otherwise no - does not implement
     * <p>
     * setIssueCreation - true: trigger to create an issue if Test Cases is fail, otherwise no
     * setEnv - string: testObject Env
     * setVersion - string: testObject Version
     * setPlatform - string: Platform Current Test Cases running on, if not provide,  PriorTest Automation detects the platform test cases running on
     * setIssueIdentifier - make issue title as unicode as per
     **/

    public Properties readProps() {
        Properties props = new Properties();
        FileInputStream input;
        {
            try {
                input = new FileInputStream("src/test/resources/test_parameters.properties");
                props.load(input);
                input.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return props;
    }

    @BeforeSuite
    public void propertiesSetup() {
        // 加载 test_parameters.properties 文件
        Properties props = readProps();
        // 获取参数值
        String Env = props.getProperty("Env");
        String testCycle = props.getProperty("testCycle");
        String version = props.getProperty("version");
        String browser = props.getProperty("browser");
        boolean released = Boolean.parseBoolean(props.getProperty("released"));
        boolean currentRelease = Boolean.parseBoolean(props.getProperty("currentRelease"));
        boolean enablePTApi = Boolean.parseBoolean(props.getProperty("enablePTApi"));
        boolean signOff = Boolean.parseBoolean(props.getProperty("signOff"));
        String testSuiteName = props.getProperty("testSuiteName");
        String runMode = props.getProperty("runMode");
        int releasedFlag = released ? 1 : 0;
        int currentReleaseFlag = currentRelease ? 1 : 0;

        // 打印参数值
        log.info("Env: " + Env);
        System.out.println("Test Cycle: " + testCycle);
        System.out.println("Version: " + version);
        System.out.println("Browser: " + browser);
        System.out.println("Released: " + released);
        System.out.println("Current Release: " + currentRelease);
        System.out.println("Enable PT API: " + enablePTApi);
        System.out.println("Sign Off: " + signOff);
        System.out.println("Test Suite Name: " + testSuiteName);
        System.out.println("Run Mode: " + runMode);

        PTApiConfig.setConnectPTAPI(enablePTApi);
        PTApiConfig.setTestCycleTitle(testCycle);
        PTApiConfig.setPriorTestRelease(releasedFlag);
        PTApiConfig.setPriorTestCurrentRelease(currentReleaseFlag);
        PTApiConfig.setBrowser(browser);

        PriorTestConfig.setPriorTestApi();
        PriorTestConfig.setPriorTestProjectId();
        PriorTestConfig.setPriorTestToken();
        PriorTestConfig.setPriorTestEmail();
        PriorTestConfig.setIssueCreation(true);

        PriorTestConfig.setEnv(Env);
        PriorTestConfig.setPlatform(System.getProperty("os.name"));
        PriorTestConfig.setVersion(version);

        PriorTestConfig.setPriorTestSignOff(signOff);

        PTApiConfig.setIssueIdentifier(generateDeviceInfo());
        log.info("+++ End Setup CICD ++++ ");

    }

    @Parameters({"enablePTApi", "signOff", "browser", "testCycle", "Env", "version", "released", "currentRelease"})
    public void basicSetup(
            @Optional("true") boolean enablePTApi,
            @Optional("true") boolean signOff,
            @Optional("FIREFOX") String browser,
            @Optional("调试 Automation Test") String testCycle,
            @Optional("开发") String Env,
            @Optional("1.0.0.0") String version,
            @Optional("1") int released,
            @Optional("1") int currentRelease) {
        log.info("+++++ Setup CICD setting :" + enablePTApi + "  " + testCycle + " " + version + "  " + Env + " " + browser);

        PTApiConfig.setConnectPTAPI(enablePTApi);
        PTApiConfig.setTestCycleTitle(testCycle);
        PTApiConfig.setPriorTestRelease(released);
        PTApiConfig.setPriorTestCurrentRelease(currentRelease);
        PTApiConfig.setBrowser(browser);

        PriorTestConfig.setPriorTestApi();
        PriorTestConfig.setPriorTestProjectId();
        PriorTestConfig.setPriorTestToken();
        PriorTestConfig.setPriorTestEmail();
        PriorTestConfig.setIssueCreation(true);

        PriorTestConfig.setEnv(Env);
        PriorTestConfig.setPlatform(System.getProperty("os.name"));
        PriorTestConfig.setVersion(version);

        PriorTestConfig.setPriorTestSignOff(signOff);

        PTApiConfig.setIssueIdentifier(generateDeviceInfo());
        log.info("+++ End Setup CICD ++++ ");
    }

    private String generateDeviceInfo() {
        // Example implementation: retrieve device or OS from test result attributes or system properties
        String osName = System.getProperty("os.name");
        String osVersion = System.getProperty("os.version");
        String osArch = System.getProperty("os.arch");
        String version = PTConstant.getPTVersion();
        String issueIdentifier = version + "_" + (osName != null ? osName : "UnknownDevice") + "_" + (osVersion != null ? osVersion : "UnknownOSVersion") + "_" + (osArch != null ? osArch : "UnKnowsOSarch");
        return issueIdentifier;
    }

    @AfterMethod
    public void afterTest(Method method) {
        log.info("End TC " + getClass().getSimpleName() + "." + method.getName());
    }

    @BeforeMethod
    public void beforeTest(Method method) {
        log.info("Start TC " + getClass().getSimpleName() + "." + method.getName());

    }
}
