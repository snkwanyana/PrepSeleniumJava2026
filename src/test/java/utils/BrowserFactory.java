package utils;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;

import java.time.Duration;

public class BrowserFactory {

     static WebDriver driver;

    public static WebDriver startBrowser(String browserType, String url){

        if (browserType.equalsIgnoreCase("chrome")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--incognito");
            driver = new ChromeDriver(options);
        }else if (browserType.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }else if (browserType.equalsIgnoreCase("Safari")){
            driver = new SafariDriver();
        }else {
            driver = new EdgeDriver();
        }

        driver.get(url);
        driver.manage().window().setSize(new Dimension(1920,1080));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;

    }

}
