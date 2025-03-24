package Testing;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.sql.Driver;
import Pages.Login;

public class testLogin extends Base{
	
	
	@Test(dataProvider = "getData")
	public void Ftest(String name, String pass) throws InterruptedException {
		
	//	extent.createTest("demo1");
		Login login = new Login(driver);
		login.clicklogin();
		login.user(name);
		login.pass(pass);
		login.clickloginbtn();
		login.successmessage();
		
		Thread.sleep(3000);
		// extent.flush();
		
	}
	@Test
	public void emailerror() throws InterruptedException {
		
	//	extent.createTest("demo1");
		Login login = new Login(driver);
		login.clicklogin();
		login.user("dgd");
		login.pass("fgdfd456");
		login.clickloginbtn();
		login.mailerror();
		
		Thread.sleep(3000);
		// extent.flush();
		
	}
	@Test
	public void passerror() throws InterruptedException {
		
	//	extent.createTest("demo1");
		Login login = new Login(driver);
		login.clicklogin();
		login.user("abc@gmail.com");
		login.pass("fgdfd");
		login.clickloginbtn();
		login.passerror();
		
		Thread.sleep(3000);
		// extent.flush();
		
	}
	
	@DataProvider		// This is data provider
	public Object[][] getData(){
		return new Object[][] {	{"abc@gmail.com", "123456147"}	};		// This is the array
	}
}


