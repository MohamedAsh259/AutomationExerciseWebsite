import com.shaft.driver.SHAFT;
import jdk.jfr.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase11VerifySubscriptionInCartPage {
    private SHAFT.GUI.WebDriver driver;
    private SHAFT.TestData.JSON testData;
    private HomePage homePage;
    private CartPage cartPage;

    @BeforeClass
    public void beforeClass() {
        testData = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/TestData/SubscriptionTestsData.json");
    }

    @BeforeMethod
    @Description("Initializes the WebDriver and Pages")
    public void setup() {
        driver = new SHAFT.GUI.WebDriver();
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
    }

    @Test(description = "subscriptionText")
    private void subscriptionValidationInCart() {
        homePage.navigateToURL(testData.getTestData("WebSite-URL"))
                .validateHomePageVisibility()
                .clickOnCartButton();
        cartPage.scrollDownToSubscribtionText()
                .validateSubscribtionTextContent().
                fillEmail(testData.getTestData("Subscription-Mail"))
                .clickOnSubscriptionButton().
                validateSubscriptionSuccessMessageVisibility();
    }

    @AfterMethod
    @Description("Close browser after test")
    public void teardown() {
        driver.browser().closeCurrentWindow();
    }
}