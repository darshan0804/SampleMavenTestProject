package com.autodisk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.autodisk.genericutility.FileLib;

public class Loginpage {	//Rule_1
	
	WebDriver driver;
	@FindBy(name = "user_name")			//Rule--2
	private WebElement Un;
	
	@FindBy(name = "user_password")
	private WebElement Ps;
	
	@FindBy(id = "submitButton")
	private WebElement lnBtn;

	public WebElement getUn() {				//Rile---3
		return Un;
	}

	public WebElement getPs() {
		return Ps;
	}

	public WebElement getLnBtn() {
		return lnBtn;
	}
	
	public void loginToaApp(String username, String password)
	{
		Un.sendKeys(username);
		Ps.sendKeys(password);
		lnBtn.click();	
	}
	
	public void loginToaApp() throws Throwable
	{
		FileLib fis = new FileLib();
		Un.sendKeys(fis.getPropertieFileData("username"));
		Ps.sendKeys(fis.getPropertieFileData("password"));
		lnBtn.click();	
	}

	
	public Loginpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}

}

