import com.shaft.driver.SHAFT;
import jdk.jfr.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase23VerifyAddressDetailsInCheckoutPage {
    private SHAFT.GUI.WebDriver driver ;
    private SHAFT.TestData.JSON testData;
    private HomePage homePage;
    private LoginPage loginPage;
    private  SignupPage signupPage;
    private ProductsPage productsPage;
    private ProductDetailPage productDetailPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    @BeforeClass
    public void beforeClass() {
        testData = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/TestData/RegisterUserData.json");
    }
    @BeforeMethod
    @Description("Initializes the WebDriver and Pages")
    public void setup() {
        driver = new SHAFT.GUI.WebDriver();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        signupPage = new SignupPage(driver);
        productsPage = new ProductsPage(driver);
        productDetailPage = new ProductDetailPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }
    @Test(description = "Check Out Address Details")
    private void testCase23VerifyAddressDetailsInCheckOut() {
        homePage.navigateToURL(testData.getTestData("WebSite-URL"))
                .validateHomePageVisibility()
                .clickOnSignupLoginButton();
        loginPage.fillSignupName(testData.getTestData("SignupData['Name-s']"))
                .fillSignupEmail(testData.getTestData("SignupData['Email']"))
                .clickSignupButton();
        signupPage.verifyThatEnterAccountInformationIsVisible()
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
                .clickOnViewCartButton();
        cartPage.validateCartPageVisibility()
                .clickOnCheckOutButton();
        checkoutPage.validateAddressFieldContent();
        homePage.clickOnDeleteAccountButton()
                .validateAccountDeletedVerificationVisibility()
                .clickOnContinueDeleteButton();
    }
    @AfterMethod
    @Description("Close browser after test")
    public void teardown(){
        driver.browser().closeCurrentWindow();
    }
     }
