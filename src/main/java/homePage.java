import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import com.shaft.validation.Validations;
public class homePage {
    private SHAFT.GUI.WebDriver driver;

    //Constructor
    public homePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private By homePageLogoFeild = By.xpath("//div[@class=\"logo pull-left\"]//img[@src=\"/static/images/home/logo.png\"]");
    private By homePageProductButton = By.xpath("//ul[@class=\"nav navbar-nav\"]//a[@href=\"/products\"]");
    private By homePageCartButton = By.xpath("//ul[@class=\"nav navbar-nav\"]//a[@href=\"/view_cart\"]");
    private By homePageNewUserSignup = By.xpath("//div[@class=\"signup-form\"]//h2");
    private By contactUsButton = By.xpath("//a[@href=\"/contact_us\"]");

    //Actions
    public homePage navigateToURL(String URL) {
        driver.browser().navigateToURL(URL);
        return this;
    }

    public homePage clickOnProductButton() {
        driver.element().click(homePageProductButton);
        return this;
    }

    public homePage clickOnCartButton() {
        driver.element().click(homePageCartButton);
        return this;
    }

    public homePage clickOnNewUserSignupButton() {
        driver.element().click(homePageNewUserSignup);
        return this;
    }


    public homePage clickOnContactUsButton() {
        driver.element().click(contactUsButton);
        return this;
    }

    //Assertions
    @Step("Verify that home page is visible successfully")
    public void validateHomePageVisibility() {
        driver.element().verifyThat(homePageLogoFeild).isVisible().perform();
    }
}

