import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ContactUsForm {
    private SHAFT.GUI.WebDriver driver ;
    //Constructor
    public ContactUsForm(SHAFT.GUI.WebDriver driver){
        this.driver = driver ;
    }
    //Locators
    private By homePageLogoFeild = By.xpath("//div[@class=\"logo pull-left\"]//img[@src=\"/static/images/home/logo.png\"]");
    private By contactUsButton = By.xpath("//a[@href=\"/contact_us\"]");
    private By getInTouchField = By.xpath("//h2[@class='title text-center' and text()='Get In Touch']");
    private By nameField = By.xpath("//input[@name=\"name\"]");
    private By emailField = By.xpath("//input[@ name=\"email\"]");
    private By subjectField = By.xpath("//input[@ name=\"subject\"]");
    private By messageField = By.xpath("//textarea[@name=\"message\"]");
    private By uploadFileButton = By.xpath("//input[@ name=\"upload_file\"]");
    private By submitButton = By.xpath("//input[@ name=\"submit\"]");
    private By successMessage = By.xpath("//div[@class=\"status alert alert-success\"]");
    private By homeButton = By.xpath("//a[@ href=\"/\"]//i[@class=\"fa fa-home\"]");

//Actions
public ContactUsForm navigateToURL(String URL){
    driver.browser().navigateToURL(URL);
    return this;
}
    public ContactUsForm clickOnContactUsButton(){
        driver.element().click(contactUsButton);
        return this ;
    }
    public ContactUsForm fillName(String Name) {
        driver.element().type(nameField, Name);
        return this;
    }
    public ContactUsForm fillEmail(String Email) {
        driver.element().type(emailField, Email);
        return this;
    }
    public ContactUsForm fillSubject(String Subject) {
        driver.element().type(subjectField, Subject);
        return this;
    }
    public ContactUsForm fillMessage(String Message) {
        driver.element().type(messageField, Message);
        return this;
    }
    String filePath = "C:\\Users\\moham\\OneDrive\\Desktop\\Capture.png";
    public ContactUsForm uploadFile() {
        driver.element().typeFileLocationForUpload(uploadFileButton, filePath);
        return this;
    }
    public ContactUsForm submitForm() {
        driver.element().click(submitButton);
        return this;
    }
    public ContactUsForm clickOnUploadFileButton(){
        driver.element().click(uploadFileButton);
        return this ;
    }
    public ContactUsForm handleAlert() {
        driver.alert().acceptAlert();
        return this;
    }
    public ContactUsForm clickOnHomeButton(){
        driver.element().click(homeButton);
        return this ;
    }

    //Assertions
    @Step("Verify that home page is visible successfully")
    public void validateHomePageVisibility(){
        driver.element().verifyThat(homePageLogoFeild).isVisible().perform();
    }
    @Step("Verify that Get In Touch is visible successfully")
    public void validateGetInTouchVisibility(){
        driver.element().verifyThat(getInTouchField).isVisible().perform();
    }
    @Step("Verify success message Success! is visible")
    public void validateSuccessMessageVisibility(){
        driver.element().verifyThat(successMessage).isVisible().perform();
    }





















}
