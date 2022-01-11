package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest  extends TestBase
{
	
	LoginPage loginPage;
	HomePage homePage;
	public HomePageTest ()
	{
		super();
	}
	
	
	@BeforeMethod
	
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
	}

@Test(priority=1)
	
	public void homePageLoginTest() throws InterruptedException 
	{
		loginPage.login();
		String str =homePage.getUserName();
		Assert.assertEquals(str, "Keerthi Puvvada");
		System.out.println(" Inside home page : "+str);
	
	}

		@Test(priority=2)
		public void homePageContactsTest() throws InterruptedException
		
		{
			loginPage.login();
			String str =homePage.contacts();
			Assert.assertEquals(str, "Contacts");
			System.out.println(" Inside home page contacts: "+str);
		}
		
		@Test(priority=3)
		public void homePageCalendarTest() throws InterruptedException
		
		{
			loginPage.login();
			String str =homePage.calendar();
			Assert.assertEquals(str, "Calendar");
			System.out.println(" Inside home page Calendar: "+str);
		}

@AfterMethod

public void tearDown() 
{
	
	driver.quit();
}
	
}
