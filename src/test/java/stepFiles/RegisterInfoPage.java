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

public class RegisterInfoPage {

	private static final Logger log = LogManager.getLogger(RegisterInfoPage.class);
	private CoreActions coreAction;

	public RegisterInfoPage(WebDriver driver) {
		this.coreAction = new CoreActions(driver);
	}

	@TestStepApi(stepDesc = "Verify  电话号码 长度" ,issueId=" ")
	@And("Verify  电话号码 长度")
	public void stepVerifyPhoneNoLength(String param) {
		boolean stepSuccess = false;
		String errorMessage = null;
		try {
			boolean result = coreAction.getVerifyTextPresent("xpath", "/html/body/div/div/div/form/div[2]/div[2]/div/div/div[2]",param);
				Assert.assertTrue(result, "Verification failed for VerifyPhoneNoLength");
			 stepSuccess = true;
			} catch (Exception e) {
			 errorMessage =e.getMessage();
			throw new RuntimeException(e.getMessage());
		} finally {
			StepResultTracker.addStepResult("Verify  电话号码 长度", stepSuccess, errorMessage);
			}
		}


	@TestStepApi(stepDesc = "输入用户名称" ,issueId=" ")
	@And("输入用户名称")
	public void stepEnterUserName(String param) {
		boolean stepSuccess = false;
		String errorMessage = null;
		try {
			 coreAction.enterText("xpath", "/html/body/div/div/div/form/div[2]/div[3]/div/div/div/input", param);
			 stepSuccess = true;
			} catch (Exception e) {
			 errorMessage =e.getMessage();
			throw new RuntimeException(e.getMessage());
		} finally {
			StepResultTracker.addStepResult("输入用户名称", stepSuccess, errorMessage);
			}
		}


	@TestStepApi(stepDesc = "输入注册用户信息", issueId=" ")
	@And("输入注册用户信息")
	public void stepGroupEnterRegisterInfo(JSONObject inputData) {
		boolean stepSuccess = false;
		String errorMessage = null;
		try {
			if (inputData.has("emailId") && inputData.get("emailId") != null) {
				log.info(" Performing Step :  EnterEmailId(emailId)");
				stepEnterEmailId((String)inputData.get("emailId"));
			}
			if (inputData.has("phoneNo") && inputData.get("phoneNo") != null) {
				log.info(" Performing Step :  EnterPhoneNo(phoneNo)");
				stepEnterPhoneNo((String)inputData.get("phoneNo"));
			}
			if (inputData.has("userName") && inputData.get("userName") != null) {
				log.info(" Performing Step :  EnterUserName(userName)");
				stepEnterUserName((String)inputData.get("userName"));
			}
			if (inputData.has("companyName") && inputData.get("companyName") != null) {
				log.info(" Performing Step :  EnterCompanyName(companyName)");
				stepEnterCompanyName((String)inputData.get("companyName"));
			}
			if (inputData.has("industry") && inputData.get("industry") != null) {
				log.info(" Performing Step :  EnterIndustry(industry)");
				stepEnterIndustry((String)inputData.get("industry"));
			}
			if (inputData.has("occupation") && inputData.get("occupation") != null) {
				log.info(" Performing Step :  EnterOccupation(occupation)");
				stepEnterOccupation((String)inputData.get("occupation"));
			}
			stepSuccess = true;
		}
		catch (Exception e) {
			log.info("An error occurred: " + e.getMessage());
			throw e;
		} finally {
			StepResultTracker.addStepResult("输入注册用户信息", stepSuccess, errorMessage);
		}
	}


	@TestStepApi(stepDesc = "Move to Page Bottom" ,issueId=" ")
	@And("Move to Page Bottom")
	public void stepScrollBottom() {
		boolean stepSuccess = false;
		String errorMessage = null;
		try {
				coreAction.scrollToBottom();
			 stepSuccess = true;
			} catch (Exception e) {
			 errorMessage =e.getMessage();
			throw new RuntimeException(e.getMessage());
		} finally {
			StepResultTracker.addStepResult("Move to Page Bottom", stepSuccess, errorMessage);
			}
		}


	@TestStepApi(stepDesc = "Verify  用户名 长度" ,issueId=" ")
	@And("Verify  用户名 长度")
	public void stepVerifyUserNameLength(String param) {
		boolean stepSuccess = false;
		String errorMessage = null;
		try {
			boolean result = coreAction.getVerifyTextPresent("xpath", "/html/body/div/div/div/form/div[2]/div[3]/div/div/div[2]",param);
				Assert.assertTrue(result, "Verification failed for VerifyUserNameLength");
			 stepSuccess = true;
			} catch (Exception e) {
			 errorMessage =e.getMessage();
			throw new RuntimeException(e.getMessage());
		} finally {
			StepResultTracker.addStepResult("Verify  用户名 长度", stepSuccess, errorMessage);
			}
		}


	@TestStepApi(stepDesc = "打开服务条款" ,issueId=" ")
	@And("打开服务条款")
	public void stepOpenTerms() {
		boolean stepSuccess = false;
		String errorMessage = null;
		try {
			 coreAction.clickAction("xpath", "/html/body/div/div/div/form/div[3]/div/a/span");
			 stepSuccess = true;
			} catch (Exception e) {
			 errorMessage =e.getMessage();
			throw new RuntimeException(e.getMessage());
		} finally {
			StepResultTracker.addStepResult("打开服务条款", stepSuccess, errorMessage);
			}
		}


	@TestStepApi(stepDesc = "点击返回登录 from register page" ,issueId=" ")
	@And("点击返回登录 from register page")
	public void stepGoBackLogon() {
		boolean stepSuccess = false;
		String errorMessage = null;
		try {
			 coreAction.clickAction("xpath", "/html/body/div/div/div/form/div[3]/a/span");
			 stepSuccess = true;
			} catch (Exception e) {
			 errorMessage =e.getMessage();
			throw new RuntimeException(e.getMessage());
		} finally {
			StepResultTracker.addStepResult("点击返回登录 from register page", stepSuccess, errorMessage);
			}
		}


	@TestStepApi(stepDesc = "Switch to main window" ,issueId=" ")
	@And("Switch to main window")
	public void stepSwitchToMainWindow() {
		boolean stepSuccess = false;
		String errorMessage = null;
		try {
				coreAction.switchToMainWin();
			 stepSuccess = true;
			} catch (Exception e) {
			 errorMessage =e.getMessage();
			throw new RuntimeException(e.getMessage());
		} finally {
			StepResultTracker.addStepResult("Switch to main window", stepSuccess, errorMessage);
			}
		}


	@TestStepApi(stepDesc = "输入公司名称" ,issueId=" ")
	@And("输入公司名称")
	public void stepEnterCompanyName(String param) {
		boolean stepSuccess = false;
		String errorMessage = null;
		try {
			 coreAction.enterText("xpath", "/html/body/div/div/div/form/div[2]/div[4]/div/div/div/input", param);
			 stepSuccess = true;
			} catch (Exception e) {
			 errorMessage =e.getMessage();
			throw new RuntimeException(e.getMessage());
		} finally {
			StepResultTracker.addStepResult("输入公司名称", stepSuccess, errorMessage);
			}
		}


	@TestStepApi(stepDesc = "Verify 注册成功信息" ,issueId=" ")
	@And("Verify 注册成功信息")
	public void stepVerifyRegisterSucess(String param) {
		boolean stepSuccess = false;
		String errorMessage = null;
		try {
			boolean result = coreAction.getVerifyTextPresent("xpath", "/html/body/div/div/div/form/div[2]",param);
				Assert.assertTrue(result, "Verification failed for VerifyRegisterSucess");
			 stepSuccess = true;
			} catch (Exception e) {
			 errorMessage =e.getMessage();
			throw new RuntimeException(e.getMessage());
		} finally {
			StepResultTracker.addStepResult("Verify 注册成功信息", stepSuccess, errorMessage);
			}
		}


	@TestStepApi(stepDesc = "Move to Page Top" ,issueId=" ")
	@And("Move to Page Top")
	public void stepScrollTop() {
		boolean stepSuccess = false;
		String errorMessage = null;
		try {
				coreAction.scrollToTop();
			 stepSuccess = true;
			} catch (Exception e) {
			 errorMessage =e.getMessage();
			throw new RuntimeException(e.getMessage());
		} finally {
			StepResultTracker.addStepResult("Move to Page Top", stepSuccess, errorMessage);
			}
		}


	@TestStepApi(stepDesc = "Verify  邮箱 长度" ,issueId=" ")
	@And("Verify  邮箱 长度")
	public void stepVerifyEmailIdLength(String param) {
		boolean stepSuccess = false;
		String errorMessage = null;
		try {
			boolean result = coreAction.getVerifyTextPresent("xpath", "/html/body/div/div/div/form/div[2]/div[1]/div/div/div[2]",param);
				Assert.assertTrue(result, "Verification failed for VerifyEmailIdLength");
			 stepSuccess = true;
			} catch (Exception e) {
			 errorMessage =e.getMessage();
			throw new RuntimeException(e.getMessage());
		} finally {
			StepResultTracker.addStepResult("Verify  邮箱 长度", stepSuccess, errorMessage);
			}
		}


	@TestStepApi(stepDesc = "Click 同意并继续按钮" ,issueId=" ")
	@And("Click 同意并继续按钮")
	public void stepClickAgree() {
		boolean stepSuccess = false;
		String errorMessage = null;
		try {
			 coreAction.clickAction("xpath", "/html/body/div[1]/div/div[2]/div/div[2]/span/button/span");
			 stepSuccess = true;
			} catch (Exception e) {
			 errorMessage =e.getMessage();
			throw new RuntimeException(e.getMessage());
		} finally {
			StepResultTracker.addStepResult("Click 同意并继续按钮", stepSuccess, errorMessage);
			}
		}


	@TestStepApi(stepDesc = "验证注册邮箱" ,issueId=" ")
	@And("验证注册邮箱")
	public void stepVerifyInvalidEmail(String param) {
		boolean stepSuccess = false;
		String errorMessage = null;
		try {
			boolean result = coreAction.getVerifyTextPresent("xpath", "/html/body/div/div/div/form/div[2]/div[1]/div/div/div[2]",param);
				Assert.assertTrue(result, "Verification failed for VerifyInvalidEmail");
			 stepSuccess = true;
			} catch (Exception e) {
			 errorMessage =e.getMessage();
			throw new RuntimeException(e.getMessage());
		} finally {
			StepResultTracker.addStepResult("验证注册邮箱", stepSuccess, errorMessage);
			}
		}


	@TestStepApi(stepDesc = "输入职业" ,issueId=" ")
	@And("输入职业")
	public void stepEnterOccupation(String param) {
		boolean stepSuccess = false;
		String errorMessage = null;
		try {
			 coreAction.enterText("xpath", "/html/body/div/div/div/form/div[2]/div[6]/div/div/div/input", param);
			 stepSuccess = true;
			} catch (Exception e) {
			 errorMessage =e.getMessage();
			throw new RuntimeException(e.getMessage());
		} finally {
			StepResultTracker.addStepResult("输入职业", stepSuccess, errorMessage);
			}
		}


	@TestStepApi(stepDesc = "输入注册邮箱" ,issueId=" ")
	@And("输入注册邮箱")
	public void stepEnterEmailId(String param) {
		boolean stepSuccess = false;
		String errorMessage = null;
		try {
			 coreAction.enterText("xpath", "//*[@id='mazey']", param);
			 stepSuccess = true;
			} catch (Exception e) {
			 errorMessage =e.getMessage();
			throw new RuntimeException(e.getMessage());
		} finally {
			StepResultTracker.addStepResult("输入注册邮箱", stepSuccess, errorMessage);
			}
		}


	@TestStepApi(stepDesc = "点击注册按钮提交注册信息" ,issueId=" ")
	@And("点击注册按钮提交注册信息")
	public void stepClickOnZhuce() {
		boolean stepSuccess = false;
		String errorMessage = null;
		try {
			 coreAction.clickAction("xpath", "/html/body/div/div/div/form/div[4]/button");
			 stepSuccess = true;
			} catch (Exception e) {
			 errorMessage =e.getMessage();
			throw new RuntimeException(e.getMessage());
		} finally {
			StepResultTracker.addStepResult("点击注册按钮提交注册信息", stepSuccess, errorMessage);
			}
		}


	@TestStepApi(stepDesc = "输入电话号码" ,issueId=" ")
	@And("输入电话号码")
	public void stepEnterPhoneNo(String param) {
		boolean stepSuccess = false;
		String errorMessage = null;
		try {
			 coreAction.enterText("xpath", "/html/body/div/div/div/form/div[2]/div[2]/div/div/div/input", param);
			 stepSuccess = true;
			} catch (Exception e) {
			 errorMessage =e.getMessage();
			throw new RuntimeException(e.getMessage());
		} finally {
			StepResultTracker.addStepResult("输入电话号码", stepSuccess, errorMessage);
			}
		}


	@TestStepApi(stepDesc = "选择同意服务条款" ,issueId=" ")
	@And("选择同意服务条款")
	public void stepSelectCheckBox() {
		boolean stepSuccess = false;
		String errorMessage = null;
		try {
			 coreAction.clickAction("xpath", "/html/body/div/div/div/form/div[3]/div/label/span/span");
			 stepSuccess = true;
			} catch (Exception e) {
			 errorMessage =e.getMessage();
			throw new RuntimeException(e.getMessage());
		} finally {
			StepResultTracker.addStepResult("选择同意服务条款", stepSuccess, errorMessage);
			}
		}


	@TestStepApi(stepDesc = "Switch to new popup window" ,issueId=" ")
	@And("Switch to new popup window")
	public void stepSwitchToNewWindow() {
		boolean stepSuccess = false;
		String errorMessage = null;
		try {
				coreAction.switchToNewPopupWindow();
			 stepSuccess = true;
			} catch (Exception e) {
			 errorMessage =e.getMessage();
			throw new RuntimeException(e.getMessage());
		} finally {
			StepResultTracker.addStepResult("Switch to new popup window", stepSuccess, errorMessage);
			}
		}


	@TestStepApi(stepDesc = "输入行业" ,issueId=" ")
	@And("输入行业")
	public void stepEnterIndustry(String param) {
		boolean stepSuccess = false;
		String errorMessage = null;
		try {
			 coreAction.enterText("xpath", "/html/body/div/div/div/form/div[2]/div[5]/div/div/div/input", param);
			 stepSuccess = true;
			} catch (Exception e) {
			 errorMessage =e.getMessage();
			throw new RuntimeException(e.getMessage());
		} finally {
			StepResultTracker.addStepResult("输入行业", stepSuccess, errorMessage);
			}
		}


}

