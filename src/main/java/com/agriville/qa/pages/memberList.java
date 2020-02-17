package com.agriville.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.agriville.qa.base.TestBase;
import com.agriville.qa.util.testUtil;

public class memberList extends TestBase
{
	public memberList()
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[@class='editor-title']")
	WebElement H1SendPvtMsg;
	
	@FindBy(xpath="//div[@id='pmrecips']/textarea")
	WebElement Recipients;
	
	@FindBy(xpath="//div[@id='shell-subpage']//div[2]//div[@class='group']//input[@id='vB_Editor_001_save']")
	WebElement BtnSubmit;
	
	@FindBy(xpath="//input[@id='agree']")
	WebElement IAgreeCookies;
	
	@FindBy(xpath="//input[@id='title']")
	WebElement Title;
	
	@FindBy(xpath="//td[@id='cke_contents_vB_Editor_001_editor']/textarea")
	WebElement RTBxEditor;
	
	@FindBy(xpath="//ul[@class='blockrow error']//a")
	WebElement LinkmemberList;
		
	@FindBy(xpath="//a[contains(text(),'Personal Messages')]")
	WebElement PersonalMsg;
	
	@FindBy(xpath="//strong[contains(text(),'Send New Message')]")
	WebElement InboxSendMsg;
	
	@FindBy(xpath="//div[@id='pagetitle']/h1")
	WebElement MemberListTitle;
	
	@FindBy(xpath="//body/a[contains(text(),'Forum')]")
	WebElement LinkForum;
	
	@FindBy(xpath="//dl[@id='charnav']/dt")
	WebElement LblForum;
	
	@FindBy(xpath="//h2[contains(text(),'Members of Farming and Agriculture Discussion Forum | Agriville.com')]")
	WebElement H2MembersList;
	
	@FindBy(xpath="//span[@class='ctrlcontainer']")
	WebElement DDquickNavi;
	
	@FindBy(xpath="//dt[contains(text(),'Filter Results')]")
	WebElement FilterResult;
	
	@FindBy(xpath="//a[contains(text(),'User Name')]")
	WebElement LinkUserName;
	
	@FindBy(xpath="//a[@id='yui-gen2']")
	WebElement LinkSearchMem;
	
	
	@FindBy(xpath="//a[@class='textcontrol']")
	WebElement linkTop;
	
	@FindBy(xpath="//a[contains(text(),'Posts')]")
	WebElement linkPosts;
	
	@FindBy(xpath="//span[contains(text(),'Avatar')]")
	WebElement linkAvatar;
	
	@FindBy(xpath="//a[@class='username']")
	List<WebElement> UNonMemberList;
	
	@FindBy(xpath="//td[@class='postcount']")
	List<WebElement> NumberOfPostMemberList;
	
	@FindBy(xpath="//table[@id='memberlist_table']")
	WebElement table;
	
	@FindBy(xpath="//form[@id='yui-gen0']//a[contains(text(),'1')]")
	WebElement FirstPage;
	
	@FindBy(xpath="//form[@id='yui-gen0']//a")
	List<WebElement> listPage; 
	
	@FindBy(xpath="//div[@id='above_memberlist']//li[4]//a[1]//img[1]")
	WebElement BtnNext;
	
	@FindBy(xpath="//div[@id='above_memberlist']//li[5]//a[1]//img[1]")
	WebElement BtnLast;
	
	@FindBy(xpath="//div[@id='above_memberlist']//li[3]//a[1]//img[1]")
	WebElement BtnPrevious;
	
	@FindBy(xpath="//div[@id='above_memberlist']//li[1]//a[1]//img[1]")
	WebElement BtnFirst;
	
	@FindBy(xpath="//span[@class='ctrlcontainer']")
	WebElement quickNavigationBtm;
	
	@FindBy(xpath="//ul[@class='navpopupbody popupbody']/li")
	List<WebElement> ListsiteAreas; 
	
	@FindBy(xpath="//ol[@class='d1']/li")
	List<WebElement> ListForums; 
	
	@FindBy(xpath="//a[contains(text(),'Community Centre')]")
	WebElement AgrivilleComunication;
	
	@FindBy(xpath="//div[@class='editor-title']")
	WebElement settings;
	
	@FindBy(xpath="//h1[@class='blockhead']")
	WebElement msgHeader;
	
	@FindBy(xpath="//a[contains(text(),'Forums Home')]")
	WebElement forumHome;
	
	@FindBy(xpath="//div[@class='body-left-col']//th[contains(text(),'Replies')]")
	WebElement ColRepliesView;
	
	@FindBy(xpath="//h1")
	WebElement h1OnDiscCategories;
	
	//Actions
	
	public String H1SendPvtMsg()
	{
		return H1SendPvtMsg.getText().trim();
	}
	
	public void clearRecipients()
	{
		
		Recipients.clear();
	}
	
	public void clickBtnSubmit()
	{
		testUtil.ElementIsClickable(BtnSubmit);
		BtnSubmit.click();
	}
	

	public void clickIAgreeCookies()
	{
		testUtil.ElementIsClickable(IAgreeCookies);
		IAgreeCookies.click();
	}
	
	
	public void Title(String title)
	{
		Title.clear();
		Title.sendKeys(title);
	}
	public void RTBxEditor(String rtbxeditor)
	{

		RTBxEditor.clear();
		RTBxEditor.sendKeys(rtbxeditor);
	}
	
	public void clickLinkmemberList()
	{
		testUtil.ElementIsClickable(LinkmemberList);
		LinkmemberList.click();
	}
	
	public void clicklinkPosts()
	{
		testUtil.ElementIsClickable(linkPosts);
		linkPosts.click();
	}
	
//	public WebElement clickLinkmemberList(WebElement LinkmemberList)
//	{
//		testUtil.clickLocator(LinkmemberList);
//
//	}
	
	public String MemberListTitle()
	{
		return MemberListTitle.getText().trim();
	}
	public void clickPersonalMsg()
	{
		testUtil.ElementIsClickable(PersonalMsg);
		PersonalMsg.click();
	}
	
	public void ClickInboxSendMsg()
	{
		testUtil.ElementIsClickable(InboxSendMsg);
		InboxSendMsg.click();
	}
	
	public ArrayList<Boolean> ElementOnMemberList()
	{
		ArrayList<Boolean> listObj=new ArrayList<>();
		listObj.add(MemberListTitle.isDisplayed());
		listObj.add(LinkForum.isDisplayed());
		listObj.add(LblForum.isDisplayed());
		listObj.add(H2MembersList.isDisplayed());
		listObj.add(DDquickNavi.isDisplayed());
		listObj.add(FilterResult.isDisplayed());
		listObj.add(LinkUserName.isDisplayed());
		listObj.add(LinkSearchMem.isDisplayed());
		listObj.add(linkTop.isDisplayed());
		
		listObj.add(linkPosts.isDisplayed());
		listObj.add(linkAvatar.isDisplayed());
		return listObj;
		
	}
	
	public String LinkForum()
	{
		return LinkForum.getText().trim();
	}
	
	public String LblForum()
	{
		return LblForum.getText().trim();
	}
	
	public String H2MembersList()
	{
		return H2MembersList.getText().trim();
	}
	public String DDquickNavi()
	{
		return DDquickNavi.getText().trim();
	}
	
	public String FilterResult()
	{
		return FilterResult.getText().trim();
	}
	
	public String LinkUserName()
	{
		return LinkUserName.getText().trim();
	}
	
	public String LinkSearchMem()
	{
		return LinkSearchMem.getText().trim();
	}
	
	public String linkTop()
	{
		return linkTop.getText().trim();
	}

	public String linkPosts()
	{
		return linkPosts.getText().trim();
	}
	
	public String linkAvatar()
	{
		return linkAvatar.getText().trim();
	}
	
	public void clickLinkForum()
	{
		testUtil.ElementIsClickable(LinkForum);
		LinkForum.click();
	}
	
	public void clickLinkUserName()
	{
		LinkUserName.click();
	}
	public ArrayList<String> UNonMemberList()
	{
		//driver.switchTo().frame(table);
		ArrayList<String> listObtain=new ArrayList<String>();
		
		for(int i=0;i<UNonMemberList.size();i++)
		{
			listObtain.add(UNonMemberList.get(i).getText());
			
		}
		return listObtain;
	}
	
	public ArrayList<String> NumberOfPostMemberList()
	{
		//driver.switchTo().frame(table);
		ArrayList<String> listObtain=new ArrayList<String>();
		
		for(int i=0;i<NumberOfPostMemberList.size();i++)
		{
			listObtain.add(NumberOfPostMemberList.get(i).getText());
			
		}
		return listObtain;
	}
	
	public String getColor()
	{
		return FirstPage.getText();
	}
	
	public String clickOnSecondPage()
	{
		
		for(int i=1;i<2;i++)
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", listPage.get(i));
			
		}
	return listPage.get(3).getText();
	}
	

	
	
	public String clickOnFirstPage()
	{
		
		for(int i=2;i<3;i++)
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", listPage.get(i));
			
		}
	return listPage.get(0).getText();
	}
	
	public void clickBtnNext()
	{
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", BtnNext);

	}
	
	public String getValueNextBtn()
	{
		return listPage.get(3).getText();
	}
	
	public void clickBtnLast()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", BtnLast);
	}
	public String getValueLastBtn()
	{
		for(int i=0;i<1;i++)
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", listPage.get(i));
			
		}
		return listPage.get(0).getText();
	}
	
	public void clickBtnPrevious()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", BtnPrevious);
	}
	
	public String getValuePreviousBtn()
	{
		return listPage.get(0).getText();
	}
	
	public void clickBtnFirst()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", BtnFirst);
		
	}
	
	public void clickquickNavigationBtm()
	{
		testUtil.ElementIsClickable(quickNavigationBtm);
		quickNavigationBtm.click();
		
	}
	
	public ArrayList<String> getListsiteAreas()
	{
		ArrayList<String> listObtain=new ArrayList<String>();
		for(int i=0;i<ListsiteAreas.size()-1;i++ )
		{
			listObtain.add(ListsiteAreas.get(i).getText());
		}
		return listObtain;
		
	}
	
	public ArrayList<String> getListForums()
	{
		ArrayList<String> listObtain=new ArrayList<String>();
		for(int i=0;i<ListForums.size()-1;i++ )
		{
			listObtain.add(ListForums.get(i).getText());
		}
		return listObtain;
		
	}
	
	public String AgrivilleComunication()
	{
		return AgrivilleComunication.getText().trim();
	}
	
	
	
	public ArrayList<String> clickListsiteAreas()
	{
		ArrayList<String> listObj=new ArrayList<String>();
		for(int i=1;i<ListsiteAreas.size()-5;i++)
		{
			testUtil.RefreshCurrentPage();
//			JavascriptExecutor js=(JavascriptExecutor)driver;
//			js.executeScript("arguments[0].click();", quickNavigationBtm);
			
			quickNavigationBtm.click();
			ListsiteAreas.get(i).click();
//			JavascriptExecutor js1=(JavascriptExecutor)driver;
//			js1.executeScript("arguments[0].click();", ListsiteAreas.get(i));
			listObj.add(settings.getText());
			testUtil.navigateToPreviouPage();
		}
		return listObj;
		
	}
	
	public ArrayList<String> clickListsiteAreas1()
	{
		ArrayList<String> listObj=new ArrayList<String>();
		for(int i=4;i<ListsiteAreas.size()-3;i++)
		{
			testUtil.RefreshCurrentPage();
//			JavascriptExecutor js=(JavascriptExecutor)driver;
//			js.executeScript("arguments[0].click();", quickNavigationBtm);
			quickNavigationBtm.click();
			ListsiteAreas.get(i).click();
//			JavascriptExecutor js1=(JavascriptExecutor)driver;
//			js1.executeScript("arguments[0].click();", ListsiteAreas.get(i));
			
			listObj.add(msgHeader.getText());
			testUtil.navigateToPreviouPage();
		}
		return listObj;
		
	}
	
	public void clickforumHome()
	{
		testUtil.ElementIsClickable(forumHome);
		forumHome.click();
	}
	
	public void clickAgrivilleComunication()
	{
		testUtil.ElementIsClickable(AgrivilleComunication);
		AgrivilleComunication.click();
	}
	
	public String ColRepliesView()
	{
		return ColRepliesView.getText();
	}
	
	
	public ArrayList<String> clickForums()
	{
		ArrayList<String> listObj=new ArrayList<String>();
		for(int i=4;i<ListsiteAreas.size()-3;i++)
		{
			testUtil.RefreshCurrentPage();
//			JavascriptExecutor js=(JavascriptExecutor)driver;
//			js.executeScript("arguments[0].click();", quickNavigationBtm);
			quickNavigationBtm.click();
			ListForums.get(i).click();
//			JavascriptExecutor js1=(JavascriptExecutor)driver;
//			js1.executeScript("arguments[0].click();", ListsiteAreas.get(i));
			
			
			testUtil.navigateToPreviouPage();
		}
		return listObj;
		
	}
	
	public ArrayList<String> clickListForums()
	{
		ArrayList<String> listObj=new ArrayList<String>();
		for(int i=0;i<ListForums.size();i++)
		{
			testUtil.RefreshCurrentPage();
			quickNavigationBtm.click();
			ListForums.get(i).click();
			listObj.add(h1OnDiscCategories.getText());
			testUtil.navigateToPreviouPage();
			
		}
		return listObj;
		
	}
	
	
	
	
	
	
	
}
