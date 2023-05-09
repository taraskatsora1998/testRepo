package comFinmatic;

import comFinmatic.dto.TestContextPersonal;
import comFinmatic.dto.TestContextBusiness;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashboardPage extends AbstractComponents {

    public DashboardPage(WebDriver driver, TestContextPersonal testContextPersonal, TestContextBusiness testContextBusiness) {
        super(driver, testContextPersonal, testContextBusiness);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@role='button']/div")
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

    @FindBy(xpath = "//a[@href='/new-payment']")
    WebElement btnNewPayment;

    @FindBy(xpath = "//input[@name='recipient_wallet']")
    WebElement fieldRecipientsIban;

    @FindBy(xpath = "//input[@name='amount']")
    WebElement fieldAmount;

    @FindBy(xpath = "//input[@name='comment']")
    WebElement fieldComment;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnSend;

    @FindBy(xpath = "//button[contains(text(),'Confirm')]")
    WebElement btnConfirmTransaction;

    @FindBy(xpath = "//input[@name='company_name']")
    WebElement fieldCompanyNameForTransaction;

    @FindBy(xpath = "//input[@name='account_number']")
    WebElement fieldAccountNumber;

    @FindBy(xpath = "//button[contains(text(),'Confirm')]")
    WebElement btnConfirmTransactionFinal;

    @FindBy(xpath = "(//div[@role='button']/div)[3]")
    WebElement fieldPaymentMethod;

    @FindBy(xpath = "//*[contains(text(),'SEPA Instant')]")
    WebElement btnSepaInstant;

    @FindBy(xpath = "//*[contains(text(),'Internal')]")
    WebElement btnInternal;

    @FindBy(xpath = "//*[contains(text(),'Internal Provider')]")
    WebElement btnInternalProvider;

    @FindBy(xpath = "(//*[contains(text(),'IBAN')])[1]")
    WebElement btnIban;

    @FindBy(xpath = "//*[contains(text(),'Faster Payments')]")
    WebElement btnFasterPayments;

    @FindBy(xpath = "//p[@class='alert-text']")
    WebElement allertText;

    @FindBy(xpath = "//*[contains(text(),'Personal Account')]")
    WebElement btnPersonal;

    @FindBy(xpath = "//input[@name='bank_name']")
    WebElement fieldBankName;

    @FindBy(xpath = "//input[@name='bank_country']")
    WebElement fieldBankCountry;

    @FindBy(xpath = "//input[@name='bic']")
    WebElement fieldBic;

    @FindBy(xpath = "//input[@name='company_name']")
    WebElement fieldCompanyName;

    @FindBy(xpath = "//input[@name='registration_number']")
    WebElement fieldRegistrationNumber;

    @FindBy(xpath = "//input[@name='beneficiary_city']")
    WebElement fieldRecipientsCity;

    @FindBy(xpath = "//label[@for='beneficiary_country']/..//div")
    WebElement fieldRecipientsCountry;

    @FindBy(xpath = "(//div[@class='input-icon eye '])[5]")
    WebElement fieldRecipientsCountryEur;

    @FindBy(xpath = "(//div[@class='input-icon eye '])[2]")
    WebElement fieldSelectIban;

    @FindBy(xpath = "//input[@name='beneficiary_post_code']")
    WebElement fieldPostCode;

    @FindBy(xpath = "//input[@name='beneficiary_address']")
    WebElement fieldRecipientsAddress;

    @FindBy(xpath = "//div[@class='input-wrapper icon input-dropdown-input']")
    WebElement fieldEnterCountry;

    @FindBy(xpath = "//div[@class='input-wrapper icon input-dropdown-input']")
    WebElement fieldEnterCountryRecipients;

    @FindBy(xpath = "//p[@class='dropdown-choice-value']")
    WebElement selectCountry;

    @FindBy(xpath = "(//div[@class='dropdown-choice'])[1]")
    WebElement clickCountryFromDropDown;

    @FindBy(xpath = "//label[contains(text(),'Account number*')]/..//div")
    WebElement btnAccountNumber;

    @FindBy(xpath = "//*[contains(text(),'GBXXCLJU04130780088730 EUR')]")
    WebElement btnEruIban;

    @FindBy(xpath = "//input[@name='sort_code']")
    WebElement fieldSortCode;

    @FindBy(xpath = "//div//button[@class='icon-button navigation-payment-button']")
    WebElement btnIbanTwo;

    @FindBy(xpath = "//div[@class='wrapper-balance']//p[@class='currency']")
    WebElement getCurrency;

    By dropDown = By.xpath("//*[contains(@class,'input-wrapper-dropdown active account-dropdown')]");
    By securityCode = By.xpath("//input[@class='security-cell']");
    By waitTextElement = By.xpath("//p[contains(text(),'Latest Transactions')]");
    By waitSendBtn = By.xpath("//button[@type='submit']");
    By waitInternalBtn = By.xpath("//*[contains(text(),'Internal')]");
    By waitRepresentativeBtn = By.xpath("//p[.='Representatives']");
    By waitNewPaymentBtn = By.xpath("//a[@href='/new-payment']");
    By waitSearchCountry = By.xpath("//div[@class='input-wrapper icon input-dropdown-input']");
    By waitFieldCompany = By.xpath("//input[@name='company_name']");

    public DashboardPage clickDropDownField() {
        waitForElementToBeVisible(dropDown);
        fieldDropDown.click();

        return this;
    }

    public DashboardPage clickOpenAnAccountBtn() {
        btnOpenAnAccount.click();

        return this;
    }

    public DashboardPage clickOpenAccountFromDashboardBtn() {
        implicitWait();
        btnOpenAccountFromDashboard.click();

        return this;
    }

    public DashboardPage enterCompanyName(String companyName) {
        fieldEnterCompanyName.sendKeys(companyName);

        return this;
    }

    public DashboardPage enterYourEmail() {
        fieldEnterYourEmail.sendKeys(testContextPersonal.getEmail());

        return this;
    }

    public DashboardPage clickRegisterBtn() {
        btnRegister.click();

        return this;
    }

    public DashboardPage enterSecurityCode() {
        waitForElementToBeVisible(securityCode);
        for (WebElement webElement : fieldSecurityCode) {
            webElement.sendKeys("1");
        }

        return this;
    }

    public DashboardPage clickPersonalAccountBtn() {
        btnPersonalAccount.click();

        return this;
    }

    public DashboardPage enterFirstName(String firstName) {
        fieldFirstName.sendKeys(firstName);

        return this;
    }

    public DashboardPage enterLastName(String lastName) {
        filedLastName.sendKeys(lastName);

        return this;
    }

    public boolean checkPersonalAccountBtnIsEnabled() {
        boolean isEnabled = false;
        if (radioGroup.getAttribute("class").contains("disabled-left")) {
            isEnabled = true;
        }
        return isEnabled;
    }

    public boolean verifySuccessfullSignUp() {
        boolean isSuccessfull = false;
        implicitWait();
        if (successNotification.getText().equals("Success!")) {
            isSuccessfull = true;
        }

        return isSuccessfull;
    }

    public boolean verifySuccessfullLogIn() {
        boolean isSuccessfull = false;
        implicitWait();
        if (btnDashboard.getText().equals("Dashboard")) {
            isSuccessfull = true;
        }

        return isSuccessfull;
    }

    public boolean verifyUserCanSeeBeginVerificationBtn() {
        boolean isSuccessfull = false;
        implicitWait();
        if (btnBeginVerification.isDisplayed()) {
            isSuccessfull = true;
        }

        return isSuccessfull;
    }

    public DashboardPage clickBeginVerificationSimpleStructureBtn() {
        btnBeginVerificationSimpleStructure.click();

        return this;
    }

    public DashboardPage clickChooseDocumentType() {
        btnChooseDocumentType.click();

        return this;
    }

    public boolean verifySuccessfullAccountConfirmation() {
        boolean isSuccessfull = false;
        waitForElementToBeVisible(waitTextElement);
        if (textField.getText().equals("Latest Transactions")) {
            isSuccessfull = true;
        }

        return isSuccessfull;
    }

    public DashboardPage clickRepresentativesBtn() {
        waitForElementToBeClickable(waitRepresentativeBtn);
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

    public DashboardPage clickNewPaymentBtn() {
        waitForElementToBeClickable(waitNewPaymentBtn);
        btnNewPayment.click();

        return this;
    }

    public DashboardPage enterRecipientsIban(String Iban) {
        fieldRecipientsIban.sendKeys(Iban);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB);
        actions.build().perform();

        return this;
    }

    public DashboardPage enterAmountField(String enterAmount) {
        fieldAmount.sendKeys(enterAmount);

        return this;
    }

    public DashboardPage enterComment() {
        fieldComment.sendKeys("Transfer Details");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.TAB);
        action.pause(4000);
        action.build().perform();

        return this;
    }

    public DashboardPage clickSendBtn() {
        waitForElementToBeClickable(waitSendBtn);
        Actions actions = new Actions(driver);
        actions.moveToElement(btnSend);
        actions.click();
        actions.build().perform();
        //btnSend.click();

        return this;
    }

    public DashboardPage clickConfirmTransactionBtn() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        btnConfirmTransaction.click();

        return this;
    }

    public DashboardPage enterCompanyNameForTransaction() {
        fieldCompanyNameForTransaction.sendKeys("CompTest");

        return this;
    }

    public DashboardPage clickConfirmTransactionFinalBtn() {
        btnConfirmTransactionFinal.click();

        return this;
    }

    public boolean verifySuccessfullTransaction() {
        boolean isSuccessfull = false;
        implicitWait();
        if (successNotification.getText().equals("Success!")) {
            isSuccessfull = true;
        }

        return isSuccessfull;
    }

    public DashboardPage clickPaymentMethod() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", fieldPaymentMethod);

        return this;
    }

    public DashboardPage clickSepaInstant() {
        btnSepaInstant.click();

        return this;
    }

    public DashboardPage clickInternal() {
        waitForElementToBeVisible(waitInternalBtn);
        btnInternal.click();

        return this;
    }


    public DashboardPage clickInternalProvider() {
        waitForElementToBeVisible(waitInternalBtn);
        btnInternalProvider.click();

        return this;
    }

    public DashboardPage clickIbanBtn() {
        btnIban.click();

        return this;
    }

    public DashboardPage clickFasterPayments() {
        btnFasterPayments.click();

        return this;
    }

    public DashboardPage clickPersonalAccount() {
        btnPersonal.click();

        return this;
    }

    public DashboardPage enterBankName() {
        fieldBankName.sendKeys("Bank Name");

        return this;
    }

    public DashboardPage enterAccountNumber() {
        fieldAccountNumber.sendKeys("8310329576");

        return this;
    }

    public DashboardPage enterBic() {
        fieldBic.sendKeys("CMFGUS33");

        return this;
    }

    public DashboardPage enterCompanyName() {
        waitForElementToBeClickable(waitFieldCompany);
        fieldCompanyName.sendKeys("Company Name");

        return this;
    }

    public DashboardPage enterRegistrationNumber() {
        fieldRegistrationNumber.sendKeys(testContextPersonal.getPnone());

        return this;
    }

    public DashboardPage enterRecipientsCity() {
        fieldRecipientsCity.sendKeys("Recipients CIty");

        return this;
    }

    public DashboardPage enterPostalCode() {
        fieldPostCode.sendKeys("12345");

        return this;
    }

    public DashboardPage enterRecipientsAddress() {
        fieldRecipientsAddress.sendKeys("Recipietns Address");

        return this;
    }

    public DashboardPage enterBankCountry() {
        fieldBankCountry.click();
        waitForElementToBeVisible(waitSearchCountry);
        fieldEnterCountry.sendKeys("Anguilla");
        selectCountry.click();

        return this;
    }

    public DashboardPage enterRecipientsCountry() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", fieldRecipientsCountry);
        waitForElementToBeVisible(waitSearchCountry);
        executor.executeScript("arguments[0].click();", clickCountryFromDropDown);
        return this;
    }

    public DashboardPage enterRecipientsCountryEur() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        fieldRecipientsCountryEur.click();
        waitForElementToBeVisible(waitSearchCountry);
        executor.executeScript("arguments[0].click();", clickCountryFromDropDown);
        return this;
    }

    public boolean verifyCorrectnessOfAlertMessage() {
        boolean isSuccessfull = false;
        implicitWait();
        if (allertText.getText().equals("Insufficient funds")) {
            isSuccessfull = true;
        }

        return isSuccessfull;
    }

    public DashboardPage selectIban() {
        fieldSelectIban.click();

        return this;
    }

    public DashboardPage clickAccountNumberBtn() {
        btnAccountNumber.click();

        return this;
    }

    public DashboardPage clickEurIban() {
        btnEruIban.click();

        return this;
    }

    public DashboardPage enterSortCode() {
        fieldSortCode.sendKeys("11-22-33");

        return this;
    }

    public DashboardPage clickSecondIbanBtn() {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", btnIbanTwo);

        return this;
    }

    public String getCurrencyText() {
        return getCurrency.getText();

    }
}