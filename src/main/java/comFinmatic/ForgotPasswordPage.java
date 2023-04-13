package comFinmatic;

import comFinmatic.dto.TestContextPersonal;
import comFinmatic.dto.TestContextBusiness;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ForgotPasswordPage extends AbstractComponents{

    public ForgotPasswordPage(WebDriver driver, TestContextPersonal testContextPersonal, TestContextBusiness testContextBusiness){
        super(driver, testContextPersonal, testContextBusiness);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@class='form-control ']")
    WebElement fieldPhoneNumber;

    @FindBy(xpath = "//button")
    WebElement btnSubmit;

    @FindBy(xpath = "//input[@class='security-cell']")
    List<WebElement> fieldSecurityCode;

    @FindBy(xpath = "//input[@name='username']")
    WebElement fieldEmail;

    @FindBy(xpath = "//button")
    WebElement btnSendAccountEmail;

    @FindBy(xpath = "//input[@name='password']")
    WebElement fieldNewPassword;

    @FindBy(xpath = "//input[@name='repeat_password']")
    WebElement fieldRepeatPassword;

    @FindBy(xpath = "//button")
    WebElement btnConfirm;

    @FindBy(xpath = "//h2[.='Success!']")
    WebElement successNotification;

    @FindBy(xpath = "//div[@class='selected-flag']")
    WebElement btnCountryCode;

    @FindBy(xpath = "//span[.='Ukraine']")
    WebElement btnCountry;

    By securityCode = By.xpath("//input[@class='security-cell']");

    public ForgotPasswordPage enterPhoneNumberPersonal(){
        fieldPhoneNumber.sendKeys(testContextPersonal.getPnone());

        return this;
    }

    public ForgotPasswordPage enterPhoneNumberBusiness(){
        fieldPhoneNumber.sendKeys(testContextBusiness.getPnoneBusiness());

        return this;
    }

    public ForgotPasswordPage clickSubmitBtn(){
        btnSubmit.click();

        return this;
    }

    public ForgotPasswordPage enterSecurityCode() {
        waitForElementToBeVisible(securityCode);
        for (WebElement webElement : fieldSecurityCode) {
            webElement.sendKeys("1");
        }

        return this;
    }

    public ForgotPasswordPage enterEmailPersonal(){
        fieldEmail.sendKeys(testContextPersonal.getEmail());

        return this;
    }

    public ForgotPasswordPage enterNewPassword(String newPassword){
        implicitWait();
        fieldNewPassword.sendKeys(newPassword);

        return this;
    }

    public ForgotPasswordPage repeatPasswordField(String repeatPassword){
        fieldRepeatPassword.sendKeys(repeatPassword);

        return this;
    }

    public ForgotPasswordPage clickConfirmBtn(){
        btnConfirm.click();

        return this;
    }

    public ForgotPasswordPage clickSendAccountEmailBtn(){
        btnSendAccountEmail.click();

        return this;
    }

    public ForgotPasswordPage clickCountryCodeBtn() {
        btnCountryCode.click();

        return this;
    }

    public ForgotPasswordPage clickCountryBtn(){
        btnCountry.click();

        return this;
    }

    public boolean verifySuccessfullSignUp(){
        boolean isSuccessfull = false;

        if (successNotification.getText().equals("Success!")){
            isSuccessfull = true;
        }

        return isSuccessfull;
    }

    public ForgotPasswordPage enterEmailBusiness(){
        fieldEmail.sendKeys(testContextBusiness.getEmailBusiness());

        return this;
    }
}
