package comFinmatic;

import comFinmatic.dto.TestContextPersonal;
import comFinmatic.dto.TestContextBusiness;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashboardPage extends AbstractComponents {

    public DashboardPage(WebDriver driver, TestContextPersonal testContextPersonal, TestContextBusiness testContextBusiness){
        super(driver, testContextPersonal, testContextBusiness);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[contains(@class,'input-wrapper-dropdown active account-dropdown')]")
    WebElement fieldDropDown;

    @FindBy(xpath = "//*[contains(text(), 'Open an account')]")
    WebElement btnOpenAnAccount;

    @FindBy(xpath = "//p[.='Personal']")
    WebElement btnPersonalAccount;

    @FindBy(xpath = "//*[contains(@class,'radio-group')]")
    WebElement radioGroup;

    @FindBy(xpath = "//*[contains(text(),'Open an account')]")
    WebElement btnOpenAccountFromDashboard;

    @FindBy(xpath = "//input[@name='companyName']")
    WebElement fieldEnterCompanyName;

    @FindBy(xpath = "//input[@name='email']")
    WebElement fieldEnterYourEmail;

    @FindBy(xpath = "//button[.='Register']")
    WebElement btnRegister;

    @FindBy(xpath = "//input[@class='security-cell']")
    List<WebElement> fieldSecurityCode;

    @FindBy(xpath = "//h2[.='Success!']")
    WebElement successNotification;

    @FindBy(xpath = "//input[@name='name']")
    WebElement fieldFirstName;

    @FindBy(xpath = "//input[@name='surname']")
    WebElement filedLastName;

    @FindBy(xpath = "//p[.='Dashboard']")
    WebElement btnDashboard;

    @FindBy(xpath = "//button[.='Begin verification']")
    WebElement btnBeginVerification;

    @FindBy(xpath = "(//button[@type='submit'])[1]")
    WebElement btnBeginVerificationSimpleStructure;

    @FindBy(xpath = "//*[contains(@class,'company-select')]")
    WebElement btnChooseDocumentType;

    @FindBy(xpath = "//p[contains(text(),'Latest Transactions')]")
    WebElement textField;

    @FindBy(xpath = "//p[.='Representatives']")
    WebElement btnRepresentatives;

    @FindBy(xpath = "//button[text()='Add new representative']")
    WebElement btnAddNewRepresentatives;

    @FindBy(xpath = "//button[contains(text(),'Next')]")
    WebElement btnNext;

    @FindBy(xpath = "//input[@placeholder='Name@example.com']")
    WebElement fieldEnterEmail;

    @FindBy(xpath = "(//*[@class='checkbox'])[1]")
    WebElement btnCheckBox;

    @FindBy(xpath = "(//*[contains(text(),'Add')])[2]")
    WebElement btnAdd;

    @FindBy(xpath = "//*[contains(text(),'Confirm')]")
    WebElement btnConfirm;

    @FindBy(xpath = "//button[contains(text(),'Next')]")
    WebElement btnNextRepresentative;

    @FindBy(xpath = "//button[contains(text(),'Yes')]")
    WebElement btnYes;

    @FindBy(xpath = "//button[contains(text(),'Ok')]")
    WebElement btnOk;

    @FindBy(xpath = "//p[@class='account']")
    WebElement fieldIbanAccount;

    By dropDown = By.xpath("//*[contains(@class,'input-wrapper-dropdown active account-dropdown')]");
    By securityCode = By.xpath("//input[@class='security-cell']");

    public DashboardPage clickDropDownField(){
        waitForElementToBeVisible(dropDown);
        fieldDropDown.click();

        return this;
    }

    public DashboardPage clickOpenAnAccountBtn(){
        btnOpenAnAccount.click();

        return this;
    }

    public DashboardPage clickOpenAccountFromDashboardBtn(){
        implicitWait();
        btnOpenAccountFromDashboard.click();

        return this;
    }

    public DashboardPage enterCompanyName(String companyName){
        fieldEnterCompanyName.sendKeys(companyName);

        return this;
    }

    public DashboardPage enterYourEmail(){
        fieldEnterYourEmail.sendKeys(testContextPersonal.getEmail());

        return this;
    }

    public DashboardPage clickRegisterBtn(){
        btnRegister.click();

        return this;
    }

    public DashboardPage enterSecurityCode(){
        waitForElementToBeVisible(securityCode);
        for (WebElement webElement: fieldSecurityCode) {
            webElement.sendKeys("1");
        }

        return this;
    }

    public DashboardPage clickPersonalAccountBtn(){
        btnPersonalAccount.click();

        return this;
    }

    public DashboardPage enterFirstName(String firstName){
        fieldFirstName.sendKeys(firstName);

        return this;
    }

    public DashboardPage enterLastName(String lastName){
        filedLastName.sendKeys(lastName);

        return this;
    }

    public boolean checkPersonalAccountBtnIsEnabled(){
        boolean isEnabled = false;
        if(radioGroup.getAttribute("class").contains("disabled-left")){
            isEnabled = true;
        }
        return isEnabled;
    }

    public boolean verifySuccessfullSignUp(){
        boolean isSuccessfull = false;
        implicitWait();
        if (successNotification.getText().equals("Success!")){
            isSuccessfull = true;
        }

        return isSuccessfull;
    }

    public boolean verifySuccessfullLogIn(){
        boolean isSuccessfull = false;
        implicitWait();
        if (btnDashboard.getText().equals("Dashboard")){
            isSuccessfull = true;
        }

        return isSuccessfull;
    }

    public boolean verifyUserCanSeeBeginVerificationBtn(){
        boolean isSuccessfull = false;
        implicitWait();
        if (btnBeginVerification.isDisplayed()){
            isSuccessfull = true;
        }

        return isSuccessfull;
    }

    public DashboardPage clickBeginVerificationSimpleStructureBtn(){
        btnBeginVerificationSimpleStructure.click();

        return this;
    }

    public DashboardPage clickChooseDocumentType(){
        btnChooseDocumentType.click();

        return this;
    }

    public boolean verifySuccessfullAccountConfirmation(){
        boolean isSuccessfull = false;
        implicitWait();
        if (textField.getText().equals("Latest Transactions")){
            isSuccessfull = true;
        }

        return isSuccessfull;
    }

    public DashboardPage clickRepresentativesBtn() {
        btnRepresentatives.click();

        return this;
    }

    public DashboardPage clickAddNewRepresentativesBtn() {
        btnAddNewRepresentatives.click();

        return this;
    }

    public DashboardPage enterEmailField() {
        fieldEnterEmail.sendKeys(testContextPersonal.getEmail());

        return this;
    }

    public DashboardPage clickNextBtn() {
        btnNext.click();

        return this;
    }

    public DashboardPage clickNextRepresentativeBtn() {
        btnNextRepresentative.click();

        return this;
    }

    public DashboardPage clickCheckBoxBtn() {
        btnCheckBox.click();

        return this;
    }

    public DashboardPage clickAddBtn() {
        btnAdd.click();

        return this;
    }

    public DashboardPage clickConfirmBtn() {
        btnConfirm.click();

        return this;
    }

    public DashboardPage clickYesBtn() {
        btnYes.click();

        return this;
    }

    public DashboardPage enterCompanyNameForRepresentative() {
        fieldEnterCompanyName.sendKeys("TestCompRepresentative");

        return this;
    }

    public DashboardPage enterEmailForRepresentative() {
        fieldEnterYourEmail.sendKeys(randomEmail);

        return this;
    }

    public DashboardPage clickOkBtn() {
        btnOk.click();

        return this;
    }

    public String getCreatedIbanAccount() {
        String s = fieldIbanAccount.getText();

        return s;
    }

}