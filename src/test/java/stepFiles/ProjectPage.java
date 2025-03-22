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

public class ProjectPage {

	private static final Logger log = LogManager.getLogger(ProjectPage.class);
	private CoreActions coreAction;

	public ProjectPage(WebDriver driver) {
		this.coreAction = new CoreActions(driver);
	}

	@TestStepApi(stepDesc = "Click Save and Back Project Record" ,issueId=" ")
	@And("Click Save and Back Project Record")
	public void stepProjectSaveAndBackButton() {
		boolean stepSuccess = false;
		String errorMessage = null;
		try {
			 coreAction.clickAction("xpath", "/html/body/div/div/div/div[2]/div/div[1]/div/div/div[2]/div[1]/form/div[1]/button[2]/span");
			 stepSuccess = true;
			} catch (Exception e) {
			 errorMessage =e.getMessage();
			throw new RuntimeException(e.getMessage());
		} finally {
			StepResultTracker.addStepResult("Click Save and Back Project Record", stepSuccess, errorMessage);
			}
		}


	@TestStepApi(stepDesc = "Select report to" ,issueId=" ")
	@And("Select report to")
	public void stepProjectFieldReportTo(String param) {
		boolean stepSuccess = false;
		String errorMessage = null;
		try {
			 coreAction.selectOptionByValue("xpath", "/html/body/div/div/div/div[2]/div/div[1]/div/div/div[2]/div[1]/form/div[2]/div/div[3]/div/div/div/div[1]/input", param);
			 stepSuccess = true;
			} catch (Exception e) {
			 errorMessage =e.getMessage();
			throw new RuntimeException(e.getMessage());
		} finally {
			StepResultTracker.addStepResult("Select report to", stepSuccess, errorMessage);
			}
		}


	@TestStepApi(stepDesc = "Select test frame" ,issueId=" ")
	@And("Select test frame")
	public void stepProjectFieldTestFrame(String param) {
		boolean stepSuccess = false;
		String errorMessage = null;
		try {
			 coreAction.selectOptionByValue("xpath", "/html/body/div/div/div/div[2]/div/div[1]/div/div/div[2]/div[1]/form/div[2]/div/div[6]/div/div/div/div[1]/input", param);
			 stepSuccess = true;
			} catch (Exception e) {
			 errorMessage =e.getMessage();
			throw new RuntimeException(e.getMessage());
		} finally {
			StepResultTracker.addStepResult("Select test frame", stepSuccess, errorMessage);
			}
		}


	@TestStepApi(stepDesc = "Verify New Created Record In Project List" ,issueId=" ")
	@And("Verify New Created Record In Project List")
	public void stepVerifyProjectTitle(String param) {
		boolean stepSuccess = false;
		String errorMessage = null;
		try {
			boolean result = coreAction.getVerifyTextPresent("xpath", "/html/body/div[1]/div/div/div[2]/div/div/div[2]/div/div/div/div[3]/div[1]/div[3]/table/tbody/tr[1]/td[4]/div/span",param);
				Assert.assertTrue(result, "Verification failed for VerifyProjectTitle");
			 stepSuccess = true;
			} catch (Exception e) {
			 errorMessage =e.getMessage();
			throw new RuntimeException(e.getMessage());
		} finally {
			StepResultTracker.addStepResult("Verify New Created Record In Project List", stepSuccess, errorMessage);
			}
		}


	@TestStepApi(stepDesc = "Enter Desc" ,issueId=" ")
	@And("Enter Desc")
	public void stepProjectFieldDesc(String param) {
		boolean stepSuccess = false;
		String errorMessage = null;
		try {
			 coreAction.enterText("xpath", "/html/body/div/div/div/div[2]/div/div[1]/div/div/div[2]/div[1]/form/div[2]/div/div[2]/div/div/div/textarea", param);
			 stepSuccess = true;
			} catch (Exception e) {
			 errorMessage =e.getMessage();
			throw new RuntimeException(e.getMessage());
		} finally {
			StepResultTracker.addStepResult("Enter Desc", stepSuccess, errorMessage);
			}
		}


	@TestStepApi(stepDesc = "Enter title" ,issueId=" ")
	@And("Enter title")
	public void stepProjectFieldTitle(String param) {
		boolean stepSuccess = false;
		String errorMessage = null;
		try {
			 coreAction.enterText("xpath", "/html/body/div/div/div/div[2]/div/div[1]/div/div/div[2]/div[1]/form/div[2]/div/div[1]/div/div/div[1]/input", param);
			 stepSuccess = true;
			} catch (Exception e) {
			 errorMessage =e.getMessage();
			throw new RuntimeException(e.getMessage());
		} finally {
			StepResultTracker.addStepResult("Enter title", stepSuccess, errorMessage);
			}
		}


	@TestStepApi(stepDesc = "输入 创建 Project 数据", issueId=" ")
	@And("输入 创建 Project 数据")
	public void stepGroupEnterProjectInfo(JSONObject inputData) {
		boolean stepSuccess = false;
		String errorMessage = null;
		try {
			if (inputData.has("title") && inputData.get("title") != null) {
				log.info(" Performing Step :  ProjectFieldTitle(title)");
				stepProjectFieldTitle((String)inputData.get("title"));
			}
			if (inputData.has("desc") && inputData.get("desc") != null) {
				log.info(" Performing Step :  ProjectFieldDesc(desc)");
				stepProjectFieldDesc((String)inputData.get("desc"));
			}
			if (inputData.has("type") && inputData.get("type") != null) {
				log.info(" Performing Step :  ProjectFieldProjectType(type)");
				stepProjectFieldProjectType((String)inputData.get("type"));
			}
			if (inputData.has("reportTo") && inputData.get("reportTo") != null) {
				log.info(" Performing Step :  ProjectFieldReportTo(reportTo)");
				stepProjectFieldReportTo((String)inputData.get("reportTo"));
			}
			if (inputData.has("remarks") && inputData.get("remarks") != null) {
				log.info(" Performing Step :  ProjectFieldRemarks(remarks)");
				stepProjectFieldRemarks((String)inputData.get("remarks"));
			}
			if (inputData.has("status") && inputData.get("status") != null) {
				log.info(" Performing Step :  ProjectFieldStatus(status)");
				stepProjectFieldStatus((String)inputData.get("status"));
			}
			stepSuccess = true;
		}
		catch (Exception e) {
			log.info("An error occurred: " + e.getMessage());
			throw e;
		} finally {
			StepResultTracker.addStepResult("输入 创建 Project 数据", stepSuccess, errorMessage);
		}
	}


	@TestStepApi(stepDesc = "Enter customer" ,issueId=" ")
	@And("Enter customer")
	public void stepProjectFieldCustomer(String param) {
		boolean stepSuccess = false;
		String errorMessage = null;
		try {
			 coreAction.enterText("xpath", "/html/body/div/div/div/div[2]/div/div[1]/div/div/div[2]/div[1]/form/div[2]/div/div[8]/div/div/div/input", param);
			 stepSuccess = true;
			} catch (Exception e) {
			 errorMessage =e.getMessage();
			throw new RuntimeException(e.getMessage());
		} finally {
			StepResultTracker.addStepResult("Enter customer", stepSuccess, errorMessage);
			}
		}


	@TestStepApi(stepDesc = "Select the Project record from the list" ,issueId=" ")
	@And("Select the Project record from the list")
	public void stepProjectRecordSelectSingle() {
		boolean stepSuccess = false;
		String errorMessage = null;
		try {
			 coreAction.clickAction("xpath", "/html/body/div/div/div/div[2]/div/div/div[2]/div/div/div/div[3]/div[1]/div[3]/table/tbody/tr[1]/td[1]/div/label/span/span");
			 stepSuccess = true;
			} catch (Exception e) {
			 errorMessage =e.getMessage();
			throw new RuntimeException(e.getMessage());
		} finally {
			StepResultTracker.addStepResult("Select the Project record from the list", stepSuccess, errorMessage);
			}
		}


	@TestStepApi(stepDesc = "Click on the delete button of a test case" ,issueId=" ")
	@And("Click on the delete button of a test case")
	public void stepProjectDeleteButton() {
		boolean stepSuccess = false;
		String errorMessage = null;
		try {
			 coreAction.clickAction("xpath", "/html/body/div[1]/div/div/div[2]/div/div/div[2]/div/div/div/div[3]/div[1]/div[4]/div[2]/table/tbody/tr[1]/td[15]/div/button[4]/span");
			 stepSuccess = true;
			} catch (Exception e) {
			 errorMessage =e.getMessage();
			throw new RuntimeException(e.getMessage());
		} finally {
			StepResultTracker.addStepResult("Click on the delete button of a test case", stepSuccess, errorMessage);
			}
		}


	@TestStepApi(stepDesc = "Click Project Menu" ,issueId=" ")
	@And("Click Project Menu")
	public void stepProjectMenu() {
		boolean stepSuccess = false;
		String errorMessage = null;
		try {
			 coreAction.clickAction("xpath", "/html/body/div/div/div/div[1]/div/div[2]/ul/li[10]");
			 stepSuccess = true;
			} catch (Exception e) {
			 errorMessage =e.getMessage();
			throw new RuntimeException(e.getMessage());
		} finally {
			StepResultTracker.addStepResult("Click Project Menu", stepSuccess, errorMessage);
			}
		}


	@TestStepApi(stepDesc = "Select status" ,issueId=" ")
	@And("Select status")
	public void stepProjectFieldStatus(String param) {
		boolean stepSuccess = false;
		String errorMessage = null;
		try {
			 coreAction.selectOptionByValue("xpath", "/html/body/div/div/div/div[2]/div/div[1]/div/div/div[2]/div[1]/form/div[2]/div/div[5]/div/div/div/div[1]/input", param);
			 stepSuccess = true;
			} catch (Exception e) {
			 errorMessage =e.getMessage();
			throw new RuntimeException(e.getMessage());
		} finally {
			StepResultTracker.addStepResult("Select status", stepSuccess, errorMessage);
			}
		}


	@TestStepApi(stepDesc = "Enter project type" ,issueId=" ")
	@And("Enter project type")
	public void stepProjectFieldProjectType(String param) {
		boolean stepSuccess = false;
		String errorMessage = null;
		try {
			 coreAction.selectOptionByValue("xpath", "/html/body/div/div/div/div[2]/div/div[1]/div/div/div[2]/div[1]/form/div[2]/div/div[4]/div/div/div/div[1]/input", param);
			 stepSuccess = true;
			} catch (Exception e) {
			 errorMessage =e.getMessage();
			throw new RuntimeException(e.getMessage());
		} finally {
			StepResultTracker.addStepResult("Enter project type", stepSuccess, errorMessage);
			}
		}


	@TestStepApi(stepDesc = "Click On Project Create Button" ,issueId=" ")
	@And("Click On Project Create Button")
	public void stepProjectCreateButton() {
		boolean stepSuccess = false;
		String errorMessage = null;
		try {
			 coreAction.clickAction("xpath", "/html/body/div/div/div/div[2]/div/div/div[2]/div/div/div/div[1]/button/span");
			 stepSuccess = true;
			} catch (Exception e) {
			 errorMessage =e.getMessage();
			throw new RuntimeException(e.getMessage());
		} finally {
			StepResultTracker.addStepResult("Click On Project Create Button", stepSuccess, errorMessage);
			}
		}


	@TestStepApi(stepDesc = "Enter Remarks" ,issueId=" ")
	@And("Enter Remarks")
	public void stepProjectFieldRemarks(String param) {
		boolean stepSuccess = false;
		String errorMessage = null;
		try {
			 coreAction.enterText("xpath", "/html/body/div/div/div/div[2]/div/div[1]/div/div/div[2]/div[1]/form/div[2]/div/div[9]/div/div/div/textarea", param);
			 stepSuccess = true;
			} catch (Exception e) {
			 errorMessage =e.getMessage();
			throw new RuntimeException(e.getMessage());
		} finally {
			StepResultTracker.addStepResult("Enter Remarks", stepSuccess, errorMessage);
			}
		}


}

