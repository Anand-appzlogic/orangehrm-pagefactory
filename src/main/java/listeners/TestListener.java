package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.orangehrm.BaseClass;

import failure.AIFailureAnalyzer;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println("-------------");
        System.out.println("TEST FAILED : " + result.getName());

        String errorMessage = result.getThrowable().getMessage();

      
        String aiInsight = AIFailureAnalyzer.analyze(errorMessage);
        System.out.println("AI Insight : " + aiInsight);

        
        BaseClass base = (BaseClass) result.getInstance();
        base.screenshotUtil.captureScreenshot(result.getName());

        System.out.println("------------");
    }
   
}