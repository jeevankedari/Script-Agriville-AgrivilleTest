package com.agriville.qa.util;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.agriville.qa.base.TestBase;
import com.agriville.qa.pages.loginPage;
import com.agriville.qa.pages.searchTopic;

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
	
//	public static void ScrollToEndOfPage()
//	{
//		Actions actions = new Actions(driver);
//		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
//	}

	
	
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
	
	
	public static void Switch_To_Alert_Accept() throws InterruptedException
	{
		
		 WebDriverWait wait = new WebDriverWait(driver, 30);
		 wait.until(ExpectedConditions.alertIsPresent());
		 driver.switchTo().alert().accept();
		 
	}

	public static void Switch_To_Alert_Dismiss()
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().dismiss();
		
	}
	
	
	public static String Switch_ToAlert_GetText_And_Accept_Alert() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert newAlert=driver.switchTo().alert();
		String Str1=newAlert.getText();
		wait.until(ExpectedConditions.alertIsPresent());
		newAlert.accept();
		
		return Str1;
		
		
//		try 
//		{
//	        Alert alert = driver.switchTo().alert();
//	        String alertText = alert.getText();
//	        alert.accept();
//	        return alertText;
//	    } 
//		catch(NoAlertPresentException e) 
//		{
//	        e.printStackTrace();
//		}
		
		  
		
	}
	


	public static WebElement ElementIsDisplayed(WebElement item) 
	{
	    WebDriverWait wait = new WebDriverWait(driver,30);
	    wait.until(ExpectedConditions.visibilityOf(item));
	    return item;
	}
	
	public static WebElement ElementIsClickable(WebElement item) 
	{
	    WebDriverWait wait = new WebDriverWait(driver,30);
	    wait.until(ExpectedConditions.elementToBeClickable(item));
	    return item;
	}
	

		
	
	
	
	String Path="E://Script Agriville//AgrivilleTest//src//main//java//com//agriville//qa//testdata//Agriville.xlsx";
	String sheetName="Disc_Categories";
	String sheetName1="Disc_CategoriesLogin";
	loginPage loginPageObj=new loginPage();
	ExcelDataUtil ExcelDataUtilObj=new ExcelDataUtil(Path);
	searchTopic searchTopicObj=new searchTopic();
	
//Login with Active Account and Click on Beef Production
	public void loginWithActiveAccount() throws InterruptedException
	{
		loginPageObj.clickLogin();
		Thread.sleep(4000);
		loginPageObj.UserName(ExcelDataUtilObj.getData(sheetName1, 2, 0));
		loginPageObj.Password(ExcelDataUtilObj.getData(sheetName1, 2, 1));
		loginPageObj.clickLoginBtnOnLoginFrame();
		
	} 
	
	public void logOut() throws InterruptedException
	{
		loginPageObj.clickArrowBtn();
		loginPageObj.clickLogOutBtn();
		Switch_To_Alert_Accept();
	}
	
	public void logOutWithOutChanges()
	{
		loginPageObj.clickArrowBtn();
		loginPageObj.clickLogOutBtn();
		driver.switchTo().alert().accept();
		driver.switchTo().alert().accept();
	}

	//Login with InActive Account and Click on Beef Production
	public void loginWithInActiveAccount() throws InterruptedException
	{
		loginPageObj.clickLogin();
		Thread.sleep(4000);
		loginPageObj.UserName(ExcelDataUtilObj.getData(sheetName1, 1, 0));
		loginPageObj.Password(ExcelDataUtilObj.getData(sheetName1, 1, 1));
		loginPageObj.clickLoginBtnOnLoginFrame();
		
	} 


	
	
}
