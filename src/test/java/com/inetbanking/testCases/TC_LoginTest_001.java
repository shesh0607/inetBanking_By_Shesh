
package com.inetbanking.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObject.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	@Test
	public void loginTest() throws IOException, InterruptedException {

	    Logger.info("Url is opened");
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		Logger.info("Entered Username");
		lp.setPassword(password);
		Logger.info("Entered Password");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			Logger.info("Login test passed");
		}
		else
		{
			capturesScreen(driver,"loginTest");
			Assert.assertTrue(false);
			Logger.info("Login test Failed");
		}
		
	}
	

}
