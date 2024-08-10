import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class HomePage {
    private SHAFT.GUI.WebDriver driver;

    //Constructor
    public HomePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private By homePageLogoFeild = By.xpath("//div[@class=\"logo pull-left\"]//img[@src=\"/static/images/home/logo.png\"]");
    private By homePageProductButton = By.xpath("//ul[@class=\"nav navbar-nav\"]//a[@href=\"/products\"]");
    private By homePageCartButton = By.xpath("//ul[@class=\"nav navbar-nav\"]//a[@href=\"/view_cart\"]");
    private By signupLoginButton = By.xpath("//a[@href=\"/login\"]");
    private By contactUsButton = By.xpath("//a[@href=\"/contact_us\"]");
    private By logoutButton = By.xpath("//a[@href=\"/logout\"]");
    private By deleteAccountButton = By.xpath("//a[@href=\"/delete_account\"]");
    private By accountDeletedVerification = By.xpath("//h2[@data-qa=\"account-deleted\"]/b");
    private By deleteContinueButton = By.xpath("//a[@data-qa=\"continue-button\"]");
    private By loggedInAs = By.xpath("//a[contains(text(), \"Logged in as\")]");
    //Actions
    public HomePage navigateToURL(String URL) {
        driver.browser().navigateToURL(URL);
        return this;
    }
    public HomePage clickOnProductButton() {
        driver.element().click(homePageProductButton);
        return this;
    }
    public HomePage clickOnCartButton() {
        driver.element().click(homePageCartButton);
        return this;
    }
    public HomePage clickOnSignupLoginButton() {
        driver.element().click(signupLoginButton);
        return this;
    }
    public HomePage clickOnContactUsButton() {
        driver.element().click(contactUsButton);
        return this;
    }
    public HomePage clickOnLogOutButton() {
        driver.element().click(logoutButton);
        return this;
    }
    public  HomePage clickOnDeleteAccountButton(){
        driver.element().click(deleteAccountButton);
        return this ;
    }
    public  HomePage clickOnContinueDeleteButton(){
        driver.element().click(deleteContinueButton);
        return this ;
    }

    //Assertions
    @Step("Validate that the user is logged in")
    public HomePage validateLogin(){
        driver.element().verifyThat(loggedInAs).isVisible().perform();
        return this;
    }
    @Step("Verify that home page is visible successfully")
    public HomePage validateHomePageVisibility() {
        driver.element().verifyThat(homePageLogoFeild).isVisible().perform();
        return this;
    }
    @Step("Verify that HomePage Product Button is visible successfully")
    public HomePage validateHomePageProductButtonVisibility() {
        driver.element().verifyThat(homePageProductButton).isVisible().perform();
        return this;
    }
    @Step("Verify that HomePage Product Button is visible successfully")
    public HomePage validateHomePageCartButtonVisibility() {
        driver.element().verifyThat(homePageCartButton).isVisible().perform();
        return this;
    }
    @Step("Verify that Signup/Login Button Button is visible successfully")
    public HomePage validateSignupLoginButtonVisibility() {
        driver.element().verifyThat(signupLoginButton).isVisible().perform();
        return this;
    }
    @Step("Verify that ContactUs Button is visible successfully")
    public HomePage validateContactUsButtonVisibility() {
        driver.element().verifyThat(contactUsButton).isVisible().perform();
        return this;
    }
    @Step("Verify that logout Button is visible successfully")
    public HomePage validateLogoutButtonVisibility() {
        driver.element().verifyThat(logoutButton).isVisible().perform();
        return this;
    }
    @Step("Verify that DeleteAccountButton is visible successfully")
    public HomePage validateDeleteAccountButtonVisibility() {
        driver.element().verifyThat(deleteAccountButton).isVisible().perform();
        return this;
    }
    @Step("Verify that accountDeletedVerification is visible successfully")
    public HomePage validateAccountDeletedVerificationVisibility() {
        driver.element().verifyThat(accountDeletedVerification).isVisible().perform();
        return this;
    }
}