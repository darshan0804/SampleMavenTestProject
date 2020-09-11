package com.autodisk.genericutility;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.autodisk.ObjectRepository.Loginpage;


/**
 * 
 * @author Drashan
 * 
 *
 */
public class Baseclass {

	
	/**
	 * libraries object creations
	 */
   public DatabaseLib dbLib = new DatabaseLib();
   public ExcelLib excelLib = new ExcelLib();
   public FileLib fLib = new FileLib();
   public WebDriverUtils wLib = new WebDriverUtils();
   public WebDriver driver = null;
	
   @BeforeSuite
	public void configBS() {
		/*connect to db*/
	   dbLib.connectToDB();
	}
	
	@BeforeClass
	public void configBC() throws Throwable{
		   String BROWSER = fLib.getPropertieFileData("browser");
		  
		 if(BROWSER.equals("chrome")) {
		   driver= new ChromeDriver();
		 } else if(BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		 }else if(BROWSER.equals("ie")) {
				driver = new InternetExplorerDriver();
	     }else {
	    	 driver = new FirefoxDriver();
	     }
		 
	}
	
/*	@Parameters("browser")
	@BeforeTest
	public void configBT(String BROWSER) throws Throwable{
		  
		 if(BROWSER.equals("chrome")) {
		   driver= new ChromeDriver();
		 } else if(BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		 }else if(BROWSER.equals("ie")) {
				driver = new InternetExplorerDriver();
	     }else {
	    	 driver = new FirefoxDriver();
	     }
		 
	}*/
	
	@BeforeMethod
	public void configBM() throws Throwable {
		/* read data from property File */
		String USERNAME = fLib.getPropertieFileData("username");
		String PASSWORD = fLib.getPropertieFileData("password");
		String URL = fLib.getPropertieFileData("url");
	
		/*login to app*/
		wLib.waitforPageLoad(driver);
		driver.get(URL);
		
		/*step 2 : login*/
	     Loginpage lp = new Loginpage(driver);
	     lp.loginToaApp(USERNAME, PASSWORD);
	}
	
	@AfterMethod
	public void configAm() {

		
		/*step 1 : logout*/
		WebElement wb = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
        wLib.mouseToElement(driver, wb);
		driver.findElement(By.linkText("Sign Out")).click();
	}
	
	@AfterClass
	public void configAC(){
		/*close the browser*/
		driver.close();
	}
	
	@AfterSuite
	public void confiAs() {
		/*dissconnect to db*/
		dbLib.dissconnectToDb();
	}
	
	
	
	
}
