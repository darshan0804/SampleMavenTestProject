package com.autodiskcrm.campaintest;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.autodisk.ObjectRepository.Homepage;
import com.autodisk.genericutility.Baseclass;

public class CampainTest extends Baseclass {

	
	@Test
	public void createCamp() throws Throwable
	{
		String campaignName = excelLib.getExcelData("Campaign", 1, 2);
		
		/*navigate to campain*/
		Homepage home = new Homepage(driver);
		
		home.navigateToCampainpage();
		
	
	
	}
	
	
}
