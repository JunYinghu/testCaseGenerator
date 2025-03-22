package stepFiles;

import com.priortest.step.StepResultTracker;

import io.cucumber.java.en.And;

import org.json.JSONObject;

import org.openqa.selenium.WebDriver;
import com.priortest.annotation.TestStepApi;
import com.priortest.generator.coreAction.CoreActions;

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
		String errorMessage = null;
		try {
			 coreAction.clear("xpath", "/html/body/div[1]/div/form/div[3]/div/div/input");
			 stepSuccess = true;
			} catch (Exception e) {
			 errorMessage =e.getMessage();
			throw new RuntimeException(e.getMessage());
		} finally {
			StepResultTracker.addStepResult("clear the password in the login form", stepSuccess, errorMessage);
			}
		}


	@TestStepApi(stepDesc = "Enter the username in the login form" ,issueId=" ")
	@And("Enter the username in the login form")
	public void stepEnterUserName(String param) {
		boolean stepSuccess = false;
		String errorMessage = null;
		try {
			 coreAction.enterText("xpath", "/html/body/div[1]/div/form/div[2]/div/div/input", param);
			 stepSuccess = true;
			} catch (Exception e) {
			 errorMessage =e.getMessage();
			throw new RuntimeException(e.getMessage());
		} finally {
			StepResultTracker.addStepResult("Enter the username in the login form", stepSuccess, errorMessage);
			}
		}


	@TestStepApi(stepDesc = "验证 web page title" ,issueId=" ")
	@And("验证 web page title")
	public void stepVerifyPageTitle(String param) {
		boolean stepSuccess = false;
		String errorMessage = null;
		try {
			 boolean result = coreAction.getVerifyPageTitle(param);
				Assert.assertTrue(result, "Verification failed for VerifyPageTitle");
			 stepSuccess = true;
			} catch (Exception e) {
			 errorMessage =e.getMessage();
			throw new RuntimeException(e.getMessage());
		} finally {
			StepResultTracker.addStepResult("验证 web page title", stepSuccess, errorMessage);
			}
		}


	@TestStepApi(stepDesc = "Verify the email incorrect message on the page" ,issueId=" ")
	@And("Verify the email incorrect message on the page")
	public void stepVerifyIncorrectEmailPresent(String param) {
		boolean stepSuccess = false;
		String errorMessage = null;
		try {
			boolean result = coreAction.getVerifyTextPresent("xpath", "/html/body/div[1]/div/form/div[2]/div/div[2]",param);
				Assert.assertTrue(result, "Verification failed for VerifyIncorrectEmailPresent");
			 stepSuccess = true;
			} catch (Exception e) {
			 errorMessage =e.getMessage();
			throw new RuntimeException(e.getMessage());
		} finally {
			StepResultTracker.addStepResult("Verify the email incorrect message on the page", stepSuccess, errorMessage);
			}
		}


	@TestStepApi(stepDesc = "Verify the login fails message on the page" ,issueId=" ")
	@And("Verify the login fails message on the page")
	public void stepVerifyFailLoginPresent(String param) {
		boolean stepSuccess = false;
		String errorMessage = null;
		try {
			boolean result = coreAction.getVerifyTextPresent("xpath", "/html/body/div[2]/p",param);
				Assert.assertTrue(result, "Verification failed for VerifyFailLoginPresent");
			 stepSuccess = true;
			} catch (Exception e) {
			 errorMessage =e.getMessage();
			throw new RuntimeException(e.getMessage());
		} finally {
			StepResultTracker.addStepResult("Verify the login fails message on the page", stepSuccess, errorMessage);
			}
		}


	@TestStepApi(stepDesc = "Click the login button on the login form" ,issueId=" ")
	@And("Click the login button on the login form")
	public void stepClickLoginButton() {
		boolean stepSuccess = false;
		String errorMessage = null;
		try {
			 coreAction.clickAction("xpath", "/html/body/div[1]/div/form/div[5]/button[1]");
			 stepSuccess = true;
			} catch (Exception e) {
			 errorMessage =e.getMessage();
			throw new RuntimeException(e.getMessage());
		} finally {
			StepResultTracker.addStepResult("Click the login button on the login form", stepSuccess, errorMessage);
			}
		}


	@TestStepApi(stepDesc = "Click 注册按钮 from login form" ,issueId=" ")
	@And("Click 注册按钮 from login form")
	public void stepClickZhuCe() {
		boolean stepSuccess = false;
		String errorMessage = null;
		try {
			 coreAction.clickAction("xpath", "/html/body/div/div/form/div[5]/button[2]/span");
			 stepSuccess = true;
			} catch (Exception e) {
			 errorMessage =e.getMessage();
			throw new RuntimeException(e.getMessage());
		} finally {
			StepResultTracker.addStepResult("Click 注册按钮 from login form", stepSuccess, errorMessage);
			}
		}


	@TestStepApi(stepDesc = "clear the username in the login form" ,issueId=" ")
	@And("clear the username in the login form")
	public void stepClearUserName() {
		boolean stepSuccess = false;
		String errorMessage = null;
		try {
			 coreAction.clear("xpath", "/html/body/div[1]/div/form/div[2]/div/div/input");
			 stepSuccess = true;
			} catch (Exception e) {
			 errorMessage =e.getMessage();
			throw new RuntimeException(e.getMessage());
		} finally {
			StepResultTracker.addStepResult("clear the username in the login form", stepSuccess, errorMessage);
			}
		}


	@TestStepApi(stepDesc = "Open Web Page as given URL" ,issueId=" ")
	@And("Open Web Page as given URL")
	public void stepOpenLogonPage(String param) {
		boolean stepSuccess = false;
		String errorMessage = null;
		try {
				coreAction.openWebPage(param);
			 stepSuccess = true;
			} catch (Exception e) {
			 errorMessage =e.getMessage();
			throw new RuntimeException(e.getMessage());
		} finally {
			StepResultTracker.addStepResult("Open Web Page as given URL", stepSuccess, errorMessage);
			}
		}


	@TestStepApi(stepDesc = "Enter the password in the login form" ,issueId=" ")
	@And("Enter the password in the login form")
	public void stepEnterPassword(String param) {
		boolean stepSuccess = false;
		String errorMessage = null;
		try {
			 coreAction.enterText("xpath", "/html/body/div[1]/div/form/div[3]/div/div/input", param);
			 stepSuccess = true;
			} catch (Exception e) {
			 errorMessage =e.getMessage();
			throw new RuntimeException(e.getMessage());
		} finally {
			StepResultTracker.addStepResult("Enter the password in the login form", stepSuccess, errorMessage);
			}
		}


}

