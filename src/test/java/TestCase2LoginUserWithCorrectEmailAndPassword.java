import com.shaft.driver.SHAFT;
import jdk.jfr.Description;
import org.testng.annotations.*;

public class TestCase2LoginUserWithCorrectEmailAndPassword {
    private SHAFT.GUI.WebDriver driver;
    private SHAFT.TestData.JSON testData;

    @BeforeClass
    public void beforeClass() {
        testData = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/TestData/LoginTestData.json");
    }

    @BeforeMethod
    @Description("this is a setup class for our test")
    public void setup (){
        driver = new SHAFT.GUI.WebDriver();
    }

    @Test(description = "Validate user login")
    private void validateLogin(){
        new HomePage(driver).navigateToURL(testData.getTestData("WebSite-URL"))
                .clickOnSignupLoginButton();
        new LoginPage(driver).fillLoginData(testData.getTestData("Email"),testData.getTestData("Password"))
                .clickLoginButton();
        new HomePage(driver).validateLogin();
    }
    @AfterMethod
    @Description("Close browser after test")
    public void teardown(){
        driver.browser().closeCurrentWindow();
    }
}
