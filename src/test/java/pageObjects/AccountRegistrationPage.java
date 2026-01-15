package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement firstname;
	
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement lastname;
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement telephone;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement confirmPassword;
	
	@FindBy(xpath="//input[@id='input-newsletter']")
	WebElement newslatter;
	
	
	@FindBy(xpath = "//input[@name='agree']")
	WebElement checkpolicy;
	
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement continueButton;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgconfirmation;
	
	public void setFirstName(String fname) {
		firstname.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
	lastname.sendKeys(lname);
	}

    public void setEmail(String mail) {
	email.sendKeys(mail);
    }
    
    public void setTelephone(String phone) {
	telephone.sendKeys(phone);
    }
    
	public void setPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void setConfirmPassword(String confirmPass) {
		confirmPassword.sendKeys(confirmPass);
	
	}
	
	public void CheckNewsletter(String nletter) {
		newslatter.sendKeys(nletter);
	}
	
	
	public void checkPolicy() {
		checkpolicy.click();
	}
	
	public void continueTap() {
		continueButton.click();
	}
	
	
	public String getConfirmation() {
		
		try {		
			
			return msgconfirmation.getText();
			
		} 
		catch (Exception e) {
			return e.getMessage();
			}
		
		}
	}
	
	
	