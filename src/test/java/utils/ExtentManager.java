package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
            spark.config().setReportName("Versiq AI Automation Report");
            spark.config().setDocumentTitle("Versiq AI Test Results");
            extent.attachReporter(spark);
        }
        return extent;
    }
	

}
