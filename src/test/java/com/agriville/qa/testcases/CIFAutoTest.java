package com.agriville.qa.testcases;

import java.util.ArrayList;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.agriville.qa.base.TestBase;
import com.agriville.qa.pages.CIFAuto;



public class CIFAutoTest extends TestBase
{
	CIFAuto CIFAutoObj;
	public CIFAutoTest()
	{
		super();
	}
	
	
	@BeforeClass
	public void SetUp() 
	{
		intialization();
		
		CIFAutoObj = new CIFAuto();
	}
	
	@Test(priority=1)
	public void verifyStateDD()
	{
		ArrayList<String> listObj=new ArrayList<String>();
		listObj=CIFAutoObj.ListstateValue();
		
		for(int i=0;i<listObj.size();i++)
		{
			
		}
		
	}
	
	
	@Test(priority=2)
	public void verifyUSCountryDD()
	{
		ArrayList<String> listObj=new ArrayList<String>();
		listObj=CIFAutoObj.ListUSCountryValue();
		
		for(int i=0;i<listObj.size();i++)
		{
			
		}
		
	}
	
	
	@Test(priority=3)
	public void verifyCanadaCountryDD()
	{
		ArrayList<String> listObj=new ArrayList<String>();
		listObj=CIFAutoObj.ListCandaCountryValue();
		
		for(int i=0;i<listObj.size();i++)
		{
			
		}
		
	}

	@AfterClass
	public void TearDown()
	{
		driver.quit();
	}
	
	
}
