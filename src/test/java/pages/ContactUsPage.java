package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactUsPage {

    WebDriver driver;

    By contactusMenu_xpath = By.xpath("//button[@class='nav-item ']/span[contains(text(),'Contact Us')]");
    By contactMethods_xpath = By.tagName("h3");

    public ContactUsPage(WebDriver driver){
        this.driver = driver;
    }
    public void clickContactUsMenu(){
        driver.findElement(contactusMenu_xpath).click();
    }
    public void getContactMethodList(){
        ArrayList<String> contacts = new ArrayList<>();
        List<WebElement> contactList = driver.findElements(contactMethods_xpath);
        for (WebElement contact: contactList){
            contacts.add(contact.getText());
        }

        System.out.println(contacts);
    }
}
