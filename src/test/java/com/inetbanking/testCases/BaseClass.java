package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.Readconfig;

public class BaseClass {
	
	Readconfig readconfig=new Readconfig();
	
	public String baseURL=readconfig.getApplicationURl();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	public static Logger Logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		
		
	   Logger=org.apache.log4j.Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equals("chrome")) {


		System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		
		driver=new ChromeDriver(chromeOptions);

		}
		else if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxpath());
			driver=new FirefoxDriver();
			
			
			
		}
		driver.get(baseURL);
	}
	@AfterClass
	public void tearDown() {
		//driver.quit();
	}
     
	public void capturesScreen(WebDriver driver,String tname) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"./Screenshots/"+ tname +".png");
		FileUtils.copyFile(source, target);
		System.out.println("Scareenshot taken");
	}

	 //emailid are unique for every user so To generate emailaddress dynamically we have to create following user define function
		public String randomestring()
		{
		 String generatedstring=RandomStringUtils.randomAlphabetic(5);//randomalphabet means it generate the string with given num of characters
		 return (generatedstring);
		 
		}
		
		public static String  rendomeNum() {
			String generatedstring2=RandomStringUtils.randomNumeric(4);//randomNumeric means it generate the randomen number 
			return (generatedstring2);
			
			
		}
		
}
