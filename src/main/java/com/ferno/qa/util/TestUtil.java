package com.ferno.qa.util;



import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.ferno.qa.base.TestBase;
import java.lang.reflect.Method;


public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	static String pageLoadStatus = null;
//	public static String TESTDATA_SHEET_PATH = "C:\\Users\\josej\\Downloads\\Testdata.xlsx";

	static Workbook book;
	static Sheet sheet;
	static JavascriptExecutor js;
	Actions actionObject;
	static WebDriverWait wait;
	
	public TestUtil(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 60);
		js = (JavascriptExecutor) driver;
		actionObject = new Actions(driver);
	}
		public void implicitwait() {
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		}
		public static Object[][] getTestData(String sheetName) {

		FileInputStream file=null;
		try {
		file=new FileInputStream("C:\\Users\\josej\\OneDrive\\Desktop\\workspace\\Vuelogix.Framework\\src\\main\\java\\com\\ferno\\qa\\testdata\\TestData.xlsx");


		//THis statement will point your excelsheet and also opens your excelsheet

		}catch(FileNotFoundException e) {
		e.printStackTrace();
		System.out.println("either location has changed or the file is no more");
		}



		try {
		book=WorkbookFactory.create(file);
		}catch(InvalidFormatException e) {
		e.printStackTrace();
		}catch(IOException e) {
		e.printStackTrace();
		}
		sheet=book.getSheet(sheetName);
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		//   this statement will create a row and column

		//Object[][]data=new Object[3][2];
		// data[1][1].getdata();




		for(int i=0;i<sheet.getLastRowNum();i++) {
		for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
		data[i][k]=sheet.getRow(i+1).getCell(k).toString();
		}
		}

		return data;




		}
		public static void clickon(WebElement element) {
	       driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);	
			element.click();
			System.out.println("WebElement"+" "+element+"Was clicked");
		}
		public static void acceptvalue(WebElement element,String value) {
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
			element.sendKeys(value);
			System.out.println("WebElement"+" "+element+"has value"+value);
		}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

	public static void runTimeInfo(String messageType, String message) throws InterruptedException {
		js = (JavascriptExecutor) driver;
		// Check for jQuery on the page, add it if need be
		js.executeScript("if (!window.jQuery) {"
				+ "var jquery = document.createElement('script'); jquery.type = 'text/javascript';"
				+ "jquery.src = 'https://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js';"
				+ "document.getElementsByTagName('head')[0].appendChild(jquery);" + "}");
		Thread.sleep(5000);

		// Use jQuery to add jquery-growl to the page
		js.executeScript("$.getScript('https://the-internet.herokuapp.com/js/vendor/jquery.growl.js')");

		// Use jQuery to add jquery-growl styles to the page
		js.executeScript("$('head').append('<link rel=\"stylesheet\" "
				+ "href=\"https://the-internet.herokuapp.com/css/jquery.growl.css\" " + "type=\"text/css\" />');");
		Thread.sleep(5000);

		// jquery-growl w/ no frills
		js.executeScript("$.growl({ title: 'GET', message: '/' });");
//'"+color+"'"
		if (messageType.equals("error")) {
			js.executeScript("$.growl.error({ title: 'ERROR', message: '"+message+"' });");
		}else if(messageType.equals("info")){
			js.executeScript("$.growl.notice({ title: 'Notice', message: 'your notice message goes here' });");
		}else if(messageType.equals("warning")){
			js.executeScript("$.growl.warning({ title: 'Warning!', message: 'your warning message goes here' });");
		}else
			System.out.println("no error message");
		// jquery-growl w/ colorized output
//		js.executeScript("$.growl.error({ title: 'ERROR', message: 'your error message goes here' });");
//		js.executeScript("$.growl.notice({ title: 'Notice', message: 'your notice message goes here' });");
//		js.executeScript("$.growl.warning({ title: 'Warning!', message: 'your warning message goes here' });");
		Thread.sleep(5000);
	}

	
	
	public static Date timedate(){
		
		Calendar calendar = Calendar.getInstance();
		Date currentDateTime = calendar.getTime();
		
		System.out.println(currentDateTime);
		return currentDateTime;
		
	}
	
	
	
	public static String geturl(String url) {
		
		String[] a=url.split(":4201");
		int len=a.length;
		
		String url1=a[0];
		
		return url1;
		
	}
	
	public void javascript_sendKeys(WebElement inputFiel) {
		WebElement element=inputFiel;
		WebElement inputField =  element;
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		String value1="Hello";
		js.executeScript("arguments[0].value='valu';", inputField);	
	}
	
	public void launch_URL(String url) {
		waitForPageToLoad();
		driver.get(url);
		
	}
	public static void refresh_Page() {
		driver.navigate().refresh();
	}
	public void verify_Url(String expected_Url) {
		Assert.assertEquals(expected_Url, driver.getCurrentUrl());
	}
	public void verify_Title(String expected_Title) {
		
		Assert.assertEquals(expected_Title, driver.getTitle(),"Title doesnot match");
	}
	
	public void navigate_to_previous_Page() {
		driver.navigate().back();
	}
	public void navigate_to_next_Page() {
		driver.navigate().forward();
	}
	
	public void scroll_at_the_bottom_of_the_page() {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	public void scroll_at_the_bottom_of_the_page_to_up() {
		js.executeScript("window.scrollTo(0, document.body.scrollTop)");
	}
	
	public void press_DOWN_Arrow_key() throws Throwable {
		actionObject.sendKeys(Keys.ARROW_DOWN).build().perform();
		actionObject.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(1000);
	}
	public void hover_mouse(WebElement element_Location) throws Throwable {
		wait.until(ExpectedConditions.visibilityOf(element_Location));
		actionObject.moveToElement(element_Location).build().perform();
		Thread.sleep(1000);
	}
	
	public void hover_mouse_and_click(WebElement element_Location) throws Throwable {
		wait.until(ExpectedConditions.visibilityOf(element_Location));
		actionObject.moveToElement(element_Location).click().build().perform();
		Thread.sleep(1000);
	}
	
	public void drag_and_drop(WebElement source_Location, WebElement destination_Location) throws Throwable {
		wait.until(ExpectedConditions.visibilityOf(source_Location));
		wait.until(ExpectedConditions.visibilityOf(destination_Location));
		actionObject.dragAndDrop(source_Location, destination_Location).build().perform();
		Thread.sleep(2000);
	}

	public void slide_horizontally(WebElement slider_Location, WebElement slider_x_axis_Location) throws Throwable {
		wait.until(ExpectedConditions.visibilityOf(slider_Location));
		Integer slider_width_half = slider_x_axis_Location.getSize().width / 2;

		actionObject.dragAndDropBy(slider_Location, slider_width_half, 0).build().perform();
		Thread.sleep(2000);
	}
	
	public void right_click(WebElement element_Location) throws Throwable {
		wait.until(ExpectedConditions.visibilityOf(element_Location));

		actionObject.contextClick(element_Location).build().perform();
		Thread.sleep(1000);
	}
	public void is_Displayed(WebElement element_Location) {
		Assert.assertTrue(element_Location.isDisplayed());
	}

	/******
	 * Method to fetch the value of the element
	 * 
	 * @return
	 **** @Creator Avik Guha
	 **/
	public String get_Value(WebElement element_Location) {
		wait.until(ExpectedConditions.visibilityOf(element_Location));
		String x = element_Location.getText();
		System.out.println("The value returned is: " + x);
		return x;
	}
	public void open_link_in_separate_tab(WebElement link_location) throws Throwable {
		String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
		link_location.sendKeys(clickOnLinkTab);
		Thread.sleep(3000);

	}
	/******
	 * Method to get Attribute Value using index
	 * 
	 * @return String
	 **** @Creator Avik Guha
	 **/
	public String get_Value_using_index(WebElement parent_element_Location, List<WebElement> list, Integer index,
			String expected_value) {
		wait.until(ExpectedConditions.visibilityOf(parent_element_Location));
		String actual_value = list.get(index).getAttribute("Value");
		return actual_value;
	}
	
	
	
	

	public String fetch_data_from_excel(String excel_name, int sheet_index, int row_index, int column_index) throws IOException {
		

			String folderPath = "C:\\Users\\josej\\OneDrive\\Desktop\\workspace\\Vuelogix.Framework\\src\\main\\java\\com\\ferno\\qa\\testdata"; // keep excel in this folder path
			String element_Image = folderPath + "\\"+excel_name;

			File file = new File(element_Image);
			FileInputStream fis = new FileInputStream(file); // this contains raw data from the excel
			XSSFWorkbook workbook = new XSSFWorkbook(fis); // creating workbook
			XSSFSheet sheet = workbook.getSheetAt(sheet_index); // getting the sheet from workbook

			String cellValue = sheet.getRow(row_index).getCell(column_index).getStringCellValue(); // fetching data from the
			System.out.println(sheet.getLastRowNum());																	// sheet
			return cellValue;
	}
	
	public static String[][] fetchdata_from_excel(String excelname,int sheet_index) throws IOException{
		String folderPath = "C:\\Users\\josej\\OneDrive\\Desktop\\workspace\\Vuelogix.Framework\\src\\main\\java\\com\\ferno\\qa\\testdata"; // keep excel in this folder path
		String element_Image = folderPath + "\\"+excelname;

		File file = new File(element_Image);
		FileInputStream fis = new FileInputStream(file); // this contains raw data from the excel
		XSSFWorkbook workbook = new XSSFWorkbook(fis); // creating workbook
		XSSFSheet sheet = workbook.getSheetAt(sheet_index); // getting the sheet from workbook
		int row=sheet.getLastRowNum();
		String[][] data=new String[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<row;i++) {
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
				data[i][k]=sheet.getRow(i+1).getCell(k).getStringCellValue();
				
			}
		}
		
		return data;
		
		
	}
	public void accept_alert() {
		driver.switchTo().alert().accept();
	
	
	
	
	}
	
	public void verify_text_in_alert(String expected_text) {
		String actual_text = driver.switchTo().alert().getText();
		Assert.assertEquals(expected_text, actual_text);
	}
	public static void waitForPageLoad() {

		do {

		js = (JavascriptExecutor) driver;

		pageLoadStatus = (String)js.executeScript("return document.readyState");

		} while ( !pageLoadStatus.equals("complete") );

		System.out.println("Page Loaded.");

		}
	public void test_maximum_Length(WebElement element_Location, Integer expected_Length) {
		wait.until(ExpectedConditions.visibilityOf(element_Location));
		Assert.assertEquals(expected_Length, element_Location.getAttribute("maxlength"));
	}
	
	
	public void explicitwait_Visibilityofelement(WebElement e) {
		WebDriverWait wait=new WebDriverWait(driver,180);
		System.out.println("Initialized wait variable");
		wait.until(ExpectedConditions.visibilityOf(e));
		System.out.println("Explicit wait was triggered and waited until the given condtion was satified");
		
	}
	
	public void explicitwait_Elementtobeclickable(WebElement e) {
		WebDriverWait wait=new WebDriverWait(driver,180);
		wait.until(ExpectedConditions.elementToBeClickable(e));
		System.out.println("Explicit wait was triggered and waited until the given condtion was satified");
		
	}
	
	public void explicitlywait_ExpectedURL(String expectedurl) {
		
		WebDriverWait wait=new WebDriverWait(driver,180);
		wait.until(ExpectedConditions.urlToBe(expectedurl));
		System.out.println("Explicit wait was triggered and waited until the given condtion was satified");
	}
	
	
	
	
}