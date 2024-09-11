import com.shaft.driver.SHAFT;
import jdk.jfr.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase5RegisterUserWithExistingEmail {
    private SHAFT.GUI.WebDriver driver;
    private SHAFT.TestData.JSON testData;
    private HomePage homePage;
    private LoginPage loginPage;
    @BeforeClass
    public void beforeClass() {
        testData = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/TestData/RegisterUserData.json");
    }

    @BeforeMethod
    @Description("Initializes the WebDriver and Pages")
    public void setup() {
        driver = new SHAFT.GUI.WebDriver();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test(description = "Test Case 5 Register User With Existing Email")
    private void registerUserWithExistingEmail() {
        homePage.navigateToURL(testData.getTestData("WebSite-URL"))
                .validateHomePageVisibility()
                .clickOnSignupLoginButton();
        loginPage.validateVisibilityOfNewUserSignup()
                .fillSignupName(testData.getTestData("SignupData['Name-s']"))
                .fillSignupEmail(testData.getTestData("SignupData['Email']"))
                .clickSignupButton()
                .verifyEmailAddressAlreadyExistErrorVisibility();
    }

    @AfterMethod
    @Description("Close the browser after the test execution.")
    public void teardown() {
        driver.browser().closeCurrentWindow();
    }




















}
