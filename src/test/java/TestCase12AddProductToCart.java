import com.shaft.driver.SHAFT;
import jdk.jfr.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase12AddProductToCart {
    private SHAFT.GUI.WebDriver driver ;
    private SHAFT.TestData.JSON testData;
    private HomePage homePage;
    private ProductsPage productsPage;
    private ProductDetailPage productDetailPage;
    private CartPage cartPage;

    @BeforeClass
    public void beforeClass() {
        testData = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/TestData/AddProductToCartData.json");
    }

    @BeforeMethod
    @Description("Initializes the WebDriver and Pages")
    public void setup (){
        driver = new SHAFT.GUI.WebDriver();
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        productDetailPage = new ProductDetailPage(driver);
        cartPage = new CartPage(driver);

    }
    @Test(description = "AddProductToCart")
    private void addProductToCart(){
        homePage.navigateToURL(testData.getTestData("WebSite-URL"))
                .validateHomePageVisibility()
                .clickOnProductButton();
        productsPage.clickOnFirstProductViewButton();
        productDetailPage.clickOnProductAddToCartButton()
                .clickOnProductContinueShoppingButton()
                .navigateBack();
        productsPage.clickOnSecondProductViewButton();
        productDetailPage.clickOnProductAddToCartButton()
                .clickOnViewCartButton();
        cartPage.VerifyBothProductsAreAddedToCart()
                .VerifyPricesOfTwoProducts()
                .VerifyQuantitiesOfTwoProducts()
                .VerifyTotalPricesOfTwoProducts();
    }
    @AfterMethod
    @Description("Close browser after test")
    public void teardown(){
        driver.browser().closeCurrentWindow();
    }
}
