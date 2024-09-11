import com.shaft.driver.SHAFT;
import jdk.jfr.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase4LogoutUser {
    private SHAFT.GUI.WebDriver driver;
    private SHAFT.TestData.JSON testData;
    private HomePage homePage;
    private LoginPage loginPage;
    @BeforeClass
    public void beforeClass() {
        testData = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/TestData/LoginTestData.json");
    }

    @BeforeMethod
    @Description("Initializes the WebDriver and Pages")
    public void setup() {
        driver = new SHAFT.GUI.WebDriver();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }
    @Test(description = "Test Case 4 Logout User")
    private void logoutUser() {
        homePage.navigateToURL(testData.getTestData("WebSite-URL"))
                .validateHomePageVisibility()
                .clickOnSignupLoginButton();
        loginPage.validateVisibilityOfLoginToYourAccount()
                .fillEmail(testData.getTestData("Email"))
                .fillPassword(testData.getTestData("Password"))
                .clickLoginButton();
        homePage.validateLogin()
                .clickOnLogOutButton();
        loginPage.validateVisibilityOfLoginToYourAccount();
    }

    @AfterMethod
    @Description("Close the browser after the test execution.")
    public void teardown() {
        driver.browser().closeCurrentWindow();
    }
}