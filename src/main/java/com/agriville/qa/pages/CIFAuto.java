package com.agriville.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.agriville.qa.base.TestBase;

public class CIFAuto extends TestBase
{
	public CIFAuto()
	{
		PageFactory.initElements(driver, this);
	}


	
	@FindBy(xpath="//optgroup[@label]")
	List<WebElement> ListStateValue;
	
	@FindBy(xpath="//optgroup[@label='United States']//following-sibling::option")
	List<WebElement> ListUSCountryValue;
	
	@FindBy(xpath="//optgroup[@label='Canada']//following-sibling::option")
	List<WebElement> ListCandaCountryValue;
	
	@FindBy(xpath="//button[@class='dropdown-toggle btn btn-default']")
	WebElement BtnState;

	@FindBy(xpath="//select[@name='states']")
	WebElement selectState;

	public ArrayList<String> ListstateValue()
	{
		ArrayList<String> listObj=new ArrayList<String>();
		for(int i=0; i<ListStateValue.size();i++)
		{
			listObj.add(ListStateValue.get(i).getAttribute("label"));
		}
		return listObj;
	}

	public ArrayList<String> ListUSCountryValue()
	{
		ArrayList<String> listObj=new ArrayList<String>();
		for(int i=0; i<ListUSCountryValue.size();i++)
		{
			listObj.add(ListUSCountryValue.get(i).getAttribute("label"));
		}
		return listObj;
	}
	
	public ArrayList<String> ListCandaCountryValue()
	{
		ArrayList<String> listObj=new ArrayList<String>();
		for(int i=0; i<ListCandaCountryValue.size();i++)
		{
			listObj.add(ListCandaCountryValue.get(i).getAttribute("label"));
		}
		return listObj;
	}
	
	

}
