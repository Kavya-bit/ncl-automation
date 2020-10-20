import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NclAutomationTest extends BaseTest {

    public String baseUrl = "https://www.ncl.com/";

    @Test
    public void test() {

        HomePage homePage = new HomePage(this.driver);
        try {
            homePage.findCruisesAndClosePopUp("Alaska Cruises", "April");
            String offerPriceText = homePage.offerPrice.getText();

            //since no logging frame work is used using sysout for logging purpose

            System.out.println(offerPriceText);
            VacationsPage vacationsPage = new VacationsPage(this.driver);
            vacationsPage.viewCruises();
            vacationsPage.clickOnDates();
            String listedOfferPrices = vacationsPage.getListedOfferPrices();
            System.out.println("prices" + listedOfferPrices);

            /*Making assertion so that offerPrice should be available in one of the listed prices on vacations page */

            Assert.assertTrue(listedOfferPrices.contains(offerPriceText));


        } catch (InterruptedException e) {
            System.out.println("exception occurred");
        }
    }

    @BeforeTest
    public void beforeTest() {
        driver.navigate().to("https://www.ncl.com/");
        driver.manage().window().maximize();
        System.out.println("Starting NCL AAutomation test");
    }

    @AfterTest
    public void afterTest() {
        /*quitting chrome browser after tests are completed*/
        driver.quit();
        System.out.println("Completed NCL AAutomation test");
    }
}