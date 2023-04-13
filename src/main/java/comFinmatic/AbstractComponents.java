package comFinmatic;

import comFinmatic.dto.TestContextPersonal;
import comFinmatic.dto.TestContextBusiness;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class AbstractComponents {
    protected final WebDriver driver;
    public String browser;
    public String url;
    protected final TestContextPersonal testContextPersonal;
    protected final TestContextBusiness testContextBusiness;

    public AbstractComponents(WebDriver driver, TestContextPersonal testContextPersonal, TestContextBusiness testContextBusiness){
        this.driver = driver;
        this.testContextPersonal = testContextPersonal;
        this.testContextBusiness = testContextBusiness;
    }

    private int boundedRandomValue = ThreadLocalRandom.current().nextInt(0, 9999999);
    public String randomEmail = boundedRandomValue + "@mailinator.com";

    public void waitForElementToBeVisible(By findBy){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(150));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

    public void waitForElementToBeClickable(By findBy){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(findBy));
    }

    public void waitForElementToContains(By findBy){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(150));
        wait.until(ExpectedConditions.attributeContains(findBy,"value","UNDER_REVIEW"));
    }

    public void selectValueFromDropdown(WebElement webElement, String valueFromDropDown){
        Select select = new Select(webElement);
        select.selectByValue(valueFromDropDown);
    }

    public String getValueSelected(WebElement userStatus){
        Select select = new Select(userStatus);
        WebElement webElement = select.getFirstSelectedOption();
        String selectedOptions = webElement.getText();

        return selectedOptions;
    }

    public void getRequiredEnvLinkWebSite() {
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

        driver.get(url);
    }

    public void getRequiredEnvLinkBO() {
        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> all = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(all.get(1));

        String environment = System.getProperty("environment");
        if (environment.equalsIgnoreCase("dev_chrome")) {
            url = "https://dev-admin.finmatic.net/login";
            browser = "chrome";
        } else if (environment.equalsIgnoreCase("dev_firefox")) {
            url = "https://dev-admin.finmatic.net/login";
            browser = "firefox";
        } else if (environment.equalsIgnoreCase("dev_safari")) {
            url = "https://dev-admin.finmatic.net/login";
            browser = "safari";
        } else if (environment.equalsIgnoreCase("bmp_chrome")) {
            url = "https://bmp-admin.finmatic.net/login";
            browser = "chrome";
        } else if (environment.equalsIgnoreCase("bmp_firefox")) {
            url = "https://bmp-admin.finmatic.net/login";
            browser = "firefox";
        } else if (environment.equalsIgnoreCase("bmp_safari")) {
            url = "https://bmp-admin.finmatic.net/login";
            browser = "safari";
        } else if (environment.equalsIgnoreCase("acceptance_chrome")) {
            url = "https://acceptance.admin.finmatic.net/login";
            browser = "chrome";
        } else if (environment.equalsIgnoreCase("acceptance_firefox")) {
            url = "https://acceptance.admin.finmatic.net/login";
            browser = "firefox";
        } else if (environment.equalsIgnoreCase("acceptance_safari")) {
            url = "https://acceptance.admin.finmatic.net/login";
            browser = "safari";
        } else {
            throw new IllegalArgumentException("Invalid environment: " + environment);
        }

        driver.get(url);
    }

    public void implicitWait(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(550));
    }
}