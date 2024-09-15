import com.shaft.driver.SHAFT;
import jdk.jfr.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase21AddReviewOnProduct {
    private SHAFT.GUI.WebDriver driver ;
    private SHAFT.TestData.JSON testData;
    private HomePage homePage;
    private ProductsPage productsPage;
    @BeforeClass
    public void beforeClass() {
        testData = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/TestData/ReviewProductData.json");
    }
    @BeforeMethod
    @Description("Initializes the WebDriver and Pages")
    public void setup() {
        driver = new SHAFT.GUI.WebDriver();
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
    }
    @Test(description = "ProductReview")
    private void testCase21AddReview() {
        homePage.navigateToURL(testData.getTestData("WebSite-URL"))
                .clickOnProductButton();
        productsPage.validateAllProductsVisibility()
                .clickOnFirstProductViewButton()
                .validateReviewProductsVisibility()
                .fillReviewName(testData.getTestData("Name"))
                .fillReviewEmail(testData.getTestData("Email"))
                .addReview(testData.getTestData("Review-Comment"))
                .clickOnSubmitReviewButton()
                .validateReviewSuccessfullMessageVisibility();
    }
    @AfterMethod
    @Description("Close browser after test")
    public void teardown(){
        driver.browser().closeCurrentWindow();
    }
}
