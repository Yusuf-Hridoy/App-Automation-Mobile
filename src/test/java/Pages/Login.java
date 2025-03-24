package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Login {
		AndroidDriver driver;   // here the driver is demo driver
		public Login(AndroidDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
}
		
		@AndroidFindBy (xpath = "//android.view.View[@content-desc=\"Login\"]")
		private WebElement loginpage;
		
		@AndroidFindBy (xpath = "//android.widget.EditText[@content-desc=\"input-email\"]")
		private WebElement username;
		
		@AndroidFindBy (xpath = "//android.widget.EditText[@content-desc=\"input-password\"]")
		private WebElement password;
		
		@AndroidFindBy (xpath = "//android.view.ViewGroup[@content-desc=\"button-LOGIN\"]/android.view.ViewGroup")
		private WebElement Loginbtn;
		
		@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id=\"android:id/message\"]")
		private WebElement successlogin;
		
		@AndroidFindBy (xpath = "//android.widget.TextView[@text=\"Please enter a valid email address\"]")
		private WebElement emailerrors;
		
		@AndroidFindBy (xpath = "//android.widget.TextView[@text=\"Please enter at least 8 characters\"]")
		private WebElement passer;
		
		
		public void clicklogin() {
			loginpage.click();
		}
		
		public void user(String name) {
			username.sendKeys(name);
			driver.hideKeyboard();
		}
		public void pass(String number) {
			password.sendKeys(number);
			driver.hideKeyboard();
		}
		public void clickloginbtn() {
			Loginbtn.click();
		}
		public void successmessage() {
			String text = successlogin.getText();
			System.out.println("the text is " +text);
		}
		public void mailerror() {
			String text = emailerrors.getText();
			System.out.println("the text is " +text);
		}
		public void passerror() {
			String text = passer.getText();
			System.out.println("the text is " +text);
		}
}
