import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class TestCasePage {
    private SHAFT.GUI.WebDriver driver ;

    //Constructor
    public TestCasePage(SHAFT.GUI.WebDriver driver){
        this.driver = driver ;
    }

    //Locators
    private By testCaseText = By.xpath("//h2[@class=\"title text-center\"]/b");
    //Assertions
    @Step("Verify that Test Case Text is visible")
    public TestCasePage verifyThatTestCaseTextIsVisible(){
        driver.element().verifyThat(testCaseText).isVisible().perform();
        return this;
    }
}
