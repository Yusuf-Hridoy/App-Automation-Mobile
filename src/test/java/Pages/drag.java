package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class drag {
	
	AndroidDriver driver;   // here the driver is demo driver
	public drag(AndroidDriver driver) {
	
	this.driver=driver;
	PageFactory.initElements(new AppiumFieldDecorator(driver), this);

}
	@AndroidFindBy (xpath = "//android.view.View[@content-desc=\"Drag\"]")
	private WebElement dragbtn;
	
	@AndroidFindBy (xpath = "//android.view.ViewGroup[@content-desc=\"drag-l2\"]/android.widget.ImageView")
	private WebElement optionbtn;
	
	

	
	
	public void clickdrag() {
		dragbtn.click();
	}
	
	public void dodrag() {
		optionbtn.click();
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) optionbtn).getId(),
			    "endX", 350,
			    "endY", 797
			));
		
	}

}