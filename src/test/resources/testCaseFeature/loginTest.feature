Feature:登录

  Scenario Outline: User Login Successfully
    Given Open Web Page as given URL <url>
    Given clear the password in the login form
    Given clear the username in the login form
    When Enter the username in the login form <userName>
    And Enter the password in the login form <password>
    And Click the login button on the login form
    And Wait for 3 seconds
    Then Verify the welcome message on the page <verifiedMessage>
    And Wait for 3 seconds
    And Logout user from the page

    Examples:
      | testCaseName       | url                   | userName                  | password     | verifiedMessage | priority | severity | caseCategory | automationId |
      | loginAdminAccount  | http://43.139.159.146 | qatest.hu.mary3@gmail.com | Hjyhappy123! | 欢迎              | 高        | 严重       | 功能           | TC01        |
      | loginTesterAccount | http://43.139.159.146 | hujy11@gmail.com          | Hjyhappy123!  | 欢迎              | 中        | 一般       | 功能           | TC02        |

  Scenario Outline: User Login Fail
    Given Open Web Page as given URL <url>
    Given clear the password in the login form
    Given clear the username in the login form
    And Wait for 5 seconds
    When Enter the username in the login form <userName>
    And Enter the password in the login form <password>
    And Click the login button on the login form
    And Wait for 5 seconds
    Then Verify the login fails message on the page <verifiedMessage>

    Examples:
      | testCaseName        | url                   | userName                  | password    | verifiedMessage | priority | severity | caseCategory | automationId |
      | AccountExpired      | http://43.139.159.146 | qatest.hu.mary@gmail.com | Hjyhappy234 | 请采购服务，或请申请再次试用  | 高        | 严重       | 功能           | TC03        |
      | IncorrectPassword | http://43.139.159.146 | qatest.hu.mary3@gmail.com | Hjyhappy234 |认证失败，请重新登录。       | 高        | 严重       | 功能           | TC04        |
      | emailNoPresent | http://43.139.159.146 | qatest.hu.mar3@gmail.com | Hjyhappy234 | 用户名或密码错误。       | 高        | 严重       | 功能           | TC05        |


  Scenario Outline: Incorrect Email Error
    Given Open Web Page as given URL <url>
    And Wait for 5 seconds
    Given clear the password in the login form
    Given clear the username in the login form
    And Wait for 5 seconds
    When Enter the username in the login form <userName>
    And Enter the password in the login form <password>
    And Wait for 5 seconds
    And Click the login button on the login form
    Then Verify the email incorrect message on the page <verifiedMessage>

    Examples:
      | testCaseName       | url                   | userName                  | password    | verifiedMessage | priority | severity | caseCategory | automationId |
      | emailFormatInValid| http://43.139.159.146 | qatest.hu.mary3@gmail.com.com@test | Hjyhappy234 | 请输入正确的邮箱地址      | 高        | 严重       | 功能           | TC06        |
