package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class HomeMenuPage {

    WebDriver driver;
    By mainLoginButton_xpath = By.xpath("//div[@class='nav-user-section']");

    public HomeMenuPage(WebDriver driver){
        this.driver = driver;
    }

    public void verifyHomePageIsLoaded(){
        driver.findElement(mainLoginButton_xpath).isDisplayed();
    }

    public void clickLoginButton(){
        driver.findElement(mainLoginButton_xpath).click();
    }

}
