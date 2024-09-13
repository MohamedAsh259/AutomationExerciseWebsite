import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class HomePage {
    private SHAFT.GUI.WebDriver driver;

    //Constructor
    public HomePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private By homePageLogoFeild = By.xpath("//div[@class=\"logo pull-left\"]//img[@src=\"/static/images/home/logo.png\"]");
    private By homePageProductButton = By.xpath("//ul[@class=\"nav navbar-nav\"]//a[@href=\"/products\"]");
    private By homePageCartButton = By.xpath("//ul[@class=\"nav navbar-nav\"]//a[@href=\"/view_cart\"]");
    private By signupLoginButton = By.xpath("//a[@href=\"/login\"]");
    private By contactUsButton = By.xpath("//a[@href=\"/contact_us\"]");
    private By logoutButton = By.xpath("//a[@href=\"/logout\"]");
    private By deleteAccountButton = By.xpath("//a[@href=\"/delete_account\"]");
    private By accountDeletedVerification = By.xpath("//h2[@data-qa=\"account-deleted\"]/b");
    private By deleteContinueButton = By.xpath("//a[@data-qa=\"continue-button\"]");
    private By loggedInAs = By.xpath("//a[contains(text(), \"Logged in as\")]");
    private By testCaseButton = By.xpath("//a[@ href=\"/test_cases\"]//i [@class=\"fa fa-list\"]");
    private By subscriptionText = By.xpath("//div[@class=\"single-widget\"]//h2");
    private By subscriptionSearchField = By.xpath("//input[@id=\"susbscribe_email\"]");
    private By subscriptionArrowButton = By.xpath("//i[@class=\"fa fa-arrow-circle-o-right\"]");
    private By subscriptionSuccessMessage = By.xpath("//div[@class=\"alert-success alert\"]");
    private By firstProductViewButton = By.xpath("//ul [@class=\"nav nav-pills nav-justified\"]//li//a[@href=\"/product_details/1\"]");
    private By categoryList = By.xpath("//div[@class=\"left-sidebar\"]/h2");
    private By womenCategoryList = By.xpath("//a[@href=\"#Women\"]");
    private By womenFirstCategory = By.xpath("//a[@href=\"/category_products/1\"]");
    private By subCategoryTitleText = By.xpath("//h2[@class=\"title text-center\"]");
    private By manCategory = By.xpath("//a[@ href=\"#Men\"]");
    private By firstManSubCategory = By.xpath("//a[@href=\"/category_products/3\"]");

    //Actions
    public HomePage navigateToURL(String URL) {
        driver.browser().navigateToURL(URL);
        return this;
    }
    public HomePage clickOnProductButton() {
        driver.element().click(homePageProductButton);
        return this;
    }
    public HomePage clickOnCartButton() {
        driver.element().click(homePageCartButton);
        return this;
    }
    public HomePage clickOnSignupLoginButton() {
        driver.element().click(signupLoginButton);
        return this;
    }
    public HomePage clickOnContactUsButton() {
        driver.element().click(contactUsButton);
        return this;
    }
    public HomePage clickOnLogOutButton() {
        driver.element().click(logoutButton);
        return this;
    }
    public HomePage clickOnWomenCategoryButton() {
        driver.element().click(womenCategoryList);
        return this;
    }
    public HomePage clickOnWomenFirstCategoryButton() {
        driver.element().click(womenFirstCategory);
        return this;
    }
    public HomePage clickOnManCategoryButton() {
        driver.element().click(manCategory);
        return this;
    }
    public HomePage clickOnFirstManSubCategoryButton() {
        driver.element().click(firstManSubCategory);
        return this;
    }
    public  HomePage clickOnDeleteAccountButton(){
        driver.element().click(deleteAccountButton);
        return this ;
    }
    public  HomePage clickOnContinueDeleteButton(){
        driver.element().click(deleteContinueButton);
        return this ;
    }
    public  HomePage clickOnTestCaseButton(){
        driver.element().click(testCaseButton);
        return this ;
    }
    public  HomePage scrollDownToSubscribtionText(){
        driver.element().scrollToElement(subscriptionText);
        return this ;
    }
    public HomePage fillEmail(String email) {
        driver.element().type(subscriptionSearchField, email);
        return this;
    }
    public  HomePage clickOnSubscriptionButton(){
        driver.element().click(subscriptionArrowButton);
        return this ;
    }
    public  HomePage clickOnFirstProductViewButton(){
        driver.element().click(firstProductViewButton);
        return this ;
    }

    //Assertions
    @Step("Validate that the user is logged in")
    public HomePage validateLogin(){
        driver.element().verifyThat(loggedInAs).isVisible().perform();
        return this;
    }
    @Step("Verify that home page is visible successfully")
    public HomePage validateHomePageVisibility() {
        driver.element().verifyThat(homePageLogoFeild).isVisible().perform();
        return this;
    }
    @Step("Verify that category list is visible successfully")
    public HomePage validateCategoryListVisibility() {
        driver.element().verifyThat(categoryList).isVisible().perform();
        return this;
    }
    @Step("Verify that category list is visible successfully")
    public HomePage validateSubCategoryWomenPageVisibility() {
        driver.element().verifyThat(subCategoryTitleText).isVisible().perform();
        driver.element().assertThat(subCategoryTitleText).text().isEqualTo("WOMEN - DRESS PRODUCTS").perform();
        return this;
    }
    @Step("Verify that category list is visible successfully")
    public HomePage validateSubCategoryManPageVisibility() {
        driver.element().verifyThat(subCategoryTitleText).isVisible().perform();
        driver.element().assertThat(subCategoryTitleText).text().isEqualTo("MEN - TSHIRTS PRODUCTS").perform();
        return this;
    }
    @Step("Verify that test cases button is visible successfully")
    public HomePage validateTestCasesButtonVisibility() {
        driver.element().verifyThat(testCaseButton).isVisible().perform();
        return this;
    }
    @Step("Verify that HomePage Product Button is visible successfully")
    public HomePage validateHomePageProductButtonVisibility() {
        driver.element().verifyThat(homePageProductButton).isVisible().perform();
        return this;
    }
    @Step("Verify that HomePage Product Button is visible successfully")
    public HomePage validateHomePageCartButtonVisibility() {
        driver.element().verifyThat(homePageCartButton).isVisible().perform();
        return this;
    }
    @Step("Verify that Signup/Login Button Button is visible successfully")
    public HomePage validateSignupLoginButtonVisibility() {
        driver.element().verifyThat(signupLoginButton).isVisible().perform();
        return this;
    }
    @Step("Verify that ContactUs Button is visible successfully")
    public HomePage validateContactUsButtonVisibility() {
        driver.element().verifyThat(contactUsButton).isVisible().perform();
        return this;
    }
    @Step("Verify that logout Button is visible successfully")
    public HomePage validateLogoutButtonVisibility() {
        driver.element().verifyThat(logoutButton).isVisible().perform();
        return this;
    }
    @Step("Verify that Delete Account Button is visible successfully")
    public HomePage validateDeleteAccountButtonVisibility() {
        driver.element().verifyThat(deleteAccountButton).isVisible().perform();
        return this;
    }
    @Step("Verify that account Deleted Verification is visible successfully")
    public HomePage validateAccountDeletedVerificationVisibility() {
        driver.element().verifyThat(accountDeletedVerification).isVisible().perform();
        return this;
    }
    @Step("Verify text SUBSCRIPTION")
    public HomePage validateSubscribtionTextContent() {
        driver.element().assertThat(subscriptionText).text().contains("SUBSCRIPTION").perform();;
        return this;
    }
    @Step("Verify Subscription success message")
    public HomePage validateSubscriptionSuccessMessageVisibility() {
        driver.element().waitToBeReady(subscriptionSuccessMessage);
        driver.element().assertThat(subscriptionSuccessMessage).isVisible().perform();
        return this;
    }
}