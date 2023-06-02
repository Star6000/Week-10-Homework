package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public void openBrowser(String url){
        driver = new ChromeDriver();
        driver.get(url);// launch url
        driver.manage().window().maximize(); // maximising screen
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000)); // giving wait
    }
    public void CloseBrowser(){
        driver.quit();
    }
}


