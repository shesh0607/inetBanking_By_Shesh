package com.inetbanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(name="uid")
	private WebElement txtUserName;
	
	@FindBy(name="password")
	private WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	private WebElement btnLogin;
	
	@FindBy(how=How.ID,using="dismiss-button")
	WebElement btnDismiss;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	WebElement lnkLogout;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void setUserName(String uname) {
		txtUserName.sendKeys(uname);
	}

	public void setPassword(String psw){
		txtPassword.sendKeys( psw );
	}
	
	public void clickSubmit() {
		btnLogin.click();
	}
	
	public void clickDismiss() {
		btnDismiss.click();
	}
	
	public void clickLogout() {
		lnkLogout.click();
		
	}
	
	

}
