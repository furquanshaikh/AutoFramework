package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class LoginPage extends BaseClass{
	
	//Page Factory -- object repository
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signupBtn;
	
	@FindBy(xpath="/html/body/div[2]/div/div[1]/a/img")
	WebElement logo;
	
	//initializing the page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateLogo(){
		return logo.isDisplayed();
	}
	
	public HomePage login(String usr, String pas) {
		username.sendKeys(usr);
		password.sendKeys(pas);
		loginBtn.click();
		return new HomePage();
	}

}
