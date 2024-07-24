import com.shaft.driver.SHAFT;
import jdk.jfr.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterUserTests {
    private SHAFT.GUI.WebDriver driver ;

    @BeforeMethod
    @Description("this is a setup class for our test")
    public void setup (){
        driver = new SHAFT.GUI.WebDriver();
    }
@Test(description = "RegisterUser")
private void RegisterUser() {
    new RegisterUser(driver).navigateToURL("https://automationexercise.com/");
    new RegisterUser(driver).validateHomePageVisibility();
    new RegisterUser(driver).clickOnLoginHomePageButton();
    new RegisterUser(driver).validateVisibilityOfNewUserSignup();
    new RegisterUser(driver).fillName("Mohamed").fillEmail("GODOFWAR12120@gmail.com").clickOnSignUpButton();
    new RegisterUser(driver).verifyThatEnterAccountInformationIsVisible();
    new RegisterUser(driver).clickOnTitleButton().fillAccountName("Mohamed")
            .fillAccountPassword("Mohamed259")
            .selectDayOfBirthDate("25")
            .selectMonthOfBirthDate("9")
            .selectYearsOfBirthDate("1998")
            .clickOnNewsLetterButton()
            .clickOnSpeicalOfferButton()
            .addressFirstName("cairo")
            .addressLastName("khanka")
            .companyNameField("ICE")
            .addressField("cairo")
            .addressFieldTwo("cairo-c")
            .selectCountryName("United States")
            .stateField("cairo")
            .cityField("Benha")
            .zipCodeField("0000")
            .mobileNumber("01113635939")
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
