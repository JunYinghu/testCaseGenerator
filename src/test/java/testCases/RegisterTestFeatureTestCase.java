package testCases;
import stepFiles.LogonPage;
import stepFiles.RegisterInfoPage;
import stepFiles.RegisterPageEnd;
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
public class RegisterTestFeatureTestCase extends BasicSetup {

	private WebDriver driver;

	@Test
	@TestCaseApi(feature = "注册", priority = "高", severity = "严重", caseCategory = "功能", automationId = "RegisterUserSuccess_TC01", issueId = {})
	public void testCase_RegisterUserSuccess_FullInfo() {
		logonPage.stepOpenLogonPage("http://43.139.159.146/index_login.html#/login?redirect=%2Fdashboard");
		logonPage.stepClickZhuCe();
		JSONObject inputData = new JSONObject();
		inputData.put("severity", "严重");
		inputData.put("automationId", "TC01");
		inputData.put("occupation", "软件测试");
		inputData.put("companyName", "Json.test");
		inputData.put("emailId", "qatest.hu.mary3@gmail.com");
		inputData.put("industry", "IT");
		inputData.put("userName", "星海软件");
		inputData.put("priority", "高");
		inputData.put("url", "http://43.139.159.146/index_login.html#/login?redirect=%2Fdashboard");
		inputData.put("phoneNo", "85331509");
		inputData.put("verifiedMessage", "感谢您试用PriorTest, 请通过您的注册邮箱qatest.hu.mary3@gmail.com激活注册帐号开启您的体验之旅");
		inputData.put("testCaseName", "FullInfo");
		inputData.put("caseCategory", "功能");

		registerInfoPage.stepGroupEnterRegisterInfo(inputData);
		// Create Hard Code Wait
		try { Thread.sleep(5000);} catch (InterruptedException e) {throw new RuntimeException(e);}
		// Auto-generated method: Wait for 5 seconds
		// Placeholder for method: WaitFor5Seconds();
		registerInfoPage.stepOpenTerms();
		registerInfoPage.stepClickAgree();
		registerInfoPage.stepSelectCheckBox();
		registerInfoPage.stepClickOnZhuce();
		registerInfoPage.stepVerifyRegisterSucess("感谢您试用PriorTest, 请通过您的注册邮箱qatest.hu.mary3@gmail.com激活注册帐号开启您的体验之旅");
		registerPageEnd.stepGoBackLogon();
	}

	@Test
	@TestCaseApi(feature = "注册", priority = "高", severity = "严重", caseCategory = "功能", automationId = "RegisterUserSuccess_TC02", issueId = {})
	public void testCase_RegisterUserSuccess_UserNameWithOtherDefault() {
		logonPage.stepOpenLogonPage("http://43.139.159.146/index_login.html#/login?redirect=%2Fdashboard");
		logonPage.stepClickZhuCe();
		JSONObject inputData = new JSONObject();
		inputData.put("severity", "严重");
		inputData.put("automationId", "TC02");
		inputData.put("occupation", "");
		inputData.put("companyName", "");
		inputData.put("emailId", "qatest.hu.mary@163.com");
		inputData.put("industry", "");
		inputData.put("userName", "");
		inputData.put("priority", "高");
		inputData.put("url", "http://43.139.159.146/index_login.html#/login?redirect=%2Fdashboard");
		inputData.put("phoneNo", "");
		inputData.put("verifiedMessage", "感谢您试用PriorTest, 请通过您的注册邮箱qatest.hu.mary@163.com激活注册帐号开启您的体验之旅");
		inputData.put("testCaseName", "UserNameWithOtherDefault");
		inputData.put("caseCategory", "功能");

		registerInfoPage.stepGroupEnterRegisterInfo(inputData);
		// Create Hard Code Wait
		try { Thread.sleep(5000);} catch (InterruptedException e) {throw new RuntimeException(e);}
		// Auto-generated method: Wait for 5 seconds
		// Placeholder for method: WaitFor5Seconds();
		registerInfoPage.stepOpenTerms();
		registerInfoPage.stepClickAgree();
		registerInfoPage.stepSelectCheckBox();
		registerInfoPage.stepClickOnZhuce();
		registerInfoPage.stepVerifyRegisterSucess("感谢您试用PriorTest, 请通过您的注册邮箱qatest.hu.mary@163.com激活注册帐号开启您的体验之旅");
		registerPageEnd.stepGoBackLogon();
	}

	@Test
	@TestCaseApi(feature = "注册", priority = "高", severity = "严重", caseCategory = "界面", automationId = "VerifyFieldLength_TC02", issueId = {})
	public void testCase_VerifyFieldLength_Exceed() {
		logonPage.stepOpenLogonPage("http://43.139.159.146/index_login.html#/login?redirect=%2Fdashboard");
		logonPage.stepClickZhuCe();
		registerInfoPage.stepEnterEmailId("testingitngasdfasdasdfas.adaf.adfasdfdsafasdf@gmail.com");
		registerInfoPage.stepEnterPhoneNo("                         ");
		registerInfoPage.stepEnterUserName("userName         userName2");
		registerInfoPage.stepEnterCompanyName("companyName");
		registerInfoPage.stepEnterOccupation("123.45");
		registerInfoPage.stepEnterIndustry("industry");
		// Create Hard Code Wait
		try { Thread.sleep(5000);} catch (InterruptedException e) {throw new RuntimeException(e);}
		// Auto-generated method: Wait for 5 seconds
		// Placeholder for method: WaitFor5Seconds();
		registerInfoPage.stepVerifyUserNameLength("长度最多20个字符");
		registerInfoPage.stepVerifyEmailIdLength("长度最多50个字符");
		registerInfoPage.stepVerifyPhoneNoLength("长度最多20个字符");
		registerInfoPage.stepGoBackLogon();
	}

	@Test
	@TestCaseApi(feature = "注册", priority = "高", severity = "严重", caseCategory = "功能", automationId = "FailedToRegister_TC04", issueId = {})
	public void testCase_FailedToRegister_NotEmail() {
		logonPage.stepOpenLogonPage("http://43.139.159.146/index_login.html#/login?redirect=%2Fdashboard");
		logonPage.stepClickZhuCe();
		registerInfoPage.stepEnterEmailId("qatest.hu.mary3");
		registerInfoPage.stepVerifyInvalidEmail("请输入正确的邮箱地址");
	}

	@Test
	@TestCaseApi(feature = "注册", priority = "高", severity = "严重", caseCategory = "功能", automationId = "RegisterCancellation_TC04", issueId = {})
	public void testCase_RegisterCancellation_GoBackLogon() {
		logonPage.stepOpenLogonPage("http://43.139.159.146/index_login.html#/login?redirect=%2Fdashboard");
		logonPage.stepClickZhuCe();
		registerInfoPage.stepGoBackLogon();
		logonPage.stepVerifyPageTitle("PriorTest");
	}

	@BeforeClass
	public void setUp(){
		String browser = PTApiConfig.getBrowser();
		driver = WebDriverSingleton.getDriver(WebDriverSingleton.BrowserType.valueOf(browser));
		logonPage= new LogonPage(driver);
		registerInfoPage= new RegisterInfoPage(driver);
		registerPageEnd= new RegisterPageEnd(driver);

		// Set Case Module
		PTApiFieldSetup.setModule("注册");
	}

	@AfterClass
	public void setDown(){
		WebDriverSingleton.quitDriver();
	}

		private LogonPage logonPage;
		private RegisterInfoPage registerInfoPage;
		private RegisterPageEnd registerPageEnd;

}
