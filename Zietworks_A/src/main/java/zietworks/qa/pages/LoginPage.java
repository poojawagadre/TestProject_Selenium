package zietworks.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import zietworks.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(id = "1-email")
	WebElement username;
	
	@FindBy(name ="password" )
	WebElement password;
	
	@FindBy(name ="submit" )
	WebElement loginBtn;
		
	@FindBy(xpath ="//div[@class='auth0-lock-social-button-text']" )
	WebElement googleSignIn;
	
	@FindBy(xpath ="//img[@class='auth0-lock-header-logo']" )
	WebElement headerLogo;
	
	@FindBy(xpath ="//div[@class='auth0-lock-name']" )
	WebElement lockName;
	
	@FindBy(xpath ="//a[@class='auth0-lock-alternative-link']" )
	WebElement forgotPassword;

		
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public String validatePageTitle() {
	
		return driver.getTitle();
	}
	
	public boolean validateLogo() {
		
		return headerLogo.isDisplayed();
		
	}
	
	public String validateLockName() {
		
		String lockname = lockName.getText();
		return lockname;
	}
	
	public boolean validateForgotPassLink() {
		
		return forgotPassword.isEnabled();
		
	}
	
	public Dashboard login(String un, String pwd) {
		
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		return new Dashboard();
	}
	
}
