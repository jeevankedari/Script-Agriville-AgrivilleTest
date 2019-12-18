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
import com.agriville.qa.pages.memberProfile;
import com.agriville.qa.pages.searchTopic;
import com.agriville.qa.pages.topicDetails;
import com.agriville.qa.pages.updateProfileAndPwd;
import com.agriville.qa.util.ExcelDataUtil;
import com.agriville.qa.util.testUtil;

public class memberProfileTest extends TestBase 
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
	
	
	AddEditDeleteReply AddEditDeleteReplyObj;
	String Path = "E://Script Agriville//AgrivilleTest//src//main//java//com//agriville//qa//testdata//Agriville.xlsx";
	String sheetName = "Disc_Categories";
	String sheetName1 = "Disc_CategoriesLogin";
	String sheetName2 = "PostThread";
	String sheetName3 = "Reply";
	String sheetName4 = "EditProfile";
	String sheetName5 = "EditPassword";
	
	public memberProfileTest()
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
		AddEditDeleteReplyObj = new AddEditDeleteReply();
		ExcelDataUtilObj = new ExcelDataUtil(Path);
		AddEditDeleteTopicObj = new AddEditDeleteTopic();
		LatestPostObj=new LatestPost();
		updateProfileAndPwdObj= new updateProfileAndPwd();
		memberProfileObj=new memberProfile();
	}
	
	
	//Verify Member Profile page when user clicks on Welcome<Username> at the Top right corner
	@Test(priority=1)
	public void verifyMemberProfilePageUserName() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		AddEditDeleteTopicObj.clickProfileLink();
		
		String TabContent=memberProfileObj.tabContent();
		S1.assertEquals(TabContent, "Tab Content");
		
		String MyActivity=memberProfileObj.myActivity();
		S1.assertEquals(MyActivity, "My Activity");
		
		String VisitorMsg=memberProfileObj.visitorMsg();
		S1.assertEquals(VisitorMsg, "Visitor Messages");
		
		String AboutMe=memberProfileObj.aboutMe();
		S1.assertEquals(AboutMe, "About Me");
		
		String userNameOnDashBoard=memberProfileObj.userNameOnDashBoard();
		S1.assertEquals(userNameOnDashBoard, ExcelDataUtilObj.getData(sheetName1, 2, 0));
		
		String friendsDashBoard=memberProfileObj.friendsDashBoard();
		S1.assertEquals(friendsDashBoard, "Friends");
		
		String subscriptionsDashBoard=memberProfileObj.subscriptionsDashBoard();
		S1.assertEquals(subscriptionsDashBoard, "Subscriptions");
		
		String memberUserName=memberProfileObj.memberUserName();
		S1.assertEquals(memberUserName, ExcelDataUtilObj.getData(sheetName1, 2, 0));
		
		String sendPrivateMsg=memberProfileObj.sendPrivateMsg();
		S1.assertEquals(sendPrivateMsg, "Send Private Message");
		
		String findLatestPost=memberProfileObj.findLatestPost();
		S1.assertEquals(findLatestPost, "Find latest posts");
		
		String findLatestStartedThread=memberProfileObj.findLatestStartedThread();
		S1.assertEquals(findLatestStartedThread, "Find latest started threads");
		S1.assertAll();
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified Member Profile Page from User Name at the Top right");
		
	}
	
	
	
	//Verify Member Profile page when user clicks User Name on Home Page<Most Recent Thread>
		@Test(priority=2)
		public void verifyMemberProfilePageFrmMostRecentThread() throws InterruptedException
		{
			SoftAssert S1=new SoftAssert();
			memberProfileObj.clickByUNOnMostRecentThread();
			String msgLogin=memberProfileObj.MsgLogin();
			S1.assertEquals(msgLogin, "Welcome to Agriville! You need to login to post messages in the Agriville chat forums. Please login below.");
			
			loginPageObj.clickAgrivilleLogo();
			testUtilObj.loginWithActiveAccount();
			String UNOnMostRecentThreadHP=memberProfileObj.ByUNOnMostRecentThread();
//			String UNOnMostPopularTopics=memberProfileObj.ByUNonMostPopTopics();
			memberProfileObj.clickByUNOnMostRecentThread();
			String TabContent=memberProfileObj.tabContent();
			S1.assertEquals(TabContent, "Tab Content");
			
			String MyActivity=memberProfileObj.myActivity();
			S1.assertTrue(MyActivity.contains("Activity"));
			
			String AboutMe=memberProfileObj.aboutMe();
			S1.assertEquals(AboutMe, "About Me");
			
			String userNameOnDashBoard=memberProfileObj.userNameOnDashBoard();
			S1.assertEquals(userNameOnDashBoard, UNOnMostRecentThreadHP);
			
			String friendsDashBoard=memberProfileObj.friendsDashBoard();
			S1.assertEquals(friendsDashBoard, "Friends");
			
			
			String memberUserName=memberProfileObj.memberUserName();
			S1.assertEquals(memberUserName, UNOnMostRecentThreadHP);
			
			String addAsFriend=memberProfileObj.addAsFriend();
			S1.assertEquals(addAsFriend, "Add as Friend");
			
			String sendPrivateMsg=memberProfileObj.sendPrivateMsg();
			S1.assertEquals(sendPrivateMsg, "Send Private Message");
			
			String addToIgnore=memberProfileObj.addToIgnore();
			S1.assertEquals(addToIgnore, "Add to Ignore List");
			
			String findLatestPost=memberProfileObj.findLatestPost();
			S1.assertEquals(findLatestPost, "Find latest posts");
			
			String findLatestStartedThread=memberProfileObj.findLatestStartedThread();
			S1.assertEquals(findLatestStartedThread, "Find latest started threads");
			
			S1.assertAll();
			testUtilObj.logOut();
			loginPageObj.clickAgrivilleLogo();
			System.out.println("Verified Member Profile Page from Most Recent Threads");
		}
	
		
		//Verify Member Profile page when user clicks User Name on Home Page<Most Recent Topics>
		@Test(priority=3)
		public void verifyMemberProfilePageFrmMostRecentTopics() throws InterruptedException
		{
			SoftAssert S1=new SoftAssert();
			memberProfileObj.clickByByUNonMostPopTopics();
			String msgLogin=memberProfileObj.MsgLogin();
			S1.assertEquals(msgLogin, "Welcome to Agriville! You need to login to post messages in the Agriville chat forums. Please login below.");
			loginPageObj.clickAgrivilleLogo();
			testUtilObj.loginWithActiveAccount();
			//String UNOnMostRecentThreadHP=memberProfileObj.ByUNOnMostRecentThread();
			String UNOnMostPopularTopics=memberProfileObj.ByUNonMostPopTopics();
			memberProfileObj.clickByByUNonMostPopTopics();
			
			String TabContent=memberProfileObj.tabContent();
			S1.assertEquals(TabContent, "Tab Content");
			
			String MyActivity=memberProfileObj.myActivity();
			S1.assertTrue(MyActivity.contains("Activity"));
					
			String AboutMe=memberProfileObj.aboutMe();
			S1.assertEquals(AboutMe, "About Me");
					
			String userNameOnDashBoard=memberProfileObj.userNameOnDashBoard();
			S1.assertEquals(userNameOnDashBoard, UNOnMostPopularTopics);
					
			String friendsDashBoard=memberProfileObj.friendsDashBoard();
			S1.assertEquals(friendsDashBoard, "Friends");
					
					
			String memberUserName=memberProfileObj.memberUserName();
			S1.assertEquals(memberUserName, UNOnMostPopularTopics);
					
			String addAsFriend=memberProfileObj.addAsFriend();
			S1.assertEquals(addAsFriend, "Add as Friend");
					
			String sendPrivateMsg=memberProfileObj.sendPrivateMsg();
			S1.assertEquals(sendPrivateMsg, "Send Private Message");
					
			String addToIgnore=memberProfileObj.addToIgnore();
			S1.assertEquals(addToIgnore, "Add to Ignore List");
					
			String findLatestPost=memberProfileObj.findLatestPost();
			S1.assertEquals(findLatestPost, "Find latest posts");
					
			String findLatestStartedThread=memberProfileObj.findLatestStartedThread();
			S1.assertEquals(findLatestStartedThread, "Find latest started threads");
					
			S1.assertAll();
			testUtilObj.logOut();
			loginPageObj.clickAgrivilleLogo();
			System.out.println("Verified Member Profile Page from Most Recent Threads");
	}
					
		
		//Verify Member Profile page when user clicks Author on Topic Page
		//Click on any Forum--> Click on first author and verify the Member Profile Page
		@Test(priority=4)
		public void verifyMemberProfilePageFrmTopicsAuthor() throws InterruptedException
		{
			SoftAssert S1=new SoftAssert();
			searchTopicObj.clickBeefProd();
			String FirstAuthor=memberProfileObj.firstAuthor();
			memberProfileObj.clickfirstAuthor();
			
			String msgLogin=memberProfileObj.MsgLogin();
			S1.assertEquals(msgLogin, "Welcome to Agriville! You need to login to post messages in the Agriville chat forums. Please login below.");
			loginPageObj.clickAgrivilleLogo();
			testUtilObj.loginWithActiveAccount();
			searchTopicObj.clickBeefProd();
			memberProfileObj.clickfirstAuthor();
			
			String TabContent=memberProfileObj.tabContent();
			S1.assertEquals(TabContent, "Tab Content");
			
			String MyActivity=memberProfileObj.myActivity();
			S1.assertTrue(MyActivity.contains("Activity"));
					
			String AboutMe=memberProfileObj.aboutMe();
			S1.assertEquals(AboutMe, "About Me");
					
			String userNameOnDashBoard=memberProfileObj.userNameOnDashBoard();
			S1.assertTrue(FirstAuthor. contains(userNameOnDashBoard));
					
			String friendsDashBoard=memberProfileObj.friendsDashBoard();
			S1.assertEquals(friendsDashBoard, "Friends");
					
					
			String memberUserName=memberProfileObj.memberUserName();
			S1.assertTrue(FirstAuthor.contains(memberUserName));
			//S1.assertEquals(memberUserName, FirstAuthor);
					
			String addAsFriend=memberProfileObj.addAsFriend();
			S1.assertEquals(addAsFriend, "Add as Friend");
					
			String sendPrivateMsg=memberProfileObj.sendPrivateMsg();
			S1.assertEquals(sendPrivateMsg, "Send Private Message");
					
			String addToIgnore=memberProfileObj.addToIgnore();
			S1.assertEquals(addToIgnore, "Add to Ignore List");
					
			String findLatestPost=memberProfileObj.findLatestPost();
			S1.assertEquals(findLatestPost, "Find latest posts");
					
			String findLatestStartedThread=memberProfileObj.findLatestStartedThread();
			S1.assertEquals(findLatestStartedThread, "Find latest started threads");
					
			S1.assertAll();
			testUtilObj.logOut();
			loginPageObj.clickAgrivilleLogo();
			System.out.println("Author:Verified Member Profile Page from Topic Details Page");
			
			
		}
		
		//Verify Member Profile page when user clicks User Name on Topic Page
		//Click on any Forum--> Click on first User Name and verify the Member Profile Page
		@Test(priority=5)
		public void verifyMemberProfilePageFrmTopicsUserName() throws InterruptedException
		{	
			SoftAssert S1=new SoftAssert();
			searchTopicObj.clickBeefProd();
			String firstUserName=memberProfileObj.firstUserName();
			memberProfileObj.clickfirstUserName();
			
			String msgLogin=memberProfileObj.MsgLogin();
			S1.assertEquals(msgLogin, "Welcome to Agriville! You need to login to post messages in the Agriville chat forums. Please login below.");
			loginPageObj.clickAgrivilleLogo();
			testUtilObj.loginWithActiveAccount();
			searchTopicObj.clickBeefProd();
			memberProfileObj.clickfirstUserName();
			
			
			String TabContent=memberProfileObj.tabContent();
			S1.assertEquals(TabContent, "Tab Content");
			
			String MyActivity=memberProfileObj.myActivity();
			S1.assertEquals(MyActivity, "My Activity");
			
			String VisitorMsg=memberProfileObj.visitorMsg();
			S1.assertEquals(VisitorMsg, "Visitor Messages");
			
			String AboutMe=memberProfileObj.aboutMe();
			S1.assertEquals(AboutMe, "About Me");
			
			String userNameOnDashBoard=memberProfileObj.userNameOnDashBoard();
			S1.assertTrue(firstUserName.contains(userNameOnDashBoard));
			
			
			String friendsDashBoard=memberProfileObj.friendsDashBoard();
			S1.assertEquals(friendsDashBoard, "Friends");
			
			String subscriptionsDashBoard=memberProfileObj.subscriptionsDashBoard();
			S1.assertEquals(subscriptionsDashBoard, "Subscriptions");
			
			String memberUserName=memberProfileObj.memberUserName();
			S1.assertTrue(firstUserName.contains(memberUserName));
			
			
			String sendPrivateMsg=memberProfileObj.sendPrivateMsg();
			S1.assertEquals(sendPrivateMsg, "Send Private Message");
			
			String findLatestPost=memberProfileObj.findLatestPost();
			S1.assertEquals(findLatestPost, "Find latest posts");
			
			String findLatestStartedThread=memberProfileObj.findLatestStartedThread();
			S1.assertEquals(findLatestStartedThread, "Find latest started threads");
			S1.assertAll();
			testUtilObj.logOut();
			loginPageObj.clickAgrivilleLogo();
			System.out.println("User Name:Verified Member Profile Page from Topic Details Page");
		}
		
		
		//Verify Member Profile page when user clicks User Name under Thread/Title Started
		//Enter Keyword and click on search button
		//Click on First Author under Thread/Title Starter
		@Test(priority=6)
		public void verifyMemberProfilePageFrmUNThreadTitle_Search() throws InterruptedException
		{
			SoftAssert S1 = new SoftAssert();
			topicDetailsObj.EnterDataSearchBx(ExcelDataUtilObj.getData(sheetName, 1, 4));
			topicDetailsObj.clickBtnSearch();
			String FirstUserNameSearchResult=memberProfileObj.firstUserNameSearchResult();
			memberProfileObj.clickfirstUserNameSearchResult();
		
		
						
			String msgLogin=memberProfileObj.MsgLogin();
			S1.assertEquals(msgLogin, "Welcome to Agriville! You need to login to post messages in the Agriville chat forums. Please login below.");
			loginPageObj.clickAgrivilleLogo();
			testUtilObj.loginWithActiveAccount();
					
			topicDetailsObj.EnterDataSearchBx(ExcelDataUtilObj.getData(sheetName, 1, 4));
			topicDetailsObj.clickBtnSearch();
			memberProfileObj.clickfirstUserNameSearchResult();
						
			String TabContent=memberProfileObj.tabContent();
			S1.assertEquals(TabContent, "Tab Content");
			
			String MyActivity=memberProfileObj.myActivity();
			S1.assertTrue(MyActivity.contains("Activity"));
					
			String AboutMe=memberProfileObj.aboutMe();
			S1.assertEquals(AboutMe, "About Me");
					
			String userNameOnDashBoard=memberProfileObj.userNameOnDashBoard();
			S1.assertTrue(FirstUserNameSearchResult. contains(userNameOnDashBoard));
					
			String friendsDashBoard=memberProfileObj.friendsDashBoard();
			S1.assertEquals(friendsDashBoard, "Friends");
					
					
			String memberUserName=memberProfileObj.memberUserName();
			S1.assertTrue(FirstUserNameSearchResult.contains(memberUserName));
			//S1.assertEquals(memberUserName, FirstAuthor);
					
			String addAsFriend=memberProfileObj.addAsFriend();
			S1.assertEquals(addAsFriend, "Add as Friend");
					
			String sendPrivateMsg=memberProfileObj.sendPrivateMsg();
			S1.assertEquals(sendPrivateMsg, "Send Private Message");
					
			String addToIgnore=memberProfileObj.addToIgnore();
			S1.assertEquals(addToIgnore, "Add to Ignore List");
					
			String findLatestPost=memberProfileObj.findLatestPost();
			S1.assertEquals(findLatestPost, "Find latest posts");
					
			String findLatestStartedThread=memberProfileObj.findLatestStartedThread();
			S1.assertEquals(findLatestStartedThread, "Find latest started threads");
					
			S1.assertAll();
			testUtilObj.logOut();
			loginPageObj.clickAgrivilleLogo();
			System.out.println("Author:Verified Member Profile Page from Search Result page");
			
			
		}
		
		//Verify Member Profile page when user clicks user name under Last Post By
		//Enter Keyword and click  on search button
		//Click on First User Name under Last Post By
		@Test(priority=7)
		public void verifyMemberProfilePageFrmLastPostThreadTitle_Search() throws InterruptedException
		{		
			
		SoftAssert S1 = new SoftAssert();
		searchTopicObj.clickBeefProd();
		topicDetailsObj.clickH2FirstSubCategory();
		String FirstLastPostByOnSearchResult=topicDetailsObj.FirstLastPostByOnSearchResult();
		topicDetailsObj.clickFirstLastPostByOnSearchResult();
	
		String msgLogin=memberProfileObj.MsgLogin();
		S1.assertEquals(msgLogin, "Welcome to Agriville! You need to login to post messages in the Agriville chat forums. Please login below.");
		loginPageObj.clickAgrivilleLogo();
		testUtilObj.loginWithActiveAccount();
				
		topicDetailsObj.EnterDataSearchBx(ExcelDataUtilObj.getData(sheetName, 1, 4));
		topicDetailsObj.clickBtnSearch();
		topicDetailsObj.clickFirstLastPostByOnSearchResult();
		String TabContent=memberProfileObj.tabContent();
		S1.assertEquals(TabContent, "Tab Content");
		
		String MyActivity=memberProfileObj.myActivity();
		S1.assertEquals(MyActivity, "My Activity");
		
		String VisitorMsg=memberProfileObj.visitorMsg();
		S1.assertEquals(VisitorMsg, "Visitor Messages");
		
		String AboutMe=memberProfileObj.aboutMe();
		S1.assertEquals(AboutMe, "About Me");
		
		String userNameOnDashBoard=memberProfileObj.userNameOnDashBoard();
		S1.assertTrue(FirstLastPostByOnSearchResult.contains(userNameOnDashBoard));
				
		String friendsDashBoard=memberProfileObj.friendsDashBoard();
		S1.assertEquals(friendsDashBoard, "Friends");
		
		String subscriptionsDashBoard=memberProfileObj.subscriptionsDashBoard();
		S1.assertEquals(subscriptionsDashBoard, "Subscriptions");
		
		String memberUserName=memberProfileObj.memberUserName();
		S1.assertTrue(FirstLastPostByOnSearchResult.contains(memberUserName));
		
		String sendPrivateMsg=memberProfileObj.sendPrivateMsg();
		S1.assertEquals(sendPrivateMsg, "Send Private Message");
		
		String findLatestPost=memberProfileObj.findLatestPost();
		S1.assertEquals(findLatestPost, "Find latest posts");
		
		String findLatestStartedThread=memberProfileObj.findLatestStartedThread();
		S1.assertEquals(findLatestStartedThread, "Find latest started threads");
		S1.assertAll();
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("User Name:Verified Member Profile Page from Search Result page");
			
		}
		
		

		//Verify Member Profile page On Thread Details Page
		//Click on Beef Production and click on First Thread 
		//Click on First Author
		@Test(priority=8)
		public void verifyMemberProfilePageThreadDetails() throws InterruptedException
		{
		SoftAssert S1 = new SoftAssert();
		searchTopicObj.clickBeefProd();
		topicDetailsObj.clickH2FirstSubCategory();
		String firstAuthorOnThreadDetails=memberProfileObj.firstAuthorOnThreadDetails();
		memberProfileObj.clickfirstAuthorOnThreadDetails();
		String msgLogin=memberProfileObj.MsgLogin();
		S1.assertEquals(msgLogin, "Welcome to Agriville! You need to login to post messages in the Agriville chat forums. Please login below.");
		loginPageObj.clickAgrivilleLogo();
		testUtilObj.loginWithActiveAccount();
				
		searchTopicObj.clickBeefProd();
		topicDetailsObj.clickH2FirstSubCategory();
		memberProfileObj.clickfirstAuthorOnThreadDetails();
					
		String TabContent=memberProfileObj.tabContent();
		S1.assertEquals(TabContent, "Tab Content");
		
		String MyActivity=memberProfileObj.myActivity();
		S1.assertTrue(MyActivity.contains("Activity"));
				
		String AboutMe=memberProfileObj.aboutMe();
		S1.assertEquals(AboutMe, "About Me");
				
		String userNameOnDashBoard=memberProfileObj.userNameOnDashBoard();
		S1.assertTrue(firstAuthorOnThreadDetails. contains(userNameOnDashBoard));
				
		String friendsDashBoard=memberProfileObj.friendsDashBoard();
		S1.assertEquals(friendsDashBoard, "Friends");
				
				
		String memberUserName=memberProfileObj.memberUserName();
		S1.assertTrue(firstAuthorOnThreadDetails.contains(memberUserName));
		//S1.assertEquals(memberUserName, FirstAuthor);
				
		String addAsFriend=memberProfileObj.addAsFriend();
		S1.assertEquals(addAsFriend, "Add as Friend");
				
		String sendPrivateMsg=memberProfileObj.sendPrivateMsg();
		S1.assertEquals(sendPrivateMsg, "Send Private Message");
				
		String addToIgnore=memberProfileObj.addToIgnore();
		S1.assertEquals(addToIgnore, "Add to Ignore List");
				
		String findLatestPost=memberProfileObj.findLatestPost();
		S1.assertEquals(findLatestPost, "Find latest posts");
				
		String findLatestStartedThread=memberProfileObj.findLatestStartedThread();
		S1.assertEquals(findLatestStartedThread, "Find latest started threads");
				
		S1.assertAll();
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("Author:Verified Member Profile Page from Thread Details Page");
}
	
		//Verify Member Profile page On Thread View Page
		//Enter keyword and click on search button
		//Click on View Button and click on First Author
		@Test(priority=9)
		public void verifyMemberProfilePageThreadDetails_View() throws InterruptedException
		{
		SoftAssert S1 = new SoftAssert();
		topicDetailsObj.EnterDataSearchBx(ExcelDataUtilObj.getData(sheetName, 1, 4));
		topicDetailsObj.clickBtnSearch();
		topicDetailsObj.clickBtnFirstView();
	
		String firstAuthorOnThreadDetails=memberProfileObj.firstAuthorOnThreadDetails();
		memberProfileObj.clickfirstAuthorOnThreadDetails();
		
		String msgLogin=memberProfileObj.MsgLogin();
		S1.assertEquals(msgLogin, "Welcome to Agriville! You need to login to post messages in the Agriville chat forums. Please login below.");
		loginPageObj.clickAgrivilleLogo();
		testUtilObj.loginWithActiveAccount();
						
		topicDetailsObj.EnterDataSearchBx(ExcelDataUtilObj.getData(sheetName, 1, 4));
		topicDetailsObj.clickBtnSearch();
		topicDetailsObj.clickBtnFirstView();
		memberProfileObj.clickfirstAuthorOnThreadDetails();					
		String TabContent=memberProfileObj.tabContent();
		S1.assertEquals(TabContent, "Tab Content");
				
		String MyActivity=memberProfileObj.myActivity();
		S1.assertTrue(MyActivity.contains("Activity"));
						
		String AboutMe=memberProfileObj.aboutMe();
		S1.assertEquals(AboutMe, "About Me");
						
		String userNameOnDashBoard=memberProfileObj.userNameOnDashBoard();
		S1.assertTrue(firstAuthorOnThreadDetails. contains(userNameOnDashBoard));
						
		String friendsDashBoard=memberProfileObj.friendsDashBoard();
		S1.assertEquals(friendsDashBoard, "Friends");
						
		String memberUserName=memberProfileObj.memberUserName();
		S1.assertTrue(firstAuthorOnThreadDetails.contains(memberUserName));
		//S1.assertEquals(memberUserName, FirstAuthor);
						
		String addAsFriend=memberProfileObj.addAsFriend();
		S1.assertEquals(addAsFriend, "Add as Friend");
						
		String sendPrivateMsg=memberProfileObj.sendPrivateMsg();
		S1.assertEquals(sendPrivateMsg, "Send Private Message");
						
		String addToIgnore=memberProfileObj.addToIgnore();
		S1.assertEquals(addToIgnore, "Add to Ignore List");
						
		String findLatestPost=memberProfileObj.findLatestPost();
		S1.assertEquals(findLatestPost, "Find latest posts");
						
		String findLatestStartedThread=memberProfileObj.findLatestStartedThread();
		S1.assertEquals(findLatestStartedThread, "Find latest started threads");
						
		S1.assertAll();
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("Author:Verified Member Profile Page from Thread View Page");
		}	
	
		
	@AfterClass
	public void TearDown()
	{
		driver.quit();
	}
	
	

}
