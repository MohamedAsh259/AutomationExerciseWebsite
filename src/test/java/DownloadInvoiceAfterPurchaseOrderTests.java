import com.shaft.driver.SHAFT;
import jdk.jfr.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DownloadInvoiceAfterPurchaseOrderTests{
private SHAFT.GUI.WebDriver driver ;
private SHAFT.TestData.JSON testData;
@BeforeClass
public void beforeClass() {
    testData = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/TestData/DownloadInvoiceAfterPurchaseOrderData.json");
}
@BeforeMethod
@Description("this is a setup class for our test")
public void setup (){
    driver = new SHAFT.GUI.WebDriver();
}
@Test(description = "DownloadInvoiceAfterPurchaseOrder")
private void DownloadInvoiceAfterPurchaseOrder() {
    new DownloadInvoiceAfterPurchaseOrder(driver).navigateToURL(testData.getTestData("WebSite-URL"));
    new DownloadInvoiceAfterPurchaseOrder(driver).validateHomePageVisibility();
    new DownloadInvoiceAfterPurchaseOrder(driver).clickOnProductButton()
            .clickOnFirstProductViewButton()
            .clickOnFirstProductAddToCartButton()
            .clickOnFirstProductContinueShoppingButton()
            .navigateBack()
            .clickOnSecondProductViewButton()
            .clickOnSecondProductAddToCartButton()
            .clickOnSecondProductContinueShoppingButton()
            .clickOnHomePageCartButton();
    new DownloadInvoiceAfterPurchaseOrder(driver).validateCartPageVisibility();
    new DownloadInvoiceAfterPurchaseOrder(driver).clickOnCheckoutButton();
    new DownloadInvoiceAfterPurchaseOrder(driver).clickOnLoginRegisterButton();
    new DownloadInvoiceAfterPurchaseOrder(driver).fillName(testData.getTestData("SignupData['Name-s']"))
            .fillEmail(testData.getTestData("SignupData['Email']"))
            .clickOnSignUpButton()
            .clickOnTitleButton()
            .fillAccountName(testData.getTestData("AccountInformation['Name-A']"))
            .fillAccountPassword(testData.getTestData("AccountInformation['Password']"))
            .selectDayOfBirthDate(testData.getTestData("AccountInformation['Day']"))
            .selectMonthOfBirthDate(testData.getTestData("AccountInformation['Month']"))
            .selectYearsOfBirthDate(testData.getTestData("AccountInformation['Year']"))
            .clickOnNewsLetterButton()
            .clickOnSpeicalOfferButton()
            .addressFirstName(testData.getTestData("AddressInformation['addressFirstName']"))
            .addressLastName(testData.getTestData("AddressInformation['addressLastName']"))
            .companyNameField(testData.getTestData("AddressInformation['companyNameField']"))
            .addressField(testData.getTestData("AddressInformation['addressField']"))
            .addressFieldTwo(testData.getTestData("AddressInformation['addressFieldTwo']"))
            .selectCountryName(testData.getTestData("AddressInformation['CountryName']"))
            .stateField(testData.getTestData("AddressInformation['stateField']"))
            .cityField(testData.getTestData("AddressInformation['cityField']"))
            .zipCodeField(testData.getTestData("AddressInformation['zipCodeField']"))
            .mobileNumber(testData.getTestData("AddressInformation['mobileNumber']"));
    new DownloadInvoiceAfterPurchaseOrder(driver).clickOnCreateAccountButton();
    new DownloadInvoiceAfterPurchaseOrder(driver).verifyThatAccountCreatedIsVisible();
    new DownloadInvoiceAfterPurchaseOrder(driver).clickOnContinueButton();
    new DownloadInvoiceAfterPurchaseOrder(driver).verifyLoggedInAsMohamedIsVisible();
    new DownloadInvoiceAfterPurchaseOrder(driver).clickOnHomePageCartButton();
    new DownloadInvoiceAfterPurchaseOrder(driver).clickOnCheckoutButton();
    new DownloadInvoiceAfterPurchaseOrder(driver).validateAddressFieldVisibility();
    new DownloadInvoiceAfterPurchaseOrder(driver).validateAddressFieldContent();
    new DownloadInvoiceAfterPurchaseOrder(driver).validateReviewOrderFieldVisibility();
    new DownloadInvoiceAfterPurchaseOrder(driver).validateFirstProductContent();
    new DownloadInvoiceAfterPurchaseOrder(driver).validateSecondProductContent();
    new DownloadInvoiceAfterPurchaseOrder(driver).validateActualProductPrice();
    new DownloadInvoiceAfterPurchaseOrder(driver).fillComment(testData.getTestData("CheckOutComment"))
            .clickOnPlaceOrderButton()
            .fillCardNumber(testData.getTestData("CardInformation['fillCardNumber']"))
            .fillCardName(testData.getTestData("CardInformation['fillCardName']"))
            .fillCardCvc(testData.getTestData("CardInformation['fillCardCvc']"))
            .fillCardExpirationMonth(testData.getTestData("CardInformation['fillCardExpirationMonth']"))
            .fillCardExpirationYear(testData.getTestData("CardInformation['fillCardExpirationYear']"))
            .clickOnPayAndConfirmOrderButton()
            .navigateBack()
            .waitTillSuccessfulMessageAppear()
            .clickOnPayAndConfirmOrderButton();
    new DownloadInvoiceAfterPurchaseOrder(driver).clickOnInvoiceDownloadButton();
    new DownloadInvoiceAfterPurchaseOrder(driver).verifyInvoiceIsDownloaded();
    new DownloadInvoiceAfterPurchaseOrder(driver).clickOnContinueButton();
    new DownloadInvoiceAfterPurchaseOrder(driver).clickOnDeleteAccountButton();
}
}



















