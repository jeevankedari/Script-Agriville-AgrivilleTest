package com.agriville.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.agriville.qa.base.TestBase;
import com.agriville.qa.util.testUtil;

public class topicDetails extends TestBase 
{

	public topicDetails()
	{
		PageFactory.initElements(driver, this);
	}
	//Page Factory or Object Repository
	@FindBy(xpath="//input[@class='search-btn']")
	WebElement BtnSearch;
	
	@FindBy(xpath="//input[@id='textfield']")
	WebElement TxtBxSearch;
	
	@FindBy(xpath="//div[@class='body-left-col']//th[contains(text(), 'Title / Thread Starter')]//parent::tr//following-sibling::tr[1]//h2/a")
	WebElement H2FirstSubCategory;
	
	@FindBy(xpath="//h1")
	WebElement h1OnThreadPage;
	
	@FindBy(xpath="//div[@class='breadcrumbs']//a[2]")
	WebElement linkToSubPage;
	
	@FindBy(xpath="//div[@class='body-left-col']//th[contains(text(), 'Title / Thread Starter')]//parent::tr//following-sibling::tr[1]//span/a")
	WebElement FirstUNUnderThreadTitle;
	
	@FindBy(xpath="//h1[contains(text(),'Message')]")
	WebElement MsgLoginPage;
	
	@FindBy(xpath="//h1[contains(text(),'Log in')]")
	WebElement MsgH1Login;
	
	@FindBy(xpath="//span[@class='member_username']")
	WebElement NameOfMember;
	
	@FindBy(xpath="//div[@class='body-left-col']//th[contains(text(),'Last Post By')]//parent::tr//following-sibling::tr[1]//td[4]/a")
	WebElement FirstLastPostByOnSearchResult;
	
	@FindBy(xpath="//div[@class='body-left-col']//th[contains(text(),'Last Post By')]//parent::tr//following-sibling::tr[1]//td[5]/input[@id='button']")
	WebElement BtnFirstView;

	
	
	@FindBy(xpath="//table[@class='message-table']//input[@type='button']")
	WebElement BtnPostMsg;
	
	@FindBy(xpath="//th[contains(text(),'Post a New Reply')]")
	WebElement MsgPostNewReply;
	
	@FindBy(xpath="//h1[contains(text(),'Message')]")
	WebElement MsgAccountNotActivated;
	
	@FindBy(xpath="//table[@class='message-inner-table'][1]//img[contains(@id, 'quoteimg')]")
	WebElement BtnReply;
	
	@FindBy(xpath="//div[@id='yui-gen0']")
	WebElement UNThreadDetails;
	
	
	
	//Actions

	
	public String H2FirstSubCategory()
	{
		return H2FirstSubCategory.getText().trim();
	}
	
	
	public void clickH2FirstSubCategory()
	{
		testUtil.ElementIsClickable(H2FirstSubCategory);
		JavascriptExecutor jsclick=(JavascriptExecutor)driver;
		jsclick.executeScript("arguments[0].click();",H2FirstSubCategory);
		//H2FirstSubCategory.click();
	}
	
	
	public String h1OnThreadPage()
	{
		return h1OnThreadPage.getText().trim();
	}
	
	public void EnterDataSearchBx(String TextToSearch)
	{
		testUtil.ElementIsDisplayed(TxtBxSearch);
		TxtBxSearch.sendKeys(TextToSearch);
		
	}
	
	public void clicklinkToSubPage()
	{
		testUtil.ElementIsClickable(linkToSubPage);
		linkToSubPage.click();
	}
	
	
	public String FirstUNUnderThreadTitle()
	{
		return FirstUNUnderThreadTitle.getText().trim();
	}
	public void clickFirstUNUnderThreadTitle()
	{
		testUtil.ElementIsClickable(FirstUNUnderThreadTitle);
		FirstUNUnderThreadTitle.click();
	}
	
	
	public String MsgLoginPage()
	{
		return MsgLoginPage.getText().trim();
	}
	public String MsgH1Login()
	{
		return MsgH1Login.getText().trim();
	}
	
	
	public void clickBtnSearch()
	{
		testUtil.ElementIsClickable(BtnSearch);
		
		BtnSearch.click();
	}
	public String NameOfMember()
	{
		return NameOfMember.getText().trim();
	}
	
	
	public void clickFirstLastPostByOnSearchResult()
	{
		testUtil.ElementIsClickable(FirstLastPostByOnSearchResult);
		FirstLastPostByOnSearchResult.click();
	}
	
	public String FirstLastPostByOnSearchResult()
	{
		return FirstLastPostByOnSearchResult.getText().trim();
	}
	
	public void clickBtnFirstView()
	{
		testUtil.ElementIsClickable(BtnFirstView);
		BtnFirstView.click();
		
	}
	
	
	public void clickBtnPostMsg()
	{
		testUtil.ElementIsClickable(BtnPostMsg);
		BtnPostMsg.click();
	}
	
	public String MsgPostNewReply()
	{
		return MsgPostNewReply.getText().trim();
	}
	
	
	public String MsgAccountNotActivated()
	{
		return MsgAccountNotActivated.getText().trim();
	}
	
	public void clickBtnReply()
	{
		testUtil.ElementIsClickable(BtnReply);
		BtnReply.click();
	}
	
	public void clickUNThreadDetails()
	{
		testUtil.ElementIsClickable(UNThreadDetails);
		UNThreadDetails.click();
	}
	
	public String UNThreadDetails()
	{
		return UNThreadDetails.getText().trim();
	}
	
	
	
	
}
