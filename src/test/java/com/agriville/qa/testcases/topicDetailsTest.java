package com.agriville.qa.testcases;

import java.util.ArrayList;
import java.util.HashMap;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.agriville.qa.base.TestBase;
import com.agriville.qa.pages.loginPage;
import com.agriville.qa.pages.searchTopic;
import com.agriville.qa.pages.topicDetails;
import com.agriville.qa.util.ExcelDataUtil;
import com.agriville.qa.util.testUtil;

public class topicDetailsTest extends TestBase 
{

	topicDetails topicDetailsObj;
	ExcelDataUtil ExcelDataUtilObj;
	loginPage loginPageObj;
	searchTopic searchTopicObj;
	String Path="E://Script Agriville//AgrivilleTest//src//main//java//com//agriville//qa//testdata//Agriville.xlsx";
	String sheetName="Disc_Categories";
	String sheetName1="Disc_CategoriesLogin";
	
	
	public topicDetailsTest()
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
		ExcelDataUtilObj=new ExcelDataUtil(Path);
		loginPageObj=new loginPage();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	//Verify Thread Details page from Keywords result page
	@Test(priority=1)
	public void verifyTitleOfThreadFromSearchResultpage()
	{
		SoftAssert S1=new SoftAssert();
		topicDetailsObj.EnterDataSearchBx(ExcelDataUtilObj.getData(sheetName, 1, 4));
		topicDetailsObj.clickBtnSearch();
		
		String Str1=topicDetailsObj.H2FirstSubCategory();
		topicDetailsObj.clickH2FirstSubCategory();
		String Str2=topicDetailsObj.h1OnThreadPage();
		
		S1.assertTrue(Str1.contains(Str2));
		topicDetailsObj.clicklinkToSubPage();

		S1.assertAll();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified Title Header on Sub Page Under Forum from Search Result Page");
		
	}
	// Verify Username on Thread Details Page with Login and Without Login
	//Navigate from Thread Result page to Thread Details Page
	@Test(priority=2)
	public void verifyUNWithAndWithoutLogin() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		topicDetailsObj.EnterDataSearchBx(ExcelDataUtilObj.getData(sheetName, 1, 4));
		topicDetailsObj.clickBtnSearch();
		String Str1=topicDetailsObj.FirstUNUnderThreadTitle();
		topicDetailsObj.clickFirstUNUnderThreadTitle();
		String Str2= topicDetailsObj.MsgLoginPage();
		String Str3=topicDetailsObj.MsgH1Login();
		
		S1.assertEquals(Str2, "Message");
		S1.assertEquals(Str3, "Log in");
		
		loginPageObj.EmailLP(ExcelDataUtilObj.getData(sheetName1, 2, 0));
		loginPageObj.PasswordLP(ExcelDataUtilObj.getData(sheetName1, 2, 1));
		testUtil.Scroll_DownFull_Page();
		loginPageObj.clickLoginBtnLP();
		String Str4=topicDetailsObj.NameOfMember();
		S1.assertEquals(Str1, Str4,"The String do not Match");
		loginPageObj.clickArrowBtn();
		loginPageObj.clickLogOutBtn();
		testUtil.Switch_To_Alert_Accept();
		loginPageObj.clickAgrivilleLogo();
		
		loginPageObj.clickLogin();
		Thread.sleep(4000);
		loginPageObj.UserName(ExcelDataUtilObj.getData(sheetName1, 2, 0));
		loginPageObj.Password(ExcelDataUtilObj.getData(sheetName1, 2, 1));
		loginPageObj.clickLoginBtnOnLoginFrame();
		
		topicDetailsObj.EnterDataSearchBx(ExcelDataUtilObj.getData(sheetName, 1, 4));
		topicDetailsObj.clickBtnSearch();
		String Str5=topicDetailsObj.FirstUNUnderThreadTitle();
		topicDetailsObj.clickFirstUNUnderThreadTitle();
		
		String Str6=topicDetailsObj.NameOfMember();
		S1.assertEquals(Str5, Str6,"The String Do not Match");;
		loginPageObj.clickArrowBtn();
		loginPageObj.clickLogOutBtn();
		testUtil.Switch_To_Alert_Accept();
		S1.assertAll();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified Username with and without Login from search result page");
		
		
	}

	// Verify Last Post By on Thread Details Page with Login and Without Login
	//Navigate from Thread Result page to Thread Details Page
	@Test(priority=3)
	public void verifyLastPostByWithAndWithoutLogin() throws InterruptedException
	{
	
		SoftAssert S1=new SoftAssert();
		topicDetailsObj.EnterDataSearchBx(ExcelDataUtilObj.getData(sheetName, 1, 4));
		topicDetailsObj.clickBtnSearch();
		String Str1=topicDetailsObj.FirstLastPostByOnSearchResult();
		topicDetailsObj.clickFirstLastPostByOnSearchResult();
		String Str2= topicDetailsObj.MsgLoginPage();
		String Str3=topicDetailsObj.MsgH1Login();
		
		S1.assertEquals(Str2, "Message");
		S1.assertEquals(Str3, "Log in");
		
		loginPageObj.EmailLP(ExcelDataUtilObj.getData(sheetName1, 2, 0));
		loginPageObj.PasswordLP(ExcelDataUtilObj.getData(sheetName1, 2, 1));
		testUtil.Scroll_DownFull_Page();
		loginPageObj.clickLoginBtnLP();
		String Str4=topicDetailsObj.NameOfMember();
		S1.assertEquals(Str1, Str4,"The String do not Match");
		loginPageObj.clickArrowBtn();
		loginPageObj.clickLogOutBtn();
		testUtil.Switch_To_Alert_Accept();
		loginPageObj.clickAgrivilleLogo();
		
		loginPageObj.clickLogin();
		Thread.sleep(4000);
		loginPageObj.UserName(ExcelDataUtilObj.getData(sheetName1, 2, 0));
		loginPageObj.Password(ExcelDataUtilObj.getData(sheetName1, 2, 1));
		loginPageObj.clickLoginBtnOnLoginFrame();
		
		topicDetailsObj.EnterDataSearchBx(ExcelDataUtilObj.getData(sheetName, 1, 4));
		topicDetailsObj.clickBtnSearch();
		String Str5=topicDetailsObj.FirstLastPostByOnSearchResult();
		topicDetailsObj.clickFirstLastPostByOnSearchResult();
		
		String Str6=topicDetailsObj.NameOfMember();
		S1.assertEquals(Str5, Str6,"The String Do not Match");;
		loginPageObj.clickArrowBtn();
		loginPageObj.clickLogOutBtn();
		testUtil.Switch_To_Alert_Accept();
		S1.assertAll();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified Username with and without Login from search result page");
		
	}
	// Verify Title Header
	//Navigate from Thread Result page to Thread Details Page and Verify the Title Header
	@Test(priority=4)
	public void verifyViewFromSearchResultPage() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		topicDetailsObj.EnterDataSearchBx(ExcelDataUtilObj.getData(sheetName, 1, 4));
		topicDetailsObj.clickBtnSearch();
		String Str1=topicDetailsObj.H2FirstSubCategory();
		topicDetailsObj.clickBtnFirstView();
		String Str2=topicDetailsObj.h1OnThreadPage();
		
		S1.assertTrue(Str1.contains(Str2));
		topicDetailsObj.clicklinkToSubPage();

		S1.assertAll();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified Title Header on Sub Page Under Forum from Search Result Page");
		
	}
	// Verify Post Message Button on Thread Details Page
	// Navigate to Thread Details page from Beef Production
	//Enter the Login credentials of Inactive Account and Verify the Post Message Button
	@Test(priority=5)
	public void verifyPostMessageDiscCategories_InactiveAcc() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		searchTopicObj.clickBeefProd();
		topicDetailsObj.clickH2FirstSubCategory();
		topicDetailsObj.clickBtnPostMsg();
		String Str1= topicDetailsObj.MsgLoginPage();
		String Str2=topicDetailsObj.MsgH1Login();
		
		S1.assertEquals(Str1, "Message");
		S1.assertEquals(Str2, "Log in");
		
		loginPageObj.EmailLP(ExcelDataUtilObj.getData(sheetName1, 1, 0));
		loginPageObj.PasswordLP(ExcelDataUtilObj.getData(sheetName1, 1, 1));
		testUtil.Scroll_DownFull_Page();
		loginPageObj.clickLoginBtnLP();
		String Str3=topicDetailsObj.MsgAccountNotActivated();
		S1.assertEquals(Str3, "Message");
		
		loginPageObj.clickArrowBtn();
		loginPageObj.clickLogOutBtn();
		testUtil.Switch_To_Alert_Accept();
		loginPageObj.clickAgrivilleLogo();
		
		loginPageObj.clickLogin();
		Thread.sleep(4000);
		loginPageObj.UserName(ExcelDataUtilObj.getData(sheetName1, 1, 0));
		loginPageObj.Password(ExcelDataUtilObj.getData(sheetName1, 1, 1));
		loginPageObj.clickLoginBtnOnLoginFrame();
		searchTopicObj.clickBeefProd();
		topicDetailsObj.clickH2FirstSubCategory();
		topicDetailsObj.clickBtnPostMsg();
		String Str4=topicDetailsObj.MsgAccountNotActivated();
		S1.assertEquals(Str4, "Message");
		loginPageObj.clickArrowBtn();
		loginPageObj.clickLogOutBtn();
		testUtil.Switch_To_Alert_Accept();
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Disc Categories: Verified Post Message functionality for Inactive accounts");
		
	}
	
	
	// Verify Post Message Button on Thread Details Page
	// Navigate to Thread Details page from Thread Search Result Page
	//Enter the Login credentials of Inactive Account and Verify the Post Message Button
	@Test(priority=6)
	public void verifyPostMessageSearchResult_InactiveAcc() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		topicDetailsObj.EnterDataSearchBx(ExcelDataUtilObj.getData(sheetName, 1, 4));
		topicDetailsObj.clickBtnSearch();
		topicDetailsObj.clickH2FirstSubCategory();
		topicDetailsObj.clickBtnPostMsg();
		
		String Str1= topicDetailsObj.MsgLoginPage();
		String Str2=topicDetailsObj.MsgH1Login();
		
		S1.assertEquals(Str1, "Message");
		S1.assertEquals(Str2, "Log in");
		
		loginPageObj.EmailLP(ExcelDataUtilObj.getData(sheetName1, 1, 0));
		loginPageObj.PasswordLP(ExcelDataUtilObj.getData(sheetName1, 1, 1));
		testUtil.Scroll_DownFull_Page();
		loginPageObj.clickLoginBtnLP();
		String Str3=topicDetailsObj.MsgAccountNotActivated();
		S1.assertEquals(Str3, "Message");
		
		loginPageObj.clickArrowBtn();
		loginPageObj.clickLogOutBtn();
		testUtil.Switch_To_Alert_Accept();
		loginPageObj.clickAgrivilleLogo();
		
		loginPageObj.clickLogin();
		Thread.sleep(4000);
		loginPageObj.UserName(ExcelDataUtilObj.getData(sheetName1, 1, 0));
		loginPageObj.Password(ExcelDataUtilObj.getData(sheetName1, 1, 1));
		loginPageObj.clickLoginBtnOnLoginFrame();
		topicDetailsObj.EnterDataSearchBx(ExcelDataUtilObj.getData(sheetName, 1, 4));
		topicDetailsObj.clickBtnSearch();
		topicDetailsObj.clickH2FirstSubCategory();
		topicDetailsObj.clickBtnPostMsg();
		String Str4=topicDetailsObj.MsgAccountNotActivated();
		S1.assertEquals(Str4, "Message");
		loginPageObj.clickArrowBtn();
		loginPageObj.clickLogOutBtn();
		testUtil.Switch_To_Alert_Accept();
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		
		
		System.out.println("Search Result: Verified Post Message functionality for Inactive accounts");
	}
	
	
	// Verify Post Message Button on Thread Details Page
	// Navigate to Thread Details page from View Button
	//Enter the Login credentials of Inactive Account and Verify the Post Message Button
	@Test(priority=7)
	public void verifyPostMessageView_InactiveAcc() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		topicDetailsObj.EnterDataSearchBx(ExcelDataUtilObj.getData(sheetName, 1, 4));
		topicDetailsObj.clickBtnSearch();
		topicDetailsObj.clickBtnFirstView();
		
		topicDetailsObj.clickBtnPostMsg();
		
		String Str1= topicDetailsObj.MsgLoginPage();
		String Str2=topicDetailsObj.MsgH1Login();
		
		S1.assertEquals(Str1, "Message");
		S1.assertEquals(Str2, "Log in");
		
		loginPageObj.EmailLP(ExcelDataUtilObj.getData(sheetName1, 1, 0));
		loginPageObj.PasswordLP(ExcelDataUtilObj.getData(sheetName1, 1, 1));
		testUtil.Scroll_DownFull_Page();
		loginPageObj.clickLoginBtnLP();
		String Str3=topicDetailsObj.MsgAccountNotActivated();
		S1.assertEquals(Str3, "Message");
		
		loginPageObj.clickArrowBtn();
		loginPageObj.clickLogOutBtn();
		testUtil.Switch_To_Alert_Accept();
		loginPageObj.clickAgrivilleLogo();
		
		loginPageObj.clickLogin();
		Thread.sleep(4000);
		loginPageObj.UserName(ExcelDataUtilObj.getData(sheetName1, 1, 0));
		loginPageObj.Password(ExcelDataUtilObj.getData(sheetName1, 1, 1));
		loginPageObj.clickLoginBtnOnLoginFrame();
		topicDetailsObj.EnterDataSearchBx(ExcelDataUtilObj.getData(sheetName, 1, 4));
		topicDetailsObj.clickBtnSearch();
		topicDetailsObj.clickBtnFirstView();
		
		topicDetailsObj.clickBtnPostMsg();
		String Str4=topicDetailsObj.MsgAccountNotActivated();
		S1.assertEquals(Str4, "Message");
		loginPageObj.clickArrowBtn();
		loginPageObj.clickLogOutBtn();
		testUtil.Switch_To_Alert_Accept();
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		
		
		System.out.println("View Button: Verified Post Message functionality for Inactive accounts");
	}
	
	// Verify Post Message Button on Thread Details Page
	// Navigate to Thread Details page from Beef Production
	//Enter the Login credentials of Active Account and Verify the Post Message Button
	@Test(priority=8)
	public void verifyPostMessageDiscCategories_ActiveAcc() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		searchTopicObj.clickBeefProd();
		topicDetailsObj.clickH2FirstSubCategory();
		topicDetailsObj.clickBtnPostMsg();
		String Str1= topicDetailsObj.MsgLoginPage();
		String Str2=topicDetailsObj.MsgH1Login();
		
		S1.assertEquals(Str1, "Message");
		S1.assertEquals(Str2, "Log in");
		
		loginPageObj.EmailLP(ExcelDataUtilObj.getData(sheetName1, 2, 0));
		loginPageObj.PasswordLP(ExcelDataUtilObj.getData(sheetName1, 2, 1));
		testUtil.Scroll_DownFull_Page();
		loginPageObj.clickLoginBtnLP();
		String Str3=topicDetailsObj.MsgPostNewReply();
		S1.assertEquals(Str3, "Post a New Reply");
		
		loginPageObj.clickArrowBtn();
		loginPageObj.clickLogOutBtn();
		testUtil.Switch_To_Alert_Accept();
		loginPageObj.clickAgrivilleLogo();
		
		loginPageObj.clickLogin();
		Thread.sleep(4000);
		loginPageObj.UserName(ExcelDataUtilObj.getData(sheetName1, 2, 0));
		loginPageObj.Password(ExcelDataUtilObj.getData(sheetName1, 2, 1));
		loginPageObj.clickLoginBtnOnLoginFrame();
		searchTopicObj.clickBeefProd();
		topicDetailsObj.clickH2FirstSubCategory();
		topicDetailsObj.clickBtnPostMsg();
		String Str4=topicDetailsObj.MsgPostNewReply();
		S1.assertEquals(Str4, "Post a New Reply");
		loginPageObj.clickArrowBtn();
		loginPageObj.clickLogOutBtn();
		testUtil.Switch_To_Alert_Accept();
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Discussion Categories: Verified Post Message functionality for Active accounts");
		
	}
	
	// Verify Post Message Button on Thread Details Page
	// Navigate to Thread Details page from Thread Search Result Page
	//Enter the Login credentials of Active Account and Verify the Post Message Button
	@Test(priority=9)
	public void verifyPostMessageSearchResult_ActiveAcc() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		
		topicDetailsObj.EnterDataSearchBx(ExcelDataUtilObj.getData(sheetName, 1, 4));
		topicDetailsObj.clickBtnSearch();
		topicDetailsObj.clickH2FirstSubCategory();
		topicDetailsObj.clickBtnPostMsg();
		String Str1= topicDetailsObj.MsgLoginPage();
		String Str2=topicDetailsObj.MsgH1Login();
		S1.assertEquals(Str1, "Message");
		S1.assertEquals(Str2, "Log in");
		
		loginPageObj.EmailLP(ExcelDataUtilObj.getData(sheetName1, 2, 0));
		loginPageObj.PasswordLP(ExcelDataUtilObj.getData(sheetName1, 2, 1));
		testUtil.Scroll_DownFull_Page();
		loginPageObj.clickLoginBtnLP();
		String Str3=topicDetailsObj.MsgPostNewReply();
		S1.assertEquals(Str3, "Post a New Reply");
		
		loginPageObj.clickArrowBtn();
		loginPageObj.clickLogOutBtn();
		testUtil.Switch_To_Alert_Accept();
		loginPageObj.clickAgrivilleLogo();
		
		loginPageObj.clickLogin();
		Thread.sleep(4000);
		loginPageObj.UserName(ExcelDataUtilObj.getData(sheetName1, 2, 0));
		loginPageObj.Password(ExcelDataUtilObj.getData(sheetName1, 2, 1));
		loginPageObj.clickLoginBtnOnLoginFrame();
		
		topicDetailsObj.EnterDataSearchBx(ExcelDataUtilObj.getData(sheetName, 1, 4));
		topicDetailsObj.clickBtnSearch();
		topicDetailsObj.clickH2FirstSubCategory();
		topicDetailsObj.clickBtnPostMsg();
		String Str4=topicDetailsObj.MsgPostNewReply();
		S1.assertEquals(Str4, "Post a New Reply");
		loginPageObj.clickArrowBtn();
		loginPageObj.clickLogOutBtn();
		testUtil.Switch_To_Alert_Accept();
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Search Result: Verified Post Message functionality for Active accounts");
		
	}
	// Verify Post Message Button on Thread Details Page
	// Navigate to Thread Details page from View Button(Navigate to Search Result Page and Click on View Button)
	//Enter the Login credentials of Active Account and Verify the Post Message Button
	@Test(priority=10)
	public void verifyPostMessageView_ActiveAcc() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		
		topicDetailsObj.EnterDataSearchBx(ExcelDataUtilObj.getData(sheetName, 1, 4));
		topicDetailsObj.clickBtnSearch();
		topicDetailsObj.clickBtnFirstView();
		topicDetailsObj.clickBtnPostMsg();
		String Str1= topicDetailsObj.MsgLoginPage();
		String Str2=topicDetailsObj.MsgH1Login();
		S1.assertEquals(Str1, "Message");
		S1.assertEquals(Str2, "Log in");
		
		loginPageObj.EmailLP(ExcelDataUtilObj.getData(sheetName1, 2, 0));
		loginPageObj.PasswordLP(ExcelDataUtilObj.getData(sheetName1, 2, 1));
		testUtil.Scroll_DownFull_Page();
		loginPageObj.clickLoginBtnLP();
		String Str3=topicDetailsObj.MsgPostNewReply();
		S1.assertEquals(Str3, "Post a New Reply");
		
		loginPageObj.clickArrowBtn();
		loginPageObj.clickLogOutBtn();
		testUtil.Switch_To_Alert_Accept();
		loginPageObj.clickAgrivilleLogo();
		
		loginPageObj.clickLogin();
		Thread.sleep(4000);
		loginPageObj.UserName(ExcelDataUtilObj.getData(sheetName1, 2, 0));
		loginPageObj.Password(ExcelDataUtilObj.getData(sheetName1, 2, 1));
		loginPageObj.clickLoginBtnOnLoginFrame();
		
		topicDetailsObj.EnterDataSearchBx(ExcelDataUtilObj.getData(sheetName, 1, 4));
		topicDetailsObj.clickBtnSearch();
		topicDetailsObj.clickBtnFirstView();
		topicDetailsObj.clickBtnPostMsg();
		String Str4=topicDetailsObj.MsgPostNewReply();
		S1.assertEquals(Str4, "Post a New Reply");
		loginPageObj.clickArrowBtn();
		loginPageObj.clickLogOutBtn();
		testUtil.Switch_To_Alert_Accept();
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Search Result: Verified Post Message functionality for Active accounts");
		
	}

	// Verify Reply Button on Thread Details Page
	// Navigate to Thread Details page from Beef Production
	//Enter the Login credentials of InActive Account and Verify the Reply Button
	
	@Test(priority=11)
	public void verifyReplyDiscCategories_InactiveAcc() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		searchTopicObj.clickBeefProd();
		topicDetailsObj.clickH2FirstSubCategory();
		topicDetailsObj.clickBtnReply();
		String Str1= topicDetailsObj.MsgLoginPage();
		String Str2=topicDetailsObj.MsgH1Login();
		
		S1.assertEquals(Str1, "Message");
		S1.assertEquals(Str2, "Log in");
		
		loginPageObj.EmailLP(ExcelDataUtilObj.getData(sheetName1, 1, 0));
		loginPageObj.PasswordLP(ExcelDataUtilObj.getData(sheetName1, 1, 1));
		testUtil.Scroll_DownFull_Page();
		loginPageObj.clickLoginBtnLP();
		String Str3=topicDetailsObj.MsgAccountNotActivated();
		S1.assertEquals(Str3, "Message");
		
		loginPageObj.clickArrowBtn();
		loginPageObj.clickLogOutBtn();
		testUtil.Switch_To_Alert_Accept();
		loginPageObj.clickAgrivilleLogo();
		
		loginPageObj.clickLogin();
		Thread.sleep(4000);
		loginPageObj.UserName(ExcelDataUtilObj.getData(sheetName1, 1, 0));
		loginPageObj.Password(ExcelDataUtilObj.getData(sheetName1, 1, 1));
		loginPageObj.clickLoginBtnOnLoginFrame();
		searchTopicObj.clickBeefProd();
		topicDetailsObj.clickH2FirstSubCategory();
		topicDetailsObj.clickBtnReply();
		String Str4=topicDetailsObj.MsgAccountNotActivated();
		S1.assertEquals(Str4, "Message");
		loginPageObj.clickArrowBtn();
		loginPageObj.clickLogOutBtn();
		testUtil.Switch_To_Alert_Accept();
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Disc Categories: Verified Reply functionality for Inactive accounts");
		
	}
	// Verify Reply Button on Thread Details Page
	// Navigate to Thread Details page from Search Result Page
	//Enter the Login credentials of InActive Account and Verify the Reply Button	
	
	@Test(priority=12)
	public void verifyReplySearchResult_InactiveAcc() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		topicDetailsObj.EnterDataSearchBx(ExcelDataUtilObj.getData(sheetName, 1, 4));
		topicDetailsObj.clickBtnSearch();
		topicDetailsObj.clickH2FirstSubCategory();
		topicDetailsObj.clickBtnReply();
		
		String Str1= topicDetailsObj.MsgLoginPage();
		String Str2=topicDetailsObj.MsgH1Login();
		
		S1.assertEquals(Str1, "Message");
		S1.assertEquals(Str2, "Log in");
		
		loginPageObj.EmailLP(ExcelDataUtilObj.getData(sheetName1, 1, 0));
		loginPageObj.PasswordLP(ExcelDataUtilObj.getData(sheetName1, 1, 1));
		testUtil.Scroll_DownFull_Page();
		loginPageObj.clickLoginBtnLP();
		String Str3=topicDetailsObj.MsgAccountNotActivated();
		S1.assertEquals(Str3, "Message");
		
		loginPageObj.clickArrowBtn();
		loginPageObj.clickLogOutBtn();
		testUtil.Switch_To_Alert_Accept();
		loginPageObj.clickAgrivilleLogo();
		
		loginPageObj.clickLogin();
		Thread.sleep(4000);
		loginPageObj.UserName(ExcelDataUtilObj.getData(sheetName1, 1, 0));
		loginPageObj.Password(ExcelDataUtilObj.getData(sheetName1, 1, 1));
		loginPageObj.clickLoginBtnOnLoginFrame();
		topicDetailsObj.EnterDataSearchBx(ExcelDataUtilObj.getData(sheetName, 1, 4));
		topicDetailsObj.clickBtnSearch();
		topicDetailsObj.clickH2FirstSubCategory();
		topicDetailsObj.clickBtnReply();
		String Str4=topicDetailsObj.MsgAccountNotActivated();
		S1.assertEquals(Str4, "Message");
		loginPageObj.clickArrowBtn();
		loginPageObj.clickLogOutBtn();
		testUtil.Switch_To_Alert_Accept();
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		
		
		System.out.println("Search Result: Verified Reply functionality for Inactive accounts");
	}
	

	// Verify Reply Button on Thread Details Page
	// Navigate to Thread Details page from Search Result Page-->View Button
	//Enter the Login credentials of InActive Account and Verify the Reply Button
	@Test(priority=13)
	public void verifyReplyView_InactiveAcc() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		topicDetailsObj.EnterDataSearchBx(ExcelDataUtilObj.getData(sheetName, 1, 4));
		topicDetailsObj.clickBtnSearch();
		topicDetailsObj.clickBtnFirstView();
		
		topicDetailsObj.clickBtnReply();
		
		String Str1= topicDetailsObj.MsgLoginPage();
		String Str2=topicDetailsObj.MsgH1Login();
		
		S1.assertEquals(Str1, "Message");
		S1.assertEquals(Str2, "Log in");
		
		loginPageObj.EmailLP(ExcelDataUtilObj.getData(sheetName1, 1, 0));
		loginPageObj.PasswordLP(ExcelDataUtilObj.getData(sheetName1, 1, 1));
		testUtil.Scroll_DownFull_Page();
		loginPageObj.clickLoginBtnLP();
		String Str3=topicDetailsObj.MsgAccountNotActivated();
		S1.assertEquals(Str3, "Message");
		
		loginPageObj.clickArrowBtn();
		loginPageObj.clickLogOutBtn();
		testUtil.Switch_To_Alert_Accept();
		loginPageObj.clickAgrivilleLogo();
		
		loginPageObj.clickLogin();
		Thread.sleep(4000);
		loginPageObj.UserName(ExcelDataUtilObj.getData(sheetName1, 1, 0));
		loginPageObj.Password(ExcelDataUtilObj.getData(sheetName1, 1, 1));
		loginPageObj.clickLoginBtnOnLoginFrame();
		topicDetailsObj.EnterDataSearchBx(ExcelDataUtilObj.getData(sheetName, 1, 4));
		topicDetailsObj.clickBtnSearch();
		topicDetailsObj.clickBtnFirstView();
		
		topicDetailsObj.clickBtnReply();
		String Str4=topicDetailsObj.MsgAccountNotActivated();
		S1.assertEquals(Str4, "Message");
		loginPageObj.clickArrowBtn();
		loginPageObj.clickLogOutBtn();
		testUtil.Switch_To_Alert_Accept();
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		
		
		System.out.println("View Button: Verified Reply functionality for Inactive accounts");
	}
	
	// Verify Reply Button on Thread Details Page
	// Navigate to Thread Details page from Beef Production
	//Enter the Login credentials of Active Account and Verify the Reply Button	
	@Test(priority=14)
	public void verifyReplyDiscCategories_ActiveAcc() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		searchTopicObj.clickBeefProd();
		topicDetailsObj.clickH2FirstSubCategory();
		topicDetailsObj.clickBtnReply();
		String Str1= topicDetailsObj.MsgLoginPage();
		String Str2=topicDetailsObj.MsgH1Login();
		
		S1.assertEquals(Str1, "Message");
		S1.assertEquals(Str2, "Log in");
		
		loginPageObj.EmailLP(ExcelDataUtilObj.getData(sheetName1, 2, 0));
		loginPageObj.PasswordLP(ExcelDataUtilObj.getData(sheetName1, 2, 1));
		testUtil.Scroll_DownFull_Page();
		loginPageObj.clickLoginBtnLP();
		String Str3=topicDetailsObj.MsgPostNewReply();
		S1.assertEquals(Str3, "Post a New Reply");
		
		loginPageObj.clickArrowBtn();
		loginPageObj.clickLogOutBtn();
		testUtil.Switch_To_Alert_Accept();
		loginPageObj.clickAgrivilleLogo();
		
		loginPageObj.clickLogin();
		Thread.sleep(4000);
		loginPageObj.UserName(ExcelDataUtilObj.getData(sheetName1, 2, 0));
		loginPageObj.Password(ExcelDataUtilObj.getData(sheetName1, 2, 1));
		loginPageObj.clickLoginBtnOnLoginFrame();
		searchTopicObj.clickBeefProd();
		topicDetailsObj.clickH2FirstSubCategory();
		topicDetailsObj.clickBtnReply();
		String Str4=topicDetailsObj.MsgPostNewReply();
		S1.assertEquals(Str4, "Post a New Reply");
		loginPageObj.clickArrowBtn();
		loginPageObj.clickLogOutBtn();
		testUtil.Switch_To_Alert_Accept();
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Discussion Categories: Verified Post Message functionality for Active accounts");
		
	}
	

	// Verify Reply Button on Thread Details Page
	// Navigate to Thread Details page from Search Result Page
	//Enter the Login credentials of Active Account and Verify the Reply Button
	@Test(priority=15)
	public void verifyReplySearchResult_ActiveAcc() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		
		topicDetailsObj.EnterDataSearchBx(ExcelDataUtilObj.getData(sheetName, 1, 4));
		topicDetailsObj.clickBtnSearch();
		topicDetailsObj.clickH2FirstSubCategory();
		topicDetailsObj.clickBtnReply();
		String Str1= topicDetailsObj.MsgLoginPage();
		String Str2=topicDetailsObj.MsgH1Login();
		S1.assertEquals(Str1, "Message");
		S1.assertEquals(Str2, "Log in");
		
		loginPageObj.EmailLP(ExcelDataUtilObj.getData(sheetName1, 2, 0));
		loginPageObj.PasswordLP(ExcelDataUtilObj.getData(sheetName1, 2, 1));
		testUtil.Scroll_DownFull_Page();
		loginPageObj.clickLoginBtnLP();
		String Str3=topicDetailsObj.MsgPostNewReply();
		S1.assertEquals(Str3, "Post a New Reply");
		
		loginPageObj.clickArrowBtn();
		loginPageObj.clickLogOutBtn();
		testUtil.Switch_To_Alert_Accept();
		loginPageObj.clickAgrivilleLogo();
		
		loginPageObj.clickLogin();
		Thread.sleep(4000);
		loginPageObj.UserName(ExcelDataUtilObj.getData(sheetName1, 2, 0));
		loginPageObj.Password(ExcelDataUtilObj.getData(sheetName1, 2, 1));
		loginPageObj.clickLoginBtnOnLoginFrame();
		
		topicDetailsObj.EnterDataSearchBx(ExcelDataUtilObj.getData(sheetName, 1, 4));
		topicDetailsObj.clickBtnSearch();
		topicDetailsObj.clickH2FirstSubCategory();
		topicDetailsObj.clickBtnReply();
		String Str4=topicDetailsObj.MsgPostNewReply();
		S1.assertEquals(Str4, "Post a New Reply");
		loginPageObj.clickArrowBtn();
		loginPageObj.clickLogOutBtn();
		testUtil.Switch_To_Alert_Accept();
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Search Result: Verified Post Message functionality for Active accounts");
		
	}

	// Verify Reply Button on Thread Details Page
	// Navigate to Thread Details page from Search Result Page-->View Button
	//Enter the Login credentials of Active Account and Verify the Reply Button
	@Test(priority=16)
	public void verifyReplyView_ActiveAcc() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		topicDetailsObj.EnterDataSearchBx(ExcelDataUtilObj.getData(sheetName, 1, 4));
		topicDetailsObj.clickBtnSearch();
		topicDetailsObj.clickBtnFirstView();
		topicDetailsObj.clickBtnReply();
		String Str1= topicDetailsObj.MsgLoginPage();
		String Str2=topicDetailsObj.MsgH1Login();
		S1.assertEquals(Str1, "Message");
		S1.assertEquals(Str2, "Log in");
		
		loginPageObj.EmailLP(ExcelDataUtilObj.getData(sheetName1, 2, 0));
		loginPageObj.PasswordLP(ExcelDataUtilObj.getData(sheetName1, 2, 1));
		testUtil.Scroll_DownFull_Page();
		loginPageObj.clickLoginBtnLP();
		String Str3=topicDetailsObj.MsgPostNewReply();
		S1.assertEquals(Str3, "Post a New Reply");
		
		loginPageObj.clickArrowBtn();
		loginPageObj.clickLogOutBtn();
		testUtil.Switch_To_Alert_Accept();
		loginPageObj.clickAgrivilleLogo();
		
		loginPageObj.clickLogin();
		Thread.sleep(4000);
		loginPageObj.UserName(ExcelDataUtilObj.getData(sheetName1, 2, 0));
		loginPageObj.Password(ExcelDataUtilObj.getData(sheetName1, 2, 1));
		loginPageObj.clickLoginBtnOnLoginFrame();
		
		topicDetailsObj.EnterDataSearchBx(ExcelDataUtilObj.getData(sheetName, 1, 4));
		topicDetailsObj.clickBtnSearch();
		topicDetailsObj.clickBtnFirstView();
		topicDetailsObj.clickBtnReply();
		String Str4=topicDetailsObj.MsgPostNewReply();
		S1.assertEquals(Str4, "Post a New Reply");
		loginPageObj.clickArrowBtn();
		loginPageObj.clickLogOutBtn();
		testUtil.Switch_To_Alert_Accept();
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Search Result: Verified Post Message functionality for Active accounts");
		
	}
	
	
	//Verify the Discussion Categories on Thread Details page
	//Navigate to Thread Result Page and Verify the Discussion Categories
	@Test(priority=17)
	public void verifyThreadDetailsDropdown_Search() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		topicDetailsObj.EnterDataSearchBx(ExcelDataUtilObj.getData(sheetName, 1, 4));
		topicDetailsObj.clickBtnSearch();
		topicDetailsObj.clickH2FirstSubCategory();
		
		
		@SuppressWarnings("rawtypes")
		HashMap<Integer, ArrayList> HMALDiscCategory= searchTopicObj.getTextOnDiscCategory();
		@SuppressWarnings("unchecked")
		ArrayList<String> H1OnDisCategoryHP=HMALDiscCategory.get(0);
				
		@SuppressWarnings("unchecked")
		ArrayList<String> H1OnDiscCategorySubPage=HMALDiscCategory.get(1);
	
		@SuppressWarnings("unchecked")
		ArrayList<String> titleOnDiscCategorySubPage=HMALDiscCategory.get(2);
		
		@SuppressWarnings("unchecked")
		ArrayList<String> breadCrumbDiscCategoriesSubPage=HMALDiscCategory.get(3);
		
		
		for(int i=0;i<H1OnDisCategoryHP.size();i++)
		{			
			S1.assertTrue(H1OnDiscCategorySubPage.get(i).contains(H1OnDisCategoryHP.get(i)),"Title do not Match for "+H1OnDisCategoryHP.get(i));
			S1.assertTrue(titleOnDiscCategorySubPage.get(i).contains(H1OnDisCategoryHP.get(i)),"Title do not Match for "+H1OnDisCategoryHP.get(i));
			S1.assertTrue(breadCrumbDiscCategoriesSubPage.get(i).contains(H1OnDisCategoryHP.get(i)),"Title do not Match for "+H1OnDisCategoryHP.get(i));
			
		}
		S1.assertAll();
		
		System.out.println("Search Page: Verified dropdown on Thread Details Page");
			
	}
		
	//Verify the Discussion Categories on Thread Details page
	//Navigate to Thread Page from Beef Production and Verify the Discussion Categories		
	@Test(priority=18)
	public void verifyThreadDetailsDropdown_DiscCategories() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		
		searchTopicObj.clickBeefProd();
		topicDetailsObj.clickH2FirstSubCategory();
		
		
		@SuppressWarnings("rawtypes")
		HashMap<Integer, ArrayList> HMALDiscCategory= searchTopicObj.getTextOnDiscCategory();
		@SuppressWarnings("unchecked")
		ArrayList<String> H1OnDisCategoryHP=HMALDiscCategory.get(0);
				
		@SuppressWarnings("unchecked")
		ArrayList<String> H1OnDiscCategorySubPage=HMALDiscCategory.get(1);
	
		@SuppressWarnings("unchecked")
		ArrayList<String> titleOnDiscCategorySubPage=HMALDiscCategory.get(2);
		
		@SuppressWarnings("unchecked")
		ArrayList<String> breadCrumbDiscCategoriesSubPage=HMALDiscCategory.get(3);
		
		
		for(int i=0;i<H1OnDisCategoryHP.size();i++)
		{			
			S1.assertTrue(H1OnDiscCategorySubPage.get(i).contains(H1OnDisCategoryHP.get(i)),"Title do not Match for "+H1OnDisCategoryHP.get(i));
			S1.assertTrue(titleOnDiscCategorySubPage.get(i).contains(H1OnDisCategoryHP.get(i)),"Title do not Match for "+H1OnDisCategoryHP.get(i));
			S1.assertTrue(breadCrumbDiscCategoriesSubPage.get(i).contains(H1OnDisCategoryHP.get(i)),"Title do not Match for "+H1OnDisCategoryHP.get(i));
			
		}
		S1.assertAll();
		
		System.out.println("Discussion Categories: Verified Dropdown on Thread Details Page");
			
	}
	
	
	//Verify the Discussion Categories on Thread Details page
	//Navigate to Thread Result Page-->Click on View Button and Verify the Discussion Categories	
	@Test(priority=19)
	public void verifyThreadDetailsDropdown_View() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		topicDetailsObj.EnterDataSearchBx(ExcelDataUtilObj.getData(sheetName, 1, 4));
		topicDetailsObj.clickBtnSearch();
		topicDetailsObj.clickBtnFirstView();
		
		@SuppressWarnings("rawtypes")
		HashMap<Integer, ArrayList> HMALDiscCategory= searchTopicObj.getTextOnDiscCategory();
		@SuppressWarnings("unchecked")
		ArrayList<String> H1OnDisCategoryHP=HMALDiscCategory.get(0);
				
		@SuppressWarnings("unchecked")
		ArrayList<String> H1OnDiscCategorySubPage=HMALDiscCategory.get(1);
	
		@SuppressWarnings("unchecked")
		ArrayList<String> titleOnDiscCategorySubPage=HMALDiscCategory.get(2);
		
		@SuppressWarnings("unchecked")
		ArrayList<String> breadCrumbDiscCategoriesSubPage=HMALDiscCategory.get(3);
		
		
		for(int i=0;i<H1OnDisCategoryHP.size();i++)
		{			
			S1.assertTrue(H1OnDiscCategorySubPage.get(i).contains(H1OnDisCategoryHP.get(i)),"Title do not Match for "+H1OnDisCategoryHP.get(i));
			S1.assertTrue(titleOnDiscCategorySubPage.get(i).contains(H1OnDisCategoryHP.get(i)),"Title do not Match for "+H1OnDisCategoryHP.get(i));
			S1.assertTrue(breadCrumbDiscCategoriesSubPage.get(i).contains(H1OnDisCategoryHP.get(i)),"Title do not Match for "+H1OnDisCategoryHP.get(i));
			
		}
		S1.assertAll();
		
		System.out.println("Search Page: Verified dropdown on Thread Details Page");
		
	}
	
	//Verify the User Name from Thread Results Page
	@Test(priority=20)
	public void verifyUNThreadDetails_SearchResult() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		topicDetailsObj.EnterDataSearchBx(ExcelDataUtilObj.getData(sheetName, 1, 4));
		topicDetailsObj.clickBtnSearch();
		topicDetailsObj.clickH2FirstSubCategory();
		String Str1=topicDetailsObj.UNThreadDetails();
		topicDetailsObj.clickUNThreadDetails();
		
		String Str2= topicDetailsObj.MsgLoginPage();
		String Str3=topicDetailsObj.MsgH1Login();
		
		S1.assertEquals(Str2, "Message");
		S1.assertEquals(Str3, "Log in");
		
		loginPageObj.EmailLP(ExcelDataUtilObj.getData(sheetName1, 2, 0));
		loginPageObj.PasswordLP(ExcelDataUtilObj.getData(sheetName1, 2, 1));
		testUtil.Scroll_DownFull_Page();
		loginPageObj.clickLoginBtnLP();
		String Str4=topicDetailsObj.NameOfMember();
		S1.assertEquals(Str1, Str4,"The String do not Match");
		loginPageObj.clickArrowBtn();
		loginPageObj.clickLogOutBtn();
		testUtil.Switch_To_Alert_Accept();
		loginPageObj.clickAgrivilleLogo();
		
		loginPageObj.clickLogin();
		Thread.sleep(4000);
		loginPageObj.UserName(ExcelDataUtilObj.getData(sheetName1, 2, 0));
		loginPageObj.Password(ExcelDataUtilObj.getData(sheetName1, 2, 1));
		loginPageObj.clickLoginBtnOnLoginFrame();
		
		topicDetailsObj.EnterDataSearchBx(ExcelDataUtilObj.getData(sheetName, 1, 4));
		topicDetailsObj.clickBtnSearch();
		topicDetailsObj.clickH2FirstSubCategory();
		String Str5=topicDetailsObj.UNThreadDetails();
		topicDetailsObj.clickUNThreadDetails();
		
		
		String Str6=topicDetailsObj.NameOfMember();
		S1.assertEquals(Str5, Str6,"The String Do not Match");
		loginPageObj.clickArrowBtn();
		loginPageObj.clickLogOutBtn();
		testUtil.Switch_To_Alert_Accept();
		S1.assertAll();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("Thread Details: Verified Username with and without Login from search result page");
	}
	
	
	//Verify the User Name from Beef Production-->Select Beef Production-->Click on User name
	@Test(priority=21)
	public void verifyUNThreadDetails_DisCategories() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		searchTopicObj.clickBeefProd();
		topicDetailsObj.clickH2FirstSubCategory();
		
		String Str1=topicDetailsObj.UNThreadDetails();
		topicDetailsObj.clickUNThreadDetails();
		
		String Str2= topicDetailsObj.MsgLoginPage();
		String Str3=topicDetailsObj.MsgH1Login();
		
		S1.assertEquals(Str2, "Message");
		S1.assertEquals(Str3, "Log in");
		
		loginPageObj.EmailLP(ExcelDataUtilObj.getData(sheetName1, 2, 0));
		loginPageObj.PasswordLP(ExcelDataUtilObj.getData(sheetName1, 2, 1));
		testUtil.Scroll_DownFull_Page();
		loginPageObj.clickLoginBtnLP();
		String Str4=topicDetailsObj.NameOfMember();
		S1.assertEquals(Str1, Str4,"The String do not Match");
		loginPageObj.clickArrowBtn();
		loginPageObj.clickLogOutBtn();
		testUtil.Switch_To_Alert_Accept();
		loginPageObj.clickAgrivilleLogo();
		
		loginPageObj.clickLogin();
		Thread.sleep(4000);
		loginPageObj.UserName(ExcelDataUtilObj.getData(sheetName1, 2, 0));
		loginPageObj.Password(ExcelDataUtilObj.getData(sheetName1, 2, 1));
		loginPageObj.clickLoginBtnOnLoginFrame();
		
		searchTopicObj.clickBeefProd();
		topicDetailsObj.clickH2FirstSubCategory();
		String Str5=topicDetailsObj.UNThreadDetails();
		topicDetailsObj.clickUNThreadDetails();
		
		
		String Str6=topicDetailsObj.NameOfMember();
		S1.assertEquals(Str5, Str6,"The String Do not Match");
		loginPageObj.clickArrowBtn();
		loginPageObj.clickLogOutBtn();
		testUtil.Switch_To_Alert_Accept();
		S1.assertAll();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("Thread Details: Verified Username with and without Login from search result page");
	}
	
	
	//Verify the User name 
	//Navigate to thread result page->Click on view button and verify the User Name
	@Test(priority=22)
	public void verifyUNThreadDetails_View() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		topicDetailsObj.EnterDataSearchBx(ExcelDataUtilObj.getData(sheetName, 1, 4));
		topicDetailsObj.clickBtnSearch();
		topicDetailsObj.clickBtnFirstView();
		
		
		String Str1=topicDetailsObj.UNThreadDetails();
		topicDetailsObj.clickUNThreadDetails();
		
		String Str2= topicDetailsObj.MsgLoginPage();
		String Str3=topicDetailsObj.MsgH1Login();
		
		S1.assertEquals(Str2, "Message");
		S1.assertEquals(Str3, "Log in");
		
		loginPageObj.EmailLP(ExcelDataUtilObj.getData(sheetName1, 2, 0));
		loginPageObj.PasswordLP(ExcelDataUtilObj.getData(sheetName1, 2, 1));
		testUtil.Scroll_DownFull_Page();
		loginPageObj.clickLoginBtnLP();
		String Str4=topicDetailsObj.NameOfMember();
		S1.assertEquals(Str1, Str4,"The String do not Match");
		loginPageObj.clickArrowBtn();
		loginPageObj.clickLogOutBtn();
		testUtil.Switch_To_Alert_Accept();
		loginPageObj.clickAgrivilleLogo();
		
		loginPageObj.clickLogin();
		Thread.sleep(4000);
		loginPageObj.UserName(ExcelDataUtilObj.getData(sheetName1, 2, 0));
		loginPageObj.Password(ExcelDataUtilObj.getData(sheetName1, 2, 1));
		loginPageObj.clickLoginBtnOnLoginFrame();
		
		topicDetailsObj.EnterDataSearchBx(ExcelDataUtilObj.getData(sheetName, 1, 4));
		topicDetailsObj.clickBtnSearch();
		topicDetailsObj.clickBtnFirstView();
		String Str5=topicDetailsObj.UNThreadDetails();
		topicDetailsObj.clickUNThreadDetails();
		
		String Str6=topicDetailsObj.NameOfMember();
		S1.assertEquals(Str5, Str6,"The String Do not Match");
		loginPageObj.clickArrowBtn();
		loginPageObj.clickLogOutBtn();
		testUtil.Switch_To_Alert_Accept();
		S1.assertAll();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("View Option: Verified Username with and without Login from search result page");
	}
	
	
	
	
	
	
	
	
	
	@AfterClass
	public void TearDown()
	{
		driver.quit();
	}
	
}
