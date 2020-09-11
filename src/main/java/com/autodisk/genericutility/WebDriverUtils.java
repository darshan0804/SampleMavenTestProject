
package com.autodisk.genericutility;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author Darshan
 *
 */
public class WebDriverUtils {
	
	/**
	 * wait for all the element to load DOM doccument
	 * @param driver
	 */
	public void waitforPageLoad(WebDriver driver )
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	
	/**
	 * wait for visibality of  specific  Element in GUI
	 * @param driver
	 */	
		public void waitforElementVisibility(WebDriver driver, WebElement element)
		{
			WebDriverWait wait = new WebDriverWait(driver, 20);
			
				wait.until(ExpectedConditions.visibilityOf(element));	
			
		}
		/**
		 * wait for page title to aviable
		 * @param driver
		 */	
			public void waitforPagetitleVisibility(WebDriver driver, String pagetitle)
			{
				WebDriverWait wait = new WebDriverWait(driver, 20);
				
					wait.until(ExpectedConditions.titleContains(pagetitle));	
				
			}
			/**
			 * wait for  any element
			 * @param driver
			 * @throws InterruptedException 
			 */
			public boolean waitForAnyElement(WebDriver driver, WebElement expElement) throws InterruptedException {
				boolean flag = false;
				int count =0;
				while(count < 30) {
				      try {
				    	  expElement.isDisplayed();
				    	  flag=true;
				    	  break;
				      }catch(Throwable t) {
				    	  count++;
				    	  Thread.sleep(500);
				      }
				}
				return flag;
			}
			
			/**
			 * wait and click an element
			 * @param driver
			 * @throws InterruptedException 
			 */
			public boolean waitAndClickElement(WebDriver driver, WebElement expElement) throws InterruptedException {
				boolean flag = false;
				int count =0;
				while(count < 30) {
				      try {
				    	  expElement.click();
				    	  flag=true;
				    	  break;
				      }catch(Throwable t) {
				    	  count++;
				    	  Thread.sleep(1000);
				      }
				}
				return flag;
			}
			
			/**
			 * select the value from the dropdown based on the visible text
			 * @param dropdown element
			 * @param text
			 */
			public void select(WebElement dropdownelement, String text)
		
			{
				Select sel = new Select(dropdownelement);
				sel.selectByVisibleText(text);
				
			}
			/**
			 * select the value from the dropdown based on the index
			 * @param dropdown element
			 * @param num
			 */
			public void select(WebElement dropdownelement, int num)
			
			{
				Select sel = new Select(dropdownelement);
				sel.selectByIndex(num);
				
			}
			/**
			 * switch to new window
			 * @param driver
			 * @param pagetitle
			 */
			public void switchtonewTab(WebDriver driver, String pagetitle)
			{
				Set<String> set = driver.getWindowHandles();
				Iterator<String> it= set.iterator();
				while(it.hasNext()) {
					String winId = it.next();
					driver.switchTo().window(winId);
					String currentpagetitle = driver.getTitle();
					if(currentpagetitle.contains(pagetitle))
					{
						break;
					}
					
				}
				
			}
			/**
			 * alert pop up  handling
			 */
			public void alertOk(WebDriver driver)
			{
				driver.switchTo().alert().accept();
			}
			public void alertCancel(WebDriver driver)
			{
				driver.switchTo().alert().dismiss();
			}
	/**
	 * Actions Class element handling		
	 * @param driver
	 * @param element
	 */
			public void mouseToElement(WebDriver driver, WebElement element )
			{
				
				Actions act = new Actions(driver);
				act.moveToElement(element).perform();
			
			}
			public void doubleClick(WebDriver driver, WebElement element )
			{
				
				Actions act = new Actions(driver);
				act.doubleClick(element).perform();
			
			}
			public void rightClick(WebDriver driver, WebElement element )
			{
				
				Actions act = new Actions(driver);
				act.contextClick(element).perform();
			
			}
			public int getRamDomNum() {
		 		Random ranObj = new Random();
		 		int randata =ranObj.nextInt(1000);
				return randata;
		     }
		     
		     public void switchToFrame(WebDriver drver , String att) {
		           drver.switchTo().frame(att);
		     }
		     public void switchToFrame(WebDriver drver , int index) {
		         drver.switchTo().frame(index);
		   }
		     public void switchToFrame(WebDriver drver , WebElement elemnent) {
		         drver.switchTo().frame(elemnent);
		   }
		     
		     public void executeJavaScript(WebDriver driver  , String javaScript) {
		    	 JavascriptExecutor js = (JavascriptExecutor)driver;
		    	 js.executeScript(javaScript);
		     }
			
}
