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

public class WelcomePage {

	private static final Logger log = LogManager.getLogger(WelcomePage.class);
	private CoreActions coreAction;

	public WelcomePage(WebDriver driver) {
		this.coreAction = new CoreActions(driver);
	}

	@TestStepApi(stepDesc = "Verify the welcome message on the page" ,issueId=" ")
	@And("Verify the welcome message on the page")
	public void stepVerifyTextPresent(String param) {
		boolean stepSuccess = false;
		String errorMessage = null;
		try {
			boolean result = coreAction.getVerifyTextPresent("xpath", "/html/body/div/div/div/div[1]/div/div[2]/ul/li[1]",param);
				Assert.assertTrue(result, "Verification failed for VerifyTextPresent");
			 stepSuccess = true;
			} catch (Exception e) {
			 errorMessage =e.getMessage();
			throw new RuntimeException(e.getMessage());
		} finally {
			StepResultTracker.addStepResult("Verify the welcome message on the page", stepSuccess, errorMessage);
			}
		}


	@TestStepApi(stepDesc = "Logout user from the page" ,issueId=" ")
	@And("Logout user from the page")
	public void stepLogout() {
		boolean stepSuccess = false;
		String errorMessage = null;
		try {
			 coreAction.clickAction("cssSelector", ".logout-btn");
			 stepSuccess = true;
			} catch (Exception e) {
			 errorMessage =e.getMessage();
			throw new RuntimeException(e.getMessage());
		} finally {
			StepResultTracker.addStepResult("Logout user from the page", stepSuccess, errorMessage);
			}
		}


	@TestStepApi(stepDesc = "Close current web page" ,issueId=" ")
	@And("Close current web page")
	public void stepClose() {
		boolean stepSuccess = false;
		String errorMessage = null;
		try {
				coreAction.driverClose();
			 stepSuccess = true;
			} catch (Exception e) {
			 errorMessage =e.getMessage();
			throw new RuntimeException(e.getMessage());
		} finally {
			StepResultTracker.addStepResult("Close current web page", stepSuccess, errorMessage);
			}
		}


	@TestStepApi(stepDesc = "Move to User Profile" ,issueId=" ")
	@And("Move to User Profile")
	public void stepMoveToUserProfile() {
		boolean stepSuccess = false;
		String errorMessage = null;
		try {
			 coreAction.handOver("xpath", "/html/body/div/div/div/div[1]/div/div[3]/div[2]/div/span/i");
			 stepSuccess = true;
			} catch (Exception e) {
			 errorMessage =e.getMessage();
			throw new RuntimeException(e.getMessage());
		} finally {
			StepResultTracker.addStepResult("Move to User Profile", stepSuccess, errorMessage);
			}
		}


}

