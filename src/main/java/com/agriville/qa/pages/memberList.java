package com.agriville.qa.pages;

import java.util.ArrayList;
import java.util.List;


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
	WebElement BtnSubmitMsg;
	
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
	
	
	//Actions
	
	public String H1SendPvtMsg()
	{
		return H1SendPvtMsg.getText().trim();
	}
	
	public void clearRecipients()
	{
		
		Recipients.clear();
	}
	
	public void clickBtnSubmitMsg()
	{
		testUtil.ElementIsClickable(BtnSubmitMsg);
		BtnSubmitMsg.click();
	}
	

	public void clickIAgreeCookies()
	{
		testUtil.ElementIsClickable(IAgreeCookies);
		IAgreeCookies.click();
	}
	
	
	public void Title(String title)
	{
		Title.sendKeys(title);
	}
	public void RTBxEditor(String rtbxeditor)
	{
		//JavascriptExecutor js =(JavascriptExecutor) driver;
		//js.executeScript("document.getElementsByName('actionUpdate')[0].style.display='inline'");
		//((JavascriptExecutor)driver).executeScript("document.arguments[0].style.display='inline'");

//		testUtil.ElementIsClickable(RTBxEditor);
//		RTBxEditor.click();
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
	
}
