package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;



@Test
public class TwoTest extends Base{
	public WebDriver driver;
  public void testTwo () throws IOException, InterruptedException {
	  driver=initializeDriver();
	  driver.get("https://www.google.co.in/");
	  Thread.sleep(3000);
	  System.out.println(driver.getTitle());
	  driver.quit();
  }
}
