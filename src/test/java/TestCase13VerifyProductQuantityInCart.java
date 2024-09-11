import com.shaft.driver.SHAFT;
import jdk.jfr.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase13VerifyProductQuantityInCart {
    private SHAFT.GUI.WebDriver driver ;
    private SHAFT.TestData.JSON testData;
    private HomePage homePage;
    private ProductsPage productsPage;
    private ProductDetailPage productDetailPage;
    private CartPage cartPage;
    @BeforeClass
    public void beforeClass() {
        testData = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/TestData/ProductDetailPageTestData.json");
    }
    @BeforeMethod
    @Description("Initializes the WebDriver and Pages")
    public void setup (){
        driver = new SHAFT.GUI.WebDriver();
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        productDetailPage = new ProductDetailPage(driver);
        cartPage = new CartPage(driver);}
    @Test(description = "Product Quantity")
    private void productQuantityInCart() {
        homePage.navigateToURL(testData.getTestData("WebSite-URL"))
                .validateHomePageVisibility()
                .clickOnFirstProductViewButton();
        productDetailPage.validateProductDetailPageVisibility()
                .fillProductQuantity(testData.getTestData("Quantity-Number"))
                .clickOnProductAddToCartButton()
                .clickOnViewCartButton();
        cartPage. VerifyProductIsAddedToCart()
                .VerifyProductQuantityAddedToCart();
}
    @AfterMethod
    @Description("Close browser after test")
    public void teardown(){
        driver.browser().closeCurrentWindow();
    }
}
