package helper;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    int count =1;
    int retryMaxLimit=3;
    @Override
    public boolean retry(ITestResult iTestResult) {
        if(count<retryMaxLimit) {
            count++;
            return true;
        }
        return false;
    }
}
