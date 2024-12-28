package funGroup;

import config.BasicSetup;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class FuncGroup extends BasicSetup {
    private static final Logger log = LogManager.getLogger(FuncGroup.class);
    @Test
    public void userIsLogged(){
        WebDriver driver = null;
        driver = new FirefoxDriver();
        driver.quit();
        log.debug("This is a debug message");
        log.info("This is an info message");
        log.warn("This is a warning message");
        log.error("This is an error message");
        log.fatal("This is a fatal message");
        //LogonPage logonPage = new LogonPage(driver);

        //logonPage.stepOpenLogonPage("HTTP:WWW.GOOGLE.COM");
        //logonPage.stepEnterUserName(userName);
        //logonPage.stepEnterPassword(password);
        //logonPage.stepClickLoginButton();
    };
}
