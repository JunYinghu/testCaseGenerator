package stepFiles;

import io.cucumber.java.en.And;

import org.json.JSONObject;

import org.openqa.selenium.WebDriver;
import com.priortest.annotation.TestStepApi;
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
        try {
            coreAction.clickAction("xpath", "checkbok");
            stepSuccess = true;
        } catch (Exception e) {
            log.info("An error occurred: " + e.getMessage());
            throw e;
        } finally {
            if (!stepSuccess) {
                throw new RuntimeException("Step Failed: stepSelectTestCycleRecord");
            }
        }
    }


}

