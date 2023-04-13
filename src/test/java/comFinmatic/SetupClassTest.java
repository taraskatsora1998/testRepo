package comFinmatic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SetupClassTest {
    protected WebDriver driver;
    private String url;
    private String browser;

    @BeforeMethod
    public void setUp() {
        String environment = System.getProperty("environment");

        if (environment.equalsIgnoreCase("dev_chrome")) {
            url = "https://dev.finmatic.net/login";
            browser = "chrome";
        } else if (environment.equalsIgnoreCase("dev_firefox")) {
            url = "https://dev.finmatic.net/login";
            browser = "firefox";
        } else if (environment.equalsIgnoreCase("dev_safari")) {
            url = "https://dev.finmatic.net/login";
            browser = "safari";
        } else if (environment.equalsIgnoreCase("bmp_chrome")) {
            url = "https://bmp.finmatic.net/login";
            browser = "chrome";
        } else if (environment.equalsIgnoreCase("bmp_firefox")) {
            url = "https://bmp.finmatic.net/login";
            browser = "firefox";
        }  else if (environment.equalsIgnoreCase("bmp_safari")) {
            url = "https://bmp.finmatic.net/login";
            browser = "safari";
        }  else if (environment.equalsIgnoreCase("acceptance_chrome")) {
            url = "https://acceptance-new.finmatic.net/login";
            browser = "chrome";
        } else if (environment.equalsIgnoreCase("acceptance_firefox")) {
            url = "https://acceptance-new.finmatic.net/login";
            browser = "firefox";
        } else if (environment.equalsIgnoreCase("acceptance_safari")) {
            url = "https://acceptance-new.finmatic.net/login";
            browser = "safari";
        } else {
            throw new IllegalArgumentException("Invalid environment: " + environment);
        }

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        if(browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver(options);
        } else if(browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        } else if(browser.equalsIgnoreCase("safari")){
            driver = new SafariDriver();
        } else {
            throw new IllegalArgumentException("Invalid browser: " + browser);
        }

        driver.manage().window().maximize();
        driver.get(url);
    }

    @AfterMethod(alwaysRun = true)
    public void quitDriver() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}