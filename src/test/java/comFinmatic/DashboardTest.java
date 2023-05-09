package comFinmatic;

import comFinmatic.dto.TestContextPersonal;
import comFinmatic.dto.TestContextBusiness;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DashboardTest extends SetupClassTest {

    public static LoginPage loginPage;
    public static RegisterPage registerPage;
    public static DashboardPage dashboardPage;
    public static BackOfficePage backOfficePage;
    public static HeaderPage headerPage;
    public static OpenPaydPage openPaydPage;
    public static OutlookPage outlookPage;

    @Test(groups= {"group1"},priority = 1)
    public void testCheckPersonalAccountCanSeeVerificationBtn() {
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

    @Test(groups= {"group1"},priority = 2)
    public void testCheckBusinessAccountCanSeeVerificationBtn() {
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

    @Test(groups= {"group1"},priority = 3)
    public void testCheckBusinessAccountCanCompleteVerification() {
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

    @Test(groups= {"group2"},priority = 4)
    public void testCheckBusinessAccountReceivesEmailSuccessfulActivation() {
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        dashboardPage = new DashboardPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        backOfficePage = new BackOfficePage(driver, testContextPersonal, testContextBusiness);
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
                .clickAccountWasVerifiedEmail()
                .clickReadUnreadBtn();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outlookPage.verifyAccountWasVerified(), outlookPage.accountWasVerifiedText);
        softAssert.assertAll();

    }

    @Test(groups= {"group1"},priority = 5)
    public void testCheckPersonalAccountCanCompleteVerification() {
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

    @Test(groups= {"group2"},priority = 6)
    public void testCheckPersonalAccountReceivesEmailSuccessfulActivation() {
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        dashboardPage = new DashboardPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        backOfficePage = new BackOfficePage(driver, testContextPersonal, testContextBusiness);
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
                .clickAccountWasVerifiedEmail()
                .clickReadUnreadBtn();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outlookPage.verifyAccountWasVerified(), outlookPage.accountWasVerifiedPersonalText);
        softAssert.assertAll();

    }

    @Test(groups= {"group1"},priority = 7)
    public void testCheckPersonalAccountCantAddPersonalAccount() {
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

    @Test(groups= {"group1"},priority = 8)
    public void testCheckBusinessAccountCanAddPersonalAsRepresentative() {
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
        softAssert.assertEquals(headerPage.verifySuccessfullAccountSwitch(), "TestCompany");
        softAssert.assertAll();

    }

    @Test(groups= {"group1"},priority = 9)
    public void testUserCanMakeOPTransactionEurSepaPersonal() {
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        dashboardPage = new DashboardPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        backOfficePage = new BackOfficePage(driver, testContextPersonal, testContextBusiness);
        openPaydPage = new OpenPaydPage(driver, testContextPersonal, testContextBusiness);

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
                .selectAddressCountry("AI")
                .enterAddressField()
                .enterZip()
                .enterAddressCity()
                .clickSaveChangesAccountBtn()
                .clickOkBtn()
                .clickProvidersBtn()
                .clickAddProvider()
                .selectProvider("OPEN_PAYD")
                .clickAddBtn()
                .clickOkProvider()
                .clickWalletsBtn()
                .clickAddWalletBtn()
                .selectPaymentProvider("OPEN_PAYD")
                .selectCurrency("EUR")
                .clickCreateBtn()
                .clickOkWallet()
                .clickCheckboxBtn()
                .clickUserBtn()
                .selectUserStatus("ACTIVE")
                .clickSaveBtn()
                .clickOkBtn();
        openPaydPage
                .redirectToOpenPayd()
                .enterEmailField()
                .clickContinueBtn()
                .enterPasswordField()
                .clickSignInBtn()
                .clickLinkedClientsBtn()
                .clickClientsBtn()
                .clickLoginAsCustomerBtn()
                .clickAccountBtn()
                .clickActionsBtn()
                .clickSimulatePayInBtn()
                .enterAmount()
                .enterReference()
                .enterSenderAddress()
                .clickCreatePayInBtn()
                .redirectToTheLoginPage();
        loginPage
                .clickCountryCodeBtn()
                .clickCountryBtn()
                .enterPhoneNumberPersonal()
                .enterPassword()
                .clickLogInBtn()
                .enterSecurityCode();
        dashboardPage
                .clickNewPaymentBtn()
                .enterRecipientsIban("LV56RIKO0001050242347")
                .enterCompanyNameForTransaction()
                .enterAmountField("1")
                .enterComment()
                .clickSendBtn()
                .clickConfirmTransactionBtn()
                .enterSecurityCode()
                .clickConfirmTransactionFinalBtn();


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(dashboardPage.verifySuccessfullTransaction());
        softAssert.assertAll();

    }

    @Test(groups= {"group1"},priority = 10)
    public void testUserCanMakeOPTransactionEurFractionalNumberSepaPersonal() {
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        dashboardPage = new DashboardPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        backOfficePage = new BackOfficePage(driver, testContextPersonal, testContextBusiness);
        openPaydPage = new OpenPaydPage(driver, testContextPersonal, testContextBusiness);

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
                .selectAddressCountry("AI")
                .enterAddressField()
                .enterZip()
                .enterAddressCity()
                .clickSaveChangesAccountBtn()
                .clickOkBtn()
                .clickProvidersBtn()
                .clickAddProvider()
                .selectProvider("OPEN_PAYD")
                .clickAddBtn()
                .clickOkProvider()
                .clickWalletsBtn()
                .clickAddWalletBtn()
                .selectPaymentProvider("OPEN_PAYD")
                .selectCurrency("EUR")
                .clickCreateBtn()
                .clickOkWallet()
                .clickCheckboxBtn()
                .clickUserBtn()
                .selectUserStatus("ACTIVE")
                .clickSaveBtn()
                .clickOkBtn();
        openPaydPage
                .redirectToOpenPayd()
                .enterEmailField()
                .clickContinueBtn()
                .enterPasswordField()
                .clickSignInBtn()
                .clickLinkedClientsBtn()
                .clickClientsBtn()
                .clickLoginAsCustomerBtn()
                .clickAccountBtn()
                .clickActionsBtn()
                .clickSimulatePayInBtn()
                .enterAmount()
                .enterReference()
                .enterSenderAddress()
                .clickCreatePayInBtn()
                .redirectToTheLoginPage();
        loginPage
                .clickCountryCodeBtn()
                .clickCountryBtn()
                .enterPhoneNumberPersonal()
                .enterPassword()
                .clickLogInBtn()
                .enterSecurityCode();
        dashboardPage
                .clickNewPaymentBtn()
                .enterRecipientsIban("LV56RIKO0001050242347")
                .enterCompanyNameForTransaction()
                .enterAmountField("1.15")
                .enterComment()
                .clickSendBtn()
                .clickConfirmTransactionBtn()
                .enterSecurityCode()
                .clickConfirmTransactionFinalBtn();


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(dashboardPage.verifySuccessfullTransaction());
        softAssert.assertAll();

    }


    @Test(groups= {"group1"},priority = 11)
    public void testUserCanMakeOPTransactionEurWithMoreThanUsersAmountSepaPersonal() {
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        dashboardPage = new DashboardPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        backOfficePage = new BackOfficePage(driver, testContextPersonal, testContextBusiness);
        openPaydPage = new OpenPaydPage(driver, testContextPersonal, testContextBusiness);

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
                .selectAddressCountry("AI")
                .enterAddressField()
                .enterZip()
                .enterAddressCity()
                .clickSaveChangesAccountBtn()
                .clickOkBtn()
                .clickProvidersBtn()
                .clickAddProvider()
                .selectProvider("OPEN_PAYD")
                .clickAddBtn()
                .clickOkProvider()
                .clickWalletsBtn()
                .clickAddWalletBtn()
                .selectPaymentProvider("OPEN_PAYD")
                .selectCurrency("EUR")
                .clickCreateBtn()
                .clickOkWallet()
                .clickCheckboxBtn()
                .clickUserBtn()
                .selectUserStatus("ACTIVE")
                .clickSaveBtn()
                .clickOkBtn();
        openPaydPage
                .redirectToOpenPayd()
                .enterEmailField()
                .clickContinueBtn()
                .enterPasswordField()
                .clickSignInBtn()
                .clickLinkedClientsBtn()
                .clickClientsBtn()
                .clickLoginAsCustomerBtn()
                .clickAccountBtn()
                .clickActionsBtn()
                .clickSimulatePayInBtn()
                .enterAmount()
                .enterReference()
                .enterSenderAddress()
                .clickCreatePayInBtn()
                .redirectToTheLoginPage();
        loginPage
                .clickCountryCodeBtn()
                .clickCountryBtn()
                .enterPhoneNumberPersonal()
                .enterPassword()
                .clickLogInBtn()
                .enterSecurityCode();
        dashboardPage
                .clickNewPaymentBtn()
                .enterRecipientsIban("LV56RIKO0001050242347")
                .enterCompanyNameForTransaction()
                .enterAmountField("100 001")
                .enterComment()
                .clickSendBtn();


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(dashboardPage.verifyCorrectnessOfAlertMessage());
        softAssert.assertAll();

    }

    @Test(groups= {"group1"},priority = 12)
    public void testUserCanMakeOPTransactionEurSepaBusiness() {
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        dashboardPage = new DashboardPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        backOfficePage = new BackOfficePage(driver, testContextPersonal, testContextBusiness);
        openPaydPage = new OpenPaydPage(driver, testContextPersonal, testContextBusiness);

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
                .enterCompanyName()
                .enterRegistrationNumber()
                .selectLegalEntity()
                .enterLegalAddress()
                .enterZipCode()
                .enterLegalAddressCity()
                .selectAddressCountry("AI")
                .selectOfficeAddressCountry()
                .enterBusinessActivity()
                .clickSaveChangesAccountBtn()
                .clickOkBtn()
                .clickProvidersBtn()
                .clickAddProvider()
                .selectProvider("OPEN_PAYD")
                .clickAddBtn()
                .clickOkProvider()
                .clickWalletsBtn()
                .clickAddWalletBtn()
                .selectPaymentProvider("OPEN_PAYD")
                .selectCurrency("EUR")
                .clickCreateBtn()
                .clickOkWallet()
                .clickCheckboxBtn()
                .clickUserBtn()
                .selectUserStatus("ACTIVE")
                .clickSaveChangesUserBtn()
                .clickOkBtn();
        openPaydPage
                .redirectToOpenPayd()
                .enterEmailField()
                .clickContinueBtn()
                .enterPasswordField()
                .clickSignInBtn()
                .clickLinkedClientsBtn()
                .clickClientsBtn()
                .clickLoginAsCustomerBtn()
                .clickAccountBtn()
                .clickActionsBtn()
                .clickSimulatePayInBtn()
                .enterAmount()
                .enterReference()
                .enterSenderAddress()
                .clickCreatePayInBtn()
                .redirectToTheLoginPage();
        loginPage
                .clickCountryCodeBtn()
                .clickCountryBtn()
                .enterPhoneNumberBusiness()
                .enterPassword()
                .clickLogInBtn()
                .enterSecurityCode();
        dashboardPage
                .clickNewPaymentBtn()
                .enterRecipientsIban("LV56RIKO0001050242347")
                .enterCompanyNameForTransaction()
                .enterAmountField("1")
                .enterComment()
                .clickSendBtn()
                .clickConfirmTransactionBtn()
                .enterSecurityCode()
                .clickConfirmTransactionFinalBtn();


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(dashboardPage.verifySuccessfullTransaction());
        softAssert.assertAll();

    }

    @Test(groups= {"group1"},priority = 13)
    public void testUserCanMakeOPTransactionEurMoreThanUserAmountSepaBusiness() {
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        dashboardPage = new DashboardPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        backOfficePage = new BackOfficePage(driver, testContextPersonal, testContextBusiness);
        openPaydPage = new OpenPaydPage(driver, testContextPersonal, testContextBusiness);

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
                .enterCompanyName()
                .enterRegistrationNumber()
                .selectLegalEntity()
                .enterLegalAddress()
                .enterZipCode()
                .enterLegalAddressCity()
                .selectAddressCountry("AI")
                .selectOfficeAddressCountry()
                .enterBusinessActivity()
                .clickSaveChangesAccountBtn()
                .clickOkBtn()
                .clickProvidersBtn()
                .clickAddProvider()
                .selectProvider("OPEN_PAYD")
                .clickAddBtn()
                .clickOkProvider()
                .clickWalletsBtn()
                .clickAddWalletBtn()
                .selectPaymentProvider("OPEN_PAYD")
                .selectCurrency("EUR")
                .clickCreateBtn()
                .clickOkWallet()
                .clickCheckboxBtn()
                .clickUserBtn()
                .selectUserStatus("ACTIVE")
                .clickSaveChangesUserBtn()
                .clickOkBtn();
        openPaydPage
                .redirectToOpenPayd()
                .enterEmailField()
                .clickContinueBtn()
                .enterPasswordField()
                .clickSignInBtn()
                .clickLinkedClientsBtn()
                .clickClientsBtn()
                .clickLoginAsCustomerBtn()
                .clickAccountBtn()
                .clickActionsBtn()
                .clickSimulatePayInBtn()
                .enterAmount()
                .enterReference()
                .enterSenderAddress()
                .clickCreatePayInBtn()
                .redirectToTheLoginPage();
        loginPage
                .clickCountryCodeBtn()
                .clickCountryBtn()
                .enterPhoneNumberBusiness()
                .enterPassword()
                .clickLogInBtn()
                .enterSecurityCode();
        dashboardPage
                .clickNewPaymentBtn()
                .enterRecipientsIban("LV56RIKO0001050242347")
                .enterCompanyNameForTransaction()
                .enterAmountField("200 000")
                .enterComment()
                .clickSendBtn();


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(dashboardPage.verifyCorrectnessOfAlertMessage());
        softAssert.assertAll();

    }

    @Test(groups= {"group1"},priority = 14)
    public void testUserCanMakeOPTransactionEurSepaInstantPersonal() {
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        dashboardPage = new DashboardPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        backOfficePage = new BackOfficePage(driver, testContextPersonal, testContextBusiness);
        openPaydPage = new OpenPaydPage(driver, testContextPersonal, testContextBusiness);

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
                .selectAddressCountry("AI")
                .enterAddressField()
                .enterZip()
                .enterAddressCity()
                .clickSaveChangesAccountBtn()
                .clickOkBtn()
                .clickProvidersBtn()
                .clickAddProvider()
                .selectProvider("OPEN_PAYD")
                .clickAddBtn()
                .clickOkProvider()
                .clickWalletsBtn()
                .clickAddWalletBtn()
                .selectPaymentProvider("OPEN_PAYD")
                .selectCurrency("EUR")
                .clickCreateBtn()
                .clickOkWallet()
                .clickCheckboxBtn()
                .clickUserBtn()
                .selectUserStatus("ACTIVE")
                .clickSaveBtn()
                .clickOkBtn();
        openPaydPage
                .redirectToOpenPayd()
                .enterEmailField()
                .clickContinueBtn()
                .enterPasswordField()
                .clickSignInBtn()
                .clickLinkedClientsBtn()
                .clickClientsBtn()
                .clickLoginAsCustomerBtn()
                .clickAccountBtn()
                .clickActionsBtn()
                .clickSimulatePayInBtn()
                .enterAmount()
                .enterReference()
                .enterSenderAddress()
                .clickCreatePayInBtn()
                .redirectToTheLoginPage();
        loginPage
                .clickCountryCodeBtn()
                .clickCountryBtn()
                .enterPhoneNumberPersonal()
                .enterPassword()
                .clickLogInBtn()
                .enterSecurityCode();
        dashboardPage
                .clickNewPaymentBtn()
                .clickPaymentMethod()
                .clickSepaInstant()
                .enterRecipientsIban("LT68 3250 0349 9180 8042")
                .enterCompanyNameForTransaction()
                .enterAmountField("1")
                .enterComment()
                .clickSendBtn()
                .clickConfirmTransactionBtn()
                .enterSecurityCode()
                .clickConfirmTransactionFinalBtn();


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(dashboardPage.verifySuccessfullTransaction());
        softAssert.assertAll();

    }

    @Test(groups= {"group1"},priority = 15)
    public void testUserCanMakeOPTransactionEurSepaInstantBusiness() {
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        dashboardPage = new DashboardPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        backOfficePage = new BackOfficePage(driver, testContextPersonal, testContextBusiness);
        openPaydPage = new OpenPaydPage(driver, testContextPersonal, testContextBusiness);

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
                .enterCompanyName()
                .enterRegistrationNumber()
                .selectLegalEntity()
                .enterLegalAddress()
                .enterZipCode()
                .enterLegalAddressCity()
                .selectAddressCountry("AI")
                .selectOfficeAddressCountry()
                .enterBusinessActivity()
                .clickSaveChangesAccountBtn()
                .clickOkBtn()
                .clickProvidersBtn()
                .clickAddProvider()
                .selectProvider("OPEN_PAYD")
                .clickAddBtn()
                .clickOkProvider()
                .clickWalletsBtn()
                .clickAddWalletBtn()
                .selectPaymentProvider("OPEN_PAYD")
                .selectCurrency("EUR")
                .clickCreateBtn()
                .clickOkWallet()
                .clickCheckboxBtn()
                .clickUserBtn()
                .selectUserStatus("ACTIVE")
                .clickSaveChangesUserBtn()
                .clickOkBtn();
        openPaydPage
                .redirectToOpenPayd()
                .enterEmailField()
                .clickContinueBtn()
                .enterPasswordField()
                .clickSignInBtn()
                .clickLinkedClientsBtn()
                .clickClientsBtn()
                .clickLoginAsCustomerBtn()
                .clickAccountBtn()
                .clickActionsBtn()
                .clickSimulatePayInBtn()
                .enterAmount()
                .enterReference()
                .enterSenderAddress()
                .clickCreatePayInBtn()
                .redirectToTheLoginPage();
        loginPage
                .clickCountryCodeBtn()
                .clickCountryBtn()
                .enterPhoneNumberBusiness()
                .enterPassword()
                .clickLogInBtn()
                .enterSecurityCode();
        dashboardPage
                .clickNewPaymentBtn()
                .clickPaymentMethod()
                .clickSepaInstant()
                .enterRecipientsIban("LT68 3250 0349 9180 8042")
                .enterCompanyNameForTransaction()
                .enterAmountField("1")
                .enterComment()
                .clickSendBtn()
                .clickConfirmTransactionBtn()
                .enterSecurityCode()
                .clickConfirmTransactionFinalBtn();


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(dashboardPage.verifySuccessfullTransaction());
        softAssert.assertAll();

    }

    @Test(groups= {"group1"},priority = 16)
    public void testUserCanMakeOPTransactionEurInternalPersonal() {
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        dashboardPage = new DashboardPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        backOfficePage = new BackOfficePage(driver, testContextPersonal, testContextBusiness);
        openPaydPage = new OpenPaydPage(driver, testContextPersonal, testContextBusiness);

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
                .selectAddressCountry("AI")
                .enterAddressField()
                .enterZip()
                .enterAddressCity()
                .clickSaveChangesAccountBtn()
                .clickOkBtn()
                .clickProvidersBtn()
                .clickAddProvider()
                .selectProvider("OPEN_PAYD")
                .clickAddBtn()
                .clickOkProvider()
                .clickWalletsBtn()
                .clickAddWalletBtn()
                .selectPaymentProvider("OPEN_PAYD")
                .selectCurrency("EUR")
                .clickCreateBtn()
                .clickOkWallet()
                .clickCheckboxBtn()
                .clickUserBtn()
                .selectUserStatus("ACTIVE")
                .clickSaveBtn()
                .clickOkBtn();
        openPaydPage
                .redirectToOpenPayd()
                .enterEmailField()
                .clickContinueBtn()
                .enterPasswordField()
                .clickSignInBtn()
                .clickLinkedClientsBtn()
                .clickClientsBtn()
                .clickLoginAsCustomerBtn()
                .clickAccountBtn()
                .clickActionsBtn()
                .clickSimulatePayInBtn()
                .enterAmount()
                .enterReference()
                .enterSenderAddress()
                .clickCreatePayInBtn()
                .redirectToTheLoginPage();
        loginPage
                .clickCountryCodeBtn()
                .clickCountryBtn()
                .enterPhoneNumberPersonal()
                .enterPassword()
                .clickLogInBtn()
                .enterSecurityCode();
        dashboardPage
                .clickNewPaymentBtn()
                .clickPaymentMethod()
                .clickInternal()
                .enterRecipientsIban("GB71SEOU19870010059557")
                .enterCompanyNameForTransaction()
                .enterAmountField("1")
                .enterComment()
                .clickSendBtn()
                .clickConfirmTransactionBtn()
                .enterSecurityCode()
                .clickConfirmTransactionFinalBtn();


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(dashboardPage.verifySuccessfullTransaction());
        softAssert.assertAll();

    }

    @Test(groups= {"group1"},priority = 17)
    public void testUserCanMakeOPTransactionEurInternalBusiness() {
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        dashboardPage = new DashboardPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        backOfficePage = new BackOfficePage(driver, testContextPersonal, testContextBusiness);
        openPaydPage = new OpenPaydPage(driver, testContextPersonal, testContextBusiness);

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
                .enterCompanyName()
                .enterRegistrationNumber()
                .selectLegalEntity()
                .enterLegalAddress()
                .enterZipCode()
                .enterLegalAddressCity()
                .selectAddressCountry("AI")
                .selectOfficeAddressCountry()
                .enterBusinessActivity()
                .clickSaveChangesAccountBtn()
                .clickOkBtn()
                .clickProvidersBtn()
                .clickAddProvider()
                .selectProvider("OPEN_PAYD")
                .clickAddBtn()
                .clickOkProvider()
                .clickWalletsBtn()
                .clickAddWalletBtn()
                .selectPaymentProvider("OPEN_PAYD")
                .selectCurrency("EUR")
                .clickCreateBtn()
                .clickOkWallet()
                .clickCheckboxBtn()
                .clickUserBtn()
                .selectUserStatus("ACTIVE")
                .clickSaveChangesUserBtn()
                .clickOkBtn();
        openPaydPage
                .redirectToOpenPayd()
                .enterEmailField()
                .clickContinueBtn()
                .enterPasswordField()
                .clickSignInBtn()
                .clickLinkedClientsBtn()
                .clickClientsBtn()
                .clickLoginAsCustomerBtn()
                .clickAccountBtn()
                .clickActionsBtn()
                .clickSimulatePayInBtn()
                .enterAmount()
                .enterReference()
                .enterSenderAddress()
                .clickCreatePayInBtn()
                .redirectToTheLoginPage();
        loginPage
                .clickCountryCodeBtn()
                .clickCountryBtn()
                .enterPhoneNumberBusiness()
                .enterPassword()
                .clickLogInBtn()
                .enterSecurityCode();
        dashboardPage
                .clickNewPaymentBtn()
                .clickPaymentMethod()
                .clickInternal()
                .enterRecipientsIban("GB71SEOU19870010059557")
                .enterCompanyNameForTransaction()
                .enterAmountField("1")
                .enterComment()
                .clickSendBtn()
                .clickConfirmTransactionBtn()
                .enterSecurityCode()
                .clickConfirmTransactionFinalBtn();


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(dashboardPage.verifySuccessfullTransaction());
        softAssert.assertAll();

    }

    @Test(groups= {"group1"},priority = 18)
    public void testUserCanMakeOPTransactionGbpInternalPersonal() {
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        dashboardPage = new DashboardPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        backOfficePage = new BackOfficePage(driver, testContextPersonal, testContextBusiness);
        openPaydPage = new OpenPaydPage(driver, testContextPersonal, testContextBusiness);

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
                .selectAddressCountry("AI")
                .enterAddressField()
                .enterZip()
                .enterAddressCity()
                .clickSaveChangesAccountBtn()
                .clickOkBtn()
                .clickProvidersBtn()
                .clickAddProvider()
                .selectProvider("OPEN_PAYD")
                .clickAddBtn()
                .clickOkProvider()
                .clickWalletsBtn()
                .clickAddWalletBtn()
                .selectPaymentProvider("OPEN_PAYD")
                .selectCurrency("GBP")
                .clickCreateBtn()
                .clickOkWallet()
                .clickCheckboxBtn()
                .clickUserBtn()
                .selectUserStatus("ACTIVE")
                .clickSaveBtn()
                .clickOkBtn();
        openPaydPage
                .redirectToOpenPayd()
                .enterEmailField()
                .clickContinueBtn()
                .enterPasswordField()
                .clickSignInBtn()
                .clickLinkedClientsBtn()
                .clickClientsBtn()
                .clickLoginAsCustomerBtn()
                .clickAccountBtn()
                .clickActionsBtn()
                .clickSimulatePayInBtn()
                .enterAmount()
                .enterReference()
                .enterSenderAddress()
                .clickCreatePayInBtn()
                .redirectToTheLoginPage();
        loginPage
                .clickCountryCodeBtn()
                .clickCountryBtn()
                .enterPhoneNumberPersonal()
                .enterPassword()
                .clickLogInBtn()
                .enterSecurityCode();
        dashboardPage
                .clickNewPaymentBtn()
                .clickPaymentMethod()
                .clickInternal()
                .clickIbanBtn()
                .enterRecipientsIban("GB49SMLT04050900008208")
                .enterCompanyNameForTransaction()
                .enterAmountField("1")
                .enterComment()
                .clickSendBtn()
                .clickConfirmTransactionBtn()
                .enterSecurityCode()
                .clickConfirmTransactionFinalBtn();


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(dashboardPage.verifySuccessfullTransaction());
        softAssert.assertAll();

    }

    @Test(groups= {"group1"},priority = 19)
    public void testUserCanMakeOPTransactionGbpInternalBusiness() {
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        dashboardPage = new DashboardPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        backOfficePage = new BackOfficePage(driver, testContextPersonal, testContextBusiness);
        openPaydPage = new OpenPaydPage(driver, testContextPersonal, testContextBusiness);

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
                .enterCompanyName()
                .enterRegistrationNumber()
                .selectLegalEntity()
                .enterLegalAddress()
                .enterZipCode()
                .enterLegalAddressCity()
                .selectAddressCountry("AI")
                .selectOfficeAddressCountry()
                .enterBusinessActivity()
                .clickSaveChangesAccountBtn()
                .clickOkBtn()
                .clickProvidersBtn()
                .clickAddProvider()
                .selectProvider("OPEN_PAYD")
                .clickAddBtn()
                .clickOkProvider()
                .clickWalletsBtn()
                .clickAddWalletBtn()
                .selectPaymentProvider("OPEN_PAYD")
                .selectCurrency("GBP")
                .clickCreateBtn()
                .clickOkWallet()
                .clickCheckboxBtn()
                .clickUserBtn()
                .selectUserStatus("ACTIVE")
                .clickSaveChangesUserBtn()
                .clickOkBtn();
        openPaydPage
                .redirectToOpenPayd()
                .enterEmailField()
                .clickContinueBtn()
                .enterPasswordField()
                .clickSignInBtn()
                .clickLinkedClientsBtn()
                .clickClientsBtn()
                .clickLoginAsCustomerBtn()
                .clickAccountBtn()
                .clickActionsBtn()
                .clickSimulatePayInBtn()
                .enterAmount()
                .enterReference()
                .enterSenderAddress()
                .clickCreatePayInBtn()
                .redirectToTheLoginPage();
        loginPage
                .clickCountryCodeBtn()
                .clickCountryBtn()
                .enterPhoneNumberBusiness()
                .enterPassword()
                .clickLogInBtn()
                .enterSecurityCode();
        dashboardPage
                .clickNewPaymentBtn()
                .clickPaymentMethod()
                .clickInternal()
                .clickIbanBtn()
                .enterRecipientsIban("GB49SMLT04050900008208")
                .enterCompanyNameForTransaction()
                .enterAmountField("1")
                .enterComment()
                .clickSendBtn()
                .clickConfirmTransactionBtn()
                .enterSecurityCode()
                .clickConfirmTransactionFinalBtn();


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(dashboardPage.verifySuccessfullTransaction());
        softAssert.assertAll();

    }

    @Test(groups= {"group1"},priority = 20)
    public void testUserCanMakeOPTransactionGbpFPPersonal() {
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        dashboardPage = new DashboardPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        backOfficePage = new BackOfficePage(driver, testContextPersonal, testContextBusiness);
        openPaydPage = new OpenPaydPage(driver, testContextPersonal, testContextBusiness);

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
                .selectAddressCountry("AI")
                .enterAddressField()
                .enterZip()
                .enterAddressCity()
                .clickSaveChangesAccountBtn()
                .clickOkBtn()
                .clickProvidersBtn()
                .clickAddProvider()
                .selectProvider("OPEN_PAYD")
                .clickAddBtn()
                .clickOkProvider()
                .clickWalletsBtn()
                .clickAddWalletBtn()
                .selectPaymentProvider("OPEN_PAYD")
                .selectCurrency("GBP")
                .clickCreateBtn()
                .clickOkWallet()
                .clickCheckboxBtn()
                .clickUserBtn()
                .selectUserStatus("ACTIVE")
                .clickSaveBtn()
                .clickOkBtn();
        openPaydPage
                .redirectToOpenPayd()
                .enterEmailField()
                .clickContinueBtn()
                .enterPasswordField()
                .clickSignInBtn()
                .clickLinkedClientsBtn()
                .clickClientsBtn()
                .clickLoginAsCustomerBtn()
                .clickAccountBtn()
                .clickActionsBtn()
                .clickSimulatePayInBtn()
                .enterAmount()
                .enterReference()
                .enterSenderAddress()
                .clickCreatePayInBtn()
                .redirectToTheLoginPage();
        loginPage
                .clickCountryCodeBtn()
                .clickCountryBtn()
                .enterPhoneNumberPersonal()
                .enterPassword()
                .clickLogInBtn()
                .enterSecurityCode();
        dashboardPage
                .clickNewPaymentBtn()
                .clickPaymentMethod()
                .clickFasterPayments()
                .clickIbanBtn()
                .enterRecipientsIban("GB59CLJU04130734766748")
                .enterCompanyNameForTransaction()
                .enterAmountField("1")
                .enterComment()
                .clickSendBtn()
                .clickConfirmTransactionBtn()
                .enterSecurityCode()
                .clickConfirmTransactionFinalBtn();


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(dashboardPage.verifySuccessfullTransaction());
        softAssert.assertAll();

    }

    @Test(groups= {"group1"},priority = 21)
    public void testUserCanMakeOPTransactionGbpFPBusiness() {
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        dashboardPage = new DashboardPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        backOfficePage = new BackOfficePage(driver, testContextPersonal, testContextBusiness);
        openPaydPage = new OpenPaydPage(driver, testContextPersonal, testContextBusiness);

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
                .enterCompanyName()
                .enterRegistrationNumber()
                .selectLegalEntity()
                .enterLegalAddress()
                .enterZipCode()
                .enterLegalAddressCity()
                .selectAddressCountry("AI")
                .selectOfficeAddressCountry()
                .enterBusinessActivity()
                .clickSaveChangesAccountBtn()
                .clickOkBtn()
                .clickProvidersBtn()
                .clickAddProvider()
                .selectProvider("OPEN_PAYD")
                .clickAddBtn()
                .clickOkProvider()
                .clickWalletsBtn()
                .clickAddWalletBtn()
                .selectPaymentProvider("OPEN_PAYD")
                .selectCurrency("GBP")
                .clickCreateBtn()
                .clickOkWallet()
                .clickCheckboxBtn()
                .clickUserBtn()
                .selectUserStatus("ACTIVE")
                .clickSaveChangesUserBtn()
                .clickOkBtn();
        openPaydPage
                .redirectToOpenPayd()
                .enterEmailField()
                .clickContinueBtn()
                .enterPasswordField()
                .clickSignInBtn()
                .clickLinkedClientsBtn()
                .clickClientsBtn()
                .clickLoginAsCustomerBtn()
                .clickAccountBtn()
                .clickActionsBtn()
                .clickSimulatePayInBtn()
                .enterAmount()
                .enterReference()
                .enterSenderAddress()
                .clickCreatePayInBtn()
                .redirectToTheLoginPage();
        loginPage
                .clickCountryCodeBtn()
                .clickCountryBtn()
                .enterPhoneNumberBusiness()
                .enterPassword()
                .clickLogInBtn()
                .enterSecurityCode();
        dashboardPage
                .clickNewPaymentBtn()
                .clickPaymentMethod()
                .clickFasterPayments()
                .clickIbanBtn()
                .enterRecipientsIban("GB59CLJU04130734766748")
                .enterCompanyNameForTransaction()
                .enterAmountField("1")
                .enterComment()
                .clickSendBtn()
                .clickConfirmTransactionBtn()
                .enterSecurityCode()
                .clickConfirmTransactionFinalBtn();


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(dashboardPage.verifySuccessfullTransaction());
        softAssert.assertAll();

    }

    @Test(groups= {"group1"},priority = 22)
    public void testUserCanMakeCJTransactionEurSepaInstantPersonal() {
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        dashboardPage = new DashboardPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        backOfficePage = new BackOfficePage(driver, testContextPersonal, testContextBusiness);
        openPaydPage = new OpenPaydPage(driver, testContextPersonal, testContextBusiness);

        loginPage
                .clickCountryCodeBtn()
                .clickCountryBtn()
                .enterPhoneNumberSelectedAccount()
                .enterPasswordSelectedAccount()
                .clickLogInBtn()
                .enterSecurityCode();
        dashboardPage
                .clickDropDownField()
                .clickNewPaymentBtn()
                .clickAccountNumberBtn()
                .clickEurIban()
                .clickPaymentMethod()
                .clickSepaInstant()
                .enterRecipientsIban("LT68 3250 0349 9180 8042")
                .enterCompanyNameForTransaction()
                .enterAmountField("1")
                .enterComment()
                .clickSendBtn()
                .clickConfirmTransactionBtn()
                .enterSecurityCode()
                .clickConfirmTransactionFinalBtn();


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(dashboardPage.verifySuccessfullTransaction());
        softAssert.assertAll();

    }

    @Test(groups= {"group1"},priority = 23)
    public void testUserCanMakeCJTransactionEurSepaPersonal() {
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        dashboardPage = new DashboardPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        backOfficePage = new BackOfficePage(driver, testContextPersonal, testContextBusiness);
        openPaydPage = new OpenPaydPage(driver, testContextPersonal, testContextBusiness);

        loginPage
                .clickCountryCodeBtn()
                .clickCountryBtn()
                .enterPhoneNumberSelectedAccount()
                .enterPasswordSelectedAccount()
                .clickLogInBtn()
                .enterSecurityCode();
        dashboardPage
                .clickDropDownField()
                .clickNewPaymentBtn()
                .clickAccountNumberBtn()
                .clickEurIban()
                .clickPaymentMethod()
                .enterRecipientsIban("LV56RIKO0001050242347")
                .enterCompanyNameForTransaction()
                .enterAmountField("1")
                .enterComment()
                .clickSendBtn()
                .clickConfirmTransactionBtn()
                .enterSecurityCode()
                .clickConfirmTransactionFinalBtn();


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(dashboardPage.verifySuccessfullTransaction());
        softAssert.assertAll();

    }

    @Test(groups= {"group1"},priority = 24)
    public void testUserCanMakeCJTransactionEurInternalPersonal() {
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        dashboardPage = new DashboardPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        backOfficePage = new BackOfficePage(driver, testContextPersonal, testContextBusiness);
        openPaydPage = new OpenPaydPage(driver, testContextPersonal, testContextBusiness);

        loginPage
                .clickCountryCodeBtn()
                .clickCountryBtn()
                .enterPhoneNumberSelectedAccount()
                .enterPasswordSelectedAccount()
                .clickLogInBtn()
                .enterSecurityCode();
        dashboardPage
                .clickDropDownField()
                .clickNewPaymentBtn()
                .clickAccountNumberBtn()
                .clickEurIban()
                .clickPaymentMethod()
                .clickInternal()
                .enterRecipientsIban("GBXXCLJU04130780046371")
                .enterCompanyNameForTransaction()
                .enterAmountField("1")
                .enterComment()
                .clickSendBtn()
                .clickConfirmTransactionBtn()
                .enterSecurityCode()
                .clickConfirmTransactionFinalBtn();


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(dashboardPage.verifySuccessfullTransaction());
        softAssert.assertAll();

    }

    @Test(groups= {"group1"},priority = 25)
    public void testUserCanMakeCJTransactionEurInternalProviderPersonal() {
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        dashboardPage = new DashboardPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        backOfficePage = new BackOfficePage(driver, testContextPersonal, testContextBusiness);
        openPaydPage = new OpenPaydPage(driver, testContextPersonal, testContextBusiness);

        loginPage
                .clickCountryCodeBtn()
                .clickCountryBtn()
                .enterPhoneNumberSelectedAccount()
                .enterPasswordSelectedAccount()
                .clickLogInBtn()
                .enterSecurityCode();
        dashboardPage
                .clickDropDownField()
                .clickNewPaymentBtn()
                .clickAccountNumberBtn()
                .clickEurIban()
                .clickPaymentMethod()
                .clickInternalProvider()
                .enterRecipientsIban("GB59CLJU04130734766748")
                .enterCompanyNameForTransaction()
                .enterAmountField("1")
                .enterComment()
                .clickSendBtn()
                .clickConfirmTransactionBtn()
                .enterSecurityCode()
                .clickConfirmTransactionFinalBtn();


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(dashboardPage.verifySuccessfullTransaction());
        softAssert.assertAll();

    }

    @Test(groups= {"group1"},priority = 26)
    public void testUserCanMakeOPTransactionUSDSwiftPersonal() {
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        dashboardPage = new DashboardPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        backOfficePage = new BackOfficePage(driver, testContextPersonal, testContextBusiness);
        openPaydPage = new OpenPaydPage(driver, testContextPersonal, testContextBusiness);

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
                .selectAddressCountry("AI")
                .enterAddressField()
                .enterZip()
                .enterAddressCity()
                .clickSaveChangesAccountBtn()
                .clickOkBtn()
                .clickProvidersBtn()
                .clickAddProvider()
                .selectProvider("OPEN_PAYD")
                .clickAddBtn()
                .clickOkProvider()
                .clickWalletsBtn()
                .clickAddWalletBtn()
                .selectPaymentProvider("OPEN_PAYD")
                .selectCurrency("USD")
                .clickCreateBtn()
                .clickOkWallet()
                .clickCheckboxBtn()
                .clickUserBtn()
                .selectUserStatus("ACTIVE")
                .clickSaveBtn()
                .clickOkBtn();
        openPaydPage
                .redirectToOpenPayd()
                .enterEmailField()
                .clickContinueBtn()
                .enterPasswordField()
                .clickSignInBtn()
                .clickLinkedClientsBtn()
                .clickClientsBtn()
                .clickLoginAsCustomerBtn()
                .clickAccountBtn()
                .clickActionsBtn()
                .clickSimulatePayInBtn()
                .enterAmount()
                .enterReference()
                .enterSenderAddress()
                .clickCreatePayInBtn()
                .redirectToTheLoginPage();
        loginPage
                .clickCountryCodeBtn()
                .clickCountryBtn()
                .enterPhoneNumberPersonal()
                .enterPassword()
                .clickLogInBtn()
                .enterSecurityCode();
        dashboardPage
                .clickNewPaymentBtn()
                .enterRecipientsIban("LT68 3250 0349 9180 8042")
                .enterCompanyName()
                .enterRegistrationNumber()
                .enterRecipientsCity()
                .enterRecipientsCountry()
                .enterPostalCode()
                .enterRecipientsAddress()
                .enterAmountField("1")
                .enterComment()
                .clickSendBtn()
                .clickConfirmTransactionBtn()
                .enterSecurityCode()
                .clickConfirmTransactionFinalBtn();


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(dashboardPage.verifySuccessfullTransaction());
        softAssert.assertAll();

    }

    @Test(groups= {"group1"},priority = 27)
    public void testUserCanMakeOPTransactionEURSwiftPersonal() {
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        dashboardPage = new DashboardPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        backOfficePage = new BackOfficePage(driver, testContextPersonal, testContextBusiness);
        openPaydPage = new OpenPaydPage(driver, testContextPersonal, testContextBusiness);

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
                .selectAddressCountry("AI")
                .enterAddressField()
                .enterZip()
                .enterAddressCity()
                .clickSaveChangesAccountBtn()
                .clickOkBtn()
                .clickProvidersBtn()
                .clickAddProvider()
                .selectProvider("OPEN_PAYD")
                .clickAddBtn()
                .clickOkProvider()
                .clickWalletsBtn()
                .clickAddWalletBtn()
                .selectPaymentProvider("OPEN_PAYD")
                .selectCurrency("USD")
                .clickCreateBtn()
                .clickOkWallet()
                .clickAddCurrency()
                .selectPaymentProvider("OPEN_PAYD")
                .selectCurrency("EUR")
                .clickCreateBtn()
                .clickOkWallet()
                .clickCheckboxBtnEur()
                .clickCheckboxBtn()
                .clickUserBtn()
                .selectUserStatus("ACTIVE")
                .clickSaveBtn()
                .clickOkBtn();
        openPaydPage
                .redirectToOpenPayd()
                .enterEmailField()
                .clickContinueBtn()
                .enterPasswordField()
                .clickSignInBtn()
                .clickLinkedClientsBtn()
                .clickClientsBtn()
                .clickLoginAsCustomerBtn()
                .clickAccountBtn()
                .clickActionsBtn()
                .clickSimulatePayInBtn()
                .enterAmount()
                .enterReference()
                .enterSenderAddress()
                .clickCreatePayInBtn()
                .redirectToTheLoginPage();
        loginPage
                .clickCountryCodeBtn()
                .clickCountryBtn()
                .enterPhoneNumberPersonal()
                .enterPassword()
                .clickLogInBtn()
                .enterSecurityCode();
        dashboardPage
                .clickNewPaymentBtn()
                .enterRecipientsIban("LT68 3250 0349 9180 8042")
                .enterCompanyName()
                .enterRegistrationNumber()
                .enterRecipientsCity()
                .enterRecipientsCountry()
                .enterPostalCode()
                .enterRecipientsAddress()
                .enterAmountField("1")
                .enterComment()
                .clickSendBtn()
                .clickConfirmTransactionBtn()
                .enterSecurityCode()
                .clickConfirmTransactionFinalBtn();


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(dashboardPage.verifySuccessfullTransaction());
        softAssert.assertAll();

    }

    @Test(groups= {"group1"},priority = 28)
    public void testUserCanMakeCJTransactionGBPFasterPaymentProviderPersonal() {
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        dashboardPage = new DashboardPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        backOfficePage = new BackOfficePage(driver, testContextPersonal, testContextBusiness);
        openPaydPage = new OpenPaydPage(driver, testContextPersonal, testContextBusiness);

        loginPage
                .clickCountryCodeBtn()
                .clickCountryBtn()
                .enterPhoneNumberSelectedAccount()
                .enterPasswordSelectedAccount()
                .clickLogInBtn()
                .enterSecurityCode();
        dashboardPage
                .clickDropDownField()
                .clickNewPaymentBtn()
                .enterAccountNumber()
                .enterSortCode()
                .enterCompanyNameForTransaction()
                .enterAmountField("1")
                .enterComment()
                .clickSendBtn()
                .clickConfirmTransactionBtn()
                .enterSecurityCode()
                .clickConfirmTransactionFinalBtn();


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(dashboardPage.verifySuccessfullTransaction());
        softAssert.assertAll();

    }

    @Test(groups= {"group1"},priority = 29)
    public void testUserCanMakeCJTransactionGBPInternalProviderPersonal() {
        TestContextPersonal testContextPersonal = new TestContextPersonal();
        TestContextBusiness testContextBusiness = new TestContextBusiness();
        loginPage = new LoginPage(driver, testContextPersonal, testContextBusiness);
        dashboardPage = new DashboardPage(driver, testContextPersonal, testContextBusiness);
        registerPage = new RegisterPage(driver, testContextPersonal, testContextBusiness);
        backOfficePage = new BackOfficePage(driver, testContextPersonal, testContextBusiness);
        openPaydPage = new OpenPaydPage(driver, testContextPersonal, testContextBusiness);

        loginPage
                .clickCountryCodeBtn()
                .clickCountryBtn()
                .enterPhoneNumberSelectedAccount()
                .enterPasswordSelectedAccount()
                .clickLogInBtn()
                .enterSecurityCode();
        dashboardPage
                .clickDropDownField()
                .clickNewPaymentBtn()
                .clickPaymentMethod()
                .clickInternal()
                .clickSecondIbanBtn()
                .enterRecipientsIban("GBXXCLJU04130780086594")
                .enterCompanyNameForTransaction()
                .enterAmountField("1")
                .enterComment()
                .clickSendBtn()
                .clickConfirmTransactionBtn()
                .enterSecurityCode()
                .clickConfirmTransactionFinalBtn();


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(dashboardPage.verifySuccessfullTransaction());
        softAssert.assertAll();

    }
}
