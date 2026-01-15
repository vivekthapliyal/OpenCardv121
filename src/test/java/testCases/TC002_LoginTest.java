package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;


public class TC002_LoginTest extends BaseClass{

	@Test(groups = {"Sanity","Master"})
	public void verifyLogin() {
		// TODO Auto-generated method stub
		logger.info("Starting TC002_LoginTest");
		
		try {
			
		//Home page activity
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//login page activity
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.loginClick();
		
		MyAccountPage myacc=new MyAccountPage(driver);
		boolean targetpage= myacc.isMyAccountDisplayed();
		
		//Assert.assertEquals(targetpage, true,"login failed");
		Assert.assertTrue(targetpage);
		
		} catch (Exception e) {
			// TODO: handle exception
			Assert.fail();

		}
		
		logger.info("Finished TC_002_LoginTest");
	}
	
}
