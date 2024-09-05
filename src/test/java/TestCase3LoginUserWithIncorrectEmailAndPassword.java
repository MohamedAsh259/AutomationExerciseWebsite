import com.shaft.driver.SHAFT;
import jdk.jfr.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase3LoginUserWithIncorrectEmailAndPassword {
    private SHAFT.GUI.WebDriver driver;
    private SHAFT.TestData.JSON testData;
    private HomePage homePage;
    private LoginPage loginPage;

    @BeforeClass
    public void beforeClass() {
        // Load test data from JSON file
        testData = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/TestData/LoginTestData.json");
    }

    @BeforeMethod
    @Description("Initializes the WebDriver and Pages")
    public void setup() {
        driver = new SHAFT.GUI.WebDriver();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test(description = "Login User with Incorrect Email And Password")
    private void testCase3LoginUserWithIncorrectEmailAndPassword() {
        // Navigate to website URL
        homePage.navigateToURL(testData.getTestData("WebSite-URL"))
                .validateHomePageVisibility()  // Assert that home page is visible
                .clickOnSignupLoginButton();  // Click "Sign Up / Login" button
        loginPage.validateVisibilityOfLoginToYourAccount()  // Verify Login to your account is visible
                .fillEmail(testData.getTestData("Email"))
                .fillPassword(testData.getTestData("Password"))
                .clickLoginButton() // Proceed to sign-up
                .verifyErrorYourEmailOrPasswordIsIncorrectVisibility();
    }

    @AfterMethod
    @Description("Close the browser after the test execution.")
    public void teardown() {
        driver.browser().closeCurrentWindow();  // Close the browser
    }
}
