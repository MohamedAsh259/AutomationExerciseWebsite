import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ContactUsPage {
    private SHAFT.GUI.WebDriver driver ;
    //Constructor
    public ContactUsPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver ;
    }
    //Locators
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
    public ContactUsPage fillName(String Name) {
        driver.element().type(nameField, Name);
        return this;
    }
    public ContactUsPage fillEmail(String Email) {
        driver.element().type(emailField, Email);
        return this;
    }
    public ContactUsPage fillSubject(String Subject) {
        driver.element().type(subjectField, Subject);
        return this;
    }
    public ContactUsPage fillMessage(String Message) {
        driver.element().type(messageField, Message);
        return this;
    }
    String filePath = "C:\\Users\\moham\\OneDrive\\Desktop\\x path.txt";
    public ContactUsPage uploadFile() {
        driver.element().typeFileLocationForUpload(uploadFileButton, filePath);
        return this;
    }
    public ContactUsPage submitForm() {
        driver.element().click(submitButton);
        return this;
    }
    public ContactUsPage clickOnUploadFileButton(){
        driver.element().click(uploadFileButton);
        return this ;
    }
    public ContactUsPage handleAlert() {
        driver.alert().acceptAlert();
        return this;
    }
    public ContactUsPage clickOnHomeButton(){
        driver.element().click(homeButton);
        return this ;
    }
    //Assertions

    @Step("Verify that Get In Touch is visible successfully")
    public ContactUsPage validateGetInTouchVisibility(){
        driver.element().verifyThat(getInTouchField).isVisible().perform();
        return this;
    }
    @Step("Verify success message Success! is visible")
    public ContactUsPage validateSuccessMessageVisibility(){
        driver.element().verifyThat(successMessage).isVisible().perform();
        return this;
    }
}
