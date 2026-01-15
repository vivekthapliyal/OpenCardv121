package testCases;
import java.time.Duration;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	@Test(groups = {"Regression","Master"})
	public void verifyAccountRegistration() throws InterruptedException {
		
		logger.info("Starting the TC001`_AccountRegistrationTest ");
		
		try {
			
		
		//Creating the homepages object
		HomePage hp=new HomePage(driver);
		
		hp.clickMyAccount();
		logger.info("Clicking on MyAccount link");

		hp.clickRegister();
		logger.info("Clicked on Register link ");

		
		//Creating Account registration object
		AccountRegistrationPage regPage=new AccountRegistrationPage(driver);
		logger.info("Providing customer details");

		regPage.setFirstName(randomString().toUpperCase());
		regPage.setLastName(randomString().toUpperCase());
		regPage.setEmail(randomString()+"@gmail.com");
		regPage.setTelephone(randomNumber());
		
		//Storing ramdom password and passing the same in password and confirm password
		String randompassword=randomNumber();
		regPage.setPassword(randompassword);
		regPage.setConfirmPassword(randompassword);
		regPage.checkPolicy();
		regPage.continueTap();
		Thread.sleep(5000);
		logger.info("Validating the expected message");

		String confirmationmessage=regPage.getConfirmation();
		
		
		if(confirmationmessage.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
			
		}else {
			logger.error("Test Failed");
			 logger.debug("Debug loges");
				Assert.assertTrue(false);

			
		}
		
		} catch (Exception e) {
		
			Assert.fail();
		}
		logger.info("TC001`_AccountRegistrationTest");

		
	}
	

}
