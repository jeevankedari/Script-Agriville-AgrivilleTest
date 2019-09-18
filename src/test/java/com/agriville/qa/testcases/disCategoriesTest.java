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
import com.agriville.qa.pages.disCategories;
import com.agriville.qa.pages.loginPage;
import com.agriville.qa.util.ExcelDataUtil;
import com.agriville.qa.util.testUtil;

public class disCategoriesTest extends TestBase 
{
	disCategories disCategoriesObj;
	//testUtil testUtilObj;
	ExcelDataUtil ExcelDataUtilObj;
	loginPage loginPageObj;
	String Path="E://Script Agriville//AgrivilleTest//src//main//java//com//agriville//qa//testdata//Agriville.xlsx";
	String sheetName="Disc_Categories";
	String sheetName1="Disc_CategoriesLogin";
	public disCategoriesTest()
	{
		super();
	}
	
	@BeforeClass
	public void SetUp()
	{
		intialization();
		disCategoriesObj = new disCategories();
		//testUtilObj=new testUtil();
		ExcelDataUtilObj=new ExcelDataUtil(Path);
		loginPageObj=new loginPage();
		
	}
	
	
	@Test(priority=1)
	public void verifyCategoriesLandingResult()
	{
		SoftAssert S1=new SoftAssert();
		disCategoriesObj.clickBeefProd();
		ArrayList<Boolean> SearchList=disCategoriesObj.verifySearchResults();
		for(int i=0;i<SearchList.size();i++)
		{
			Boolean flag=disCategoriesObj.verifySearchResults().get(i);
			S1.assertTrue(flag);
		}
		String Str1=disCategoriesObj.TxtBxSearch();
		S1.assertEquals(Str1, "search farmer discussions!","The Text is not Present");
		
		String Str2=disCategoriesObj.H1BeefProd();
		S1.assertEquals(Str2, "Beef Production");
		
		String Str3=disCategoriesObj.BreadCrumbs();
		S1.assertEquals(Str3, "Forum › Beef Production");
		
		String Str4=disCategoriesObj.ColThreadTitleStarter();
		S1.assertEquals(Str4, "TITLE / THREAD STARTER");
		
		String Str5=disCategoriesObj.ColAuthor();
		S1.assertEquals(Str5, "AUTHOR");
		
		String Str6=disCategoriesObj.ColRepliesView();
		S1.assertEquals(Str6, "REPLIES / VIEWS");
		
		String Str7=disCategoriesObj.ColLastPostBy();
		S1.assertEquals(Str7, "LAST POST BY");
		
		S1.assertAll();
		System.out.println("Verified all the Search Result Page");
		disCategoriesObj.clickOnAgrivilleLogo();
		
	}
	
	@Test(priority=2)
	public void verifySortThreadsDropDown()
	{
		disCategoriesObj.clickBeefProd();
		
		ArrayList<String> SortThread=disCategoriesObj.SelectSortThreads();
		
		
		for(int i=0;i<SortThread.size();i++)
		{
			if((ExcelDataUtilObj.getData(sheetName, i+1, 0)).equals(SortThread.get(i)))
			{
				String Actual=SortThread.get(i);
				String Expected=ExcelDataUtilObj.getData(sheetName, i+1, 0);
				System.out.println(Actual+ " is Actual Value from Agriville Web Application and Expected Value is" + Expected+ " Matches");
				
			}
			else
			{
				System.out.println("Values in Sort Thread dropdown do not Match");
			}
		}
		
		System.out.println("All values in Sort Thread dropdown are Matched");
		disCategoriesObj.clickOnAgrivilleLogo();
	}
	
	@Test(priority=3)
	public void verifyDropdDownOptions()
	{
		SoftAssert S1=new SoftAssert();
		
		disCategoriesObj.clickBeefProd();
		
		
		@SuppressWarnings("rawtypes")
		HashMap<Integer, ArrayList> HMALDiscCategory= disCategoriesObj.getTextOnDiscCategory();
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
		disCategoriesObj.clickOnAgrivilleLogo();
		System.out.println("Verified Discussion Categories on Search Page and Verified Header, Title and BreadCrumb");
			
	}
	
	@Test(priority=4)
	public void verifyPaginationAtTop()
	{
		SoftAssert S1=new SoftAssert();
		String StrSecondPage, StrFirstPage, StrNextBtn, StrLast, StrFirst, StrPrevious;
		disCategoriesObj.clickBeefProd();
		if(disCategoriesObj.isEmptyPagingTop())
		{
			System.out.println("Paging is not Present on Current Page");
		}
		else
		{
				StrSecondPage=disCategoriesObj.SecondPageTop();
				S1.assertEquals(StrSecondPage, "700");
				
				StrFirstPage=disCategoriesObj.FirstPageTop();
				S1.assertEquals(StrFirstPage, "700");
				
			
				StrNextBtn=disCategoriesObj.clickBtnNextTop();
				S1.assertEquals(StrNextBtn, "700");
				
				disCategoriesObj.FirstPageTop();
				
				StrLast=disCategoriesObj.clickLastBtnTop();
				S1.assertEquals(StrLast, "700");
				
				StrFirst=disCategoriesObj.clickFirstBtnTop();
				S1.assertEquals(StrFirst, "700");
				
				disCategoriesObj.SecondPageTop();
				
				StrPrevious=disCategoriesObj.clickBtnPreviousTop();
				S1.assertEquals(StrPrevious, "400");
				
		}
		S1.assertAll();
		disCategoriesObj.clickOnAgrivilleLogo();
	}
	
	@Test(priority=5)
	public void verifyPaginationAtBottom()
	{
		SoftAssert S1=new SoftAssert();
		String StrSecondPage, StrFirstPage, StrNextBtn, StrLast, StrFirst, StrPrevious;
		disCategoriesObj.clickBeefProd();
		testUtil.Scroll_DownFull_Page();
		if(disCategoriesObj.isEmptyPagingBottom())
		{
			System.out.println("Paging is not Present on Current Page");
		}
		else
		{
				StrSecondPage=disCategoriesObj.SecondPageBottom();
				S1.assertEquals(StrSecondPage, "700");
				
				
				StrFirstPage=disCategoriesObj.FirstPageBottom();
				S1.assertEquals(StrFirstPage, "700");
					
				StrNextBtn=disCategoriesObj.clickBtnNextBottom();
				S1.assertEquals(StrNextBtn, "700");
								
				disCategoriesObj.FirstPageBottom();
				
				StrLast=disCategoriesObj.clickLastBtnBottom();
				S1.assertEquals(StrLast, "700");
				
									
				
				StrFirst=disCategoriesObj.clickPagingBottomLastPage();
				S1.assertEquals(StrFirst, "700");
				
				disCategoriesObj.SecondPageTop();
				
				StrPrevious=disCategoriesObj.clickBtnPreviousBottom();
				S1.assertEquals(StrPrevious, "400");
					
				
				
		}
		S1.assertAll();
		disCategoriesObj.clickOnAgrivilleLogo();
	}
	
	@Test(priority=6)
	public void verifyForumlink()
	{
		SoftAssert S1=new SoftAssert();
		disCategoriesObj.clickBeefProd();
		disCategoriesObj.clickBCrumbsForum();
		String Str1=testUtil.getTitleOfPage();
		S1.assertEquals(Str1, "Farming and Agriculture Discussion Forum | Agriville.com");
		System.out.println("Verified Navigation to Home Page from Forum Link");
		disCategoriesObj.clickOnAgrivilleLogo();
		S1.assertAll();
		
	}
	
	@Test(priority=7)
	public void verifyPostThreadWithoutLogin()
	{
		SoftAssert S1=new SoftAssert();
		disCategoriesObj.clickBeefProd();
		disCategoriesObj.clickBtnPostAThread();
		String Str1= disCategoriesObj.MsgLoginPage();
		String Str2=disCategoriesObj.MsgH1Login();
		
		S1.assertEquals(Str1, "Message");
		S1.assertEquals(Str2, "Log in");
		
		System.out.println("User Not Logged in: User is navigated to Login Screen when user clicks on Post A Thread Button");
		S1.assertAll();
		disCategoriesObj.clickOnAgrivilleLogo();
	}
	
	
	@Test(priority=8)
	public void verifyPostThreadLoginAccNotActivated() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		loginPageObj.clickLogin();
		Thread.sleep(4000);
		loginPageObj.UserName(ExcelDataUtilObj.getData(sheetName1, 1, 0));
		loginPageObj.Password(ExcelDataUtilObj.getData(sheetName1, 1, 1));
		loginPageObj.clickLoginBtnOnLoginFrame();
		disCategoriesObj.clickBeefProd();
		disCategoriesObj.clickBtnPostAThread();
		
		String Str1=disCategoriesObj.MsgAccountNotActivated();
		S1.assertEquals(Str1, "Message");
		loginPageObj.clickArrowBtn();
		loginPageObj.clickLogOutBtn();
		testUtil.Switch_To_Alert_Accept();
		loginPageObj.clickAgrivilleLogo();
		
		
		S1.assertAll();
		System.out.println("Verified user is not navigated to post a thread page for inactive account ");
		
		
		
	}
	
	@Test(priority=9)
	public void verifyPostThreadLoginAcctActivated() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		loginPageObj.clickLogin();
		Thread.sleep(4000);
		loginPageObj.UserName(ExcelDataUtilObj.getData(sheetName1, 2, 0));
		loginPageObj.Password(ExcelDataUtilObj.getData(sheetName1, 2, 1));
		loginPageObj.clickLoginBtnOnLoginFrame();
		disCategoriesObj.clickBeefProd();
		disCategoriesObj.clickBtnPostAThread();
		
		String Str1=disCategoriesObj.H1PostNewThread();
		S1.assertEquals(Str1, "Post a New Thread");
		loginPageObj.clickArrowBtn();
		loginPageObj.clickLogOutBtn();
		testUtil.Switch_To_Alert_Accept();
		loginPageObj.clickAgrivilleLogo();	
		S1.assertAll();
		System.out.println("Verified user is navigated to post a thread page for Active account ");
	}
	
	@Test(priority=10)
	public void verifyMostRecentPost() throws InterruptedException, ParseException
	{
		SoftAssert S1=new SoftAssert();
		disCategoriesObj.clickBeefProd();
		disCategoriesObj.SelectMostRecentPost();
		ArrayList<Date> listObj=new ArrayList<Date>();
		listObj=disCategoriesObj.LastPostBy();
		
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
	
		System.out.println("Most Recent Post are sorted Correctly ");
		loginPageObj.clickAgrivilleLogo();
		
	}
	
	
	
	
	@Test(priority=11)
	public void verifyMostRecentThread() throws InterruptedException, ParseException
	{
		SoftAssert S1=new SoftAssert();
		disCategoriesObj.clickBeefProd();
		ArrayList<Date> listObj=new ArrayList<Date>();
		disCategoriesObj.SelectMostRecentThread();
		listObj=disCategoriesObj.AuthorDateTime();
		
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
		System.out.println("Most Recent Threads are sorted Correctly");
		loginPageObj.clickAgrivilleLogo();
	}
	
	

	
	@Test(priority=12)
	public void verifyMostRecentReplies() throws InterruptedException, ParseException
	{
		SoftAssert S1=new SoftAssert();
		disCategoriesObj.clickBeefProd();
		ArrayList<Integer> listObj=new ArrayList<Integer>();
		disCategoriesObj.SelectMostRecentReplies();
		listObj=disCategoriesObj.MostRecentReplies();
		
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
		System.out.println("Number of replies are displayad in Descending Order");
		loginPageObj.clickAgrivilleLogo();
	}
	
	@Test(priority=13)
	public void verifyMostRecentViews() throws InterruptedException, ParseException
	{
		SoftAssert S1=new SoftAssert();
		disCategoriesObj.clickBeefProd();
		ArrayList<Integer> listObj=new ArrayList<Integer>();
		disCategoriesObj.SelectMostRecentViews();
		listObj=disCategoriesObj.MostRecentViews();
		
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
		System.out.println("Number of replies are displayad in Descending Order");
		loginPageObj.clickAgrivilleLogo();
	}
	
	
	@Test(priority=13)
	public void verifyH2ThreadTitleUnderForum()
	{
		SoftAssert S1=new SoftAssert();
		disCategoriesObj.clickBeefProd();
		String Str1=disCategoriesObj.H2FirstSubCategory();
		disCategoriesObj.clickH2FirstSubCategory();
		String Str2=disCategoriesObj.h1OnThreadPage();
		
		S1.assertTrue(Str1.contains(Str2));
		disCategoriesObj.clicklinkToSubPage();
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Verified Title Header on Sub Page Under Forum");
		
		
	}
	
	
	@Test(priority=14)
	public void verifyFirstAuthorWithoutLogin()
	{
		SoftAssert S1=new SoftAssert();
		disCategoriesObj.clickBeefProd();
		
		disCategoriesObj.clickFirstAuthor();
		String Str1= disCategoriesObj.MsgLoginPage();
		String Str2=disCategoriesObj.MsgH1Login();
		S1.assertEquals(Str1, "Message");
		S1.assertEquals(Str2, "Log in");
		S1.assertAll();
		System.out.println("User Not Logged in: User is navigated to Login Screen when user clicks on Authors");
			
	}
	
	@Test(priority=15)
	public void verifyFirstAuthorWithLogin() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		disCategoriesObj.clickBeefProd();
		String Str1= disCategoriesObj.FirstAuthor();
		disCategoriesObj.clickFirstAuthor();
		String Str2= disCategoriesObj.MsgLoginPage();
		String Str3=disCategoriesObj.MsgH1Login();
		S1.assertEquals(Str2, "Message");
		S1.assertEquals(Str3, "Log in");
		
		loginPageObj.EmailLP(ExcelDataUtilObj.getData(sheetName1, 2, 0));
		loginPageObj.PasswordLP(ExcelDataUtilObj.getData(sheetName1, 2, 1));
		testUtil.Scroll_DownFull_Page();
		loginPageObj.clickLoginBtnLP();
		String Str4=disCategoriesObj.NameOfMember();
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
		disCategoriesObj.clickBeefProd();
		String Str5= disCategoriesObj.FirstAuthor();
		disCategoriesObj.clickFirstAuthor();
		String Str6=disCategoriesObj.NameOfMember();
		S1.assertEquals(Str5, Str6);
		loginPageObj.clickArrowBtn();
		loginPageObj.clickLogOutBtn();
		testUtil.Switch_To_Alert_Accept();
		loginPageObj.clickAgrivilleLogo();
		
		S1.assertAll();
		System.out.println("Verified Author name on Sub page and Member Page");
				
	}
	
	@Test(priority=16)
	public void verifyLastPostByWithoutLogin()
	{
		SoftAssert S1=new SoftAssert();
		disCategoriesObj.clickBeefProd();
		
		disCategoriesObj.clickFirstLastPostBy();
		String Str1= disCategoriesObj.MsgLoginPage();
		String Str2=disCategoriesObj.MsgH1Login();
		S1.assertEquals(Str1, "Message");
		S1.assertEquals(Str2, "Log in");
		S1.assertAll();
		System.out.println("User Not Logged in: User is navigated to Login Screen when user clicks on Authors");
			
	}
	
	
	
	@Test(priority=17)
	public void verifyLastPostByWithLogin() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		disCategoriesObj.clickBeefProd();
		String Str1= disCategoriesObj.FirstLastPostBy();
		disCategoriesObj.clickFirstLastPostBy();
		String Str2= disCategoriesObj.MsgLoginPage();
		String Str3=disCategoriesObj.MsgH1Login();
		S1.assertEquals(Str2, "Message");
		S1.assertEquals(Str3, "Log in");
		
		loginPageObj.EmailLP(ExcelDataUtilObj.getData(sheetName1, 2, 0));
		loginPageObj.PasswordLP(ExcelDataUtilObj.getData(sheetName1, 2, 1));
		testUtil.Scroll_DownFull_Page();
		loginPageObj.clickLoginBtnLP();
		String Str4=disCategoriesObj.NameOfMember();
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
		disCategoriesObj.clickBeefProd();
		String Str5= disCategoriesObj.FirstLastPostBy();
		disCategoriesObj.clickFirstLastPostBy();
		String Str6=disCategoriesObj.NameOfMember();
		S1.assertEquals(Str5, Str6);
		loginPageObj.clickArrowBtn();
		loginPageObj.clickLogOutBtn();
		testUtil.Switch_To_Alert_Accept();
		loginPageObj.clickAgrivilleLogo();
		
		S1.assertAll();
		System.out.println("Verified Author name on Sub page and Member Page");
				
	}
	
	
	
	
	
	
	
	
	
	public void verifyThreadDisplayOptions()
	{
		disCategoriesObj.clickBeefProd();
		if(disCategoriesObj.isEmptyPagingTop())
		{
			System.out.println("Paging is not Present on Current Page");
		}
		else
		{
		
		}
	}

	
	
	


	@AfterClass
	public void TearDown()
	{
		driver.quit();
	}
	
}
