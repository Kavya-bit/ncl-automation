import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    String driverPath = "C:\\Users\\kavya\\Downloads\\chromedriver_win32\\chromedriver.exe";
    public WebDriver driver;

    BaseTest() {

        System.setProperty("webdriver.chrome.driver", driverPath);
        this.driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
}