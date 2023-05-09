package comFinmatic;

import comFinmatic.dto.TestContextPersonal;
import comFinmatic.dto.TestContextBusiness;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ForgotPasswordTest extends SetupClassTest {
    public static LoginPage loginPage;
    public static RegisterPage registerPage;
    public static ForgotPasswordPage forgotPasswordPage;
    public static OutlookPage outlookPage;

    @Test(groups= {"group2"},priority = 1)
    public void testForgotPasswordPersonalAccount() {
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        forgotPasswordPage = new ForgotPasswordPage(driver, testContextPersonal, testContextBusiness);
        outlookPage = new OutlookPage(driver, testContextPersonal, testContextBusiness);

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
        outlookPage
                .navigateNewTabb()
                .enterEMail()
                .clickNextBtn()
                .enterPassword()
                .clickNextBtn()
                .clickYesBtn()
                .clickMenuBtn()
                .clickOutlookBtn()
                .clickJunkMail()
                .clickResetPswrdEmailBtn()
                .clickReadUnreadBtn()
                .navigatePreviousTab();
        forgotPasswordPage
                .enterNewPassword("Aa123b123-3")
                .repeatPasswordField("Aa123b123-3")
                .clickConfirmBtn();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(forgotPasswordPage.verifySuccessfullSignUp());
        softAssert.assertAll();
    }

    @Test(groups= {"group2"},priority = 2)
    public void testForgotPasswordWithEMailPhoneBusinessAccount() {
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        forgotPasswordPage = new ForgotPasswordPage(driver, testContextPersonal, testContextBusiness);
        outlookPage = new OutlookPage(driver, testContextPersonal, testContextBusiness);

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
        outlookPage
                .navigateNewTabb()
                .enterEMail()
                .clickNextBtn()
                .enterPassword()
                .clickNextBtn()
                .clickYesBtn()
                .clickMenuBtn()
                .clickOutlookBtn()
                .clickJunkMail()
                .clickResetPswrdEmailBtn()
                .clickReadUnreadBtn()
                .navigatePreviousTab();
        forgotPasswordPage
                .enterNewPassword("Aa123b123-2")
                .repeatPasswordField("Aa123b123-3")
                .clickConfirmBtn();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(forgotPasswordPage.verifySuccessfullSignUp());
        softAssert.assertAll();
    }

    @Test(groups= {"group2"},priority = 3)
    public void testForgotPasswordWithEmailPhonePersonalAccount() {
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        forgotPasswordPage = new ForgotPasswordPage(driver, testContextPersonal, testContextBusiness);
        outlookPage = new OutlookPage(driver, testContextPersonal, testContextBusiness);

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
        outlookPage
                .navigateNewTabb()
                .enterEMail()
                .clickNextBtn()
                .enterPassword()
                .clickNextBtn()
                .clickYesBtn()
                .clickMenuBtn()
                .clickOutlookBtn()
                .clickJunkMail()
                .clickResetPswrdEmailBtn()
                .clickReadUnreadBtn()
                .navigatePreviousTab();
        forgotPasswordPage
                .enterNewPassword("Aa123b123-3")
                .repeatPasswordField("Aa123b123-3")
                .clickConfirmBtn()
                .verifySuccessfullSignUp();
    }

    @Test(groups= {"group1"},priority = 4)
    public void testForgotPasswordWithOutEmail() {
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        forgotPasswordPage = new ForgotPasswordPage(driver, testContextPersonal, testContextBusiness);

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