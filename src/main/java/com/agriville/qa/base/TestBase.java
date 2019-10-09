package com.agriville.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase
{
	public static WebDriver driver;
	public static Properties prop;
	public TestBase()
	{
		try
		{
			prop = new Properties();
			FileInputStream ip=new FileInputStream("E:\\Script Agriville\\AgrivilleTest\\src\\main\\java\\com\\agriville\\qa\\config\\config.properties");
			prop.load(ip);
			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void intialization()
	{
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			
			System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Chrome_Driver_win32\\chromedriver.exe");
//			ChromeOptions options = new ChromeOptions();
//			options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
			

			
			driver=new ChromeDriver();
		}
			else if(browserName.equals("MFF"))
			{
				
				System.setProperty("webdriver.gecko.driver", "E:\\Script AgCareers\\Gecko Driver\\Firefox_GeckoWin32");
				driver=new FirefoxDriver();
			}
		
	else if(browserName.equals("IE"))
	{
		System.setProperty("webdriver.ie.driver","E:\\Script AgCareers\\Gecko Driver\\IEDriverServer_Win32_3.12.0" );
		driver = new InternetExplorerDriver();
	}
	
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	
	
	



	}

}