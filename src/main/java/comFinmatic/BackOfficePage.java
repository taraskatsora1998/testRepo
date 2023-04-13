package comFinmatic;

import comFinmatic.dto.TestContextPersonal;
import comFinmatic.dto.TestContextBusiness;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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

    // @FindBy(xpath = "(//td[@scope='row'])[1]")
    @FindBy(xpath = "(//a)[20]")
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

    @FindBy(xpath = "(//*[contains(text(),'Add')])[11]")
    WebElement btnAdd;

    @FindBy(xpath = "//button[contains(text(),'OK')]")
    WebElement btnOkProvider;

    @FindBy(xpath = "//button[contains(text(),'OK')]")
    WebElement btnOkWallet;

    @FindBy(xpath = "(//*[@class='custom-checkbox custom-control'])[1]")
    WebElement btnCheckbox;

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

    By userBtn = By.xpath("//span[contains(text(),'User')]");
    By fieldKycStatusBy = By.xpath("//select[@id='kycStatus']");

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
        waitForElementToBeVisible(userBtn);
        btnUser.click();

        return this;
    }

    public BackOfficePage selectUserStatus(String userStatus){
        selectUserStatus.click();
        selectValueFromDropdown(selectUserStatus,userStatus);

        return this;
    }

    public BackOfficePage clickUserAccountBtn(){
        btnAccount.click();

        return this;
    }

    public BackOfficePage selectKYCStatus(){
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
        return getValueSelected(fieldUserStatusBusiness);
    }

    public String verifyUserKycStatus(){
        //waitForElementToContains(fieldKycStatusBy);
        return getValueSelected(fieldKycStatus);

    }

    public BackOfficePage selectKycStatus(String userStatus){
        selectValueFromDropdown(fieldKycStatus,userStatus);

        return this;
    }

    public BackOfficePage clickWalletsBtn(){
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
        btnOkProvider.click();

        return this;
    }

    public BackOfficePage clickOkWallet(){
        btnOkWallet.click();

        return this;
    }

    public BackOfficePage clickCheckboxBtn(){
        btnCheckbox.click();

        return this;
    }

    public String getCreatedIban() {
        String s = fieldIban.getText();

        return s;
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
}