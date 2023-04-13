package comFinmatic;

import comFinmatic.dto.TestContextPersonal;
import comFinmatic.dto.TestContextBusiness;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RegisterPage extends AbstractComponents{

    public RegisterPage(WebDriver driver, TestContextPersonal testContextPersonal, TestContextBusiness testContextBusiness){
        super(driver, testContextPersonal, testContextBusiness);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@class='form-control ']")
    WebElement fieldPhoneNumber;

    @FindBy(xpath = "//input[@name='password']")
    WebElement fieldPassword;

    @FindBy(xpath = "//button[.='Register']")
    WebElement btnRegister;

    @FindBy(xpath = "//input[@class='security-cell']")
    List<WebElement> fieldSecurityCode;

    @FindBy(xpath = "//p[.='Personal']")
    WebElement btnPersonalAccount;

    @FindBy(xpath = "//input[@name='name']")
    WebElement fieldFirstName;

    @FindBy(xpath = "//input[@name='surname']")
    WebElement filedLastName;

    @FindBy(xpath = "//input[@name='email']")
    WebElement fieldEmail;

    @FindBy(xpath = "//h2[.='Success!']")
    WebElement successNotification;

    @FindBy(xpath = "//button[.='Log in now']")
    WebElement btnLogIn;

    @FindBy(xpath = "//button[@class='scheme-success-button']")
    WebElement btnSuccessLogin;

    @FindBy(xpath = "//div[@class='selected-flag']")
    WebElement btnCountryCode;

    @FindBy(xpath = "//span[.='Ukraine']")
    WebElement btnCountry;

    @FindBy(xpath = "//input[@name='companyName']")
    WebElement fieldCompanyName;

    By securityCode = By.xpath("//input[@class='security-cell']");
    By companyName = By.xpath("//input[@name='companyName']");

    public RegisterPage enterPhoneNumberPersonal(){
        fieldPhoneNumber.sendKeys(testContextPersonal.getPnone());

        return this;
    }

    public RegisterPage enterPhoneNumberBusiness(){
        fieldPhoneNumber.sendKeys(testContextBusiness.getPnoneBusiness());

        return this;
    }

    public RegisterPage enterPassword(){
        fieldPassword.sendKeys(testContextPersonal.getPassword());

        return this;
    }

    public RegisterPage clickRegisterBtn(){
        implicitWait();
        btnRegister.click();

        return this;
    }

    public RegisterPage enterSecurityCode(){
        waitForElementToBeVisible(securityCode);
        for (WebElement webElement: fieldSecurityCode) {
            webElement.sendKeys("1");
        }

        return this;
    }

    public RegisterPage clickPeprsonalAccountBtn(){
        implicitWait();
        btnPersonalAccount.click();

        return this;
    }

    public RegisterPage enterFirstName(String firstName){
        fieldFirstName.sendKeys(firstName);

        return this;
    }

    public RegisterPage enterLastName(String lastName){
        filedLastName.sendKeys(lastName);

        return this;
    }

    public RegisterPage enterEmailPersonal(){
        fieldEmail.sendKeys(testContextPersonal.getEmail());

        return this;
    }

    public RegisterPage enterEmailBusiness(){
        fieldEmail.sendKeys(testContextBusiness.getEmailBusiness());

        return this;
    }

    public RegisterPage clickLogInbtn(){
        btnLogIn.click();

        return this;
    }

    public RegisterPage rediretToLoginPage(){
        getRequiredEnvLinkWebSite();

        return this;
    }

    public RegisterPage clickSuccessLogInBtn(){
        btnSuccessLogin.click();

        return this;
    }

    public boolean verifySuccessfullSignUp(){
        boolean isSuccessfull = false;
        implicitWait();
        if (successNotification.getText().equals("Success!")){
            isSuccessfull = true;
        }

        return isSuccessfull;
    }

    public RegisterPage clickCountryCodeBtn() {
        btnCountryCode.click();

        return this;
    }

    public RegisterPage clickCountryBtn(){
        btnCountry.click();

        return this;
    }

    public RegisterPage enterCompanyName(String testCompany) {
        waitForElementToBeVisible(companyName);
        fieldCompanyName.sendKeys(testCompany);

        return this;
    }
}