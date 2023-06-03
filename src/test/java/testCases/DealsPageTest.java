package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.DealsPage;
import pages.HomePage;
import pages.LoginPage;
import utilitiy.TestUtil;

public class DealsPageTest extends BaseClass{

	public LoginPage loginObj;
	public HomePage objHome;
	public TestUtil objTestUtil;
	public DealsPage objDeals;
	
	@BeforeMethod
	public void setup() throws IOException {
		initialize();
		loginObj = new LoginPage();
		objTestUtil = new TestUtil();
		objHome = loginObj.login(prop.getProperty("username"), prop.getProperty("password"));
		objTestUtil.switchToFrame();
		objHome.clickOnDeals();
		objDeals = new DealsPage();
	}
	
	@Test(priority=1)
	public void verifyDealsLabelTest() {
		//System.out.println(objDeals.verifyDealsLabel());
		AssertJUnit.assertTrue(objDeals.verifyDealsLabel());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
