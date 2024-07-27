import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class RemoveProductFromCart {
    private SHAFT.GUI.WebDriver driver;

    //Constructor
    public RemoveProductFromCart(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private By homePageLogoFeild = By.xpath("//div[@class=\"logo pull-left\"]//img[@src=\"/static/images/home/logo.png\"]");
    private By homePageProductButton = By.xpath("//ul[@class=\"nav navbar-nav\"]//a[@href=\"/products\"]");
    private By firstProductViewButton = By.xpath("//ul [@class=\"nav nav-pills nav-justified\"]//li//a[@href=\"/product_details/1\"]");
    private By addToCartButton = By.xpath("//span//button[@ type=\"button\"]");
    private By continueShoppingButton = By.xpath("//div[@class=\"modal-footer\"]//button[@class=\"btn btn-success close-modal btn-block\"]");
    private By homePageCartButton = By.xpath("//ul[@class=\"nav navbar-nav\"]//a[@href=\"/view_cart\"]");
    private By checkOutButton = By.xpath("//a[@class=\"btn btn-default check_out\"]");
    private By removeProductButton = By.xpath("//tr[@id=\"product-1\"]//a[@class=\"cart_quantity_delete\"]");
    private By emptyCartMessage = By.xpath("//b[contains(text(), 'Cart is empty!')]");
    //Actions
    public RemoveProductFromCart navigateToURL(String URL) {
        driver.browser().navigateToURL(URL);
        return this;
    }

    public RemoveProductFromCart clickOnProductButton() {
        driver.element().click(homePageProductButton);
        return this;
    }

    public RemoveProductFromCart clickOnFirstProductViewButton() {
        driver.element().click(firstProductViewButton);
        return this;
    }

    public RemoveProductFromCart clickOnFirstProductAddToCartButton() {
        driver.element().click(addToCartButton);
        return this;
    }

    public RemoveProductFromCart clickOnFirstProductContinueShoppingButton() {
        driver.element().click(continueShoppingButton);
        return this;
    }

    public RemoveProductFromCart clickOnHomePageCartButton() {
        driver.element().click(homePageCartButton);
        return this;
    }
    public RemoveProductFromCart clickOnRemoveProductButton() {
        driver.element().click(removeProductButton);
        return this;
    }


    //Assertions
    @Step("Verify that home page is visible successfully")
    public void validateHomePageVisibility() {
        driver.element().verifyThat(homePageLogoFeild).isVisible().perform();
    }

    @Step("Verify that cart page is displayed")
    public void validateCartPageVisibility() {
        driver.element().verifyThat(checkOutButton).isVisible().perform();
    }
    @Step("Verify that product is removed from the cart")
    public void validateProductIsRemoved() {
        driver.element().verifyThat(emptyCartMessage).isVisible().perform();
    }

}
