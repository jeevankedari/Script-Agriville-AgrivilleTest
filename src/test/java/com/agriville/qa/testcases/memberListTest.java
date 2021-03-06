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
	String sheetName7="QuickNavigation";
	
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
		memberListObj.clickBtnSubmit();
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
		memberListObj.clickBtnSubmit();
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
		memberListObj.clickBtnSubmit();
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
		memberListObj.clickBtnSubmit();
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
		memberListObj.clickBtnSubmit();
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
		memberListObj.clickBtnSubmit();
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
		memberListObj.clickBtnSubmit();
		memberListObj.clickLinkmemberList();
		testUtil.Switch_To_ChildTab();
		
		memberListObj.clickLinkUserName();
		memberListObj.clickLinkUserName();
		ArrayList<String> listObtain=new ArrayList<String>();
		listObtain=memberListObj.UNonMemberList();
		////System.out.println("Click Sort "+listObtain);
		memberListObj.clickLinkUserName();
		memberListObj.clickLinkUserName();
		ArrayList<String> listObtain1=new ArrayList<String>();
		listObtain1=memberListObj.UNonMemberList();
		
		for(int i=0;i<listObtain.size();i++)
		{
			S1.assertTrue(listObtain.get(i).equals(listObtain1.get(i)));	
		}
		//System.out.println("Click Sort "+listObtain1);
		S1.assertAll();
		testUtil.Close_Tab_Switch_To_ParentTab();
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("UserName: Verified the Member List in Ascending Order");
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
		memberListObj.clickBtnSubmit();
		memberListObj.clickLinkmemberList();
		testUtil.Switch_To_ChildTab();
		
		
		memberListObj.clickLinkUserName();
		ArrayList<String> listObtain=new ArrayList<String>();
		listObtain=memberListObj.UNonMemberList();
		//System.out.println("Click Sort "+listObtain);
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
		
		System.out.println("UserName: Verified the Member List in Descending Order");
		
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
		memberListObj.clickBtnSubmit();
		memberListObj.clickLinkmemberList();
		testUtil.Switch_To_ChildTab();
		
		memberListObj.clickLinkUserName();
		memberListObj.clickLinkUserName();
		ArrayList<String> listObtain=new ArrayList<String>();
		listObtain=memberListObj.UNonMemberList();
		//System.out.println("Click Sort "+listObtain);
		memberListObj.clickLinkUserName();
		memberListObj.clickLinkUserName();
		ArrayList<String> listObtain1=new ArrayList<String>();
		listObtain1=memberListObj.UNonMemberList();
		
		for(int i=0;i<listObtain.size();i++)
		{
			S1.assertTrue(listObtain.get(i).equals(listObtain1.get(i)));	
		}
		//System.out.println("Click Sort "+listObtain1);
		S1.assertAll();
		testUtil.Close_Tab_Switch_To_ParentTab();
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		
		System.out.println("Personal Message: Verified the Member List in Ascending Order");
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
		memberListObj.clickBtnSubmit();
		memberListObj.clickLinkmemberList();
		testUtil.Switch_To_ChildTab();
		
		
		memberListObj.clickLinkUserName();
		ArrayList<String> listObtain=new ArrayList<String>();
		listObtain=memberListObj.UNonMemberList();
		//System.out.println("Click Sort "+listObtain);
		memberListObj.clickLinkUserName();
		memberListObj.clickLinkUserName();
		ArrayList<String> listObtain1=new ArrayList<String>();
		listObtain1=memberListObj.UNonMemberList();
		//System.out.println("Click Sort "+listObtain1);
		for(int i=0;i<listObtain.size();i++)
		{
			S1.assertTrue(listObtain.get(i).equals(listObtain1.get(i)));	
		}
		
		S1.assertAll();
		testUtil.Close_Tab_Switch_To_ParentTab();
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("Personal Messge: Verified the Member List in Descending Order");
	}
	
	
	
	
	@Test(priority=11)
	public void verifySortPostFrmUserNameAsc() throws InterruptedException
	{
		//memberListObj.clickIAgreeCookies();
		SoftAssert S1=new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		AddEditDeleteTopicObj.clickProfileLink();
		memberProfileObj.clicksendPrivateMsg();
		memberListObj.clearRecipients();
		memberListObj.Title(ExcelDataUtilObj.getData(sheetName6, 1, 1));
		memberListObj.RTBxEditor(ExcelDataUtilObj.getData(sheetName6, 1, 2));
		memberListObj.clickBtnSubmit();
		memberListObj.clickLinkmemberList();
		testUtil.Switch_To_ChildTab();
		
		memberListObj.clicklinkPosts();
		memberListObj.clicklinkPosts();
		ArrayList<String> listObtain=new ArrayList<String>();
		listObtain=memberListObj.NumberOfPostMemberList();
		//System.out.println("Click Sort "+listObtain);
		memberListObj.clicklinkPosts();
		memberListObj.clicklinkPosts();
		ArrayList<String> listObtain1=new ArrayList<String>();
		listObtain1=memberListObj.NumberOfPostMemberList();
		
		for(int i=0;i<listObtain.size();i++)
		{
			S1.assertTrue(listObtain.get(i).equals(listObtain1.get(i)));	
		}
		//System.out.println("Click Sort "+listObtain1);
		S1.assertAll();
		testUtil.Close_Tab_Switch_To_ParentTab();
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("UserName: Verified the Member List in Ascending Order");
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
		memberListObj.clickBtnSubmit();
		memberListObj.clickLinkmemberList();
		testUtil.Switch_To_ChildTab();
		
		
		memberListObj.clicklinkPosts();
		ArrayList<String> listObtain=new ArrayList<String>();
		listObtain=memberListObj.NumberOfPostMemberList();
		//System.out.println("Click Sort "+listObtain);
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
		System.out.println("UserName: Verified the Member List in Descending Order");
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
		memberListObj.clickBtnSubmit();
		memberListObj.clickLinkmemberList();
		testUtil.Switch_To_ChildTab();
		
		memberListObj.clicklinkPosts();
		memberListObj.clicklinkPosts();
		ArrayList<String> listObtain=new ArrayList<String>();
		listObtain=memberListObj.NumberOfPostMemberList();
		//System.out.println("Click Sort "+listObtain);
		memberListObj.clicklinkPosts();
		memberListObj.clicklinkPosts();
		ArrayList<String> listObtain1=new ArrayList<String>();
		listObtain1=memberListObj.NumberOfPostMemberList();
		
		
		for(int i=0;i<listObtain.size();i++)
		{
			S1.assertTrue(listObtain.get(i).equals(listObtain1.get(i)));	
		}
		//System.out.println("Click Sort "+listObtain1);
		S1.assertAll();
		testUtil.Close_Tab_Switch_To_ParentTab();
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("Personal Message: Verified the Member List in Ascending Order");
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
		memberListObj.clickBtnSubmit();
		memberListObj.clickLinkmemberList();
		testUtil.Switch_To_ChildTab();
		
		
		memberListObj.clicklinkPosts();
		ArrayList<String> listObtain=new ArrayList<String>();
		listObtain=memberListObj.NumberOfPostMemberList();
		//System.out.println("Click Sort "+listObtain);
		memberListObj.clicklinkPosts();
		memberListObj.clicklinkPosts();
		ArrayList<String> listObtain1=new ArrayList<String>();
		listObtain1=memberListObj.NumberOfPostMemberList();
		//System.out.println("Click Sort "+listObtain1);
		for(int i=0;i<listObtain.size();i++)
		{
			S1.assertTrue(listObtain.get(i).equals(listObtain1.get(i)));	
		}
		
		S1.assertAll();
		testUtil.Close_Tab_Switch_To_ParentTab();
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("Personal Message: Verified the Member List in Descending Order");
	}
	
	@Test(priority=15)
	public void verifyPaginationFrmPersonalMsg() throws InterruptedException
	{
		memberListObj.clickIAgreeCookies();
		SoftAssert S1=new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		updateProfileAndPwdObj.clickdownArrow();
		memberListObj.clickPersonalMsg();
		memberListObj.ClickInboxSendMsg();
		memberListObj.clearRecipients();
		memberListObj.Title(ExcelDataUtilObj.getData(sheetName6, 1, 1));
		memberListObj.RTBxEditor(ExcelDataUtilObj.getData(sheetName6, 1, 2));
		memberListObj.clickBtnSubmit();
		memberListObj.clickLinkmemberList();
		testUtil.Switch_To_ChildTab();
		
		//Navigation to second Page
		String secondPage=memberListObj.clickOnSecondPage();
		S1.assertEquals(secondPage, "2");
		
		//Navigation to First Page
		String firstPage=memberListObj.clickOnFirstPage();
		S1.assertEquals(firstPage, "1");
		
		//Click on Next Button
		memberListObj.clickBtnNext();
		String nextBtn=memberListObj.getValueNextBtn();
		S1.assertEquals(nextBtn, "2");
		
		//Navigation to First Page
		String previouspage=memberListObj.clickOnFirstPage();
		S1.assertEquals(previouspage, "1");
		
		//Navigation using Last Arrow Button
		memberListObj.clickBtnLast();
		
		//Navigation to First Page
		String firstPage1=memberListObj.getValueLastBtn();
		S1.assertEquals(firstPage1, "1");
		
		//Navigation using previous Button
		memberListObj.clickOnSecondPage();
		memberListObj.clickBtnPrevious();
		String previousBtn=memberListObj.getValuePreviousBtn();
		S1.assertEquals(previousBtn, "1");
		
		//Navigation using First Arrow Button Button
		memberListObj.clickOnSecondPage();
		String nextBtn1=memberListObj.getValueNextBtn();
		S1.assertEquals(nextBtn1, "2");
		memberListObj.clickBtnFirst();
		
		S1.assertAll();
		testUtil.Close_Tab_Switch_To_ParentTab();
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		
		System.out.println("Personal Message:Verified the Navigation on Members Page ");
		
		
		
	}
	
	@Test(priority=16)
	public void verifyPaginationFrmUserName() throws InterruptedException
	{
		memberListObj.clickIAgreeCookies();
		SoftAssert S1=new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		AddEditDeleteTopicObj.clickProfileLink();
		memberProfileObj.clicksendPrivateMsg();
		memberListObj.clearRecipients();
		memberListObj.Title(ExcelDataUtilObj.getData(sheetName6, 1, 1));
		memberListObj.RTBxEditor(ExcelDataUtilObj.getData(sheetName6, 1, 2));
		memberListObj.clickBtnSubmit();
		memberListObj.clickLinkmemberList();
		testUtil.Switch_To_ChildTab();
		
		//Navigation to second Page
		String secondPage=memberListObj.clickOnSecondPage();
		S1.assertEquals(secondPage, "2");
		
		//Navigation to First Page
		String firstPage=memberListObj.clickOnFirstPage();
		S1.assertEquals(firstPage, "1");
		
		//Click on Next Button
		memberListObj.clickBtnNext();
		String nextBtn=memberListObj.getValueNextBtn();
		S1.assertEquals(nextBtn, "2");
		
		//Navigation to First Page
		String previouspage=memberListObj.clickOnFirstPage();
		S1.assertEquals(previouspage, "1");
		
		//Navigation using Last Arrow Button
		memberListObj.clickBtnLast();
		
		//Navigation to First Page
		String firstPage1=memberListObj.getValueLastBtn();
		S1.assertEquals(firstPage1, "1");
		
		//Navigation using previous Button
		memberListObj.clickOnSecondPage();
		memberListObj.clickBtnPrevious();
		String previousBtn=memberListObj.getValuePreviousBtn();
		S1.assertEquals(previousBtn, "1");
		
		//Navigation using First Arrow Button Button
		memberListObj.clickOnSecondPage();
		String nextBtn1=memberListObj.getValueNextBtn();
		S1.assertEquals(nextBtn1, "2");
		memberListObj.clickBtnFirst();
		
		S1.assertAll();
		testUtil.Close_Tab_Switch_To_ParentTab();
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		
		System.out.println("User Name: Verified the Navigation on Members Page ");
		
		
		
	}
	
	@Test(priority=17)
	public void verifyNavigationDropdownFrmPersonalMessage() throws InterruptedException
	{
		memberListObj.clickIAgreeCookies();
		SoftAssert S1=new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		updateProfileAndPwdObj.clickdownArrow();
		memberListObj.clickPersonalMsg();
		memberListObj.ClickInboxSendMsg();
		memberListObj.clearRecipients();
		memberListObj.Title(ExcelDataUtilObj.getData(sheetName6, 1, 1));
		memberListObj.RTBxEditor(ExcelDataUtilObj.getData(sheetName6, 1, 2));
		memberListObj.clickBtnSubmit();
		memberListObj.clickLinkmemberList();
		testUtil.Switch_To_ChildTab();
		
		testUtil.Scroll_DownFull_Page();
		memberListObj.clickquickNavigationBtm();
		
		ArrayList<String> listObj=memberListObj.getListsiteAreas();
		
		for(int i=0;i<listObj.size();i++)
		{
			String str=ExcelDataUtilObj.getData(sheetName7, i+1, 0);
			S1.assertEquals(listObj.get(i), ExcelDataUtilObj.getData(sheetName7, i+1, 0));
		}
		
		String AgrivilleComunication=memberListObj.AgrivilleComunication();
		S1.assertTrue(AgrivilleComunication.contains("Agriville.com"));
		ArrayList<String> listObj1=memberListObj.getListForums();
		
		for(int i=0;i<listObj1.size();i++)
		{
			
			S1.assertEquals(listObj1.get(i), ExcelDataUtilObj.getData(sheetName7, i+1, 1));
		}
	
		
		S1.assertAll();
		testUtil.Close_Tab_Switch_To_ParentTab();
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("Personal Message: Verified the Values in Navigation Dropdown ");
	}
	
	
	@Test(priority=18)
	public void verifyNavigationDropdownFrmUserName() throws InterruptedException
	{
		memberListObj.clickIAgreeCookies();
		SoftAssert S1=new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		AddEditDeleteTopicObj.clickProfileLink();
		memberProfileObj.clicksendPrivateMsg();
		memberListObj.clearRecipients();
		memberListObj.Title(ExcelDataUtilObj.getData(sheetName6, 1, 1));
		memberListObj.RTBxEditor(ExcelDataUtilObj.getData(sheetName6, 1, 2));
		memberListObj.clickBtnSubmit();
		memberListObj.clickLinkmemberList();
		testUtil.Switch_To_ChildTab();
		testUtil.Scroll_DownFull_Page();
		memberListObj.clickquickNavigationBtm();
		
		ArrayList<String> listObj=memberListObj.getListsiteAreas();
		
		for(int i=0;i<listObj.size();i++)
		{
			String str=ExcelDataUtilObj.getData(sheetName7, i+1, 0);
			S1.assertEquals(listObj.get(i), ExcelDataUtilObj.getData(sheetName7, i+1, 0));
		}
		
		String AgrivilleComunication=memberListObj.AgrivilleComunication();
		S1.assertTrue(AgrivilleComunication.contains("Agriville.com"));
		ArrayList<String> listObj1=memberListObj.getListForums();
		
		for(int i=0;i<listObj1.size();i++)
		{
			
			S1.assertEquals(listObj1.get(i), ExcelDataUtilObj.getData(sheetName7, i+1, 1));
		}
	
		
		S1.assertAll();
		testUtil.Close_Tab_Switch_To_ParentTab();
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("UserName: Verified the Values in Navigation Dropdown ");
	}
	
	
	@Test(priority=19)
	public void verifyNavigationFromSiteAreasFrmPersonalMsg() throws InterruptedException
	{
		memberListObj.clickIAgreeCookies();
		SoftAssert S1=new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		updateProfileAndPwdObj.clickdownArrow();
		memberListObj.clickPersonalMsg();
		memberListObj.ClickInboxSendMsg();
		memberListObj.clearRecipients();
		memberListObj.Title(ExcelDataUtilObj.getData(sheetName6, 1, 1));
		memberListObj.RTBxEditor(ExcelDataUtilObj.getData(sheetName6, 1, 2));
		memberListObj.clickBtnSubmit();
		memberListObj.clickLinkmemberList();
		testUtil.Switch_To_ChildTab();
		
		testUtil.Scroll_DownFull_Page();
		memberListObj.clickquickNavigationBtm();
		ArrayList<String> ListAreas=memberListObj.clickListsiteAreas();
		
		for(int i=0;i<ListAreas.size();i++)
		{
//			String str=ExcelDataUtilObj.getData(sheetName7, i+1, 2);
			S1.assertEquals(ListAreas.get(i), ExcelDataUtilObj.getData(sheetName7, i+1, 2));
		}
		
		ArrayList<String> ListAreas1=memberListObj.clickListsiteAreas1();
		
		for(int i=0;i<ListAreas1.size();i++)
		{
			
//			String str=ExcelDataUtilObj.getData(sheetName7, i+4, 2);
			S1.assertEquals(ListAreas1.get(i), ExcelDataUtilObj.getData(sheetName7, i+4, 2));
		}
		
		memberListObj.clickquickNavigationBtm();
		memberListObj.clickforumHome();
		String getTitle=testUtil.getTitleOfPage();
		S1.assertEquals(getTitle, "Farming and Agriculture Discussion Forum | Agriville.com");
		testUtil.navigateToPreviouPage();
		memberListObj.clickquickNavigationBtm();
		memberListObj.clickAgrivilleComunication();
		String TitleThread=searchTopicObj.ColThreadTitleStarter();
		S1.assertEquals(TitleThread,"TITLE / THREAD STARTER");
		String Author=searchTopicObj.ColAuthor();
		S1.assertEquals(Author,"AUTHOR");
		String ReplyViews=memberListObj.ColRepliesView();
		S1.assertEquals(ReplyViews,"REPLIES");
		String LastPostBy=searchTopicObj.ColLastPostBy();
		S1.assertEquals(LastPostBy,"LAST POST BY");
		testUtil.navigateToPreviouPage();
		
		S1.assertAll();
		testUtil.Close_Tab_Switch_To_ParentTab();
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("Personal Message: Verified the Navigation Dropdown ");
	}
	
	
	@Test(priority=20)
	public void verifyNavigationFromSiteAreasFrmUserName() throws InterruptedException
	{
		memberListObj.clickIAgreeCookies();
		SoftAssert S1=new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		AddEditDeleteTopicObj.clickProfileLink();
		memberProfileObj.clicksendPrivateMsg();
		memberListObj.clearRecipients();
		memberListObj.Title(ExcelDataUtilObj.getData(sheetName6, 1, 1));
		memberListObj.RTBxEditor(ExcelDataUtilObj.getData(sheetName6, 1, 2));
		memberListObj.clickBtnSubmit();
		memberListObj.clickLinkmemberList();
		testUtil.Switch_To_ChildTab();
		
		testUtil.Scroll_DownFull_Page();
		memberListObj.clickquickNavigationBtm();
		ArrayList<String> ListAreas=memberListObj.clickListsiteAreas();
		
		for(int i=0;i<ListAreas.size();i++)
		{
//			String str=ExcelDataUtilObj.getData(sheetName7, i+1, 2);
			S1.assertEquals(ListAreas.get(i), ExcelDataUtilObj.getData(sheetName7, i+1, 2));
		}
		
		ArrayList<String> ListAreas1=memberListObj.clickListsiteAreas1();
		
		for(int i=0;i<ListAreas1.size();i++)
		{
			
//			String str=ExcelDataUtilObj.getData(sheetName7, i+4, 2);
			S1.assertEquals(ListAreas1.get(i), ExcelDataUtilObj.getData(sheetName7, i+4, 2));
		}
		
		memberListObj.clickquickNavigationBtm();
		memberListObj.clickforumHome();
		String getTitle=testUtil.getTitleOfPage();
		S1.assertEquals(getTitle, "Farming and Agriculture Discussion Forum | Agriville.com");
		testUtil.navigateToPreviouPage();
		memberListObj.clickquickNavigationBtm();
		memberListObj.clickAgrivilleComunication();
		String TitleThread=searchTopicObj.ColThreadTitleStarter();
		S1.assertEquals(TitleThread,"TITLE / THREAD STARTER");
		String Author=searchTopicObj.ColAuthor();
		S1.assertEquals(Author,"AUTHOR");
		String ReplyViews=memberListObj.ColRepliesView();
		S1.assertEquals(ReplyViews,"REPLIES");
		String LastPostBy=searchTopicObj.ColLastPostBy();
		S1.assertEquals(LastPostBy,"LAST POST BY");
		testUtil.navigateToPreviouPage();
		
		S1.assertAll();
		testUtil.Close_Tab_Switch_To_ParentTab();
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("Home Page:Verified the Navigation Dropdown ");
	}
	@Test(priority=21)
	public void verifyNavigationFromForumsFrmPersonalMsg() throws InterruptedException
	{
		memberListObj.clickIAgreeCookies();
		SoftAssert S1=new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		updateProfileAndPwdObj.clickdownArrow();
		memberListObj.clickPersonalMsg();
		memberListObj.ClickInboxSendMsg();
		memberListObj.clearRecipients();
		memberListObj.Title(ExcelDataUtilObj.getData(sheetName6, 1, 1));
		memberListObj.RTBxEditor(ExcelDataUtilObj.getData(sheetName6, 1, 2));
		memberListObj.clickBtnSubmit();
		memberListObj.clickLinkmemberList();
		testUtil.Switch_To_ChildTab();
		
		testUtil.Scroll_DownFull_Page();

		ArrayList<String> ListForums=memberListObj.clickListForums();
		for(int i=0;i<ListForums.size();i++)
		{
			S1.assertEquals(ListForums.get(i), ExcelDataUtilObj.getData(sheetName7, i+1, 3));
		}
		
		
		
		
		S1.assertAll();
		testUtil.Close_Tab_Switch_To_ParentTab();
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("Personal Message: Verified the Navigation Dropdown ");
	}
	
	@Test(priority=22)
	public void verifyNavigationFromForumsFrmUserName() throws InterruptedException
	{
		memberListObj.clickIAgreeCookies();
		SoftAssert S1=new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		AddEditDeleteTopicObj.clickProfileLink();
		memberProfileObj.clicksendPrivateMsg();
		memberListObj.clearRecipients();
		memberListObj.Title(ExcelDataUtilObj.getData(sheetName6, 1, 1));
		memberListObj.RTBxEditor(ExcelDataUtilObj.getData(sheetName6, 1, 2));
		memberListObj.clickBtnSubmit();
		memberListObj.clickLinkmemberList();
		testUtil.Switch_To_ChildTab();
		
		testUtil.Scroll_DownFull_Page();

		ArrayList<String> ListForums=memberListObj.clickListForums();
		for(int i=0;i<ListForums.size();i++)
		{
			S1.assertEquals(ListForums.get(i), ExcelDataUtilObj.getData(sheetName7, i+1, 3));
		}
		
		
		
		
		S1.assertAll();
		testUtil.Close_Tab_Switch_To_ParentTab();
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("User Name: Verified the Navigation Dropdown ");
	}
	
	
	
	@AfterClass
	public void TearDown()
	{
		driver.quit();
	}
	
	
	
	
	
	
	
}
