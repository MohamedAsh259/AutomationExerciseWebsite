import com.shaft.driver.SHAFT;
import jdk.jfr.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase15PlaceOrderRegisterbeforeCheckout {
    private SHAFT.GUI.WebDriver driver ;
    private SHAFT.TestData.JSON testData;
    private HomePage homePage;
    private ProductsPage productsPage;
    private ProductDetailPage productDetailPage;
    private CartPage cartPage;
    private LoginPage loginPage;
    private SignupPage signupPage;
    private CheckoutPage checkoutPage;
    private PaymentPage paymentPage;

    @BeforeClass
    public void beforeClass() {
        testData = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/TestData/PlaceOrderData.json");
    }
    @BeforeMethod
    @Description("this is a setup class for our test")
    public void setup (){
        driver = new SHAFT.GUI.WebDriver();
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        productDetailPage = new ProductDetailPage(driver);
        cartPage = new CartPage(driver);
        loginPage = new LoginPage(driver);
        signupPage = new SignupPage(driver);
        checkoutPage = new CheckoutPage(driver);
        paymentPage = new PaymentPage(driver);
    }
    @Test(description = "PlaceOrder")
    private void PlaceOrder() {
        homePage.navigateToURL(testData.getTestData("WebSite-URL"))
                .validateHomePageVisibility()
                .clickOnSignupLoginButton();
        loginPage.fillSignupName(testData.getTestData("SignupData['Name-s']")).
                fillSignupEmail(testData.getTestData("SignupData['Email']"))
                .clickSignupButton();
        signupPage.clickOnTitleButton()
                .fillAccountName(testData.getTestData("AccountInformation['Name-A']"))
                .fillAccountPassword(testData.getTestData("AccountInformation['Password']"))
                .selectDayOfBirthDate(testData.getTestData("AccountInformation['Day']"))
                .selectMonthOfBirthDate(testData.getTestData("AccountInformation['Month']"))
                .selectYearsOfBirthDate(testData.getTestData("AccountInformation['Year']"))
                .clickOnNewsLetterButton()
                .clickOnSpeicalOfferButton()
                .addressFirstName(testData.getTestData("AddressInformation['addressFirstName']"))
                .addressLastName(testData.getTestData("AddressInformation['addressLastName']"))
                .companyNameField(testData.getTestData("AddressInformation['companyNameField']"))
                .addressField(testData.getTestData("AddressInformation['addressField']"))
                .addressFieldTwo(testData.getTestData("AddressInformation['addressFieldTwo']"))
                .selectCountryName(testData.getTestData("AddressInformation['CountryName']"))
                .stateField(testData.getTestData("AddressInformation['stateField']"))
                .cityField(testData.getTestData("AddressInformation['cityField']"))
                .zipCodeField(testData.getTestData("AddressInformation['zipCodeField']"))
                .mobileNumber(testData.getTestData("AddressInformation['mobileNumber']"))
                .clickOnCreateAccountButton()
                .verifyThatAccountCreatedIsVisible()
                .clickOnContinueButton();
        homePage.validateLogin()
                .clickOnProductButton();
        productsPage.clickOnFirstProductViewButton();
        productDetailPage.clickOnProductAddToCartButton()
                .clickOnProductContinueShoppingButton()
                .navigateBack();
        productsPage.clickOnSecondProductViewButton();
        productDetailPage.clickOnProductAddToCartButton()
                .clickOnProductContinueShoppingButton();
        homePage.clickOnCartButton();
        cartPage.validateCartPageVisibility()
                .clickOnCheckOutButton();
        checkoutPage.validateAddressFieldVisibility()
                .validateAddressFieldContent()
                .validateReviewOrderFieldVisibility()
                .validateFirstProductContent()
                .validateSecondProductContent()
                .validateActualProductsPrices()
                .fillComment(testData.getTestData("CheckOutComment"))
                .clickOnPlaceOrderButton();
        paymentPage.fillCardNumber(testData.getTestData("CardInformation['fillCardNumber']"))
                .fillCardName(testData.getTestData("CardInformation['fillCardName']"))
                .fillCardCvc(testData.getTestData("CardInformation['fillCardCvc']"))
                .fillCardExpirationMonth(testData.getTestData("CardInformation['fillCardExpirationMonth']"))
                .fillCardExpirationYear(testData.getTestData("CardInformation['fillCardExpirationYear']"))
                .clickOnPayAndConfirmOrderButton();
        productDetailPage.navigateBack();
        paymentPage.validateSuccessfullOrderMessageVisibility();
        homePage.clickOnDeleteAccountButton()
                .validateAccountDeletedVerificationVisibility();
    }
    @AfterMethod
    @Description("Close browser after test")
    public void teardown() {
        driver.browser().closeCurrentWindow();
    }
}
