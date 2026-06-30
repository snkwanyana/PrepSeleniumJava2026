package tests;

import extentReport.ExtentReportMananger;
import extentReport.Listener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testData.ReadFromDatabase;
import utils.Base;
import utils.TakeScreenshots;


public class RunningTests extends Base {

    @BeforeClass
    public void setup(){
        ReadFromDatabase.dbConnection();
    }
    @Test
    public void loginTest(){
        homeMenuPage.verifyHomePageIsLoaded();
        homeMenuPage.clickLoginButton();
//        loginPage.enterUsername(ReadFromDatabase.getUsername);
//        loginPage.enterPassword(ReadFromDatabase.getPassword);
        loginPage.enterUsername("nkwanyana@gmail.com");
        loginPage.enterPassword("#12345678");
        loginPage.clickLoginButton();
        welcomePage.validateLoginScreen();


        // Capture and attach screenshot to Extent Report
        try {
            String screenshotPath = TakeScreenshots.takesSnapShot(driver, "LoginScreen");
            Listener.extentTest.addScreenCaptureFromPath(screenshotPath, "Login Screen");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void contactListNameTest() {
        contactUsPage.clickContactUsMenu();
        contactUsPage.getContactMethodList();


    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
