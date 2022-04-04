package testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ferno.qa.base.TestBase;
import com.ferno.qa.pages.Adminpage;
import com.ferno.qa.pages.Alarmpage;
import com.ferno.qa.pages.ConfiguringSOP;
import com.ferno.qa.pages.Fernohomepage;
import com.ferno.qa.pages.LoginPage;

public class Alarmtest extends TestBase {
	
	Adminpage admin;
	LoginPage login;
	Fernohomepage ferno;
	ConfiguringSOP con;
	Alarmpage alarm;
	
	public Alarmtest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		System.out.println("*****Initialising the precondition*********");
		initialization();
		admin= new Adminpage();	
		login=new LoginPage();
	    ferno=new Fernohomepage();
	    con=new ConfiguringSOP();
	    alarm=new Alarmpage();
		login.login(prop.getProperty("username"), prop.getProperty("password"));
		WebDriver driver;
		Logger log = Logger.getLogger(ConfiguringSOPTest.class);
		System.out.println("*****the precondition sucessfully completed*********");
	}
	
	
	
	@Test
	public void On_alarm_page() {
		System.out.println("Testcase: On AlarmPage");
		alarm.launchalrmpage();
		alarm.availablealrms();
		alarm.Ackalarms();
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}