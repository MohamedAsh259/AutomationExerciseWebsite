import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class cartPage {
    private SHAFT.GUI.WebDriver driver;

    //Constructor
    public cartPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private By homePageProductButton = By.xpath("//ul[@class=\"nav navbar-nav\"]//a[@href=\"/products\"]");
    private By homePageCartButton = By.xpath("//ul[@class=\"nav navbar-nav\"]//a[@href=\"/view_cart\"]");
    private By homePageNewUserSignup = By.xpath("//div[@class=\"signup-form\"]//h2");
    private By contactUsButton = By.xpath("//a[@href=\"/contact_us\"]");
    private By checkOutButton = By.xpath("//a[@class=\"btn btn-default check_out\"]");
    private By addressFieldData = By.xpath("//a[@ href=\"/payment\"]");
    private By addressContentOne = By.xpath("//ul[@id='address_delivery']/li[@class='address_address1 address_address2'][2]");
    private By addressContentTwo = By.xpath("//ul[@id='address_delivery']/li[@class='address_address1 address_address2'][3]");
    private By reviewContentField = By.xpath("//div[@class='step-one']/h2[@class='heading' and text()='Review Your Order']");
    private By productName1 = By.xpath("//tr[1]/td[@class='cart_description']/h4/a");
    private By productCategory1 = By.xpath("//tr[1]/td[@class='cart_description']/p");
    private By productPrice1 = By.xpath("//tr[1]/td[@class='cart_price']/p");
    private By productQuantity1 = By.xpath("//tr[1]/td[@class='cart_quantity']/button");
    private By productTotalPrice1 = By.xpath("//tr[1]/td[@class='cart_total']/p[@class='cart_total_price']");
    private By productName2 = By.xpath("//tr[@id='product-2']/td[@class='cart_description']/h4/a");
    private By productCategory2 = By.xpath("//tr[@id='product-2']/td[@class='cart_description']/p");
    private By productPrice2 = By.xpath("//tr[@id='product-2']/td[@class='cart_price']/p");
    private By productQuantity2 = By.xpath("//tr[@id='product-2']/td[@class='cart_quantity']/button");
    private By productTotalPrice2 = By.xpath("//tr[@id='product-2']/td[@class='cart_total']/p[@class='cart_total_price']");
    private By totalProductPrices = By.xpath("//td//p[@class=\"cart_total_price\"and contains(text(), 'Rs. 900')]");
    // Actions

    public cartPage clickOnProductButton() {
        driver.element().click(homePageCartButton);
        return this;
    }

    public cartPage clickOnCheckOutButton() {
        driver.element().click(checkOutButton);
        return this;
    }


    @Step("Verify that cart page is displayed")
    public void validateCartPageVisibility() {
        driver.element().verifyThat(checkOutButton).isVisible().perform();
    }

    @Step("Verify that address field is visible")
    public void validateAddressFieldVisibility() {
        driver.element().verifyThat(addressFieldData).isVisible().perform();
    }

    @Step("Verify that address text is like given")
    public void validateAddressFieldContent() {
        Assertions.assertEquals("cairo", driver.element().getText(addressContentOne), "Verify the address one Content");
        Assertions.assertEquals("cairo-c", driver.element().getText(addressContentTwo), "Verify the address two Content");
    }

    @Step("Verify that Review Order field is visible")
    public void validateReviewOrderFieldVisibility() {
        driver.element().verifyThat(reviewContentField).isVisible().perform();
    }

    @Step("Verify first product content")
    public void validateFirstProductContent() {
        Assertions.assertEquals("Blue Top", driver.element().getText(productName1), "Verify product name for the second item");
        Assertions.assertEquals("Women > Tops", driver.element().getText(productCategory1), "Verify product category for the second item");
        Assertions.assertEquals("Rs. 500", driver.element().getText(productPrice1), "Verify product price for the second item");
        Assertions.assertEquals("1", driver.element().getText(productQuantity1), "Verify product quantity for the second item");
        Assertions.assertEquals("Rs. 500", driver.element().getText(productTotalPrice1), "Verify product total price for the second item");
    }

    @Step("Verify second product content")
    public void validateSecondProductContent() {
        Assertions.assertEquals("Men Tshirt", driver.element().getText(productName2), "Verify product name for the first item");
        Assertions.assertEquals("Men > Tshirts", driver.element().getText(productCategory2), "Verify product category for the first item");
        Assertions.assertEquals("Rs. 400", driver.element().getText(productPrice2), "Verify product price for the first item");
        Assertions.assertEquals("1", driver.element().getText(productQuantity2), "Verify product quantity for the first item");
        Assertions.assertEquals("Rs. 400", driver.element().getText(productTotalPrice2), "Verify product total price for the first item");
    }

    @Step("Verify that expected product price equal actual")
    public void validateActualProductPrice() {
        String totalPrice1Text = driver.element().getText(productTotalPrice1).replace("Rs. ", "").replace(",", "");
        String totalPrice2Text = driver.element().getText(productTotalPrice2).replace("Rs. ", "").replace(",", "");
        String actualTotalPriceText = driver.element().getText(totalProductPrices).replace("Rs. ", "").replace(",", "");
        int totalPrice1 = Integer.parseInt(totalPrice1Text);
        int totalPrice2 = Integer.parseInt(totalPrice2Text);
        //expected
        int expectedTotal = totalPrice1 + totalPrice2;
        //actual
        int actualTotal = Integer.parseInt(actualTotalPriceText);
        Assertions.assertEquals(expectedTotal, actualTotal, "Verify the total price of all items in the cart");
    }
}

