import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NclAutomationTest extends BaseTest {

    public String baseUrl = "https://www.ncl.com/";

    @Test
    public void test() {
// Create driver object for CHROME browser
        driver.navigate().to("https://www.ncl.com/");
        driver.manage().window().maximize();

        HomePage homePage = new HomePage(this.driver);
        try {
            homePage.findCruisesAndClosePopUp();
            String offerPriceText = homePage.offerPrice.getText();
            System.out.println(offerPriceText);
            VacationsPage vacationsPage = new VacationsPage(this.driver);
            vacationsPage.viewCruises();
            vacationsPage.clickOnDates();
            String offeredTextPrice = driver.findElements(By.xpath("//*[@id=\"anchor-datePrice\"]/div/div/div/div/div[2]/ul/li/div/div[1]/div/div[2]/div/div[2]/ul/li/div/div[2]/div/ul")).get(0).getText();

            System.out.println("pricess"+offeredTextPrice);
            Assert.assertTrue(offeredTextPrice.contains(offerPriceText));


        } catch (InterruptedException e) {
            System.out.println("exception occurred");
        }
    }

    @BeforeTest
    public void beforeTest() {

        System.out.println("before test");
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
        System.out.println("after test");
    }
}