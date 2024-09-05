import com.shaft.driver.SHAFT;
import jdk.jfr.Description;
import org.testng.annotations.*;

public class TestCase2LoginUserWithCorrectEmailAndPassword {
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
    public void setup (){
        driver = new SHAFT.GUI.WebDriver();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test(description = "Validate user login")
    private void validateLogin(){
       homePage.navigateToURL(testData.getTestData("WebSite-URL"))
                .clickOnSignupLoginButton();
       loginPage.fillLoginData(testData.getTestData("Email"),testData.getTestData("Password"))
                .clickLoginButton();
       homePage.validateLogin();
    }
    @AfterMethod
    @Description("Close browser after test")
    public void teardown(){
        driver.browser().closeCurrentWindow();
    }
}
