package stepFiles;

import io.cucumber.java.en.And;

import org.json.JSONObject;

import org.openqa.selenium.WebDriver;
import com.priortest.annotation.TestStepApi;
import org.testng.Assert;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestCasePage {

	private static final Logger log = LogManager.getLogger(TestCasePage.class);
	private CoreActions coreAction;

	public TestCasePage(WebDriver driver) {
		this.coreAction = new CoreActions(driver);
	}

		@TestStepApi(stepDesc = "Click Test Case Menu" ,issueId=" ")
		@And("Click Test Case Menu")
	public void stepTestCaseMenu() {
		boolean stepSuccess = false;
		try {
				 coreAction.clickAction("xpath", "/html/body/div/div/div/div[1]/div/div[2]/ul/li[6]");
				 stepSuccess = true;
			} catch (Exception e) {
					log.info("An error occurred: " + e.getMessage());
			throw e;
		} finally {
			if (!stepSuccess) {
				throw new RuntimeException("Step Failed: stepTestCaseMenu");
				}
			}
		}


		@TestStepApi(stepDesc = "Enter title" ,issueId=" ")
		@And("Enter title")
	public void stepTestCaseFieldTestData(String param) {
		boolean stepSuccess = false;
		try {
				 coreAction.enterText("xpath", "/html/body/div/div/div/div[2]/div/div[1]/div/div/div[2]/div[1]/form/div[2]/div/div[1]/div/div/div/input", param);
				 stepSuccess = true;
			} catch (Exception e) {
					log.info("An error occurred: " + e.getMessage());
			throw e;
		} finally {
			if (!stepSuccess) {
				throw new RuntimeException("Step Failed: stepTestCaseFieldTestData with parameter: " + param);
				}
			}
		}


		@TestStepApi(stepDesc = "Enter External Id" ,issueId=" ")
		@And("Enter External Id")
	public void stepTestCaseFieldExternalId(String param) {
		boolean stepSuccess = false;
		try {
				 coreAction.enterText("xpath", "/html/body/div[1]/div/div/div[2]/div/div[1]/div/div/div[2]/div[1]/form/div[2]/div/div[16]/div/div/div/input", param);
				 stepSuccess = true;
			} catch (Exception e) {
					log.info("An error occurred: " + e.getMessage());
			throw e;
		} finally {
			if (!stepSuccess) {
				throw new RuntimeException("Step Failed: stepTestCaseFieldExternalId with parameter: " + param);
				}
			}
		}


		@TestStepApi(stepDesc = "Enter title" ,issueId=" ")
		@And("Enter title")
	public void stepTestCaseFieldTitle(String param) {
		boolean stepSuccess = false;
		try {
				 coreAction.enterText("xpath", "/html/body/div/div/div/div[2]/div/div[1]/div/div/div[2]/div[1]/form/div[2]/div/div[1]/div/div/div/input", param);
				 stepSuccess = true;
			} catch (Exception e) {
					log.info("An error occurred: " + e.getMessage());
			throw e;
		} finally {
			if (!stepSuccess) {
				throw new RuntimeException("Step Failed: stepTestCaseFieldTitle with parameter: " + param);
				}
			}
		}


		@TestStepApi(stepDesc = "Enter title" ,issueId=" ")
		@And("Enter title")
	public void stepTestCaseFieldLinkStory(String param) {
		boolean stepSuccess = false;
		try {
				 coreAction.enterText("xpath", "/html/body/div/div/div/div[2]/div/div[1]/div/div/div[2]/div[1]/form/div[2]/div/div[1]/div/div/div/input", param);
				 stepSuccess = true;
			} catch (Exception e) {
					log.info("An error occurred: " + e.getMessage());
			throw e;
		} finally {
			if (!stepSuccess) {
				throw new RuntimeException("Step Failed: stepTestCaseFieldLinkStory with parameter: " + param);
				}
			}
		}


		@TestStepApi(stepDesc = "Select device" ,issueId=" ")
		@And("Select device")
	public void stepTestCaseFieldDevice(String param) {
		boolean stepSuccess = false;
		try {
				 coreAction.selectOptionByValue("xpath", "/html/body/div[1]/div/div/div[2]/div/div[1]/div/div/div[2]/div[1]/form/div[2]/div/div[14]/div/div/div/div/input", param);
				 stepSuccess = true;
			} catch (Exception e) {
					log.info("An error occurred: " + e.getMessage());
			throw e;
		} finally {
			if (!stepSuccess) {
				throw new RuntimeException("Step Failed: stepTestCaseFieldDevice with parameter: " + param);
				}
			}
		}


		@TestStepApi(stepDesc = "Select status" ,issueId=" ")
		@And("Select status")
	public void stepTestCaseFieldStatus(String param) {
		boolean stepSuccess = false;
		try {
				 coreAction.selectOptionByTextFromList("xpath", "/html/body/div[1]/div/div/div[2]/div/div[1]/div/div/div[2]/div[1]/form/div[2]/div/div[11]/div/div/div/div/input", param);
				 stepSuccess = true;
			} catch (Exception e) {
					log.info("An error occurred: " + e.getMessage());
			throw e;
		} finally {
			if (!stepSuccess) {
				throw new RuntimeException("Step Failed: stepTestCaseFieldStatus with parameter: " + param);
				}
			}
		}


	@TestStepApi(stepDesc = "输入 创建test case 数据", issueId=" ")
	@And("输入 创建test case 数据")
	public void stepGroupEnterTestCaseInfo(JSONObject inputData) {
		boolean stepSuccess = false;
		try {
			if (inputData.has("title") && inputData.get("title") != null) {
				log.info(" Performing Step :  TestCaseFieldTitle(title)");
				stepTestCaseFieldTitle((String)inputData.get("title"));
			}
			if (inputData.has("desc") && inputData.get("desc") != null) {
				log.info(" Performing Step :  TestCaseFieldDesc(desc)");
				stepTestCaseFieldDesc((String)inputData.get("desc"));
			}
			if (inputData.has("category") && inputData.get("category") != null) {
				log.info(" Performing Step :  TestCaseFieldCategory(category)");
				stepTestCaseFieldCategory((String)inputData.get("category"));
			}
			if (inputData.has("condition") && inputData.get("condition") != null) {
				log.info(" Performing Step :  TestCaseFieldCondition(condition)");
				stepTestCaseFieldCondition((String)inputData.get("condition"));
			}
			if (inputData.has("browser") && inputData.get("browser") != null) {
				log.info(" Performing Step :  TestCaseFieldBrowser(browser)");
				stepTestCaseFieldBrowser((String)inputData.get("browser"));
			}
			if (inputData.has("status") && inputData.get("status") != null) {
				log.info(" Performing Step :  TestCaseFieldStatus(status)");
				stepTestCaseFieldStatus((String)inputData.get("status"));
			}
			if (inputData.has("查询") && inputData.get("查询") != null) {
				log.info(" Performing Step :  TestCaseFieldCustomChaXun(查询)");
				stepTestCaseFieldCustomChaXun((String)inputData.get("查询"));
			}
			stepSuccess = true;
		}
		catch (Exception e) {
			log.info("An error occurred: " + e.getMessage());
			throw e;
		} finally {
		if (!stepSuccess) {
			throw new RuntimeException("Step Failed: stepGroupEnterTestCaseInfo(输入 创建test case 数据)");
			}
		}
	}


		@TestStepApi(stepDesc = "Enter condition" ,issueId=" ")
		@And("Enter condition")
	public void stepTestCaseFieldCondition(String param) {
		boolean stepSuccess = false;
		try {
				 coreAction.enterText("xpath", "/html/body/div[1]/div/div/div[2]/div/div[1]/div/div/div[2]/div[1]/form/div[2]/div/div[18]/div/div/div/input", param);
				 stepSuccess = true;
			} catch (Exception e) {
					log.info("An error occurred: " + e.getMessage());
			throw e;
		} finally {
			if (!stepSuccess) {
				throw new RuntimeException("Step Failed: stepTestCaseFieldCondition with parameter: " + param);
				}
			}
		}


		@TestStepApi(stepDesc = "Click On Test Case Create Button" ,issueId=" ")
		@And("Click On Test Case Create Button")
	public void stepTestCaseCreateButton() {
		boolean stepSuccess = false;
		try {
				 coreAction.clickAction("xpath", "/html/body/div/div/div/div[2]/div/div/div[2]/div/div/div/div[1]/button/span");
				 stepSuccess = true;
			} catch (Exception e) {
					log.info("An error occurred: " + e.getMessage());
			throw e;
		} finally {
			if (!stepSuccess) {
				throw new RuntimeException("Step Failed: stepTestCaseCreateButton");
				}
			}
		}


		@TestStepApi(stepDesc = "Select the test case record from the list" ,issueId=" ")
		@And("Select the test case record from the list")
	public void stepTestCaseRecordSelectSingle() {
		boolean stepSuccess = false;
		try {
				 coreAction.clickAction("xpath", "/html/body/div/div/div/div[2]/div/div/div[2]/div/div/div/div[3]/div[1]/div[3]/table/tbody/tr[1]/td[1]/div/label/span/span");
				 stepSuccess = true;
			} catch (Exception e) {
					log.info("An error occurred: " + e.getMessage());
			throw e;
		} finally {
			if (!stepSuccess) {
				throw new RuntimeException("Step Failed: stepTestCaseRecordSelectSingle");
				}
			}
		}


		@TestStepApi(stepDesc = "Select Browser" ,issueId=" ")
		@And("Select Browser")
	public void stepTestCaseFieldBrowser(String param) {
		boolean stepSuccess = false;
		try {
				 coreAction.selectOptionByTextFromList("xpath", "/html/body/div[1]/div/div/div[2]/div/div[1]/div/div/div[2]/div[1]/form/div[2]/div/div[15]/div/div/div/div[1]/input", param);
				 stepSuccess = true;
			} catch (Exception e) {
					log.info("An error occurred: " + e.getMessage());
			throw e;
		} finally {
			if (!stepSuccess) {
				throw new RuntimeException("Step Failed: stepTestCaseFieldBrowser with parameter: " + param);
				}
			}
		}


		@TestStepApi(stepDesc = "Select Category" ,issueId=" ")
		@And("Select Category")
	public void stepTestCaseFieldCategory(String param) {
		boolean stepSuccess = false;
		try {
				 coreAction.selectOptionByTextFromList("xpath", "/html/body/div/div/div/div[2]/div/div[1]/div/div/div[2]/div[1]/form/div[2]/div/div[1]/div/div/div/input", param);
				 stepSuccess = true;
			} catch (Exception e) {
					log.info("An error occurred: " + e.getMessage());
			throw e;
		} finally {
			if (!stepSuccess) {
				throw new RuntimeException("Step Failed: stepTestCaseFieldCategory with parameter: " + param);
				}
			}
		}


		@TestStepApi(stepDesc = "Verify New Created Record In Test Case List" ,issueId=" ")
		@And("Verify New Created Record In Test Case List")
	public void stepVerifyTestCaseTitle(String param) {
		boolean stepSuccess = false;
		try {
			boolean result = coreAction.getVerifyTextPresent("xpath", "/html/body/div/div/div/div[2]/div/div[1]/div/div/div[2]/div[1]/form/div[2]/div/div[1]/div/div/div/input",param);
				Assert.assertTrue(result, "Verification failed for VerifyTestCaseTitle");
				 stepSuccess = true;
			} catch (Exception e) {
					log.info("An error occurred: " + e.getMessage());
			throw e;
		} finally {
			if (!stepSuccess) {
				throw new RuntimeException("Step Failed: stepVerifyTestCaseTitle with parameter: " + param);
				}
			}
		}


		@TestStepApi(stepDesc = "Select Version" ,issueId=" ")
		@And("Select Version")
	public void stepTestCaseFieldVersion(String param) {
		boolean stepSuccess = false;
		try {
				 coreAction.selectOptionByValue("xpath", "/html/body/div/div/div/div[2]/div/div[1]/div/div/div[2]/div[1]/form/div[2]/div/div[1]/div/div/div/input", param);
				 stepSuccess = true;
			} catch (Exception e) {
					log.info("An error occurred: " + e.getMessage());
			throw e;
		} finally {
			if (!stepSuccess) {
				throw new RuntimeException("Step Failed: stepTestCaseFieldVersion with parameter: " + param);
				}
			}
		}


		@TestStepApi(stepDesc = "Enter Desc" ,issueId=" ")
		@And("Enter Desc")
	public void stepTestCaseFieldDesc(String param) {
		boolean stepSuccess = false;
		try {
				 coreAction.enterText("xpath", "/html/body/div/div/div/div[2]/div/div[1]/div/div/div[2]/div[1]/form/div[2]/div/div[1]/div/div/div/input", param);
				 stepSuccess = true;
			} catch (Exception e) {
					log.info("An error occurred: " + e.getMessage());
			throw e;
		} finally {
			if (!stepSuccess) {
				throw new RuntimeException("Step Failed: stepTestCaseFieldDesc with parameter: " + param);
				}
			}
		}


		@TestStepApi(stepDesc = "Enter chaXun" ,issueId=" ")
		@And("Enter chaXun")
	public void stepTestCaseFieldCustomChaXun(String param) {
		boolean stepSuccess = false;
		try {
				 coreAction.selectOptionByTextFromList("xpath", "/html/body/div/div/div/div[2]/div/div[1]/div/div/div[2]/div[1]/form/div[2]/div/div[21]/div/div/div/div[1]/input", param);
				 stepSuccess = true;
			} catch (Exception e) {
					log.info("An error occurred: " + e.getMessage());
			throw e;
		} finally {
			if (!stepSuccess) {
				throw new RuntimeException("Step Failed: stepTestCaseFieldCustomChaXun with parameter: " + param);
				}
			}
		}


		@TestStepApi(stepDesc = "Enter title" ,issueId=" ")
		@And("Enter title")
	public void stepTestCaseFieldRemarks(String param) {
		boolean stepSuccess = false;
		try {
				 coreAction.enterText("xpath", "/html/body/div[1]/div/div/div[2]/div/div[1]/div/div/div[2]/div[1]/form/div[2]/div/div[19]/div/div/div/textarea", param);
				 stepSuccess = true;
			} catch (Exception e) {
					log.info("An error occurred: " + e.getMessage());
			throw e;
		} finally {
			if (!stepSuccess) {
				throw new RuntimeException("Step Failed: stepTestCaseFieldRemarks with parameter: " + param);
				}
			}
		}


		@TestStepApi(stepDesc = "select platform" ,issueId=" ")
		@And("select platform")
	public void stepTestCaseFieldPlatform(String param) {
		boolean stepSuccess = false;
		try {
				 coreAction.selectOptionByTextFromList("xpath", "/html/body/div[1]/div/div/div[2]/div/div[1]/div/div/div[2]/div[1]/form/div[2]/div/div[17]/div/div/div/div/input", param);
				 stepSuccess = true;
			} catch (Exception e) {
					log.info("An error occurred: " + e.getMessage());
			throw e;
		} finally {
			if (!stepSuccess) {
				throw new RuntimeException("Step Failed: stepTestCaseFieldPlatform with parameter: " + param);
				}
			}
		}


		@TestStepApi(stepDesc = "Click Save and Back Test Case Record" ,issueId=" ")
		@And("Click Save and Back Test Case Record")
	public void stepTestCaseSaveAndBackButton() {
		boolean stepSuccess = false;
		try {
				 coreAction.clickAction("xpath", "/html/body/div[1]/div/div/div[2]/div/div/div[2]/div/div/div/div[1]/button/span");
				 stepSuccess = true;
			} catch (Exception e) {
					log.info("An error occurred: " + e.getMessage());
			throw e;
		} finally {
			if (!stepSuccess) {
				throw new RuntimeException("Step Failed: stepTestCaseSaveAndBackButton");
				}
			}
		}


		@TestStepApi(stepDesc = "Click on the delete button of a test case" ,issueId=" ")
		@And("Click on the delete button of a test case")
	public void stepTestCaseDeleteButton() {
		boolean stepSuccess = false;
		try {
				 coreAction.clickAction("xpath", "/html/body/div[1]/div/div/div[2]/div/div/div[2]/div/div/div/div[3]/div[1]/div[4]/div[2]/table/tbody/tr[1]/td[15]/div/button[4]/span");
				 stepSuccess = true;
			} catch (Exception e) {
					log.info("An error occurred: " + e.getMessage());
			throw e;
		} finally {
			if (!stepSuccess) {
				throw new RuntimeException("Step Failed: stepTestCaseDeleteButton");
				}
			}
		}


}

