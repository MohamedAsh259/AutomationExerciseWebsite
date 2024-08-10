import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ProductDetailPage {
        private SHAFT.GUI.WebDriver driver;

        //Constructor
        public ProductDetailPage(SHAFT.GUI.WebDriver driver) {
            this.driver = driver;
        }

        //Locators
        private By addToCartButton = By.xpath("//span//button[@ type=\"button\"]");
        private By continueShoppingButton = By.xpath("//div[@class=\"modal-footer\"]//button[@class=\"btn btn-success close-modal btn-block\"]");
        private By viewCartButton = By.xpath("//a[@href=\"/view_cart\"]/u");
        private By productName = By.xpath("//div[@class='product-information']/h2");
        private By productCategory = By.xpath("//div[@class='product-information']/p[1]");
        private By productPrice = By.xpath("//div[@class='product-information']/span/span");
        private By productAvailability = By.xpath("//div[@class='product-information']/p[2]");
        private By productCondition = By.xpath("//div[@class='product-information']/p[3]");
        private By productBrand = By.xpath("//div[@class='product-information']/p[4]");
        private By productImage = By.xpath("//div[@class=\"view-product\"] //img[@alt=\"ecommerce website products\"]");

        //Actions
        public ProductDetailPage clickOnProductAddToCartButton() {
            driver.element().click(addToCartButton);
            return this;
        }
       public ProductDetailPage clickOnProductContinueShoppingButton() {
        driver.element().click(continueShoppingButton);
        return this;
        }
       public ProductDetailPage navigateBack() {
        driver.browser().navigateBack();
        return this;
    }
    public ProductDetailPage clickOnViewCartButton() {
        driver.element().click(viewCartButton);
        return this;
    }

//Assertions
    @Step("Verify that first product name is visible")
    public ProductDetailPage validateProductDetailPageVisibility(){
        driver.element().verifyThat(productImage).isVisible().perform();
        return this;
    }
    @Step("Verify that product details is visible")
    public ProductDetailPage validateFirstProductDetailsVisibility(){
        driver.element().verifyThat(productName).isVisible().perform();
        driver.element().verifyThat(productCategory).isVisible().perform();
        driver.element().verifyThat(productPrice).isVisible().perform();
        driver.element().verifyThat(productAvailability).isVisible().perform();
        driver.element().verifyThat(productCondition).isVisible().perform();
        driver.element().verifyThat(productBrand).isVisible().perform();
        return this;
    }
}