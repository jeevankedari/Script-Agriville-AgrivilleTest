package com.agriville.qa.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.agriville.qa.base.TestBase;
import com.agriville.qa.pages.AddEditDeleteReply;
import com.agriville.qa.pages.AddEditDeleteTopic;
import com.agriville.qa.pages.LatestPost;
import com.agriville.qa.pages.loginPage;
import com.agriville.qa.pages.searchTopic;
import com.agriville.qa.pages.topicDetails;
import com.agriville.qa.util.ExcelDataUtil;
import com.agriville.qa.util.testUtil;

public class LatestPostTest extends TestBase
{
	topicDetails topicDetailsObj;
	ExcelDataUtil ExcelDataUtilObj;
	loginPage loginPageObj;
	AddEditDeleteTopic AddEditDeleteTopicObj;
	searchTopic searchTopicObj;
	testUtil testUtilObj;
	LatestPost LatestPostObj;
	
	AddEditDeleteReply AddEditDeleteReplyObj;
	String Path = "E://Script Agriville//AgrivilleTest//src//main//java//com//agriville//qa//testdata//Agriville.xlsx";
	String sheetName = "Disc_Categories";
	String sheetName1 = "Disc_CategoriesLogin";
	String sheetName2 = "PostThread";
	String sheetName3 = "Reply";
	
	
	@BeforeClass
	public void SetUp() 
	{
		intialization();
		topicDetailsObj = new topicDetails();
		searchTopicObj = new searchTopic();
		// testUtilObj=new testUtil();
		loginPageObj = new loginPage();
		testUtilObj = new testUtil();
		AddEditDeleteReplyObj = new AddEditDeleteReply();
		ExcelDataUtilObj = new ExcelDataUtil(Path);
		AddEditDeleteTopicObj = new AddEditDeleteTopic();
		LatestPostObj=new LatestPost();
	}

	
	@Test(priority=1)
	public void verifyMemberPage() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		AddEditDeleteTopicObj.clickProfileLink();
		String NameOfMember=searchTopicObj.NameOfMember();
		String NameOfMemberFrmExcel=ExcelDataUtilObj.getData(sheetName1, 2, 0);
		S1.assertEquals(NameOfMember, NameOfMemberFrmExcel);
		
		String SendPrivateMsgAct=LatestPostObj.SendPrivateMsg();
		S1.assertEquals(SendPrivateMsgAct, "Send Private Message");
		
		String FindLatestPost=LatestPostObj.FindLatestPost();
		S1.assertEquals(FindLatestPost, "Find latest posts");
		
		String FindLatestStartedThread=LatestPostObj.FindLatestStartedThread();
		S1.assertEquals(FindLatestStartedThread, "Find latest started threads");
		
		String myActivity=LatestPostObj.myActivity();
		S1.assertEquals(myActivity, "My Activity");
		
		String visitorMsgs=LatestPostObj.visitorMsgs();
		S1.assertEquals(visitorMsgs, "Visitor Messages");

		String aboutMe=LatestPostObj.aboutMe();
		S1.assertEquals(aboutMe, "About Me");
		
		String User=LatestPostObj.User();
		S1.assertEquals(User, NameOfMemberFrmExcel);
		
		String Friends=LatestPostObj.Friends();
		S1.assertEquals(Friends, "Friends");
		
		String Subscriptions=LatestPostObj.Subscriptions();
		S1.assertEquals(Subscriptions, "Subscriptions");
		S1.assertAll();
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified Member Page");
			
	}
	
	@Test(priority=2)
	public void verifyLatestPostWithNoData() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		AddEditDeleteTopicObj.clickProfileLink();
		LatestPostObj.clickFindLatestPost();
		String MsgNoPost=LatestPostObj.MsgNoPost();
		S1.assertEquals(MsgNoPost, "Sorry - no matches. Please try some different terms.");
		
		
	}
	
	
	@AfterClass
	public void TearDown() {
		driver.quit();
	}

}
