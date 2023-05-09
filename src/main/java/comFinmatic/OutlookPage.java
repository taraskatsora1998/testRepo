package comFinmatic;

import comFinmatic.dto.TestContextBusiness;
import comFinmatic.dto.TestContextPersonal;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class OutlookPage extends AbstractComponents {

    public OutlookPage(WebDriver driver, TestContextPersonal testContextPersonal, TestContextBusiness testContextBusiness) {
        super(driver, testContextPersonal, testContextBusiness);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@type='email']")
    WebElement fieldEmail;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement btnNext;

    @FindBy(xpath = "//input[@name='passwd']")
    WebElement fieldPassword;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement btnYes;

    @FindBy(xpath = "//button[@id='O365_MainLink_NavMenu']")
    WebElement btnMenu;

    @FindBy(xpath = "//div/span[contains(text(),'Outlook')]")
    WebElement btnOutlook;

    @FindBy(xpath = "//div[@title='Junk Email']")
    WebElement btnJunkEmail;

    @FindBy(xpath = "(//div[contains(@aria-label,'Unread')]//span[contains(text(),'Registration Success')])[1]")
    WebElement btnEmailSuccessfullRegistration;

    @FindBy(xpath = "(//div[contains(@aria-label,'Unread')]//span[contains(text(),'Password Reset')])[1]")
    WebElement btnEmailPasswordReset;

    @FindBy(xpath = "(//div[contains(@aria-label,'Unread')]//span[contains(text(),'Account was verified')])[1]")
    WebElement btnEmailAccountVerified;

    @FindBy(xpath = "(//div[contains(@aria-label,'Unread')]//span[contains(text(),'Password Reset')])[1]")
    WebElement btnEmailPswrdReset;

    @FindBy(xpath = "(//span[contains(text(),'Read / Unread')])[1]")
    WebElement btnReadUnread;

    @FindBy(xpath = "//a[@target='_blank' and contains(text(),'Reset password')]")
    WebElement btnResetPassword;

    @FindBy(xpath = "//div[@class='x_mj-column-per-100 x_mj-outlook-group-fix']//div[contains(text(),'Registration Success')]")
    WebElement checkUserSuccessRegistered;

    @FindBy(xpath = "//div[@class='x_mj-column-per-50 x_mj-outlook-group-fix']//div[contains(text(),'Account access')]")
    WebElement checkAccountAccess;

    @FindBy(xpath = "(//table[@style='vertical-align:top']//div)[2]")
    WebElement getAccountVerifiedText;

    @FindBy(xpath = "//input[@class='security-cell']")
    WebElement fieldSecurityCode;

    @FindBy(xpath = "//button[@aria-label='Empty folder']")
    WebElement btnDeletemsg;

    @FindBy(xpath = "(//div[@data-automation-type='RibbonSplitButton'])[2]")
    WebElement btnDeletemsgForCheckStatus;

    @FindBy(xpath = "//span[contains(text(),'Delete all')]")
    WebElement btnDeleteMailsBtn;

    By waitMenuBtn = By.xpath("//button[@id='O365_MainLink_NavMenu']");
    By waitOutlookBtn = By.xpath("//div/span[contains(text(),'Outlook')]");
    By waitFieldPassword = By.xpath("//input[@name='passwd']");
    By waitYesBtn = By.xpath("//input[@type='submit']");
    By waitJunkMailBtn = By.xpath("//div[@title='Junk Email']");
    By waitEmailField = By.xpath("//input[@type='email']");

    String accountWasVerifiedText = "Dear TestCompany,\n" +
            "you have successfully finished the verification process";

    String accountWasVerifiedPersonalText = "Dear FirstName LastName,\n" +
            "you have successfully finished the verification process";

    public OutlookPage navigateNewTab() {
        ArrayList<String> all = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(all.get(1));
        driver.get("https://login.live.com/login.srf?");

        return this;
    }

    public OutlookPage navigateNewTabb() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> all = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(all.get(1));
        driver.get("https://login.live.com/login.srf?");

        return this;
    }

    public OutlookPage enterEMail() {
        waitForElementToBeVisible(waitEmailField);
        fieldEmail.sendKeys("QaAutomationTests@outlook.com");

        return this;
    }

    public OutlookPage clickNextBtn() {
        btnNext.click();

        return this;
    }

    public OutlookPage enterPassword() {
        waitForElementToBeVisible(waitFieldPassword);
        fieldPassword.sendKeys("Aa123b123-1");

        return this;
    }

    public OutlookPage clickYesBtn() {
        waitForElementToBeClickable(waitYesBtn);
        btnYes.click();

        return this;
    }

    public OutlookPage clickMenuBtn() {
        waitForElementToBeClickable(waitMenuBtn);
        btnMenu.click();

        return this;
    }

    public OutlookPage clickOutlookBtn() {
        waitForElementToBeClickable(waitOutlookBtn);
        Actions actions = new Actions(driver);
        actions.moveToElement(btnOutlook);
        actions.click();
        actions.build().perform();

        return this;
    }

    public OutlookPage clickSuccessRegistrationEmail() {
        implicitWait();
        btnEmailSuccessfullRegistration.click();

        return this;
    }

    public OutlookPage clickAccountWasVerifiedEmail() {
        implicitWait();
        btnEmailAccountVerified.click();

        return this;
    }

    public OutlookPage clickJunkMail() {
        ArrayList<String> all = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(all.get(2));
        waitForElementToBeClickable(waitJunkMailBtn);
        btnJunkEmail.click();

        return this;
    }

    public String checkUSerWasSuccessfullyRegistered() {
        return checkUserSuccessRegistered.getText();
    }

    public String checkUSerReceivedPasswordResetEmail() {
        return checkAccountAccess.getText();
    }

    public OutlookPage clickReadUnreadBtn() {
        btnReadUnread.click();

        return this;
    }

    public OutlookPage clickPasswordResetEMail() {
        implicitWait();
        btnEmailPasswordReset.click();

        return this;
    }

    public OutlookPage clickResetPswrdBtn() {
        implicitWait();
        btnResetPassword.click();

        return this;
    }

    public OutlookPage clickResetPswrdEmailBtn() {
        implicitWait();
        btnEmailPswrdReset.click();

        return this;
    }

    public String verifyAccountWasVerified() {
        return getAccountVerifiedText.getText();
    }

    public OutlookPage navigatePreviousTab() {
        String copiedDigits = driver.findElement(By.xpath("//td[@class='x_text-code']//div")).getText();
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> all = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(all.get(0));
        fieldSecurityCode.sendKeys(copiedDigits);

        return this;
    }

    public OutlookPage quitDriverEmail() {
        ArrayList<String> all = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(all.get(0));
        driver.get("https://login.live.com/login.srf?");
        waitForElementToBeVisible(waitMenuBtn);
        btnMenu.click();
        waitForElementToBeClickable(waitOutlookBtn);
        Actions actions = new Actions(driver);
        actions.moveToElement(btnOutlook);
        actions.click();
        actions.build().perform();
        driver.switchTo().window(all.get(2));
        btnJunkEmail.click();
        if (btnDeletemsgForCheckStatus.getAttribute("class").contains("splitButtonContainerDisabled")) {
            driver.quit();
        } else {
            btnDeletemsg.click();
            actions.moveToElement(btnDeleteMailsBtn);
            actions.click();
            actions.build().perform();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return this;
    }
}