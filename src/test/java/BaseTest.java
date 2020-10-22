import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    //please update to local chrome driver location
    String driverPath = "C:\\Users\\kavya\\Downloads\\chromedriver_win32\\chromedriver.exe";
    public WebDriver driver;

    BaseTest() {

        System.setProperty("webdriver.chrome.driver", driverPath);
        /*Create driver object for CHROME browser*/
        this.driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

    }
}