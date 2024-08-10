import com.shaft.driver.SHAFT;
import jdk.jfr.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase8VerifyAllProductsAndProductDetailpage {
    private SHAFT.GUI.WebDriver driver;
    private SHAFT.TestData.JSON testData;

    @BeforeClass
    public void beforeClass() {
        testData = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/TestData/allProductsAndProductDetailData.json");
    }
    @BeforeMethod
    @Description("this is a setup class for our test")
    public void setup() {
        driver = new SHAFT.GUI.WebDriver();
    }
    @Test(description = "AllProductsAndProductDetailTests")
    private void allProductsAndProductDetail() {
        new HomePage(driver).navigateToURL(testData.getTestData("WebSite-URL"))
                .validateHomePageVisibility()
                .clickOnProductButton();
        new ProductsPage(driver).validateAllProductsVisibility()
                .validateProductListVisibility()
                .clickOnFirstProductViewButton();
        new ProductDetailPage(driver).validateProductDetailPageVisibility()
                .validateFirstProductDetailsVisibility();
    }
    @AfterMethod
    @Description("Close browser after test")
    public void teardown(){
        driver.browser().closeCurrentWindow();
    }
}