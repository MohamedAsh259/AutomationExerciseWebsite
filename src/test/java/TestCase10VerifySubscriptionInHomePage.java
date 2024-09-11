import com.shaft.driver.SHAFT;
import jdk.jfr.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase10VerifySubscriptionInHomePage {
    private SHAFT.GUI.WebDriver driver ;
    private SHAFT.TestData.JSON testData;
    private HomePage homePage;
    @BeforeClass
    public void beforeClass() {
        testData = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/TestData/SubscriptionTestsData.json");
    }
    @BeforeMethod
    @Description("Initializes the WebDriver and Pages")
    public void setup () {
        driver = new SHAFT.GUI.WebDriver();
        homePage = new HomePage(driver);
    }
    @Test(description = "subscriptionText")
    private void subscriptionValidationInHomePage () {
        homePage.navigateToURL(testData.getTestData("WebSite-URL"))
                .validateHomePageVisibility()
                .scrollDownToSubscribtionText()
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
