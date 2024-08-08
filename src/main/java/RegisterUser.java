import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import io.qameta.allure.Step;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;

import javax.naming.Name;

public class RegisterUser {
    private SHAFT.GUI.WebDriver driver ;

    //Constructor
    public RegisterUser(SHAFT.GUI.WebDriver driver){
        this.driver = driver ;
    }

    //Locators
    private By homePageLogoFeild = By.xpath("//div[@class=\"logo pull-left\"]//img[@src=\"/static/images/home/logo.png\"]");
    private By loginHomePageButton = By.xpath("//a[@href=\"/login\"]");
    private By newUserSignup = By.xpath("//div[@class=\"signup-form\"]//h2");

    //Actions
    //Before create account
    public RegisterUser navigateToURL(String URL){
        driver.browser().navigateToURL(URL);
        return this ;
    }
    public RegisterUser clickOnLoginHomePageButton(){
        driver.element().click(loginHomePageButton);
        return this ;
    }
        public RegisterUser fillName(String Name){
            driver.element().type(nameField, Name);
            return this ;
        }
    public RegisterUser fillEmail(String Email){
        driver.element().type(emailField, Email);
        return this ;
    }
    public RegisterUser clickOnSignUpButton(){
        driver.element().click(signupButton);
        return this ;
    }
    //Enter Account Information
    public RegisterUser fillAccountName(String AccountName){
        driver.element().type(createAccountnameField, AccountName);
        return this ;
    }
    public RegisterUser fillAccountEmail(String AccountEmail){
        driver.element().type(createAccountEmailField, AccountEmail);
        return this ;
    }
    public RegisterUser fillAccountPassword(String AccountPassword){
        driver.element().type(createAccountPasswordField, AccountPassword);
        return this ;
    }
    public RegisterUser selectDayOfBirthDate(String SelectDay){
        driver.element().select(daysForDateOfBirth, SelectDay);
        return this ;
    }
    public RegisterUser selectMonthOfBirthDate(String SelectMonth){
        driver.element().select(monthsForDateOfBirth, SelectMonth);
        return this ;
    }
    public RegisterUser selectYearsOfBirthDate(String SelectYear){
        driver.element().select(yearsForDateOfBirth, SelectYear);
        return this ;
    }
    public RegisterUser clickOnTitleButton(){
        driver.element().click(tilteButton);
        return this ;
    }
    public RegisterUser clickOnNewsLetterButton(){
        driver.element().click(newsletter);
        return this ;
    }
    public RegisterUser clickOnSpeicalOfferButton(){
        driver.element().click(speicalOfferButton);
        return this ;
    }
    //Address Information
    public RegisterUser addressFirstName(String AddressFirstName){
        driver.element().type(addressFirstNameField, AddressFirstName);
        return this ;
    }
    public RegisterUser addressLastName(String AddressLastName){
        driver.element().type(addressLastNameField, AddressLastName);
        return this ;
    }
    public RegisterUser companyNameField(String CompanyName){
        driver.element().type(companyNameField, CompanyName);
        return this ;
    }
    public RegisterUser addressField(String Address){
        driver.element().type(addressField, Address);
        return this ;
    }
    public RegisterUser addressFieldTwo(String AddressTwo){
        driver.element().type(addressFieldTwo, AddressTwo);
        return this ;
    }
    public RegisterUser selectCountryName(String SelectCountry){
        driver.element().select(countryName, SelectCountry);
        return this ;
    }
    public RegisterUser stateField(String StateName){
        driver.element().type(stateName,StateName);
        return this ;
    }
    public RegisterUser cityField(String CityName){
        driver.element().type(cityName,CityName);
        return this ;
    }
    public RegisterUser zipCodeField(String ZipCode){
        driver.element().type(zipCode,ZipCode);
        return this ;
    }
    public RegisterUser mobileNumber(String MobileNumber){
        driver.element().type(mobileNumber,MobileNumber);
        return this ;
    }
    public RegisterUser clickOnCreateAccountButton(){
        driver.element().click(createAccountButton);
        return this ;
    }
//After Account Creation
public RegisterUser clickOnContinueButton(){
    driver.element().click(continueButton);
    return this ;
}
    public RegisterUser clickOnDeleteAccountButton(){
        driver.element().click(deleteAccountButton);
        return this ;
    }
    public RegisterUser clickOnContinueDeleteButton(){
        driver.element().click(deleteContinueButton);
        return this ;
    }
    //Assertions
    @Step("Verify that home page is visible successfully")
    public void validateHomePageVisibility(){
        driver.element().verifyThat(homePageLogoFeild).isVisible().perform();
    }
    @Step("Verify that New User Signup is visible")
    public void validateVisibilityOfNewUserSignup(){
        driver.element().verifyThat(newUserSignup).isVisible().perform();
    }
    @Step("Verify that ENTER ACCOUNT INFORMATION is visible")
    public void verifyThatEnterAccountInformationIsVisible(){
        driver.element().verifyThat(enterAccountInformationText).isVisible().perform();
    }

    @Step("Verify that Account Created is visible")
    public void verifyThatAccountCreatedIsVisible(){
        driver.element().verifyThat(accountCreatedVerification).isVisible().perform();
    }
    @Step("Verify that Account Created is visible")
    public void verifyLoggedInAsMohamedIsVisible(){
        driver.element().verifyThat(loggedInAs).isVisible().perform();
    }
    @Step("Verify that Account Deleted is visible")
    public void verifyDeletedAccountIsVisible(){
        driver.element().verifyThat(accountDeletedVerification).isVisible().perform();
    }
}












































