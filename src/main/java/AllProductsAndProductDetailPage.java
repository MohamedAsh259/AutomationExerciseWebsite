import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class AllProductsAndProductDetailPage {
    private SHAFT.GUI.WebDriver driver ;
    //Constructor
    public AllProductsAndProductDetailPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver ;
    }
    //Locators
    private By homePageLogoFeild = By.xpath("//div[@class=\"logo pull-left\"]//img[@src=\"/static/images/home/logo.png\"]");
    private By homePageProductButton = By.xpath("//ul[@class=\"nav navbar-nav\"]//a[@href=\"/products\"]");
    private By allProductsText = By.xpath("//h2[@class=\"title text-center\"]");
    private By productList = By.xpath("//div[@class=\"features_items\"]");
    private By firstProductViewButton = By.xpath("//ul [@class=\"nav nav-pills nav-justified\"]//li//a[@href=\"/product_details/1\"]");
    private By firstProductDetailPage = By.xpath("//div[@class=\"view-product\"]");
    private By productName = By.xpath("//div[@class='product-information']/h2");
    private By productCategory = By.xpath("//div[@class='product-information']/p[1]");
    private By productPrice = By.xpath("//div[@class='product-information']/span/span");
    private By productAvailability = By.xpath("//div[@class='product-information']/p[2]");
    private By productCondition = By.xpath("//div[@class='product-information']/p[3]");
    private By productBrand = By.xpath("//div[@class='product-information']/p[4]");

    // Actions
    public AllProductsAndProductDetailPage navigateToURL(String URL){
        driver.browser().navigateToURL(URL);
        return this;
    }

    public AllProductsAndProductDetailPage clickOnProductButton(){
        driver.element().click(homePageProductButton);
        return this;
    }

    public AllProductsAndProductDetailPage clickOnFirstProductViewButton(){
        driver.element().click(firstProductViewButton);
        return this;
    }


    // Assertions
    @Step("Verify that home page is visible successfully")
    public void validateHomePageVisibility(){
        driver.element().verifyThat(homePageLogoFeild).isVisible().perform();
    }

    @Step("Verify that all products text is visible successfully")
    public void validateAllProductsVisibility(){
        driver.element().verifyThat(allProductsText).isVisible().perform();
    }

    @Step("Verify that product list is visible successfully")
    public void validateProductListVisibility(){
        driver.element().verifyThat(productList).isVisible().perform();
    }

    @Step("Verify that first product detail page is visible")
    public void validateFirstProductPageVisibility(){
        driver.element().verifyThat(firstProductDetailPage).isVisible().perform();
    }
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




































