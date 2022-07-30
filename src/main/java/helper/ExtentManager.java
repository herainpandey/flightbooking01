package helper;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager {

    public static ExtentReports extentReports;

    public static ExtentReports getExtentReport(){
        if(extentReports==null){
            return createReport();
        }
        return extentReports;
    }

    public static ExtentReports createReport(){
        // initialize the HtmlReporter
        ExtentHtmlReporter reporter = new ExtentHtmlReporter("reports\\extent-report.html");
        reporter.config().setDocumentTitle("|EXTENT==REPORTS|");
        extentReports = new ExtentReports();
        extentReports.attachReporter(reporter);
        return extentReports;
    }
}
