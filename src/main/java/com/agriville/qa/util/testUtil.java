package com.agriville.qa.util;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.agriville.qa.base.TestBase;

public class testUtil extends TestBase
{
	public String SwitchToChildTab_ReturnTitleOfChildTab_BackToParentTab() throws InterruptedException
	{
		String parentTab   = driver.getWindowHandle();
		String TitleofChildTab = null;
		Set<String> AllTab=driver.getWindowHandles();
		for(String childTab:AllTab)
		{
			if(!parentTab.equalsIgnoreCase(childTab))
			{
				driver.switchTo().window(childTab);
				Thread.sleep(10000);
				TitleofChildTab=driver.getTitle().trim();
				
			}
			
		}
		driver.close();
		driver.switchTo().window(parentTab);
		return TitleofChildTab;
		
	}
	
	public void Switch_To_ChildTab() throws InterruptedException
	{
		String parentTab = driver.getWindowHandle();
		Set<String> AllTab=driver.getWindowHandles();
		for(String childTab:AllTab)
		{
			if(!parentTab.equalsIgnoreCase(childTab))
			{
				driver.switchTo().window(childTab);
				
			}
			
		}
					
	}
	
	public void Switch_To_ParentTab() throws InterruptedException
	{
		String parentTab = driver.getWindowHandle();
		Set<String> newTab=driver.getWindowHandles();
		for(String childTab:newTab)
		{
			if(!parentTab.equalsIgnoreCase(childTab))
			{
				driver.close();
				driver.switchTo().window(childTab);
				
			}
			
		}
		
		
	}
	
	
	public static void Scroll_DownFull_Page()
	{
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,1500)", "");
	}
	
	public static void ScrollToEndOfPage()
	{
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
	}

	
	
	public static String getTitleOfPage()
	{
		return driver.getTitle();
	}
	
	public static void navigateToPreviouPage()
	{
		driver.navigate().back();
	}
	
	public static void RefreshCurrentPage()
	{
		driver.navigate().refresh();
	}
	
	
	public static void Switch_To_Alert_Accept()
	{
		
		driver.switchTo().alert().accept();
	}

	public static void Switch_To_Alert_Dismiss()
	{
		driver.switchTo().alert().dismiss();
	}
	
	
	public static String Switch_ToAlert_GetText_And_Accept_Alert() throws InterruptedException
	{
		
		Thread.sleep(3000);
		Alert newAlert=driver.switchTo().alert();
		String Str1=newAlert.getText();
		newAlert.accept();
		return Str1;
		
		
	}


	public static WebElement waitForElement(WebElement item) 
	{
	    WebDriverWait wait = new WebDriverWait(driver,30);
	    
	    
	    wait.until(ExpectedConditions.visibilityOf(item));
	    return item;
	}
	
	


	


	
	
}
