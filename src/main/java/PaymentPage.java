import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class PaymentPage {
    private SHAFT.GUI.WebDriver driver;
    //Constructor
    public PaymentPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
       }
    //Locators
    private By cardName = By.xpath("//input[@ name=\"name_on_card\"]");
    private By cardNumber = By.xpath("//input[@ name=\"card_number\"]");
    private By cvc = By.xpath("//input[@  name=\"cvc\"]");
    private By expirationMonth = By.xpath("//input[@name=\"expiry_month\"]");
    private By expirationYear = By.xpath("//input[@ name=\"expiry_year\"]");
    private By payAndConfirmOrderButton = By.xpath("//button[@data-qa=\"pay-button\"]");
    private By successfulOrderMessage = By.xpath("//div[contains(@class, 'alert-success') and contains(text(), 'Your order has been placed successfully!')]");
    private By continueButton = By.xpath("//a[@data-qa=\"continue-button\"]");
    private By inoviceDowloadButton = By.xpath("//a[@class=\"btn btn-default check_out\"]");
    //Actions
    public PaymentPage fillCardName(String CardName) {
        driver.element().type(cardName, CardName);
        return this;
    }

    public PaymentPage fillCardNumber(String CardNumber) {
        driver.element().type(cardNumber, CardNumber);
        return this;
    }

    public PaymentPage fillCardExpirationMonth(String CardExpirationMonth) {
        driver.element().type(expirationMonth, CardExpirationMonth);
        return this;
    }

    public PaymentPage fillCardExpirationYear(String CardExpirationYear) {
        driver.element().type(expirationYear, CardExpirationYear);
        return this;
    }

    public PaymentPage fillCardCvc(String Cvc) {
        driver.element().type(cvc, Cvc);
        return this;
    }

    public PaymentPage clickOnPayAndConfirmOrderButton() {
        driver.element().click(payAndConfirmOrderButton);
        return this;
    }
    public PaymentPage clickOnContinueButton() {
        driver.element().click(continueButton);
        return this;
    }
    public PaymentPage clickOnInvoiceButton() {
        driver.element().click(inoviceDowloadButton);
        return this;
    }
    public PaymentPage waitTillSuccessfulMessageAppear() {
        driver.element().waitToBeReady(successfulOrderMessage, true);
        return this;
    }

    //Assertions
    @Step("Verify that successful order message is visible")
    public PaymentPage validateSuccessfullOrderMessageVisibility() {
        driver.element().verifyThat(successfulOrderMessage).isVisible().perform();
        return this;
    }
    @Step("Download Invoice button and verify invoice is downloaded successfully")
    public PaymentPage verifyInvoiceIsDownloaded() {
        String downloadDir = "C:\\Users\\moham\\IdeaProjects\\AutomationExerciseWebsite\\target\\downloadedFiles";
        String expectedFileName = "\\invoice.txt";
        Validations.assertThat().file(downloadDir, expectedFileName).exists().perform();
        return this;
    }
}