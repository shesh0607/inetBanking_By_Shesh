package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObject.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {
	@Test(dataProvider="LoginData.xlsx")
	public void loginDDT(String user,String pwd) 
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		Logger.info("user name is provided");
		lp.setPassword(pwd);
		Logger.info("password is provided");
		lp.clickSubmit();
		
		if(isAlertPresent()==true)//test fail 
	
		{
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			Logger.warn("Login failed");
		}
		else//test passed open homepage ,we have to logout
		{
			Assert.assertTrue(true);
			Logger.info("Login passed");
			lp.clickLogout();
			driver.switchTo().alert().accept();//close the logout alert.
			driver.switchTo().defaultContent();//focus on login window.
		}
	}
	
	
	
	public boolean isAlertPresent()//user defined method to check alert is present or not. it is reuse method we can put this in base class.
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}
	
	
	@DataProvider(name="LoginData.xlsx")
	String[][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData.xlsx.xlsx";
		int rownum=XLUtils.getRowCount(path,"sheet1");
		int colcount=XLUtils.getCellCount(path,"sheet1", 1);
		String logindata [][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++) 
		{
			for(int j=0;j<colcount;j++) 
			{
				logindata[i-1][j]=XLUtils.getCellData(path, "sheet1", i, j);
				
			}
		}
		return logindata;
		
	}

}
