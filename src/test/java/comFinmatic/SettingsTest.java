package comFinmatic;

import comFinmatic.dto.TestContextPersonal;
import comFinmatic.dto.TestContextBusiness;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SettingsTest extends SetupClassTest{

    public static LoginPage loginPage;
    public static RegisterPage registerPage;
    public static DashboardPage dashboardPage;
    public static SettingsPage settingsPage;
    public static HeaderPage headerPage;

    @Test(groups= {"group1"},priority = 1)
    public void testResetPasswordPersonalAccountInSettings(){
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        dashboardPage = new DashboardPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        headerPage = new HeaderPage(driver, testContextPersonal, testContextBusiness);
        settingsPage = new SettingsPage(driver, testContextPersonal, testContextBusiness);

        loginPage
                .clickRegisterBtn();
        registerPage
                .clickCountryCodeBtn()
                .clickCountryBtn()
                .enterPhoneNumberPersonal()
                .enterPassword()
                .clickRegisterBtn()
                .enterSecurityCode()
                .clickPeprsonalAccountBtn()
                .enterFirstName("FirstName")
                .enterLastName("LastName")
                .enterEmailPersonal()
                .clickRegisterBtn()
                .enterSecurityCode()
                .rediretToLoginPage();
        loginPage
                .clickCountryCodeBtn()
                .clickCountryBtn()
                .enterPhoneNumberPersonal()
                .enterPassword()
                .clickLogInBtn()
                .enterSecurityCode();
        headerPage
                .clickSettingsBtn();
        settingsPage
                .enterOldPassword()
                .enterNewPassword()
                .enterRepeatPassword()
                .clickSaveBtn()
                .clickYesBtn();


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(settingsPage.verifySuccessfullyChangedPassword());
        softAssert.assertAll();
    }

    @Test(groups= {"group1"},priority = 2)
    public void testResetPasswordBusinessAccountInSettings(){
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        dashboardPage = new DashboardPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        headerPage = new HeaderPage(driver, testContextPersonal, testContextBusiness);
        settingsPage = new SettingsPage(driver, testContextPersonal, testContextBusiness);

        loginPage
                .clickRegisterBtn();
        registerPage
                .clickCountryCodeBtn()
                .clickCountryBtn()
                .enterPhoneNumberBusiness()
                .enterPassword()
                .clickRegisterBtn()
                .enterSecurityCode()
                .enterCompanyName("TestCompany")
                .enterEmailBusiness()
                .clickRegisterBtn()
                .enterSecurityCode()
                .rediretToLoginPage();
        loginPage
                .clickCountryCodeBtn()
                .clickCountryBtn()
                .enterPhoneNumberBusiness()
                .enterPassword()
                .clickLogInBtn()
                .enterSecurityCode();
        headerPage
                .clickSettingsBtn();
        settingsPage
                .enterOldPassword()
                .enterNewPassword()
                .enterRepeatPassword()
                .clickSaveBtn()
                .clickYesBtn();


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(settingsPage.verifySuccessfullyChangedPassword());
        softAssert.assertAll();
    }
}