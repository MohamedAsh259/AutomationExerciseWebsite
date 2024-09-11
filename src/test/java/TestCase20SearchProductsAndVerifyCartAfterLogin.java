import com.shaft.driver.SHAFT;
import jdk.jfr.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase20SearchProductsAndVerifyCartAfterLogin {
    private SHAFT.GUI.WebDriver driver ;
    private SHAFT.TestData.JSON testData;
    private HomePage homePage;
    private ProductsPage productsPage;
    private CartPage cartPage;
    private LoginPage loginPage;

    @BeforeClass
    public void beforeClass() {
        testData = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/TestData/SearchProductData.json");
    }
    @BeforeMethod
    @Description("Initializes the WebDriver and Pages")
    public void setup () {
        driver = new SHAFT.GUI.WebDriver();
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        loginPage = new LoginPage(driver);
    }
        @Test(description = "searchProducts")
        private void searchProductsAndVerifyCartAfterLogin() {
            homePage.navigateToURL(testData.getTestData("WebSite-URL"))
                    .clickOnProductButton();
            productsPage.validateAllProductsVisibility()
                    .fillProductName(testData.getTestData("ProductName"))
                    .clickOnSearchButton()
                    .validateSearchedProductsVisibility()
                    .validateProductsRelatedToSearchVisibility()
                    .ClickOnAddFirstProductToCartButton()
                    .clickOnContinueShoppingButton()
                    .ClickOnAddSecondProductToCartButton()
                    .clickOnContinueShoppingButton()
                    .ClickOnAddThirdProductToCartButton()
                    .clickOnContinueShoppingButton();
            homePage.clickOnCartButton();
            cartPage.validateProductsVisibilityInCart()
                    .clickOnSignupLogintButton();
            loginPage.fillEmail(testData.getTestData("Email"))
                    .fillPassword(testData.getTestData("Password"))
                    .clickLoginButton();
            homePage.clickOnCartButton();
            cartPage.validateProductsVisibilityInCart();
        }
        @AfterMethod
        @Description("Close browser after test")
        public void teardown() {
            driver.browser().closeCurrentWindow();
        }
    }
