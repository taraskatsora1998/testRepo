package comFinmatic;

import comFinmatic.dto.TestContextPersonal;
import comFinmatic.dto.TestContextBusiness;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends SetupClassTest{
    public static LoginPage loginPage;
    public static DashboardPage dashboardPage;
    public static RegisterPage registerPage;

    @Test
    public void testCheckUserCanLoginPersonalAccount(){
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        dashboardPage = new DashboardPage(driver, testContextPersonal, testContextBusiness);
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
                .enterSecurityCode()
                .rediretToLoginPage();
        loginPage
                .clickCountryCodeBtn()
                .clickCountryBtn()
                .enterPhoneNumber()
                .enterPassword()
                .clickLogInBtn()
                .enterSecurityCode();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(dashboardPage.verifySuccessfullLogIn());
        softAssert.assertAll();
    }

    @Test
    public void testCheckUserCanLoginBussinessAccount(){
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        dashboardPage = new DashboardPage(driver, testContextPersonal, testContextBusiness);
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
                .enterSecurityCode()
                .clickLogInbtn();
        loginPage
                .clickCountryCodeBtn()
                .clickCountryBtn()
                .enterPhoneNumber()
                .enterPassword()
                .clickLogInBtn()
                .enterSecurityCode();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(dashboardPage.verifySuccessfullLogIn());
        softAssert.assertAll();
    }
}