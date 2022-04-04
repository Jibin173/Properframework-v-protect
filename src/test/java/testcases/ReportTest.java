package testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ferno.qa.base.TestBase;
import com.ferno.qa.pages.Adminpage;
import com.ferno.qa.pages.ConfiguringSOP;
import com.ferno.qa.pages.Fernohomepage;
import com.ferno.qa.pages.LoginPage;
import com.ferno.qa.pages.Report;

public class ReportTest extends TestBase{

	
	Adminpage admin;
	LoginPage login;
	Fernohomepage ferno;
	ConfiguringSOP con;
	Report re;
	public ReportTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		System.out.println("*****Initialising the precondition*********");
		initialization();
		admin= new Adminpage();	
		login=new LoginPage();
	    ferno=new Fernohomepage();
	    re=new Report();
	    con=new ConfiguringSOP();
		login.login(prop.getProperty("username"), prop.getProperty("password"));
		WebDriver driver;
		Logger log = Logger.getLogger(ConfiguringSOPTest.class);
		System.out.println("*****the precondition sucessfully completed*********");
	}
	
	@Test
	public void DVRreport_tc() {
		String url1=prop.getProperty("url");
		re.Availibility_Report(url1);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
