package tests;


import java.io.IOException;
import java.util.Properties;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pagesObjects.LandingPage;
import pagesObjects.LoginPage;
import pagesObjects.MyAccountPage;
import resources.Base;
import resources.ExcelReader;

public class LoginTest extends Base {
	public WebDriver driver;
	@BeforeMethod
	public void openApplication() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));	
	
	}

	@Test(dataProvider = "getLoginData")

	public void login(String userName, String password,String expected  ) throws IOException {

		LandingPage landing = new LandingPage(driver);
		landing.myAccountDropDown().click();
		landing.loginOption().click();

		LoginPage login = new LoginPage(driver);
		login.emailaddress().sendKeys(userName);
		login.passwordfield().sendKeys(password);
		login.loginButton().click();
		

		MyAccountPage account = new MyAccountPage(driver);
		String actual = null;
		try {
		if(account.getEdityouraccInfo().isDisplayed()) {
			actual="success";
		} 
		}
		catch(Exception e) {
			actual="failure";
		}
		Assert.assertEquals(actual, expected);
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

	@DataProvider
	public Object[][] getLoginData() throws IOException {
		ExcelReader excel= new ExcelReader();
		Object[][] exceldata=excel.excelRead();
		return exceldata;
	}

}