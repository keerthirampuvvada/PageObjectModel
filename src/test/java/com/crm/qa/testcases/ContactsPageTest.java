package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase
{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	String sheetName ="Contacts";
	public ContactsPageTest ()
	{
		super();
	}
	
	
	@BeforeMethod
	
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage(); 
		contactsPage = new ContactsPage();
	}
	
	@Test(enabled=false)
	public void clickContactsLinkTest() throws InterruptedException
	{   loginPage.login();
		//contactsPage.clickContactLink();
		//.createButton();
		contactsPage.actionsContacts();
		contactsPage.enterFirstName("");
		contactsPage.enterLastName("");
		contactsPage.saveName();
		Thread.sleep(2000);
		System.out.println("contacts saved");
	}
	
	
	@DataProvider
	public  Object[][] getTestData() throws Exception 
	{
		Object[][] data =TestUtil.getTestData(sheetName);
		return data;
		
	}
	@Test(priority=1,dataProvider="getTestData")
	public void createNewContact(String firstName, String lastName) throws InterruptedException
	{
		loginPage.login();
		contactsPage.actionsContacts();
		//contactsPage.createNewContact(firstName, lastName);
		contactsPage.createNewContact(firstName, lastName);
	}
	
	
@AfterMethod
	
	public void tearDown() 
	{
		
		driver.quit();
	}
	

}
