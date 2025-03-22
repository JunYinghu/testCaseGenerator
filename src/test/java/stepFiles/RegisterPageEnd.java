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

public class RegisterPageEnd {

	private static final Logger log = LogManager.getLogger(RegisterPageEnd.class);
	private CoreActions coreAction;

	public RegisterPageEnd(WebDriver driver) {
		this.coreAction = new CoreActions(driver);
	}

	@TestStepApi(stepDesc = "打开注册邮箱" ,issueId=" ")
	@And("打开注册邮箱")
	public void stepGoToEmail() {
		boolean stepSuccess = false;
		String errorMessage = null;
		try {
			 coreAction.clickAction("xpath", "/html/body/div/div/div/form/div[2]/span");
			 stepSuccess = true;
			} catch (Exception e) {
			 errorMessage =e.getMessage();
			throw new RuntimeException(e.getMessage());
		} finally {
			StepResultTracker.addStepResult("打开注册邮箱", stepSuccess, errorMessage);
			}
		}


	@TestStepApi(stepDesc = "点击返回登录 from register end" ,issueId=" ")
	@And("点击返回登录 from register end")
	public void stepGoBackLogon() {
		boolean stepSuccess = false;
		String errorMessage = null;
		try {
			 coreAction.clickAction("xpath", "/html/body/div/div/div/form/a/span");
			 stepSuccess = true;
			} catch (Exception e) {
			 errorMessage =e.getMessage();
			throw new RuntimeException(e.getMessage());
		} finally {
			StepResultTracker.addStepResult("点击返回登录 from register end", stepSuccess, errorMessage);
			}
		}


}

