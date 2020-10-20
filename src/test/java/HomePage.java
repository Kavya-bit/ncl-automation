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

    @FindBy(xpath = "/html/body/main/section[1]/div/div/form/div[2]/div/div[1]/div/div/div[1]/div/div[1]/div/div[1]/div")

    WebElement destinationCruise;
    @FindBy(xpath = "//input[@placeholder='Find a Destination']")

    WebElement selectCruiseFromDropDown;

    @FindBy(xpath = "/html/body/main/section[1]/div/div/form/div[2]/div/div[1]/div/div/div[1]/div/div[1]/div/div[2]/div/div/div[3]/div/div/div[2]/ul/li[2]/a")
    WebElement apply;

    @FindBy(xpath = "/html/body/main/section[1]/div/div/form/div[2]/div/div[1]/div/div/div[2]/div/div/div/div[1]/div")

    WebElement dates;

    @FindBy(xpath = "//*[@id=\"month-view-32006\"]/div/div[2]/div/div[2]/div/div/div/div/div[1]/ul/li[2]/div/div[2]/ul/li[4]/div/label")

    WebElement month;

    @FindBy(xpath = "/html/body/main/section[1]/div/div/form/div[2]/div/div[1]/div/div/div[2]/div/div/div/div[2]/div/div/div[3]/div/div/div[2]/ul/li[2]/a")

    WebElement dateApply;


    @FindBy(xpath = "/html/body/main/section[1]/div/div/form/div[2]/div/div[3]/a")

    WebElement findCruise;

    @FindBy(xpath = "//*[@id=\"simplemodal-close-img\"]")

    WebElement closeModal;

    @FindBy(xpath = "/html/body/main/ul/li[2]/section/div/div/div[3]/ul/li[1]/article/div[1]/div[3]/div/div[1]/div/div[1]/div/div/div/div/div/div/div[2]/div[1]/span")

    WebElement offerPrice;

    public HomePage(WebDriver driver) {

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }


    public void findCruisesAndClosePopUp() throws InterruptedException {
        destinationCruise.click();
        selectCruiseFromDropDown.click();
        apply.click();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(250, 0)");
        dates.click();
        month.click();
        Thread.sleep(500);
        dateApply.click();
        findCruise.click();
        closeModal.click();



    }

    public void fillSearchCriteria() throws InterruptedException {


    }
}