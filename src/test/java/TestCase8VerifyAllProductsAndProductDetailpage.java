import com.shaft.driver.SHAFT;
import jdk.jfr.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase8VerifyAllProductsAndProductDetailpage {
    private SHAFT.GUI.WebDriver driver;
    private SHAFT.TestData.JSON testData;
    private HomePage homePage;
    private ProductsPage productsPage;
    private ProductDetailPage productDetailPage;

    @BeforeClass
    public void beforeClass() {
        testData = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/TestData/allProductsAndProductDetailData.json");
    }
    @BeforeMethod
    @Description("Initializes the WebDriver and Pages")
    public void setup() {
        driver = new SHAFT.GUI.WebDriver();
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        productDetailPage = new ProductDetailPage(driver);
    }
    @Test(description = "AllProductsAndProductDetailTests")
    private void allProductsAndProductDetail() {
        homePage.navigateToURL(testData.getTestData("WebSite-URL"))
                .validateHomePageVisibility()
                .clickOnProductButton();
        productsPage.validateAllProductsVisibility()
                .validateProductListVisibility()
                .clickOnFirstProductViewButton();
        productDetailPage.validateProductDetailPageVisibility()
                .validateFirstProductDetailsVisibility();
    }
    @AfterMethod
    @Description("Close browser after test")
    public void teardown(){
        driver.browser().closeCurrentWindow();
    }
}