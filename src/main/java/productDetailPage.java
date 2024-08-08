import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class productDetailPage {
        private SHAFT.GUI.WebDriver driver;

        //Constructor
        public productDetailPage(SHAFT.GUI.WebDriver driver) {
            this.driver = driver;
        }

        //Locators
        private By addToCartButton = By.xpath("//span//button[@ type=\"button\"]");private By continueShoppingButton = By.xpath("//div[@class=\"modal-footer\"]//button[@class=\"btn btn-success close-modal btn-block\"]");
        private By productName = By.xpath("//div[@class='product-information']/h2");
        private By productCategory = By.xpath("//div[@class='product-information']/p[1]");
        private By productPrice = By.xpath("//div[@class='product-information']/span/span");
        private By productAvailability = By.xpath("//div[@class='product-information']/p[2]");
        private By productCondition = By.xpath("//div[@class='product-information']/p[3]");
        private By productBrand = By.xpath("//div[@class='product-information']/p[4]");

        //Actions
        public productDetailPage clickOnProductAddToCartButton() {
            driver.element().click(addToCartButton);
            return this;
        }
       public productDetailPage clickOnProductContinueShoppingButton() {
        driver.element().click(continueShoppingButton);
        return this;
        }


//Assertions

    @Step("Verify that first product name is visible")
    public void validateFirstProductNameVisibility(){
        driver.element().verifyThat(productName).isVisible().perform();
    }
    @Step("Verify that first product category is visible")
    public void validateFirstProductCategoryVisibility(){
        driver.element().verifyThat(productCategory).isVisible().perform();
    }
    @Step("Verify that first product price is visible")
    public void validateFirstProductPriceVisibility(){
        driver.element().verifyThat(productPrice).isVisible().perform();
    }
    @Step("Verify that first product availability is visible")
    public void validateFirstProductAvailabilityVisibility(){
        driver.element().verifyThat(productAvailability).isVisible().perform();
    }
    @Step("Verify that first product condition is visible")
    public void validateFirstProductConditionVisibility(){
        driver.element().verifyThat(productCondition).isVisible().perform();
    }
    @Step("Verify that first product brand is visible")
    public void validateFirstProductBrandVisibility(){
        driver.element().verifyThat(productBrand).isVisible().perform();
    }
}

