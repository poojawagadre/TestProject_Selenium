package Zietworks.qa.testpage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import zietworks.qa.base.TestBase;
import zietworks.qa.pages.Dashboard;
import zietworks.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	Dashboard dashboard;
	
	public LoginPageTest() {
		
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		loginpage = new LoginPage();
	}

	@Test
	public void pageTitleTest() {
		
		String title = loginpage.validatePageTitle();
		Assert.assertEquals(title, "Sign In with Auth0");
	}
	
	@Test
	public void pageLogoTest() {
		
		Assert.assertTrue(loginpage.validateLogo());
	}
	
	@Test
	public void pageLockNameTest() {
		
		String lockname = loginpage.validateLockName();
		Assert.assertEquals(lockname, "zeithworks App Staging");
	}
	
	@Test
	public void forgotPassTest() {
		
		Assert.assertTrue(loginpage.validateForgotPassLink());
	}
	
	@Test
	public void loginTest() {
		
		dashboard = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
			
	}
		
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
}
