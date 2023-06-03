package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import base.BaseClass;
import pages.ContactPage;
import pages.HomePage;
import pages.LoginPage;
import utilitiy.TestUtil;

public class HomePageTest extends BaseClass{
	
	public LoginPage loginObj;
	public HomePage objHome;
	public TestUtil objTestUtil;
	public ContactPage objContactPage;
	
	@BeforeMethod
	public void setup() throws IOException {
		initialize();
		loginObj = new LoginPage();
		objTestUtil = new TestUtil();
		objHome = loginObj.login(prop.getProperty("username"), prop.getProperty("password"));
		objTestUtil.switchToFrame();
	}
	
	@Test(priority=2)
	public void verifyUserNameLabelTest() throws InterruptedException {
		//System.out.println("reached here");
		//Thread.sleep(14000);
		Assert.assertTrue(objHome.verifyUserNameLabel());
	}
	
	@Test(priority=1)
	public void verfiyhomePageTitle() {
		String expected = objHome.verifyHomePageTitle();
		SoftAssert softAssert = new SoftAssert();
		//System.out.println(expected);
		softAssert.assertEquals(expected, "CRMPRO", "Home Page Tile not matching");
	}
	
	@Test(priority=3)
	public void verifyContactLinkTest() {
		objHome.clickOnContact();
	}
	
	@Test(priority=1)
	public void countHomePagetLinksTest() {
		objHome.homePageLinks();
	}
	
	
	@Test(priority=1)
	public void elementPresentTest(){
		objHome.elementPresentcheck();
		System.out.println(objHome.elementPresentcheck());
		//driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
