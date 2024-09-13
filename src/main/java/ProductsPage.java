import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static io.appium.java_client.touch.offset.ElementOption.element;

public class ProductsPage {
    private SHAFT.GUI.WebDriver driver;

    //Constructor
    public ProductsPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private By firstProductViewButton = By.xpath("//ul [@class=\"nav nav-pills nav-justified\"]//li//a[@href=\"/product_details/1\"]");
    private By secondProductVeiwButton = By.xpath("//ul[@class=\"nav nav-pills nav-justified\"]//a [@href=\"/product_details/2\"]");
    private By allProductsText = By.xpath("//h2[@class=\"title text-center\"]");
    private By productList = By.xpath("//div[@class=\"features_items\"]");
    private By searchTextField = By.xpath("//input[@name=\"search\"]");
    private By searchButton = By.xpath("//i[@class=\"fa fa-search\"]");
    private By searchedProductText = By.xpath("//h2[@class=\"title text-center\"]");
    private By featuredItems = By.xpath("//div[@class=\"features_items\"]");
    private By firstProductAddToCartButton = By.xpath("//div[@class=\"productinfo text-center\"]//a[@data-product-id=\"28\"]");
    private By secondProductAddToCartButton = By.xpath("//div[@class=\"productinfo text-center\"]//a[@data-product-id=\"29\"]");
    private By thirdProductAddToCartButton = By.xpath("//div[@class=\"productinfo text-center\"]//a[@data-product-id=\"30\"]");
    private By continueShopping = By.xpath("//button[@class=\"btn btn-success close-modal btn-block\"]");
    private By brandList = By.xpath("//div[@class=\"brands_products\"]");
    private By firstBrandName = By.xpath("//a[@href=\"/brand_products/Polo\"]");
    private By brandTitleText = By.xpath("//h2[@class=\"title text-center\"]");
    private By allProductsInBrand = By.xpath("//div[@class=\"features_items\"]");
    private By secondBrand = By.xpath("//a[@href='/brand_products/H&M']");
   // Action
    public ProductsPage fillProductName(String productName){
        driver.element().type(searchTextField,productName);
        return this ;
    }
    public ProductsPage clickOnSearchButton() {
        driver.element().click(searchButton);
        return this;
    }
    public ProductsPage ClickOnAddFirstProductToCartButton() {
        driver.element().click(firstProductAddToCartButton);
        return this;
    }
        public ProductsPage ClickOnAddSecondProductToCartButton() {
        driver.element().click(secondProductAddToCartButton);
        return this;
    }
    public ProductsPage ClickOnAddThirdProductToCartButton() {
        driver.element().click(thirdProductAddToCartButton);
        return this;
    }
    public ProductsPage clickOnContinueShoppingButton() {
        driver.element().click(continueShopping);
        return this;
    }
    public ProductsPage clickOnFirstProductViewButton() {
        driver.element().click(firstProductViewButton);
        return this;
    }
    public ProductsPage clickOnSecondProductViewButton() {
        driver.element().click(secondProductVeiwButton);
        return this;
    }
    //brand list actions
    public ProductsPage clickOnFirstBrandName() {
        driver.element().click(firstBrandName);
        return this;
    }
    public ProductsPage clickOnSecondBrandName() {
        driver.element().click(secondBrand);
        return this;
    }

//Assertions
    @Step("Verify that all products text is visible successfully")
    public ProductsPage validateAllProductsVisibility() {
        driver.element().verifyThat(allProductsText).isVisible().perform();
        return this;
    }
    @Step("Verify Searched Products Text is visible")
    public ProductsPage validateSearchedProductsVisibility() {
        driver.element().verifyThat(searchedProductText).isVisible().perform();
        return this;
    }
    @Step("Verify  all the products related to search are visible")
    public ProductsPage validateProductsRelatedToSearchVisibility() {
        driver.element().assertThat(featuredItems).exists().perform();
        return this;
    }
    @Step("Verify that product list is visible successfully")
    public ProductsPage validateProductListVisibility() {
        driver.element().verifyThat(productList).isVisible().perform();
        return this;
    }
    //Brand Assertions
    @Step("Verify that brand list is visible successfully")
    public ProductsPage validateBrandListVisibility() {
        driver.element().verifyThat(brandList).isVisible().perform();
        return this;
    }
    @Step("Verify that user is navigated to brand page")
    public ProductsPage validateBrandPageVisibility() {
        driver.element().verifyThat(brandTitleText).isVisible().perform();
        return this;
    }
    @Step("Verify that brand products are displayed")
    public ProductsPage validateBrandProductsVisibility() {
        driver.element().verifyThat(allProductsInBrand).isVisible().perform();
        return this;
    }
}