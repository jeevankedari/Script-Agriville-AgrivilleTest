package com.agriville.qa.testcases;

import java.util.ArrayList;
import java.util.Collections;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.agriville.qa.base.TestBase;
import com.agriville.qa.pages.AddEditDeleteReply;
import com.agriville.qa.pages.AddEditDeleteTopic;
import com.agriville.qa.pages.LatestPost;
import com.agriville.qa.pages.homePageAgriville;
import com.agriville.qa.pages.loginPage;
import com.agriville.qa.pages.memberList;
import com.agriville.qa.pages.memberProfile;
import com.agriville.qa.pages.searchTopic;
import com.agriville.qa.pages.topicDetails;
import com.agriville.qa.pages.updateProfileAndPwd;
import com.agriville.qa.util.ExcelDataUtil;
import com.agriville.qa.util.testUtil;

public class memberListTest extends TestBase
{
	topicDetails topicDetailsObj;
	ExcelDataUtil ExcelDataUtilObj;
	loginPage loginPageObj;
	AddEditDeleteTopic AddEditDeleteTopicObj;
	searchTopic searchTopicObj;
	testUtil testUtilObj;
	LatestPost LatestPostObj;
	updateProfileAndPwd updateProfileAndPwdObj;
	memberProfile memberProfileObj;
	memberList memberListObj;
	homePageAgriville homePageAgrivilleObj;
	
	
	AddEditDeleteReply AddEditDeleteReplyObj;
	String Path = "E://Script Agriville//AgrivilleTest//src//main//java//com//agriville//qa//testdata//Agriville.xlsx";
	String sheetName = "Disc_Categories";
	String sheetName1 = "Disc_CategoriesLogin";
	String sheetName2 = "PostThread";
	String sheetName3 = "Reply";
	String sheetName4 = "EditProfile";
	String sheetName5 = "EditPassword";
	String sheetName6 = "MemberList";
	
	public memberListTest()
	{
		super();
	}
	
	@BeforeClass
	public void SetUp() 
	{
		intialization();
		topicDetailsObj = new topicDetails();
		searchTopicObj = new searchTopic();
		// testUtilObj=new testUtil();
		loginPageObj = new loginPage();
		testUtilObj = new testUtil();
		homePageAgrivilleObj=new homePageAgriville();
		AddEditDeleteReplyObj = new AddEditDeleteReply();
		ExcelDataUtilObj = new ExcelDataUtil(Path);
		AddEditDeleteTopicObj = new AddEditDeleteTopic();
		LatestPostObj=new LatestPost();
		updateProfileAndPwdObj= new updateProfileAndPwd();
		memberProfileObj=new memberProfile();
		memberListObj=new memberList();
	}
	
	@Test(priority=1)
	public void verifyNavigationToListFromHP() throws InterruptedException
	{
		memberListObj.clickIAgreeCookies();
		SoftAssert S1=new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		AddEditDeleteTopicObj.clickProfileLink();
		memberProfileObj.clicksendPrivateMsg();
		String H1SendPvtMsg=memberListObj.H1SendPvtMsg();
		S1.assertEquals(H1SendPvtMsg, "SEND NEW PRIVATE MESSAGE","Send New Message Not Found");
		//updateProfileAndPwdObj.clickdownArrow();
		memberListObj.clearRecipients();
		memberListObj.Title(ExcelDataUtilObj.getData(sheetName6, 1, 1));
		memberListObj.RTBxEditor(ExcelDataUtilObj.getData(sheetName6, 1, 2));
		memberListObj.clickBtnSubmitMsg();
		memberListObj.clickLinkmemberList();
		testUtil.Switch_To_ChildTab();
		String MemberListTitle=memberListObj.MemberListTitle();
		
		S1.assertEquals(MemberListTitle, "Member List","Member List Not Found");
		testUtil.Close_Tab_Switch_To_ParentTab();
		S1.assertAll();
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("HomePage: Verified user is navigated to Member List Page from Home Page");
		
	}
	
	@Test(priority=2)
	public void verifyNavigationToListFromPersonalMsg() throws InterruptedException
	{
		//memberListObj.clickIAgreeCookies();
		SoftAssert S1=new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		//AddEditDeleteTopicObj.clickProfileLink();
		updateProfileAndPwdObj.clickdownArrow();
		memberListObj.clickPersonalMsg();
		memberListObj.ClickInboxSendMsg();
		//memberProfileObj.clicksendPrivateMsg();
		String H1SendPvtMsg=memberListObj.H1SendPvtMsg();
		S1.assertEquals(H1SendPvtMsg, "SEND NEW PRIVATE MESSAGE","Send New Private Message Not found");
		
		memberListObj.clearRecipients();
		memberListObj.Title(ExcelDataUtilObj.getData(sheetName6, 1, 1));
		memberListObj.RTBxEditor(ExcelDataUtilObj.getData(sheetName6, 1, 2));
		memberListObj.clickBtnSubmitMsg();
		memberListObj.clickLinkmemberList();
		testUtil.Switch_To_ChildTab();
		String MemberListTitle=memberListObj.MemberListTitle();
		
		S1.assertEquals(MemberListTitle, "Member List","Member List Not Found");
		testUtil.Close_Tab_Switch_To_ParentTab();
		
		
		S1.assertAll();
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("Personal Message: Verified user is navigated to Member List Page from Personal Page");
		
	}
	
	
	@Test(priority=3)
	public void verifyMemberListPageFrmHP() throws InterruptedException
	{
		//memberListObj.clickIAgreeCookies();
		SoftAssert S1=new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		AddEditDeleteTopicObj.clickProfileLink();
		memberProfileObj.clicksendPrivateMsg();
		memberListObj.clearRecipients();
		memberListObj.Title(ExcelDataUtilObj.getData(sheetName6, 1, 1));
		memberListObj.RTBxEditor(ExcelDataUtilObj.getData(sheetName6, 1, 2));
		memberListObj.clickBtnSubmitMsg();
		memberListObj.clickLinkmemberList();
		testUtil.Switch_To_ChildTab();
		
		
		
		
		for(int i=0; i<memberListObj.ElementOnMemberList().size();i++)
		{
			S1.assertTrue(memberListObj.ElementOnMemberList().get(i));
		}
		String MemberListTitle=memberListObj.MemberListTitle();
		S1.assertEquals(MemberListTitle, "Member List","Member List Not found");
		
		String LinkForum=memberListObj.LinkForum();
		S1.assertEquals(LinkForum, "Forum","Forum Link not Found");
		
		String LblForum=memberListObj.LblForum();
		S1.assertEquals(LblForum, "Filter Results","Filter Results not Found");
		
		String H2MembersList=memberListObj.H2MembersList();
		S1.assertEquals(H2MembersList, "Members of Farming and Agriculture Discussion Forum | Agriville.com","Title is Incorrect");
		
		String DDquickNavi=memberListObj.DDquickNavi();
		S1.assertEquals(DDquickNavi, "Member List","Dropdown Title is incorrect");
		
		String FilterResult=memberListObj.FilterResult();
		S1.assertEquals(FilterResult, "Filter Results","Filter Results not found");
		
		String LinkUserName=memberListObj.LinkUserName();
		S1.assertEquals(LinkUserName, "User Name","User Name not found");
		
		String LinkSearchMem=memberListObj.LinkSearchMem();
		S1.assertEquals(LinkSearchMem, "Search Members","Search Members not found");
		
		String linkTop=memberListObj.linkTop();
		S1.assertEquals(linkTop, "Top","Top link not found");
				
		String linkPosts=memberListObj.linkPosts();
		S1.assertEquals(linkPosts, "Posts","Posts column Not found");
		
		String linkAvatar=memberListObj.linkAvatar();
		S1.assertEquals(linkAvatar, "Avatar","Avatar column not found");
		
		
		
		
		
		S1.assertAll();
		testUtil.Close_Tab_Switch_To_ParentTab();
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("Home Page: Verified Members Page ");
	}
	
	@Test(priority=4)
	public void verifyMemberListPageFrmPersonalMsg() throws InterruptedException
	{
		//memberListObj.clickIAgreeCookies();
		SoftAssert S1=new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		updateProfileAndPwdObj.clickdownArrow();
		memberListObj.clickPersonalMsg();
		memberListObj.ClickInboxSendMsg();
		memberListObj.clearRecipients();
		memberListObj.Title(ExcelDataUtilObj.getData(sheetName6, 1, 1));
		memberListObj.RTBxEditor(ExcelDataUtilObj.getData(sheetName6, 1, 2));
		memberListObj.clickBtnSubmitMsg();
		memberListObj.clickLinkmemberList();
		testUtil.Switch_To_ChildTab();
		
		for(int i=0; i<memberListObj.ElementOnMemberList().size();i++)
		{
			S1.assertTrue(memberListObj.ElementOnMemberList().get(i));
		}
		String MemberListTitle=memberListObj.MemberListTitle();
		S1.assertEquals(MemberListTitle, "Member List", "Member List Not Found");
		
		String LinkForum=memberListObj.LinkForum();
		S1.assertEquals(LinkForum, "Forum","Forum Link Not Found");
		
		String LblForum=memberListObj.LblForum();
		S1.assertEquals(LblForum, "Filter Results","Filter Results not found");
		
		String H2MembersList=memberListObj.H2MembersList();
		S1.assertEquals(H2MembersList, "Members of Farming and Agriculture Discussion Forum | Agriville.com","Member List not Foune");
		
		String DDquickNavi=memberListObj.DDquickNavi();
		S1.assertEquals(DDquickNavi, "Member List","Dropdown Member List Not found");
		
		String FilterResult=memberListObj.FilterResult();
		S1.assertEquals(FilterResult, "Filter Results","Filter Results Link not found");
		
		String LinkUserName=memberListObj.LinkUserName();
		S1.assertEquals(LinkUserName, "User Name","User Name link not found");
		
		String LinkSearchMem=memberListObj.LinkSearchMem();
		S1.assertEquals(LinkSearchMem, "Search Members","Search Member Not found");
		
		String linkPosts=memberListObj.linkPosts();
		S1.assertEquals(linkPosts, "Posts","Link Posts not Found");
		
		
		String linkAvatar=memberListObj.linkAvatar();
		S1.assertEquals(linkAvatar, "Avatar","Avatar Not Found");
		
		String linkTop=memberListObj.linkTop();
		S1.assertEquals(linkTop, "Top","Top link Not Found");
		
		
		
		
		
		
		S1.assertAll();
		testUtil.Close_Tab_Switch_To_ParentTab();
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("Personal Message: Verified Members Page ");
	}
	
	@Test(priority=5)
	public void verifyForumFromHP() throws InterruptedException
	{
		//memberListObj.clickIAgreeCookies();
		SoftAssert S1=new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		AddEditDeleteTopicObj.clickProfileLink();
		memberProfileObj.clicksendPrivateMsg();
		memberListObj.clearRecipients();
		memberListObj.Title(ExcelDataUtilObj.getData(sheetName6, 1, 1));
		memberListObj.RTBxEditor(ExcelDataUtilObj.getData(sheetName6, 1, 2));
		memberListObj.clickBtnSubmitMsg();
		memberListObj.clickLinkmemberList();
		testUtil.Switch_To_ChildTab();
		memberListObj.clickLinkForum();
		
		String DiscCategoriesH1=homePageAgrivilleObj.DiscCategoriesH1();
		S1.assertEquals(DiscCategoriesH1, "DISCUSSION CATEGORIES", "First SoftAssert Failed");
		String MostRecentThreadsH2OnHP=homePageAgrivilleObj.MostRecentThreadsH2OnHP();
		S1.assertEquals(MostRecentThreadsH2OnHP,"MOST RECENT THREADS" );
		String HPTitle= testUtil.getTitleOfPage();
		S1.assertEquals(HPTitle, "Farming and Agriculture Discussion Forum | Agriville.com");
		
		
		S1.assertAll();
		testUtil.Close_Tab_Switch_To_ParentTab();
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("Home Page: Verified the Navigation to Forum from Member List");
	}
	
	@Test(priority=6)
	public void verifyForumFrmPersonalMsg() throws InterruptedException
	{
		//memberListObj.clickIAgreeCookies();
		SoftAssert S1=new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		updateProfileAndPwdObj.clickdownArrow();
		memberListObj.clickPersonalMsg();
		memberListObj.ClickInboxSendMsg();
		memberListObj.clearRecipients();
		memberListObj.Title(ExcelDataUtilObj.getData(sheetName6, 1, 1));
		memberListObj.RTBxEditor(ExcelDataUtilObj.getData(sheetName6, 1, 2));
		memberListObj.clickBtnSubmitMsg();
		memberListObj.clickLinkmemberList();
		testUtil.Switch_To_ChildTab();
		memberListObj.clickLinkForum();
		
		String DiscCategoriesH1=homePageAgrivilleObj.DiscCategoriesH1();
		S1.assertEquals(DiscCategoriesH1, "DISCUSSION CATEGORIES", "First SoftAssert Failed");
		String MostRecentThreadsH2OnHP=homePageAgrivilleObj.MostRecentThreadsH2OnHP();
		S1.assertEquals(MostRecentThreadsH2OnHP,"MOST RECENT THREADS" );
		String HPTitle= testUtil.getTitleOfPage();
		S1.assertEquals(HPTitle, "Farming and Agriculture Discussion Forum1 | Agriville.com");
		
		
		
		S1.assertAll();
		testUtil.Close_Tab_Switch_To_ParentTab();
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("Personal Message: Verified the Navigation to Forum from Member List");
	}
	
	@Test(priority=7)
	public void verifySortUserNameFrmUserNameAsc() throws InterruptedException
	{
		//memberListObj.clickIAgreeCookies();
		SoftAssert S1=new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		AddEditDeleteTopicObj.clickProfileLink();
		memberProfileObj.clicksendPrivateMsg();
		memberListObj.clearRecipients();
		memberListObj.Title(ExcelDataUtilObj.getData(sheetName6, 1, 1));
		memberListObj.RTBxEditor(ExcelDataUtilObj.getData(sheetName6, 1, 2));
		memberListObj.clickBtnSubmitMsg();
		memberListObj.clickLinkmemberList();
		testUtil.Switch_To_ChildTab();
		
		memberListObj.clickLinkUserName();
		memberListObj.clickLinkUserName();
		ArrayList<String> listObtain=new ArrayList<String>();
		listObtain=memberListObj.UNonMemberList();
		System.out.println("Click Sort "+listObtain);
		memberListObj.clickLinkUserName();
		memberListObj.clickLinkUserName();
		ArrayList<String> listObtain1=new ArrayList<String>();
		listObtain1=memberListObj.UNonMemberList();
		
		for(int i=0;i<listObtain.size();i++)
		{
			S1.assertTrue(listObtain.get(i).equals(listObtain1.get(i)));	
		}
		System.out.println("Click Sort "+listObtain1);
		S1.assertAll();
		testUtil.Close_Tab_Switch_To_ParentTab();
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
	}
	
	@Test(priority=8)
	public void verifySortUserNameFrmUserNameDsc() throws InterruptedException
	{
	//	memberListObj.clickIAgreeCookies();
		SoftAssert S1=new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		AddEditDeleteTopicObj.clickProfileLink();
		memberProfileObj.clicksendPrivateMsg();
		memberListObj.clearRecipients();
		memberListObj.Title(ExcelDataUtilObj.getData(sheetName6, 1, 1));
		memberListObj.RTBxEditor(ExcelDataUtilObj.getData(sheetName6, 1, 2));
		memberListObj.clickBtnSubmitMsg();
		memberListObj.clickLinkmemberList();
		testUtil.Switch_To_ChildTab();
		
		
		memberListObj.clickLinkUserName();
		ArrayList<String> listObtain=new ArrayList<String>();
		listObtain=memberListObj.UNonMemberList();
		System.out.println("Click Sort "+listObtain);
		memberListObj.clickLinkUserName();
		memberListObj.clickLinkUserName();
		ArrayList<String> listObtain1=new ArrayList<String>();
		listObtain1=memberListObj.UNonMemberList();
		
		for(int i=0;i<listObtain.size();i++)
		{
			S1.assertTrue(listObtain.get(i).equals(listObtain1.get(i)));	
		}
		
		S1.assertAll();
		testUtil.Close_Tab_Switch_To_ParentTab();
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
	}
	
	@Test(priority=9)
	public void verifySortUserNameFrmPersonalMsgAsc() throws InterruptedException
	{
		//memberListObj.clickIAgreeCookies();
		SoftAssert S1=new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		updateProfileAndPwdObj.clickdownArrow();
		memberListObj.clickPersonalMsg();
		memberListObj.ClickInboxSendMsg();
		memberListObj.clearRecipients();
		memberListObj.Title(ExcelDataUtilObj.getData(sheetName6, 1, 1));
		memberListObj.RTBxEditor(ExcelDataUtilObj.getData(sheetName6, 1, 2));
		memberListObj.clickBtnSubmitMsg();
		memberListObj.clickLinkmemberList();
		testUtil.Switch_To_ChildTab();
		
		memberListObj.clickLinkUserName();
		memberListObj.clickLinkUserName();
		ArrayList<String> listObtain=new ArrayList<String>();
		listObtain=memberListObj.UNonMemberList();
		System.out.println("Click Sort "+listObtain);
		memberListObj.clickLinkUserName();
		memberListObj.clickLinkUserName();
		ArrayList<String> listObtain1=new ArrayList<String>();
		listObtain1=memberListObj.UNonMemberList();
		
		for(int i=0;i<listObtain.size();i++)
		{
			S1.assertTrue(listObtain.get(i).equals(listObtain1.get(i)));	
		}
		System.out.println("Click Sort "+listObtain1);
		S1.assertAll();
		testUtil.Close_Tab_Switch_To_ParentTab();
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
	}
	
	
	@Test(priority=10)
	public void verifySortUserNameFrmPersonalMsgDsc() throws InterruptedException
	{
	//	memberListObj.clickIAgreeCookies();
		SoftAssert S1=new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		updateProfileAndPwdObj.clickdownArrow();
		memberListObj.clickPersonalMsg();
		memberListObj.ClickInboxSendMsg();
		memberListObj.clearRecipients();
		memberListObj.Title(ExcelDataUtilObj.getData(sheetName6, 1, 1));
		memberListObj.RTBxEditor(ExcelDataUtilObj.getData(sheetName6, 1, 2));
		memberListObj.clickBtnSubmitMsg();
		memberListObj.clickLinkmemberList();
		testUtil.Switch_To_ChildTab();
		
		
		memberListObj.clickLinkUserName();
		ArrayList<String> listObtain=new ArrayList<String>();
		listObtain=memberListObj.UNonMemberList();
		System.out.println("Click Sort "+listObtain);
		memberListObj.clickLinkUserName();
		memberListObj.clickLinkUserName();
		ArrayList<String> listObtain1=new ArrayList<String>();
		listObtain1=memberListObj.UNonMemberList();
		System.out.println("Click Sort "+listObtain1);
		for(int i=0;i<listObtain.size();i++)
		{
			S1.assertTrue(listObtain.get(i).equals(listObtain1.get(i)));	
		}
		
		S1.assertAll();
		testUtil.Close_Tab_Switch_To_ParentTab();
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
	}
	
	
	
	
	@Test(priority=11)
	public void verifySortPostFrmUserNameAsc() throws InterruptedException
	{
		memberListObj.clickIAgreeCookies();
		SoftAssert S1=new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		AddEditDeleteTopicObj.clickProfileLink();
		memberProfileObj.clicksendPrivateMsg();
		memberListObj.clearRecipients();
		memberListObj.Title(ExcelDataUtilObj.getData(sheetName6, 1, 1));
		memberListObj.RTBxEditor(ExcelDataUtilObj.getData(sheetName6, 1, 2));
		memberListObj.clickBtnSubmitMsg();
		memberListObj.clickLinkmemberList();
		testUtil.Switch_To_ChildTab();
		
		memberListObj.clicklinkPosts();
		memberListObj.clicklinkPosts();
		ArrayList<String> listObtain=new ArrayList<String>();
		listObtain=memberListObj.NumberOfPostMemberList();
		System.out.println("Click Sort "+listObtain);
		memberListObj.clicklinkPosts();
		memberListObj.clicklinkPosts();
		ArrayList<String> listObtain1=new ArrayList<String>();
		listObtain1=memberListObj.NumberOfPostMemberList();
		
		for(int i=0;i<listObtain.size();i++)
		{
			S1.assertTrue(listObtain.get(i).equals(listObtain1.get(i)));	
		}
		System.out.println("Click Sort "+listObtain1);
		S1.assertAll();
		testUtil.Close_Tab_Switch_To_ParentTab();
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
	}
	
	@Test(priority=12)
	public void verifySortPostFrmUserNameDsc() throws InterruptedException
	{
		//memberListObj.clickIAgreeCookies();
		SoftAssert S1=new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		AddEditDeleteTopicObj.clickProfileLink();
		memberProfileObj.clicksendPrivateMsg();
		memberListObj.clearRecipients();
		memberListObj.Title(ExcelDataUtilObj.getData(sheetName6, 1, 1));
		memberListObj.RTBxEditor(ExcelDataUtilObj.getData(sheetName6, 1, 2));
		memberListObj.clickBtnSubmitMsg();
		memberListObj.clickLinkmemberList();
		testUtil.Switch_To_ChildTab();
		
		
		memberListObj.clicklinkPosts();
		ArrayList<String> listObtain=new ArrayList<String>();
		listObtain=memberListObj.NumberOfPostMemberList();
		System.out.println("Click Sort "+listObtain);
		memberListObj.clicklinkPosts();
		memberListObj.clicklinkPosts();
		ArrayList<String> listObtain1=new ArrayList<String>();
		listObtain1=memberListObj.NumberOfPostMemberList();
		
		for(int i=0;i<listObtain.size();i++)
		{
			S1.assertTrue(listObtain.get(i).equals(listObtain1.get(i)));	
		}
		
		S1.assertAll();
		testUtil.Close_Tab_Switch_To_ParentTab();
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
	}
	
	
	@Test(priority=13)
	public void verifySortPostFrmPersonalMsgAsc() throws InterruptedException
	{
		//memberListObj.clickIAgreeCookies();
		SoftAssert S1=new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		updateProfileAndPwdObj.clickdownArrow();
		memberListObj.clickPersonalMsg();
		memberListObj.ClickInboxSendMsg();
		memberListObj.clearRecipients();
		memberListObj.Title(ExcelDataUtilObj.getData(sheetName6, 1, 1));
		memberListObj.RTBxEditor(ExcelDataUtilObj.getData(sheetName6, 1, 2));
		memberListObj.clickBtnSubmitMsg();
		memberListObj.clickLinkmemberList();
		testUtil.Switch_To_ChildTab();
		
		memberListObj.clicklinkPosts();
		memberListObj.clicklinkPosts();
		ArrayList<String> listObtain=new ArrayList<String>();
		listObtain=memberListObj.NumberOfPostMemberList();
		System.out.println("Click Sort "+listObtain);
		memberListObj.clicklinkPosts();
		memberListObj.clicklinkPosts();
		ArrayList<String> listObtain1=new ArrayList<String>();
		listObtain1=memberListObj.NumberOfPostMemberList();
		
		
		for(int i=0;i<listObtain.size();i++)
		{
			S1.assertTrue(listObtain.get(i).equals(listObtain1.get(i)));	
		}
		System.out.println("Click Sort "+listObtain1);
		S1.assertAll();
		testUtil.Close_Tab_Switch_To_ParentTab();
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
	}
	
	@Test(priority=14)
	public void verifySortPostsFrmPersonalMsgDsc() throws InterruptedException
	{
		//memberListObj.clickIAgreeCookies();
		SoftAssert S1=new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		updateProfileAndPwdObj.clickdownArrow();
		memberListObj.clickPersonalMsg();
		memberListObj.ClickInboxSendMsg();
		memberListObj.clearRecipients();
		memberListObj.Title(ExcelDataUtilObj.getData(sheetName6, 1, 1));
		memberListObj.RTBxEditor(ExcelDataUtilObj.getData(sheetName6, 1, 2));
		memberListObj.clickBtnSubmitMsg();
		memberListObj.clickLinkmemberList();
		testUtil.Switch_To_ChildTab();
		
		
		memberListObj.clicklinkPosts();
		ArrayList<String> listObtain=new ArrayList<String>();
		listObtain=memberListObj.NumberOfPostMemberList();
		System.out.println("Click Sort "+listObtain);
		memberListObj.clicklinkPosts();
		memberListObj.clicklinkPosts();
		ArrayList<String> listObtain1=new ArrayList<String>();
		listObtain1=memberListObj.NumberOfPostMemberList();
		System.out.println("Click Sort "+listObtain1);
		for(int i=0;i<listObtain.size();i++)
		{
			S1.assertTrue(listObtain.get(i).equals(listObtain1.get(i)));	
		}
		
		S1.assertAll();
		testUtil.Close_Tab_Switch_To_ParentTab();
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
	}
	
	@AfterClass
	public void TearDown()
	{
		driver.quit();
	}
	
	
	
	
	
	
	
}
