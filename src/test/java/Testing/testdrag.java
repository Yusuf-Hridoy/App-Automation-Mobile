package Testing;

import org.testng.annotations.Test;

import Pages.drag;
import Pages.swipe;

public class testdrag extends Base{
	
	@Test
	public void dragtest() throws InterruptedException {
		
	drag drage = new drag (driver);
	drage.clickdrag();
	drage.dodrag();
	
		
	}

}



