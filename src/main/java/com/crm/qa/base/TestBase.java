package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase 
{
	public  static WebDriver driver;
	public  static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
		public TestBase() 
		{
			try {
			 prop= new Properties();
			FileInputStream fis = new FileInputStream("C:/EclipseWorkSpace/FreeCrmTest/src/main/java/com/crm/qa/config/config.properties");
			prop.load(fis);
			}
			catch (FileNotFoundException fileNotFoundException) 
			{
				System.out.println(fileNotFoundException);
			}
			
			catch (IOException ioexception)
			{
				System.out.println(ioexception);
			}
		}
		
		//@SuppressWarnings("deprecation")
		public static void initialization()
		{
			String browserName = prop.getProperty("browser");
			
			if (browserName.equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "C:\\EclipseWorkSpace\\Seleniumdownloads\\chrome\\chromedriver_win32\\chromedriver.exe");
			 	driver = new ChromeDriver();
			}
			else if (browserName.equals("FF"))
			{
				System.setProperty("webdriver.gecko.driver", "C:\\EclipseWorkSpace\\Seleniumdownloads\\geko\\gekodriver.exe");
			 	driver = new FirefoxDriver();
			}
			e_driver= new EventFiringWebDriver(driver);
			eventListener=new WebEventListener();
			e_driver.register(eventListener);
			driver=e_driver;
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT ,TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
			
			String urlName=prop.getProperty("url");
			driver.get(urlName);
		}

}
