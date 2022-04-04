package testcases;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ferno.qa.base.TestBase;
import com.ferno.qa.pages.Adminpage;
import com.ferno.qa.pages.Dashboard;
import com.ferno.qa.pages.Fernohomepage;
import com.ferno.qa.pages.LoginPage;
import com.ferno.qa.pages.Matrixpage;

public class DashboardTest extends TestBase {
	Adminpage admin;
	LoginPage login;
	Fernohomepage ferno;
	Matrixpage matrix;
	Dashboard dash;
	WebDriverWait wait;
	
	public DashboardTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
		 dash =new Dashboard();
		 matrix=new Matrixpage();
		admin= new Adminpage();	
		 login=new LoginPage();
		 ferno=new Fernohomepage();
		
		login.login(prop.getProperty("username"), prop.getProperty("password"));
		WebDriver driver;
		System.out.println("Precodition installed");
		Logger log = Logger.getLogger(DashboardTest.class);
		
	
	}
	
     @Test
      public void dashboard() throws Throwable {
    	
    	 System.out.println("To verify whether alarm dashboard");
    		String url1=prop.getProperty("url");
    		dash.dashboard(url1);

    	
    	
}
}