package extentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class Listener implements ITestListener {

    private static ExtentReports extent;
    public static ExtentTest extentTest;

    @Override
    public void onTestStart(ITestResult result){
        extentTest = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result){
        extentTest.log(Status.FAIL, "Test case name "+result.getMethod().getMethodName()+" has failed");

    }

    @Override
    public void onTestSuccess(ITestResult result){
        extentTest.log(Status.PASS,"Test case name "+result.getMethod().getMethodName()+" has passed");
    }

    @Override
    public void onTestSkipped(ITestResult result){
        extentTest.log(Status.SKIP,"Test case name "+result.getMethod().getMethodName()+"has skipped");
    }

    @Override
    public void onFinish(ITestContext context){
        extent.flush();
    }

    @Override
    public void onStart(ITestContext context){
        extent = ExtentReportMananger.extentReports();
    }
}
