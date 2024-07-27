import com.shaft.driver.SHAFT;
import jdk.jfr.Description;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.*;

import java.io.FileReader;
import java.io.IOException;

public class LoginTests {
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
        new LoginPage(driver).navigateToURL(testData.getTestData("WebSite-URL"))
                .clickOnLoginPageButton()
                .fillLoginData(testData.getTestData("Email"),testData.getTestData("Password"))
                .clickLoginButton().validateLogin();
    }

    @AfterMethod
    @Description("Close browser after test")
    public void teardown(){
        driver.browser().closeCurrentWindow();
    }
}
