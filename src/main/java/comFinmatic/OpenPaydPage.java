package comFinmatic;

import comFinmatic.dto.TestContextBusiness;
import comFinmatic.dto.TestContextPersonal;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.awt.SystemColor.window;

public class OpenPaydPage extends AbstractComponents {

    public OpenPaydPage(WebDriver driver, TestContextPersonal testContextPersonal, TestContextBusiness testContextBusiness) {
        super(driver, testContextPersonal, testContextBusiness);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='combined-app__email']")
    WebElement fieldEmailAddress;

    @FindBy(xpath = "//button[@opde='login-button']")
    WebElement btnContinue;

    @FindBy(xpath = "//input[@id='signup__input--password']")
    WebElement fieldPassword;

    @FindBy(xpath = "//button[@data-testid='btn_sign_in']")
    WebElement btnSignIn;

    @FindBy(xpath = "//*[contains(text(),'Linked Clients')]")
    WebElement btnLinkedClients;

    @FindBy(xpath = "(//*[contains(text(),'Clients')])[2]")
    WebElement btnClients;

    @FindBy(xpath = "(//button[@opdbutton='link'])[1]")
    WebElement btnLoginAsClient;

    @FindBy(xpath = "(//td)[1]")
    WebElement fieldAccounts;

    @FindBy(xpath = "//button[@data-testid='btn_view_statement']")
    WebElement btnActions;

    @FindBy(xpath = "//button[@data-testid='btn_simulate_payin']")
    WebElement btnSimulatePayIn;

    @FindBy(xpath = "//input[@data-testid='input_amount']")
    WebElement fieldEnterAmount;

    @FindBy(xpath = "(//input[@data-testid='input_reference'])[2]")
    WebElement fieldEnterReference;

    @FindBy(xpath = "//input[@data-testid='input_sender_address']")
    WebElement fieldSenderAddress;

    @FindBy(xpath = "//button[@data-testid='btn_create_payin']")
    WebElement btnCreatePayIn;

    @FindBy(xpath = "//button[@id='confirm_delete_button']")
    WebElement btnClose;

    By waitClientsBtn = By.xpath("(//*[contains(text(),'Clients')])[2]");
    By waitAccountsBtn = By.xpath("//tr[@data-testid='row_account_0']");
    By waitCreatePayInBtn = By.xpath("//button[@data-testid='btn_create_payin']");
    By waitLinkedClientsBtn = By.xpath("//*[contains(text(),'Linked Clients')]");
    By waitCloseBtn = By.xpath("//button[@id='confirm_delete_button']");

    public OpenPaydPage enterEmailField() {
        fieldEmailAddress.sendKeys("ar@transferra.uk");

        return this;
    }

    public OpenPaydPage clickContinueBtn() {
        btnContinue.click();

        return this;
    }

    public OpenPaydPage enterPasswordField() {
        fieldPassword.sendKeys("De2zH7WC8nX@M5D");

        return this;
    }

    public OpenPaydPage clickSignInBtn() {
        btnSignIn.click();

        return this;
    }

    public OpenPaydPage clickLinkedClientsBtn() {
        try {
            Boolean checkBtnClose = btnClose.isDisplayed();
            if (checkBtnClose == true) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnClose);
                waitForElementToBeClickable(waitLinkedClientsBtn);
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnLinkedClients);
            } else {
                waitForElementToBeClickable(waitLinkedClientsBtn);
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnLinkedClients);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnLinkedClients);

        return this;
    }

    public OpenPaydPage clickClientsBtn() {
        waitForElementToBeVisible(waitClientsBtn);
        btnClients.click();

        return this;
    }

    public OpenPaydPage redirectToOpenPayd() {
        getRequiredEnvLinkOP();

        return this;
    }

    public OpenPaydPage clickLoginAsCustomerBtn() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            btnLoginAsClient.click();
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            btnLoginAsClient.click();
        }
        return this;
    }

    public OpenPaydPage clickAccountBtn() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(550,650)");

        waitForElementToBeClickable(waitAccountsBtn);
        fieldAccounts.click();

        return this;
    }

    public OpenPaydPage clickActionsBtn() {
        //driver.findElement(By.tagName("body")).sendKeys(Keys.HOME);
        Actions actions = new Actions(driver);
        actions.moveToElement(btnActions).click().build().perform();

        return this;
    }

    public OpenPaydPage clickSimulatePayInBtn() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnSimulatePayIn);

        return this;
    }

    public OpenPaydPage enterAmount() {
        fieldEnterAmount.sendKeys("100000");

        return this;
    }

    public OpenPaydPage enterReference() {
        fieldEnterReference.sendKeys("Reference");

        return this;
    }

    public OpenPaydPage enterSenderAddress() {
        fieldSenderAddress.sendKeys("SenderAddress");

        return this;
    }

    public OpenPaydPage redirectToTheLoginPage() {
        getRequiredEnvLinkWebSite();

        return this;
    }

    public OpenPaydPage clickCreatePayInBtn() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        btnCreatePayIn.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public OpenPaydPage clickCloseBtn() {
        waitForElementToBeClickable(waitCloseBtn);
        if (btnClose.isDisplayed()) {
            btnClose.click();
        }

        return this;
    }
}
