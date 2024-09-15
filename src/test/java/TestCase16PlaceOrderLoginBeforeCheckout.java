import com.shaft.driver.SHAFT;
import jdk.jfr.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase16PlaceOrderLoginBeforeCheckout {
    private SHAFT.GUI.WebDriver driver ;
    private SHAFT.TestData.JSON testData;
    private HomePage homePage;
    private ProductsPage productsPage;
    private ProductDetailPage productDetailPage;
    private CartPage cartPage;
    private LoginPage loginPage;
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
        checkoutPage = new CheckoutPage(driver);
        paymentPage = new PaymentPage(driver);
    }
    @Test(description = "PlaceOrder")
    private void PlaceOrder() {
        homePage.navigateToURL(testData.getTestData("WebSite-URL"))
                .validateHomePageVisibility()
                .clickOnSignupLoginButton();
        loginPage.fillEmail(testData.getTestData("SignupData['Email']")).
                fillPassword(testData.getTestData("AccountInformation['Password']"))
                .clickLoginButton();
        homePage.validateLogin();
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