package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException {
	prop= new Properties();
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
	prop.load(fis);
	String browser=prop.getProperty("browser");
	if (browser.equals("chrome")) {
		ChromeOptions co =new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver= new ChromeDriver(co);
		
	}
	else if (browser.equals("firefox")) {
		driver= new FirefoxDriver();
		
	}
	else if (browser.equals("edge")) {
		driver= new EdgeDriver();
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	return driver;
	}
	
	public String takeScreenshot(String testName, WebDriver driver) throws IOException {
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationFile=(System.getProperty("user.dir")+"\\screenshots\\"+testName+".png");
		FileUtils.copyFile(sourceFile, new File(destinationFile));
		return destinationFile;
	}
}
