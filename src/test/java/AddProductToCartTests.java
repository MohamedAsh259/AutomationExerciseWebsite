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
        new homePage(driver).navigateToURL(testData.getTestData("WebSite-URL"))
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
        new homePage(driver).validateHomePageVisibility();
        new homePage(driver).VerifyBothProductsAreAddedToCart();
        new homePage(driver).VerifyPricesOfTwoProducts();
        new homePage(driver).VerifyQuantitiesOfTwoProducts();
        new homePage(driver).VerifyTotalPricesOfTwoProducts();
    }
    @AfterMethod
    @Description("Close browser after test")
    public void teardown(){
        driver.browser().closeCurrentWindow();
    }
}
