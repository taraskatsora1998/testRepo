package comFinmatic;

import comFinmatic.dto.TestContextPersonal;
import comFinmatic.dto.TestContextBusiness;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage extends AbstractComponents{

    public HeaderPage(WebDriver driver, TestContextPersonal testContextPersonal, TestContextBusiness testContextBusiness){
        super(driver, testContextPersonal, testContextBusiness);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[.='Settings']")
    WebElement btnSettings;

    @FindBy(xpath = "//button[@class='icon-button']")
    WebElement btnLogOut;

    @FindBy(xpath = "//div[@role='button']/div")
    WebElement btnDropDown;

    @FindBy(xpath = "//*[contains(text(),'TestCompany')]")
    WebElement btnTestComp;

    @FindBy(xpath = "//input[@placeholder='John Doe']")
    WebElement getText;

    By dropDownText = By.xpath("//*[contains(@value,'TestComp')]");

    public HeaderPage clickSettingsBtn(){
        btnSettings.click();

        return this;
    }

    public HeaderPage clickLogOutBtn(){
        btnLogOut.click();

        return this;
    }

    public HeaderPage clickDropDownBtn() {
        btnDropDown.click();

        return this;
    }

    public HeaderPage clickTestComp() {
        btnTestComp.click();

        return this;
    }

    public String verifySuccessfullAccountSwitch(){
        waitForElementToBeVisible(dropDownText);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String textFromDropDown = (String) js.executeScript("return arguments[0].value", getText);

        return textFromDropDown;
    }
}