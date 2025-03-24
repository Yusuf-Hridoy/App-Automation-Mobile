package Testing;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Base {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService servive;
	
	@BeforeClass
	public void CommonConfigure() throws MalformedURLException, URISyntaxException {
		// this line of code is for to invoke the appium server from the local machine
		//Properties prop = new Properties();
		//FileInputStream fis = new FileInputStream("D:\\Mobile qa Auto\\Mobile_Project\\src\\main\\java\\resources\\data.properties");
	//	prop.load(fis);
	//	String ipAddress = prop.getProperty("ipAddress");
	//	servive = startAppiumServer(ipAddress);
		
			 servive = new  AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Md Yusuf Ahmed\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
						.withIPAddress("127.0.0.1").usingPort(4723).build();
				servive.start();
					
				
				UiAutomator2Options options = new UiAutomator2Options();
				options.setDeviceName("Lucifer");
				options.setApp("C:\\Users\\Md Yusuf Ahmed\\Downloads\\android.wdio.native.app.v1.0.8.apk");
				
					 driver = new AndroidDriver (new URI("http://127.0.0.1:4723").toURL(), options);
				 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				
			
	}
	public void longpress(WebElement ele) {  // this is for long press
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId",((RemoteWebElement) ele).getId(),"duration",2000));
	}
	
	public void swipeaction(WebElement imageView, String direction) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement)imageView).getId(),
			    "direction", direction,
			    "percent", 1.0
			));
	}
	
	public String screenshot( WebDriver driver, String testname) throws IOException {
	    File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    String destination = System.getProperty("user.dir") + "\\reports\\" + testname + ".png";
	    File destinationFile = new File(destination);
	    FileUtils.copyFile(source, destinationFile);
	    return destination;
	}
	
	
	@AfterClass
	public void finish() {
		driver.quit();
		servive.stop();
	}
	
	

}



