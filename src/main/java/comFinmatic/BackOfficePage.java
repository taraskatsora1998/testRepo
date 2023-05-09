package comFinmatic;

import comFinmatic.dto.TestContextPersonal;
import comFinmatic.dto.TestContextBusiness;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class BackOfficePage extends AbstractComponents{

    public BackOfficePage(WebDriver driver, TestContextPersonal testContextPersonal, TestContextBusiness testContextBusiness){
        super(driver, testContextPersonal, testContextBusiness);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@id='inputEmail']")
    WebElement fieldLogin;

    @FindBy(xpath = "//input[@id='inputPass']")
    WebElement fieldPassword;

    @FindBy(xpath = "//button")
    WebElement btnLogIn;

    @FindBy(xpath = "(//td[@class='valign-middle']//a)[1]")
    WebElement btnAccountIdBtn;

    @FindBy(xpath = "//span[contains(text(),'User')]")
    WebElement btnUser;

    @FindBy(xpath = "//select[@id='basicUserStatus']")
    WebElement selectUserStatus;

    @FindBy(xpath = "//span[contains(text(),'Account')]")
    WebElement btnAccount;

    @FindBy(xpath = "//select[@id='kycStatus']")
    WebElement selectKYCStatus;

    @FindBy(xpath = "//input[@name='registrationNumber']")
    WebElement fieldRegistrationNumber;

    @FindBy(xpath = "//select[@id='entityLegalType']")
    WebElement selectLegalEntity;

    @FindBy(xpath = "(//button[contains(text(),'Save changes')])[2]")
    WebElement btnSaveChangesUser;

    @FindBy(xpath = "//button[@class='swal2-confirm swal2-styled']")
    WebElement btnOk;

    @FindBy(xpath = "//input[@name='characteristics']")
    WebElement fieldBusinessActivity;

    @FindBy(xpath = "(//button[contains(text(),'Save changes')])[1]")
    WebElement getBtnSaveChangesAccount;

    @FindBy(xpath = "(//button[@class='btn btn-primary'])[3]")
    WebElement btnSave;

    @FindBy(xpath = "//select[@id='basicUserStatus']")
    WebElement fieldUserStatusBusiness;

    @FindBy(xpath = "(//select[@type='select'])[1]")
    WebElement fieldUserStatus;

    @FindBy(xpath = "//select[@id='kycStatus']")
    WebElement fieldKycStatus;

    @FindBy(xpath = "//span[contains(text(),'Wallets')]")
    WebElement btnWallets;

    @FindBy(xpath = "//button[contains(text(),'Add Wallet')]")
    WebElement btnAddWallet;

    @FindBy(xpath = "//select[@id='payment_provider_select']")
    WebElement selectPaymentProvider;

    @FindBy(xpath = "//select[@id='currency_select']")
    WebElement selectCurrency;

    @FindBy(xpath = "(//button[contains(text(),'Create')])[2]")
    WebElement btnCreate;

    @FindBy(xpath = "//span[contains(text(),'Providers')]")
    WebElement btnProviders;

    @FindBy(xpath = "//button[contains(text(),'Add Provider')]")
    WebElement btnAddProvider;

    @FindBy(xpath = "//select[@id='provider-modal-provider']")
    WebElement selectProvider;

    @FindBy(xpath = "//div[@class='modal-footer']/button[@class='btn btn-primary']")
    WebElement btnAdd;

    @FindBy(xpath = "//button[contains(text(),'OK')]")
    WebElement btnOkProvider;

    @FindBy(xpath = "//button[contains(text(),'OK')]")
    WebElement btnOkWallet;

    @FindBy(xpath = "(//*[@class='custom-checkbox custom-control'])[1]")
    WebElement btnCheckbox;

    @FindBy(xpath = "(//*[@class='custom-checkbox custom-control'])[2]")
    WebElement btnCheckboxEur;

    @FindBy(xpath = "(//*[@class=\"text-center\"])[2]/../td[2]")
    WebElement fieldIban;

    @FindBy(xpath = "//select[@id='accountStatus']")
    WebElement selectAccountStatus;

    @FindBy(xpath = "//button[contains(text(),'Reset password')]")
    WebElement btnResetPswrd;

    @FindBy(xpath = "//button[contains(text(),'Yes')]")
    WebElement btnYes;

    @FindBy(xpath = "//button[contains(text(),'OK')]")
    WebElement btnOkResetPswrd;

    @FindBy(xpath = "//select[@id='addressCountry']")
    WebElement selectCountry;

    @FindBy(xpath = "//input[@name='address']")
    WebElement fieldAddress;

    @FindBy(xpath = "//input[@name='zip']")
    WebElement fieldZip;

    @FindBy(xpath = "//input[@name='addressCity']")
    WebElement fieldAddressCity;

    @FindBy(xpath = "//input[@name='address']")
    WebElement fieldLegalAddress;

    @FindBy(xpath = "//input[@name='zipCode']")
    WebElement fieldLegalZipCode;

    @FindBy(xpath = "//input[@name='city']")
    WebElement fieldLegalAddressCity;

    @FindBy(xpath = "(//select[@id='addressCountry'])[2]")
    WebElement selectOfficeAddress;

    @FindBy(xpath = "//input[@name='companyName']")
    WebElement enterCompanyName;

    @FindBy(xpath = "//button[contains(text(),'Add Currency')]")
    WebElement btnAddCurrency;

    By userBtn = By.xpath("//span[contains(text(),'User')]");
    By btnWalletsWait = By.xpath("//span[contains(text(),'Wallets')]");
    By btnCheckBoxWait = By.xpath("(//*[@class='custom-checkbox custom-control'])[1]");
    By btnCheckBoxEurWait = By.xpath("(//*[@class='custom-checkbox custom-control'])[2]");
    By waitBtnSaveChangesUser = By.xpath("(//button[contains(text(),'Save changes')])[2]");
    By waitFieldZip = By.xpath("//input[@name='zip']");

    public BackOfficePage enterLoginFiled(){
        fieldLogin.sendKeys("operator@finmatic.net");

        return this;
    }

    public BackOfficePage enterPassword(){
        fieldPassword.sendKeys("MainOper1");

        return this;
    }

    public BackOfficePage clickLoginBtn(){
        btnLogIn.click();

        return this;
    }

    public BackOfficePage redirectToBackOfficePage(){
        getRequiredEnvLinkBO();

        return this;
    }

    public BackOfficePage clickAccountIdBtn(){
        implicitWait();
        btnAccountIdBtn.click();

        return this;
    }

    public BackOfficePage clickUserBtn(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        btnUser.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public BackOfficePage selectUserStatus(String userStatus){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        selectUserStatus.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        selectValueFromDropdown(selectUserStatus,userStatus);

        return this;
    }

    public BackOfficePage clickUserAccountBtn(){
        btnAccount.click();

        return this;
    }

    public BackOfficePage selectKYCStatus(){
        selectKYCStatus.click();
        selectValueFromDropdown(selectKYCStatus,"VERIFIED");

        return this;
    }

    public BackOfficePage enterRegistrationNumber(){
        fieldRegistrationNumber.sendKeys(testContextPersonal.getRegistrationNumber());

        return this;
    }

    public BackOfficePage selectLegalEntity(){
        selectValueFromDropdown(selectLegalEntity,"IT");

        return this;
    }

    public BackOfficePage clickSaveChangesUserBtn(){
        waitForElementToBeClickable(waitBtnSaveChangesUser);
        btnSaveChangesUser.click();

        return this;
    }

    public BackOfficePage clickOkBtn(){
        btnOk.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public BackOfficePage redirectToTheLoginPage(){
        getRequiredEnvLinkWebSite();

        return this;
    }

    public BackOfficePage enterBusinessActivity(){
        fieldBusinessActivity.sendKeys("BusinessActivity");

        return this;
    }

    public BackOfficePage clickSaveChangesAccountBtn(){
        getBtnSaveChangesAccount.click();

        return this;
    }

    public BackOfficePage clickSaveBtn(){
        btnSave.click();

        return this;
    }

    public String verifyUserStatusPersonalAccount(){
        return getValueSelected(fieldUserStatus);

    }

    public String verifyUserStatusBusinessAccount(){
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return getValueSelected(fieldUserStatusBusiness);
    }

    public String verifyUserKycStatus(){
        return getValueSelected(fieldKycStatus);

    }

    public BackOfficePage selectKycStatus(String userStatus){
        selectValueFromDropdown(fieldKycStatus,userStatus);

        return this;
    }

    public BackOfficePage clickWalletsBtn(){
        waitForElementToBeClickable(btnWalletsWait);
        btnWallets.click();

        return this;
    }

    public BackOfficePage clickAddWalletBtn(){
        btnAddWallet.click();

        return this;
    }

    public BackOfficePage selectPaymentProvider(String paymentProvider) {
        selectValueFromDropdown(selectPaymentProvider,paymentProvider);

        return this;
    }

    public BackOfficePage selectCurrency(String currency) {
        selectValueFromDropdown(selectCurrency,currency);

        return this;
    }

    public BackOfficePage clickCreateBtn() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        btnCreate.click();

        return this;
    }

    public BackOfficePage clickProvidersBtn(){
        btnProviders.click();

        return this;
    }

    public BackOfficePage clickAddProvider(){
        btnAddProvider.click();

        return this;
    }

    public BackOfficePage selectProvider(String provider) {
        selectValueFromDropdown(selectProvider,provider);

        return this;
    }

    public BackOfficePage clickAddBtn(){
        btnAdd.click();

        return this;
    }

    public BackOfficePage clickOkProvider(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        btnOkProvider.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public BackOfficePage clickOkWallet(){
        waitForElementToBeVisible(btnWalletsWait);
        btnOkWallet.click();

        return this;
    }

    public BackOfficePage clickCheckboxBtn(){
        waitForElementToBeVisible(btnCheckBoxWait);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        btnCheckbox.click();

        return this;
    }

    public BackOfficePage clickCheckboxBtnEur(){
        waitForElementToBeVisible(btnCheckBoxEurWait);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        btnCheckboxEur.click();

        return this;
    }

    public BackOfficePage selectAccountStatus(String accountStatus) {
        selectValueFromDropdown(selectAccountStatus,accountStatus);

        return this;
    }

    public BackOfficePage clickResetPswrdBtn() {
        btnResetPswrd.click();

        return this;
    }

    public BackOfficePage clickYesBtn() {
        btnYes.click();

        return this;
    }

    public BackOfficePage clickOkResetPswrd(){
        btnOkResetPswrd.click();

        return this;
    }

    public BackOfficePage selectAddressCountry(String addressCountry){
        selectCountry.click();
        selectValueFromDropdown(selectCountry,addressCountry);

        return this;
    }

    public BackOfficePage enterAddressField() {
        fieldAddress.sendKeys("Address");

        return this;
    }

    public BackOfficePage enterZip() {
        waitForElementToBeClickable(waitFieldZip);
        fieldZip.sendKeys("12345");

        return this;
    }

    public BackOfficePage enterAddressCity() {
        fieldAddressCity.sendKeys("Address City");

        return this;
    }

    public BackOfficePage enterLegalAddress() {
        fieldLegalAddress.sendKeys("LegalAddress");

        return this;
    }

    public BackOfficePage enterZipCode() {
        fieldLegalZipCode.sendKeys("12345");

        return this;
    }

    public BackOfficePage enterLegalAddressCity() {
        fieldLegalAddressCity.sendKeys("Legal Address City");

        return this;
    }

    public BackOfficePage selectOfficeAddressCountry() {
        selectValueFromDropdown(selectOfficeAddress,"AI");

        return this;
    }

    public BackOfficePage enterCompanyName() {
        enterCompanyName.clear();
        enterCompanyName.sendKeys("CompName" + testContextBusiness.getPnoneBusiness());

        return this;
    }

    public BackOfficePage clickAddCurrency() {
        btnAddCurrency.click();
        return this;
    }


}