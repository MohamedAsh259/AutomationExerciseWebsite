import com.shaft.driver.SHAFT;
import jdk.jfr.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PlaceOrderBeforeCheckOutTests {
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
        new PlaceOrder(driver).navigateToURL(testData.getTestData("WebSite-URL"));
        new PlaceOrder(driver).validateHomePageVisibility();
        new PlaceOrder(driver).clickOnLoginSignupButton()
                .fillName(testData.getTestData("SignupData['Name-s']"))
                .fillEmail(testData.getTestData("SignupData['Email']"))
                .clickOnSignUpButton()
                .clickOnTitleButton()
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
                .mobileNumber(testData.getTestData("AddressInformation['mobileNumber']"));
        new PlaceOrder(driver).clickOnCreateAccountButton();
        new PlaceOrder(driver).verifyThatAccountCreatedIsVisible();
        new PlaceOrder(driver).clickOnContinueButton();
        new PlaceOrder(driver).verifyLoggedInAsMohamedIsVisible();
        new PlaceOrder(driver).clickOnProductHomeButton()
                .clickOnFirstProductViewButton()
                .clickOnFirstProductAddToCartButton()
                .clickOnFirstProductContinueShoppingButton()
                .navigateBack()
                .clickOnSecondProductViewButton()
                .clickOnSecondProductAddToCartButton()
                .clickOnSecondProductContinueShoppingButton()
                .clickOnHomePageCartButton();
        new PlaceOrder(driver).validateCartPageVisibility();
        new PlaceOrder(driver).clickOnCheckOutButton();
        new PlaceOrder(driver).validateAddressFieldVisibility();
        new PlaceOrder(driver).validateAddressFieldContent();
        new PlaceOrder(driver).validateReviewOrderFieldVisibility();
        new PlaceOrder(driver).validateFirstProductContent();
        new PlaceOrder(driver).validateSecondProductContent();
        new PlaceOrder(driver).validateActualProductPrice();
        new PlaceOrder(driver).fillComment(testData.getTestData("CheckOutComment"))
                .clickOnPlaceOrderButton()
                .fillCardNumber(testData.getTestData("CardInformation['fillCardNumber']"))
                .fillCardName(testData.getTestData("CardInformation['fillCardName']"))
                .fillCardCvc(testData.getTestData("CardInformation['fillCardCvc']"))
                .fillCardExpirationMonth(testData.getTestData("CardInformation['fillCardExpirationMonth']"))
                .fillCardExpirationYear(testData.getTestData("CardInformation['fillCardExpirationYear']"))
                .clickOnPayAndConfirmOrderButton()
                .navigateBack();
        new PlaceOrder(driver).validateSuccessfullOrderMessageVisibility();
        new PlaceOrder(driver).clickOnDeleteAccountButton()
                .verifyDeletedAccountIsVisible();
    }
    @AfterMethod
    @Description("Close browser after test")
    public void teardown() {
        driver.browser().closeCurrentWindow();
    }
}
