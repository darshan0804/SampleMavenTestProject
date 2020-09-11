package com.autodisk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.autodisk.genericutility.WebDriverUtils;

public class Homepage extends WebDriverUtils {

	WebDriver driver;
	
	public Homepage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Contacts")
	private WebElement contactlink;
	
	
	@FindBy(linkText = "Organizations")
	private WebElement orglink;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campiontlink;
	
	@FindBy(linkText = "More")
	private WebElement morelink;
	
	
	@FindBy(linkText = " Administrator")
	private WebElement admistratorlink;
	
	@FindBy(linkText = " Sign Out")
	private WebElement signoutlink;
	
	@FindBy(linkText="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	public WebElement getAdminImg() {
		return adminImg;
	}

	public WebElement getMorelink() {
		return morelink;
	}

	public WebElement getAdmistratorlink() {
		return admistratorlink;
	}

	public WebElement getSignoutlink() {
		return signoutlink;
	}

	public WebElement getContlink() {
		return contactlink;
	}

	public WebElement getOrglink() {
		return orglink;
	}

	public WebElement getCampiontlink() {
		return campiontlink;
	}

	public void navigateToCampainpage()
	
	{
		mouseToElement(driver, morelink);
		morelink.click();
		waitforElementVisibility(driver, campiontlink);
		campiontlink.click();
	}
	
}
