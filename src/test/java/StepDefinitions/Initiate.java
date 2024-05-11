package StepDefinitions;

import Utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Initiate {
    public static WebDriver driver;

    @Before
    public  static void openBrowser() throws InterruptedException {
        //Set up the selected browser from the config.properties file (chrome,firefox,edge)
        String browser = ConfigReader.getBrowser();
        switch (browser.toLowerCase()) {
            case "chrome":
              System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\IdeaProjects\\Saoudi_Assessment\\src\\main\\resources\\chromedriver.exe");
              driver = new ChromeDriver();
                break;
            case "firefox":
              System.setProperty("webdriver.gecko.driver", "C:\\Users\\user\\IdeaProjects\\Saoudi_Assessment\\src\\main\\resources\\geckodriver.exe");
              driver = new FirefoxDriver();
                break;
            case "edge":
              System.setProperty("webdriver.edge.driver", "C:\\Users\\user\\IdeaProjects\\Saoudi_Assessment\\src\\main\\resources\\msedgedriver.exe");
              driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Invalid browser is selected in the congfig.properties file");
        }
        driver.manage().window().maximize();
        String URL = "https://demo.nopcommerce.com/";
        driver.get(URL);
    }

    @After
    public static void closeBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
