import com.shaft.driver.SHAFT;
import jdk.jfr.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterUserTests {
    private SHAFT.GUI.WebDriver driver ;
    private SHAFT.TestData.JSON testData;
    @BeforeClass
    public void beforeClass() {
        testData = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/TestData/RegisterUserData.json");
    }
    @BeforeMethod
    @Description("this is a setup class for our test")
    public void setup (){
        driver = new SHAFT.GUI.WebDriver();
    }
@Test(description = "RegisterUser")
private void RegisterUser() {
    new RegisterUser(driver).navigateToURL(testData.getTestData("WebSite-URL"));
    new RegisterUser(driver).validateHomePageVisibility();
    new RegisterUser(driver).clickOnLoginHomePageButton();
    new RegisterUser(driver).validateVisibilityOfNewUserSignup();
    new RegisterUser(driver).fillName(testData.getTestData("SignupData['Name-s']"))
            .fillEmail(testData.getTestData("SignupData['Email']"))
            .clickOnSignUpButton();
    new RegisterUser(driver).verifyThatEnterAccountInformationIsVisible();
    new RegisterUser(driver).clickOnTitleButton()
            .fillAccountName(testData.getTestData("AccountInformation['Name-A']"))
            .fillAccountPassword(testData.getTestData("AccountInformation['Password']"))
            .selectDayOfBirthDate(testData.getTestData("AccountInformation['Day']"))
            .selectMonthOfBirthDate(testData.getTestData("AccountInformation['Month']"))
            .selectYearsOfBirthDate(testData.getTestData("AccountInformation['Year']"))
            .clickOnNewsLetterButton()
            .clickOnSpeicalOfferButton()
            .addressFirstName(testData.getTestData("AddressInformation['addressFirstName']"))
            .addressLastName(testData.getTestData("AddressInformation['addressLastName']"))
            .companyNameField(testData.getTestData("AddressInformation['companyNameField']"))
            .addressField(testData.getTestData("AddressInformation['addressField']"))
            .addressFieldTwo(testData.getTestData("AddressInformation['addressFieldTwo']"))
            .selectCountryName(testData.getTestData("AddressInformation['CountryName']"))
            .stateField(testData.getTestData("AddressInformation['stateField']"))
            .cityField(testData.getTestData("AddressInformation['cityField']"))
            .zipCodeField(testData.getTestData("AddressInformation['zipCodeField']"))
            .mobileNumber(testData.getTestData("AddressInformation['mobileNumber']"))
            .clickOnCreateAccountButton();
    new RegisterUser(driver).verifyThatAccountCreatedIsVisible();
    new RegisterUser(driver).clickOnContinueButton();
    new RegisterUser(driver).verifyLoggedInAsMohamedIsVisible();
    new RegisterUser(driver).clickOnDeleteAccountButton();
    new RegisterUser(driver).verifyDeletedAccountIsVisible();
    new RegisterUser(driver).clickOnContinueButton();
    }
@AfterMethod
@Description("Close browser after test")
public void teardown(){
    driver.browser().closeCurrentWindow();
}
}
