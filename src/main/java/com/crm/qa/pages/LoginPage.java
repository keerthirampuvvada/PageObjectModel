package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;;

public class LoginPage extends TestBase
{
	
	@FindBy(xpath ="//span[contains(text(),'Log In')]")
	 WebElement loginLandingPageButton;
	
	@FindBy(xpath ="//input[@name='email']")
	 WebElement username;
	
	@FindBy(xpath ="//input[@name='password']")
	 WebElement password;
	
	@FindBy(xpath = "//div[@class='ui fluid large blue submit button']")
	WebElement loginButton;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String  getTitleOfPage() {
		return driver.getTitle();
		
	}
	public void loginLandingPageButton()
	{
		loginLandingPageButton.click();
		
	}
	
	//public void login(String un , String pwd) throws InterruptedException
	public HomePage login() throws InterruptedException 
	{
		
		loginLandingPageButton.click();
		Thread.sleep(5000);
		username.sendKeys(prop.getProperty("username"));
		password.sendKeys(prop.getProperty("password"));
		loginButton.click();
		
		return new HomePage();
	}
	
}
