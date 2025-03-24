package Testing;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentreport {
	static ExtentReports extent;
	
	public static ExtentReports configo()		// report configurtion
	{
		String path = 	System.getProperty("user.dir")+"\\reports\\index.html";
		 ExtentSparkReporter reporter = new ExtentSparkReporter(path);	// This one is responsible to create report
			reporter.config().setReportName("Mobile results");	 
			reporter.config().setDocumentTitle("testo");
			
			 extent = new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("Tester", "Yusuf ");
			return extent;			

}
}