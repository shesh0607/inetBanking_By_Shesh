package com.inetbanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	WebDriver driver;
	
	public AddCustomerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="/html/body/div[3]/div/ul/li[2]/a")
	WebElement lnkAddNewCustomer;
	
	
	
	@FindBy(name="name")
	WebElement txtCustomerName;
	
	@FindBy(how=How.NAME,using="rad1")
	WebElement rdGender;
	
	@FindBy(how=How.ID,using="dob")
	WebElement txtdob;
	
	@FindBy(how=How.NAME,using="addr")
	WebElement txtaddress;
	
	@FindBy(how=How.NAME,using="city")
	WebElement txtcity;
	
	@FindBy(how=How.NAME,using="state")
	WebElement txtstate;	
	
	@FindBy(how=How.NAME,using="pinno")
	WebElement txtpinno;
	
	@FindBy(how=How.NAME,using="telephoneno")
	WebElement txttelephoneno;
	
	@FindBy(how=How.NAME,using="emailid")
	WebElement txtemailid;
	
	@FindBy(how=How.NAME,using="password")
	WebElement txtpassword;
	
	@FindBy(how=How.NAME,using="sub")
	WebElement btnSubmit;

	//action method
	
	public void clickAddNewCustomer() {
		lnkAddNewCustomer.click();
	}
	
	public void custName(String cname) {
		txtCustomerName.sendKeys(cname);
	}
	
	public void custGender(String cgender) {
		rdGender.click();
	}
	
//	public void custdob(String mm,String dd,String yyyy) {
//		txtdob.sendKeys("mm");
//		txtdob.sendKeys("dd");
//		txtdob.sendKeys("yy");
//	}
	
	public void custdob(String cdob) {
		txtdob.sendKeys(String.valueOf(cdob));
	}
	public void custaddress(String caddress) {
		txtaddress.sendKeys(caddress);
	}
	
	public void custcity(String ccity) {
		txtcity.sendKeys(ccity);
	}
	
	public void custstate(String cstate) {
		txtstate.sendKeys(cstate);
	}
	
	public void custpinno(String cpinno) {
		txtpinno.sendKeys(String.valueOf(cpinno));
	}
	
	public void custtelephoneno(String ctelephoneno) {
		txttelephoneno.sendKeys(ctelephoneno);
	}
	
	public void custemailid(String cemailid) {
		txtemailid.sendKeys(cemailid);
	}
	
	public void custpassword(String cpassword) {
		txtpassword.sendKeys(cpassword);
	}
	
	public void custsubmit() {
		btnSubmit.click();
	}
	
	
	
	
	
	
	
	
}
