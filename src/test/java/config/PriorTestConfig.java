package config;

import com.priortest.config.PTConstant;

public class PriorTestConfig {
    public static void setPriorTestApi() {
        PTConstant.setPTBasedURI("http://43.139.159.146:8082/api/apiAdpater/");
    }

    public static void setPriorTestToken() {
        PTConstant.setPTToken("vnM8WrMbHqb6QdUR7H5cPQeVOd0KoGjZHadBqlWA71fv4p0Kkh");
    }

    public static void setPriorTestProjectId() {
        PTConstant.setPTProjectId("885958494765715456");
    }

    public static void setPriorTestEmail() {
        PTConstant.setPTEmail("qatest.hu.mary3@gmail.com");
    }

    public static void setPriorTestSignOff(boolean signOff) {
        PTConstant.setPTSignOff(signOff);
    }

    public static void setIssueCreation(boolean issueCreation) {
        PTConstant.setPTIssueCreation(issueCreation);
    }

    public static void setEnv(String env) {
        PTConstant.setPTEnv(env);
    }
    public static void setPlatform(String platform) {
        PTConstant.setPTPlatform(platform);
    }

    public static void setVersion(String version) {
        PTConstant.setPTVersion(version);
    }
}
