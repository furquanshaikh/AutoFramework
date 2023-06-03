package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class LoginPageTest extends BaseClass{
	LoginPage loginObj;
	
	@BeforeMethod
	public void setup() throws IOException {
		initialize();
		loginObj = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String expected = loginObj.getLoginPageTitle();
		AssertJUnit.assertEquals(expected, "Free CRM - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority=2)
	public void logoTest() {
		AssertJUnit.assertTrue(loginObj.validateLogo());
	}
	
	@Test(priority=3)
	public void ableToLogin() {
		loginObj.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();	
	}
}
