package comFinmatic;

import comFinmatic.dto.TestContextBusiness;
import comFinmatic.dto.TestContextPersonal;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BackOfficeTest extends SetupClassTest{

    public static LoginPage loginPage;
    public static RegisterPage registerPage;
    public static DashboardPage dashboardPage;
    public static BackOfficePage backOfficePage;
    public static MailinatorPage mailinatorPage;
    public static HeaderPage headerPage;
    public static PasswordRecoveryPage passwordRecoveryPage;

    @Test
    public void testCheckOperatorCanChangeUserStatusToActivePersonalAccount(){
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
                .selectUserStatus("ACTIVE")
                .clickSaveBtn()
                .clickOkBtn();


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(backOfficePage.verifyUserStatusPersonalAccount(),"ACTIVE");
        softAssert.assertAll();

    }

    @Test
    public void testCheckOperatorCanChangeUserStatusToAdministratePersonalAccount(){
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
                .redirectToTheLoginPage();
        loginPage
                .clickCountryCodeBtn()
                .clickCountryBtn()
                .enterPhoneNumberPersonal()
                .enterPassword()
                .clickLogInBtn();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(loginPage.getAllertMsg(), loginPage.allertMsgAdministrate);
        softAssert.assertAll();

    }

    @Test
    public void testCheckOperatorCanChangeUserStatusToBlockedPersonalAccount(){
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
                .selectUserStatus("BLOCKED")
                .clickSaveBtn()
                .clickOkBtn()
                .redirectToTheLoginPage();
        loginPage
                .clickCountryCodeBtn()
                .clickCountryBtn()
                .enterPhoneNumberPersonal()
                .enterPassword()
                .clickLogInBtn();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(loginPage.getAllertMsg(), loginPage.allertMsgBlocked);
        softAssert.assertAll();

    }

    @Test
    public void testCheckOperatorCanChangeUserStatusToActiveBusinessAccount(){
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
                .enterPhoneNumberBusiness()
                .enterPassword()
                .clickRegisterBtn()
                .enterSecurityCode()
                .enterCompanyName("TestCompany")
                .enterEmailBusiness()
                .clickRegisterBtn()
                .enterSecurityCode()
                .clickLogInbtn();
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
                .selectUserStatus("ACTIVE")
                .clickSaveBtn()
                .clickOkBtn();


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(backOfficePage.verifyUserStatusBusinessAccount(),"ACTIVE");
        softAssert.assertAll();

    }

    @Test
    public void testCheckOperatorCanChangeUserStatusToAdministrateBusinessAccount(){
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
                .enterPhoneNumberBusiness()
                .enterPassword()
                .clickRegisterBtn()
                .enterSecurityCode()
                .enterCompanyName("TestCompany")
                .enterEmailBusiness()
                .clickRegisterBtn()
                .enterSecurityCode()
                .clickLogInbtn();
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
                .redirectToTheLoginPage();
        loginPage
                .clickCountryCodeBtn()
                .clickCountryBtn()
                .enterPhoneNumberBusiness()
                .enterPassword()
                .clickLogInBtn();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(loginPage.getAllertMsg(), loginPage.allertMsgAdministrate);
        softAssert.assertAll();

    }

    @Test
    public void testCheckOperatorCanChangeUserStatusToBlockedBusinessAccount(){
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
                .enterPhoneNumberBusiness()
                .enterPassword()
                .clickRegisterBtn()
                .enterSecurityCode()
                .enterCompanyName("TestCompany")
                .enterEmailBusiness()
                .clickRegisterBtn()
                .enterSecurityCode()
                .clickLogInbtn();
        backOfficePage
                .redirectToBackOfficePage()
                .enterLoginFiled()
                .enterPassword()
                .clickLoginBtn()
                .clickAccountIdBtn()
                .clickUserBtn()
                .selectUserStatus("BLOCKED")
                .clickSaveChangesUserBtn()
                .clickOkBtn()
                .redirectToTheLoginPage();
        loginPage
                .clickCountryCodeBtn()
                .clickCountryBtn()
                .enterPhoneNumberBusiness()
                .enterPassword()
                .clickLogInBtn();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(loginPage.getAllertMsg(), loginPage.allertMsgBlocked);
        softAssert.assertAll();

    }

    @Test
    public void testCheckKycStatusNewForNewUserPersonal(){
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
                .clickAccountIdBtn();


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(backOfficePage.verifyUserKycStatus(),"New");
        softAssert.assertAll();

    }

    @Test
    public void testCheckKycStatusNewForNewUserBusiness(){
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
                .enterPhoneNumberBusiness()
                .enterPassword()
                .clickRegisterBtn()
                .enterSecurityCode()
                .enterCompanyName("TestCompany")
                .enterEmailBusiness()
                .clickRegisterBtn()
                .enterSecurityCode()
                .clickLogInbtn();
        backOfficePage
                .redirectToBackOfficePage()
                .enterLoginFiled()
                .enterPassword()
                .clickLoginBtn()
                .clickAccountIdBtn();


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(backOfficePage.verifyUserKycStatus(),"New");
        softAssert.assertAll();

    }

    @Test
    public void testCheckKycStatusUnderReviewForNewUserPersonal(){
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
                .selectKycStatus("UNDER_REVIEW")
                .clickSaveChangesAccountBtn()
                .clickOkBtn();


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(backOfficePage.verifyUserKycStatus(),"Under review");
        softAssert.assertAll();

    }

    @Test
    public void testCheckKycStatusUnderReviewForNewUserBusiness(){
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
                .selectKycStatus("UNDER_REVIEW")
                .enterRegistrationNumber()
                .selectLegalEntity()
                .enterBusinessActivity()
                .clickSaveChangesAccountBtn()
                .clickOkBtn();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(backOfficePage.verifyUserKycStatus(),"Under review");
        softAssert.assertAll();

    }

    @Test
    public void testCheckKycStatusVerifiedForNewUserPersonal(){
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
                .selectKycStatus("VERIFIED")
                .clickSaveChangesAccountBtn()
                .clickOkBtn()
                .clickProvidersBtn()
                .clickAddProvider()
                .selectProvider("LPB")
                .clickAddBtn()
                .clickOkProvider()
                .clickWalletsBtn()
                .clickAddWalletBtn()
                .selectPaymentProvider("LPB")
                .selectCurrency("EUR")
                .clickCreateBtn()
                .clickOkWallet()
                .clickCheckboxBtn()
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

       /* SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(backOfficePage.getCreatedIban(),dashboardPage.getCreatedIbanAccount());
        softAssert.assertAll();*/

    }

    @Test
    public void testCheckKycStatusDeclinedForNewUserPersonal(){
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
                .selectKycStatus("DECLINED")
                .clickSaveChangesAccountBtn()
                .clickOkBtn()
                .redirectToTheLoginPage();
        loginPage
                .clickCountryCodeBtn()
                .clickCountryBtn()
                .enterPhoneNumberPersonal()
                .enterPassword()
                .clickLogInBtn();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(loginPage.getAllertMsg(), loginPage.allertMsgAdministrate);
        softAssert.assertAll();

    }

    @Test
    public void testCheckKycStatusDeclinedForNewUserBusiness(){
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
                .selectKycStatus("DECLINED")
                .enterRegistrationNumber()
                .selectLegalEntity()
                .enterBusinessActivity()
                .clickSaveChangesAccountBtn()
                .clickOkBtn()
                .redirectToTheLoginPage();
        loginPage
                .clickCountryCodeBtn()
                .clickCountryBtn()
                .enterPhoneNumberBusiness()
                .enterPassword()
                .clickLogInBtn();


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(loginPage.getAllertMsg(), loginPage.allertMsgAdministrate);
        softAssert.assertAll();

    }

    @Test
    public void testUserReceiveResetPswrdEmailPersonal(){
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
                .clickResetPswrdBtn()
                .clickYesBtn()
                .clickOkResetPswrd();
        mailinatorPage
                .navigateNewTab()
                .enterEmailPersonal()
                .clickGoBtn();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(mailinatorPage.checkPasswordResetEmailIsDisplayed());
        softAssert.assertAll();

    }

    @Test
    public void testUserReceiveResetPswrdEmailBusiness(){
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
                .clickResetPswrdBtn()
                .clickYesBtn()
                .clickOkResetPswrd();
        mailinatorPage
                .navigateNewTab()
                .enterEmailBusiness()
                .clickGoBtn();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(mailinatorPage.checkPasswordResetEmailIsDisplayed());
        softAssert.assertAll();

    }

    @Test
    public void testCheckUserCanResetPswrdUsingProvidedLinkBusiness(){
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        dashboardPage = new DashboardPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        backOfficePage = new BackOfficePage(driver, testContextPersonal, testContextBusiness);
        mailinatorPage = new MailinatorPage(driver, testContextPersonal, testContextBusiness);
        headerPage = new HeaderPage(driver, testContextPersonal, testContextBusiness);
        passwordRecoveryPage = new PasswordRecoveryPage(driver, testContextPersonal, testContextBusiness);


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
                .clickResetPswrdBtn()
                .clickYesBtn()
                .clickOkResetPswrd();
        mailinatorPage
                .navigateNewTabb()
                .enterEmailBusiness()
                .clickGoBtn()
                .clickEmailBtn()
                .clickResetPasswordBtnFromEmail();
        passwordRecoveryPage
                .enterSecurityCode()
                .enterNewPassword("Aa123b123-2")
                .repeatPasswordField("Aa123b123-2")
                .clickConfirmBtn();


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(passwordRecoveryPage.verifySuccessfullSignUp());
        softAssert.assertAll();

    }

}