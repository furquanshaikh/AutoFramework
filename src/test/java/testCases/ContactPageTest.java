package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.ContactPage;
import pages.HomePage;
import pages.LoginPage;
import utilitiy.TestUtil;

public class ContactPageTest extends BaseClass{
	public LoginPage loginObj;
	public HomePage objHome;
	public TestUtil objTestUtil;
	public ContactPage objContactPage;
	
	String sheetName = "Contact";
	
	@BeforeMethod
	public void setup() throws IOException {
		initialize();
		loginObj = new LoginPage();
		objTestUtil = new TestUtil();
		objHome = loginObj.login(prop.getProperty("username"), prop.getProperty("password"));
		objTestUtil.switchToFrame();
		objContactPage = new ContactPage();
	}
	
	@Test(priority=1)
	public void verifyContactLabelTest() {
		//System.out.println("1");
		objHome.clickOnContact();
		boolean label = objContactPage.verifyContactLabel();	
		//System.out.println(label);
		AssertJUnit.assertTrue(label);
	}
	
	@Test(priority=2)
	public void verifyClickOnCreateNewContactLinkTest() {
		objHome.verifyClickOnCreateNewContactLink();
	}
	
	@DataProvider
	public Object[][] getCRMTestData() throws FileNotFoundException{
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=3, dataProvider="getCRMTestData")
	public void CreateNewContactTest(String title, String firstName, String lastName, String company){
		objHome.verifyClickOnCreateNewContactLink();
		//contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		objContactPage.createNewContact(title, firstName, lastName, company);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
