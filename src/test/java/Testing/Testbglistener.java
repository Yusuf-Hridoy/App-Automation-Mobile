package Testing;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;

public class Testbglistener  implements ITestListener {
	ExtentTest test;
	ExtentReports extent = extentreport.configo();
	@Override
	public void onTestStart(ITestResult result) {
		 test = extent.createTest(result.getMethod().getMethodName());	// dynamically will get the name
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "test pass");	// dynamically will get the name
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());	// dynamically will get the name
		
	}
	
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();	// dynamically will get the name
	}


}
