package rsa.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

    public static ExtentReports getReporterObject(){

            // ExtentSparkReporter
            String path = System.getProperty("user.dir")+"\\reports\\index.html";
            ExtentSparkReporter reporter = new ExtentSparkReporter(path);
            reporter.config().setReportName("E-commerce Automation");
            reporter.config().setDocumentTitle("Test Results");

            //ExtentReports
            ExtentReports extent = new ExtentReports();
            extent.attachReporter(reporter);
            extent.setSystemInfo("Tester", "Jaroslaw Nazar");
            extent.createTest(path);
            return extent;
    }

}
