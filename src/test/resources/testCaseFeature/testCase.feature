Feature: 测试用例

  Scenario Outline: Create Test Case Successfully
    Given Open Web Page as given URL "http://43.139.159.146/"
    Given clear the password in the login form
    Given clear the username in the login form
    When Enter the username in the login form "hujy11@gmail.com"
    And Enter the password in the login form "Hjyhappy123!"
    And Click the login button on the login form
    And Wait for 3 seconds
    And Click Test Case Menu
    And Wait for 3 seconds
    When Click On Test Case Create Button
    And Wait for 3 seconds
    And 输入 创建test case 数据
     """
      {
  "title": "est",
  "description": "",
  "version": "1.0.0.0",
  "caseCategory": "性能",
  "priority": "中",
  "reportTo": "",
  "feature": "1213123",
  "testData": "请输入测试所需数据",
  "module": "未知",
  "testMethod": "自动",
  "testStatus": "草稿",
  "env": "测试",
  "testType": "正向",
  "testDevice": "手机",
  "browser": "",
  "externalLinkId": "tc-02",
  "platform": "Window11",
  "testCondition": "",
  "remarks": "",
  "projectId": "885958494765715456",
  "customFieldDatas": {
    "attributes": [
      {
        "fieldType": "dropDown",
        "fieldNameEn": "",
        "customFieldId": "888311159843721218",
        "customFieldLinkId": "888311159877275648",
        "fieldNameCn": "查询",
        "scopeNameCn": "测试用例",
        "scope": "testCase",
        "scopeId": "3000001",
        "valueData": ""
      }
    ]
  }
}
      """
    And Wait for 15 seconds
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


