import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class SignupPage {
    private SHAFT.GUI.WebDriver driver ;

    //Constructor
    public SignupPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver ;
    }

    //Locators
    private By enterAccountInformationText = By.xpath("//b[contains(text(), 'Enter Account Information')]");
    private By createAccountnameField = By.xpath("//input[@name=\"name\"]");
    private By createAccountEmailField = By.xpath("//input[@name=\"email\"]");
    private By createAccountPasswordField = By.xpath("//input[@name=\"password\"]");
    private By daysForDateOfBirth = By.xpath("//select[@name=\"days\"]");
    private By monthsForDateOfBirth = By.xpath("//select[@name=\"months\"]");
    private By yearsForDateOfBirth = By.xpath("//select[@name=\"years\"]");
    private By tilteButton = By.xpath("//input[@id=\"id_gender1\"]");
    private By newsletter = By.xpath("//input[@id=\"newsletter\"]");
    private By speicalOfferButton = By.xpath("//input[@name=\"optin\"]");
    private By addressFirstNameField = By.xpath("//input[@name=\"first_name\"]");
    private By addressLastNameField = By.xpath("//input[@name=\"last_name\"]");
    private By companyNameField = By.xpath("//input[@ name=\"company\"]");
    private By addressField = By.xpath("//input[@name=\"address1\"]");
    private By addressFieldTwo = By.xpath("//input[@name=\"address2\"]");
    private By countryName = By.xpath("//select[@name=\"country\"]");
    private By stateName = By.xpath("//input[@name=\"state\"]");
    private By cityName = By.xpath("//input[@name=\"city\"]");
    private By zipCode = By.xpath("//input[@name=\"zipcode\"]");
    private By mobileNumber = By.xpath("//input[@name=\"mobile_number\"]");
    private By createAccountButton = By.xpath("//button[@data-qa=\"create-account\"]");
    private By accountCreatedVerification = By.xpath("//h2[@data-qa=\"account-created\"]");
    private By continueButton = By.xpath("//a[@data-qa=\"continue-button\"]");
    //Actions
    //Enter Account Information
    public SignupPage fillAccountName(String AccountName){
        driver.element().type(createAccountnameField, AccountName);
        return this ;
    }
    public SignupPage fillAccountEmail(String AccountEmail){
        driver.element().type(createAccountEmailField, AccountEmail);
        return this ;
    }
    public SignupPage fillAccountPassword(String AccountPassword){
        driver.element().type(createAccountPasswordField, AccountPassword);
        return this ;
    }
    public SignupPage selectDayOfBirthDate(String SelectDay){
        driver.element().select(daysForDateOfBirth, SelectDay);
        return this ;
    }
    public SignupPage selectMonthOfBirthDate(String SelectMonth){
        driver.element().select(monthsForDateOfBirth, SelectMonth);
        return this ;
    }
    public SignupPage selectYearsOfBirthDate(String SelectYear){
        driver.element().select(yearsForDateOfBirth, SelectYear);
        return this ;
    }
    public SignupPage clickOnTitleButton(){
        driver.element().click(tilteButton);
        return this ;
    }
    public SignupPage clickOnNewsLetterButton(){
        driver.element().click(newsletter);
        return this ;
    }
    public SignupPage clickOnSpeicalOfferButton(){
        driver.element().click(speicalOfferButton);
        return this ;
    }
    //Address Information
    public SignupPage addressFirstName(String AddressFirstName){
        driver.element().type(addressFirstNameField, AddressFirstName);
        return this ;
    }
    public SignupPage addressLastName(String AddressLastName){
        driver.element().type(addressLastNameField, AddressLastName);
        return this ;
    }
    public SignupPage companyNameField(String CompanyName){
        driver.element().type(companyNameField, CompanyName);
        return this ;
    }
    public SignupPage addressField(String Address){
        driver.element().type(addressField, Address);
        return this ;
    }
    public SignupPage addressFieldTwo(String AddressTwo){
        driver.element().type(addressFieldTwo, AddressTwo);
        return this ;
    }
    public SignupPage selectCountryName(String SelectCountry){
        driver.element().select(countryName, SelectCountry);
        return this ;
    }
    public SignupPage stateField(String StateName){
        driver.element().type(stateName,StateName);
        return this ;
    }
    public SignupPage cityField(String CityName){
        driver.element().type(cityName,CityName);
        return this ;
    }
    public SignupPage zipCodeField(String ZipCode){
        driver.element().type(zipCode,ZipCode);
        return this ;
    }
    public SignupPage mobileNumber(String MobileNumber){
        driver.element().type(mobileNumber,MobileNumber);
        return this ;
    }
    public SignupPage clickOnCreateAccountButton(){
        driver.element().click(createAccountButton);
        return this ;
    }
    public SignupPage clickOnContinueButton(){
        driver.element().click(continueButton);
        return this ;
    }

    //Assertions
    @Step("Verify that ENTER ACCOUNT INFORMATION is visible")
    public SignupPage verifyThatEnterAccountInformationIsVisible(){
        driver.element().verifyThat(enterAccountInformationText).isVisible().perform();
        return this;
    }
    @Step("Verify that Account Created is visible")
    public SignupPage verifyThatAccountCreatedIsVisible(){
        driver.element().verifyThat(accountCreatedVerification).isVisible().perform();
        return this;
    }
       }
