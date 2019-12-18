package com.agriville.qa.testcases;

import java.util.ArrayList;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.agriville.qa.base.TestBase;
import com.agriville.qa.pages.AddEditDeleteReply;
import com.agriville.qa.pages.AddEditDeleteTopic;
import com.agriville.qa.pages.loginPage;
import com.agriville.qa.pages.searchTopic;
import com.agriville.qa.pages.topicDetails;
import com.agriville.qa.util.ExcelDataUtil;
import com.agriville.qa.util.testUtil;

public class AddEditDeleteReplyTest extends TestBase {
	topicDetails topicDetailsObj;
	ExcelDataUtil ExcelDataUtilObj;
	loginPage loginPageObj;
	AddEditDeleteTopic AddEditDeleteTopicObj;
	searchTopic searchTopicObj;
	testUtil testUtilObj;
	AddEditDeleteReply AddEditDeleteReplyObj;
	String Path = "E://Script Agriville//AgrivilleTest//src//main//java//com//agriville//qa//testdata//Agriville.xlsx";
	String sheetName = "Disc_Categories";
	String sheetName1 = "Disc_CategoriesLogin";
	String sheetName2 = "PostThread";
	String sheetName3 = "Reply";

	public AddEditDeleteReplyTest() {
		super();
	}

	@BeforeClass
	public void SetUp() {
		intialization();
		topicDetailsObj = new topicDetails();
		searchTopicObj = new searchTopic();
		// testUtilObj=new testUtil();
		loginPageObj = new loginPage();
		testUtilObj = new testUtil();
		AddEditDeleteReplyObj = new AddEditDeleteReply();
		ExcelDataUtilObj = new ExcelDataUtil(Path);
		AddEditDeleteTopicObj = new AddEditDeleteTopic();

	}

	// Reply from search page and reply to this thread at bottom
	// Reply from search result page
	// Reply from View Button

	// Verify Post A message button on Thread Details Page
	// Disc Categories-->Click on First Thread-->>Click on Post a Message
	@Test(priority = 1, invocationCount=3)
	public void verifyPostANewReply_DiscCategoriesPostMessageBtn() throws InterruptedException {

		SoftAssert S1 = new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		searchTopicObj.clickBeefProd();
		topicDetailsObj.clickH2FirstSubCategory();
		topicDetailsObj.clickBtnPostMsg();
		String ForumTitle = AddEditDeleteReplyObj.ForumTitle();
		S1.assertTrue(ForumTitle.contains("Reply to Thread"));
		String H1PostReply = topicDetailsObj.MsgPostNewReply();
		S1.assertEquals(H1PostReply, "Post a New Reply");
		ArrayList<Boolean> listObj = AddEditDeleteReplyObj.AllElementOnReplyThread();
		for (int i = 0; i < listObj.size(); i++) 
		{
			S1.assertTrue(listObj.get(i), "Element is not Present on Reply Page");
		}
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Disc Categories: Verified Post A new reply Page from Post A Message");
	}

	// Verify Post A message button on Thread Details Page
	// Enter Keyword in Search box-->Click on First Thread-->>Click on Post a Message
	@Test(priority = 2, invocationCount=3)
	public void verifyPostANewReply_SearchResultPostMsgBtn() throws InterruptedException {
		SoftAssert S1 = new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		topicDetailsObj.EnterDataSearchBx(ExcelDataUtilObj.getData(sheetName, 1, 4));
		topicDetailsObj.clickBtnSearch();
		topicDetailsObj.clickH2FirstSubCategory();
		topicDetailsObj.clickBtnPostMsg();
		String ForumTitle = AddEditDeleteReplyObj.ForumTitle();
		S1.assertTrue(ForumTitle.contains("Reply to Thread"));
		String H1PostReply = topicDetailsObj.MsgPostNewReply();
		S1.assertEquals(H1PostReply, "Post a New Reply");
		ArrayList<Boolean> listObj = AddEditDeleteReplyObj.AllElementOnReplyThread();
		for (int i = 0; i < listObj.size(); i++) {
			S1.assertTrue(listObj.get(i), "Element is not Present on Reply Page");
		}
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Search Result: Verified Post A new reply Page from Post A Message");
	}

	// Verify Post A message button on Thread Details Page
	// Enter Keyword in Search box-->Click on View Button for First Thread-->>Click on Post a Message
	@Test(priority = 3, invocationCount=3)
	public void verifyPostANewReply_ViewPostMsgBtn() throws InterruptedException {
		SoftAssert S1 = new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		topicDetailsObj.EnterDataSearchBx(ExcelDataUtilObj.getData(sheetName, 1, 4));
		topicDetailsObj.clickBtnSearch();
		topicDetailsObj.clickBtnFirstView();
		topicDetailsObj.clickBtnPostMsg();
		String ForumTitle = AddEditDeleteReplyObj.ForumTitle();
		S1.assertTrue(ForumTitle.contains("Reply to Thread"));
		String H1PostReply = topicDetailsObj.MsgPostNewReply();
		S1.assertEquals(H1PostReply, "Post a New Reply");
		ArrayList<Boolean> listObj = AddEditDeleteReplyObj.AllElementOnReplyThread();
		for (int i = 0; i < listObj.size(); i++) {
			S1.assertTrue(listObj.get(i), "Element is not Present on Reply Page");
		}
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("View: Verified Post A new reply Page from Post A Message");

	}

	// Verify Preview Post Button
	// Click on Disc Categories-->Click on First Thread-->>Click on Post a Message-->Enter Description and Click on Preview Post Button
	@Test(priority = 4, invocationCount=3)
	public void verifyPreviewPost_DiscCategoriesPostMsgBtn() throws InterruptedException {
		SoftAssert S1 = new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		searchTopicObj.clickBeefProd();
		topicDetailsObj.clickH2FirstSubCategory();
		topicDetailsObj.clickBtnPostMsg();
		AddEditDeleteReplyObj.EnterDescription(ExcelDataUtilObj.getData(sheetName3, 1, 0));
		AddEditDeleteReplyObj.clickBtnPreviewReply();
		String Msg5Char = testUtil.Switch_ToAlert_GetText_And_Accept_Alert();
		S1.assertEquals(Msg5Char,
				"The message you have entered is too short. Please lengthen your message to at least 5 characters.",
				"Message is incorrect");
		AddEditDeleteReplyObj.clearDescription();
		AddEditDeleteReplyObj.EnterDescription(ExcelDataUtilObj.getData(sheetName3, 2, 0));
		AddEditDeleteReplyObj.clickBtnPreviewReply();
		String Msg10000Char = AddEditDeleteTopicObj.MsgErrors10000();
		S1.assertEquals(Msg10000Char, "The text that you have entered is too long",
				"Description Accepts more than 10000 Characters");
		AddEditDeleteReplyObj.clearDescription();
		AddEditDeleteReplyObj.EnterDescription(ExcelDataUtilObj.getData(sheetName3, 3, 0));
		AddEditDeleteReplyObj.clickBtnPreviewReply();
		String TxtPreview = AddEditDeleteTopicObj.TxtPreview();
		S1.assertEquals(TxtPreview, "Preview");
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Description Categories: Verified Preview Button On Post A New Reply from Post A Message");
	}

	// Verify Preview Post Button
	// Enter Keyword in Search box-->Click on First Thread-->>Click on Post a Message-->Enter Description and Click on Preview Post Button
	@Test(priority = 5, invocationCount=3)
	public void verifyPreviewPost_SearchResultsPostMsgBtn() throws InterruptedException {
		SoftAssert S1 = new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		topicDetailsObj.EnterDataSearchBx(ExcelDataUtilObj.getData(sheetName, 1, 4));
		topicDetailsObj.clickBtnSearch();
		topicDetailsObj.clickH2FirstSubCategory();
		topicDetailsObj.clickBtnPostMsg();
		AddEditDeleteReplyObj.EnterDescription(ExcelDataUtilObj.getData(sheetName3, 1, 0));
		AddEditDeleteReplyObj.clickBtnPreviewReply();
		String Msg5Char = testUtil.Switch_ToAlert_GetText_And_Accept_Alert();
		S1.assertEquals(Msg5Char,"The message you have entered is too short. Please lengthen your message to at least 5 characters.","Message is incorrect");
		AddEditDeleteReplyObj.clearDescription();
		AddEditDeleteReplyObj.EnterDescription(ExcelDataUtilObj.getData(sheetName3, 2, 0));
		AddEditDeleteReplyObj.clickBtnPreviewReply();
		String Msg10000Char = AddEditDeleteTopicObj.MsgErrors10000();
		S1.assertEquals(Msg10000Char, "The text that you have entered is too long",
				"Description Accepts more than 10000 Characters");
		AddEditDeleteReplyObj.clearDescription();
		AddEditDeleteReplyObj.EnterDescription(ExcelDataUtilObj.getData(sheetName3, 3, 0));
		AddEditDeleteReplyObj.clickBtnPreviewReply();
		String TxtPreview = AddEditDeleteTopicObj.TxtPreview();
		S1.assertEquals(TxtPreview, "Preview");
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Search Results: Verified Preview Button On Post A New Reply from Post A Message");
	}

	// Verify Preview Post Button
	// Enter Keyword in Search box-->Click on First View Button->>Click on Post a Message-->Enter Description and Click on Preview Post Button
	@Test(priority = 6, invocationCount=3)
	public void verifyPreviewPost_ViewPostMsgBtn() throws InterruptedException {
		SoftAssert S1 = new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		topicDetailsObj.EnterDataSearchBx(ExcelDataUtilObj.getData(sheetName, 1, 4));
		topicDetailsObj.clickBtnSearch();
		topicDetailsObj.clickBtnFirstView();

		topicDetailsObj.clickBtnPostMsg();
		AddEditDeleteReplyObj.EnterDescription(ExcelDataUtilObj.getData(sheetName3, 1, 0));
		AddEditDeleteReplyObj.clickBtnPreviewReply();
		String Msg5Char = testUtil.Switch_ToAlert_GetText_And_Accept_Alert();
		S1.assertEquals(Msg5Char,
				"The message you have entered is too short. Please lengthen your message to at least 5 characters.",
				"Message is incorrect");
		AddEditDeleteReplyObj.clearDescription();
		AddEditDeleteReplyObj.EnterDescription(ExcelDataUtilObj.getData(sheetName3, 2, 0));
		AddEditDeleteReplyObj.clickBtnPreviewReply();
		String Msg10000Char = AddEditDeleteTopicObj.MsgErrors10000();
		S1.assertEquals(Msg10000Char, "The text that you have entered is too long",
				"Description Accepts more than 10000 Characters");
		AddEditDeleteReplyObj.clearDescription();
		AddEditDeleteReplyObj.EnterDescription(ExcelDataUtilObj.getData(sheetName3, 3, 0));
		AddEditDeleteReplyObj.clickBtnPreviewReply();
		String TxtPreview = AddEditDeleteTopicObj.TxtPreview();
		S1.assertEquals(TxtPreview, "Preview");

		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("View: Verified Preview Button On Post A New Reply from Post A Message");
	}

	// Verify Submit Reply Button
	// Click on Disc Categories-->Click on First Thread-->>Click on Post a Message--> Enter Description and Click on Submit Reply Button
	@Test(priority = 7, invocationCount=3)
	public void verifySubmitReply_DiscCategoriesPostMsgBtn() throws InterruptedException {
		SoftAssert S1 = new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		searchTopicObj.clickBeefProd();
		topicDetailsObj.clickH2FirstSubCategory();
		String H1OnThreadDetails = AddEditDeleteReplyObj.H1OnThreadDetails();
		topicDetailsObj.clickBtnPostMsg();
		AddEditDeleteReplyObj.EnterDescription(ExcelDataUtilObj.getData(sheetName3, 1, 0));
		AddEditDeleteReplyObj.clickBtnSubmitReply();
		String Msg5Char = testUtil.Switch_ToAlert_GetText_And_Accept_Alert();
		S1.assertEquals(Msg5Char,
				"The message you have entered is too short. Please lengthen your message to at least 5 characters.",
				"Message is incorrect");
		AddEditDeleteReplyObj.clearDescription();
		AddEditDeleteReplyObj.EnterDescription(ExcelDataUtilObj.getData(sheetName3, 2, 0));
		AddEditDeleteReplyObj.clickBtnSubmitReply();
		String Msg10000Char = AddEditDeleteTopicObj.MsgErrors10000();
		S1.assertEquals(Msg10000Char, "The text that you have entered is too long",
				"Description Accepts more than 10000 Characters");
		AddEditDeleteReplyObj.clearDescription();
		AddEditDeleteReplyObj.EnterDescription(ExcelDataUtilObj.getData(sheetName3, 3, 0));
		AddEditDeleteReplyObj.clickBtnSubmitReply();
		String H1OnThreadDetailsAfterSubmitReply = AddEditDeleteReplyObj.H1OnThreadDetails();
		S1.assertEquals(H1OnThreadDetails, H1OnThreadDetailsAfterSubmitReply, "The Reply to the Thread is not added");
		S1.assertTrue(topicDetailsObj.BtnPostMsgisDisplayed());

		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Description Categories: Verified Submit Reply Button On Post A New Reply from Post A Message");
	}

	// Verify Submit Reply Button
	// Enter Keyword in Search box-->Click on First Thread-->>Click on Post a Message
	// Enter Description and Click on Submit Reply Button
	@Test(priority = 8, invocationCount=3)
	public void verifySubmitReply_SearchResultsPostMsgBtn() throws InterruptedException {
		SoftAssert S1 = new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		topicDetailsObj.EnterDataSearchBx(ExcelDataUtilObj.getData(sheetName, 1, 4));
		topicDetailsObj.clickBtnSearch();
		topicDetailsObj.clickH2FirstSubCategory();

		String H1OnThreadDetails = AddEditDeleteReplyObj.H1OnThreadDetails();
		topicDetailsObj.clickBtnPostMsg();
		AddEditDeleteReplyObj.EnterDescription(ExcelDataUtilObj.getData(sheetName3, 1, 0));
		AddEditDeleteReplyObj.clickBtnSubmitReply();
		String Msg5Char = testUtil.Switch_ToAlert_GetText_And_Accept_Alert();
		S1.assertEquals(Msg5Char,
				"The message you have entered is too short. Please lengthen your message to at least 5 characters.",
				"Message is incorrect");
		AddEditDeleteReplyObj.clearDescription();
		AddEditDeleteReplyObj.EnterDescription(ExcelDataUtilObj.getData(sheetName3, 2, 0));
		AddEditDeleteReplyObj.clickBtnSubmitReply();
		String Msg10000Char = AddEditDeleteTopicObj.MsgErrors10000();
		S1.assertEquals(Msg10000Char, "The text that you have entered is too long",
				"Description Accepts more than 10000 Characters");
		AddEditDeleteReplyObj.clearDescription();
		AddEditDeleteReplyObj.EnterDescription(ExcelDataUtilObj.getData(sheetName3, 3, 0));
		AddEditDeleteReplyObj.clickBtnSubmitReply();
		String H1OnThreadDetailsAfterSubmitReply = AddEditDeleteReplyObj.H1OnThreadDetails();
		S1.assertEquals(H1OnThreadDetails, H1OnThreadDetailsAfterSubmitReply, "The Reply to the Thread is not added");
		S1.assertTrue(topicDetailsObj.BtnPostMsgisDisplayed());
		testUtilObj.logOut();
		S1.assertAll();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("Search Results: Verified Submit Reply Button On Post A New Reply from Post A Message");
	}

	// Verify Submit Reply Button
	// Enter Keyword in Search box-->Click on First View Button-->>Click on Post a Message-->Enter Description and Click on Submit Reply Button
	@Test(priority = 9, invocationCount=3)
	public void verifySubmitReply_ViewPostMsgBtn() throws InterruptedException {
		SoftAssert S1 = new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		topicDetailsObj.EnterDataSearchBx(ExcelDataUtilObj.getData(sheetName, 1, 4));
		topicDetailsObj.clickBtnSearch();
		topicDetailsObj.clickBtnFirstView();

		String H1OnThreadDetails = AddEditDeleteReplyObj.H1OnThreadDetails();
		topicDetailsObj.clickBtnPostMsg();
		AddEditDeleteReplyObj.EnterDescription(ExcelDataUtilObj.getData(sheetName3, 1, 0));
		AddEditDeleteReplyObj.clickBtnSubmitReply();
		String Msg5Char = testUtil.Switch_ToAlert_GetText_And_Accept_Alert();
		S1.assertEquals(Msg5Char,
				"The message you have entered is too short. Please lengthen your message to at least 5 characters.",
				"Message is incorrect");
		AddEditDeleteReplyObj.clearDescription();
		AddEditDeleteReplyObj.EnterDescription(ExcelDataUtilObj.getData(sheetName3, 2, 0));
		AddEditDeleteReplyObj.clickBtnSubmitReply();
		String Msg10000Char = AddEditDeleteTopicObj.MsgErrors10000();
		S1.assertEquals(Msg10000Char, "The text that you have entered is too long",
				"Description Accepts more than 10000 Characters");
		AddEditDeleteReplyObj.clearDescription();
		AddEditDeleteReplyObj.EnterDescription(ExcelDataUtilObj.getData(sheetName3, 3, 0));
		AddEditDeleteReplyObj.clickBtnSubmitReply();
		String H1OnThreadDetailsAfterSubmitReply = AddEditDeleteReplyObj.H1OnThreadDetails();
		S1.assertEquals(H1OnThreadDetails, H1OnThreadDetailsAfterSubmitReply, "The Reply to the Thread is not added");
		S1.assertTrue(topicDetailsObj.BtnPostMsgisDisplayed());
		testUtilObj.logOut();
		S1.assertAll();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("View: Verified Submit Reply Button On Post A New Reply from Post A Message");
	}

	// Verify the Breadcrumbs link
	//// Click on Disc Categories-->Click on First Thread-->>Click on Post a Message-->Click on All the sub links
	@Test(priority = 10, invocationCount=3)
	public void verifyBreadCrumbs_DiscCategoriesPostMsgBtn() throws InterruptedException {
		SoftAssert S1 = new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		searchTopicObj.clickBeefProd();
		String H1BeefProd = searchTopicObj.H1BeefProd();
		topicDetailsObj.clickH2FirstSubCategory();
		String H1OnThreadDetails = AddEditDeleteReplyObj.H1OnThreadDetails();
		topicDetailsObj.clickBtnPostMsg();
		AddEditDeleteReplyObj.clickThreadTitlelink();
		String H1OnNavigation = AddEditDeleteReplyObj.H1OnThreadDetails();
		S1.assertEquals(H1OnThreadDetails, H1OnNavigation, "The Thread Title do not match");
		S1.assertTrue(topicDetailsObj.BtnPostMsgisDisplayed());
		testUtil.navigateToPreviouPage();

		AddEditDeleteReplyObj.clickDiscCategorieslink();
		String ColThreadTitleStarter = searchTopicObj.ColThreadTitleStarter();
		S1.assertEquals(ColThreadTitleStarter, "TITLE / THREAD STARTER");
		String ColAuthor = searchTopicObj.ColAuthor();
		S1.assertEquals(ColAuthor, "AUTHOR");
		String ColRepliesView = searchTopicObj.ColRepliesView();
		S1.assertEquals(ColRepliesView, "REPLIES / VIEWS");
		String ColLastPostBy = searchTopicObj.ColLastPostBy();
		S1.assertEquals(ColLastPostBy, "LAST POST BY");
		String H1BeefProdNavigation = searchTopicObj.H1BeefProd();
		S1.assertEquals(H1BeefProd, H1BeefProdNavigation);
		testUtil.navigateToPreviouPage();
		AddEditDeleteReplyObj.clickForumlink();
		String Title = testUtil.getTitleOfPage();
		S1.assertEquals(Title, "Farming and Agriculture Discussion Forum | Agriville.com");
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("Discussion Categories: Verified the Breadcrumbs link from Post A Message");
		S1.assertAll();

	}

	// Verify the Breadcrumbs link
	// Enter Keyword in Search box-->Click on First Thread-->>Click on Post a Message-->Click on All the sub links
	@Test(priority = 11, invocationCount=3)
	public void verifyBreadCrumbs_SearchResultsPostMsgBtn() throws InterruptedException {
		SoftAssert S1 = new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		topicDetailsObj.EnterDataSearchBx(ExcelDataUtilObj.getData(sheetName, 1, 4));
		topicDetailsObj.clickBtnSearch();
	//	String H2FirstSubCategory = searchTopicObj.H2FirstSubCategory();
		topicDetailsObj.clickH2FirstSubCategory();
		String H1OnThreadDetails = AddEditDeleteReplyObj.H1OnThreadDetails();
		topicDetailsObj.clickBtnPostMsg();
		AddEditDeleteReplyObj.clickThreadTitlelink();
		String H1OnNavigation = AddEditDeleteReplyObj.H1OnThreadDetails();
		S1.assertEquals(H1OnThreadDetails, H1OnNavigation, "The Thread Title do not match");
		S1.assertTrue(topicDetailsObj.BtnPostMsgisDisplayed());
		testUtil.navigateToPreviouPage();

		AddEditDeleteReplyObj.clickDiscCategorieslink();
		String ColThreadTitleStarter = searchTopicObj.ColThreadTitleStarter();
		S1.assertEquals(ColThreadTitleStarter, "TITLE / THREAD STARTER");
		String ColAuthor = searchTopicObj.ColAuthor();
		S1.assertEquals(ColAuthor, "AUTHOR");
		String ColRepliesView = searchTopicObj.ColRepliesView();
		S1.assertEquals(ColRepliesView, "REPLIES / VIEWS");
		String ColLastPostBy = searchTopicObj.ColLastPostBy();
		S1.assertEquals(ColLastPostBy, "LAST POST BY");
//		String H2FirstSubCategoryNavigation = searchTopicObj.H2FirstSubCategory();
//		S1.assertEquals(H2FirstSubCategory, H2FirstSubCategoryNavigation);
		testUtil.navigateToPreviouPage();
		AddEditDeleteReplyObj.clickForumlink();
		String Title = testUtil.getTitleOfPage();
		S1.assertEquals(Title, "Farming and Agriculture Discussion Forum | Agriville.com");
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("Search Result: Verified the Breadcrumbs link from Post A Message");
		S1.assertAll();

	}

	// Verify the Breadcrumbs link
	// Enter Keyword in Search box-->Click on First View Button-->>Click on Post a Message-->Click on All the sub links
	@Test(priority = 12, invocationCount=3)
	public void verifyBreadCrumbs_ViewPostMsgBtn() throws InterruptedException {
		SoftAssert S1 = new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		topicDetailsObj.EnterDataSearchBx(ExcelDataUtilObj.getData(sheetName, 1, 4));
		topicDetailsObj.clickBtnSearch();
		//String H2FirstSubCategory = searchTopicObj.H2FirstSubCategory();
		topicDetailsObj.clickBtnFirstView();
		String H1OnThreadDetails = AddEditDeleteReplyObj.H1OnThreadDetails();
		topicDetailsObj.clickBtnPostMsg();
		AddEditDeleteReplyObj.clickThreadTitlelink();
		String H1OnNavigation = AddEditDeleteReplyObj.H1OnThreadDetails();
		S1.assertEquals(H1OnThreadDetails, H1OnNavigation, "The Thread Title do not match");
		S1.assertTrue(topicDetailsObj.BtnPostMsgisDisplayed());
		testUtil.navigateToPreviouPage();

		AddEditDeleteReplyObj.clickDiscCategorieslink();
		String ColThreadTitleStarter = searchTopicObj.ColThreadTitleStarter();
		S1.assertEquals(ColThreadTitleStarter, "TITLE / THREAD STARTER");
		String ColAuthor = searchTopicObj.ColAuthor();
		S1.assertEquals(ColAuthor, "AUTHOR");
		String ColRepliesView = searchTopicObj.ColRepliesView();
		S1.assertEquals(ColRepliesView, "REPLIES / VIEWS");
		String ColLastPostBy = searchTopicObj.ColLastPostBy();
		S1.assertEquals(ColLastPostBy, "LAST POST BY");
		//String H2FirstSubCategoryNavigation = searchTopicObj.H2FirstSubCategory();
		//S1.assertEquals(H2FirstSubCategory, H2FirstSubCategoryNavigation);
		testUtil.navigateToPreviouPage();
		AddEditDeleteReplyObj.clickForumlink();
		String Title = testUtil.getTitleOfPage();
		S1.assertEquals(Title, "Farming and Agriculture Discussion Forum | Agriville.com");
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("View: Verified the Breadcrumbs link from Post A Message");
		S1.assertAll();

	}

	// Verify First Reply button on Thread Details Page
	// Disc Categories-->Thread Result Page-->Click on First Thread-->>Click on Reply Button
	@Test(priority = 13, invocationCount=3)
	public void verifyPostANewReply_DiscCategoriesFirstReplyBtn() throws InterruptedException {

		SoftAssert S1 = new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		searchTopicObj.clickBeefProd();
		topicDetailsObj.clickH2FirstSubCategory();
		topicDetailsObj.clickFirstBtnReply();
		String ForumTitle = AddEditDeleteReplyObj.ForumTitle();
		S1.assertTrue(ForumTitle.contains("Reply to Thread"));
		String H1PostReply = topicDetailsObj.MsgPostNewReply();
		S1.assertEquals(H1PostReply, "Post a New Reply");
		ArrayList<Boolean> listObj = AddEditDeleteReplyObj.AllElementOnReplyThread();
		for (int i = 0; i < listObj.size(); i++) {
			S1.assertTrue(listObj.get(i), "Element is not Present on Reply Page");
		}
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Disc Categories: Verified Post A new reply Page from First Reply Button on Thread Details Page");
	}

	// Verify First Reply button on Thread Details Page
	// Enter Keyword in Search box-->Thread Result Page-->Click on First Thread-->>Click on Reply button
	@Test(priority = 14, invocationCount=3)
	public void verifyPostANewReply_SearchResultFirstReplyBtn() throws InterruptedException {
		SoftAssert S1 = new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		topicDetailsObj.EnterDataSearchBx(ExcelDataUtilObj.getData(sheetName, 1, 4));
		topicDetailsObj.clickBtnSearch();
		topicDetailsObj.clickH2FirstSubCategory();
		topicDetailsObj.clickFirstBtnReply();
		String ForumTitle = AddEditDeleteReplyObj.ForumTitle();
		S1.assertTrue(ForumTitle.contains("Reply to Thread"));
		String H1PostReply = topicDetailsObj.MsgPostNewReply();
		S1.assertEquals(H1PostReply, "Post a New Reply");
		ArrayList<Boolean> listObj = AddEditDeleteReplyObj.AllElementOnReplyThread();
		for (int i = 0; i < listObj.size(); i++) {
			S1.assertTrue(listObj.get(i), "Element is not Present on Reply Page");
		}
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Search Result: Verified Post A new reply Page from First Reply Button on Thread Details Page");
	}

	// Verify First Reply button on Thread Details Page
	// Enter Keyword in Search box-->Thread Result Page-->Click on First View Button-->>Click on Reply Btn
	@Test(priority = 15, invocationCount=3)
	public void verifyPostANewReply_ViewFirstReplyBtn() throws InterruptedException {
		SoftAssert S1 = new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		topicDetailsObj.EnterDataSearchBx(ExcelDataUtilObj.getData(sheetName, 1, 4));
		topicDetailsObj.clickBtnSearch();
		topicDetailsObj.clickBtnFirstView();
		topicDetailsObj.clickFirstBtnReply();
		String ForumTitle = AddEditDeleteReplyObj.ForumTitle();
		S1.assertTrue(ForumTitle.contains("Reply to Thread"));
		String H1PostReply = topicDetailsObj.MsgPostNewReply();
		S1.assertEquals(H1PostReply, "Post a New Reply");
		ArrayList<Boolean> listObj = AddEditDeleteReplyObj.AllElementOnReplyThread();
		for (int i = 0; i < listObj.size(); i++) {
			S1.assertTrue(listObj.get(i), "Element is not Present on Reply Page");
		}
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("View: Verified Post A new reply Page from First Reply Button on Thread Details Page");

	}

	// Verify Preview Post Button
	// Click on Disc Categories-->Click on First Thread-->>Click on First ReplyBtn-->Enter Description and Click on Preview Post Button
	@Test(priority = 16, invocationCount=3)
	public void verifyPreviewPostFirstReplyBtn_DiscCategories() throws InterruptedException {
		SoftAssert S1 = new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		searchTopicObj.clickBeefProd();
		topicDetailsObj.clickH2FirstSubCategory();
		topicDetailsObj.clickFirstBtnReply();
		AddEditDeleteReplyObj.EnterDescription(ExcelDataUtilObj.getData(sheetName3, 1, 0));
		AddEditDeleteReplyObj.clickBtnPreviewReply();
		String Msg5Char = testUtil.Switch_ToAlert_GetText_And_Accept_Alert();
		S1.assertEquals(Msg5Char,
				"The message you have entered is too short. Please lengthen your message to at least 5 characters.",
				"Message is incorrect");
		AddEditDeleteReplyObj.clearDescription();
		AddEditDeleteReplyObj.EnterDescription(ExcelDataUtilObj.getData(sheetName3, 2, 0));
		AddEditDeleteReplyObj.clickBtnPreviewReply();
		String Msg10000Char = AddEditDeleteTopicObj.MsgErrors10000();
		S1.assertEquals(Msg10000Char, "The text that you have entered is too long",
				"Description Accepts more than 10000 Characters");
		AddEditDeleteReplyObj.clearDescription();
		AddEditDeleteReplyObj.EnterDescription(ExcelDataUtilObj.getData(sheetName3, 3, 0));
		AddEditDeleteReplyObj.clickBtnPreviewReply();
		String TxtPreview = AddEditDeleteTopicObj.TxtPreview();
		S1.assertEquals(TxtPreview, "Preview");
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Description Categories: Verified Preview Button On Post A New Reply Page from First Reply Button on Thread Details Page");
	}

	// Verify Preview Post Button
	// Enter Keyword in Search box-->Click on First Thread-->>Click on First Reply-->Enter Description and Click on Preview Post Button
	@Test(priority = 17, invocationCount=3)
	public void verifyPreviewFirstPostReplyBtn_SearchResults() throws InterruptedException {
		SoftAssert S1 = new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		topicDetailsObj.EnterDataSearchBx(ExcelDataUtilObj.getData(sheetName, 1, 4));
		topicDetailsObj.clickBtnSearch();
		topicDetailsObj.clickH2FirstSubCategory();
		topicDetailsObj.clickFirstBtnReply();
		AddEditDeleteReplyObj.EnterDescription(ExcelDataUtilObj.getData(sheetName3, 1, 0));
		AddEditDeleteReplyObj.clickBtnPreviewReply();
		String Msg5Char = testUtil.Switch_ToAlert_GetText_And_Accept_Alert();
		S1.assertEquals(Msg5Char,
				"The message you have entered is too short. Please lengthen your message to at least 5 characters.",
				"Message is incorrect");
		AddEditDeleteReplyObj.clearDescription();
		AddEditDeleteReplyObj.EnterDescription(ExcelDataUtilObj.getData(sheetName3, 2, 0));
		AddEditDeleteReplyObj.clickBtnPreviewReply();
		String Msg10000Char = AddEditDeleteTopicObj.MsgErrors10000();
		S1.assertEquals(Msg10000Char, "The text that you have entered is too long",
				"Description Accepts more than 10000 Characters");
		AddEditDeleteReplyObj.clearDescription();
		AddEditDeleteReplyObj.EnterDescription(ExcelDataUtilObj.getData(sheetName3, 3, 0));
		AddEditDeleteReplyObj.clickBtnPreviewReply();
		String TxtPreview = AddEditDeleteTopicObj.TxtPreview();
		S1.assertEquals(TxtPreview, "Preview");
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Search Results: Verified Preview Button On Post A New Reply Page from First Reply Button on Thread Details Page");
	}

	// Verify Preview Post Button
	// Enter Keyword in Search box-->Click on First View Button->>Click on Post a
	// Message-->Enter Description and Click on Preview Post Button
	@Test(priority = 18, invocationCount=3)
	public void verifyPreviewPostFirstReplyBtn_View() throws InterruptedException {
		SoftAssert S1 = new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		topicDetailsObj.EnterDataSearchBx(ExcelDataUtilObj.getData(sheetName, 1, 4));
		topicDetailsObj.clickBtnSearch();
		topicDetailsObj.clickBtnFirstView();

		topicDetailsObj.clickFirstBtnReply();
		AddEditDeleteReplyObj.EnterDescription(ExcelDataUtilObj.getData(sheetName3, 1, 0));
		AddEditDeleteReplyObj.clickBtnPreviewReply();
		String Msg5Char = testUtil.Switch_ToAlert_GetText_And_Accept_Alert();
		S1.assertEquals(Msg5Char,
				"The message you have entered is too short. Please lengthen your message to at least 5 characters.",
				"Message is incorrect");
		AddEditDeleteReplyObj.clearDescription();
		AddEditDeleteReplyObj.EnterDescription(ExcelDataUtilObj.getData(sheetName3, 2, 0));
		AddEditDeleteReplyObj.clickBtnPreviewReply();
		String Msg10000Char = AddEditDeleteTopicObj.MsgErrors10000();
		S1.assertEquals(Msg10000Char, "The text that you have entered is too long",
				"Description Accepts more than 10000 Characters");
		AddEditDeleteReplyObj.clearDescription();
		AddEditDeleteReplyObj.EnterDescription(ExcelDataUtilObj.getData(sheetName3, 3, 0));
		AddEditDeleteReplyObj.clickBtnPreviewReply();
		String TxtPreview = AddEditDeleteTopicObj.TxtPreview();
		S1.assertEquals(TxtPreview, "Preview");

		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("View: Verified Preview Button On Post A New Reply Page from First Reply Button on Thread Details Page");
	}

	// Verify Submit Reply Button
	// Click on Disc Categories-->Click on First Thread-->>Click on First Reply Button-->Enter Description and Click on Submit Reply Button
	@Test(priority = 19, invocationCount=3)
	public void verifySubmitReply_DiscCategoriesFirstReplyBtn() throws InterruptedException {
		SoftAssert S1 = new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		searchTopicObj.clickBeefProd();
		topicDetailsObj.clickH2FirstSubCategory();
		String H1OnThreadDetails = AddEditDeleteReplyObj.H1OnThreadDetails();
		topicDetailsObj.clickFirstBtnReply();
		AddEditDeleteReplyObj.EnterDescription(ExcelDataUtilObj.getData(sheetName3, 1, 0));
		AddEditDeleteReplyObj.clickBtnSubmitReply();
		String Msg5Char = testUtil.Switch_ToAlert_GetText_And_Accept_Alert();
		S1.assertEquals(Msg5Char,
				"The message you have entered is too short. Please lengthen your message to at least 5 characters.",
				"Message is incorrect");
		AddEditDeleteReplyObj.clearDescription();
		AddEditDeleteReplyObj.EnterDescription(ExcelDataUtilObj.getData(sheetName3, 2, 0));
		AddEditDeleteReplyObj.clickBtnSubmitReply();
		String Msg10000Char = AddEditDeleteTopicObj.MsgErrors10000();
		S1.assertEquals(Msg10000Char, "The text that you have entered is too long",
				"Description Accepts more than 10000 Characters");
		AddEditDeleteReplyObj.clearDescription();
		AddEditDeleteReplyObj.EnterDescription(ExcelDataUtilObj.getData(sheetName3, 3, 0));
		AddEditDeleteReplyObj.clickBtnSubmitReply();
		String H1OnThreadDetailsAfterSubmitReply = AddEditDeleteReplyObj.H1OnThreadDetails();
		S1.assertEquals(H1OnThreadDetails, H1OnThreadDetailsAfterSubmitReply, "The Reply to the Thread is not added");
		S1.assertTrue(topicDetailsObj.BtnPostMsgisDisplayed());

		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Description Categories: Verified Submit Reply Button On Post A New Reply from First Reply Button on Thread Details Page");
	}

	// Verify Submit Reply Button
	// Enter Keyword in Search box-->Click on First Thread-->>Click on First Reply button-->Enter Description and Click on Submit Reply Button
	@Test(priority = 20, invocationCount=3)
	public void verifySubmitReply_SearchResultsFirstReplyBtn() throws InterruptedException {
		SoftAssert S1 = new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		topicDetailsObj.EnterDataSearchBx(ExcelDataUtilObj.getData(sheetName, 1, 4));
		topicDetailsObj.clickBtnSearch();
		topicDetailsObj.clickH2FirstSubCategory();

		String H1OnThreadDetails = AddEditDeleteReplyObj.H1OnThreadDetails();
		topicDetailsObj.clickFirstBtnReply();
		AddEditDeleteReplyObj.EnterDescription(ExcelDataUtilObj.getData(sheetName3, 1, 0));
		AddEditDeleteReplyObj.clickBtnSubmitReply();
		String Msg5Char = testUtil.Switch_ToAlert_GetText_And_Accept_Alert();
		S1.assertEquals(Msg5Char,
				"The message you have entered is too short. Please lengthen your message to at least 5 characters.",
				"Message is incorrect");
		AddEditDeleteReplyObj.clearDescription();
		AddEditDeleteReplyObj.EnterDescription(ExcelDataUtilObj.getData(sheetName3, 2, 0));
		AddEditDeleteReplyObj.clickBtnSubmitReply();
		String Msg10000Char = AddEditDeleteTopicObj.MsgErrors10000();
		S1.assertEquals(Msg10000Char, "The text that you have entered is too long",
				"Description Accepts more than 10000 Characters");
		AddEditDeleteReplyObj.clearDescription();
		AddEditDeleteReplyObj.EnterDescription(ExcelDataUtilObj.getData(sheetName3, 3, 0));
		AddEditDeleteReplyObj.clickBtnSubmitReply();
		String H1OnThreadDetailsAfterSubmitReply = AddEditDeleteReplyObj.H1OnThreadDetails();
		S1.assertEquals(H1OnThreadDetails, H1OnThreadDetailsAfterSubmitReply, "The Reply to the Thread is not added");
		S1.assertTrue(topicDetailsObj.BtnPostMsgisDisplayed());
		testUtilObj.logOut();
		S1.assertAll();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("Search Results: Verified Submit Reply Button On Post A New Reply from First Reply Button on Thread Details Page");
	}

	// Verify Submit Reply Button
	// Enter Keyword in Search box-->Click on First View Button->>Click on First Reply Button-->Enter Description and Click on Submit Reply Button
	@Test(priority = 21, invocationCount=3)
	public void verifySubmitReply_ViewFirstReplyBtn() throws InterruptedException {
		SoftAssert S1 = new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		topicDetailsObj.EnterDataSearchBx(ExcelDataUtilObj.getData(sheetName, 1, 4));
		topicDetailsObj.clickBtnSearch();
		topicDetailsObj.clickBtnFirstView();

		String H1OnThreadDetails = AddEditDeleteReplyObj.H1OnThreadDetails();
		topicDetailsObj.clickFirstBtnReply();
		AddEditDeleteReplyObj.EnterDescription(ExcelDataUtilObj.getData(sheetName3, 1, 0));
		AddEditDeleteReplyObj.clickBtnSubmitReply();
		String Msg5Char = testUtil.Switch_ToAlert_GetText_And_Accept_Alert();
		S1.assertEquals(Msg5Char,
				"The message you have entered is too short. Please lengthen your message to at least 5 characters.",
				"Message is incorrect");
		AddEditDeleteReplyObj.clearDescription();
		AddEditDeleteReplyObj.EnterDescription(ExcelDataUtilObj.getData(sheetName3, 2, 0));
		AddEditDeleteReplyObj.clickBtnSubmitReply();
		String Msg10000Char = AddEditDeleteTopicObj.MsgErrors10000();
		S1.assertEquals(Msg10000Char, "The text that you have entered is too long",
				"Description Accepts more than 10000 Characters");
		AddEditDeleteReplyObj.clearDescription();
		AddEditDeleteReplyObj.EnterDescription(ExcelDataUtilObj.getData(sheetName3, 3, 0));
		AddEditDeleteReplyObj.clickBtnSubmitReply();
		String H1OnThreadDetailsAfterSubmitReply = AddEditDeleteReplyObj.H1OnThreadDetails();
		S1.assertEquals(H1OnThreadDetails, H1OnThreadDetailsAfterSubmitReply, "The Reply to the Thread is not added");
		S1.assertTrue(topicDetailsObj.BtnPostMsgisDisplayed());
		testUtilObj.logOut();
		S1.assertAll();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("View: Verified Submit Reply Button On Post A New Reply from First Reply Button on Thread Details Page");
	}

	// Verify the Breadcrumbs link
	//// Click on Disc Categories-->Click on First Thread-->>Click on First Reply Button-->Click on All the sub links
	@Test(priority = 22, invocationCount=3)
	public void verifyBreadCrumbs_DiscCategoriesFirstReplyBtn() throws InterruptedException {
		SoftAssert S1 = new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		searchTopicObj.clickBeefProd();
		String H1BeefProd = searchTopicObj.H1BeefProd();
		topicDetailsObj.clickH2FirstSubCategory();
		String H1OnThreadDetails = AddEditDeleteReplyObj.H1OnThreadDetails();
		topicDetailsObj.clickFirstBtnReply();
		AddEditDeleteReplyObj.clickThreadTitlelink();
		String H1OnNavigation = AddEditDeleteReplyObj.H1OnThreadDetails();
		S1.assertEquals(H1OnThreadDetails, H1OnNavigation, "The Thread Title do not match");
		S1.assertTrue(topicDetailsObj.BtnPostMsgisDisplayed());
		testUtil.navigateToPreviouPage();

		AddEditDeleteReplyObj.clickDiscCategorieslink();
		String ColThreadTitleStarter = searchTopicObj.ColThreadTitleStarter();
		S1.assertEquals(ColThreadTitleStarter, "TITLE / THREAD STARTER");
		String ColAuthor = searchTopicObj.ColAuthor();
		S1.assertEquals(ColAuthor, "AUTHOR");
		String ColRepliesView = searchTopicObj.ColRepliesView();
		S1.assertEquals(ColRepliesView, "REPLIES / VIEWS");
		String ColLastPostBy = searchTopicObj.ColLastPostBy();
		S1.assertEquals(ColLastPostBy, "LAST POST BY");
		String H1BeefProdNavigation = searchTopicObj.H1BeefProd();
		S1.assertEquals(H1BeefProd, H1BeefProdNavigation);
		testUtil.navigateToPreviouPage();
		AddEditDeleteReplyObj.clickForumlink();
		String Title = testUtil.getTitleOfPage();
		S1.assertEquals(Title, "Farming and Agriculture Discussion Forum | Agriville.com");
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("Discussion Categories: Verified the Breadcrumbs from First Reply Button on Thread Details Page");
		S1.assertAll();

	}

	// Verify the Breadcrumbs link
	// Enter Keyword in Search box-->Click on First Thread-->>Click on First Reply Button-->Click on All the sub links
	@Test(priority = 23, invocationCount=3)
	public void verifyBreadCrumbs_SearchResultsFirstReplyBtn() throws InterruptedException {
		SoftAssert S1 = new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		topicDetailsObj.EnterDataSearchBx(ExcelDataUtilObj.getData(sheetName, 1, 4));
		topicDetailsObj.clickBtnSearch();
		//String H2FirstSubCategory = searchTopicObj.H2FirstSubCategory();
		topicDetailsObj.clickH2FirstSubCategory();
		String H1OnThreadDetails = AddEditDeleteReplyObj.H1OnThreadDetails();
		topicDetailsObj.clickFirstBtnReply();
		AddEditDeleteReplyObj.clickThreadTitlelink();
		String H1OnNavigation = AddEditDeleteReplyObj.H1OnThreadDetails();
		S1.assertEquals(H1OnThreadDetails, H1OnNavigation, "The Thread Title do not match");
		S1.assertTrue(topicDetailsObj.BtnPostMsgisDisplayed());
		testUtil.navigateToPreviouPage();

		AddEditDeleteReplyObj.clickDiscCategorieslink();
		String ColThreadTitleStarter = searchTopicObj.ColThreadTitleStarter();
		S1.assertEquals(ColThreadTitleStarter, "TITLE / THREAD STARTER");
		String ColAuthor = searchTopicObj.ColAuthor();
		S1.assertEquals(ColAuthor, "AUTHOR");
		String ColRepliesView = searchTopicObj.ColRepliesView();
		S1.assertEquals(ColRepliesView, "REPLIES / VIEWS");
		String ColLastPostBy = searchTopicObj.ColLastPostBy();
		S1.assertEquals(ColLastPostBy, "LAST POST BY");
		//String H2FirstSubCategoryNavigation = searchTopicObj.H2FirstSubCategory();
	//	S1.assertEquals(H2FirstSubCategory, H2FirstSubCategoryNavigation);
		testUtil.navigateToPreviouPage();
		AddEditDeleteReplyObj.clickForumlink();
		String Title = testUtil.getTitleOfPage();
		S1.assertEquals(Title, "Farming and Agriculture Discussion Forum | Agriville.com");
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("Search Result: Verified the Breadcrumbs link  from First Reply Button on Thread Details Page");
		S1.assertAll();

	}

	// Verify the Breadcrumbs link
	// Enter Keyword in Search box-->Click on First View Button-->>Click on First Reply Button-->Click on All the sub links
	@Test(priority = 24, invocationCount=3)
	public void verifyBreadCrumbs_ViewFirstReplyBtn() throws InterruptedException {
		SoftAssert S1 = new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		topicDetailsObj.EnterDataSearchBx(ExcelDataUtilObj.getData(sheetName, 1, 4));
		topicDetailsObj.clickBtnSearch();
		//String H2FirstSubCategory = searchTopicObj.H2FirstSubCategory();
		topicDetailsObj.clickBtnFirstView();
		String H1OnThreadDetails = AddEditDeleteReplyObj.H1OnThreadDetails();
		topicDetailsObj.clickFirstBtnReply();
		AddEditDeleteReplyObj.clickThreadTitlelink();
		String H1OnNavigation = AddEditDeleteReplyObj.H1OnThreadDetails();
		S1.assertEquals(H1OnThreadDetails, H1OnNavigation, "The Thread Title do not match");
		S1.assertTrue(topicDetailsObj.BtnPostMsgisDisplayed());
		testUtil.navigateToPreviouPage();

		AddEditDeleteReplyObj.clickDiscCategorieslink();
		String ColThreadTitleStarter = searchTopicObj.ColThreadTitleStarter();
		S1.assertEquals(ColThreadTitleStarter, "TITLE / THREAD STARTER");
		String ColAuthor = searchTopicObj.ColAuthor();
		S1.assertEquals(ColAuthor, "AUTHOR");
		String ColRepliesView = searchTopicObj.ColRepliesView();
		S1.assertEquals(ColRepliesView, "REPLIES / VIEWS");
		String ColLastPostBy = searchTopicObj.ColLastPostBy();
		S1.assertEquals(ColLastPostBy, "LAST POST BY");
	//	String H2FirstSubCategoryNavigation = searchTopicObj.H2FirstSubCategory();
	//	S1.assertEquals(H2FirstSubCategory, H2FirstSubCategoryNavigation);
		testUtil.navigateToPreviouPage();
		AddEditDeleteReplyObj.clickForumlink();
		String Title = testUtil.getTitleOfPage();
		S1.assertEquals(Title, "Farming and Agriculture Discussion Forum | Agriville.com");
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("View: Verified the Breadcrumbs from First Reply Button on Thread Details Page");
		S1.assertAll();

	}

	/**************************************************************************************************************************************/
	/**************************************************************************************************************************************/
	// Verify Reply to this thread button on Thread Details Page
	// Disc Categories-->Click on First Thread-->>Click on Reply to this thread at Bottom
	@Test(priority = 25, invocationCount=3)
	public void verifyPostANewReply_DiscCategoriesReplyToThisThread() throws InterruptedException {

		SoftAssert S1 = new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		searchTopicObj.clickBeefProd();
		topicDetailsObj.clickH2FirstSubCategory();
		topicDetailsObj.clickReplyToThisThreadLink();
		String ForumTitle = AddEditDeleteReplyObj.ForumTitle();
		S1.assertTrue(ForumTitle.contains("Reply to Thread"));
		String H1PostReply = topicDetailsObj.MsgPostNewReply();
		S1.assertEquals(H1PostReply, "Post a New Reply");
		ArrayList<Boolean> listObj = AddEditDeleteReplyObj.AllElementOnReplyThread();
		for (int i = 0; i < listObj.size(); i++) {
			S1.assertTrue(listObj.get(i), "Element is not Present on Reply Page");
		}
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Disc Categories: Verified Post A new reply Page from Reply to this Thread link at Bottom");
	}

	// Verify Reply to this thread button on Thread Details Page
	// Enter Keyword in Search box-->Click on First Thread-->>Click on Reply to this Thread button at Bottom
	@Test(priority = 26, invocationCount=3)
	public void verifyPostANewReply_SearchResultReplyToThisThread() throws InterruptedException {
		SoftAssert S1 = new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		topicDetailsObj.EnterDataSearchBx(ExcelDataUtilObj.getData(sheetName, 1, 4));
		topicDetailsObj.clickBtnSearch();
		topicDetailsObj.clickH2FirstSubCategory();
		topicDetailsObj.clickReplyToThisThreadLink();
		String ForumTitle = AddEditDeleteReplyObj.ForumTitle();
		S1.assertTrue(ForumTitle.contains("Reply to Thread"));
		String H1PostReply = topicDetailsObj.MsgPostNewReply();
		S1.assertEquals(H1PostReply, "Post a New Reply");
		ArrayList<Boolean> listObj = AddEditDeleteReplyObj.AllElementOnReplyThread();
		for (int i = 0; i < listObj.size(); i++) {
			S1.assertTrue(listObj.get(i), "Element is not Present on Reply Page");
		}
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Search Result: Verified Post A new reply Page from Reply to this Thread link at Bottom");
	}

	// Verify Post A message button on Thread Details Page
	// Enter Keyword in Search box-->Click on View Button for First Thread-->>Click on Reply to This Thread
	@Test(priority = 27, invocationCount=3)
	public void verifyPostANewReply_ViewReplyToThisThread() throws InterruptedException {
		SoftAssert S1 = new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		topicDetailsObj.EnterDataSearchBx(ExcelDataUtilObj.getData(sheetName, 1, 4));
		topicDetailsObj.clickBtnSearch();
		topicDetailsObj.clickBtnFirstView();
		topicDetailsObj.clickReplyToThisThreadLink();
		String ForumTitle = AddEditDeleteReplyObj.ForumTitle();
		S1.assertTrue(ForumTitle.contains("Reply to Thread"));
		String H1PostReply = topicDetailsObj.MsgPostNewReply();
		S1.assertEquals(H1PostReply, "Post a New Reply");
		ArrayList<Boolean> listObj = AddEditDeleteReplyObj.AllElementOnReplyThread();
		for (int i = 0; i < listObj.size(); i++) {
			S1.assertTrue(listObj.get(i), "Element is not Present on Reply Page");
		}
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("View: Verified Post A new reply Page from Reply from Reply To This Thread link at Bottom");

	}

	// Verify Preview Post Button
	// Click on Disc Categories-->Click on First Thread-->>Click on Reply to This Thread-->Enter Description and Click on Preview Post Button
	@Test(priority = 28, invocationCount=3)
	public void verifyPreviewPost_DiscCategoriesReplyToThisThreadBtn() throws InterruptedException {
		SoftAssert S1 = new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		searchTopicObj.clickBeefProd();
		topicDetailsObj.clickH2FirstSubCategory();
		topicDetailsObj.clickReplyToThisThreadLink();
		AddEditDeleteReplyObj.EnterDescription(ExcelDataUtilObj.getData(sheetName3, 1, 0));
		AddEditDeleteReplyObj.clickBtnPreviewReply();
		String Msg5Char = testUtil.Switch_ToAlert_GetText_And_Accept_Alert();
		S1.assertEquals(Msg5Char,
				"The message you have entered is too short. Please lengthen your message to at least 5 characters.",
				"Message is incorrect");
		AddEditDeleteReplyObj.clearDescription();
		AddEditDeleteReplyObj.EnterDescription(ExcelDataUtilObj.getData(sheetName3, 2, 0));
		AddEditDeleteReplyObj.clickBtnPreviewReply();
		String Msg10000Char = AddEditDeleteTopicObj.MsgErrors10000();
		S1.assertEquals(Msg10000Char, "The text that you have entered is too long",
				"Description Accepts more than 10000 Characters");
		AddEditDeleteReplyObj.clearDescription();
		AddEditDeleteReplyObj.EnterDescription(ExcelDataUtilObj.getData(sheetName3, 3, 0));
		AddEditDeleteReplyObj.clickBtnPreviewReply();
		String TxtPreview = AddEditDeleteTopicObj.TxtPreview();
		S1.assertEquals(TxtPreview, "Preview");
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Description Categories: Verified Preview Button On Post A New Reply from Reply To This Thread link at Bottom");
	}

	// Verify Preview Post Button
	// Enter Keyword in Search box-->Click on First Thread-->>Click on Reply To this Thread at Bottom-->Enter Description and Click on Preview Post Button
	@Test(priority = 29, invocationCount=3)
	public void verifyPreviewPost_SearchResultsReplyToThisThreadBtn() throws InterruptedException {
		SoftAssert S1 = new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		topicDetailsObj.EnterDataSearchBx(ExcelDataUtilObj.getData(sheetName, 1, 4));
		topicDetailsObj.clickBtnSearch();
		topicDetailsObj.clickH2FirstSubCategory();
		topicDetailsObj.clickReplyToThisThreadLink();
		AddEditDeleteReplyObj.EnterDescription(ExcelDataUtilObj.getData(sheetName3, 1, 0));
		AddEditDeleteReplyObj.clickBtnPreviewReply();
		String Msg5Char = testUtil.Switch_ToAlert_GetText_And_Accept_Alert();
		S1.assertEquals(Msg5Char,
				"The message you have entered is too short. Please lengthen your message to at least 5 characters.",
				"Message is incorrect");
		AddEditDeleteReplyObj.clearDescription();
		AddEditDeleteReplyObj.EnterDescription(ExcelDataUtilObj.getData(sheetName3, 2, 0));
		AddEditDeleteReplyObj.clickBtnPreviewReply();
		String Msg10000Char = AddEditDeleteTopicObj.MsgErrors10000();
		S1.assertEquals(Msg10000Char, "The text that you have entered is too long",
				"Description Accepts more than 10000 Characters");
		AddEditDeleteReplyObj.clearDescription();
		AddEditDeleteReplyObj.EnterDescription(ExcelDataUtilObj.getData(sheetName3, 3, 0));
		AddEditDeleteReplyObj.clickBtnPreviewReply();
		String TxtPreview = AddEditDeleteTopicObj.TxtPreview();
		S1.assertEquals(TxtPreview, "Preview");
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Search Results: Verified Preview Button On Post A New Reply from Reply To This Thread link at Bottom");
	}

	// Verify Preview Post Button
	// Enter Keyword in Search box-->Click on First View Button->>Click on Reply To This Thread at Bottom-->Enter Description and Click on Preview Post Button
	@Test(priority = 30, invocationCount=3)
	public void verifyPreviewPost_ViewReplyToThisThreadBtn() throws InterruptedException {
		SoftAssert S1 = new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		topicDetailsObj.EnterDataSearchBx(ExcelDataUtilObj.getData(sheetName, 1, 4));
		topicDetailsObj.clickBtnSearch();
		topicDetailsObj.clickBtnFirstView();

		topicDetailsObj.clickReplyToThisThreadLink();
		AddEditDeleteReplyObj.EnterDescription(ExcelDataUtilObj.getData(sheetName3, 1, 0));
		AddEditDeleteReplyObj.clickBtnPreviewReply();
		String Msg5Char = testUtil.Switch_ToAlert_GetText_And_Accept_Alert();
		S1.assertEquals(Msg5Char,
				"The message you have entered is too short. Please lengthen your message to at least 5 characters.",
				"Message is incorrect");
		AddEditDeleteReplyObj.clearDescription();
		AddEditDeleteReplyObj.EnterDescription(ExcelDataUtilObj.getData(sheetName3, 2, 0));
		AddEditDeleteReplyObj.clickBtnPreviewReply();
		String Msg10000Char = AddEditDeleteTopicObj.MsgErrors10000();
		S1.assertEquals(Msg10000Char, "The text that you have entered is too long",
				"Description Accepts more than 10000 Characters");
		AddEditDeleteReplyObj.clearDescription();
		AddEditDeleteReplyObj.EnterDescription(ExcelDataUtilObj.getData(sheetName3, 3, 0));
		AddEditDeleteReplyObj.clickBtnPreviewReply();
		String TxtPreview = AddEditDeleteTopicObj.TxtPreview();
		S1.assertEquals(TxtPreview, "Preview");

		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("View: Verified Preview Button On Post A New Reply from Reply To This Thread link at Bottom");
	}

	// Verify Submit Reply Button
	// Click on Disc Categories-->Click on First Thread-->>Click on Reply To This Thread at Bottom-->Enter Description and Click on Submit Reply Button
	@Test(priority = 31, invocationCount=3)
	public void verifySubmitReply_DiscCategoriesReplyToThisThreadBtn() throws InterruptedException {
		SoftAssert S1 = new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		searchTopicObj.clickBeefProd();
		topicDetailsObj.clickH2FirstSubCategory();
		String H1OnThreadDetails = AddEditDeleteReplyObj.H1OnThreadDetails();
		topicDetailsObj.clickReplyToThisThreadLink();
		AddEditDeleteReplyObj.EnterDescription(ExcelDataUtilObj.getData(sheetName3, 1, 0));
		AddEditDeleteReplyObj.clickBtnSubmitReply();
		String Msg5Char = testUtil.Switch_ToAlert_GetText_And_Accept_Alert();
		S1.assertEquals(Msg5Char,
				"The message you have entered is too short. Please lengthen your message to at least 5 characters.",
				"Message is incorrect");
		AddEditDeleteReplyObj.clearDescription();
		AddEditDeleteReplyObj.EnterDescription(ExcelDataUtilObj.getData(sheetName3, 2, 0));
		AddEditDeleteReplyObj.clickBtnSubmitReply();
		String Msg10000Char = AddEditDeleteTopicObj.MsgErrors10000();
		S1.assertEquals(Msg10000Char, "The text that you have entered is too long",
				"Description Accepts more than 10000 Characters");
		AddEditDeleteReplyObj.clearDescription();
		AddEditDeleteReplyObj.EnterDescription(ExcelDataUtilObj.getData(sheetName3, 3, 0));
		AddEditDeleteReplyObj.clickBtnSubmitReply();
		String H1OnThreadDetailsAfterSubmitReply = AddEditDeleteReplyObj.H1OnThreadDetails();
		S1.assertEquals(H1OnThreadDetails, H1OnThreadDetailsAfterSubmitReply, "The Reply to the Thread is not added");
		S1.assertTrue(topicDetailsObj.BtnPostMsgisDisplayed());

		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Description Categories: Verified Submit Reply Button On Post A New Reply from Reply To This Thread link at Bottom");
	}

	// Verify Submit Reply Button
	// Enter Keyword in Search box-->Click on First Thread-->>Click on Reply To This Thread at Bottom
	// Enter Description and Click on Submit Reply Button
	@Test(priority = 32, invocationCount=3)
	public void verifySubmitReply_SearchResultsReplyToThisThreadBtn() throws InterruptedException {
		SoftAssert S1 = new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		topicDetailsObj.EnterDataSearchBx(ExcelDataUtilObj.getData(sheetName, 1, 4));
		topicDetailsObj.clickBtnSearch();
		topicDetailsObj.clickH2FirstSubCategory();

		String H1OnThreadDetails = AddEditDeleteReplyObj.H1OnThreadDetails();
		topicDetailsObj.clickReplyToThisThreadLink();
		AddEditDeleteReplyObj.EnterDescription(ExcelDataUtilObj.getData(sheetName3, 1, 0));
		AddEditDeleteReplyObj.clickBtnSubmitReply();
		String Msg5Char = testUtil.Switch_ToAlert_GetText_And_Accept_Alert();
		S1.assertEquals(Msg5Char,
				"The message you have entered is too short. Please lengthen your message to at least 5 characters.",
				"Message is incorrect");
		AddEditDeleteReplyObj.clearDescription();
		AddEditDeleteReplyObj.EnterDescription(ExcelDataUtilObj.getData(sheetName3, 2, 0));
		AddEditDeleteReplyObj.clickBtnSubmitReply();
		String Msg10000Char = AddEditDeleteTopicObj.MsgErrors10000();
		S1.assertEquals(Msg10000Char, "The text that you have entered is too long",
				"Description Accepts more than 10000 Characters");
		AddEditDeleteReplyObj.clearDescription();
		AddEditDeleteReplyObj.EnterDescription(ExcelDataUtilObj.getData(sheetName3, 3, 0));
		AddEditDeleteReplyObj.clickBtnSubmitReply();
		String H1OnThreadDetailsAfterSubmitReply = AddEditDeleteReplyObj.H1OnThreadDetails();
		S1.assertEquals(H1OnThreadDetails, H1OnThreadDetailsAfterSubmitReply, "The Reply to the Thread is not added");
		S1.assertTrue(topicDetailsObj.BtnPostMsgisDisplayed());
		testUtilObj.logOut();
		S1.assertAll();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("Search Results: Verified Submit Reply Button On Post A New Reply from Reply To This Thread link at Bottom");
	}

	// Verify Submit Reply Button
	// Enter Keyword in Search box-->Click on First View Button-->>Click on Reply To This Thread at Bottom
	// Enter Description and Click on Submit Reply Button
	@Test(priority = 33, invocationCount=3)
	public void verifySubmitReply_ViewReplyToThisThreadBtn() throws InterruptedException {
		SoftAssert S1 = new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		topicDetailsObj.EnterDataSearchBx(ExcelDataUtilObj.getData(sheetName, 1, 4));
		topicDetailsObj.clickBtnSearch();
		topicDetailsObj.clickBtnFirstView();

		String H1OnThreadDetails = AddEditDeleteReplyObj.H1OnThreadDetails();
		topicDetailsObj.clickReplyToThisThreadLink();
		AddEditDeleteReplyObj.EnterDescription(ExcelDataUtilObj.getData(sheetName3, 1, 0));
		AddEditDeleteReplyObj.clickBtnSubmitReply();
		String Msg5Char = testUtil.Switch_ToAlert_GetText_And_Accept_Alert();
		S1.assertEquals(Msg5Char,
				"The message you have entered is too short. Please lengthen your message to at least 5 characters.",
				"Message is incorrect");
		AddEditDeleteReplyObj.clearDescription();
		AddEditDeleteReplyObj.EnterDescription(ExcelDataUtilObj.getData(sheetName3, 2, 0));
		AddEditDeleteReplyObj.clickBtnSubmitReply();
		String Msg10000Char = AddEditDeleteTopicObj.MsgErrors10000();
		S1.assertEquals(Msg10000Char, "The text that you have entered is too long",
				"Description Accepts more than 10000 Characters");
		AddEditDeleteReplyObj.clearDescription();
		AddEditDeleteReplyObj.EnterDescription(ExcelDataUtilObj.getData(sheetName3, 3, 0));
		AddEditDeleteReplyObj.clickBtnSubmitReply();
		String H1OnThreadDetailsAfterSubmitReply = AddEditDeleteReplyObj.H1OnThreadDetails();
		S1.assertEquals(H1OnThreadDetails, H1OnThreadDetailsAfterSubmitReply, "The Reply to the Thread is not added");
		S1.assertTrue(topicDetailsObj.BtnPostMsgisDisplayed());
		testUtilObj.logOut();
		S1.assertAll();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("View: Verified Submit Reply Button On Post A New Reply from Reply To This Thread link at Bottom");
	}

	
	//Verify Delete Reply
	@Test(priority = 34, invocationCount=3)
	public void verifyDeleteReply() throws InterruptedException
	{
		//SoftAssert S1 = new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		AddEditDeleteTopicObj.clickProfileLink();
		int TotalElements=AddEditDeleteReplyObj.ThreadReplyOnMemberPage();
		for(int i=0;i<TotalElements;i++)
		{
		AddEditDeleteTopicObj.clickProfileLink();
		AddEditDeleteReplyObj.clickFirstThreadReplyOnMemberPage();
		AddEditDeleteReplyObj.clickEditBtn();
		AddEditDeleteTopicObj.clickChkBxDelete();
		AddEditDeleteTopicObj.clickBtnDeletePost();
		AddEditDeleteTopicObj.clickProfileLink();
		}
		testUtilObj.logOut();
		System.out.println("Verified the Reply is Deleted using Delete Button");
		
	}
	
	
	//Verify Delete Post
		@Test(priority = 35, invocationCount=3)
		public void verifyDeleteThread() throws InterruptedException
		{
			//SoftAssert S1 = new SoftAssert();
			testUtilObj.loginWithActiveAccount();
			AddEditDeleteTopicObj.clickProfileLink();
			int TotalElements=AddEditDeleteReplyObj.ThreadTitleOnMemberPage();
			for(int i=0;i<TotalElements;i++)
			{
			AddEditDeleteTopicObj.clickProfileLink();
			AddEditDeleteReplyObj.clickFirstThreadTitleOnMemberPage();
			AddEditDeleteReplyObj.clickEditBtn();
			AddEditDeleteTopicObj.clickChkBxDelete();
			AddEditDeleteTopicObj.clickBtnDeletePost();
			AddEditDeleteTopicObj.clickProfileLink();
			}
			testUtilObj.logOut();
			System.out.println("Verified the Delete  Theard using delete Button");
			
		}
	
	@AfterClass
	public void TearDown() {
		driver.quit();
	}

}
