import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private final WebDriver driver;

    @FindBy(xpath = "//div[@data-code='destination']")

    WebElement destinationCruise;

    WebElement selectCruiseFromDropDown;

    @FindBy(xpath = "//div[@data-code='destination'] //a[@title='Apply']")
    WebElement apply;

    @FindBy(xpath = "//div[@data-code='dates']")

    WebElement dates;

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

    // created getters and setters to input dynamic values for cruise name and month
    public WebElement getSelectCruiseFromDropDown() {
        return selectCruiseFromDropDown;
    }

    public void setSelectCruiseFromDropDown(String selectCruiseFromDropDown) {


        this.selectCruiseFromDropDown = driver.findElement(By.xpath("//span[contains(text(),'" + selectCruiseFromDropDown + "')]"));
    }

    public WebElement getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = driver.findElement(By.xpath("//li[@data-value='" + month + "'][@data-year='2021']"));
    }


    public void findCruisesAndClosePopUp(String cruiseName, String sailingMonth) throws InterruptedException {
        destinationCruise.click();
        Thread.sleep(200);
        setSelectCruiseFromDropDown(cruiseName);
        selectCruiseFromDropDown.click();
        Thread.sleep(500);
        apply.click();
        //we need to scroll to top of the page because element is not visible at that point after selecting cruise
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(250, 0)");
        dates.click();
        setMonth(sailingMonth);
        month.click();
        /* we can use ExpectedConditions utility class to make sure all elements are visible and matched the criteria required before performing actions */
//        ExpectedConditions.elementToBeSelected()
        // added time because element is not visible sometimes
        Thread.sleep(1000);
        dateApply.click();
        findCruise.click();
        //page is taking long time to load pop up so added more wait time
        Thread.sleep(10000);
        closeModal.click();


    }


}