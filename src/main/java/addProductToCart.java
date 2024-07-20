import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import com.shaft.validation.Validations;
public class addProductToCart {
    private SHAFT.GUI.WebDriver driver ;

    //Constructor
    public addProductToCart(SHAFT.GUI.WebDriver driver){
        this.driver = driver ;
    }

    //Locators
    private By homePageLogoFeild = By.xpath("//div[@class=\"logo pull-left\"]//img[@src=\"/static/images/home/logo.png\"]");
    private By homePageProductButton = By.xpath("//ul[@class=\"nav navbar-nav\"]//a[@href=\"/products\"]");
    private By firstProductViewButton = By.xpath("//ul [@class=\"nav nav-pills nav-justified\"]//li//a[@href=\"/product_details/1\"]");
    private By addToCartButton = By.xpath("//span//button[@ type=\"button\"]");
    private By continueShoppingButton = By.xpath("//div[@class=\"modal-footer\"]//button[@class=\"btn btn-success close-modal btn-block\"]");
    private By secondProductVeiwButton = By.xpath("//ul[@class=\"nav nav-pills nav-justified\"]//a [@href=\"/product_details/2\"]");
    private By secondProductAddToCart = By.xpath("//span//button[@ type=\"button\"]");
    private By homePageCartButton = By.xpath("//ul[@class=\"nav navbar-nav\"]//a[@href=\"/view_cart\"]");
    private By firstProductInCart = By.xpath("//div[@class=\"table-responsive cart_info\"]//img[@src=\"get_product_picture/2\"]");
    private By secondProductInCart = By.xpath("//tr[@id=\"product-1\"]//img[@src=\"get_product_picture/1\"]");
    private By firstProductPrice = By.xpath("//tr[@id=\"product-2\"]//td[@class=\"cart_price\"]/p");
    private By secondProductPrice = By.xpath("//tr[@id=\"product-1\"]//td[@class=\"cart_price\"]/p");
    private By firstProductQuantity = By.xpath("//tr[@id=\"product-2\"]//button[@class=\"disabled\"]");
    private By secondProductQuantity = By.xpath("//tr[@id=\"product-1\"]//button[@class=\"disabled\"]");
    private By firstProductTotalPrice = By.xpath("//tr[@id=\"product-2\"]//p[@class=\"cart_total_price\"]");
    private By secondProductTotalPrice = By.xpath("//tr[@id=\"product-1\"]//p[@class=\"cart_total_price\"]");

    //Actions
    public addProductToCart navigateToURL(String URL){
        driver.browser().navigateToURL(URL);
        return this ;
    }

    public addProductToCart clickOnProductButton(){
        driver.element().click(homePageProductButton);
        return this ;
    }
    public addProductToCart clickOnFirstProductViewButton(){
        driver.element().click(firstProductViewButton);
        return this ;
    }
    public addProductToCart clickOnFirstProductAddToCartButton(){
        driver.element().click(addToCartButton);
        return this ;
    }
    public addProductToCart clickOnFirstProductContinueShoppingButton(){
        driver.element().click(continueShoppingButton);
        return this ;
    }
    public addProductToCart navigateBack(){
        driver.browser().navigateBack();
        return this ;
    }
    public addProductToCart clickOnSecondProductViewButton(){
        driver.element().click(secondProductVeiwButton);
        return this ;
    }

    public addProductToCart clickOnSecondProductAddToCartButton(){
        driver.element().click(secondProductAddToCart);
        return this ;
    }
    public addProductToCart clickOnSecondProductContinueShoppingButton(){
        driver.element().click(continueShoppingButton);
        return this ;
    }
    public addProductToCart clickOnHomePageCartButton(){
        driver.element().click(homePageCartButton);
        return this ;
    }

    //Assertions
    @Step("Verify that home page is visible successfully")
    public void validateHomePageVisibility(){
        driver.element().verifyThat(homePageLogoFeild).isVisible().perform();
    }

    @Step("Verify that two products added successfully")
    public void  VerifyBothProductsAreAddedToCart(){
        driver.element().verifyThat(firstProductInCart).exists().perform();
        driver.element().verifyThat(secondProductInCart).exists().perform();
    }
    @Step("Verify that two products Prices is not null")
    public void  VerifyPricesOfTwoProducts(){
        Validations.assertThat().object(firstProductPrice).isNotNull().perform();
        Validations.assertThat().object(secondProductPrice).isNotNull().perform();
    }

    @Step("Verify that two products quantities is not equal zero")
    public void  VerifyQuantitiesOfTwoProducts(){
        Validations.assertThat().object(firstProductQuantity).doesNotEqual(0).perform();
        Validations.assertThat().object(secondProductQuantity).doesNotEqual(0).perform();
    }

    @Step("Verify that two products total prices is not equal zero")
    public void  VerifyTotalPricesOfTwoProducts(){
        Validations.assertThat().object(firstProductTotalPrice).doesNotEqual(0).perform();
        Validations.assertThat().object(secondProductTotalPrice).doesNotEqual(0).perform();
    }
}
