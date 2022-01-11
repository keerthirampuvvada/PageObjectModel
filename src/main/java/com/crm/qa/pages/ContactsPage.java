package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase
{
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath = "//div[@class='ui header item mb5 light-black']")
	WebElement contactsLable;
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement dealsLink;
	@FindBy(xpath ="//button[contains(text(),'Create')]")
	WebElement createButton;
	
	@FindBy(xpath ="//input[@name='first_name']")
	WebElement firstName;
	
	@FindBy(xpath ="//input[@name='last_name']")
	WebElement lastName;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement saveButton;
	
	// 
	@FindBy(xpath="//span[contains(text(),'Contacts')]//following::i[1]")
	WebElement plusCreate;
	
	
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickContactLink() throws InterruptedException
	{
		Thread.sleep(3000);
		System.out.println("Link is enableed or not ? : "+contactsLink.isEnabled());
		contactsLink.click();
		
		
	}
	
	public void actionsContacts() throws InterruptedException
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(contactsLink).build().perform();
		Thread.sleep(2000);
		plusCreate.click();
		
		
	}
	
	public void createContactButton()
	{
		createButton.click();
	}
	
	public void enterFirstName(String firstNameValue)
	{
		firstName.sendKeys(firstNameValue);
	}
	
	public void enterLastName(String lastNameValue)
	{
		lastName.sendKeys(lastNameValue);
	}
	
	public void saveName()
	{
		saveButton.click();
	}
	public String checkContactsDisplaying()
	{
		String str=contactsLable.getText();
		return str;
	}
	public String clickDealsLink()
	{
		dealsLink.click();
		String str=contactsLable.getText();
		return str;
	}
	
	public void createNewContact(String firstNameValue,String lastNameValue) throws InterruptedException
	{
		//createButton.click();
		firstName.sendKeys(firstNameValue);
		lastName.sendKeys(lastNameValue);
		
		saveButton.click();
		Thread.sleep(1000);
		/*
		 * String str =""; if (str.equals(driver.findElement(By.
		 * xpath("//span[contains(text(),'The field First Name is required')]")).getText
		 * ())) { System.out.println("Please enter first and last name"); } else {
		 * System.out.println("continue"); }
		 * 
		 */
		
		
	}

}
