package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class DealsPage extends BaseClass{

	//page factory -- object repository
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLabel;
	
	public DealsPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Action
	public boolean verifyDealsLabel() {
		return dealsLabel.isDisplayed();
	}

}
