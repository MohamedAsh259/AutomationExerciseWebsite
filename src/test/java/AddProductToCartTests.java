import com.shaft.driver.SHAFT;
import jdk.jfr.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddProductToCartTests {
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
        new addProductToCart(driver).navigateToURL(testData.getTestData("WebSite-URL"))
                .clickOnProductButton()
                .clickOnFirstProductViewButton()
                .clickOnFirstProductAddToCartButton()
                .clickOnFirstProductContinueShoppingButton()
                .navigateBack()
                .clickOnSecondProductViewButton()
                .clickOnSecondProductAddToCartButton()
                .clickOnSecondProductContinueShoppingButton()
                .clickOnHomePageCartButton();

        //perform assertion
        new addProductToCart(driver).validateHomePageVisibility();
        new addProductToCart(driver).VerifyBothProductsAreAddedToCart();
        new addProductToCart(driver).VerifyPricesOfTwoProducts();
        new addProductToCart(driver).VerifyQuantitiesOfTwoProducts();
        new addProductToCart(driver).VerifyTotalPricesOfTwoProducts();
    }
    @AfterMethod
    @Description("Close browser after test")
    public void teardown(){
        driver.browser().closeCurrentWindow();
    }
}
