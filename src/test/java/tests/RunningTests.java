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
        loginPage.enterUsername(ReadFromDatabase.getUsername);
        loginPage.enterPassword(ReadFromDatabase.getPassword);
        loginPage.clickLoginButton();
        welcomePage.validateLoginScreen();
    }


    @Test
    public void contactListNameTest() {
        contactUsPage.clickContactUsMenu();
        contactUsPage.getContactMethodList();
        Listener.extentTest.addScreenCaptureFromPath(TakeScreenshots.takesSnapShot(driver,"Contactscreen"));
//        TakeScreenshots.takesSnapShot(driver,"Contact screen");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
