import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private final WebDriver driver;

    @FindBy(xpath = "//div[@data-code='destination']")

    WebElement destinationCruise;
    @FindBy(xpath ="//span[contains(text(),'Alaska Cruises')]" )
    WebElement selectCruiseFromDropDown;

    @FindBy(xpath = "//div[@data-code='destination'] //a[@title='Apply']")
    WebElement apply;

    @FindBy(xpath = "//div[@data-code='dates']")

    WebElement dates;

    @FindBy(xpath = "//li[@data-value='April'][@data-year='2021']")

    WebElement month;

    @FindBy(xpath = "//div[@data-code='dates'] //a[@title='Apply']")

    WebElement dateApply;


    @FindBy(xpath = "//a[@data-action='find-a-cruise']")

    WebElement findCruise;

    @FindBy(xpath = "//*[@id=\"simplemodal-close-img\"]")

    WebElement closeModal;

    @FindBy(xpath = " //ul[@class='listing -block'] //li[@app-offers-card-component][1]//span[@class='headline-1 -variant-3']")

    WebElement offerPrice;

    public HomePage(WebDriver driver) {

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }


    public void findCruisesAndClosePopUp() throws InterruptedException {
        destinationCruise.click();
        Thread.sleep(200);
        selectCruiseFromDropDown.click();
        Thread.sleep(500);
        apply.click();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(250, 0)");
        dates.click();
        month.click();
        Thread.sleep(500);
        dateApply.click();
        findCruise.click();
        Thread.sleep(10000);
        closeModal.click();



    }

    public void fillSearchCriteria() throws InterruptedException {


    }
}