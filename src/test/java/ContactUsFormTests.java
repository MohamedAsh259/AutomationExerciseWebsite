import com.shaft.driver.SHAFT;
import jdk.jfr.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactUsFormTests {
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
        new ContactUsForm(driver).navigateToURL(testData.getTestData("WebSite-URL"));
        new ContactUsForm(driver).validateHomePageVisibility();
        new ContactUsForm(driver).clickOnContactUsButton();
        new ContactUsForm(driver).validateGetInTouchVisibility();
        new ContactUsForm(driver).fillName(testData.getTestData("Name"))
                .fillEmail(testData.getTestData("Email"))
                .fillSubject(testData.getTestData("Subject"))
                .fillMessage(testData.getTestData("Message"));
        new ContactUsForm(driver).uploadFile()
                .submitForm()
                .handleAlert();
        new ContactUsForm(driver).validateSuccessMessageVisibility();
        new ContactUsForm(driver).clickOnHomeButton();
        new ContactUsForm(driver).validateHomePageVisibility();
    }

    @AfterMethod
    @Description("Close browser after test")
    public void teardown() {
        driver.browser().closeCurrentWindow();
    }
}
