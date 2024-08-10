import com.shaft.driver.SHAFT;
import jdk.jfr.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase1RegisterUser {
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
    new HomePage (driver).navigateToURL(testData.getTestData("WebSite-URL"))
    .validateHomePageVisibility()
    .clickOnSignupLoginButton();
    new LoginPage (driver).validateVisibilityOfNewUserSignup()
            .fillSignupName(testData.getTestData("SignupData['Name-s']"))
            .fillSignupEmail(testData.getTestData("SignupData['Email']"))
            .clickSignupButton();
    new SignupPage(driver).verifyThatEnterAccountInformationIsVisible()
            .clickOnTitleButton()
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
            .clickOnCreateAccountButton()
            .verifyThatAccountCreatedIsVisible()
            .clickOnContinueButton();
    new HomePage (driver).validateLogin()
            .clickOnDeleteAccountButton()
            .validateAccountDeletedVerificationVisibility()
            .clickOnContinueDeleteButton();
    }
@AfterMethod
@Description("Close browser after test")
public void teardown(){
    driver.browser().closeCurrentWindow();
}
}
