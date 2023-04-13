package comFinmatic;

import comFinmatic.dto.TestContextPersonal;
import comFinmatic.dto.TestContextBusiness;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class MailinatorPage extends AbstractComponents{

    public MailinatorPage(WebDriver driver, TestContextPersonal testContextPersonal, TestContextBusiness testContextBusiness){
        super(driver, testContextPersonal, testContextBusiness);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "(//*[contains(@id,'search')])[1]")
    WebElement fieldEmail;

    @FindBy(xpath = "//button[contains(text(),'GO')]")
    WebElement btnGO;

    @FindBy(xpath = "(//td[contains(text(),'Password Reset')])[1]")
    WebElement emailRessetPassword;

    @FindBy(xpath = "(//*[contains(text(),'Reset password')])[1]")
    WebElement btnResetPasword;

    @FindBy(xpath = "//iframe[@id='html_msg_body']")
    WebElement swithToIframe;

    @FindBy(xpath = "//input[@class='security-cell']")
    WebElement fieldSecurityCode;

    @FindBy(xpath = "(//*[contains(text(),'Account was verified')])[1]")
    WebElement btnEmailVerification;

    @FindBy(xpath = "(//*[contains(@style,'font-family: \"manrope\" , sans-serif ')])[2]")
    WebElement textAccountVerified;

    @FindBy(xpath = "(//*[contains(text(),'Password Reset')])[1]")
    WebElement btnEmailPasswordReset;

    @FindBy(xpath = "(//*[contains(text(),'Reset password')])[1]")
    WebElement btnEmailResetPassword;

    public String textFromEmailBusinessAccount = "Dear TestCompany,\n" +
            "you have successfully finished the verification process";

    public String textFromEmailPersonalsAccount = "Dear FirstName LastName,\n" +
            "you have successfully finished the verification process";

    public MailinatorPage enterEmailPersonal(){
        fieldEmail.sendKeys(testContextPersonal.getEmail());

        return this;
    }

    public MailinatorPage enterEmailBusiness(){
        fieldEmail.sendKeys(testContextBusiness.getEmailBusiness());

        return this;
    }

    public MailinatorPage clickGoBtn(){
        btnGO.click();

        return this;
    }

    public MailinatorPage clickEmailBtn() {
        implicitWait();
        emailRessetPassword.click();

        return this;
    }

    public MailinatorPage clickResetPasswordBtn(){
        driver.switchTo().frame(swithToIframe);
        btnResetPasword.click();

        return this;
    }

    public MailinatorPage navigatePreviousTab(){
        driver.switchTo().frame(swithToIframe);
        String copiedDigits = driver.findElement(By.xpath("//td[@class='text-code']")).getText();
        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> all = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(all.get(0));
        fieldSecurityCode.sendKeys(copiedDigits);

        return this;
    }

    public MailinatorPage navigateNewTab(){
        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> all = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(all.get(1));
        driver.get("https://www.mailinator.com/");

        return this;
    }

    public MailinatorPage navigateNewTabb(){
        ArrayList<String> all = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(all.get(1));
        driver.get("https://www.mailinator.com/");

        return this;
    }

    public MailinatorPage clickAccountVerificationEmail(){
        implicitWait();
        btnEmailVerification.click();

        return this;
    }

    public String verifySuccessfullAccountConfirmation(){
        implicitWait();
        driver.switchTo().frame(swithToIframe);

        return textAccountVerified.getText();
    }

    public boolean checkPasswordResetEmailIsDisplayed() {
        boolean isEnabled = btnEmailPasswordReset.isDisplayed();
        return isEnabled;
    }

    public MailinatorPage clickResetPasswordBtnFromEmail() {
        driver.switchTo().frame(swithToIframe);
        btnEmailResetPassword.click();

        return this;
    }
}