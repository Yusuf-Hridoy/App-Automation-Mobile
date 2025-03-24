package Testing;

import org.testng.annotations.Test;

import Pages.Login;
import Pages.swipe;

public class testswipe extends Base{
	
	@Test
	public void Ftest() throws InterruptedException {
		
	//	extent.createTest("demo1");
		swipe swipee = new swipe(driver);
		swipee.clickswipe();
		swipee.clickswiper();
		
		
		Thread.sleep(3000);
		// extent.flush();
		
	}

} 
