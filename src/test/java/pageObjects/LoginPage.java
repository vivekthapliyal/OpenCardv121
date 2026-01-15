package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(xpath ="//input[@id='input-email']")
	WebElement textemailaddress;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement passwordbox;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginbutton;
	
	
	public void setEmail(String email) {
		textemailaddress.sendKeys(email);
	}
	
	public void setPassword(String password) {
		passwordbox.sendKeys(password);
	}
	
	public void loginClick() {
		loginbutton.click();
	}
	

	
	
	

}
