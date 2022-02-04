package week5.day2classroomexercise;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFaildTCs implements IRetryAnalyzer{

	int count = 0;
	public boolean retry(ITestResult result) {
		if(count<2) {
		return true;
	}
		return false;
	
	}	

}
