import com.shaft.driver.SHAFT;
import jdk.jfr.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase15PlaceOrderRegisterbeforeCheckout {
    private SHAFT.GUI.WebDriver driver ;
    private SHAFT.TestData.JSON testData;
    @BeforeClass
    public void beforeClass() {
        testData = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/TestData/PlaceOrderData.json");
    }
    @BeforeMethod
    @Description("this is a setup class for our test")
    public void setup (){
        driver = new SHAFT.GUI.WebDriver();
    }
    @Test(description = "PlaceOrder")
    private void PlaceOrder() {
        new HomePage(driver).navigateToURL(testData.getTestData("WebSite-URL"))
                .validateHomePageVisibility()
                .clickOnSignupLoginButton();
        new LoginPage(driver).fillSignupName(testData.getTestData("SignupData['Name-s']")).
                fillSignupEmail(testData.getTestData("SignupData['Email']"))
                .clickSignupButton();
        new SignupPage(driver).clickOnTitleButton()
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
        new HomePage(driver).validateLogin()
                .clickOnProductButton();
        new ProductsPage(driver).clickOnFirstProductViewButton();
        new ProductDetailPage(driver).clickOnProductAddToCartButton()
                .clickOnProductContinueShoppingButton()
                .navigateBack();
        new ProductsPage(driver).clickOnSecondProductViewButton();
        new ProductDetailPage(driver).clickOnProductAddToCartButton()
                .clickOnProductContinueShoppingButton();
        new HomePage(driver).clickOnCartButton();
        new CartPage(driver).validateCartPageVisibility()
                .clickOnCheckOutButton();
        new CheckoutPage(driver).validateAddressFieldVisibility()
                .validateAddressFieldContent()
                .validateReviewOrderFieldVisibility()
                .validateFirstProductContent()
                .validateSecondProductContent()
                .validateActualProductsPrices()
                .fillComment(testData.getTestData("CheckOutComment"))
                .clickOnPlaceOrderButton();
        new PaymentPage(driver).fillCardNumber(testData.getTestData("CardInformation['fillCardNumber']"))
                .fillCardName(testData.getTestData("CardInformation['fillCardName']"))
                .fillCardCvc(testData.getTestData("CardInformation['fillCardCvc']"))
                .fillCardExpirationMonth(testData.getTestData("CardInformation['fillCardExpirationMonth']"))
                .fillCardExpirationYear(testData.getTestData("CardInformation['fillCardExpirationYear']"))
                .clickOnPayAndConfirmOrderButton();
        new ProductDetailPage(driver).navigateBack();
        new PaymentPage(driver).validateSuccessfullOrderMessageVisibility();
        new HomePage(driver).clickOnDeleteAccountButton()
                .validateAccountDeletedVerificationVisibility();
    }
    @AfterMethod
    @Description("Close browser after test")
    public void teardown() {
        driver.browser().closeCurrentWindow();
    }
}
