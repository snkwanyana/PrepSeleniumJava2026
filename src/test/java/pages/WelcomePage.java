package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage {

    WebDriver driver;

    By loginVerification = By.tagName("h2");

    public WelcomePage(WebDriver driver){
        this.driver = driver;
    }

    public void validateLoginScreen(){
        driver.findElement(loginVerification).isDisplayed();
    }
}
