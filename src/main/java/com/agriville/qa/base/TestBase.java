package com.agriville.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
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

			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--disable-notifications");
//			options.addArguments("disable-infobars");
			DesiredCapabilities DCapabilities = DesiredCapabilities.chrome();     
			DCapabilities.setCapability (CapabilityType.ACCEPT_INSECURE_CERTS, true);
			options.merge(DCapabilities);
			System.setProperty("webdriver.chrome.driver", "E:\\Gecko Drivers\\Chrome_Driver_win32\\chromedriver.exe");
			driver=new ChromeDriver(options);
			
		}
			else if(browserName.equals("MFF"))
			{
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--disable-notifications");
				options.addArguments("disable-infobars");
				options.addArguments("marionette");
				DesiredCapabilities DCapabilities = DesiredCapabilities.firefox();
				 
				DCapabilities.setCapability (CapabilityType.ACCEPT_INSECURE_CERTS, true);
				options.merge(DCapabilities);
				System.setProperty("webdriver.gecko.driver", "E:\\Gecko Drivers\\Firefox_GeckoWin32\\geckodriver.exe");
				driver=new FirefoxDriver(options);
			}
		
	else if(browserName.equals("IE"))
	{
		// We will receive an error while execution of TC on IE
		//Unexpected error launching Internet Explorer. Browser zoom level was set to 94%. It should be set to 100
		//Navigate to registry and add DWORD to the Key 32bit HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Internet Explorer\Main\FeatureControl\FEATURE_BFCACHE
		//DWORD=0
		
		//For 64 bit
		//HKEY_LOCAL_MACHINE\SOFTWARE\Wow6432Node\Microsoft\Internet Explorer\Main\FeatureControl\FEATURE_BFCACHE
	
		
		InternetExplorerOptions options = new InternetExplorerOptions();
		//options.ignoreZoomSettings();
		
		DesiredCapabilities DCapabilities = DesiredCapabilities.internetExplorer();

		DCapabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		options.setCapability("ACCEPT_SSL_CERTS", true);
		DCapabilities.setCapability (CapabilityType.ACCEPT_SSL_CERTS, true);
	
//		DCapabilities.setCapability("chrome.switches", Arrays.asList("--start-maximized", "--ignore-certificate-errors",
//				"--disable-popup-blocking", "--disable-default-apps", "--auto-launch-at-startup", "--always-authorize-plugins"));
		
		
		options.merge(DCapabilities);		
		System.setProperty("webdriver.ie.driver","E:\\Gecko Drivers\\IEDriver\\IEDriverServer.exe" );
		driver = new InternetExplorerDriver(options);
		

		
//		driver = new InternetExplorerDriver();
	}
	
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.navigate().to(prop.getProperty("url"));
		
		//driver.navigate().to("javascript:document.getElementById('overridelink').click()");
		//The above line is used to bypass the IE unsigned certificates
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	
	
	



	}

}