package Testing;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
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
			    "percent", 0.75
			));
	}
	@AfterClass
	public void finish() {
		driver.quit();
		servive.stop();
	}
	
	

}



