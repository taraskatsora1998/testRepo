package comFinmatic;

import comFinmatic.dto.TestContextPersonal;
import comFinmatic.dto.TestContextBusiness;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage extends AbstractComponents {

    public LoginPage(WebDriver driver, TestContextPersonal testContextPersonal, TestContextBusiness testContextBusiness){
        super(driver, testContextPersonal, testContextBusiness);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[contains(.,'Register')]")
    WebElement btnRegister;

    @FindBy(xpath = "//input[@class='form-control ']")
    WebElement fieldPhoneNumber;

    @FindBy(xpath = "//input[@name='password']")
    WebElement fieldPassword;

    @FindBy(xpath = "//button[.='Log In']")
    WebElement btnLogIn;

    @FindBy(xpath = "//input[@class='security-cell']")
    List<WebElement> fieldSecurityCode;

    @FindBy(xpath = "//a[@href='/password_recovery']")
    WebElement btnForgotPassword;

    @FindBy(xpath = "//div[@class='selected-flag']")
    WebElement btnCountryCode;

    @FindBy(xpath = "//span[.='Ukraine']")
    WebElement btnCountry;

    @FindBy(xpath = "//p[@class='alert-text']")
    WebElement allertMsgStatus;

    By securityCode = By.xpath("//input[@class='security-cell']");

    public String allertMsgAdministrate = "Your account has been temporarily blocked due to an internal account review. Please contact the support team.";

    public String allertMsgBlocked = "User account is locked. Please contact the support team.";

    public LoginPage clickRegisterBtn() {
        btnRegister.click();

        return this;
    }

    public LoginPage enterPhoneNumberPersonal() {
        fieldPhoneNumber.sendKeys(testContextPersonal.getPnone());

        return this;
    }

    public LoginPage enterPhoneNumberBusiness() {
        fieldPhoneNumber.sendKeys(testContextBusiness.getPnoneBusiness());

        return this;
    }

    public LoginPage enterPassword() {
        fieldPassword.sendKeys(testContextPersonal.getPassword());

        return this;
    }

    public LoginPage clickLogInBtn() {
        btnLogIn.click();

        return this;
    }

    public LoginPage enterSecurityCode() {
        waitForElementToBeVisible(securityCode);
        for (WebElement webElement : fieldSecurityCode) {
            webElement.sendKeys("1");
        }

        return this;
    }

    public LoginPage clickForgotPasswordBtn(){
        btnForgotPassword.click();

        return this;
    }

    public LoginPage clickCountryCodeBtn() {
        btnCountryCode.click();

        return this;
    }

    public LoginPage clickCountryBtn(){
        btnCountry.click();

        return this;
    }

    public String getAllertMsg() {
        return allertMsgStatus.getText();
    }

}