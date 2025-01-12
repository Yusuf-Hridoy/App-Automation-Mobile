package Testing;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class LoginTest extends Base{
	
	@Test
	public void LoginSuccess() throws MalformedURLException, URISyntaxException, InterruptedException
	{
		 driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"Login\"]")).click();	
		 driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"input-email\"]")).sendKeys("aaa@gmail.com");
		 driver.hideKeyboard();
		 driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"input-password\"]")).sendKeys("123456AW@");
		 driver.hideKeyboard();
		 driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"button-LOGIN\"]/android.view.ViewGroup")).click();
		 
		 WebElement getlogint = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/message\"]"));
		 String logtext = getlogint.getText();
		 System.out.println("the after login text"  +logtext);
		 
		 driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")).click();
		 
		 
		 Thread.sleep(3000);
		 
}
	@Test
	public void emailerrorCheck() throws MalformedURLException, URISyntaxException, InterruptedException
	{
		 driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"Login\"]")).click();	
		// driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"input-email\"]")).sendKeys("aaa@gmail.com");
		// driver.hideKeyboard();
		 driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"input-password\"]")).sendKeys("123456AW@");
		 driver.hideKeyboard();
		 driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"button-LOGIN\"]/android.view.ViewGroup")).click();
		 
		 WebElement getlogint = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Please enter a valid email address\"]"));
		 String logtext = getlogint.getText();
		 System.out.println("the after login text ="  +logtext);
		 
		
		 
		 
		 Thread.sleep(3000);
		 
}
	@Test
	public void PassworderrorCheck() throws MalformedURLException, URISyntaxException, InterruptedException
	{
		 driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"Login\"]")).click();	
		 driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"input-email\"]")).sendKeys("aaa@gmail.com");
		 driver.hideKeyboard();
		// driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"input-password\"]")).sendKeys("123456AW@");
		// driver.hideKeyboard();
		 driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"button-LOGIN\"]/android.view.ViewGroup")).click();
		 
		 WebElement getlogint = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Please enter at least 8 characters\"]"));
		 String logtext = getlogint.getText();
		 System.out.println("the after login text ="  +logtext);
		 
		
		 
		 
		 Thread.sleep(3000);
		 
}
}





