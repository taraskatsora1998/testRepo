package comFinmatic;

import comFinmatic.dto.TestContextBusiness;
import comFinmatic.dto.TestContextPersonal;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BackOfficeTest extends SetupClassTest {

    public static LoginPage loginPage;
    public static RegisterPage registerPage;
    public static DashboardPage dashboardPage;
    public static BackOfficePage backOfficePage;
    public static HeaderPage headerPage;
    public static PasswordRecoveryPage passwordRecoveryPage;
    public static OutlookPage outlookPage;

    @Test(groups= {"group1"}, priority = 1)
    public void testCheckOperatorCanChangeUserStatusToActivePersonalAccount() {
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        dashboardPage = new DashboardPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        backOfficePage = new BackOfficePage(driver, testContextPersonal, testContextBusiness);
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
        softAssert.assertEquals(backOfficePage.verifyUserStatusPersonalAccount(), "ACTIVE");
        softAssert.assertAll();

    }

    @Test(groups= {"group1"},priority = 2)
    public void testCheckOperatorCanChangeUserStatusToAdministratePersonalAccount() {
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        dashboardPage = new DashboardPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        backOfficePage = new BackOfficePage(driver, testContextPersonal, testContextBusiness);
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

    @Test(groups= {"group1"},priority = 3)
    public void testCheckOperatorCanChangeUserStatusToBlockedPersonalAccount() {
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        dashboardPage = new DashboardPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        backOfficePage = new BackOfficePage(driver, testContextPersonal, testContextBusiness);
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

    @Test(groups= {"group1"},priority = 4)
    public void testCheckOperatorCanChangeUserStatusToActiveBusinessAccount() {
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        dashboardPage = new DashboardPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        backOfficePage = new BackOfficePage(driver, testContextPersonal, testContextBusiness);
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
        softAssert.assertEquals(backOfficePage.verifyUserStatusBusinessAccount(), "ACTIVE");
        softAssert.assertAll();

    }

    @Test(groups= {"group1"},priority = 5)
    public void testCheckOperatorCanChangeUserStatusToAdministrateBusinessAccount() {
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        dashboardPage = new DashboardPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        backOfficePage = new BackOfficePage(driver, testContextPersonal, testContextBusiness);
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

    @Test(groups= {"group1"},priority = 6)
    public void testCheckOperatorCanChangeUserStatusToBlockedBusinessAccount() {
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        dashboardPage = new DashboardPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        backOfficePage = new BackOfficePage(driver, testContextPersonal, testContextBusiness);
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

    @Test(groups= {"group1"},priority = 7)
    public void testCheckKycStatusNewForNewUserPersonal() {
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        dashboardPage = new DashboardPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        backOfficePage = new BackOfficePage(driver, testContextPersonal, testContextBusiness);
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
        softAssert.assertEquals(backOfficePage.verifyUserKycStatus(), "New");
        softAssert.assertAll();

    }

    @Test(groups= {"group1"},priority = 8)
    public void testCheckKycStatusNewForNewUserBusiness() {
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        dashboardPage = new DashboardPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        backOfficePage = new BackOfficePage(driver, testContextPersonal, testContextBusiness);
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
        softAssert.assertEquals(backOfficePage.verifyUserKycStatus(), "New");
        softAssert.assertAll();

    }

    @Test(groups= {"group1"},priority = 9)
    public void testCheckKycStatusUnderReviewForNewUserPersonal() {
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        dashboardPage = new DashboardPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        backOfficePage = new BackOfficePage(driver, testContextPersonal, testContextBusiness);
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
        softAssert.assertEquals(backOfficePage.verifyUserKycStatus(), "Under review");
        softAssert.assertAll();

    }

    @Test(groups= {"group1"},priority = 10)
    public void testCheckKycStatusUnderReviewForNewUserBusiness() {
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        dashboardPage = new DashboardPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        backOfficePage = new BackOfficePage(driver, testContextPersonal, testContextBusiness);
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
        softAssert.assertEquals(backOfficePage.verifyUserKycStatus(), "Under review");
        softAssert.assertAll();

    }

    @Test(groups= {"group1"},priority = 11)
    public void testCheckKycStatusVerifiedForNewUserPersonal() {
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        dashboardPage = new DashboardPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        backOfficePage = new BackOfficePage(driver, testContextPersonal, testContextBusiness);
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
                .selectUserStatus("ACTIVEe")
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
        softAssert.assertEquals(dashboardPage.getCurrencyText(),"EUR");
        softAssert.assertAll();
    }

    @Test(groups= {"group1"},priority = 12)
    public void testCheckKycStatusVerifiedForNewUserBusiness() {
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        dashboardPage = new DashboardPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        backOfficePage = new BackOfficePage(driver, testContextPersonal, testContextBusiness);
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
                .selectKycStatus("VERIFIED")
                .enterRegistrationNumber()
                .selectLegalEntity()
                .enterBusinessActivity()
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
        softAssert.assertEquals(dashboardPage.getCurrencyText(),"EUR");
        softAssert.assertAll();
    }

    @Test(groups= {"group1"},priority = 13)
    public void testCheckKycStatusDeclinedForNewUserPersonal() {
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        dashboardPage = new DashboardPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        backOfficePage = new BackOfficePage(driver, testContextPersonal, testContextBusiness);
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

    @Test(groups= {"group1"},priority = 14)
    public void testCheckKycStatusDeclinedForNewUserBusiness() {
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        dashboardPage = new DashboardPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        backOfficePage = new BackOfficePage(driver, testContextPersonal, testContextBusiness);
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

    @Test(groups= {"group2"},priority = 15)
    public void testUserReceiveResetPswrdEmailPersonal() {
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        dashboardPage = new DashboardPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        backOfficePage = new BackOfficePage(driver, testContextPersonal, testContextBusiness);
        headerPage = new HeaderPage(driver, testContextPersonal, testContextBusiness);
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
        outlookPage
                .navigateNewTab()
                .enterEMail()
                .clickNextBtn()
                .enterPassword()
                .clickNextBtn()
                .clickYesBtn()
                .clickMenuBtn()
                .clickOutlookBtn()
                .clickJunkMail()
                .clickSuccessRegistrationEmail()
                .clickReadUnreadBtn();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outlookPage.checkUSerWasSuccessfullyRegistered(), "Registration Success");
        softAssert.assertAll();

    }

    @Test(groups= {"group2"},priority = 16)
    public void testUserReceiveResetPswrdEmailBusiness() {
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        dashboardPage = new DashboardPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        backOfficePage = new BackOfficePage(driver, testContextPersonal, testContextBusiness);
        headerPage = new HeaderPage(driver, testContextPersonal, testContextBusiness);
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
        outlookPage
                .navigateNewTab()
                .enterEMail()
                .clickNextBtn()
                .enterPassword()
                .clickNextBtn()
                .clickYesBtn()
                .clickMenuBtn()
                .clickOutlookBtn()
                .clickJunkMail()
                .clickPasswordResetEMail()
                .clickReadUnreadBtn();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outlookPage.checkUSerReceivedPasswordResetEmail(), "Account access");
        softAssert.assertAll();

    }

    @Test(groups= {"group2"},priority = 17)
    public void testCheckUserCanResetPswrdUsingProvidedLinkBusiness() {
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        dashboardPage = new DashboardPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        backOfficePage = new BackOfficePage(driver, testContextPersonal, testContextBusiness);
        headerPage = new HeaderPage(driver, testContextPersonal, testContextBusiness);
        passwordRecoveryPage = new PasswordRecoveryPage(driver, testContextPersonal, testContextBusiness);
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
        outlookPage
                .navigateNewTab()
                .enterEMail()
                .clickNextBtn()
                .enterPassword()
                .clickNextBtn()
                .clickYesBtn()
                .clickMenuBtn()
                .clickOutlookBtn()
                .clickJunkMail()
                .clickPasswordResetEMail()
                .clickReadUnreadBtn()
                .clickResetPswrdBtn();
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
