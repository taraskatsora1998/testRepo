package comFinmatic;

import comFinmatic.dto.TestContextBusiness;
import comFinmatic.dto.TestContextPersonal;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SetupClassTest {
    public WebDriver driver;
    public OutlookPage outlookPage;

    @BeforeMethod
    public void setUp() {
        String url = Utils.getFrontofficeUrl();
        String browser = Utils.getBrowser();
        DesiredCapabilities capabilities = new DesiredCapabilities();

        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--window-size=1920,1080");
            //options.addArguments("--headless");
            options.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Safari/537.36");
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(ChromeOptions.CAPABILITY, options);
            caps.setCapability("acceptInsecureCerts", caps);
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            capabilities.setBrowserName("firefox");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--disable-gpu");
            options.addArguments("--disable-extensions");
            options.addArguments("--proxy-server='direct://'");
            options.addArguments("--proxy-bypass-list=*");
            options.addArguments("--start-maximized");
            options.addArguments("--headless");
            driver = new FirefoxDriver(options);
        } else {
            throw new IllegalArgumentException("Invalid browser: " + browser);
        }
        driver.manage().window().maximize();
        driver.get(url);
    }

    @AfterMethod(onlyForGroups = {"group2"})
    public void deleteMails() {
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        outlookPage = new OutlookPage(driver, testContextPersonal, testContextBusiness);
        outlookPage.quitDriverEmail();
    }

    @AfterMethod(onlyForGroups = {"group2", "group1"}, alwaysRun = true)
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

}