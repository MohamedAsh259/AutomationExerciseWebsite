import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class productPage {
    private SHAFT.GUI.WebDriver driver;

    //Constructor
    public productPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private By homePageProductButton = By.xpath("//ul[@class=\"nav navbar-nav\"]//a[@href=\"/products\"]");
    private By firstProductViewButton = By.xpath("//ul [@class=\"nav nav-pills nav-justified\"]//li//a[@href=\"/product_details/1\"]");
    private By secondProductVeiwButton = By.xpath("//ul[@class=\"nav nav-pills nav-justified\"]//a [@href=\"/product_details/2\"]");
    private By allProductsText = By.xpath("//h2[@class=\"title text-center\"]");
    private By productList = By.xpath("//div[@class=\"features_items\"]");


    //Actions

    public productPage clickOnProductButton() {
        driver.element().click(homePageProductButton);
        return this;
    }

    public productPage clickOnFirstProductViewButton() {
        driver.element().click(firstProductViewButton);
        return this;
    }

    public productPage clickOnSecondProductViewButton() {
        driver.element().click(secondProductVeiwButton);
        return this;
    }


//Assertions

    @Step("Verify that all products text is visible successfully")
    public void validateAllProductsVisibility() {
        driver.element().verifyThat(allProductsText).isVisible().perform();
    }

    @Step("Verify that product list is visible successfully")
    public void validateProductListVisibility() {
        driver.element().verifyThat(productList).isVisible().perform();
    }
}




