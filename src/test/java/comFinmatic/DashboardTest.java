package comFinmatic;

import comFinmatic.dto.TestContextPersonal;
import comFinmatic.dto.TestContextBusiness;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DashboardTest extends SetupClassTest{

    public static LoginPage loginPage;
    public static RegisterPage registerPage;
    public static DashboardPage dashboardPage;
    public static BackOfficePage backOfficePage;
    public static MailinatorPage mailinatorPage;
    public static HeaderPage headerPage;


    @Test(priority = 1)
    public void testCheckPersonalAccountCanSeeVerificationBtn(){
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

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(dashboardPage.verifyUserCanSeeBeginVerificationBtn());
        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void testCheckBusinessAccountCanSeeVerificationBtn(){
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
                .enterPhoneNumberBusiness()
                .enterPassword()
                .clickRegisterBtn()
                .enterSecurityCode()
                .enterCompanyName("TestCompany")
                .enterEmailBusiness()
                .clickRegisterBtn()
                .enterSecurityCode()
                .clickLogInbtn();
        loginPage
                .clickCountryCodeBtn()
                .clickCountryBtn()
                .enterPhoneNumberBusiness()
                .enterPassword()
                .clickLogInBtn()
                .enterSecurityCode();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(dashboardPage.verifyUserCanSeeBeginVerificationBtn());
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void testCheckBusinessAccountCanCompleteVerification(){
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        dashboardPage = new DashboardPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        backOfficePage = new BackOfficePage(driver, testContextPersonal, testContextBusiness);

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
                .enterSecurityCode();
        backOfficePage
                .redirectToBackOfficePage()
                .enterLoginFiled()
                .enterPassword()
                .clickLoginBtn()
                .clickAccountIdBtn()
                .clickUserBtn()
                .selectUserStatus("ADMINISTRATE")
                .clickSaveChangesUserBtn()
                .clickOkBtn()
                .clickUserAccountBtn()
                .selectKYCStatus()
                .enterRegistrationNumber()
                .selectLegalEntity()
                .enterBusinessActivity()
                .clickSaveChangesAccountBtn()
                .clickOkBtn()
                .clickUserBtn()
                .selectUserStatus("ACTIVE")
                .clickSaveChangesUserBtn()
                .clickOkBtn()
                .redirectToTheLoginPage();
        loginPage
                .clickCountryCodeBtn()
                .clickCountryBtn()
                .enterPhoneNumberBusiness()
                .enterPassword()
                .clickLogInBtn()
                .enterSecurityCode();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(dashboardPage.verifySuccessfullAccountConfirmation());
        softAssert.assertAll();

    }

    @Test(priority = 4)
    public void testCheckBusinessAccountReceivesEmailSuccessfulActivation(){
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        dashboardPage = new DashboardPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        backOfficePage = new BackOfficePage(driver, testContextPersonal, testContextBusiness);
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
                .enterCompanyName("TestCompany")
                .enterEmailBusiness()
                .clickRegisterBtn()
                .enterSecurityCode();
        backOfficePage
                .redirectToBackOfficePage()
                .enterLoginFiled()
                .enterPassword()
                .clickLoginBtn()
                .clickAccountIdBtn()
                .clickUserBtn()
                .selectUserStatus("ADMINISTRATE")
                .clickSaveChangesUserBtn()
                .clickOkBtn()
                .clickUserAccountBtn()
                .selectKYCStatus()
                .enterRegistrationNumber()
                .selectLegalEntity()
                .enterBusinessActivity()
                .clickSaveChangesAccountBtn()
                .clickOkBtn()
                .clickUserBtn()
                .selectUserStatus("ACTIVE")
                .clickSaveChangesUserBtn()
                .clickOkBtn();
        mailinatorPage
                .navigateNewTab()
                .enterEmailBusiness()
                .clickGoBtn()
                .clickAccountVerificationEmail();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(mailinatorPage.verifySuccessfullAccountConfirmation(),mailinatorPage.textFromEmailBusinessAccount);
        softAssert.assertAll();

    }

    @Test(priority = 5)
    public void testCheckPersonalAccountCanCompleteVerification(){
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        dashboardPage = new DashboardPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        backOfficePage = new BackOfficePage(driver, testContextPersonal, testContextBusiness);

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
                .enterSecurityCode();
        backOfficePage
                .redirectToBackOfficePage()
                .enterLoginFiled()
                .enterPassword()
                .clickLoginBtn()
                .clickAccountIdBtn()
                .clickUserBtn()
                .selectUserStatus("ADMINISTRATE")
                .clickSaveBtn()
                .clickOkBtn()
                .clickUserAccountBtn()
                .selectKYCStatus()
                .clickSaveChangesAccountBtn()
                .clickOkBtn()
                .clickUserBtn()
                .selectUserStatus("ACTIVE")
                .clickSaveBtn()
                .clickOkBtn()
                .redirectToTheLoginPage();
        loginPage
                .clickCountryCodeBtn()
                .clickCountryBtn()
                .enterPhoneNumberPersonal()
                .enterPassword()
                .clickLogInBtn()
                .enterSecurityCode();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(dashboardPage.verifySuccessfullAccountConfirmation());
        softAssert.assertAll();

    }

    @Test(priority = 6)
    public void testCheckPersonalAccountReceivesEmailSuccessfulActivation(){
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        dashboardPage = new DashboardPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        backOfficePage = new BackOfficePage(driver, testContextPersonal, testContextBusiness);
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
                .enterSecurityCode();
        backOfficePage
                .redirectToBackOfficePage()
                .enterLoginFiled()
                .enterPassword()
                .clickLoginBtn()
                .clickAccountIdBtn()
                .clickUserBtn()
                .selectUserStatus("ADMINISTRATE")
                .clickSaveBtn()
                .clickOkBtn()
                .clickUserAccountBtn()
                .selectKYCStatus()
                .clickSaveChangesAccountBtn()
                .clickOkBtn()
                .clickUserBtn()
                .selectUserStatus("ACTIVE")
                .clickSaveBtn()
                .clickOkBtn()
                .redirectToTheLoginPage();
        mailinatorPage
                .navigateNewTab()
                .enterEmailPersonal()
                .clickGoBtn()
                .clickAccountVerificationEmail();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(mailinatorPage.verifySuccessfullAccountConfirmation(),mailinatorPage.textFromEmailPersonalsAccount);
        softAssert.assertAll();

    }

    @Test(priority = 7)
    public void testCheckPersonalAccountCantAddPersonalAccount(){
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
        dashboardPage
                .clickDropDownField()
                .clickOpenAnAccountBtn();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(dashboardPage.checkPersonalAccountBtnIsEnabled());
        softAssert.assertAll();
    }

    @Test(priority = 8)
    public void testCheckBusinessAccountCanAddPersonalAsRepresentative(){
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        dashboardPage = new DashboardPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        backOfficePage = new BackOfficePage(driver, testContextPersonal, testContextBusiness);
        mailinatorPage = new MailinatorPage(driver, testContextPersonal, testContextBusiness);
        headerPage = new HeaderPage(driver, testContextPersonal, testContextBusiness);

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
                .enterSecurityCode();
        backOfficePage
                .redirectToBackOfficePage()
                .enterLoginFiled()
                .enterPassword()
                .clickLoginBtn()
                .clickAccountIdBtn()
                .clickUserBtn()
                .selectUserStatus("ADMINISTRATE")
                .clickSaveBtn()
                .clickOkBtn()
                .clickUserAccountBtn()
                .selectKYCStatus()
                .clickSaveChangesAccountBtn()
                .clickOkBtn()
                .clickUserBtn()
                .selectUserStatus("ACTIVE")
                .clickSaveBtn()
                .clickOkBtn()
                .redirectToTheLoginPage();
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
                .enterSecurityCode();
        backOfficePage
                .redirectToBackOfficePage()
                .enterLoginFiled()
                .enterPassword()
                .clickLoginBtn()
                .clickAccountIdBtn()
                .clickUserBtn()
                .selectUserStatus("ADMINISTRATE")
                .clickSaveChangesUserBtn()
                .clickOkBtn()
                .clickUserAccountBtn()
                .selectKYCStatus()
                .enterRegistrationNumber()
                .selectLegalEntity()
                .enterBusinessActivity()
                .clickSaveChangesAccountBtn()
                .clickOkBtn()
                .clickUserBtn()
                .selectUserStatus("ACTIVE")
                .clickSaveChangesUserBtn()
                .clickOkBtn()
                .redirectToTheLoginPage();
        loginPage
                .clickCountryCodeBtn()
                .clickCountryBtn()
                .enterPhoneNumberBusiness()
                .enterPassword()
                .clickLogInBtn()
                .enterSecurityCode();
        dashboardPage
                .clickRepresentativesBtn()
                .clickAddNewRepresentativesBtn()
                .enterEmailField()
                .clickNextBtn()
                .clickCheckBoxBtn()
                .clickAddBtn()
                .enterSecurityCode()
                .clickConfirmBtn()
                .clickNextRepresentativeBtn();
        headerPage
                .clickLogOutBtn();
        dashboardPage
                .clickYesBtn();
        loginPage
                .clickCountryCodeBtn()
                .clickCountryBtn()
                .enterPhoneNumberPersonal()
                .enterPassword()
                .clickLogInBtn()
                .enterSecurityCode();
        headerPage
                .clickDropDownBtn()
                .clickTestComp();


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(headerPage.verifySuccessfullAccountSwitch(),"TestCompany");
        softAssert.assertAll();

    }

}