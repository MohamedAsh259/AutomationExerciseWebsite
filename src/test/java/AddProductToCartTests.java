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
        new AddProductToCart(driver).navigateToURL(testData.getTestData("WebSite-URL"))
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
        new AddProductToCart(driver).validateHomePageVisibility();
        new AddProductToCart(driver).VerifyBothProductsAreAddedToCart();
        new AddProductToCart(driver).VerifyPricesOfTwoProducts();
        new AddProductToCart(driver).VerifyQuantitiesOfTwoProducts();
        new AddProductToCart(driver).VerifyTotalPricesOfTwoProducts();
    }
    @AfterMethod
    @Description("Close browser after test")
    public void teardown(){
        driver.browser().closeCurrentWindow();
    }
}
