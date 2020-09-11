package com.autodiskcrm.orgtest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.autodisk.ObjectRepository.CreateOrganaizationPage;
import com.autodisk.ObjectRepository.Homepage;
import com.autodisk.ObjectRepository.OrganizationInfopage;
import com.autodisk.ObjectRepository.Organizationpage;
import com.autodisk.genericutility.Baseclass;

public class CreateOrganizationTest extends Baseclass{

/**
 * 
 * @author Darshan
 * @throws Throwable 
 * 
 * 
 */

@Test(priority = 1)
public void createOrgeithTypeTest() throws Throwable
{	
	
	String orgName = excelLib.getExcelData("org", 1, 2)+ "_"+ wLib.getRamDomNum();
	String org_Type = excelLib.getExcelData("org", 1, 3);
	String org_industry = excelLib.getExcelData("org", 1, 4);
	
	/*step 3 : navigate to Org page*/
	Homepage hp = new Homepage(driver);
	hp.getOrglink().click();
	/*step 4 : navigate to create new Org page*/
	Organizationpage org = new Organizationpage(driver);
	org.getCreateorg().click();
	/*step 5 : create Org*/
	CreateOrganaizationPage createOrg = new CreateOrganaizationPage(driver);
	createOrg.createOrg(orgName, org_industry,org_Type );
	/*step 6 : verify the Org*/
	
	OrganizationInfopage orginfo = new OrganizationInfopage(driver);
	String actMasg = orginfo.getOrgSucessfullMsgText().getText();
	
	Assert.assertTrue(actMasg.contains(orgName));	
	/*step 7 : logout*/
}
	@Test(priority = 2)
	public void createOrg() throws Throwable
	{	 
		/* read test script specific data*/
		String orgName = excelLib.getExcelData("org", 4, 2)+ "_"+ wLib.getRamDomNum();
		/*step 3 : navigate to Org page*/
		Homepage hp = new Homepage(driver);
		hp.getOrglink().click();
		/*step 4 : navigate to create new Org page*/
		Organizationpage org = new Organizationpage(driver);
		org.getCreateorg().click();
		/*step 5 : create Org*/
		CreateOrganaizationPage createOrg = new CreateOrganaizationPage(driver);
		createOrg.createOrg(orgName);
		/*step 6 : verify the Org*/
		OrganizationInfopage orginfo = new OrganizationInfopage(driver);
		String actMasg = orginfo.getOrgSucessfullMsgText().getText();
		
		Assert.assertTrue(actMasg.contains(orgName));	
		/*step 7 : logout*/
	
	
	
}



}
