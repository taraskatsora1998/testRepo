package comFinmatic;

import comFinmatic.dto.TestContextBusiness;
import comFinmatic.dto.TestContextPersonal;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class PasswordRecoveryPage extends AbstractComponents{

    public PasswordRecoveryPage(WebDriver driver, TestContextPersonal testContextPersonal, TestContextBusiness testContextBusiness) {
        super(driver, testContextPersonal, testContextBusiness);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@class='security-cell']")
    List<WebElement> fieldSecurityCode;

    @FindBy(xpath = "//input[@name='password']")
    WebElement fieldNewPassword;

    @FindBy(xpath = "//input[@name='repeat_password']")
    WebElement fieldRepeatPassword;

    @FindBy(xpath = "//button")
    WebElement btnConfirm;

    @FindBy(xpath = "//*[contains(text(),'OK')]")
    WebElement btnOk;

    @FindBy(xpath = "//h2[.='Success!']")
    WebElement successNotification;

    By securityCode = By.xpath("//input[@class='security-cell']");

    public PasswordRecoveryPage enterSecurityCode() {
        ArrayList<String> all = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(all.get(2));
        waitForElementToBeVisible(securityCode);
        for (WebElement webElement : fieldSecurityCode) {
            webElement.sendKeys("1");
        }

        return this;
    }

    public PasswordRecoveryPage enterNewPassword(String newPassword){
        implicitWait();
        fieldNewPassword.sendKeys(newPassword);

        return this;
    }

    public PasswordRecoveryPage repeatPasswordField(String repeatPassword){
        fieldRepeatPassword.sendKeys(repeatPassword);

        return this;
    }

    public PasswordRecoveryPage clickConfirmBtn(){
        btnConfirm.click();

        return this;
    }

    public PasswordRecoveryPage clickOkBtn(){
        btnOk.click();

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
}