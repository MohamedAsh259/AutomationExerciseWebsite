import com.shaft.driver.SHAFT;
import jdk.jfr.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddProductToCartTests {
    private SHAFT.GUI.WebDriver driver ;

    @BeforeMethod
    @Description("this is a setup class for our test")
    public void setup (){
        driver = new SHAFT.GUI.WebDriver();
    }

    @Test(description = "addProductToCart")
    private void addProductToCart(){
        new addProductToCart(driver).navigateToURL("https://automationexercise.com/")
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
