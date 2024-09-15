import com.shaft.driver.SHAFT;
import jdk.jfr.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase25VerifyScrollUpUsingArrowButtonAndScrollDownFunctionality {
    private SHAFT.GUI.WebDriver driver ;
    private SHAFT.TestData.JSON testData;
    private HomePage homePage;
    @BeforeClass
    public void beforeClass() {
        testData = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/TestData/RegisterUserData.json");
    }
    @BeforeMethod
    @Description("Initializes the WebDriver and Pages")
    public void setup() {
        driver = new SHAFT.GUI.WebDriver();
        homePage = new HomePage(driver);
    }
    @Test(description = "Verify Scroll Up And Down With Arrow")
    private void testCase25VerifyScrollUpAndDownWithArrow() {
        homePage.navigateToURL(testData.getTestData("WebSite-URL"))
                .validateHomePageVisibility()
                .scrollToSubscribtionText()
                .validateSubscribtionTextVisibility()
                .clickOnMoveUpButton()
                .validateFullFledgedPracticeTextVisibility();
}
    @AfterMethod
    @Description("Close browser after test")
    public void teardown(){
        driver.browser().closeCurrentWindow();
    }
 }
