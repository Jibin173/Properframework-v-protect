package testcases;


import static org.testng.Assert.assertEquals;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ferno.qa.util.TestUtil;

import com.ferno.qa.base.TestBase;
import com.ferno.qa.pages.LoginPage;
import java.lang.reflect.Method;
public class LoginTest extends TestBase{
	LoginPage loginPage;
	SoftAssert softAssertion= new SoftAssert();
     TestUtil util;
	 TestBase base; 
	public LoginTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(Method name){
		initialization();
		loginPage = new LoginPage(); 
		base=new TestBase();
		util=new TestUtil(driver);
		Logger Log = Logger.getLogger(LoginTest.class);
		Log.info("*****Initialising the precondition*********");
		System.out.println("*****Initialising the precondition*********");
		TestUtil.waitForPageLoad();
		System.out.println("You are Running testcase"+name);
	}
	
	
	
	@Test(enabled=true,priority=2)
	public void loginPageTitleTest(){
		System.out.println("1. Test Case for verifiying the loginpage Title");
		String expected="Login";
		System.out.println("Before calling the testmethod");
		util.verify_Title(expected);
		System.out.println("After calling the testmethod");
	}
	
	@Test()
	public void loginwithvalidcred() {
		System.out.println("Test case for verifiying user can login the application with valid credentials");
		System.out.println("Before calling the testmethod");
		loginPage.login();
		System.out.println("After calling the testmethod");
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException{
		
		Thread.sleep(5000);
		driver.close();
	}
	
	
	
	

}
