package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;

    public static String baseURL = "https://www.saucedemo.com/";

    public void openBrowser(String baseURL){
        driver = new ChromeDriver();
        //launch the url
        driver.get(baseURL);
        //Maximise window
        driver.manage().window().maximize();
        //Implicit timeout
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    public void closeBrowser(){
        driver.close();
    }
}
