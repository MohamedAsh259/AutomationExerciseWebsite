import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;

public class LoginPage {
    private SHAFT.GUI.WebDriver driver ;
    //Constructor
    public LoginPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver ;
    }
    //Locators
    private By loginPageButton = By.xpath("//a[@href=\"/login\"]");
    private By loginEmailTextField = By.xpath("//input[@data-qa=\"login-email\"]");
    private By loginPasswordTextField = By.xpath("//input[@data-qa=\"login-password\"]");
    private By loginButton = By.xpath("//button[@data-qa=\"login-button\"]");
    private By logoutButton = By.xpath("//a[@href=\"/logout\"]");
    //Actions
    public LoginPage navigateToURL(String URL){
        driver.browser().navigateToURL(URL);
        return this ;
    }

    public LoginPage clickOnLoginPageButton(){
        driver.element().click(loginPageButton);
        return this ;
    }

    public LoginPage fillEmail(String email){
        driver.element().type(loginEmailTextField,email);
        return this ;
    }

    public LoginPage fillPassword(String password){
        driver.element().type(loginPasswordTextField,password);
        return this ;
    }

    public LoginPage fillLoginData(String email,String password){
        fillEmail(email);
        fillPassword(password);
        return this ;
    }

    public LoginPage clickLoginButton(){
        driver.element().click(loginButton);
        return this ;
    }

    //Assertions
    @Step("Validate that the user is logged in")
    public void validateLogin(){
        driver.element().verifyThat(logoutButton).isVisible().perform();
    }

}

