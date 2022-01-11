package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath ="//span[contains(text(),'Keerthi Puvvada')]")
	WebElement userLoggedInName;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contacts ;
	
	@FindBy(xpath="//span[contains(text(),'Calendar')]")
	WebElement calendarLink ;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	public String  getUserName()
	{
		String loggedInName =userLoggedInName.getText();
		return loggedInName;
		
	}
	public String contacts()
	{
		String str = contacts.getText();
		return str;
	}
	
	public  String calendar() throws InterruptedException
	{
		String str = calendarLink.getText();
		return str;
		//calendarLink.click();
		//return new CalendarPage();
	}

}
