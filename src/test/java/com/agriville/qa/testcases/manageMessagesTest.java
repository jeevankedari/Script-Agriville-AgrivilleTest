package com.agriville.qa.testcases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.agriville.qa.base.TestBase;
import com.agriville.qa.pages.AddEditDeleteTopic;
import com.agriville.qa.pages.loginPage;
import com.agriville.qa.pages.manageMessages;
import com.agriville.qa.pages.memberList;
import com.agriville.qa.pages.memberProfile;
import com.agriville.qa.pages.updateProfileAndPwd;
import com.agriville.qa.util.ExcelDataUtil;
import com.agriville.qa.util.testUtil;

public class manageMessagesTest extends TestBase
{
	memberList memberListObj;
	manageMessages manageMessagesObj;
	testUtil testUtilObj;
	AddEditDeleteTopic AddEditDeleteTopicObj;
	memberProfile memberProfileObj;
	ExcelDataUtil ExcelDataUtilObj;
	loginPage loginPageObj;
	updateProfileAndPwd updateProfileAndPwdObj;
	String Path = "E://Script Agriville//AgrivilleTest//src//main//java//com//agriville//qa//testdata//Agriville.xlsx";
	String sheetName = "Disc_Categories";
	String sheetName1 = "Disc_CategoriesLogin";
	String sheetName2 = "PostThread";
	String sheetName3 = "Reply";
	String sheetName4 = "EditProfile";
	String sheetName5 = "EditPassword";
	String sheetName6 = "MemberList";
	String sheetName7="QuickNavigation";
	String sheetName8="Messages";
	public manageMessagesTest()
	{
		super();
	}

	@BeforeClass
	public void SetUp() 
	{
		intialization();
		memberListObj=new memberList();
		manageMessagesObj= new manageMessages();
		testUtilObj = new testUtil();
		memberProfileObj=new memberProfile();
		AddEditDeleteTopicObj=new AddEditDeleteTopic();
		ExcelDataUtilObj=new ExcelDataUtil(Path);
		updateProfileAndPwdObj=new updateProfileAndPwd();
		loginPageObj=new loginPage();
	}
	
	
	@Test(priority=1)
	public void verifyNavigationToSPFrmUN() throws InterruptedException
	{
		memberListObj.clickIAgreeCookies();
		SoftAssert S1=new SoftAssert();
		testUtilObj.NavigateToContentPage();
		memberProfileObj.clicksendPrivateMsg();
		
		String H1SendPvtMsg=memberListObj.H1SendPvtMsg();
		S1.assertEquals(H1SendPvtMsg, "SEND NEW PRIVATE MESSAGE","Send New Message Not Found");
		
		String h1YourMsg=manageMessagesObj.h1YourMsg();
		S1.assertEquals(h1YourMsg, "Your Message");
		
		String postIconsMsg=manageMessagesObj.postIconsMsg();
		S1.assertEquals(postIconsMsg, "You may choose an icon for your message from this list");
		testUtil.Scroll_DownFull_Page();
		for(int i=0;i<manageMessagesObj.verifySendNMsg().size();i++)
		{
			boolean flag=manageMessagesObj.verifySendNMsg().get(i);
			S1.assertTrue(flag);
		}
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		
		System.out.println("User Name: Verified navigation to Send Message Page ");
		
	}
	
	@Test(priority=2)
	public void verifyNavigationToSPFrmPersonalMessage() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
//		memberListObj.clickIAgreeCookies();
		
		testUtilObj.NavigateToInbox();
		memberListObj.ClickInboxSendMsg();
		
		String H1SendPvtMsg=memberListObj.H1SendPvtMsg();
		S1.assertEquals(H1SendPvtMsg, "SEND NEW PRIVATE MESSAGE","Send New Message Not Found");
		
		String h1YourMsg=manageMessagesObj.h1YourMsg();
		S1.assertEquals(h1YourMsg, "Your Message");
		
		String postIconsMsg=manageMessagesObj.postIconsMsg();
		S1.assertEquals(postIconsMsg, "You may choose an icon for your message from this list");
		testUtil.Scroll_DownFull_Page();
		for(int i=0;i<manageMessagesObj.verifySendNMsg().size();i++)
		{
			boolean flag=manageMessagesObj.verifySendNMsg().get(i);
			S1.assertTrue(flag);
		}
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Personal Message: Verified navigation to Send Message Page ");
	
	}
	
	
	@Test(priority=3)
	public void verifyFirstSubmitBtnFrmUN() throws InterruptedException
	{
//		memberListObj.clickIAgreeCookies();
		SoftAssert S1=new SoftAssert();
		testUtilObj.NavigateToContentPage();
		memberProfileObj.clicksendPrivateMsg();
		
		memberListObj.clearRecipients();
		manageMessagesObj.clickFirstBtnSubmit();
		String Title=testUtil.Switch_ToAlert_GetText_And_Accept_Alert();
		S1.assertEquals(Title, "You must enter a title / subject!");
	
		AddEditDeleteTopicObj.clickProfileLink();
		memberProfileObj.clicksendPrivateMsg();
		memberListObj.Title(ExcelDataUtilObj.getData(sheetName6, 1, 1));
		manageMessagesObj.clickFirstBtnSubmit();
		String msgDescription=manageMessagesObj.msgDescription();
		S1.assertEquals(msgDescription, "Please complete both the subject and message fields.");
		
		AddEditDeleteTopicObj.clickProfileLink();
		memberProfileObj.clicksendPrivateMsg();
		memberListObj.clearRecipients();
		memberListObj.Title(ExcelDataUtilObj.getData(sheetName6, 1, 1));
		memberListObj.RTBxEditor(ExcelDataUtilObj.getData(sheetName6, 1, 2));
		manageMessagesObj.clickFirstBtnSubmit();
		String msgErrors=manageMessagesObj.msgErrors();

		S1.assertEquals(msgErrors, "Errors");
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("UserName: Verified Send Message Page using First Submit Button");
		
	}
	
	@Test(priority=4)
	public void verifySecondSubmitBtnFrmUN() throws InterruptedException
	{
//		memberListObj.clickIAgreeCookies();
		SoftAssert S1=new SoftAssert();
		testUtilObj.NavigateToContentPage();
		memberProfileObj.clicksendPrivateMsg();
		
		memberListObj.clearRecipients();
		manageMessagesObj.clickSecondBtnSubmit();
		String Title=testUtil.Switch_ToAlert_GetText_And_Accept_Alert();
		S1.assertEquals(Title, "You must enter a title / subject!");
	
		AddEditDeleteTopicObj.clickProfileLink();
		memberProfileObj.clicksendPrivateMsg();
		memberListObj.Title(ExcelDataUtilObj.getData(sheetName6, 1, 1));
		manageMessagesObj.clickSecondBtnSubmit();
		String msgDescription=manageMessagesObj.msgDescription();
		S1.assertEquals(msgDescription, "Please complete both the subject and message fields.");
		
		AddEditDeleteTopicObj.clickProfileLink();
		memberProfileObj.clicksendPrivateMsg();
		memberListObj.clearRecipients();
		memberListObj.Title(ExcelDataUtilObj.getData(sheetName6, 1, 1));
		memberListObj.RTBxEditor(ExcelDataUtilObj.getData(sheetName6, 1, 2));
		manageMessagesObj.clickSecondBtnSubmit();
		String msgErrors=manageMessagesObj.msgErrors();

		S1.assertEquals(msgErrors, "Errors");
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("UserName: Verified Send Message Page using Second Submit Button");
	}
	
	@Test(priority=5)
	public void verifyFirstSubmitBtnFrmPersonalMsg() throws InterruptedException
	{
//		memberListObj.clickIAgreeCookies();
		SoftAssert S1=new SoftAssert();
		testUtilObj.NavigateToInbox();
		memberListObj.ClickInboxSendMsg();
		
		memberListObj.clearRecipients();
		manageMessagesObj.clickFirstBtnSubmit();
		String Title=testUtil.Switch_ToAlert_GetText_And_Accept_Alert();
		S1.assertEquals(Title, "You must enter a title / subject!");
	
		updateProfileAndPwdObj.clickdownArrow();
		memberListObj.clickPersonalMsg();
		memberListObj.ClickInboxSendMsg();
		memberListObj.Title(ExcelDataUtilObj.getData(sheetName6, 1, 1));
		manageMessagesObj.clickFirstBtnSubmit();
		String msgDescription=manageMessagesObj.msgDescription();
		S1.assertEquals(msgDescription, "Please complete both the subject and message fields.");
		
		updateProfileAndPwdObj.clickdownArrow();
		memberListObj.clickPersonalMsg();
		memberListObj.ClickInboxSendMsg();
		memberListObj.clearRecipients();
		memberListObj.Title(ExcelDataUtilObj.getData(sheetName6, 1, 1));
		memberListObj.RTBxEditor(ExcelDataUtilObj.getData(sheetName6, 1, 2));
		manageMessagesObj.clickFirstBtnSubmit();
		String msgErrors=manageMessagesObj.msgErrors();

		S1.assertEquals(msgErrors, "Errors");
		testUtilObj.logOut();
		S1.assertAll();
		System.out.println("Personal Message: Verified Send Message Page using First Submit Button");
		
	}
	
	@Test(priority=6)
	public void verifySecondSubmitBtnFrmPersonalMsg() throws InterruptedException
	{
//		memberListObj.clickIAgreeCookies();
		SoftAssert S1=new SoftAssert();
		testUtilObj.NavigateToInbox();
		memberListObj.ClickInboxSendMsg();
		
		memberListObj.clearRecipients();
		manageMessagesObj.clickSecondBtnSubmit();
		String Title=testUtil.Switch_ToAlert_GetText_And_Accept_Alert();
		S1.assertEquals(Title, "You must enter a title / subject!");
	
		updateProfileAndPwdObj.clickdownArrow();
		memberListObj.clickPersonalMsg();
		memberListObj.ClickInboxSendMsg();
		memberListObj.Title(ExcelDataUtilObj.getData(sheetName6, 1, 1));
		manageMessagesObj.clickSecondBtnSubmit();
		String msgDescription=manageMessagesObj.msgDescription();
		S1.assertEquals(msgDescription, "Please complete both the subject and message fields.");
		
		updateProfileAndPwdObj.clickdownArrow();
		memberListObj.clickPersonalMsg();
		memberListObj.ClickInboxSendMsg();
		memberListObj.clearRecipients();
		memberListObj.Title(ExcelDataUtilObj.getData(sheetName6, 1, 1));
		memberListObj.RTBxEditor(ExcelDataUtilObj.getData(sheetName6, 1, 2));
		manageMessagesObj.clickSecondBtnSubmit();
		String msgErrors=manageMessagesObj.msgErrors();

		S1.assertEquals(msgErrors, "Errors");
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Personal Message: Verified Send Message Page using Second Submit Button");
	}
	
	
	@Test(priority=7)
	public void verifyFirstPreviewBtnFrmUN() throws InterruptedException
	{
//		memberListObj.clickIAgreeCookies();
		SoftAssert S1=new SoftAssert();
		testUtilObj.NavigateToContentPage();
		memberProfileObj.clicksendPrivateMsg();
		
		memberListObj.clearRecipients();
		manageMessagesObj.clickFirstBtnPreview();
		String Title=testUtil.Switch_ToAlert_GetText_And_Accept_Alert();
		S1.assertEquals(Title, "You must enter a title / subject!");
	
		AddEditDeleteTopicObj.clickProfileLink();
		memberProfileObj.clicksendPrivateMsg();
		memberListObj.Title(ExcelDataUtilObj.getData(sheetName6, 1, 1));
		manageMessagesObj.clickFirstBtnPreview();
		String msgDescription=manageMessagesObj.msgDescription();
		S1.assertEquals(msgDescription, "Please complete both the subject and message fields.");
		
		AddEditDeleteTopicObj.clickProfileLink();
		memberProfileObj.clicksendPrivateMsg();
		memberListObj.clearRecipients();
		memberListObj.Title(ExcelDataUtilObj.getData(sheetName6, 1, 1));
		memberListObj.RTBxEditor(ExcelDataUtilObj.getData(sheetName6, 1, 2));
		manageMessagesObj.clickFirstBtnPreview();
		String msgErrors=manageMessagesObj.msgErrors();

		S1.assertEquals(msgErrors, "Errors");
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("UserName: Verified Send Message Page using First Preivew Button");
	}
	
	@Test(priority=8)
	public void verifySecondPreviewBtnFrmUN() throws InterruptedException
	{
//		memberListObj.clickIAgreeCookies();
		SoftAssert S1=new SoftAssert();
		testUtilObj.NavigateToContentPage();
		memberProfileObj.clicksendPrivateMsg();
		
		memberListObj.clearRecipients();
		manageMessagesObj.clickSecondBtnPreview();
		String Title=testUtil.Switch_ToAlert_GetText_And_Accept_Alert();
		S1.assertEquals(Title, "You must enter a title / subject!");
	
		AddEditDeleteTopicObj.clickProfileLink();
		memberProfileObj.clicksendPrivateMsg();
		memberListObj.Title(ExcelDataUtilObj.getData(sheetName6, 1, 1));
		manageMessagesObj.clickSecondBtnPreview();
		String msgDescription=manageMessagesObj.msgDescription();
		S1.assertEquals(msgDescription, "Please complete both the subject and message fields.");
		
		AddEditDeleteTopicObj.clickProfileLink();
		memberProfileObj.clicksendPrivateMsg();
		memberListObj.clearRecipients();
		memberListObj.Title(ExcelDataUtilObj.getData(sheetName6, 1, 1));
		memberListObj.RTBxEditor(ExcelDataUtilObj.getData(sheetName6, 1, 2));
		manageMessagesObj.clickSecondBtnPreview();
		String msgErrors=manageMessagesObj.msgErrors();

		S1.assertEquals(msgErrors,"Errors");
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("UserName: Verified Send Message Page using Second  Preview Button");
		
	}
	
	@Test(priority=9)
	public void verifyFirstPreiviewBtnFrmPersonalMsg() throws InterruptedException
	{
//		memberListObj.clickIAgreeCookies();
		SoftAssert S1=new SoftAssert();
		testUtilObj.NavigateToInbox();
		memberListObj.ClickInboxSendMsg();
		
		memberListObj.clearRecipients();
		manageMessagesObj.clickFirstBtnPreview();
		String Title=testUtil.Switch_ToAlert_GetText_And_Accept_Alert();
		S1.assertEquals(Title, "You must enter a title / subject!");
	
		updateProfileAndPwdObj.clickdownArrow();
		memberListObj.clickPersonalMsg();
		memberListObj.ClickInboxSendMsg();
		memberListObj.Title(ExcelDataUtilObj.getData(sheetName6, 1, 1));
		manageMessagesObj.clickFirstBtnPreview();
		String msgDescription=manageMessagesObj.msgDescription();
		S1.assertEquals(msgDescription, "Please complete both the subject and message fields.");
		
		updateProfileAndPwdObj.clickdownArrow();
		memberListObj.clickPersonalMsg();
		memberListObj.ClickInboxSendMsg();
		memberListObj.clearRecipients();
		memberListObj.Title(ExcelDataUtilObj.getData(sheetName6, 1, 1));
		memberListObj.RTBxEditor(ExcelDataUtilObj.getData(sheetName6, 1, 2));
		manageMessagesObj.clickFirstBtnPreview();
		String msgErrors=manageMessagesObj.msgErrors();

		S1.assertEquals(msgErrors, "Errors");
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Personal Message: Verified Send Message Page using First Preview Button");
	}
	
	@Test(priority=10)
	public void verifySecondPreiviewBtnFrmPersonalMsg() throws InterruptedException
	{
//		memberListObj.clickIAgreeCookies();
		SoftAssert S1=new SoftAssert();
		
		memberListObj.ClickInboxSendMsg();
		
		memberListObj.clearRecipients();
		manageMessagesObj.clickSecondBtnPreview();
		String Title=testUtil.Switch_ToAlert_GetText_And_Accept_Alert();
		S1.assertEquals(Title, "You must enter a title / subject!");
	
		updateProfileAndPwdObj.clickdownArrow();
		memberListObj.clickPersonalMsg();
		memberListObj.ClickInboxSendMsg();
		memberListObj.Title(ExcelDataUtilObj.getData(sheetName6, 1, 1));
		manageMessagesObj.clickSecondBtnPreview();
		String msgDescription=manageMessagesObj.msgDescription();
		S1.assertEquals(msgDescription, "Please complete both the subject and message fields.");
		
		updateProfileAndPwdObj.clickdownArrow();
		memberListObj.clickPersonalMsg();
		memberListObj.ClickInboxSendMsg();
		memberListObj.clearRecipients();
		memberListObj.Title(ExcelDataUtilObj.getData(sheetName6, 1, 1));
		memberListObj.RTBxEditor(ExcelDataUtilObj.getData(sheetName6, 1, 2));
		manageMessagesObj.clickSecondBtnPreview();
		String msgErrors=manageMessagesObj.msgErrors();

		S1.assertEquals(msgErrors, "Errors");
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Personal Message: Verified Send Message Page using Second Preview Button");
		
	}
	
	
	@Test(priority=11)
	public void verifyInboxFrmUN() throws InterruptedException
	{
//		memberListObj.clickIAgreeCookies();
		SoftAssert S1=new SoftAssert();
		testUtilObj.NavigateToContentPage();
		memberProfileObj.clicksendPrivateMsg();
		manageMessagesObj.clicklinkInbox();
		
		String editorTitle=manageMessagesObj.editorTitle();
		S1.assertEquals(editorTitle, "INBOX");
		
		manageMessagesObj.clicklinkInbox();
		String iconLegend=manageMessagesObj.iconLegend();
		S1.assertEquals(iconLegend,"Icon Legend");
		
		String msgUnread=manageMessagesObj.msgUnread();
		S1.assertEquals(msgUnread,"Unread Message");
		
		
		String msgRead=manageMessagesObj.msgRead();
		S1.assertEquals(msgRead,"Read Message");
		
		
		String msgReplied=manageMessagesObj.msgReplied();
		S1.assertEquals(msgReplied,"Replied-to Message");
		
		
		String msgForward=manageMessagesObj.msgForward();
		S1.assertEquals(msgForward,"Forwarded Message");
		
		
		String msgDownload=manageMessagesObj.msgDownload();
		S1.assertEquals(msgDownload,"Download all Private Messages as");
		
		
		String linkXML=manageMessagesObj.linkXML();
		S1.assertEquals(linkXML,"XML");
		
		String linkCSV=manageMessagesObj.linkCSV();
		S1.assertEquals(linkCSV,"CSV");
		
		String linkText=manageMessagesObj.linkText();
		S1.assertEquals(linkText,"Text");
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		
		
		System.out.println("User Name: Verified Inbox Messages");
	}
	
	
	@Test(priority=12)
	public void verifyInboxFrmPersonalMsg() throws InterruptedException
	{
//		memberListObj.clickIAgreeCookies();
		SoftAssert S1=new SoftAssert();
		
		testUtilObj.NavigateToInbox();
		String editorTitle=manageMessagesObj.editorTitle();
		S1.assertEquals(editorTitle, "INBOX");
		
		String iconLegend=manageMessagesObj.iconLegend();
		S1.assertEquals(iconLegend,"Icon Legend");
		
		String msgUnread=manageMessagesObj.msgUnread();
		S1.assertEquals(msgUnread,"Unread Message");
		
		
		String msgRead=manageMessagesObj.msgRead();
		S1.assertEquals(msgRead,"Read Message");
		
		
		String msgReplied=manageMessagesObj.msgReplied();
		S1.assertEquals(msgReplied,"Replied-to Message");
		
		
		String msgForward=manageMessagesObj.msgForward();
		S1.assertEquals(msgForward,"Forwarded Message");
		
		
		String msgDownload=manageMessagesObj.msgDownload();
		S1.assertEquals(msgDownload,"Download all Private Messages as");
		
		
		String linkXML=manageMessagesObj.linkXML();
		S1.assertEquals(linkXML,"XML");
		
		String linkCSV=manageMessagesObj.linkCSV();
		S1.assertEquals(linkCSV,"CSV");
		
		String linkText=manageMessagesObj.linkText();
		S1.assertEquals(linkText,"Text");
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		
		System.out.println("Personal Message: Verified Inbox Messages");
	}
	
	
	
	
	
	
	
	@Test(priority=13)
	public void verifySentItemsFrmUN() throws InterruptedException
	{
//		memberListObj.clickIAgreeCookies();
		SoftAssert S1=new SoftAssert();
		testUtilObj.NavigateToContentPage();
		memberProfileObj.clicksendPrivateMsg();
		manageMessagesObj.clicksentItems();
		String editorTitle=manageMessagesObj.editorTitle();
		S1.assertEquals(editorTitle, "SENT ITEMS");
		
		for(int i=0;i<manageMessagesObj.verifySentItems().size();i++)
		{
			boolean flag=manageMessagesObj.verifySentItems().get(i);
			S1.assertTrue(flag);
		}
		
		ArrayList<String> listObj=new ArrayList<String>();
		listObj=manageMessagesObj.verifySelectedMsg();
		for(int i=0;i<listObj.size();i++)
			
		{
			S1.assertEquals(listObj.get(i), ExcelDataUtilObj.getData(sheetName8, i+1, 0));
		}
		testUtil.RefreshCurrentPage();
		
		List<WebElement> selectMsg=manageMessagesObj.verifyReadReply();
		for(int i=0;i<selectMsg.size();i++)
		{
			
			S1.assertEquals(selectMsg.get(i).getText(), ExcelDataUtilObj.getData(sheetName8, i+1, 1));
		}
		
		List<WebElement> startMonth=manageMessagesObj.verifyStartMonth();
		for(int i=0;i<startMonth.size();i++)
		{
			S1.assertEquals(startMonth.get(i).getText(),  ExcelDataUtilObj.getData(sheetName8, i+1, 2));
		}
		
		List<WebElement> endMonth=manageMessagesObj.verifyStartMonth();
		for(int i=0;i<endMonth.size();i++)
		{
			S1.assertEquals(endMonth.get(i).getText(),  ExcelDataUtilObj.getData(sheetName8, i+1, 2));
		}
		
		String iconLegend=manageMessagesObj.iconLegend();
		S1.assertEquals(iconLegend,"Icon Legend");
		
		String msgUnread=manageMessagesObj.msgUnread();
		S1.assertEquals(msgUnread,"Unread Message");
		
		
		String msgRead=manageMessagesObj.msgRead();
		S1.assertEquals(msgRead,"Read Message");
		
		
		String msgReplied=manageMessagesObj.msgReplied();
		S1.assertEquals(msgReplied,"Replied-to Message");
		
		
		String msgForward=manageMessagesObj.msgForward();
		S1.assertEquals(msgForward,"Forwarded Message");
		
		
		String msgDownload=manageMessagesObj.msgDownload();
		S1.assertEquals(msgDownload,"Download all Private Messages as");
		
		
		String linkXML=manageMessagesObj.linkXML();
		S1.assertEquals(linkXML,"XML");
		
		String linkCSV=manageMessagesObj.linkCSV();
		S1.assertEquals(linkCSV,"CSV");
		
		String linkText=manageMessagesObj.linkText();
		S1.assertEquals(linkText,"Text");
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		
		System.out.println("User Name: Verified Inbox Messages");
		
	}
	
	
	
	@Test(priority=14)
	public void verifySentItemsFrmPersonalMessage() throws InterruptedException
	{
//		memberListObj.clickIAgreeCookies();
		SoftAssert S1=new SoftAssert();
		
		testUtilObj.NavigateToInbox();
		manageMessagesObj.clicksentItems();
		String editorTitle=manageMessagesObj.editorTitle();
		S1.assertEquals(editorTitle, "SENT ITEMS");
		
		for(int i=0;i<manageMessagesObj.verifySentItems().size();i++)
		{
			boolean flag=manageMessagesObj.verifySentItems().get(i);
			S1.assertTrue(flag);
		}
		
		ArrayList<String> listObj=new ArrayList<String>();
		listObj=manageMessagesObj.verifySelectedMsg();
		for(int i=0;i<listObj.size();i++)
			
		{
			S1.assertEquals(listObj.get(i), ExcelDataUtilObj.getData(sheetName8, i+1, 0));
		}
		testUtil.RefreshCurrentPage();
		
		List<WebElement> selectMsg=manageMessagesObj.verifyReadReply();
		for(int i=0;i<selectMsg.size();i++)
		{
			
			S1.assertEquals(selectMsg.get(i).getText(), ExcelDataUtilObj.getData(sheetName8, i+1, 1));
		}
		
		List<WebElement> startMonth=manageMessagesObj.verifyStartMonth();
		for(int i=0;i<startMonth.size();i++)
		{
			S1.assertEquals(startMonth.get(i).getText(),  ExcelDataUtilObj.getData(sheetName8, i+1, 2));
		}
		
		List<WebElement> endMonth=manageMessagesObj.verifyStartMonth();
		for(int i=0;i<endMonth.size();i++)
		{
			S1.assertEquals(endMonth.get(i).getText(),  ExcelDataUtilObj.getData(sheetName8, i+1, 2));
		}
		
		String iconLegend=manageMessagesObj.iconLegend();
		S1.assertEquals(iconLegend,"Icon Legend");
		
		String msgUnread=manageMessagesObj.msgUnread();
		S1.assertEquals(msgUnread,"Unread Message");
		
		
		String msgRead=manageMessagesObj.msgRead();
		S1.assertEquals(msgRead,"Read Message");
		
		
		String msgReplied=manageMessagesObj.msgReplied();
		S1.assertEquals(msgReplied,"Replied-to Message");
		
		
		String msgForward=manageMessagesObj.msgForward();
		S1.assertEquals(msgForward,"Forwarded Message");
		
		
		String msgDownload=manageMessagesObj.msgDownload();
		S1.assertEquals(msgDownload,"Download all Private Messages as");
		
		
		String linkXML=manageMessagesObj.linkXML();
		S1.assertEquals(linkXML,"XML");
		
		String linkCSV=manageMessagesObj.linkCSV();
		S1.assertEquals(linkCSV,"CSV");
		
		String linkText=manageMessagesObj.linkText();
		S1.assertEquals(linkText,"Text");
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();		
		System.out.println("User Name: Verified Inbox Messages");
		
	}
	
	
	@Test(priority=15)
	public void verifyTrackMsgFrmUN() throws InterruptedException
	{
//		memberListObj.clickIAgreeCookies();
		SoftAssert S1=new SoftAssert();
		testUtilObj.NavigateToContentPage();
		memberProfileObj.clicksendPrivateMsg();
		manageMessagesObj.clicktrackMsgs();
		String editorTitle=manageMessagesObj.editorTitle();
		S1.assertEquals(editorTitle, "MESSAGE TRACKING");
		
		String h1TrackMsgs=manageMessagesObj.h1TrackMsgs();
		S1.assertEquals(h1TrackMsgs, "Unconfirmed Private Message Receipts");
		
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		
		System.out.println("User Name: Verified Track Messages");
		
	}
	
	@Test(priority=16)
	public void verifyTrackMsgFrmPersonalMessage() throws InterruptedException
	{
//		memberListObj.clickIAgreeCookies();
		SoftAssert S1=new SoftAssert();
		
		testUtilObj.NavigateToInbox();
		manageMessagesObj.clicktrackMsgs();
		String editorTitle=manageMessagesObj.editorTitle();
		S1.assertEquals(editorTitle, "MESSAGE TRACKING");
		
		String h1TrackMsgs=manageMessagesObj.h1TrackMsgs();
		S1.assertEquals(h1TrackMsgs, "Unconfirmed Private Message Receipts");
		
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		
		System.out.println("Personal Message: Verified Track Messages");
		
	}
	
	@Test(priority=17)
	public void verifyEditFoldersUN() throws InterruptedException
	{
//		memberListObj.clickIAgreeCookies();
		SoftAssert S1=new SoftAssert();
		testUtilObj.NavigateToContentPage();
		memberProfileObj.clicksendPrivateMsg();
		
		manageMessagesObj.clickeditFolder();
		String editorTitle=manageMessagesObj.editorTitle();
		S1.assertEquals(editorTitle, "EDIT FOLDERS");
		
		String h2StdFolder=manageMessagesObj.h2StdFolder();
		S1.assertEquals(h2StdFolder, "Standard Folders");
			
		ArrayList<Boolean> listObj=new ArrayList<Boolean>();
		listObj=manageMessagesObj.verifyEditFolders();
		for(int i=0;i<listObj.size();i++)
		{
			S1.assertTrue(listObj.get(i));
		}
		
		manageMessagesObj.clicklinkInboxFolder();
		String navInbox=manageMessagesObj.editorTitle();
		S1.assertEquals(navInbox, "INBOX");
		testUtil.navigateToPreviouPage();
		
		
		manageMessagesObj.clicklinkemptyFolder1();
		String navEmptyFolder1=manageMessagesObj.editorTitle();
		S1.assertEquals(navEmptyFolder1, "CONFIRM DELETION");
		
		String navEmptyFolder2=manageMessagesObj.msgConfirmDeletion();
		S1.assertEquals(navEmptyFolder2, "Confirm Deletion");
		boolean flag=manageMessagesObj.btnYesConfirmDeletion();
		S1.assertTrue(flag);
		testUtil.navigateToPreviouPage();
		
		manageMessagesObj.clicklinkSentItems();
		String navsentItems=manageMessagesObj.editorTitle();
		S1.assertEquals(navsentItems, "SENT ITEMS");
		testUtil.navigateToPreviouPage();
		
		manageMessagesObj.clicklinkemptyFolder2();
		String navEmptyFolder3=manageMessagesObj.editorTitle();
		S1.assertEquals(navEmptyFolder3, "CONFIRM DELETION");
		
		String navEmptyFolder4=manageMessagesObj.msgConfirmDeletion();
		S1.assertEquals(navEmptyFolder4, "Confirm Deletion");
		boolean flag1=manageMessagesObj.btnYesConfirmDeletion();
		S1.assertTrue(flag1);
		testUtil.navigateToPreviouPage();
		
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		
		System.out.println("User name: Verified Edit Folders");
		
		
		
		
	}
	
	
	@Test(priority=18)
	public void verifyEditFoldersPersonalMsg() throws InterruptedException
	{
//		memberListObj.clickIAgreeCookies();
		SoftAssert S1=new SoftAssert();
		
		testUtilObj.NavigateToInbox();
		manageMessagesObj.clickeditFolder();
		String editorTitle=manageMessagesObj.editorTitle();
		S1.assertEquals(editorTitle, "EDIT FOLDERS");
		
		String h2StdFolder=manageMessagesObj.h2StdFolder();
		S1.assertEquals(h2StdFolder, "Standard Folders");
			
		ArrayList<Boolean> listObj=new ArrayList<Boolean>();
		listObj=manageMessagesObj.verifyEditFolders();
		for(int i=0;i<listObj.size();i++)
		{
			S1.assertTrue(listObj.get(i));
		}
		
		manageMessagesObj.clicklinkInboxFolder();
		String navInbox=manageMessagesObj.editorTitle();
		S1.assertEquals(navInbox, "INBOX");
		testUtil.navigateToPreviouPage();
		
		
		manageMessagesObj.clicklinkemptyFolder1();
		String navEmptyFolder1=manageMessagesObj.editorTitle();
		S1.assertEquals(navEmptyFolder1, "CONFIRM DELETION");
		
		String navEmptyFolder2=manageMessagesObj.msgConfirmDeletion();
		S1.assertEquals(navEmptyFolder2, "Confirm Deletion");
		boolean flag=manageMessagesObj.btnYesConfirmDeletion();
		S1.assertTrue(flag);
		testUtil.navigateToPreviouPage();
		
	
		
		
		manageMessagesObj.clicklinkSentItems();
		String navsentItems=manageMessagesObj.editorTitle();
		S1.assertEquals(navsentItems, "SENT ITEMS");
		testUtil.navigateToPreviouPage();
		
		manageMessagesObj.clicklinkemptyFolder2();
		String navEmptyFolder3=manageMessagesObj.editorTitle();
		S1.assertEquals(navEmptyFolder3, "CONFIRM DELETION");
		
		String navEmptyFolder4=manageMessagesObj.msgConfirmDeletion();
		S1.assertEquals(navEmptyFolder4, "Confirm Deletion");
		boolean flag1=manageMessagesObj.btnYesConfirmDeletion();
		S1.assertTrue(flag1);
		testUtil.navigateToPreviouPage();
		
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Personal Message: Verified Edit Folders");
	}
	@AfterClass
	public void TearDown()
	{
		driver.quit();
	}
}
