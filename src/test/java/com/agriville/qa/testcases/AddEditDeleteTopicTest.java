package com.agriville.qa.testcases;

import java.util.ArrayList;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.agriville.qa.base.TestBase;
import com.agriville.qa.pages.AddEditDeleteTopic;
import com.agriville.qa.pages.loginPage;
import com.agriville.qa.pages.searchTopic;
import com.agriville.qa.pages.topicDetails;
import com.agriville.qa.util.ExcelDataUtil;
import com.agriville.qa.util.testUtil;

public class AddEditDeleteTopicTest extends TestBase 
{
	//Need to Write Test Case for Verifying Title on Edit Page
	//The Code for Verifying Title is not Implemented 
	//The Title can be Saved with Blank Name
	AddEditDeleteTopic AddEditDeleteTopicObj;
	topicDetails topicDetailsObj;
	ExcelDataUtil ExcelDataUtilObj;
	loginPage loginPageObj;
	
	searchTopic searchTopicObj;
	testUtil testUtilObj;
	String Path="E://Script Agriville//AgrivilleTest//src//main//java//com//agriville//qa//testdata//Agriville.xlsx";
	String sheetName="Disc_Categories";
	String sheetName1="Disc_CategoriesLogin";
	String sheetName2="PostThread";

	public AddEditDeleteTopicTest()
	{
		super();
	}
	
	@BeforeClass
	public void SetUp()
	{
		intialization();
		topicDetailsObj = new topicDetails();
		searchTopicObj=new searchTopic();
		//testUtilObj=new testUtil();
		
		loginPageObj=new loginPage();
		testUtilObj=new testUtil();
		AddEditDeleteTopicObj=new AddEditDeleteTopic();
		ExcelDataUtilObj=new ExcelDataUtil(Path);
		
	}
	
	
	
	
	
	//Verify Post A New Thread Page for InActive Accounts
	@Test(priority=1)
	public void verifyPostANewThread_ActiveAcc() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		searchTopicObj.clickBeefProd();
		searchTopicObj.clickBtnPostAThread();
		String Str1=searchTopicObj.H1PostNewThread();
		S1.assertEquals(Str1, "Post a New Thread","This is not Post Thread Button");
		ArrayList<Boolean> listObj=AddEditDeleteTopicObj.AllElementOnPostThread();
		String Str2=AddEditDeleteTopicObj.HTxtTags();
		S1.assertEquals(Str2, "Separate tags using a comma. You may add 5 tag(s) to this thread.","User can add more than 5 tags");
		for(int i=0;i<listObj.size();i++)
		{
			S1.assertTrue(listObj.get(i),"Element is not Present on Post A New Thread");
		}
			S1.assertAll();
			testUtilObj.logOut();
			loginPageObj.clickAgrivilleLogo();
			System.out.println("Verified Post A New Thread Page for Active Account");
			
	}
	//Verify Post A New Thread Page for InActive Accounts
	@Test(priority=2)
	public void verifyPostANewThread_InActiveAcc() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		testUtilObj.loginWithInActiveAccount();
		searchTopicObj.clickBeefProd();
		searchTopicObj.clickBtnPostAThread();
		String Str1=searchTopicObj.MsgAccountNotActivated();
		S1.assertEquals(Str1, "Message","User is not present on Login Screen");
		S1.assertAll();
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified Post A New Thread Page for InActive Account");
	}
	
	//Verify Post New Thread functionality with blank Title
	//Click on Post a New Thread and do not Enter Title and click on Submit New Thread Button
	@Test(priority=3)
	public void verifyTitle_SubmitBtn() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		searchTopicObj.clickBeefProd();
		searchTopicObj.clickBtnPostAThread();
		AddEditDeleteTopicObj.EnterTitleForThread(ExcelDataUtilObj.getData(sheetName2, 1, 0));
		AddEditDeleteTopicObj.EnterDescription(ExcelDataUtilObj.getData(sheetName2, 1, 1));
		AddEditDeleteTopicObj.EnterTags(ExcelDataUtilObj.getData(sheetName2, 1, 2));
		AddEditDeleteTopicObj.clickBtnSubmitNewThread();
		String Str1=testUtil.Switch_ToAlert_GetText_And_Accept_Alert();
		S1.assertEquals(Str1, "You must enter a title / subject!","The Alert Message is missing");
		S1.assertAll();
		testUtilObj.logOutWithOutChanges();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("Title is Mandatory when we click on Submit Button");
		
	}
	
	
	//Verify Post New Thread functionality with Blank Description or Description having less than 5 characters
	//Click on Post a New Thread and do not Description or Enter Description Less than 5 Characters and click on Submit New Thread Button
	@Test(priority=4)
	public void verifyDescription_SubmitBtn() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		searchTopicObj.clickBeefProd();
		searchTopicObj.clickBtnPostAThread();
		AddEditDeleteTopicObj.EnterTitleForThread(ExcelDataUtilObj.getData(sheetName2, 2, 0));
		AddEditDeleteTopicObj.EnterDescription(ExcelDataUtilObj.getData(sheetName2, 2, 1));
		AddEditDeleteTopicObj.EnterTags(ExcelDataUtilObj.getData(sheetName2, 2, 2));
		AddEditDeleteTopicObj.clickBtnSubmitNewThread();
		String Str1=testUtil.Switch_ToAlert_GetText_And_Accept_Alert();
		S1.assertEquals(Str1, "The message you have entered is too short. Please lengthen your message to at least 5 characters.","Description Accepts less than 5 characters");
		
		loginPageObj.clickAgrivilleLogo();
		searchTopicObj.clickBeefProd();
		searchTopicObj.clickBtnPostAThread();
		AddEditDeleteTopicObj.EnterTitleForThread(ExcelDataUtilObj.getData(sheetName2, 3, 0));
		AddEditDeleteTopicObj.EnterDescription(ExcelDataUtilObj.getData(sheetName2, 3, 1));
		AddEditDeleteTopicObj.EnterTags(ExcelDataUtilObj.getData(sheetName2, 3, 2));
		AddEditDeleteTopicObj.clickBtnSubmitNewThread();
		String Str2=testUtil.Switch_ToAlert_GetText_And_Accept_Alert();
		S1.assertEquals(Str2, "The message you have entered is too short. Please lengthen your message to at least 5 characters.","Description accepts less than 5 characters");
		
		loginPageObj.clickAgrivilleLogo();
		testUtil.Switch_To_Alert_Accept();
		searchTopicObj.clickBeefProd();
		searchTopicObj.clickBtnPostAThread();
		AddEditDeleteTopicObj.EnterTitleForThread(ExcelDataUtilObj.getData(sheetName2, 6, 0));
		AddEditDeleteTopicObj.EnterDescription(ExcelDataUtilObj.getData(sheetName2, 6, 1));
		AddEditDeleteTopicObj.EnterTags(ExcelDataUtilObj.getData(sheetName2, 6, 2));
		AddEditDeleteTopicObj.clickBtnSubmitNewThread();
		String Str3=AddEditDeleteTopicObj.MsgErrors10000();
		S1.assertEquals(Str3, "The text that you have entered is too long","Description Accepts more than 10000 Characters");
		
		
		S1.assertAll();
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("Description for the Post A New Thread is Mandatory when we click on Submit Button");
		
		
	}
	
	//Verify Post New Thread functionality with tags having More than 25 characters
	//Click on Post a New Thread Enter Tags Greater than 25 Characters and click on Submit New Thread Button
	@Test(priority=5)
	public void verifyTags_SubmitBtn() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		searchTopicObj.clickBeefProd();
		searchTopicObj.clickBtnPostAThread();
		AddEditDeleteTopicObj.EnterTitleForThread(ExcelDataUtilObj.getData(sheetName2, 4, 0));
		AddEditDeleteTopicObj.EnterDescription(ExcelDataUtilObj.getData(sheetName2, 4, 1));
		AddEditDeleteTopicObj.EnterTags(ExcelDataUtilObj.getData(sheetName2, 4, 2));
		AddEditDeleteTopicObj.clickBtnSubmitNewThread();
		String Str1=AddEditDeleteTopicObj.MsgErrors();
		S1.assertEquals(Str1, "You specified a tag that was too long. A tag can only be 25 characters.","Tag Accepts more than 25 Characters");
		S1.assertAll();
		testUtilObj.logOut();
		System.out.println("New Thread was not posted as The character limit for tags exceded when we click on Submit button");
		loginPageObj.clickAgrivilleLogo();
	}
	
	//Verify Preview Post Button
	//Enter all the Mandatory data on post a thread button and click on Preview Post Button
	@Test(priority=6)
	public void verifyTitle_PreviewBtn() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		searchTopicObj.clickBeefProd();
		searchTopicObj.clickBtnPostAThread();
		AddEditDeleteTopicObj.EnterTitleForThread(ExcelDataUtilObj.getData(sheetName2, 1, 0));
		AddEditDeleteTopicObj.EnterDescription(ExcelDataUtilObj.getData(sheetName2, 1, 1));
		AddEditDeleteTopicObj.EnterTags(ExcelDataUtilObj.getData(sheetName2, 1, 2));
		AddEditDeleteTopicObj.clickBtnPreview();
		String Str1=testUtil.Switch_ToAlert_GetText_And_Accept_Alert();
		S1.assertEquals(Str1, "You must enter a title / subject!","The Alert Message is missing");
		S1.assertAll();
		testUtilObj.logOutWithOutChanges();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("Title is Mandatory when we click on Preview Preview Post Button");
	}
	
	
	//Verify Post New Thread functionality with Blank Description or Description having less than 5 characters
		//Click on Post a New Thread and do not Description or Enter Description Less than 5 Characters and click on Preview Button
		@Test(priority=7)
		public void verifyDescription_PreviewBtn() throws InterruptedException
		{
			SoftAssert S1=new SoftAssert();
			testUtilObj.loginWithActiveAccount();
			searchTopicObj.clickBeefProd();
			searchTopicObj.clickBtnPostAThread();
			AddEditDeleteTopicObj.EnterTitleForThread(ExcelDataUtilObj.getData(sheetName2, 2, 0));
			AddEditDeleteTopicObj.EnterDescription(ExcelDataUtilObj.getData(sheetName2, 2, 1));
			AddEditDeleteTopicObj.EnterTags(ExcelDataUtilObj.getData(sheetName2, 2, 2));
			AddEditDeleteTopicObj.clickBtnPreview();
			String Str1=testUtil.Switch_ToAlert_GetText_And_Accept_Alert();
			S1.assertEquals(Str1, "The message you have entered is too short. Please lengthen your message to at least 5 characters.","Description Accepts less than 5 characters");
			
			loginPageObj.clickAgrivilleLogo();
			searchTopicObj.clickBeefProd();
			searchTopicObj.clickBtnPostAThread();
			AddEditDeleteTopicObj.EnterTitleForThread(ExcelDataUtilObj.getData(sheetName2, 3, 0));
			AddEditDeleteTopicObj.EnterDescription(ExcelDataUtilObj.getData(sheetName2, 3, 1));
			AddEditDeleteTopicObj.EnterTags(ExcelDataUtilObj.getData(sheetName2, 3, 2));
			AddEditDeleteTopicObj.clickBtnPreview();
			String Str2=testUtil.Switch_ToAlert_GetText_And_Accept_Alert();
			S1.assertEquals(Str2, "The message you have entered is too short. Please lengthen your message to at least 5 characters.","Description accepts less than 5 characters");
			
			loginPageObj.clickAgrivilleLogo();
			testUtil.Switch_To_Alert_Accept();
			searchTopicObj.clickBeefProd();
			searchTopicObj.clickBtnPostAThread();
			AddEditDeleteTopicObj.EnterTitleForThread(ExcelDataUtilObj.getData(sheetName2, 6, 0));
			AddEditDeleteTopicObj.EnterDescription(ExcelDataUtilObj.getData(sheetName2, 6, 1));
			AddEditDeleteTopicObj.EnterTags(ExcelDataUtilObj.getData(sheetName2, 6, 2));
			AddEditDeleteTopicObj.clickBtnPreview();
			String Str3=AddEditDeleteTopicObj.MsgErrors10000();
			S1.assertEquals(Str3, "The text that you have entered is too long","Description Accepts more than 10000 Characters");
			S1.assertAll();
			testUtilObj.logOut();
			loginPageObj.clickAgrivilleLogo();
			System.out.println("Description for the Post A New Thread is Mandatory when we click on Preview Post Button");
			
			
		}
		
		//Verify Post New Thread functionality with tags having More than 25 characters
		//Click on Post a New Thread Enter Tags Greater than 25 Characters and click on Preview Post Button
		@Test(priority=8)
		public void verifyTags_PreviewBtn() throws InterruptedException
		{
			SoftAssert S1=new SoftAssert();
			testUtilObj.loginWithActiveAccount();
			searchTopicObj.clickBeefProd();
			searchTopicObj.clickBtnPostAThread();
			AddEditDeleteTopicObj.EnterTitleForThread(ExcelDataUtilObj.getData(sheetName2, 4, 0));
			AddEditDeleteTopicObj.EnterDescription(ExcelDataUtilObj.getData(sheetName2, 4, 1));
			AddEditDeleteTopicObj.EnterTags(ExcelDataUtilObj.getData(sheetName2, 4, 2));
			AddEditDeleteTopicObj.clickBtnPreview();
			String Str1=AddEditDeleteTopicObj.MsgErrors();
			S1.assertEquals(Str1, "You specified a tag that was too long. A tag can only be 25 characters.","Tag Accepts more than 25 Characters");
			S1.assertAll();
			testUtilObj.logOut();
			System.out.println("New Thread was not posted as The character limit for tags exceded when we click on Submit button");
			loginPageObj.clickAgrivilleLogo();
		}
	
		
		//Verify Preview Post Button
		//Enter all the Mandatory Data on Post A Thread and Click on Preview Post Button
		@Test(priority=9)
		public void verifyPreviewPostBtn() throws InterruptedException
		{
			SoftAssert S1=new SoftAssert();
			testUtilObj.loginWithActiveAccount();
			searchTopicObj.clickBeefProd();
			searchTopicObj.clickBtnPostAThread();
			AddEditDeleteTopicObj.EnterTitleForThread(ExcelDataUtilObj.getData(sheetName2, 5, 0));
			AddEditDeleteTopicObj.EnterDescription(ExcelDataUtilObj.getData(sheetName2, 5, 1));
			AddEditDeleteTopicObj.EnterTags(ExcelDataUtilObj.getData(sheetName2, 5, 2));
			AddEditDeleteTopicObj.clickBtnPreview();
			String Str1=AddEditDeleteTopicObj.TxtPreview();
			S1.assertEquals(Str1, "Preview");
			
			String Str2=searchTopicObj.H1PostNewThread();
			S1.assertEquals(Str2, "Post a New Thread","This is not Post Thread Button");
			
			S1.assertAll();
			testUtilObj.logOut();
			System.out.println("Verfied Preview Button for New Thread");
			loginPageObj.clickAgrivilleLogo();
		}
		
		

		//Verify Submit New Thread Button
		//Enter all the Mandatory Data on Post A Thread and Click on Submit new Thread Button
		@Test(priority=10)
		public void verifySubmitBtn() throws InterruptedException
		{
			SoftAssert S1=new SoftAssert();
			testUtilObj.loginWithActiveAccount();
			searchTopicObj.clickBeefProd();
			
			searchTopicObj.clickBtnPostAThread();
			AddEditDeleteTopicObj.EnterTitleForThread(ExcelDataUtilObj.getData(sheetName2, 5, 0));
			AddEditDeleteTopicObj.EnterDescription(ExcelDataUtilObj.getData(sheetName2, 5, 1));
			AddEditDeleteTopicObj.EnterTags(ExcelDataUtilObj.getData(sheetName2, 5, 2));
			AddEditDeleteTopicObj.clickBtnSubmitNewThread();
			String H1ForNewThread=AddEditDeleteTopicObj.H1ForNewThread();
			String H1ForNewThreadExcel=ExcelDataUtilObj.getData(sheetName2, 5, 0);
			S1.assertEquals(H1ForNewThread,H1ForNewThreadExcel);
			String UserNameExcel=ExcelDataUtilObj.getData(sheetName1, 2, 0);
			String UserName=AddEditDeleteTopicObj.UserName();
			S1.assertEquals(UserNameExcel, UserName);
		
			S1.assertAll();
			testUtilObj.logOut();
			System.out.println("New Thread is Added using the Submit a new thread button");
			loginPageObj.clickAgrivilleLogo();
			}
		
		
		//Verify Edit Page
		@Test(priority=11)
		public void verifyEditPage() throws InterruptedException
		{
			SoftAssert S1=new SoftAssert();
			testUtilObj.loginWithActiveAccount();
			searchTopicObj.clickBeefProd();
			AddEditDeleteTopicObj.clickProfileLink();
			String TitleThread=AddEditDeleteTopicObj.ThreadLink();
			AddEditDeleteTopicObj.clickThreadLink();
			String UserNameThread=AddEditDeleteTopicObj.UserName();
			AddEditDeleteTopicObj.clickEditLink();
			String ForumLink=AddEditDeleteTopicObj.ForumLink();
			S1.assertTrue(ForumLink.contains("Edit Post"),"The Forum link is not Present");
			String HeaderDelete=AddEditDeleteTopicObj.H2DeletePost();
			S1.assertEquals(HeaderDelete, "Delete Post","This is not Edit Delete Post");
			ArrayList<Boolean> listObj=AddEditDeleteTopicObj.AllElementOnEditPage();
			for(int i=0;i<listObj.size();i++)
			{
				S1.assertTrue(listObj.get(i),"Element is not Present on Edit Page");
			}
			
			String TitleEditPage=AddEditDeleteTopicObj.TxtBxTitleEdit();
			String UserNameEditPage=AddEditDeleteTopicObj.UserNameEditPage();
			S1.assertEquals(TitleThread, TitleEditPage);
			S1.assertEquals(UserNameThread, UserNameEditPage);
			loginPageObj.clickAgrivilleLogo();
			S1.assertAll();
			testUtilObj.logOut();
			System.out.println("Verified Thread Edit Page");
		}
		
		//Verify Forum links on Edit Thread Page
		@Test(priority=12)
		public void verifyForumLinks() throws InterruptedException
		{
			SoftAssert S1=new SoftAssert();
			testUtilObj.loginWithActiveAccount();
			searchTopicObj.clickBeefProd();
			AddEditDeleteTopicObj.clickProfileLink();
			AddEditDeleteTopicObj.clickThreadLink();
			AddEditDeleteTopicObj.clickEditLink();
			String ThreadTitleOnForum=AddEditDeleteTopicObj.ForumThreadTitle();
			AddEditDeleteTopicObj.clickForumThreadTitle();
			String H1OnThreadDetail=AddEditDeleteTopicObj.H1ForNewThread();
			S1.assertEquals(H1OnThreadDetail, ThreadTitleOnForum,"The Thread Title on Edit Page and Thread Details Page do not match");
			
			
			AddEditDeleteTopicObj.clickEditLink();
			String DiscCategoriesOnForum=AddEditDeleteTopicObj.ForumDiscCategories();
			AddEditDeleteTopicObj.clickForumDiscCategories();
			String DiscCategoriesH1=AddEditDeleteTopicObj.H1ForNewThread();
			S1.assertEquals(DiscCategoriesOnForum, DiscCategoriesH1,"The Discussion Categories on Edit Page and Disc Categories Page do not match");

			AddEditDeleteTopicObj.clickProfileLink();
			AddEditDeleteTopicObj.clickThreadLink();
			AddEditDeleteTopicObj.clickEditLink();
			AddEditDeleteTopicObj.clickForumLinkOnEdit();
			String TitleOfPage=testUtil.getTitleOfPage();
			S1.assertEquals(TitleOfPage, "Farming and Agriculture Discussion Forum | Agriville.com","Title of Page is Incorrect");
			S1.assertAll();
			loginPageObj.clickAgrivilleLogo();
			testUtilObj.logOut();
			System.out.println("Verified Forum, Disc Categories and Thread Title link on Edit Page");
		}
		
		
	@Test(priority=13)
	public void verifyDescription_SaveChangesBtn() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		searchTopicObj.clickBeefProd();
		AddEditDeleteTopicObj.clickProfileLink();
		AddEditDeleteTopicObj.clickThreadLink();
		AddEditDeleteTopicObj.clickEditLink();
		AddEditDeleteTopicObj.clearDescriptionOnEditPage();
		AddEditDeleteTopicObj.clickBtnSaveChanges();
		String TextOnAlert=testUtil.Switch_ToAlert_GetText_And_Accept_Alert();
		S1.assertEquals(TextOnAlert, "The message you have entered is too short. Please lengthen your message to at least 5 characters.","Thread is updated with No Description");
		AddEditDeleteTopicObj.EnterDescription(ExcelDataUtilObj.getData(sheetName2, 6, 1));
		AddEditDeleteTopicObj.clickBtnSaveChanges();
		String ErrorMsgOnEditPage=AddEditDeleteTopicObj.MsgErrorOnEditPage();
		S1.assertEquals(ErrorMsgOnEditPage, "The text that you have entered is too long","The Thread is updated with more than 10000 characters");
		testUtil.RefreshCurrentPage();
		S1.assertAll();
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified Description for the Save Changes Button");
	}
	@Test(priority=14)
	public void verifyDescription_PreviewChangesBtn() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		searchTopicObj.clickBeefProd();
		AddEditDeleteTopicObj.clickProfileLink();
		AddEditDeleteTopicObj.clickThreadLink();
		AddEditDeleteTopicObj.clickEditLink();
		AddEditDeleteTopicObj.clearDescriptionOnEditPage();
		AddEditDeleteTopicObj.clickBtnPreviewChanges();
		String TextOnAlert=testUtil.Switch_ToAlert_GetText_And_Accept_Alert();
		S1.assertEquals(TextOnAlert, "The message you have entered is too short. Please lengthen your message to at least 5 characters.","Thread is updated with No Description");
		AddEditDeleteTopicObj.EnterDescription(ExcelDataUtilObj.getData(sheetName2, 6, 1));
		AddEditDeleteTopicObj.clickBtnPreviewChanges();
		String ErrorMsgOnEditPage=AddEditDeleteTopicObj.MsgErrorOnEditPage();
		S1.assertEquals(ErrorMsgOnEditPage, "The text that you have entered is too long","The Thread is updated with more than 10000 characters");
		testUtil.RefreshCurrentPage();
		S1.assertAll();
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified Description for the Save Changes Button");
	}
	
	@Test(priority=15)
	public void verifyPreviewChangesforExistingThread() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		searchTopicObj.clickBeefProd();
		AddEditDeleteTopicObj.clickProfileLink();
		AddEditDeleteTopicObj.clickThreadLink();
		AddEditDeleteTopicObj.clickEditLink();
		AddEditDeleteTopicObj.clearTxtBxTitleEdit();
		AddEditDeleteTopicObj.clearTxtBxReasonEdit();
		AddEditDeleteTopicObj.clearDescriptionOnEditPage();
		AddEditDeleteTopicObj.EnterReasonForEdit(ExcelDataUtilObj.getData(sheetName2, 7, 3));
		AddEditDeleteTopicObj.EnterTitleForThreadOnEditPage(ExcelDataUtilObj.getData(sheetName2, 7, 0));
		AddEditDeleteTopicObj.EnterDescription(ExcelDataUtilObj.getData(sheetName2, 7, 1));
		
		AddEditDeleteTopicObj.clickBtnPreview();
		String PreviewTitle=AddEditDeleteTopicObj.TxtPreview();
		S1.assertAll();
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		S1.assertEquals(PreviewTitle, "Preview","The Preview Message is not Displayed");
	}
	//To Execute the Test Case Thread should be present in the account
	//To Verify Save Changes button while editing the Thread
	@Test(priority=16)
	public void verifySaveChangesForExistingThread() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		searchTopicObj.clickBeefProd();
		AddEditDeleteTopicObj.clickProfileLink();
		AddEditDeleteTopicObj.clickThreadLink();
		AddEditDeleteTopicObj.clickEditLink();
		AddEditDeleteTopicObj.clearTxtBxTitleEdit();
		AddEditDeleteTopicObj.clearTxtBxReasonEdit();
		AddEditDeleteTopicObj.clearDescriptionOnEditPage();
		AddEditDeleteTopicObj.EnterReasonForEdit(ExcelDataUtilObj.getData(sheetName2, 7, 3));
		AddEditDeleteTopicObj.EnterTitleForThreadOnEditPage(ExcelDataUtilObj.getData(sheetName2, 7, 0));
		AddEditDeleteTopicObj.EnterDescription(ExcelDataUtilObj.getData(sheetName2, 7, 1));
		
		AddEditDeleteTopicObj.clickBtnSaveChanges();
		String H1ForEditedThread=AddEditDeleteTopicObj.H1ForNewThread();
		String H1ForEditedThreadExcel=ExcelDataUtilObj.getData(sheetName2, 7, 0);
		S1.assertEquals(H1ForEditedThread, H1ForEditedThreadExcel);
		String LastEditedBy=AddEditDeleteTopicObj.LblLastEditedBy();
		String LastEditedByExcel=ExcelDataUtilObj.getData(sheetName1, 2, 0);
		
		S1.assertTrue(LastEditedBy.contains(LastEditedByExcel));
		
		
		S1.assertAll();
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified Save Changes Button on Edit Screen");
		
	}
	//To Execute the Test Case Thread should be present in the account
	//To Verify Delete button while editing the Thread
	//To handle the Delete Test Case we need Only one Thread
	@Test(priority=17)
	public void verifyDeleteThread() throws InterruptedException
	{
		
		SoftAssert S1=new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		searchTopicObj.clickBeefProd();
//		searchTopicObj.clickBtnPostAThread();
//		AddEditDeleteTopicObj.EnterTitleForThread(ExcelDataUtilObj.getData(sheetName2, 8, 0));
//		AddEditDeleteTopicObj.EnterDescription(ExcelDataUtilObj.getData(sheetName2, 8, 1));
//		AddEditDeleteTopicObj.EnterTags(ExcelDataUtilObj.getData(sheetName2, 8, 2));
//		AddEditDeleteTopicObj.clickBtnSubmitNewThread();
		AddEditDeleteTopicObj.clickProfileLink();
		AddEditDeleteTopicObj.clickThreadLink();
		AddEditDeleteTopicObj.clickEditLink();
		AddEditDeleteTopicObj.clickBtnDeletePost();
		String H1Delete=AddEditDeleteTopicObj.H1ForNewThread(); 
		//String H1DeleteExcel=ExcelDataUtilObj.getData(sheetName2, 8, 0);
		String H1DeleteExcel=ExcelDataUtilObj.getData(sheetName2, 5, 0);
		S1.assertEquals(H1Delete, H1DeleteExcel);
		AddEditDeleteTopicObj.clickEditLink();
		AddEditDeleteTopicObj.clickChkBxDelete();
		AddEditDeleteTopicObj.clickBtnDeletePost();
		String TitleThread=searchTopicObj.ColThreadTitleStarter();
		S1.assertEquals(TitleThread,"TITLE / THREAD STARTER");
		String Author=searchTopicObj.ColAuthor();
		S1.assertEquals(Author,"AUTHOR");
		String ReplyViews=searchTopicObj.ColRepliesView();
		S1.assertEquals(ReplyViews,"REPLIES / VIEWS");
		String LastPostBy=searchTopicObj.ColLastPostBy();
		S1.assertEquals(LastPostBy,"LAST POST BY");
		String BeefProd=searchTopicObj.H1BeefProd();
		S1.assertEquals(BeefProd, "Beef Production");
		AddEditDeleteTopicObj.clickProfileLink();
		String NoResults=AddEditDeleteTopicObj.noResults();
		S1.assertEquals(NoResults, "No More Results");
	
		S1.assertAll();
		testUtilObj.logOut();
		System.out.println("Thread is Deleted using Delete Thread ");
		}
		

		
		

	@AfterClass
	public void TearDown()
	{
		driver.quit();
	}
	
}
