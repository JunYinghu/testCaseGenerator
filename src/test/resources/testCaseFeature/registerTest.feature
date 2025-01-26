Feature: 注册

  Scenario Outline: Register User Success
    Given  Open Web Page as given URL <url>
    When Click 注册按钮 from login form
    Given 输入注册用户信息
    And Wait for 5 seconds
    And 打开服务条款
    And Click 同意并继续按钮
    And 选择同意服务条款
    And 点击注册按钮提交注册信息
    Then Verify 注册成功信息 <verifiedMessage>
    And 点击返回登录 from register end

    Examples:
      | testCaseName             | url                   | emailId                   | phoneNo  | userName | companyName | industry | occupation | verifiedMessage                                                  | priority | severity | caseCategory | automationId |
      | FullInfo                 | http://43.139.159.146 | qatest.hu.mary3@gmail.com | 85331509 | 星海软件     | Json.test   | IT       | 软件测试       | 感谢您试用PriorTest, 请通过您的注册邮箱qatest.hu.mary3@gmail.com激活注册帐号开启您的体验之旅 | 高        | 严重       | 功能           | TC01         |
      | UserNameWithOtherDefault | http://43.139.159.146 | qatest.hu.mary@163.com    |          |          |             |          |            | 感谢您试用PriorTest, 请通过您的注册邮箱qatest.hu.mary@163.com激活注册帐号开启您的体验之旅    | 高        | 严重       | 功能           | TC02         |

  Scenario Outline: Verify Field Length
    Given Open Web Page as given URL <url>
    When Click 注册按钮 from login form
    Given 输入注册邮箱 "testingitngasdfasdasdfas.adaf.adfasdfdsafasdf@gmail.com"
    And 输入电话号码 "                         "
    Given 输入用户名称 "userName         userName2"
    And 输入公司名称 "companyName"
    And 输入职业 "123.45"
    And 输入行业 "industry"
    And Wait for 5 seconds
    Then Verify  用户名 长度 <verifiedUserNameLength>
    And Verify  邮箱 长度 <verifiedEmailLength>
    And Verify  电话号码 长度 <verifiedUserNameLength>
    And 点击返回登录 from register page

    Examples:
      | testCaseName | url                   | verifiedUserNameLength | verifiedEmailLength | priority | severity | caseCategory | automationId |
      | Exceed     | http://43.139.159.146 | 长度最多20个字符              | 长度最多50个字符           | 高        | 严重       | 界面           | TC02         |


  Scenario Outline: Failed To Register
    Given Open Web Page as given URL <url>
    When Click 注册按钮 from login form
    And 输入注册邮箱 <emailId>
    Then 验证注册邮箱 <verifiedMessage>

    Examples:
      | testCaseName | url                   | emailId         | verifiedMessage | priority | severity | caseCategory | automationId |
      | NotEmail     | http://43.139.159.146 | qatest.hu.mary3 | 请输入正确的邮箱地址      | 高        | 严重       | 功能           | TC04         |


  Scenario Outline: Register Cancellation
    Given Open Web Page as given URL <url>
    When Click 注册按钮 from login form
    And 点击返回登录 from register page
    Then 验证 web page title <pageTitle>

    Examples:
      | testCaseName | url                   | pageTitle | priority | severity | caseCategory | automationId |
      | GoBackLogon  | http://43.139.159.146 | PriorTest | 高        | 严重       | 功能           | TC04         |