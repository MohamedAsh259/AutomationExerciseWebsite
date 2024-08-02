import com.shaft.driver.SHAFT;
import jdk.jfr.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AllProductsAndProductDetailTests {
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
        new AllProductsAndProductDetailPage(driver).navigateToURL(testData.getTestData("WebSite-URL"));
        new AllProductsAndProductDetailPage(driver).validateHomePageVisibility();
        new AllProductsAndProductDetailPage(driver).clickOnProductButton();
        new AllProductsAndProductDetailPage(driver).validateAllProductsVisibility();
        new AllProductsAndProductDetailPage(driver).validateProductListVisibility();
        new AllProductsAndProductDetailPage(driver).clickOnFirstProductViewButton();
        new AllProductsAndProductDetailPage(driver).validateFirstProductPageVisibility();
        new AllProductsAndProductDetailPage(driver).validateFirstProductNameVisibility();
        new AllProductsAndProductDetailPage(driver).validateFirstProductCategoryVisibility();
        new AllProductsAndProductDetailPage(driver).validateFirstProductPriceVisibility();
        new AllProductsAndProductDetailPage(driver).validateFirstProductAvailabilityVisibility();
        new AllProductsAndProductDetailPage(driver).validateFirstProductConditionVisibility();
        new AllProductsAndProductDetailPage(driver).validateFirstProductBrandVisibility();
    }
    @AfterMethod
    @Description("Close browser after test")
    public void teardown(){
        driver.browser().closeCurrentWindow();
    }




}

