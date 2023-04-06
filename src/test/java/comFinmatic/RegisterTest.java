package comFinmatic;

import comFinmatic.dto.TestContextPersonal;
import comFinmatic.dto.TestContextBusiness;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RegisterTest extends SetupClassTest{
    public static LoginPage loginPage;
    public static RegisterPage registerPage;
    public static DashboardPage dashboardPage;

    @Test
    public void testRegistrationPersonalAccount(){
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);

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
                .enterSecurityCode();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(registerPage.verifySuccessfullSignUp());
        softAssert.assertAll();
    }

    @Test
    public void testRegistrationBussinessAccount(){
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);

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
                .enterSecurityCode();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(registerPage.verifySuccessfullSignUp());
        softAssert.assertAll();
    }

    @Test
    public void testRegistrationWithoutAccountBussinessAccount(){
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        dashboardPage = new DashboardPage(driver, testContextPersonal, testContextBusiness);

        loginPage
                .clickRegisterBtn();
        registerPage
                .clickCountryCodeBtn()
                .clickCountryBtn()
                .enterPhoneNumber()
                .enterPassword()
                .clickRegisterBtn()
                .enterSecurityCode()
                .rediretToLoginPage()
                .clickCountryCodeBtn()
                .clickCountryBtn()
                .enterPhoneNumber()
                .enterPassword();
        loginPage
                .clickLogInBtn()
                .enterSecurityCode();
        dashboardPage
                .clickOpenAccountFromDashboardBtn()
                .enterCompanyName("TestCompany")
                .enterYourEmail()
                .clickRegisterBtn()
                .enterSecurityCode();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(dashboardPage.verifySuccessfullSignUp());
        softAssert.assertAll();
    }

    @Test
    public void testRegistrationWithoutAccountPersonalAccount(){
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        dashboardPage = new DashboardPage(driver, testContextPersonal, testContextBusiness);

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
                .clickCountryCodeBtn()
                .clickCountryBtn()
                .enterPhoneNumber()
                .enterPassword()
                .clickLogInBtn()
                .enterSecurityCode();
        dashboardPage
                .clickOpenAccountFromDashboardBtn()
                .clickPersonalAccountBtn()
                .enterFirstName("FirstName")
                .enterLastName("LastName")
                .enterYourEmail()
                .clickRegisterBtn()
                .enterSecurityCode();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(dashboardPage.verifySuccessfullSignUp());
        softAssert.assertAll();
    }
}