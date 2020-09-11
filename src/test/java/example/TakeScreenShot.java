package example;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class TakeScreenShot {

	
	
	
		@Test

			public void createCampTest(WebDriver driver) throws Throwable
			{
			
			EventFiringWebDriver Devent = new EventFiringWebDriver(driver);
			
					 File srcFile = Devent.getScreenshotAs(OutputType.FILE);
					 FileUtils.copyFile(srcFile, new File("./screnshoots/test.png"));
			}
}
