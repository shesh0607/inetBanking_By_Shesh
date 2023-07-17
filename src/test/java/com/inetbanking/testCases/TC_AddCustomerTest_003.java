package com.inetbanking.testCases;

import java.io.IOException;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObject.AddCustomerPage;
import com.inetbanking.pageObject.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {

	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		Logger.info("user name is provided");
		lp.setPassword(password);
		Logger.info("Password is provided");
		lp.clickSubmit();
		Logger.info("Submitted");
		
		Thread.sleep(3000);
		
//		lp.clickDismiss();
		
		
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		Logger.info("Click on Add New Customer");
		Thread.sleep(5000);
		//lp.clickDismiss();
		
		
		//Thread.sleep(3000);
		Logger.info("Providing customer details......");
		lp.clickDismiss();
		addcust.custName("Shubham");
		addcust.custGender("male");
		addcust.custdob("06451999");
		Thread.sleep(3000);
		addcust.custaddress("INDIA");
		addcust.custcity("PUNE");
		addcust.custstate("MH");
		addcust.custpinno("412207");
		addcust.custtelephoneno("9292939999");
		String email=randomestring()+"@gmail.com";
		addcust.custemailid(email);
		Thread.sleep(3000);
		addcust.custpassword("ahshdjdj");
		addcust.custsubmit();
		
		Thread.sleep(4000);
		
		Logger.info("Validation started...");
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res==true) {
			Assert.assertTrue(true);
			Logger.info("test case passed...,");
		}
		else {
			capturesScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
			Logger.info("test case  failed");
		}
		
		
	}
	
	
}
