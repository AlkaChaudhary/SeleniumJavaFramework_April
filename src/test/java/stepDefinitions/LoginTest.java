package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagesObjects.LandingPage;
import pagesObjects.LoginPage;
import pagesObjects.MyAccountPage;
import resources.Base;

public class LoginTest extends Base{
	 WebDriver driver;
	 LoginPage login;
	 @Given("^Open any browser$")
	    public void open_any_browser() throws Throwable {
	      driver=initializeDriver();  
	
	    }
	  @And("^Navigate to login page$")
	    public void navigate_to_login_page() throws Throwable {
	      driver.get(prop.getProperty("url"));
	      LandingPage landing = new LandingPage(driver);
	      landing.myAccountDropDown().click();
	      landing.loginOption().click(); 
	    }
	   @When("^User enter username as \"([^\"]*)\" and password as \"([^\"]*)\" into the fields$")
	    public void user_enter_username_as_something_and_password_as_something_into_the_fields(String usernmae, String password) throws Throwable {
	        login = new LoginPage(driver);
	        login.emailaddress().sendKeys(usernmae);
	        login.passwordfield().sendKeys(password);
	    }
	   @And("^User clicks on login Button$")
	    public void user_clicks_on_login_button() throws Throwable {
		   	login = new LoginPage(driver);
	        login.loginButton().click();
	    }
	   @Then("^verify user is able to successfully login$")
	    public void verify_user_is_able_to_successfully_login() throws Throwable {
	        MyAccountPage account = new MyAccountPage(driver);
	        Assert.assertTrue(account.editAccountInfo().isDisplayed());
	   }
	   @After
	   public void closeBrowser() {
		 driver.quit();  
	   }
	        	 
}
