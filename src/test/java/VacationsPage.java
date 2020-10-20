import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VacationsPage {

    private final WebDriver driver;
    @FindBy(xpath = "/html/body/main/ul/li[2]/section/div/div/div[3]/ul/li[1]/article/div[1]/div[3]/div/div[4]/div/div[1]/a")



    //a[@href='#anchor-datePrice' and @class='c133_link nav-link link-2' ]

    WebElement viewCruise;

    @FindBy(xpath = " //a[@href='#anchor-datePrice' and @class='c133_link nav-link link-2' ]")
    WebElement datesAndPrice;

    public VacationsPage(WebDriver driver) {
        this.driver = driver;
        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }

    public void viewCruises() {
        viewCruise.click();
    }
    void clickOnDates(){
        datesAndPrice.click();
    }
}