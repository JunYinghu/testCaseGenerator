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

public class TestCyclePage {

	private static final Logger log = LogManager.getLogger(TestCyclePage.class);
	private CoreActions coreAction;

	public TestCyclePage(WebDriver driver) {
		this.coreAction = new CoreActions(driver);
	}

	@TestStepApi(stepDesc = "this is select" ,issueId=" ")
	@And("this is select")
	public void stepSelectTestCycleRecord() {
		boolean stepSuccess = false;
		String errorMessage = null;
		try {
			 coreAction.clickAction("xpath", "checkbok");
			 stepSuccess = true;
			} catch (Exception e) {
			 errorMessage =e.getMessage();
			throw new RuntimeException(e.getMessage());
		} finally {
			StepResultTracker.addStepResult("this is select", stepSuccess, errorMessage);
			}
		}


}

