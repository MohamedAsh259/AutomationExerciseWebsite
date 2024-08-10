import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class CheckoutPage {
    private SHAFT.GUI.WebDriver driver;

    //Constructor
    public CheckoutPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    //Locators

    private By addressDetailsField = By.xpath("//h2[@class='heading' and text()='Address Details']");
    private By addressContentOne = By.xpath("//ul[@id='address_delivery']/li[@class='address_address1 address_address2'][2]");
    private By addressContentTwo = By.xpath("//ul[@id='address_delivery']/li[@class='address_address1 address_address2'][3]");
    private By reviewOrderField = By.xpath("//div[@class='step-one']/h2[@class='heading' and text()='Review Your Order']");
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
    private By totalProductPrices = By.xpath("//td//p[@class=\"cart_total_price\"and contains(text(), 'Rs. 900')]");
    private By commentArea = By.xpath("//textarea[@ name=\"message\"]");
    private By placeOrderButtton = By.xpath("//a[@ href=\"/payment\"]");

    //Actions
    public CheckoutPage fillComment(String Comment) {
        driver.element().type(commentArea, Comment);
        return this;
    }
    public CheckoutPage clickOnPlaceOrderButton() {
        driver.element().click(placeOrderButtton);
        return this;
    }
    //Assertions
    @Step("Verify that address field is visible")
    public CheckoutPage validateAddressFieldVisibility() {
        driver.element().verifyThat(addressDetailsField).isVisible().perform();
        return this;
    }
    @Step("Verify that address text is like given")
    public CheckoutPage validateAddressFieldContent() {
        Assertions.assertEquals("cairo", driver.element().getText(addressContentOne), "Verify the address one Content");
        Assertions.assertEquals("cairo-c", driver.element().getText(addressContentTwo), "Verify the address two Content");
        return this;
    }

    @Step("Verify that Review Order field is visible")
    public CheckoutPage validateReviewOrderFieldVisibility() {
        driver.element().verifyThat(reviewOrderField).isVisible().perform();
        return this;
    }
    @Step("Verify first product content")
    public CheckoutPage validateFirstProductContent() {
        Assertions.assertEquals("Blue Top", driver.element().getText(firstProductName), "Verify product name for the first item");
        Assertions.assertEquals("Women > Tops", driver.element().getText(firstProductCategory), "Verify product category for the second item");
        Assertions.assertEquals("Rs. 500", driver.element().getText(firstProductPrice), "Verify product price for the second item");
        Assertions.assertEquals("1", driver.element().getText(firstProductQuantity), "Verify product quantity for the second item");
        Assertions.assertEquals("Rs. 500", driver.element().getText(firstProductTotalPrice), "Verify product total price for the second item");
        return this;
    }
    @Step("Verify second product content")
    public CheckoutPage validateSecondProductContent() {
        Assertions.assertEquals("Men Tshirt", driver.element().getText(secondProductName), "Verify product name for the second item");
        Assertions.assertEquals("Men > Tshirts", driver.element().getText(secondProductCategory), "Verify product category for the second item");
        Assertions.assertEquals("Rs. 400", driver.element().getText(secondProductPrice), "Verify product price for the first item");
        Assertions.assertEquals("1", driver.element().getText(secondProductQuantity), "Verify product quantity for the first item");
        Assertions.assertEquals("Rs. 400", driver.element().getText(secondProductTotalPrice), "Verify product total price for the first item");
        return this;
    }
    @Step("Verify that expected product price equal actual")
    public CheckoutPage validateActualProductsPrices() {
        String totalPrice1Text = driver.element().getText(firstProductTotalPrice).replace("Rs. ", "").replace(",", "");
        String totalPrice2Text = driver.element().getText(secondProductTotalPrice).replace("Rs. ", "").replace(",", "");
        String actualTotalPriceText = driver.element().getText(totalProductPrices).replace("Rs. ", "").replace(",", "");
        int totalPrice1 = Integer.parseInt(totalPrice1Text);
        int totalPrice2 = Integer.parseInt(totalPrice2Text);
        //expected
        int expectedTotal = totalPrice1 + totalPrice2;
        //actual
        int actualTotal = Integer.parseInt(actualTotalPriceText);
        Assertions.assertEquals(expectedTotal, actualTotal, "Verify the total price of all items in the cart");
        return this;
    }
}