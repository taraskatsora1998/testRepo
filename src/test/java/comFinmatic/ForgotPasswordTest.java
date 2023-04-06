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
                .enterPhoneNumber()
                .enterPassword()
                .clickRegisterBtn()
                .enterSecurityCode()
                .clickPeprsonalAccountBtn()
                .enterFirstName("FirstName")
                .enterLastName("LastName")
                .enterEmail()
                .clickRegisterBtn()
                .enterSecurityCode()
                .clickSuccessLogInBtn();
        loginPage
                .clickForgotPasswordBtn();
        forgotPasswordPage
                .clickCountryCodeBtn()
                .clickCountryBtn()
                .clickSubmitBtn()
                .enterPhoneNumber()
                .clickSubmitBtn()
                .enterSecurityCode()
                .enterEmail()
                .clickSendAccountEmailBtn();
        mailinatorPage
                .navigateNewTab()
                .enterEmail()
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
    public void testForgotPasswordBusinessAccount() {
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
                .enterPhoneNumber()
                .enterPassword()
                .clickRegisterBtn()
                .enterSecurityCode()
                .rediretToLoginPage();
        loginPage
                .clickForgotPasswordBtn();
        forgotPasswordPage
                .clickCountryCodeBtn()
                .clickCountryBtn()
                .enterPhoneNumber()
                .clickSubmitBtn()
                .enterSecurityCode()
                .enterNewPassword("Aa123b123-3")
                .repeatPasswordField("Aa123b123-3")
                .clickConfirmBtn();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(forgotPasswordPage.verifySuccessfullSignUp());
        softAssert.assertAll();
    }

    @Test
    public void testForgotPasswordWithoutAccount() {
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
                .enterPhoneNumber()
                .enterPassword()
                .clickRegisterBtn()
                .enterSecurityCode()
                .enterCompanyName("TestCompany")
                .enterEmail()
                .clickRegisterBtn()
                .enterSecurityCode()
                .clickSuccessLogInBtn();
        loginPage
                .clickForgotPasswordBtn();
        forgotPasswordPage
                .clickCountryCodeBtn()
                .clickCountryBtn()
                .clickSubmitBtn()
                .enterPhoneNumber()
                .clickSubmitBtn()
                .enterSecurityCode()
                .enterEmail()
                .clickSendAccountEmailBtn();
        mailinatorPage
                .navigateNewTab()
                .enterEmail()
                .clickGoBtn()
                .clickEmailBtn()
                .navigatePreviousTab();
        forgotPasswordPage
                .enterNewPassword("Aa123b123-3")
                .repeatPasswordField("Aa123b123-3")
                .clickConfirmBtn()
                .verifySuccessfullSignUp();
    }
}