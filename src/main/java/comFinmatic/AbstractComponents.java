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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
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
        url = Utils.getFrontofficeUrl();
        browser = Utils.getBrowser();
        driver.get(url);
    }

    public void getRequiredEnvLinkBO() {
        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> all = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(all.get(1));

        url = Utils.getBackofficeUrl();
        browser = Utils.getBrowser();

        driver.get(url);
    }

    public void getRequiredEnvLinkOP() {
        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> all = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(all.get(2));
        url = Utils.getOpenPaydUrl();
        browser = Utils.getBrowser();

        driver.get(url);
    }

    public void implicitWait(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
    }

}