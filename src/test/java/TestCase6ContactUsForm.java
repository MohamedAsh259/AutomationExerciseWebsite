import com.shaft.driver.SHAFT;
import jdk.jfr.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase6ContactUsForm {
    private SHAFT.GUI.WebDriver driver;
    private SHAFT.TestData.JSON testData;

    @BeforeClass
    public void beforeClass() {
        testData = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/TestData/ContactUsData.json");
    }

    @BeforeMethod
    @Description("this is a setup class for our test")
    public void setup() {
        driver = new SHAFT.GUI.WebDriver();
    }

    @Test(description = "ContactUsForm")
    private void ContactUsForm() {
        new HomePage(driver).navigateToURL(testData.getTestData("WebSite-URL"))
        .validateHomePageVisibility()
        .clickOnContactUsButton();
        new ContactUsPage(driver).validateGetInTouchVisibility()
                .fillName(testData.getTestData("Name"))
                .fillEmail(testData.getTestData("Email"))
                .fillSubject(testData.getTestData("Subject"))
                .fillMessage(testData.getTestData("Message"))
                .uploadFile()
                .submitForm()
                .handleAlert();
        new ContactUsPage(driver).validateSuccessMessageVisibility();
        new ContactUsPage(driver).clickOnHomeButton();
        new HomePage(driver).validateHomePageVisibility();
    }

    @AfterMethod
    @Description("Close browser after test")
    public void teardown() {
        driver.browser().closeCurrentWindow();
    }
}
