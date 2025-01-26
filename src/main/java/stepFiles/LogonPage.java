package stepFiles;

import io.cucumber.java.en.And;

import org.json.JSONObject;

import org.openqa.selenium.WebDriver;
import com.priortest.annotation.TestStepApi;
import org.testng.Assert;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogonPage {

	private static final Logger log = LogManager.getLogger(LogonPage.class);
	private CoreActions coreAction;

	public LogonPage(WebDriver driver) {
		this.coreAction = new CoreActions(driver);
	}

    @TestStepApi(stepDesc = "clear the password in the login form" ,issueId=" ")
    @And("clear the password in the login form")
    public void stepClearPassword() {
        boolean stepSuccess = false;
        try {
            coreAction.clear("xpath", "/html/body/div[1]/div/form/div[3]/div/div/input");
            stepSuccess = true;
        } catch (Exception e) {
            log.info("An error occurred: " + e.getMessage());
            throw e;
        } finally {
            if (!stepSuccess) {
                throw new RuntimeException("Step Failed: stepClearPassword");
            }
        }
    }


    @TestStepApi(stepDesc = "Enter the username in the login form" ,issueId=" ")
    @And("Enter the username in the login form")
    public void stepEnterUserName(String param) {
        boolean stepSuccess = false;
        try {
            coreAction.enterText("xpath", "/html/body/div[1]/div/form/div[2]/div/div/input", param);
            stepSuccess = true;
        } catch (Exception e) {
            log.info("An error occurred: " + e.getMessage());
            throw e;
        } finally {
            if (!stepSuccess) {
                throw new RuntimeException("Step Failed: stepEnterUserName with parameter: " + param);
            }
        }
    }


    @TestStepApi(stepDesc = "验证 web page title" ,issueId=" ")
    @And("验证 web page title")
    public void stepVerifyPageTitle(String param) {
        boolean stepSuccess = false;
        try {
            boolean result = coreAction.getVerifyPageTitle(param);
            Assert.assertTrue(result, "Verification failed for VerifyPageTitle");
            stepSuccess = true;
        } catch (Exception e) {
            log.info("An error occurred: " + e.getMessage());
            throw e;
        } finally {
            if (!stepSuccess) {
                throw new RuntimeException("Step Failed: stepVerifyPageTitle with parameter: " + param);
            }
        }
    }


    @TestStepApi(stepDesc = "Verify the email incorrect message on the page" ,issueId=" ")
    @And("Verify the email incorrect message on the page")
    public void stepVerifyIncorrectEmailPresent(String param) {
        boolean stepSuccess = false;
        try {
            boolean result = coreAction.getVerifyTextPresent("xpath", "/html/body/div[1]/div/form/div[2]/div/div[2]",param);
            Assert.assertTrue(result, "Verification failed for VerifyIncorrectEmailPresent");
            stepSuccess = true;
        } catch (Exception e) {
            log.info("An error occurred: " + e.getMessage());
            throw e;
        } finally {
            if (!stepSuccess) {
                throw new RuntimeException("Step Failed: stepVerifyIncorrectEmailPresent with parameter: " + param);
            }
        }
    }


    @TestStepApi(stepDesc = "Verify the login fails message on the page" ,issueId=" ")
    @And("Verify the login fails message on the page")
    public void stepVerifyFailLoginPresent(String param) {
        boolean stepSuccess = false;
        try {
            boolean result = coreAction.getVerifyTextPresent("xpath", "/html/body/div[2]/p",param);
            Assert.assertTrue(result, "Verification failed for VerifyFailLoginPresent");
            stepSuccess = true;
        } catch (Exception e) {
            log.info("An error occurred: " + e.getMessage());
            throw e;
        } finally {
            if (!stepSuccess) {
                throw new RuntimeException("Step Failed: stepVerifyFailLoginPresent with parameter: " + param);
            }
        }
    }


    @TestStepApi(stepDesc = "Click the login button on the login form" ,issueId=" ")
    @And("Click the login button on the login form")
    public void stepClickLoginButton() {
        boolean stepSuccess = false;
        try {
            coreAction.clickAction("xpath", "/html/body/div[1]/div/form/div[5]/button[1]");
            stepSuccess = true;
        } catch (Exception e) {
            log.info("An error occurred: " + e.getMessage());
            throw e;
        } finally {
            if (!stepSuccess) {
                throw new RuntimeException("Step Failed: stepClickLoginButton");
            }
        }
    }


    @TestStepApi(stepDesc = "Click 注册按钮 from login form" ,issueId=" ")
    @And("Click 注册按钮 from login form")
    public void stepClickZhuCe() {
        boolean stepSuccess = false;
        try {
            coreAction.clickAction("xpath", "/html/body/div/div/form/div[5]/button[2]/span");
            stepSuccess = true;
        } catch (Exception e) {
            log.info("An error occurred: " + e.getMessage());
            throw e;
        } finally {
            if (!stepSuccess) {
                throw new RuntimeException("Step Failed: stepClickZhuCe");
            }
        }
    }

    @TestStepApi(stepDesc = "clear the username in the login form" ,issueId=" ")
    @And("clear the username in the login form")
    public void stepClearUserName() {
        boolean stepSuccess = false;
        try {
            coreAction.clear("xpath", "/html/body/div[1]/div/form/div[2]/div/div/input");
            stepSuccess = true;
        } catch (Exception e) {
            log.info("An error occurred: " + e.getMessage());
            throw e;
        } finally {
            if (!stepSuccess) {
                throw new RuntimeException("Step Failed: stepClearUserName");
            }
        }
    }

    @TestStepApi(stepDesc = "Open Web Page as given URL" ,issueId=" ")
    @And("Open Web Page as given URL")
    public void stepOpenLogonPage(String param) {
        boolean stepSuccess = false;
        try {
            coreAction.openWebPage(param);
            stepSuccess = true;
        } catch (Exception e) {
            log.info("An error occurred: " + e.getMessage());
            throw e;
        } finally {
            if (!stepSuccess) {
                throw new RuntimeException("Step Failed: stepOpenLogonPage with parameter: " + param);
            }
        }
    }


    @TestStepApi(stepDesc = "Enter the password in the login form" ,issueId=" ")
    @And("Enter the password in the login form")
    public void stepEnterPassword(String param) {
        boolean stepSuccess = false;
        try {
            coreAction.enterText("xpath", "/html/body/div[1]/div/form/div[3]/div/div/input", param);
            stepSuccess = true;
        } catch (Exception e) {
            log.info("An error occurred: " + e.getMessage());
            throw e;
        } finally {
            if (!stepSuccess) {
                throw new RuntimeException("Step Failed: stepEnterPassword with parameter: " + param);
            }
        }
    }


}

