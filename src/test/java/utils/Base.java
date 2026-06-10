package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.ContactUsPage;
import pages.HomeMenuPage;
import pages.LoginPage;
import pages.WelcomePage;

public class Base {

    final BrowserFactory factory = new BrowserFactory();
    public final WebDriver driver = factory.startBrowser("chrome", "https://ndosisimplifiedautomation.vercel.app/");
    public HomeMenuPage homeMenuPage = PageFactory.initElements(driver, HomeMenuPage.class);
    public LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    public WelcomePage welcomePage = PageFactory.initElements(driver, WelcomePage.class);
    public ContactUsPage contactUsPage = PageFactory.initElements(driver, ContactUsPage.class);
}
