package pagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
	
	WebDriver driver;
	
	public MyAccountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//ul[@class='breadcrumb']//a[text()='Account']")
	WebElement editaccountInfo;
	@FindBy(xpath= "//a[contains(text(),'Edit your account information')]")
	WebElement edityouraccInfo;
	
	public WebElement getEdityouraccInfo() {
		return edityouraccInfo;
	}

	public WebElement editAccountInfo() {
		return editaccountInfo;
	}

}