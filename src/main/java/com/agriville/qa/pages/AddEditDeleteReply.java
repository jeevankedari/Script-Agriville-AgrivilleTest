package com.agriville.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.agriville.qa.base.TestBase;
import com.agriville.qa.util.testUtil;

public class AddEditDeleteReply extends TestBase
{
	@FindBy(xpath="//td[@id='cke_contents_vB_Editor_001_editor']/textarea")
	WebElement RTXBXDesc;
	
	@FindBy(xpath="//input[@id='vB_Editor_001_save']")
	WebElement BtnSubmitReply;
	
	@FindBy(xpath="//input[@name='preview'][@value='Preview Post']")
	WebElement BtnPreviewReply;
	
	@FindBy(xpath="//div[@class='titlebar']")
	WebElement ForumTitle;
	//Page Factory or Object Repository
	
	@FindBy(xpath="//h1")
	WebElement H1OnThreadDetails;
	
	@FindBy(xpath="//div[@class='titlebar']//a[contains(text(),'Forum')]")
	WebElement Forumlink;
	
	@FindBy(xpath="//div[@class='titlebar']/a[2]")
	WebElement DiscCategorieslink;
	
	@FindBy(xpath="//div[@class='titlebar']/a[3]")
	WebElement ThreadTitlelink;
	
//	@FindBy(xpath="//strong[contains(text(),'jeevan.kedari')]")
//	List<WebElement> specificUserName;
	
	@FindBy(xpath="//img[contains(@id, 'editimg')]")
	List<WebElement> InitialEditBtn;
	
	@FindBy(xpath="//li[@class='activitybit forum_post']//a[2]")
	List<WebElement> ThreadReplyOnMemberPage;
	
	@FindBy(xpath="//li[@class='activitybit forum_thread']//a[2]")
	List<WebElement> ThreadTitleOnMemberPage;
	
	
	
	public AddEditDeleteReply()
	{
		PageFactory.initElements(driver, this);
	}
//Actions

	public ArrayList<Boolean> AllElementOnReplyThread()
	{
		ArrayList<Boolean> listObj=new ArrayList<Boolean>();
		listObj.add(RTXBXDesc.isDisplayed());
		listObj.add(BtnSubmitReply.isDisplayed());
		listObj.add(BtnPreviewReply.isDisplayed());
		return listObj;
	}
	
	public void EnterDescription(String description)
	{
		RTXBXDesc.sendKeys(description);
	}
	
	public void clearDescription()
	{
		RTXBXDesc.clear();
	}
	public String ForumTitle()
	{
		return ForumTitle.getText().trim();
	}
	
	public void clickBtnPreviewReply()
	{
		testUtil.ElementIsClickable(BtnPreviewReply);
		BtnPreviewReply.click();
	}
	
	public void clickBtnSubmitReply()
	{
		testUtil.ElementIsClickable(BtnSubmitReply);
		BtnSubmitReply.click();
	}
	
	public String H1OnThreadDetails()
	{
		return H1OnThreadDetails.getText().trim();
	}
	
	public void clickForumlink()
	{
		testUtil.ElementIsClickable(Forumlink);
		Forumlink.click();
	}
	
	public void clickThreadTitlelink()
	{
		testUtil.ElementIsClickable(ThreadTitlelink);
		ThreadTitlelink.click();
	}
	
	public void clickDiscCategorieslink()
	{
		testUtil.ElementIsClickable(DiscCategorieslink);
		DiscCategorieslink.click();
	}
	
	public List<WebElement> InitialEditBtn()
	{
		return InitialEditBtn;
				
	}
	
	public void clickFirstThreadTitleOnMemberPage()
	{
		if(ThreadTitleOnMemberPage.isEmpty())
		{
			System.out.println("All the Elements are deleted");
		}
		else
		{
			ThreadTitleOnMemberPage.get(0).click();
		}
		
	}
	
	public int ThreadTitleOnMemberPage()
	{
		return ThreadTitleOnMemberPage.size();
	}
	
	
	public void clickFirstThreadReplyOnMemberPage()
	{
		if(ThreadReplyOnMemberPage.isEmpty())
		{
			System.out.println("All the Elements are deleted");
		}
		else
		{
			ThreadReplyOnMemberPage.get(0).click();
		}
		
	}
	
	public int ThreadReplyOnMemberPage()
	{
		return ThreadReplyOnMemberPage.size();
	}
	
	
	
	public void clickEditBtn()
	{
		if(InitialEditBtn.isEmpty())
		{
			
		}
		else
		{
			InitialEditBtn.get(0).click();
		}
		
	}
}
