package Pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.collect.ImmutableMap;

import Testing.Base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class swipe  {
	AndroidDriver driver;   // here the driver is demo driver
	public swipe(AndroidDriver driver) {
	
	this.driver=driver;
	PageFactory.initElements(new AppiumFieldDecorator(driver), this);

}
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@text=\"󰤼\"]")
	private WebElement swipebtn;
	
	@AndroidFindBy (xpath = "(//android.view.ViewGroup[@content-desc=\"slideTextContainer\"])[1]")
	private WebElement swiperi;
	
	
	
	public void clickswipe() {
		swipebtn.click();
	}
	
	public void clickswiper() {
		

	    String isFocusable = swiperi.getAttribute("focusable");
	    Assert.assertEquals(isFocusable, "false");

	  //  swipeaction(swiperi, "left");
	    
	    ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement)swiperi).getId(),
			    "direction", "left",
			    "percent", 1.0
			));

	}

		
		
		
	}


