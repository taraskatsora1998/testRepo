package comFinmatic;

import comFinmatic.dto.TestContextPersonal;
import comFinmatic.dto.TestContextBusiness;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ForgotPasswordTest extends SetupClassTest{
    public static LoginPage loginPage;
    public static RegisterPage registerPage;
    public static ForgotPasswordPage forgotPasswordPage;
    public static MailinatorPage mailinatorPage;

    @Test
    public void testForgotPasswordPersonalAccount() {
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        forgotPasswordPage = new ForgotPasswordPage(driver, testContextPersonal, testContextBusiness);
        mailinatorPage = new MailinatorPage(driver, testContextPersonal, testContextBusiness);

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
                .clickSuccessLogInBtn();
        loginPage
                .clickForgotPasswordBtn();
        forgotPasswordPage
                .clickCountryCodeBtn()
                .clickCountryBtn()
                .clickSubmitBtn()
                .enterPhoneNumberPersonal()
                .clickSubmitBtn()
                .enterSecurityCode()
                .enterEmailPersonal()
                .clickSendAccountEmailBtn();
        mailinatorPage
                .navigateNewTab()
                .enterEmailPersonal()
                .clickGoBtn()
                .clickEmailBtn()
                .navigatePreviousTab();
        forgotPasswordPage
                .enterNewPassword("Aa123b123-3")
                .repeatPasswordField("Aa123b123-3")
                .clickConfirmBtn();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(forgotPasswordPage.verifySuccessfullSignUp());
        softAssert.assertAll();
    }

    @Test
    public void testForgotPasswordWithEMailPhoneBusinessAccount() {
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        forgotPasswordPage = new ForgotPasswordPage(driver, testContextPersonal, testContextBusiness);
        mailinatorPage = new MailinatorPage(driver, testContextPersonal, testContextBusiness);

        loginPage
                .clickRegisterBtn();
        registerPage
                .clickCountryCodeBtn()
                .clickCountryBtn()
                .enterPhoneNumberBusiness()
                .enterPassword()
                .clickRegisterBtn()
                .enterSecurityCode()
                .enterCompanyName("TestComp")
                .enterEmailBusiness()
                .clickRegisterBtn()
                .enterSecurityCode()
                .clickLogInbtn();
        loginPage
                .clickForgotPasswordBtn();
        forgotPasswordPage
                .clickCountryCodeBtn()
                .clickCountryBtn()
                .enterPhoneNumberBusiness()
                .clickSubmitBtn()
                .enterSecurityCode()
                .enterEmailBusiness()
                .clickSendAccountEmailBtn();
        mailinatorPage
                .navigateNewTab()
                .enterEmailBusiness()
                .clickGoBtn()
                .clickEmailBtn()
                .navigatePreviousTab();
        forgotPasswordPage
                .enterNewPassword("Aa123b123-3")
                .repeatPasswordField("Aa123b123-3")
                .clickConfirmBtn();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(forgotPasswordPage.verifySuccessfullSignUp());
        softAssert.assertAll();
    }

    @Test
    public void testForgotPasswordWithEmailPhonePersonalAccount() {
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        forgotPasswordPage = new ForgotPasswordPage(driver, testContextPersonal, testContextBusiness);
        mailinatorPage = new MailinatorPage(driver, testContextPersonal, testContextBusiness);

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
                .enterFirstName("Test")
                .enterLastName("Test")
                .enterEmailPersonal()
                .clickRegisterBtn()
                .enterSecurityCode()
                .clickSuccessLogInBtn();
        loginPage
                .clickForgotPasswordBtn();
        forgotPasswordPage
                .clickCountryCodeBtn()
                .clickCountryBtn()
                .clickSubmitBtn()
                .enterPhoneNumberPersonal()
                .clickSubmitBtn()
                .enterSecurityCode()
                .enterEmailPersonal()
                .clickSendAccountEmailBtn();
        mailinatorPage
                .navigateNewTab()
                .enterEmailPersonal()
                .clickGoBtn()
                .clickEmailBtn()
                .navigatePreviousTab();
        forgotPasswordPage
                .enterNewPassword("Aa123b123-3")
                .repeatPasswordField("Aa123b123-3")
                .clickConfirmBtn()
                .verifySuccessfullSignUp();
    }

    @Test
    public void testForgotPasswordWithOutEmail() {
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        forgotPasswordPage = new ForgotPasswordPage(driver, testContextPersonal, testContextBusiness);
        mailinatorPage = new MailinatorPage(driver, testContextPersonal, testContextBusiness);

        loginPage
                .clickRegisterBtn();
        registerPage
                .clickCountryCodeBtn()
                .clickCountryBtn()
                .enterPhoneNumberPersonal()
                .enterPassword()
                .clickRegisterBtn()
                .enterSecurityCode()
                .rediretToLoginPage();
        loginPage
                .clickForgotPasswordBtn();
        forgotPasswordPage
                .clickCountryCodeBtn()
                .clickCountryBtn()
                .clickSubmitBtn()
                .enterPhoneNumberPersonal()
                .clickSubmitBtn()
                .enterSecurityCode()
                .enterNewPassword("Aa123b123-3")
                .repeatPasswordField("Aa123b123-3")
                .clickConfirmBtn()
                .verifySuccessfullSignUp();
    }
}