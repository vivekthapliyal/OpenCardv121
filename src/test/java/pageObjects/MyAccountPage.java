package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClass;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	WebElement myaccountheading;
	
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement lnklogout;
	

	
	public boolean isMyAccountDisplayed() {
		try {
			return (myaccountheading.isDisplayed());
		} catch (Exception e) {
			return false;
		}
	
		
	}
	
	
	public void logout() {
		lnklogout.click();
	}
	
	
	
	
	
}
