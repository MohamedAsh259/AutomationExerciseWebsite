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
        new cartPage(driver).navigateToURL(testData.getTestData("WebSite-URL"));
        new cartPage(driver).validateHomePageVisibility();
        new cartPage(driver).clickOnProductButton();
        new cartPage(driver).validateAllProductsVisibility();
        new cartPage(driver).validateProductListVisibility();
        new cartPage(driver).clickOnFirstProductViewButton();
        new cartPage(driver).validateFirstProductPageVisibility();
        new cartPage(driver).validateFirstProductNameVisibility();
        new cartPage(driver).validateFirstProductCategoryVisibility();
        new cartPage(driver).validateFirstProductPriceVisibility();
        new cartPage(driver).validateFirstProductAvailabilityVisibility();
        new cartPage(driver).validateFirstProductConditionVisibility();
        new cartPage(driver).validateFirstProductBrandVisibility();
    }
    @AfterMethod
    @Description("Close browser after test")
    public void teardown(){
        driver.browser().closeCurrentWindow();
    }




}

