import com.shaft.driver.SHAFT;
import jdk.jfr.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase12AddProductToCart {
    private SHAFT.GUI.WebDriver driver ;
    private SHAFT.TestData.JSON testData;
    @BeforeClass
    public void beforeClass() {
        testData = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/TestData/AddProductToCartData.json");
    }

    @BeforeMethod
    @Description("this is a setup class for our test")
    public void setup (){
        driver = new SHAFT.GUI.WebDriver();
    }

    @Test(description = "addProductToCart")
    private void addProductToCart(){
        new HomePage (driver).navigateToURL(testData.getTestData("WebSite-URL"))
                .validateHomePageVisibility()
                .clickOnProductButton();
        new ProductsPage (driver).clickOnFirstProductViewButton();
        new ProductDetailPage (driver).clickOnProductAddToCartButton()
                .clickOnProductContinueShoppingButton()
                .navigateBack();
        new ProductsPage (driver).clickOnSecondProductViewButton();
        new ProductDetailPage (driver).clickOnProductAddToCartButton()
                .clickOnViewCartButton();
        new CartPage (driver).VerifyBothProductsAreAddedToCart()
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
