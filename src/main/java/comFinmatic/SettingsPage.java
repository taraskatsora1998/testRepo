package comFinmatic;

import comFinmatic.dto.TestContextPersonal;
import comFinmatic.dto.TestContextBusiness;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingsPage extends AbstractComponents {

    public SettingsPage(WebDriver driver, TestContextPersonal testContextPersonal, TestContextBusiness testContextBusiness){
        super(driver, testContextPersonal, testContextBusiness);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@name='oldPassword']")
    WebElement fieldOldPaswword;

    @FindBy(xpath = "//input[@name='newPassword']")
    WebElement fieldNewPaswword;

    @FindBy(xpath = "//input[@name='repeatPassword']")
    WebElement fieldRepeatPaswword;

    @FindBy(xpath = "//button[.='Save']")
    WebElement btnSave;

    @FindBy(xpath = "//button[.='Yes']")
    WebElement btnYes;

    @FindBy(xpath = "//h2[.='Success!']")
    WebElement successNotification;

    public SettingsPage enterOldPassword() {
        fieldOldPaswword.sendKeys("Aa123b123-1");

        return this;
    }

    public SettingsPage enterNewPassword() {
        fieldNewPaswword.sendKeys("Aa123b123-2");

        return this;
    }

    public SettingsPage enterRepeatPassword() {
        fieldRepeatPaswword.sendKeys("Aa123b123-2");

        return this;
    }

    public SettingsPage clickSaveBtn() {
        btnSave.click();

        return this;
    }

    public SettingsPage clickYesBtn() {
        btnYes.click();

        return this;
    }

    public boolean verifySuccessfullyChangedPassword(){
        boolean isSuccessfull = false;
        implicitWait();
        if (successNotification.getText().equals("Success!")){
            isSuccessfull = true;
        }

        return isSuccessfull;
    }
}
