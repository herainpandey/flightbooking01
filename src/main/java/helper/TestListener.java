package helper;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private static ExtentReports extentReports = ExtentManager.getExtentReport();
    private static ExtentTest test;
    private static ThreadLocal<ExtentTest> thread = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        test = extentReports.createTest(result.getMethod().getMethodName());
        thread.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        thread.get().log(Status.PASS, MarkupHelper.createLabel("SUCCESS", ExtentColor.BLUE));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        thread.get().log(Status.FAIL,MarkupHelper.createLabel("FAILED",ExtentColor.RED));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        thread.get().log(Status.SKIP,MarkupHelper.createLabel("SKIPPED",ExtentColor.GREY));

    }

    @Override
    public void onFinish(ITestContext context) {
        if(extentReports!=null){
            extentReports.flush();
        }
    }


}
