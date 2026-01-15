package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.Logger;  //Log4j
import org.apache.logging.log4j.LogManager;  //Log4j



public class BaseClass {
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@BeforeClass(groups = {"Regression","Master","Sanity"})
	@Parameters({"os","browser"})
	public void setUp(String os, String br) throws IOException {
		
		//loading config.properties
		p=new Properties();
		FileInputStream file=new FileInputStream(".//src//test//resources//config.properties");
		p.load(file);
		
		String applicationURL =p.getProperty("appURL2");
		
		
		//For logs 
		logger=LogManager.getLogger(this.getClass());
		
		switch (br.toLowerCase()) {
		case "chrome": driver=new ChromeDriver(); break;
		case "firefox": driver=new FirefoxDriver(); break;
		case "edge": driver=new EdgeDriver(); break;
		default: System.out.println("Invalid browser"); return;
		}
		
		
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		driver.get(applicationURL);
		
	}
	
	@AfterClass(groups = {"Regression","Master","Sanity","Datadriven"})
	public void teardown() {
		driver.quit();
		
	}
	
	//Generation random email
	public String randomString() {
		return RandomStringUtils.randomAlphabetic(5);
		
	}
	
	public String randomNumber() {
		return RandomStringUtils.randomNumeric(10);
		
	}
	
	public String randomAlphaNumeric() {
		return (RandomStringUtils.randomAlphabetic(5)+RandomStringUtils.randomNumeric(10));
		
	}
	
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	
}
