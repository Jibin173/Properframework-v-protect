package testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ferno.qa.base.TestBase;
import com.ferno.qa.pages.Fernohomepage;
import com.ferno.qa.pages.LoginPage;
import com.ferno.qa.util.TestUtil;

public class Homepagetest extends TestBase {
	Fernohomepage h_page;
	LoginPage login;
	TestUtil t;
	SoftAssert soft=new SoftAssert();
	
	public Homepagetest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		System.out.println("*****Initialising the precondition*********");
		initialization();
		h_page = new Fernohomepage();	
		 login=new LoginPage();
		 System.out.println("*****Initialising the pages*********");
		login.login(prop.getProperty("username"), prop.getProperty("password"));
		System.out.println("*****the precondition sucessfully completed*********");
	}
	
	
	
	
	@Test()
	public void Available_OPtions() throws Throwable {
		System.out.println("To verify all the option's available for the user to interact in homepage");
		boolean b=h_page.option_availibilty();
		soft.assertEquals(b, true);
		//TestUtil.refresh_Page();
		Thread.sleep(5000);
		//Assert.assertEquals(b, true);
		h_page.logout();
		System.out.println("Testcase executed sucessfully");
	
	}
	
	@Test(enabled=true)
	public void logoprsent() {
		System.out.println("To verify that the vuelogix logo is present");
		boolean b=h_page.logoverification();
		soft.assertEquals(b, true);
	//	Assert.assertEquals(b, true);
		System.out.println("TestCase Executed");
		//h_page.logout();
	}
	
	
	@AfterMethod
	public void tearDown(){
		//driver.quit();
	}
	

}
