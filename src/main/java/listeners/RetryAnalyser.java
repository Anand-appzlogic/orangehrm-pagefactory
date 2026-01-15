package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {
	private int recount=0;
	private int maxRe = 2;
	
	public boolean retry(ITestResult result) {
		if(recount<maxRe) {
			recount++;
			System.out.println(result.getName()+ "retry count" +recount);
			return true;
			
		}
		return false;
	}
			

}
