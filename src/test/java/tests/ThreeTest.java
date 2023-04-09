package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import resources.Base;

@Test
public class ThreeTest extends Base {
	public WebDriver driver;
	  public void testThree() throws IOException, InterruptedException {
		  driver=initializeDriver();
		  driver.get("https://www.selenium.dev/");
		  Thread.sleep(3000);
		  System.out.println(driver.getTitle());
		  Assert.assertTrue(false);
		  driver.quit();
	  }
	}
