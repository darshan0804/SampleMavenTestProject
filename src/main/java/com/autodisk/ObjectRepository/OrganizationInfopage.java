package com.autodisk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfopage {

	
	public OrganizationInfopage(WebDriver driver) {                             //Rule 5
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement orgSucessfullMsgText;

	public WebElement getOrgSucessfullMsgText() {
		return orgSucessfullMsgText;
	}
}
