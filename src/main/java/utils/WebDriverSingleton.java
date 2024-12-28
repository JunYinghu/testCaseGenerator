package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverSingleton  {

    private static WebDriver driver;
    public enum BrowserType {
        CHROME,
        FIREFOX,
        SAFARI
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
    public static WebDriver getDriver(BrowserType browserType) {
        if (driver == null) {
            switch (browserType) {
                case CHROME:
                    //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // Set path to ChromeDriver
                    driver = new ChromeDriver();
                    break;
                case FIREFOX:
                    //System.setProperty("webdriver.gecko.driver", "path/to/geckodriver"); // Set path to GeckoDriver
                    driver = new FirefoxDriver();
                    break;
                case SAFARI:
                    // SafariDriver is built into macOS, no need to set system property
                    driver = new SafariDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported browser type: " + browserType);
            }
        }
        return driver;
    }


}
