package com.autodisk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author Darshan
 *
 */
public class Organizationpage {

	public Organizationpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement createorg;

	public WebElement getCreateorg() {
		return createorg;
	}
	
	
}
