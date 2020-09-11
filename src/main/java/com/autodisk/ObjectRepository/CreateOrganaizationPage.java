package com.autodisk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.autodisk.genericutility.WebDriverUtils;

/**
 * 
 * @author Darshan
 *
 */
public class CreateOrganaizationPage extends WebDriverUtils {

	public CreateOrganaizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "accountname")
	private WebElement orgNamEdt;
	
	
	@FindBy(name = "industry")
	private WebElement industie;
	
	@FindBy(name = "accounttype")
	private WebElement accountp;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	/**
	 * 
	 * @param orgName
	 */
	public void createOrg(String orgName)
	{
	
		orgNamEdt.sendKeys(orgName);
		savebtn.click();
	}
	
	public void createOrg(String orgName, String orgtype , String orgIndusties)
	{
		orgNamEdt.sendKeys(orgName);
		
		select(industie, orgIndusties);
		select(accountp, orgtype);
		savebtn.click();
		
	}

	
	
}
