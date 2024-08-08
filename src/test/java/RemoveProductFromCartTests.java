import com.shaft.driver.SHAFT;
import jdk.jfr.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveProductFromCartTests {
    private SHAFT.GUI.WebDriver driver ;
    private SHAFT.TestData.JSON testData;
    @BeforeClass
    public void beforeClass() {
        testData = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/TestData/RemoveProductFromCartData.json");
    }
    @BeforeMethod
    @Description("this is a setup class for our test")
    public void setup (){
        driver = new SHAFT.GUI.WebDriver();
    }

    @Test(description = "removeProduct")
    private void removeProduct() {
        new productPage(driver).navigateToURL(testData.getTestData("WebSite-URL"));
        new productPage(driver).validateHomePageVisibility();
        new productPage(driver).clickOnProductButton()
                .clickOnFirstProductViewButton()
                .clickOnFirstProductAddToCartButton()
                .clickOnFirstProductContinueShoppingButton()
                .clickOnHomePageCartButton();
        new productPage(driver).validateCartPageVisibility();
        new productPage(driver).clickOnRemoveProductButton();
        new productPage(driver).validateProductIsRemoved();
    }
        @AfterMethod
        @Description("Close browser after test")
        public void teardown(){
            driver.browser().closeCurrentWindow();
    }}

















