package extentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

public class ExtentReportMananger {

    private static String reportDir = System.getProperty("user.dir")+ "/Reports/NdosiAutomationReport.html";
    private static ExtentReports extentReports;
    private static ExtentSparkReporter extentSparkReporter;

    public static ExtentReports extentReports(){
        extentReports = new ExtentReports();
        extentSparkReporter = new ExtentSparkReporter(new File(reportDir));
        extentReports.attachReporter(extentSparkReporter);

        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setDocumentTitle("Ndosi automation");
        extentSparkReporter.config().setReportName("Ndosi user friendly report");

        extentReports.setSystemInfo("os",System.getProperty("os.name"));
        extentReports.setSystemInfo("Execution machine", System.getProperty("user.name"));

        return extentReports;

    }
}
