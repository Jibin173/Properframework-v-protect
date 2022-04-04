package testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ferno.qa.base.TestBase;
import com.ferno.qa.pages.Adminpage;
import com.ferno.qa.pages.Fernohomepage;
import com.ferno.qa.pages.LoginPage;
import com.ferno.qa.pages.*;

public class Matrixtest extends TestBase{
	
	Adminpage admin;
	LoginPage login;
	Fernohomepage ferno;
	Matrixpage matrix;
	public Matrixtest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
		 matrix=new Matrixpage();
		admin= new Adminpage();	
		 login=new LoginPage();
		 ferno=new Fernohomepage();
		login.login(prop.getProperty("username"), prop.getProperty("password"));
		WebDriver driver;
		Logger log = Logger.getLogger(Matrixtest.class);
	}
	
	
	@Test
	public void camer() throws Throwable {
		System.out.println("Tesctase MAtrix");
		String url1=prop.getProperty("url");
		
		matrix.camera(url1);
//		ferno.logout();
	}
	@AfterMethod
	public void tearDown(){
		System.out.println("All the testcases of MAtrixtest is been completed");
	//	driver.quit();
	}
	
}


