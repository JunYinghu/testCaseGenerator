package testCases;
import stepFiles.LogonPage;
import stepFiles.WelcomePage;
import config.BasicSetup;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.*;
import org.json.JSONObject;
import static org.testng.Assert.*;

import org.openqa.selenium.WebDriver;

import utils.WebDriverSingleton;

import com.priortest.annotation.TestCaseApi;

import com.priortest.api.PriorTestAPIAdapter;

import com.priortest.config.PTApiConfig;

import com.priortest.config.PTApiFieldSetup;

@Listeners({ PriorTestAPIAdapter.class })
public class LoginTestFeatureTestCase extends BasicSetup {

	private WebDriver driver;

	@Test
	@TestCaseApi(feature = "登录", priority = "高", severity = "严重", caseCategory = "功能", automationId = "UserLoginSuccessfully_TC01", issueId = {})
	public void testCase_UserLoginSuccessfully_loginAdminAccount() {
		logonPage.stepOpenLogonPage("http://43.139.159.146/index_login.html#/login?redirect=%2Fdashboard");
		logonPage.stepClearPassword();
		logonPage.stepClearUserName();
		logonPage.stepEnterUserName("qatest.hu.mary3@gmail.com");
		logonPage.stepEnterPassword("Hjyhappy123!");
		logonPage.stepClickLoginButton();
		// Create Hard Code Wait
		try { Thread.sleep(3000);} catch (InterruptedException e) {throw new RuntimeException(e);}
		// Auto-generated method: Wait for 3 seconds
		// Placeholder for method: WaitFor3Seconds();
		welcomePage.stepVerifyTextPresent("欢迎");
		// Create Hard Code Wait
		try { Thread.sleep(3000);} catch (InterruptedException e) {throw new RuntimeException(e);}
		// Auto-generated method: Wait for 3 seconds
		// Placeholder for method: WaitFor3Seconds();
		welcomePage.stepLogout();
	}

	@Test
	@TestCaseApi(feature = "登录", priority = "中", severity = "一般", caseCategory = "功能", automationId = "UserLoginSuccessfully_TC02", issueId = {})
	public void testCase_UserLoginSuccessfully_loginTesterAccount() {
		logonPage.stepOpenLogonPage("http://43.139.159.146/index_login.html#/login?redirect=%2Fdashboard");
		logonPage.stepClearPassword();
		logonPage.stepClearUserName();
		logonPage.stepEnterUserName("hujy11@gmail.com");
		logonPage.stepEnterPassword("Hjyhappy123!");
		logonPage.stepClickLoginButton();
		// Create Hard Code Wait
		try { Thread.sleep(3000);} catch (InterruptedException e) {throw new RuntimeException(e);}
		// Auto-generated method: Wait for 3 seconds
		// Placeholder for method: WaitFor3Seconds();
		welcomePage.stepVerifyTextPresent("欢迎");
		// Create Hard Code Wait
		try { Thread.sleep(3000);} catch (InterruptedException e) {throw new RuntimeException(e);}
		// Auto-generated method: Wait for 3 seconds
		// Placeholder for method: WaitFor3Seconds();
		welcomePage.stepLogout();
	}

	@Test
	@TestCaseApi(feature = "登录", priority = "高", severity = "严重", caseCategory = "功能", automationId = "UserLoginFail_TC03", issueId = {})
	public void testCase_UserLoginFail_AccountExpired() {
		logonPage.stepOpenLogonPage("http://43.139.159.146/index_login.html#/login?redirect=%2Fdashboard");
		logonPage.stepClearPassword();
		logonPage.stepClearUserName();
		// Create Hard Code Wait
		try { Thread.sleep(5000);} catch (InterruptedException e) {throw new RuntimeException(e);}
		// Auto-generated method: Wait for 5 seconds
		// Placeholder for method: WaitFor5Seconds();
		logonPage.stepEnterUserName("qatest.hu.mary@gmail.com");
		logonPage.stepEnterPassword("Hjyhappy234");
		logonPage.stepClickLoginButton();
		// Create Hard Code Wait
		try { Thread.sleep(5000);} catch (InterruptedException e) {throw new RuntimeException(e);}
		// Auto-generated method: Wait for 5 seconds
		// Placeholder for method: WaitFor5Seconds();
		logonPage.stepVerifyFailLoginPresent("请采购服务，或请申请再次试用");
	}

	@Test
	@TestCaseApi(feature = "登录", priority = "高", severity = "严重", caseCategory = "功能", automationId = "UserLoginFail_TC04", issueId = {})
	public void testCase_UserLoginFail_IncorrectPassword() {
		logonPage.stepOpenLogonPage("http://43.139.159.146/index_login.html#/login?redirect=%2Fdashboard");
		logonPage.stepClearPassword();
		logonPage.stepClearUserName();
		// Create Hard Code Wait
		try { Thread.sleep(5000);} catch (InterruptedException e) {throw new RuntimeException(e);}
		// Auto-generated method: Wait for 5 seconds
		// Placeholder for method: WaitFor5Seconds();
		logonPage.stepEnterUserName("qatest.hu.mary3@gmail.com");
		logonPage.stepEnterPassword("Hjyhappy234");
		logonPage.stepClickLoginButton();
		// Create Hard Code Wait
		try { Thread.sleep(5000);} catch (InterruptedException e) {throw new RuntimeException(e);}
		// Auto-generated method: Wait for 5 seconds
		// Placeholder for method: WaitFor5Seconds();
		logonPage.stepVerifyFailLoginPresent("认证失败，请重新登录。");
	}

	@Test
	@TestCaseApi(feature = "登录", priority = "高", severity = "严重", caseCategory = "功能", automationId = "UserLoginFail_TC05", issueId = {})
	public void testCase_UserLoginFail_emailNoPresent() {
		logonPage.stepOpenLogonPage("http://43.139.159.146/index_login.html#/login?redirect=%2Fdashboard");
		logonPage.stepClearPassword();
		logonPage.stepClearUserName();
		// Create Hard Code Wait
		try { Thread.sleep(5000);} catch (InterruptedException e) {throw new RuntimeException(e);}
		// Auto-generated method: Wait for 5 seconds
		// Placeholder for method: WaitFor5Seconds();
		logonPage.stepEnterUserName("qatest.hu.mar3@gmail.com");
		logonPage.stepEnterPassword("Hjyhappy234");
		logonPage.stepClickLoginButton();
		// Create Hard Code Wait
		try { Thread.sleep(5000);} catch (InterruptedException e) {throw new RuntimeException(e);}
		// Auto-generated method: Wait for 5 seconds
		// Placeholder for method: WaitFor5Seconds();
		logonPage.stepVerifyFailLoginPresent("用户名或密码错误。");
	}

	@Test
	@TestCaseApi(feature = "登录", priority = "高", severity = "严重", caseCategory = "功能", automationId = "IncorrectEmailError_TC06", issueId = {})
	public void testCase_IncorrectEmailError_emailFormatInValid() {
		logonPage.stepOpenLogonPage("http://43.139.159.146/index_login.html#/login?redirect=%2Fdashboard");
		// Create Hard Code Wait
		try { Thread.sleep(5000);} catch (InterruptedException e) {throw new RuntimeException(e);}
		// Auto-generated method: Wait for 5 seconds
		// Placeholder for method: WaitFor5Seconds();
		logonPage.stepClearPassword();
		logonPage.stepClearUserName();
		// Create Hard Code Wait
		try { Thread.sleep(5000);} catch (InterruptedException e) {throw new RuntimeException(e);}
		// Auto-generated method: Wait for 5 seconds
		// Placeholder for method: WaitFor5Seconds();
		logonPage.stepEnterUserName("qatest.hu.mary3@gmail.com.com@test");
		logonPage.stepEnterPassword("Hjyhappy234");
		// Create Hard Code Wait
		try { Thread.sleep(5000);} catch (InterruptedException e) {throw new RuntimeException(e);}
		// Auto-generated method: Wait for 5 seconds
		// Placeholder for method: WaitFor5Seconds();
		logonPage.stepClickLoginButton();
		logonPage.stepVerifyIncorrectEmailPresent("请输入正确的邮箱地址");
	}

	@BeforeClass
	public void setUp(){
		String browser = PTApiConfig.getBrowser();
		driver = WebDriverSingleton.getDriver(WebDriverSingleton.BrowserType.valueOf(browser));
		logonPage= new LogonPage(driver);
		welcomePage= new WelcomePage(driver);

		// Set Case Module
		PTApiFieldSetup.setModule("登录");
	}

	@AfterClass
	public void setDown(){
		WebDriverSingleton.quitDriver();
	}

		private LogonPage logonPage;
		private WelcomePage welcomePage;

}
