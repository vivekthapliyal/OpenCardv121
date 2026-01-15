package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;


public class TC003_Login_DDT extends BaseClass{
		
	

	@Test(dataProvider ="LoginData", dataProviderClass = DataProviders.class, groups = "Datadriven") //getting data provider from the different package
	public void verify_loginDDT(String email, String pwd, String exp) throws InterruptedException 
	{
		logger.info("TC003_Login_DDT test started");	
		try {
			
		
		
		//Home page activity
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//login page activity
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.loginClick();
		
		MyAccountPage myacc=new MyAccountPage(driver);
		boolean targetpage= myacc.isMyAccountDisplayed();
		
		// Test cases 
		//data valid > Login success > Test pass > Logout 
		//Data valid > Login failed > Test fail
		//
		//Data is invalid > Login success > Test fail > Logout 
		//Data is invalid > Login fail > Test pass		
		
		logger.info("Entering the user details ");
		if(exp.equalsIgnoreCase("Valid")) {
			if(targetpage==true) {
				logger.info("Checking the valid case 1 ");
				myacc.logout();
				Assert.assertTrue(true);
			}
			else {
				logger.info("Checking the valid case 2 ");
				Assert.assertTrue(false);
				}
			}
		if(exp.equalsIgnoreCase("Invalid")) {
			if(targetpage==true) {
				logger.info("Checking the Invalid case 1 ");
				myacc.logout();
				Assert.assertTrue(false);
			}
			else {
				logger.info("Checking the Invalid case 2 ");
				Assert.assertTrue(true);
				}
			}
			} catch (Exception e) {
				Assert.fail();
			}
		Thread.sleep(3000);
		logger.info("Finshed TC003_Login_DDT Test");
	}
}
