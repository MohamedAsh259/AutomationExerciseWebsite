import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginPage {
    private SHAFT.GUI.WebDriver driver;

    //Constructor
    public LoginPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private By loginPageButton = By.xpath("//a[@href=\"/login\"]");
    private By loginEmailTextField = By.xpath("//input[@data-qa=\"login-email\"]");
    private By loginPasswordTextField = By.xpath("//input[@data-qa=\"login-password\"]");
    private By loginButton = By.xpath("//button[@data-qa=\"login-button\"]");
    private By newUserSignupText = By.xpath("//div[@class=\"signup-form\"]//h2");
    private By signupNameField = By.xpath("//input[@name=\"name\"]");
    private By signupEmailField = By.xpath("//input[@data-qa=\"signup-email\"]");
    private By signupButton = By.xpath("//button[@data-qa=\"signup-button\"]");
    private By loginToYourAccount = By.xpath("//div[@class=\"login-form\"]/h2");
    private By yourEmailOrPasswordIsIncorrectError = By.xpath("//p[text()='Your email or password is incorrect!']");
    private By emailAddressAlreadyExistError = By.xpath("//p[text()='Email Address already exist!']");

    //Actions
    public LoginPage clickOnLoginPageButton() {
        driver.element().click(loginPageButton);
        return this;
    }

    public LoginPage fillEmail(String email) {
        driver.element().type(loginEmailTextField, email);
        return this;
    }

    public LoginPage fillPassword(String password) {
        driver.element().type(loginPasswordTextField, password);
        return this;
    }

    public LoginPage fillLoginData(String email, String password) {
        fillEmail(email);
        fillPassword(password);
        return this;
    }

    public LoginPage clickLoginButton() {
        driver.element().click(loginButton);
        return this;
    }

    public LoginPage fillSignupName(String Name) {
        driver.element().type(signupNameField, Name);
        return this;
    }

    public LoginPage fillSignupEmail(String Email) {
        driver.element().type(signupEmailField, Email);
        return this;
    }

    public LoginPage clickSignupButton() {
        driver.element().click(signupButton);
        return this;
    }

    //Assertions

    @Step("Verify that New User Signup is visible")
    public LoginPage validateVisibilityOfNewUserSignup() {
        driver.element().verifyThat(newUserSignupText).isVisible().perform();
        return this;
    }

    public LoginPage validateVisibilityOfLoginToYourAccount() {
        driver.element().verifyThat(loginToYourAccount).isVisible().perform();
        return this;
    }

    public LoginPage verifyErrorYourEmailOrPasswordIsIncorrectVisibility() {
        driver.element().verifyThat(yourEmailOrPasswordIsIncorrectError).isVisible().perform();
        return this;
    }
    public LoginPage verifyEmailAddressAlreadyExistErrorVisibility() {
        driver.element().verifyThat(emailAddressAlreadyExistError).isVisible().perform();
        return this;
    }
}