package comFinmatic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class SetupClassTest {
    protected WebDriver driver;

    @Parameters({"env"})
    @BeforeMethod(alwaysRun = true)
    public void setupLogin(@Optional("UAT") final String env){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        Properties properties = new Properties();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        //String browserName =  System.getProperty("environment")!=null ? System.getProperty("environment") : properties.getProperty("environment");
        switch (env) {
            case "DEV":
                driver.get("https://dev.finmatic.net/login");
                break;
            case "BMP":
                driver.get("https://bmp.finmatic.net/login");
                break;
            default:
                //Do nothing
        }
        // driver.get("https://dev.finmatic.net/login");
        //driver.get("https://bmp.finmatic.net/login");



    }

   /* @AfterMethod(alwaysRun = true)
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }*/
}
