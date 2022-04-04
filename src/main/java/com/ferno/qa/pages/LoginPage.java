package com.ferno.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ferno.qa.base.TestBase;
import com.ferno.qa.util.TestUtil;

public class LoginPage extends TestBase{

	@FindBy(xpath="/html/body/div[2]/img")
	WebElement logo;
	TestUtil util;
	@FindBy(id="username")
	WebElement username_txtbox;
	@FindBy(id="password")
	WebElement password_textbox;
	@FindBy(xpath="/html/body/div[3]/form/div[4]/button")
	WebElement Login_submit;
	@FindBy(xpath="/html/body/div[5]/div/div/div[1]/h4")
	WebElement useralert;
	@FindBy(xpath="/html/body/div[5]/div/div/div[2]/div/button[1]")
	WebElement alert_confir;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
		 util=new TestUtil(driver);
	}
	
	public void validateLoginPageTitle() {
     util.explicitwait_Visibilityofelement(logo); 
	}
	public void username_visible() {
		util.is_Displayed(username_txtbox);
	}
	public void password_visible() {
		util.is_Displayed(password_textbox);
	}
	public void submit_login() {
		util.is_Displayed(Login_submit);
	}
	
	public void login() {
		username_visible();
		password_visible();
		submit_login();
		util.acceptvalue(username_txtbox, prop.getProperty("username"));
		util.acceptvalue(password_textbox, prop.getProperty("password"));
		util.clickon(Login_submit);
		boolean alertprest=useralert.isDisplayed();
		if(alertprest==true) {
			System.out.println("Alert needs to be handles");
			System.out.println("Alerts handling");
			util.clickon(alert_confir);
			System.out.println("After handling the alert");
		}else {
			System.out.println("No alert present");
			String url=prop.getProperty("url");
			
		}
		
	}
}
