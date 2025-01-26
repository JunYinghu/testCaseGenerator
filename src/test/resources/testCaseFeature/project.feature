Feature: 项目

  Scenario Outline: Create Project Successfully
    Given Admin User has been login
    And Click Project Menu
    When Click On Test Case Create Button
    And 输入 创建test case 数据
     """
      {
        "projectId": "1868226015180881922",
        "title": "jl;",
        "priority": "中",
        "feature": "asdf",
        "description": "asdf",
        "executeTime": "",
        "browser": "Sarfri",
        "platform": "Window11",
        "version": "1.0.0.0",
        "caseCategory": "性能",
        "testType": "正向",
        "testCondition": "sdf",
        "env": "测试",
        "externalLinkId": "test",
        "lastRunStatus": "",
        "module": "未知",
        "testDevice": "手机",
        "testData": "请输入测试所需数据",
        "testMethod": "自动",
        "testStatus": "草稿",
        "runStatus": "",
        "reportTo": "sjfle",
        "testcaseExpand": "{}",
        "remarks": "sdf",
        "testCaseStepList": ""
      }
      """
    And Click Save and Back Test Case Record
    Then Verify New Created Record In Test Case List <verifiedMessage>
    Examples:
      | testCaseName       | verifiedMessage | priority | severity | caseCategory | automationId |
      | loginTesterAccount | 调用成功            | 中        | 一般       | 功能           | TC02         |

  Scenario Outline: Test Case Is deleted Successfully
    Given Admin User has been login
    When Select the test case record from the list
    And Click on the delete button of a test case
    Then Verify Record is deleted <verifiedMessage>
    Examples:
      | testCaseName       | verifiedMessage | priority | severity | caseCategory | automationId |
      | loginTesterAccount | 调用成功            | 中        | 一般       | 功能           | TC01         |


