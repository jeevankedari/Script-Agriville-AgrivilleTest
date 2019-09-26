package com.agriville.qa.testcases;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.agriville.qa.base.TestBase;
import com.agriville.qa.pages.searchTopic;
import com.agriville.qa.pages.loginPage;
import com.agriville.qa.util.ExcelDataUtil;
import com.agriville.qa.util.testUtil;

public class searchTopicTest extends TestBase 
{
	searchTopic searchTopicObj;
	ExcelDataUtil ExcelDataUtilObj;
	loginPage loginPageObj;
	String Path="E://Script Agriville//AgrivilleTest//src//main//java//com//agriville//qa//testdata//Agriville.xlsx";
	String sheetName="Disc_Categories";
	String sheetName1="Disc_CategoriesLogin";
	public searchTopicTest()
	{
		super();
	}
	
	@BeforeClass
	public void SetUp()
	{
		intialization();
		searchTopicObj = new searchTopic();
		//testUtilObj=new testUtil();
		ExcelDataUtilObj=new ExcelDataUtil(Path);
		loginPageObj=new loginPage();
		
	}
	
	//Verify the categories Landing Page
	@Test(priority=1)
	public void verifyCategoriesLandingResult()
	{
		SoftAssert S1=new SoftAssert();
		searchTopicObj.clickBeefProd();
		ArrayList<Boolean> SearchList=searchTopicObj.verifySearchResults();
		for(int i=0;i<SearchList.size();i++)
		{
			Boolean flag=searchTopicObj.verifySearchResults().get(i);
			S1.assertTrue(flag);
		}
		String Str1=searchTopicObj.TxtBxSearch();
		S1.assertEquals(Str1, "search farmer discussions!","The Text is not Present");
		
		String Str2=searchTopicObj.H1BeefProd();
		S1.assertEquals(Str2, "Beef Production");
		
		String Str3=searchTopicObj.BreadCrumbs();
		S1.assertEquals(Str3, "Forum › Beef Production");
		
		String Str4=searchTopicObj.ColThreadTitleStarter();
		S1.assertEquals(Str4, "TITLE / THREAD STARTER");
		
		String Str5=searchTopicObj.ColAuthor();
		S1.assertEquals(Str5, "AUTHOR");
		
		String Str6=searchTopicObj.ColRepliesView();
		S1.assertEquals(Str6, "REPLIES / VIEWS");
		
		String Str7=searchTopicObj.ColLastPostBy();
		S1.assertEquals(Str7, "LAST POST BY");
		
		S1.assertAll();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified all the Search Result Page");
		
		
	}
	//Verify the Sort Thread Dropdown
	@Test(priority=2)
	public void verifySortThreadsDropDown()
	{
		SoftAssert S1=new SoftAssert();
		searchTopicObj.clickBeefProd();
		
		ArrayList<String> listSortThread=searchTopicObj.SelectSortThreads();
		
		
		for(int i=0;i<listSortThread.size();i++)
		{
			String Actual=listSortThread.get(i);
			String Expected=ExcelDataUtilObj.getData(sheetName, i+1, 0);
			S1.assertEquals(Actual, Expected);
			
				System.out.println(Actual+ " is Actual Value from Agriville Web Application and Expected Value is " + Expected+ " Matches");
				

		}
		S1.assertAll();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("All values in Sort Thread dropdown are Matched");
		
	}
	//Verify all the Dropdown option are Displayed on Beef Production 
	@Test(priority=3)
	public void verifyDropdDownOptions()
	{
		SoftAssert S1=new SoftAssert();
		
		searchTopicObj.clickBeefProd();
		
		
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
		
		System.out.println("Verified Discussion Categories on Search Page and Verified Header, Title and BreadCrumb");
			
	}
	// Verify the Pagination displayed on the Top of the Beef Production
	@Test(priority=4)
	public void verifyPaginationAtTop()
	{
		loginPageObj.clickAgrivilleLogo();
		SoftAssert S1=new SoftAssert();
		String StrSecondPage, StrFirstPage, StrNextBtn, StrLast, StrFirst, StrPrevious;
		searchTopicObj.clickBeefProd();
		if(searchTopicObj.isEmptyPagingTop())
		{
			System.out.println("Paging is not Present on Current Page");
		}
		else
		{
				StrSecondPage=searchTopicObj.clickSecondPageTop();
				S1.assertEquals(StrSecondPage, "700");
				
				StrFirstPage=searchTopicObj.clickFirstPageTop();
				S1.assertEquals(StrFirstPage, "700");
				
			
				StrNextBtn=searchTopicObj.clickBtnNextTop();
				S1.assertEquals(StrNextBtn, "700");
				
				searchTopicObj.clickFirstPageTop();
				
				StrLast=searchTopicObj.clickLastBtnTop();
				S1.assertEquals(StrLast, "700");
				
				StrFirst=searchTopicObj.clickFirstBtnTop();
				S1.assertEquals(StrFirst, "700");
				
				searchTopicObj.clickSecondPageTop();
				
				StrPrevious=searchTopicObj.clickBtnPreviousTop();
				S1.assertEquals(StrPrevious, "400");
				
		}
		S1.assertAll();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified Navigation of Pagination at Top");
		
	}
	// Verify the Pagination displayed on the Bottom of the Beef Production
	@Test(priority=5)
	public void verifyPaginationAtBottom()
	{
		SoftAssert S1=new SoftAssert();
		String StrSecondPage, StrFirstPage, StrNextBtn, StrLast, StrFirst, StrPrevious;
		searchTopicObj.clickBeefProd();
		testUtil.Scroll_DownFull_Page();
		if(searchTopicObj.isEmptyPagingBottom())
		{
			System.out.println("Paging is not Present on Current Page");
		}
		else
		{
				StrSecondPage=searchTopicObj.clickSecondPageBottom();
				S1.assertEquals(StrSecondPage, "700");
				
				
				StrFirstPage=searchTopicObj.clickFirstPageBottom();
				S1.assertEquals(StrFirstPage, "700");
					
				StrNextBtn=searchTopicObj.clickBtnNextBottom();
				S1.assertEquals(StrNextBtn, "700");
								
				searchTopicObj.clickFirstPageBottom();
				
				StrLast=searchTopicObj.clickLastBtnBottom();
				S1.assertEquals(StrLast, "700");
			
				StrFirst=searchTopicObj.clickPagingBottomLastPage();
				S1.assertEquals(StrFirst, "700");
				
				searchTopicObj.clickSecondPageBottom();
				
				StrPrevious=searchTopicObj.clickBtnPreviousBottom();
				S1.assertEquals(StrPrevious, "400");
		}
		S1.assertAll();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified Navigation of Pagination at Bottom");
		
	}
	//Verify the Forum link on Beef Production
	@Test(priority=6)
	public void verifyForumlink()
	{
		SoftAssert S1=new SoftAssert();
		searchTopicObj.clickBeefProd();
		searchTopicObj.clickBCrumbsForum();
		String Str1=testUtil.getTitleOfPage();
		S1.assertEquals(Str1, "Farming and Agriculture Discussion Forum | Agriville.com");
		S1.assertAll();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified Navigation to Home Page from Forum Link");
		
	}
	//Verify Post Thread Button Without Login
	@Test(priority=7)
	public void verifyPostThreadWithoutLogin()
	{
		SoftAssert S1=new SoftAssert();
		searchTopicObj.clickBeefProd();
		searchTopicObj.clickBtnPostAThread();
		String Str1= searchTopicObj.MsgLoginPage();
		String Str2=searchTopicObj.MsgH1Login();
		
		S1.assertEquals(Str1, "Message");
		S1.assertEquals(Str2, "Log in");
		S1.assertAll();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("User Not Logged in: User is navigated to Login Screen when user clicks on Post A Thread Button");
		
	}
	
	//Verify Post Thread Button With Login on Beef Production
	//Click on Post Thread Button. Enter Details for User(Not Activated User) and Verify Post Thread 
	@Test(priority=8)
	public void verifyPostThreadLoginAccNotActivated() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		loginPageObj.clickLogin();
		Thread.sleep(4000);
		loginPageObj.UserName(ExcelDataUtilObj.getData(sheetName1, 1, 0));
		loginPageObj.Password(ExcelDataUtilObj.getData(sheetName1, 1, 1));
		loginPageObj.clickLoginBtnOnLoginFrame();
		searchTopicObj.clickBeefProd();
		searchTopicObj.clickBtnPostAThread();
		
		String Str1=searchTopicObj.MsgAccountNotActivated();
		S1.assertEquals(Str1, "Message");
		loginPageObj.clickArrowBtn();
		loginPageObj.clickLogOutBtn();
		testUtil.Switch_To_Alert_Accept();
		S1.assertAll();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified user is not navigated to post a thread page for inactive account ");
		
		
		
	}

	//Verify Post Thread Button With Login on Beef Production
	//Click on Post Thread Button. Enter Details for User(Activated User) and Verify Post Thread 
	@Test(priority=9)
	public void verifyPostThreadLoginAcctActivated() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		loginPageObj.clickLogin();
		Thread.sleep(4000);
		loginPageObj.UserName(ExcelDataUtilObj.getData(sheetName1, 2, 0));
		loginPageObj.Password(ExcelDataUtilObj.getData(sheetName1, 2, 1));
		loginPageObj.clickLoginBtnOnLoginFrame();
		searchTopicObj.clickBeefProd();
		searchTopicObj.clickBtnPostAThread();
		
		String Str1=searchTopicObj.H1PostNewThread();
		S1.assertEquals(Str1, "Post a New Thread");
		loginPageObj.clickArrowBtn();
		loginPageObj.clickLogOutBtn();
		testUtil.Switch_To_Alert_Accept();
		S1.assertAll();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified user is navigated to post a thread page for Active account ");
	}
	
	
	//Verify the Sorting under Last Post By
	//Select Most Recent Post
	@Test(priority=10)
	public void verifyMostRecentPost() throws InterruptedException, ParseException
	{
		SoftAssert S1=new SoftAssert();
		searchTopicObj.clickBeefProd();
		searchTopicObj.SelectMostRecentPost();
		ArrayList<Date> listObj=new ArrayList<Date>();
		listObj=searchTopicObj.LastPostBy();
		
		for(int i=0;i<listObj.size()-1;i++)
		{
			for(int j=1;j<listObj.size();j++)
			{
				if(i!=j&&j>i)
				{
				
					S1.assertTrue(listObj.get(i).after(listObj.get(j)));
					
				}
			}
		}
		S1.assertAll();
		loginPageObj.clickAgrivilleLogo();	
		System.out.println("Most Recent Post are sorted Correctly ");

		
	}
	
	
	
	//Verify the Sorting under Author
	//Select Most Recent Thread
	@Test(priority=11)
	public void verifyMostRecentThread() throws InterruptedException, ParseException
	{
		SoftAssert S1=new SoftAssert();
		searchTopicObj.clickBeefProd();
		ArrayList<Date> listObj=new ArrayList<Date>();
		searchTopicObj.SelectMostRecentThread();
		listObj=searchTopicObj.AuthorDateTime();
		
		for(int i=0;i<listObj.size()-1;i++)
		{
			for(int j=1;j<listObj.size();j++)
			{
				if(i!=j&&j>i)
				{
				
					S1.assertTrue(listObj.get(i).after(listObj.get(j)));
					
				}
			}
		}
		
		S1.assertAll();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("Most Recent Threads are sorted Correctly");
		
	}
	
	
	//Verify the Sorting under Replies/Views
	//Select Most Recent Replies
	
	@Test(priority=12)
	public void verifyMostRecentReplies() throws InterruptedException, ParseException
	{
		SoftAssert S1=new SoftAssert();
		searchTopicObj.clickBeefProd();
		ArrayList<Integer> listObj=new ArrayList<Integer>();
		searchTopicObj.SelectMostRecentReplies();
		listObj=searchTopicObj.MostRecentReplies();
		
		for(int i=0;i<listObj.size()-1;i++)
		{
			for(int j=1;j<listObj.size();j++)
			{
				if(i!=j&&j>i)
				{
				
					S1.assertTrue(listObj.get(i)>=listObj.get(j));
					
				}
			}
			
		}
		S1.assertAll();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("Number of replies are displayad in Descending Order");
	
	}

	//Verify the Sorting under Replies/Views
	//Select Most Recent View
	@Test(priority=13)
	public void verifyMostRecentViews() throws InterruptedException, ParseException
	{
		SoftAssert S1=new SoftAssert();
		searchTopicObj.clickBeefProd();
		ArrayList<Integer> listObj=new ArrayList<Integer>();
		searchTopicObj.SelectMostRecentViews();
		listObj=searchTopicObj.MostRecentViews();
		
		for(int i=0;i<listObj.size()-1;i++)
		{
			for(int j=1;j<listObj.size();j++)
			{
				if(i!=j&&j>i)
				{
				
					S1.assertTrue(listObj.get(i)>=listObj.get(j));
					
				}
			}
			
		}
		S1.assertAll();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("Most Recent Reviews are displayad in Descending Order");

	}
	
	
	//Verify the Thread Title on Beef production beside Forum
	@Test(priority=14)
	public void verifyH2ThreadTitleUnderForum()
	{
		SoftAssert S1=new SoftAssert();
		searchTopicObj.clickBeefProd();
		String Str1=searchTopicObj.H2FirstSubCategory();
		searchTopicObj.clickH2FirstSubCategory();
		String Str2=searchTopicObj.h1OnThreadPage();
		
		S1.assertTrue(Str1.contains(Str2));
		searchTopicObj.clicklinkToSubPage();

		S1.assertAll();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified Title Header on Sub Page Under Forum");
		
		
	}
	
	//Verify Author Name Without Login
	// Click on Author and Enter the Login Details and Verify the Author Name
	@Test(priority=15)
	public void verifyFirstAuthorWithoutLogin()
	{
		SoftAssert S1=new SoftAssert();
		searchTopicObj.clickBeefProd();
		
		searchTopicObj.clickFirstAuthor();
		String Str1= searchTopicObj.MsgLoginPage();
		String Str2=searchTopicObj.MsgH1Login();
		S1.assertEquals(Str1, "Message");
		S1.assertEquals(Str2, "Log in");
		S1.assertAll();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("User Not Logged in: User is navigated to Login Screen when user clicks on Authors");
			
	}

	//Verify Author Name With Login
	// Click on Author and Enter the Login Details and Verify the Author Name
	@Test(priority=16)
	public void verifyFirstAuthorWithLogin() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		searchTopicObj.clickBeefProd();
		String Str1= searchTopicObj.FirstAuthor();
		searchTopicObj.clickFirstAuthor();
		String Str2= searchTopicObj.MsgLoginPage();
		String Str3=searchTopicObj.MsgH1Login();
		S1.assertEquals(Str2, "Message");
		S1.assertEquals(Str3, "Log in");
		
		loginPageObj.EmailLP(ExcelDataUtilObj.getData(sheetName1, 2, 0));
		loginPageObj.PasswordLP(ExcelDataUtilObj.getData(sheetName1, 2, 1));
		testUtil.Scroll_DownFull_Page();
		loginPageObj.clickLoginBtnLP();
		String Str4=searchTopicObj.NameOfMember();
		S1.assertEquals(Str1, Str4);
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
		String Str5= searchTopicObj.FirstAuthor();
		searchTopicObj.clickFirstAuthor();
		String Str6=searchTopicObj.NameOfMember();
		S1.assertEquals(Str5, Str6);
		loginPageObj.clickArrowBtn();
		loginPageObj.clickLogOutBtn();
		testUtil.Switch_To_Alert_Accept();
		
		
		S1.assertAll();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified Author name on Sub page and Member Page");
				
	}
	
	
	//Verify Last Post By Without Login
	// Click on Last Post By and Enter the Login Details and Verify the Name of the User
	@Test(priority=17)
	public void verifyLastPostByWithoutLogin()
	{
		SoftAssert S1=new SoftAssert();
		searchTopicObj.clickBeefProd();
		
		searchTopicObj.clickFirstLastPostBy();
		String Str1= searchTopicObj.MsgLoginPage();
		String Str2=searchTopicObj.MsgH1Login();
		S1.assertEquals(Str1, "Message");
		S1.assertEquals(Str2, "Log in");
		S1.assertAll();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("User Not Logged in: User is navigated to Login Screen when user clicks on Authors");
			
	}
	
	
	//Verify Last Post By With Login
	// Click on Last Post By and Enter the Login Details and Verify the Name of the User	
	@Test(priority=18)
	public void verifyLastPostByWithLogin() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		searchTopicObj.clickBeefProd();
		String Str1= searchTopicObj.FirstLastPostBy();
		searchTopicObj.clickFirstLastPostBy();
		String Str2= searchTopicObj.MsgLoginPage();
		String Str3=searchTopicObj.MsgH1Login();
		S1.assertEquals(Str2, "Message");
		S1.assertEquals(Str3, "Log in");
		
		loginPageObj.EmailLP(ExcelDataUtilObj.getData(sheetName1, 2, 0));
		loginPageObj.PasswordLP(ExcelDataUtilObj.getData(sheetName1, 2, 1));
		testUtil.Scroll_DownFull_Page();
		loginPageObj.clickLoginBtnLP();
		String Str4=searchTopicObj.NameOfMember();
		S1.assertEquals(Str1, Str4);
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
		String Str5= searchTopicObj.FirstLastPostBy();
		searchTopicObj.clickFirstLastPostBy();
		String Str6=searchTopicObj.NameOfMember();
		S1.assertEquals(Str5, Str6);
		loginPageObj.clickArrowBtn();
		loginPageObj.clickLogOutBtn();
		testUtil.Switch_To_Alert_Accept();
		loginPageObj.clickAgrivilleLogo();
		
		S1.assertAll();
		System.out.println("Verified Last Post By on Sub page and Member Page");
				
	}
	
	
	
	
	
	
//Verify the Show Threads from the ....... under Display Options
	
	@Test(priority=19)
	public void verifyThreadDisplayOptionsBeginning() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		searchTopicObj.clickBeefProd();
		if(searchTopicObj.isEmptyPagingTop())
		{
			System.out.println("Paging is not Present on Current Page");
		}
		else
		{
			testUtil.Scroll_DownFull_Page();
			searchTopicObj.clickBtmDispOptionsThread();
		
			ArrayList<String> Beginning=searchTopicObj.BtmBeginning();
			
			for(int i=0;i<Beginning.size();i++)
			{
				String Actual=Beginning.get(i);
				String Expected=ExcelDataUtilObj.getData(sheetName, i+1, 1);
				S1.assertEquals(Actual, Expected);
				System.out.println(Actual+ " is Actual Value from Agriville Web Application and Expected Value is " + Expected+ " Matches");
			}
			
			
			System.out.println("All values in Beginning dropdown are Matched");	
		}
		S1.assertAll();
		
		
	}
	
	//Verify the Sort Threads: under Display Options
	@Test(priority=20)
	public void verifyThreadDisplayOptionsSortThread() throws InterruptedException
	{
		loginPageObj.clickAgrivilleLogo();
		SoftAssert S1=new SoftAssert();
		searchTopicObj.clickBeefProd();
		if(searchTopicObj.isEmptyPagingTop())
		{
			System.out.println("Paging is not Present on Current Page");
		}
		else
		{
			testUtil.Scroll_DownFull_Page();
			searchTopicObj.clickBtmDispOptionsThread();
		
			ArrayList<String> ThreadSortAtBottom=searchTopicObj.BtmThreadSort();
			
			for(int i=0;i<ThreadSortAtBottom.size();i++)
			{
				String Actual=ThreadSortAtBottom.get(i);
				String Expected=ExcelDataUtilObj.getData(sheetName, i+1, 2);
				S1.assertEquals(Actual, Expected);
				System.out.println(Actual+ " is Actual Value from Agriville Web Application and Expected Value is " + Expected+ " Matches");
			}
			System.out.println("All values in Sort Thread dropdown are Matched");
			
		}
		S1.assertAll();
	}
	
	//Verify the Show Thread Button for Last day in Descending Order
	@Test(priority=21)
	public void verifyShowThreadsLastDayDesc() throws InterruptedException
	{
		loginPageObj.clickAgrivilleLogo();
		SoftAssert S1=new SoftAssert();
		searchTopicObj.clickBeefProd();
		testUtil.Scroll_DownFull_Page();
		searchTopicObj.clickBtmDispOptionsThread();
	
		
		searchTopicObj.SelectLastDay();
		searchTopicObj.clickBtnBtmShowThreads();
		ArrayList<Boolean> listObjLastDay=new ArrayList<Boolean>();
		listObjLastDay=searchTopicObj.H2IsDisplayed();
		if(listObjLastDay.isEmpty())
		{
			String Str1=searchTopicObj.MsgForumTop();
			S1.assertEquals(Str1, "Try using the controls below to search for any older posts that may exist.");	
		}
		else
		{
			for(int i=0;i<listObjLastDay.size();i++)
			{
				S1.assertTrue(listObjLastDay.get(i));
			}
		}
		S1.assertAll();
//		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified Data is Displayed for Last Day in Descending Order");
		
	}

	//Verify the Show Thread button for Last 2 day in Descending Order
	@Test(priority=22)
	public void verifyShowThreadsLast2DayDesc() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
//		searchTopicObj.clickBeefProd();
		testUtil.Scroll_DownFull_Page();
		searchTopicObj.clickBtmDispOptionsThread();
		searchTopicObj.SelectLast2Day();
		searchTopicObj.clickBtnBtmShowThreads();
		ArrayList<Boolean> listObj=new ArrayList<Boolean>();
		listObj=searchTopicObj.H2IsDisplayed();
		if(listObj.isEmpty())
		{
			String Str1=searchTopicObj.MsgForumTop();
			S1.assertEquals(Str1, "Try using the controls below to search for any older posts that may exist.");	
		}
		else
		{
			for(int i=0;i<listObj.size();i++)
			{
			S1.assertTrue(listObj.get(i));
			}
		}
		S1.assertAll();
//		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified Data is Displayed for Last 2 Day in Descending Order");
	}
	
	
	//Verify the Show Thread button 
	//Select Show threads from the Last Week, Select Order Thread in Descending Order and Click on Show Thread Button
	@Test(priority=23)
	public void verifyShowThreadsLastWeekDesc() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
//		searchTopicObj.clickBeefProd();
		testUtil.Scroll_DownFull_Page();
		searchTopicObj.clickBtmDispOptionsThread();
	
		
		searchTopicObj.SelectLastWeek();
		searchTopicObj.clickBtnBtmShowThreads();
		ArrayList<Boolean> listObj=new ArrayList<Boolean>();
		listObj=searchTopicObj.H2IsDisplayed();
		if(listObj.isEmpty())
		{
			String Str1=searchTopicObj.MsgForumTop();
			S1.assertEquals(Str1, "Try using the controls below to search for any older posts that may exist.");	
		}
		else
		{
			for(int i=0;i<listObj.size();i++)
			{
			S1.assertTrue(listObj.get(i));
			}
		}
		S1.assertAll();
//		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified Data is Displayed for Last Week in Descending Order");
	}
	
	//Verify the Show Thread button 
	//Select Show threads from the Last 10 Days, Select Order Thread in Descending Order and Click on Show Thread Button

	@Test(priority=24)
	public void verifyShowThreadsLast10DaysDesc() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
//		searchTopicObj.clickBeefProd();
		testUtil.Scroll_DownFull_Page();
		searchTopicObj.clickBtmDispOptionsThread();
	
		
		searchTopicObj.SelectLast10Days();
		searchTopicObj.clickBtnBtmShowThreads();
		ArrayList<Boolean> listObj=new ArrayList<Boolean>();
		listObj=searchTopicObj.H2IsDisplayed();
		if(listObj.isEmpty())
		{
			String Str1=searchTopicObj.MsgForumTop();
			S1.assertEquals(Str1, "Try using the controls below to search for any older posts that may exist.");	
		}
		else
		{
			for(int i=0;i<listObj.size();i++)
			{
			S1.assertTrue(listObj.get(i));
			}
		}
		S1.assertAll();
//		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified Data is Displayed for Last 10 Day in Descending Order");
	}

	
	//Verify the Show Thread button 
	//Select Show threads from the Last 2 Weeks, Select Order Thread in Descending Order and Click on Show Thread Button
	@Test(priority=25)
	public void verifyShowThreadsLast2WeeksDesc() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
//		searchTopicObj.clickBeefProd();
		testUtil.Scroll_DownFull_Page();
		searchTopicObj.clickBtmDispOptionsThread();
	
		
		searchTopicObj.SelectLast2Weeks();
		searchTopicObj.clickBtnBtmShowThreads();
		ArrayList<Boolean> listObj=new ArrayList<Boolean>();
		listObj=searchTopicObj.H2IsDisplayed();
		if(listObj.isEmpty())
		{
			String Str1=searchTopicObj.MsgForumTop();
			S1.assertEquals(Str1, "Try using the controls below to search for any older posts that may exist.");	
		}
		else
		{
			for(int i=0;i<listObj.size();i++)
			{
			S1.assertTrue(listObj.get(i));
			}
		}
		S1.assertAll();
//		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified Data is Displayed for Last 2 Weeks in Descending Order");
	}

	//Verify the Show Thread button 
	//Select Show threads from the Last Month, Select Order Thread in Descending Order and Click on Show Thread Button
	
	@Test(priority=26)
	public void verifyShowThreadsLastMonthDesc() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
//		searchTopicObj.clickBeefProd();
		testUtil.Scroll_DownFull_Page();
		searchTopicObj.clickBtmDispOptionsThread();
	
		
		searchTopicObj.SelectLastMonth();
		searchTopicObj.clickBtnBtmShowThreads();
		ArrayList<Boolean> listObj=new ArrayList<Boolean>();
		listObj=searchTopicObj.H2IsDisplayed();
		if(listObj.isEmpty())
		{
			String Str1=searchTopicObj.MsgForumTop();
			S1.assertEquals(Str1, "Try using the controls below to search for any older posts that may exist.");	
		}
		else
		{
			for(int i=0;i<listObj.size();i++)
			{
			S1.assertTrue(listObj.get(i));
			}
		}
		S1.assertAll();
//		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified Data is Displayed for Last Month in Descending Order");
	}
	
	//Verify the Show Thread button 
	//Select Show threads from the Last 45 Days, Select Order Thread in Descending Order and Click on Show Thread Button
	
	@Test(priority=27)
	public void verifyShowThreadsLast45DaysDesc() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
//		searchTopicObj.clickBeefProd();
		testUtil.Scroll_DownFull_Page();
		searchTopicObj.clickBtmDispOptionsThread();
	
		
		searchTopicObj.SelectLast45Days();
		searchTopicObj.clickBtnBtmShowThreads();
		ArrayList<Boolean> listObj=new ArrayList<Boolean>();
		listObj=searchTopicObj.H2IsDisplayed();
		if(listObj.isEmpty())
		{
			String Str1=searchTopicObj.MsgForumTop();
			S1.assertEquals(Str1, "Try using the controls below to search for any older posts that may exist.");	
		}
		else
		{
			for(int i=0;i<listObj.size();i++)
			{
			S1.assertTrue(listObj.get(i));
			}
		}
		S1.assertAll();
//		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified Data is Displayed for Last 45 Days in Descending Order");
	}
	
	
	//Verify the Show Thread button 
	//Select Show threads from the Last 2 Months, Select Order Thread in Descending Order and Click on Show Thread Button

	@Test(priority=28)
	public void verifyShowThreadsLast2MonthsDesc() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
//		searchTopicObj.clickBeefProd();
		testUtil.Scroll_DownFull_Page();
		searchTopicObj.clickBtmDispOptionsThread();
	
		
		searchTopicObj.SelectLast2Months();
		searchTopicObj.clickBtnBtmShowThreads();
		ArrayList<Boolean> listObj=new ArrayList<Boolean>();
		listObj=searchTopicObj.H2IsDisplayed();
		if(listObj.isEmpty())
		{
			String Str1=searchTopicObj.MsgForumTop();
			S1.assertEquals(Str1, "Try using the controls below to search for any older posts that may exist.");	
		}
		else
		{
			for(int i=0;i<listObj.size();i++)
			{
			S1.assertTrue(listObj.get(i));
			}
		}
		S1.assertAll();
//		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified Data is Displayed for Last 2 Months in Descending Order");
	}
	
//Verify the Show Thread button 
//Select Show threads from the Last 75 Days, Select Order Thread in Descending Order and Click on Show Thread Button

	@Test(priority=29)
	public void verifyShowThreadsLast75DaysDesc() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
//		searchTopicObj.clickBeefProd();
		testUtil.Scroll_DownFull_Page();
		searchTopicObj.clickBtmDispOptionsThread();
	
		
		searchTopicObj.SelectLast75Days();
		searchTopicObj.clickBtnBtmShowThreads();
		ArrayList<Boolean> listObj=new ArrayList<Boolean>();
		listObj=searchTopicObj.H2IsDisplayed();
		if(listObj.isEmpty())
		{
			String Str1=searchTopicObj.MsgForumTop();
			S1.assertEquals(Str1, "Try using the controls below to search for any older posts that may exist.");	
		}
		else
		{
			for(int i=0;i<listObj.size();i++)
			{
			S1.assertTrue(listObj.get(i));
			}
		}
		S1.assertAll();
//		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified Data is Displayed for Last 75 Days in Descending Order");
	}
	
	//Verify the Show Thread button 
	//Select Show threads from the Last 100 Days, Select Order Thread in Descending Order and Click on Show Thread Button
	@Test(priority=30)
	public void verifyShowThreadsLast100DaysDesc() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
//		searchTopicObj.clickBeefProd();
		testUtil.Scroll_DownFull_Page();
		searchTopicObj.clickBtmDispOptionsThread();
	
		
		searchTopicObj.SelectLast100Days();
		searchTopicObj.clickBtnBtmShowThreads();
		ArrayList<Boolean> listObj=new ArrayList<Boolean>();
		listObj=searchTopicObj.H2IsDisplayed();
		if(listObj.isEmpty())
		{
			String Str1=searchTopicObj.MsgForumTop();
			S1.assertEquals(Str1, "Try using the controls below to search for any older posts that may exist.");	
		}
		else
		{
			for(int i=0;i<listObj.size();i++)
			{
			S1.assertTrue(listObj.get(i));
			}
		}
		S1.assertAll();
//		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified Data is Displayed for Last 100 Days in Descending Order");
	}
	
	//Verify the Show Thread button 
	//Select Show threads from the Beginning, Select Order Thread in Descending Order and Click on Show Thread Button
	@Test(priority=31)
	public void verifyShowThreadsBeginningDesc() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
//		searchTopicObj.clickBeefProd();
		testUtil.Scroll_DownFull_Page();
		searchTopicObj.clickBtmDispOptionsThread();
	
		
		searchTopicObj.SelectBeginning();
		searchTopicObj.clickBtnBtmShowThreads();
		ArrayList<Boolean> listObj=new ArrayList<Boolean>();
		listObj=searchTopicObj.H2IsDisplayed();
		if(listObj.isEmpty())
		{
			String Str1=searchTopicObj.MsgForumTop();
			S1.assertEquals(Str1, "Try using the controls below to search for any older posts that may exist.");	
		}
		else
		{
			for(int i=0;i<listObj.size();i++)
			{
			S1.assertTrue(listObj.get(i));
			}
		}
		S1.assertAll();
//		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified Data is Displayed from the Beginning in Descending Order");
	}
	
	//Verify the Show Thread button 
	//Select Show threads from the Last Year, Select Order Thread in Descending Order and Click on Show Thread Button
	@Test(priority=32)
	public void verifyShowThreadsLastYearDesc() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
//		searchTopicObj.clickBeefProd();
		testUtil.Scroll_DownFull_Page();
		searchTopicObj.clickBtmDispOptionsThread();
	
		
		searchTopicObj.SelectLastYear();
		searchTopicObj.clickBtnBtmShowThreads();
		ArrayList<Boolean> listObj=new ArrayList<Boolean>();
		listObj=searchTopicObj.H2IsDisplayed();
		if(listObj.isEmpty())
		{
			String Str1=searchTopicObj.MsgForumTop();
			S1.assertEquals(Str1, "Try using the controls below to search for any older posts that may exist.");	
		}
		else
		{
			for(int i=0;i<listObj.size();i++)
			{
			S1.assertTrue(listObj.get(i));
			}
		}
		S1.assertAll();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified Data is Displayed for Last Year in Descending Order");
	}
	
	
/*****************************************************************************************************/
	//Verify the Show Thread button 
	//Select Sort Threads as Thread Starter, Select Order Thread in Descending Order and Click on Show Thread Button
	@Test(priority=33)
	public void verifyShowThreads_ThreadTitleDesc() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		searchTopicObj.clickBeefProd();
		testUtil.Scroll_DownFull_Page();
		searchTopicObj.clickBtmDispOptionsThread();
	
		
		searchTopicObj.SelectThreadTitle();
		searchTopicObj.clickBtnBtmShowThreads();
		ArrayList<Boolean> listObj=new ArrayList<Boolean>();
		listObj=searchTopicObj.H2IsDisplayed();
		if(listObj.isEmpty())
		{
			String Str1=searchTopicObj.MsgForumTop();
			S1.assertEquals(Str1, "Try using the controls below to search for any older posts that may exist.");	
		}
		else
		{
			for(int i=0;i<listObj.size();i++)
			{
			S1.assertTrue(listObj.get(i));
			}
		}
		S1.assertAll();
		//loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified Data is Displayed for Thread Title in Descending Order");
	}
	
	
	//Verify the Show Thread button 
	//Select Sort Threads as Last Post, Select Order Thread in Descending Order and Click on Show Thread Button
	@Test(priority=34)
	public void verifyShowThreadLastPostTimeDesc() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
//		searchTopicObj.clickBeefProd();
		testUtil.Scroll_DownFull_Page();
		searchTopicObj.clickBtmDispOptionsThread();
	
		
		searchTopicObj.SelectLastPostTime();
		searchTopicObj.clickBtnBtmShowThreads();
		ArrayList<Boolean> listObj=new ArrayList<Boolean>();
		listObj=searchTopicObj.H2IsDisplayed();
		if(listObj.isEmpty())
		{
			String Str1=searchTopicObj.MsgForumTop();
			S1.assertEquals(Str1, "Try using the controls below to search for any older posts that may exist.");	
		}
		else
		{
			for(int i=0;i<listObj.size();i++)
			{
			S1.assertTrue(listObj.get(i));
			}
		}
		S1.assertAll();
//		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified Data is Displayed for Last Post Time in Descending Order");
	}

	//Verify the Show Thread button 
	//Select Sort Threads as Thread Start Time, Select Order Thread in Descending Order and Click on Show Thread Button
	@Test(priority=35)
	public void verifyShowThreadStartTimeDesc() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
//		searchTopicObj.clickBeefProd();
		testUtil.Scroll_DownFull_Page();
		searchTopicObj.clickBtmDispOptionsThread();
	
		
		searchTopicObj.SelectThreadStartTime();
		searchTopicObj.clickBtnBtmShowThreads();
		ArrayList<Boolean> listObj=new ArrayList<Boolean>();
		listObj=searchTopicObj.H2IsDisplayed();
		if(listObj.isEmpty())
		{
			String Str1=searchTopicObj.MsgForumTop();
			S1.assertEquals(Str1, "Try using the controls below to search for any older posts that may exist.");	
		}
		else
		{
			for(int i=0;i<listObj.size();i++)
			{
			S1.assertTrue(listObj.get(i));
			}
		}
		S1.assertAll();
//		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified Data is Displayed for Thread Start Time in Descending Order");
	}
	//Verify the Show Thread button 
	//Select Sort Threads as Number of replies, Select Order Thread in Descending Order and Click on Show Thread Button
	@Test(priority=36)
	public void verifyShowThreadNumberOfRepliesDesc() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
//		searchTopicObj.clickBeefProd();
		testUtil.Scroll_DownFull_Page();
		searchTopicObj.clickBtmDispOptionsThread();
	
		
		searchTopicObj.SelectNumberofReplies();
		searchTopicObj.clickBtnBtmShowThreads();
		ArrayList<Boolean> listObj=new ArrayList<Boolean>();
		listObj=searchTopicObj.H2IsDisplayed();
		if(listObj.isEmpty())
		{
			String Str1=searchTopicObj.MsgForumTop();
			S1.assertEquals(Str1, "Try using the controls below to search for any older posts that may exist.");	
		}
		else
		{
			for(int i=0;i<listObj.size();i++)
			{
			S1.assertTrue(listObj.get(i));
			}
		}
		S1.assertAll();
//		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified Data is Displayed for Number of replies in Descending Order");
	}

	//Verify the Show Thread button 
	//Select Sort Threads as Number of Views, Select Order Thread in Descending Order and Click on Show Thread Button
	@Test(priority=37)
	public void verifyShowThreadNumberOfViewsDesc() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
//		searchTopicObj.clickBeefProd();
		testUtil.Scroll_DownFull_Page();
		searchTopicObj.clickBtmDispOptionsThread();
	
		
		searchTopicObj.SelectNumberofViews();
		searchTopicObj.clickBtnBtmShowThreads();
		ArrayList<Boolean> listObj=new ArrayList<Boolean>();
		listObj=searchTopicObj.H2IsDisplayed();
		if(listObj.isEmpty())
		{
			String Str1=searchTopicObj.MsgForumTop();
			S1.assertEquals(Str1, "Try using the controls below to search for any older posts that may exist.");	
		}
		else
		{
			for(int i=0;i<listObj.size();i++)
			{
			S1.assertTrue(listObj.get(i));
			}
		}
		S1.assertAll();
//		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified Data is Displayed for Number of Views in Descending Order");
	}
	
	//Verify the Show Thread button 
	//Select Sort Threads as Thread Start Date, Select Order Thread in Descending Order and Click on Show Thread Button
	
	@Test(priority=38)
	public void verifyShowThreadStarterDesc() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
//		searchTopicObj.clickBeefProd();
		testUtil.Scroll_DownFull_Page();
		searchTopicObj.clickBtmDispOptionsThread();
	
		
		searchTopicObj.SelectThreadStarter();
		searchTopicObj.clickBtnBtmShowThreads();
		ArrayList<Boolean> listObj=new ArrayList<Boolean>();
		listObj=searchTopicObj.H2IsDisplayed();
		if(listObj.isEmpty())
		{
			String Str1=searchTopicObj.MsgForumTop();
			S1.assertEquals(Str1, "Try using the controls below to search for any older posts that may exist.");	
		}
		else
		{
			for(int i=0;i<listObj.size();i++)
			{
			S1.assertTrue(listObj.get(i));
			}
		}
		S1.assertAll();
//		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified Data is Displayed for Thread Start Date in Descending Order");
	}
	
	//Verify the Show Thread button 
	//Select Sort Threads as Thread Rating, Select Order Thread in Descending Order and Click on Show Thread Button
	@Test(priority=39)
	public void verifyShowThreadRatingDesc() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
//		searchTopicObj.clickBeefProd();
		testUtil.Scroll_DownFull_Page();
		searchTopicObj.clickBtmDispOptionsThread();
	
		
		searchTopicObj.SelectThreadStarter();
		searchTopicObj.clickBtnBtmShowThreads();
		ArrayList<Boolean> listObj=new ArrayList<Boolean>();
		listObj=searchTopicObj.H2IsDisplayed();
		if(listObj.isEmpty())
		{
			String Str1=searchTopicObj.MsgForumTop();
			S1.assertEquals(Str1, "Try using the controls below to search for any older posts that may exist.");	
		}
		else
		{
			for(int i=0;i<listObj.size();i++)
			{
			S1.assertTrue(listObj.get(i));
			}
		}
		S1.assertAll();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified Data is Displayed for Thread Rating in Descending Order");
	}
	
/******************************************************************************************************************/	

	//Ascending Order//
/******************************************************************************************************************/
	
	
	
	
	
	
	
	//Verify the Show Thread button 
	//Select Show Thread From the Last Day, Select Order Thread in Ascending Order and Click on Show Thread Button	
	
	
	@Test(priority=40)
	public void verifyShowThreadsLastDayAsc() throws InterruptedException
	{
		loginPageObj.clickAgrivilleLogo();
		SoftAssert S1=new SoftAssert();
		searchTopicObj.clickBeefProd();
		testUtil.Scroll_DownFull_Page();
		searchTopicObj.clickBtmDispOptionsThread();
	
		searchTopicObj.clickAscOrder();
		searchTopicObj.SelectLastDay();
		searchTopicObj.clickBtnBtmShowThreads();
		ArrayList<Boolean> listObjLastDay=new ArrayList<Boolean>();
		listObjLastDay=searchTopicObj.H2IsDisplayed();
		if(listObjLastDay.isEmpty())
		{
			String Str1=searchTopicObj.MsgForumTop();
			S1.assertEquals(Str1, "Try using the controls below to search for any older posts that may exist.");	
		}
		else
		{
			for(int i=0;i<listObjLastDay.size();i++)
			{
				S1.assertTrue(listObjLastDay.get(i));
			}
		}
		S1.assertAll();
//		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified Data is Displayed for Last Day in Ascending Order");
		
	}
	//Verify the Show Thread button 
	//Select Show Thread From the Last 2 Day, Select Order Thread in Ascending Order and Click on Show Thread Button
	@Test(priority=41)
	public void verifyShowThreadsLast2DayAsc() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
//		searchTopicObj.clickBeefProd();
		testUtil.Scroll_DownFull_Page();
		searchTopicObj.clickBtmDispOptionsThread();
		searchTopicObj.clickAscOrder();
		searchTopicObj.SelectLast2Day();
		searchTopicObj.clickBtnBtmShowThreads();
		ArrayList<Boolean> listObj=new ArrayList<Boolean>();
		listObj=searchTopicObj.H2IsDisplayed();
		if(listObj.isEmpty())
		{
			String Str1=searchTopicObj.MsgForumTop();
			S1.assertEquals(Str1, "Try using the controls below to search for any older posts that may exist.");	
		}
		else
		{
			for(int i=0;i<listObj.size();i++)
			{
			S1.assertTrue(listObj.get(i));
			}
		}
		S1.assertAll();
//		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified Data is Displayed for Last 2 Day in Ascending Order");
	}
	//Verify the Show Thread button 
	//Select Show Thread From the Last Week, Select Order Thread in Ascending Order and Click on Show Thread Button	
	@Test(priority=42)
	public void verifyShowThreadsLastWeekAsc() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
//		searchTopicObj.clickBeefProd();
		testUtil.Scroll_DownFull_Page();
		searchTopicObj.clickBtmDispOptionsThread();
	
		searchTopicObj.clickAscOrder();
		searchTopicObj.SelectLastWeek();
		searchTopicObj.clickBtnBtmShowThreads();
		ArrayList<Boolean> listObj=new ArrayList<Boolean>();
		listObj=searchTopicObj.H2IsDisplayed();
		if(listObj.isEmpty())
		{
			String Str1=searchTopicObj.MsgForumTop();
			S1.assertEquals(Str1, "Try using the controls below to search for any older posts that may exist.");	
		}
		else
		{
			for(int i=0;i<listObj.size();i++)
			{
			S1.assertTrue(listObj.get(i));
			}
		}
		S1.assertAll();
//		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified Data is Displayed for Last Week in Ascending Order");
	}
	
	//Verify the Show Thread button 
	//Select Show Thread From the Last 10 Days, Select Order Thread in Ascending Order and Click on Show Thread Button
	@Test(priority=43)
	public void verifyShowThreadsLast10DaysAsc() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
//		searchTopicObj.clickBeefProd();
		testUtil.Scroll_DownFull_Page();
		searchTopicObj.clickBtmDispOptionsThread();
	
		searchTopicObj.clickAscOrder();
		searchTopicObj.SelectLast10Days();
		searchTopicObj.clickBtnBtmShowThreads();
		ArrayList<Boolean> listObj=new ArrayList<Boolean>();
		listObj=searchTopicObj.H2IsDisplayed();
		if(listObj.isEmpty())
		{
			String Str1=searchTopicObj.MsgForumTop();
			S1.assertEquals(Str1, "Try using the controls below to search for any older posts that may exist.");	
		}
		else
		{
			for(int i=0;i<listObj.size();i++)
			{
			S1.assertTrue(listObj.get(i));
			}
		}
		S1.assertAll();
//		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified Data is Displayed for Last 10 Day in Ascending Order");
	}

	//Verify the Show Thread button 
	//Select Show Thread From the Last 2 Weeks, Select Order Thread in Ascending Order and Click on Show Thread Button	
	@Test(priority=44)
	public void verifyShowThreadsLast2WeeksAsc() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
//		searchTopicObj.clickBeefProd();
		testUtil.Scroll_DownFull_Page();
		searchTopicObj.clickBtmDispOptionsThread();
	
		searchTopicObj.clickAscOrder();
		searchTopicObj.SelectLast2Weeks();
		searchTopicObj.clickBtnBtmShowThreads();
		ArrayList<Boolean> listObj=new ArrayList<Boolean>();
		listObj=searchTopicObj.H2IsDisplayed();
		if(listObj.isEmpty())
		{
			String Str1=searchTopicObj.MsgForumTop();
			S1.assertEquals(Str1, "Try using the controls below to search for any older posts that may exist.");	
		}
		else
		{
			for(int i=0;i<listObj.size();i++)
			{
			S1.assertTrue(listObj.get(i));
			}
		}
		S1.assertAll();
//		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified Data is Displayed for Last 2 Weeks in Ascending Order");
	}

	//Verify the Show Thread button 
	//Select Show Thread From the Last Month, Select Order Thread in Ascending Order and Click on Show Thread Button
	@Test(priority=45)
	public void verifyShowThreadsLastMonthAsc() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
//		searchTopicObj.clickBeefProd();
		testUtil.Scroll_DownFull_Page();
		searchTopicObj.clickBtmDispOptionsThread();
	
		searchTopicObj.clickAscOrder();
		searchTopicObj.SelectLastMonth();
		searchTopicObj.clickBtnBtmShowThreads();
		ArrayList<Boolean> listObj=new ArrayList<Boolean>();
		listObj=searchTopicObj.H2IsDisplayed();
		if(listObj.isEmpty())
		{
			String Str1=searchTopicObj.MsgForumTop();
			S1.assertEquals(Str1, "Try using the controls below to search for any older posts that may exist.");	
		}
		else
		{
			for(int i=0;i<listObj.size();i++)
			{
			S1.assertTrue(listObj.get(i));
			}
		}
		S1.assertAll();
//		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified Data is Displayed for Last Month in Ascending Order");
	}
	
	//Verify the Show Thread button 
	//Select Show Thread From the Last 45 Days, Select Order Thread in Ascending Order and Click on Show Thread Button	
	
	@Test(priority=46)
	public void verifyShowThreadsLast45DaysAsc() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
//		searchTopicObj.clickBeefProd();
		testUtil.Scroll_DownFull_Page();
		searchTopicObj.clickBtmDispOptionsThread();
	
		searchTopicObj.clickAscOrder();
		searchTopicObj.SelectLast45Days();
		searchTopicObj.clickBtnBtmShowThreads();
		ArrayList<Boolean> listObj=new ArrayList<Boolean>();
		listObj=searchTopicObj.H2IsDisplayed();
		if(listObj.isEmpty())
		{
			String Str1=searchTopicObj.MsgForumTop();
			S1.assertEquals(Str1, "Try using the controls below to search for any older posts that may exist.");	
		}
		else
		{
			for(int i=0;i<listObj.size();i++)
			{
			S1.assertTrue(listObj.get(i));
			}
		}
		S1.assertAll();
//		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified Data is Displayed for Last 45 Days in Ascending Order");
	}
	
	//Verify the Show Thread button 
	//Select Show Thread From the Last 2 months Days, Select Order Thread in Ascending Order and Click on Show Thread Button	
	@Test(priority=47)
	public void verifyShowThreadsLast2MonthsAsc() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
//		searchTopicObj.clickBeefProd();
		testUtil.Scroll_DownFull_Page();
		searchTopicObj.clickBtmDispOptionsThread();
	
		searchTopicObj.clickAscOrder();
		searchTopicObj.SelectLast2Months();
		searchTopicObj.clickBtnBtmShowThreads();
		ArrayList<Boolean> listObj=new ArrayList<Boolean>();
		listObj=searchTopicObj.H2IsDisplayed();
		if(listObj.isEmpty())
		{
			String Str1=searchTopicObj.MsgForumTop();
			S1.assertEquals(Str1, "Try using the controls below to search for any older posts that may exist.");	
		}
		else
		{
			for(int i=0;i<listObj.size();i++)
			{
			S1.assertTrue(listObj.get(i));
			}
		}
		S1.assertAll();
//		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified Data is Displayed for Last 2 Months in Ascending Order");
	}
	
	//Verify the Show Thread button 
	//Select Show Thread From the Last 75 Days, Select Order Thread in Ascending Order and Click on Show Thread Button	
	@Test(priority=48)
	public void verifyShowThreadsLast75DaysAsc() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
//		searchTopicObj.clickBeefProd();
		testUtil.Scroll_DownFull_Page();
		searchTopicObj.clickBtmDispOptionsThread();
	
		searchTopicObj.clickAscOrder();
		searchTopicObj.SelectLast75Days();
		searchTopicObj.clickBtnBtmShowThreads();
		ArrayList<Boolean> listObj=new ArrayList<Boolean>();
		listObj=searchTopicObj.H2IsDisplayed();
		if(listObj.isEmpty())
		{
			String Str1=searchTopicObj.MsgForumTop();
			S1.assertEquals(Str1, "Try using the controls below to search for any older posts that may exist.");	
		}
		else
		{
			for(int i=0;i<listObj.size();i++)
			{
			S1.assertTrue(listObj.get(i));
			}
		}
		S1.assertAll();
//		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified Data is Displayed for Last 75 Days in Ascending Order");
	}
	
	//Verify the Show Thread button 
	//Select Show Thread From the Last 100 Days, Select Order Thread in Ascending Order and Click on Show Thread Button	
	@Test(priority=49)
	public void verifyShowThreadsLast100DaysAsc() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
//		searchTopicObj.clickBeefProd();
		testUtil.Scroll_DownFull_Page();
		searchTopicObj.clickBtmDispOptionsThread();
	
		searchTopicObj.clickAscOrder();
		searchTopicObj.SelectLast100Days();
		searchTopicObj.clickBtnBtmShowThreads();
		ArrayList<Boolean> listObj=new ArrayList<Boolean>();
		listObj=searchTopicObj.H2IsDisplayed();
		if(listObj.isEmpty())
		{
			String Str1=searchTopicObj.MsgForumTop();
			S1.assertEquals(Str1, "Try using the controls below to search for any older posts that may exist.");	
		}
		else
		{
			for(int i=0;i<listObj.size();i++)
			{
			S1.assertTrue(listObj.get(i));
			}
		}
		S1.assertAll();
//		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified Data is Displayed for Last 100 Days in Ascending Order");
	}
	//Verify the Show Thread button 
	//Select Show Thread From the Beginning, Select Order Thread in Ascending Order and Click on Show Thread Button	

	@Test(priority=50)
	public void verifyShowThreadsBeginningAsc() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
//		searchTopicObj.clickBeefProd();
		testUtil.Scroll_DownFull_Page();
		searchTopicObj.clickBtmDispOptionsThread();
	
		searchTopicObj.clickAscOrder();
		searchTopicObj.SelectBeginning();
		searchTopicObj.clickBtnBtmShowThreads();
		ArrayList<Boolean> listObj=new ArrayList<Boolean>();
		listObj=searchTopicObj.H2IsDisplayed();
		if(listObj.isEmpty())
		{
			String Str1=searchTopicObj.MsgForumTop();
			S1.assertEquals(Str1, "Try using the controls below to search for any older posts that may exist.");	
		}
		else
		{
			for(int i=0;i<listObj.size();i++)
			{
			S1.assertTrue(listObj.get(i));
			}
		}
		S1.assertAll();
//		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified Data is Displayed from the Beginning in Ascending Order");
	}
	
	//Verify the Show Thread button 
	//Select Show Thread From the Last Year, Select Order Thread in Ascending Order and Click on Show Thread Button	
	@Test(priority=51)
	public void verifyShowThreadsLastYearAsc() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
//		searchTopicObj.clickBeefProd();
		testUtil.Scroll_DownFull_Page();
		searchTopicObj.clickBtmDispOptionsThread();
	
		searchTopicObj.clickAscOrder();
		searchTopicObj.SelectLastYear();
		searchTopicObj.clickBtnBtmShowThreads();
		ArrayList<Boolean> listObj=new ArrayList<Boolean>();
		listObj=searchTopicObj.H2IsDisplayed();
		if(listObj.isEmpty())
		{
			String Str1=searchTopicObj.MsgForumTop();
			S1.assertEquals(Str1, "Try using the controls below to search for any older posts that may exist.");	
		}
		else
		{
			for(int i=0;i<listObj.size();i++)
			{
			S1.assertTrue(listObj.get(i));
			}
		}
		S1.assertAll();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified Data is Displayed for Last Year in Ascending Order");
	}
	
	
/*****************************************************************************************************/

	//Verify the Show Thread button 
	//Select Select Thread Title, Select Order Thread in Ascending Order and Click on Show Thread Button

	@Test(priority=52)
	public void verifyShowThreads_ThreadTitleAsc() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		searchTopicObj.clickBeefProd();
		testUtil.Scroll_DownFull_Page();
		searchTopicObj.clickBtmDispOptionsThread();
		searchTopicObj.clickAscOrder();
		
		searchTopicObj.SelectThreadTitle();
		searchTopicObj.clickBtnBtmShowThreads();
		ArrayList<Boolean> listObj=new ArrayList<Boolean>();
		listObj=searchTopicObj.H2IsDisplayed();
		if(listObj.isEmpty())
		{
			String Str1=searchTopicObj.MsgForumTop();
			S1.assertEquals(Str1, "Try using the controls below to search for any older posts that may exist.");	
		}
		else
		{
			for(int i=0;i<listObj.size();i++)
			{
			S1.assertTrue(listObj.get(i));
			}
		}
		S1.assertAll();
		//loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified Data is Displayed for Thread Title in Ascending Order");
	}
	
	//Verify the Show Thread button 
	//Select Last Post Time, Select Order Thread in Ascending Order and Click on Show Thread Button
	
	@Test(priority=53)
	public void verifyShowThreadLastPostTimeAsc() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
//		searchTopicObj.clickBeefProd();
		testUtil.Scroll_DownFull_Page();
		searchTopicObj.clickBtmDispOptionsThread();
	
		searchTopicObj.clickAscOrder();
		searchTopicObj.SelectLastPostTime();
		searchTopicObj.clickBtnBtmShowThreads();
		ArrayList<Boolean> listObj=new ArrayList<Boolean>();
		listObj=searchTopicObj.H2IsDisplayed();
		if(listObj.isEmpty())
		{
			String Str1=searchTopicObj.MsgForumTop();
			S1.assertEquals(Str1, "Try using the controls below to search for any older posts that may exist.");	
		}
		else
		{
			for(int i=0;i<listObj.size();i++)
			{
			S1.assertTrue(listObj.get(i));
			}
		}
		S1.assertAll();
//		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified Data is Displayed for Last Post Time in Ascending Order");
	}

	//Verify the Show Thread button 
	//Select Thread Start Time, Select Order Thread in Ascending Order and Click on Show Thread Button
	@Test(priority=54)
	public void verifyShowThreadStartTimeAsc() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
//		searchTopicObj.clickBeefProd();
		testUtil.Scroll_DownFull_Page();
		searchTopicObj.clickBtmDispOptionsThread();
	
		searchTopicObj.clickAscOrder();
		searchTopicObj.SelectThreadStartTime();
		searchTopicObj.clickBtnBtmShowThreads();
		ArrayList<Boolean> listObj=new ArrayList<Boolean>();
		listObj=searchTopicObj.H2IsDisplayed();
		if(listObj.isEmpty())
		{
			String Str1=searchTopicObj.MsgForumTop();
			S1.assertEquals(Str1, "Try using the controls below to search for any older posts that may exist.");	
		}
		else
		{
			for(int i=0;i<listObj.size();i++)
			{
			S1.assertTrue(listObj.get(i));
			}
		}
		S1.assertAll();
//		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified Data is Displayed for Thread Start Time in Ascending Order");
	}

	//Verify the Show Thread button 
	//Select Thread Number of Replies, Select Order Thread in Ascending Order and Click on Show Thread Button
	@Test(priority=55)
	public void verifyShowThreadNumberOfRepliesAsc() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
//		searchTopicObj.clickBeefProd();
		testUtil.Scroll_DownFull_Page();
		searchTopicObj.clickBtmDispOptionsThread();
	
		searchTopicObj.clickAscOrder();
		searchTopicObj.SelectNumberofReplies();
		searchTopicObj.clickBtnBtmShowThreads();
		ArrayList<Boolean> listObj=new ArrayList<Boolean>();
		listObj=searchTopicObj.H2IsDisplayed();
		if(listObj.isEmpty())
		{
			String Str1=searchTopicObj.MsgForumTop();
			S1.assertEquals(Str1, "Try using the controls below to search for any older posts that may exist.");	
		}
		else
		{
			for(int i=0;i<listObj.size();i++)
			{
			S1.assertTrue(listObj.get(i));
			}
		}
		S1.assertAll();
//		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified Data is Displayed for Number of replies in Ascending Order");
	}
	//Verify the Show Thread button 
	//Select Thread Sort as Number of Views, Select Order Thread in Ascending Order and Click on Show Thread Button
	@Test(priority=56)
	public void verifyShowThreadNumberOfViewsAsc() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
//		searchTopicObj.clickBeefProd();
		testUtil.Scroll_DownFull_Page();
		searchTopicObj.clickBtmDispOptionsThread();
	
		searchTopicObj.clickAscOrder();
		searchTopicObj.SelectNumberofViews();
		searchTopicObj.clickBtnBtmShowThreads();
		ArrayList<Boolean> listObj=new ArrayList<Boolean>();
		listObj=searchTopicObj.H2IsDisplayed();
		if(listObj.isEmpty())
		{
			String Str1=searchTopicObj.MsgForumTop();
			S1.assertEquals(Str1, "Try using the controls below to search for any older posts that may exist.");	
		}
		else
		{
			for(int i=0;i<listObj.size();i++)
			{
			S1.assertTrue(listObj.get(i));
			}
		}
		S1.assertAll();
//		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified Data is Displayed for Number of Views in Ascending Order");
	}
	
	//Verify the Show Thread button 
	//Select Thread Sort as Thread Start Date, Select Order Thread in Ascending Order and Click on Show Thread Button
	
	@Test(priority=57)
	public void verifyShowThreadStarterAsc() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
//		searchTopicObj.clickBeefProd();
		testUtil.Scroll_DownFull_Page();
		searchTopicObj.clickBtmDispOptionsThread();
	
		searchTopicObj.clickAscOrder();
		searchTopicObj.SelectThreadStarter();
		searchTopicObj.clickBtnBtmShowThreads();
		ArrayList<Boolean> listObj=new ArrayList<Boolean>();
		listObj=searchTopicObj.H2IsDisplayed();
		if(listObj.isEmpty())
		{
			String Str1=searchTopicObj.MsgForumTop();
			S1.assertEquals(Str1, "Try using the controls below to search for any older posts that may exist.");	
		}
		else
		{
			for(int i=0;i<listObj.size();i++)
			{
			S1.assertTrue(listObj.get(i));
			}
		}
		S1.assertAll();
//		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified Data is Displayed for Thread Start Date in Ascending Order");
	}
	
	//Verify the Show Thread button 
	//Select Thread Sort as Thread Rating, Select Order Thread in Ascending Order and Click on Show Thread Button
	@Test(priority=58)
	public void verifyShowThreadRatingAsc() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
//		searchTopicObj.clickBeefProd();
		testUtil.Scroll_DownFull_Page();
		searchTopicObj.clickBtmDispOptionsThread();
	
		searchTopicObj.clickAscOrder();
		searchTopicObj.SelectThreadStarter();
		searchTopicObj.clickBtnBtmShowThreads();
		ArrayList<Boolean> listObj=new ArrayList<Boolean>();
		listObj=searchTopicObj.H2IsDisplayed();
		if(listObj.isEmpty())
		{
			String Str1=searchTopicObj.MsgForumTop();
			S1.assertEquals(Str1, "Try using the controls below to search for any older posts that may exist.");	
		}
		else
		{
			for(int i=0;i<listObj.size();i++)
			{
			S1.assertTrue(listObj.get(i));
			}
		}
		S1.assertAll();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified Data is Displayed for Thread Rating in Acending Order");
	}
	
	
	//Verify Icon Legend below the Discussion Categories
	@Test(priority=59)
	public void verifyIconLegend() throws InterruptedException
	{
		searchTopicObj.clickBeefProd();
		testUtil.Scroll_DownFull_Page();
		SoftAssert S1=new SoftAssert();
		ArrayList<String> listIconLegend=new ArrayList<>();
		searchTopicObj.clickBtmOptionsIcon();
		listIconLegend=searchTopicObj.IconLegendValue();
		for(int i=0;i<listIconLegend.size();i++)
	{
			String Actual=listIconLegend.get(i);
		String Expected=ExcelDataUtilObj.getData(sheetName, i+1, 3);
		S1.assertEquals(Actual, Expected);
		System.out.println(Actual+ " is Actual Value from Agriville Web Application and Expected Value is " + Expected+ " Matches");
	}
	
	S1.assertAll();
	loginPageObj.clickAgrivilleLogo();
	System.out.println("All values in Icon Legend are Matched");
	
	}
	
	
	
	//Enter keyword and click on search button
	//Verify the Thread View on Search Result Page
	@Test(priority=60)
	public void verifyTopicList()
	{
		SoftAssert S1=new SoftAssert();
		searchTopicObj.EnterDataSearchBx(ExcelDataUtilObj.getData(sheetName, 1, 4));
		searchTopicObj.clickBtnSearch();
		String Str1=testUtil.getTitleOfPage();
		S1.assertEquals(Str1,"Search Results - Farming and Agriculture Discussion Forum | Agriville.com","The Page Title is incorrect");
		String Str2=searchTopicObj.ColThreadTitleStarter();
		S1.assertEquals(Str2, "TITLE / THREAD STARTER","The Title Header is Incorrect");
		
		String Str3=searchTopicObj.ColRepliesView();
		S1.assertEquals(Str3, "REPLIES / VIEWS","The Replies / Views is Incorrect");
		
		String Str4=searchTopicObj.ColLastPostBy();
		S1.assertEquals(Str4, "LAST POST BY","The Last Post By is Incorrect");
		S1.assertAll();
		
		
		String Str5=searchTopicObj.FullForum();
		S1.assertEquals(Str5, "Forum › (Keyword(s)");
		
		String Str6=searchTopicObj.FullForumSearchKeyword();
		S1.assertEquals(Str6, ExcelDataUtilObj.getData(sheetName, 1, 4));
		
		loginPageObj.clickAgrivilleLogo();
		
		searchTopicObj.clickBtnSearch();
		String Str7=searchTopicObj.MsgNoSearchResult();
		S1.assertEquals(Str7, "Message");
		
		S1.assertAll();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified Search Result Page");
	}
	



	
	
	
	
	
	
	
	
	@AfterClass
	public void TearDown()
	{
		driver.quit();
	}
	
}
