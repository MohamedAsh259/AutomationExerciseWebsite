import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class CartPage {
    private SHAFT.GUI.WebDriver driver;

    //Constructor
    public CartPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private By checkOutButton = By.xpath("//a[@class=\"btn btn-default check_out\"]");
    private By firstProductInCart = By.xpath("//tr[@id=\"product-1\"]//img[@src=\"get_product_picture/1\"]");
    private By secondProductInCart = By.xpath("//div[@class=\"table-responsive cart_info\"]//img[@src=\"get_product_picture/2\"]");
    private By firstProductName = By.xpath("//tr[1]/td[@class='cart_description']/h4/a");
    private By firstProductCategory = By.xpath("//tr[1]/td[@class='cart_description']/p");
    private By firstProductPrice = By.xpath("//tr[1]/td[@class='cart_price']/p");
    private By firstProductQuantity = By.xpath("//tr[1]/td[@class='cart_quantity']/button");
    private By firstProductTotalPrice = By.xpath("//tr[1]/td[@class='cart_total']/p[@class='cart_total_price']");
    private By secondProductName = By.xpath("//tr[@id='product-2']/td[@class='cart_description']/h4/a");
    private By secondProductCategory = By.xpath("//tr[@id='product-2']/td[@class='cart_description']/p");
    private By secondProductPrice = By.xpath("//tr[@id='product-2']/td[@class='cart_price']/p");
    private By secondProductQuantity = By.xpath("//tr[@id='product-2']/td[@class='cart_quantity']/button");
    private By secondProductTotalPrice = By.xpath("//tr[@id='product-2']/td[@class='cart_total']/p[@class='cart_total_price']");
    private By loginRegisterCheckoutButton = By.xpath("//a[@href=\"/login\"]/u");
    private By continueOnCartButton = By.xpath("//button[@class=\"btn btn-success close-checkout-modal btn-block\"]");
    private By removeProductButton = By.xpath("//tr[@id=\"product-1\"]//a[@class=\"cart_quantity_delete\"]");
    private By cartIsEmptyText  = By.xpath("//p[@class=\"text-center\"]/b");

    // Actions
    public CartPage clickOnCheckOutButton() {
        driver.element().click(checkOutButton);
        return this;
    }
    public CartPage clickOnLoginRegisterCheckoutButton() {
        driver.element().click(loginRegisterCheckoutButton);
        return this;
    }
    public CartPage clickOnContinueToCartButton() {
        driver.element().click(continueOnCartButton);
        return this;
    }
    public CartPage clickOnRemoveProductButton() {
        driver.element().click(removeProductButton);
        return this;
    }

    //Asserations
    @Step("Verify that cart page is displayed")
    public CartPage validateCartPageVisibility() {
        driver.element().verifyThat(checkOutButton).isVisible().perform();
        return this;
    }
    @Step("Verify that two products added successfully")
    public CartPage VerifyBothProductsAreAddedToCart() {
        driver.element().verifyThat(firstProductInCart).exists().perform();
        driver.element().verifyThat(secondProductInCart).exists().perform();
        return this;
    }
    @Step("Verify that two products Prices is not null")
    public CartPage VerifyPricesOfTwoProducts() {
        Validations.assertThat().object(firstProductPrice).isNotNull().perform();
        Validations.assertThat().object(secondProductPrice).isNotNull().perform();
        return this;
    }
    @Step("Verify that two products quantities is not equal zero")
    public CartPage VerifyQuantitiesOfTwoProducts() {
        Validations.assertThat().object(firstProductQuantity).doesNotEqual(0).perform();
        Validations.assertThat().object(secondProductQuantity).doesNotEqual(0).perform();
        return this;
    }
    @Step("Verify that two products total prices is not equal zero")
    public CartPage VerifyTotalPricesOfTwoProducts() {
        Validations.assertThat().object(firstProductTotalPrice).doesNotEqual(0).perform();
        Validations.assertThat().object(secondProductTotalPrice).doesNotEqual(0).perform();
        return this;
    }
    @Step("Verify first product content")
    public CartPage validateFirstProductContent() {
        Assertions.assertEquals("Blue Top", driver.element().getText(firstProductName), "Verify product name for the first item");
        Assertions.assertEquals("Women > Tops", driver.element().getText(firstProductCategory), "Verify product category for the first item");
        return this;
    }
    @Step("Verify second product content")
    public CartPage validateSecondProductContent() {
        Assertions.assertEquals("Men Tshirt", driver.element().getText(secondProductName), "Verify product name for the second item");
        Assertions.assertEquals("Men > Tshirts", driver.element().getText(secondProductCategory), "Verify product category for the second item");
        return this;
    }
    @Step("Verify that cart page is displayed")
    public CartPage validateCartIsEmpty() {
        driver.element().verifyThat(cartIsEmptyText).isVisible().perform();
        return this;
    }
}