import com.shaft.driver.SHAFT;
import jdk.jfr.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase6ContactUsForm {
    private SHAFT.GUI.WebDriver driver;
    private SHAFT.TestData.JSON testData;
    private HomePage homePage;
    private ContactUsPage contactUsPage;

    @BeforeClass
    public void beforeClass() {
        testData = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/TestData/ContactUsData.json");
    }
    @BeforeMethod
    @Description("Initializes the WebDriver and Pages")
    public void setup() {
        driver = new SHAFT.GUI.WebDriver();
        homePage = new HomePage(driver);
        contactUsPage = new ContactUsPage(driver);
    }
    @Test(description = "ContactUsForm")
    private void ContactUsForm() {
       homePage.navigateToURL(testData.getTestData("WebSite-URL"))
        .validateHomePageVisibility()
        .clickOnContactUsButton();
        contactUsPage.validateGetInTouchVisibility()
                .fillName(testData.getTestData("Name"))
                .fillEmail(testData.getTestData("Email"))
                .fillSubject(testData.getTestData("Subject"))
                .fillMessage(testData.getTestData("Message"))
                .uploadFile()
                .submitForm()
                .handleAlert()
                .validateSuccessMessageVisibility()
                .clickOnHomeButton();
        homePage.validateHomePageVisibility();
    }
    @AfterMethod
    @Description("Close browser after test")
    public void teardown() {
        driver.browser().closeCurrentWindow();
    }
}
