package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class HomePage extends BaseClass{
	
	//Page Factory -- Object Repository
	@FindBy(xpath="//td[contains(text(),'User: furquantest sk')]")
	WebElement userNameHome;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement createNewContactLink;
	
	@FindBy(tagName="a")
	List<WebElement> homePageLinks;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Action
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyUserNameLabel() {
		return userNameHome.isDisplayed();
	}
		
	public ContactPage clickOnContact() {
		contactLink.click();
		return new ContactPage();
	}
	
	public DealsPage clickOnDeals() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public void verifyClickOnCreateNewContactLink() {
		Actions act = new Actions(driver);
		act.moveToElement(contactLink).build().perform();
		createNewContactLink.click();
	}
	
	public void homePageLinks() {
		System.out.println("total links on home page is -> "+homePageLinks.size());
		/*for(int i=1;i<homePageLinks.size();i++) {
			System.out.println("Name of Link is -> "+homePageLinks.get(i).getText());
		}*/
	}
	
	public boolean elementPresentcheck(){
		return contactLink.isDisplayed();
	}
}
