package com.agriville.qa.testcases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.agriville.qa.base.TestBase;
import com.agriville.qa.pages.homePageAgriville;
import com.agriville.qa.util.testUtil;

public class homePageAgrivilleTest extends TestBase 
{
	homePageAgriville homePageAgrivilleObj;
	testUtil testUtilObj;
	public homePageAgrivilleTest()
	{
		super();
	}
	
	public void SetUp()
	{
		intialization();
		homePageAgrivilleObj = new homePageAgriville();
		testUtilObj=new testUtil();
		
	}
	
	
	
	@Test(priority=1)
	public void agrivilleLogoisDisplayed()
	{
		boolean flag=homePageAgrivilleObj.agrivilleLogoisDisplayed();
		Assert.assertTrue(flag);
		System.out.println("User is on Agriville Home page and Agriville Log is displayed");
	}
	
	@Test(priority=2)
	public void verifyNavigationToFarmsDotCom() throws InterruptedException
	{
		boolean flag=homePageAgrivilleObj.farmsLogoisDisplayed();
		Assert.assertTrue(flag);
		homePageAgrivilleObj.clickOnfarmsLogoisDisplayed();
		String Str1=testUtilObj.SwitchToChildTab_ReturnTitleOfChildTab_BackToParentTab();
		Assert.assertEquals(Str1, "Farms.com – Latest agriculture information,"
			+ " farming news, commentary, weather, auctions, markets & new products portal");
		homePageAgrivilleObj.clickOnAgrivilleLogo();
		System.out.println("Verified Navigation to Farms.com Page and Verified user is back to Agriville Page");
	}
	
	@Test(priority=3)
	public void verifyNavigationToHomePageForums()
	{
		homePageAgrivilleObj.clickOnMenuHomeForums();
		boolean flag=homePageAgrivilleObj.agrivilleLogoisDisplayed();
		Assert.assertTrue(flag);
		System.out.println("Verified Navigation to Home Page of Agriville and "
				+ "Verified user is on Agriville Page");
		homePageAgrivilleObj.clickOnAgrivilleLogo();
	}
	
	@Test(priority=4)
	public void verifyNavigationToNews() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		homePageAgrivilleObj.clickOnMenuNews();
		testUtilObj.Switch_To_ChildTab();
		String Str1=homePageAgrivilleObj.NEWSHeader1();
		String Str2=testUtil.getTitleOfPage();
		testUtilObj.Switch_To_ParentTab();
		S1.assertEquals(Str1, "News","First Soft Assert Failed");
		S1.assertEquals(Str2, "Farming News - Agriculture Articles | Farms.com","Second Soft Assert Failed");
		homePageAgrivilleObj.clickOnAgrivilleLogo();
		S1.assertAll();
		System.out.println("Verified Navigation to News Page of Farms.com and Verified user is back to Agriville Page");
		
	}
	
	@Test(priority=5)
	public void verifyNavigationToAgMarkets() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		homePageAgrivilleObj.clickOnMenuMarkets();
		testUtilObj.Switch_To_ChildTab();
		String Str1=homePageAgrivilleObj.AgMarketsH1();
		String Str2=testUtil.getTitleOfPage();
		testUtilObj.Switch_To_ParentTab();
		S1.assertEquals(Str1, "Ag Markets","First Soft Assert Failed");
		S1.assertEquals(Str2, "Ag Markets | Commodity Futures | Farms.com","Second Soft Assert Failed");
		homePageAgrivilleObj.clickOnAgrivilleLogo();
		S1.assertAll();
		System.out.println("Verified Navigation to AgMarkets Page of Farms.com and Verified user is back to Agriville Page");
	
	}
	
	
	@Test(priority=6)
	public void verifyNavigationToClassifieds() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		homePageAgrivilleObj.clickOnMenuClassifieds();
		String Str1=testUtilObj.SwitchToChildTab_ReturnTitleOfChildTab_BackToParentTab();
		S1.assertEquals(Str1, "Classifieds | Buy and Sell Classifieds | Farms.com");
		homePageAgrivilleObj.clickOnAgrivilleLogo();
		S1.assertAll();
		System.out.println("Verified Navigation to Classifieds Page of Farms.com and Verified user is back to Agriville Page");
		
	}	
	
	
	@Test(priority=7)
	public void verifyNavigationToNewsFromDropDown() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		homePageAgrivilleObj.clickOndropDownBtn();
		Thread.sleep(4000);
		homePageAgrivilleObj.clickOnDropDownNews();
		testUtilObj.Switch_To_ChildTab();
		String Str1=homePageAgrivilleObj.NEWSHeader1();
		String Str2=testUtil.getTitleOfPage();
		S1.assertEquals(Str1, "News","First Soft Assert Failed");
		S1.assertEquals(Str2, "Farming News - Agriculture Articles | Farms.com","Second Soft Assert Failed");
		testUtilObj.Switch_To_ParentTab();
		homePageAgrivilleObj.clickOnAgrivilleLogo();
		S1.assertAll();
		System.out.println("Verified Navigation to News Page of Farms.com and Verified user is back to Agriville Page");
		
	}	
	

	@Test(priority=8)
	public void verifyNavigationToMarketsFromDropDown() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		homePageAgrivilleObj.clickOndropDownBtn();
		Thread.sleep(4000);
		homePageAgrivilleObj.clickOnDropDownMarkets();
		testUtilObj.Switch_To_ChildTab();
		String Str1=homePageAgrivilleObj.AgMarketsH1();
		S1.assertEquals(Str1, "Ag Markets","First Soft Assert Failed");
		String Str2=testUtil.getTitleOfPage();
		S1.assertEquals(Str2, "Ag Markets | Commodity Futures | Farms.com","Second Soft Assert Failed");
		testUtilObj.Switch_To_ParentTab();
		homePageAgrivilleObj.clickOnAgrivilleLogo();
		S1.assertAll();
		System.out.println("Verified Navigation to Markets Page of Farms.com and Verified user is back to Agriville Page");
	}	
	
	@Test(priority=9)
	public void verifyNavigationToClassifiedsFromDropDown() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		homePageAgrivilleObj.clickOndropDownBtn();
		Thread.sleep(4000);
		homePageAgrivilleObj.clickOnDropDownClassifieds();
		testUtilObj.Switch_To_ChildTab();
		String Str1=homePageAgrivilleObj.H1Classifieds();
		S1.assertEquals(Str1, "Classifieds","First Soft Assert Failed");
		String Str2=testUtil.getTitleOfPage();
		S1.assertEquals(Str2, "Classifieds | Buy and Sell Classifieds | Farms.com","Second Soft Assert Failed");
		testUtilObj.Switch_To_ParentTab();
		homePageAgrivilleObj.clickOnAgrivilleLogo();
		S1.assertAll();
		System.out.println("Verified Navigation to Classifieds Page of Farms.com and Verified user is back to Agriville Page");
	}	
	
	@Test(priority=10)
	public void verifyNavigationToUFEFromDropDown() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		homePageAgrivilleObj.clickOndropDownBtn();
		Thread.sleep(4000);
		homePageAgrivilleObj.clickOnDropDownUsedFarmEquipment();
		testUtilObj.Switch_To_ChildTab();
		String Str1=homePageAgrivilleObj.UsedFarmEquipmentH1();
		String Str2=testUtil.getTitleOfPage();
		
		S1.assertEquals(Str1, "Used Farm Equipment","First Soft Assert Failed");
		S1.assertEquals(Str2, "Used Farm Equipment | Farm Equipment for Sale | Farms.com","Second Soft Assert Failed");
		
		testUtilObj.Switch_To_ParentTab();
		homePageAgrivilleObj.clickOnAgrivilleLogo();
		S1.assertAll();
		System.out.println("Verified Navigation to Used Farm Equipment Page of Farms.com and Verified user is back to Agriville Page");
	}
	
	
	@Test(priority=11)
	public void verifyNavigationToAgSearchFromDropDown() throws InterruptedException
	{
		homePageAgrivilleObj.clickOndropDownBtn();
		Thread.sleep(4000);
		homePageAgrivilleObj.clickOnDropDownAgSearch();
		String Str1=testUtilObj.SwitchToChildTab_ReturnTitleOfChildTab_BackToParentTab();
		Assert.assertEquals(Str1, "Agriculture Products and Services Directory | AgSearch.com");
		homePageAgrivilleObj.clickOnAgrivilleLogo();
		System.out.println("Verified Navigation to AgSearch Page of Farms.com and Verified user is back to Agriville Page");
	}	
	
	@Test(priority=12)
	public void verifyNavigationToRiskMgmtFromDropDown() throws InterruptedException
	{
		homePageAgrivilleObj.clickOndropDownBtn();
		Thread.sleep(4000);
		homePageAgrivilleObj.clickOnDropDownRiskMgmt();
		String Str1=testUtilObj.SwitchToChildTab_ReturnTitleOfChildTab_BackToParentTab();
		Assert.assertEquals(Str1, "Home | Farms.com Risk Management");
		homePageAgrivilleObj.clickOnAgrivilleLogo();
		System.out.println("Verified Navigation to Risk Management Page and Verified user is back to Agriville Page");
	}	
	
	@Test(priority=13)
	public void verifyNavigationToAgrivilleCommunityFromDropDown() throws InterruptedException
	{
		homePageAgrivilleObj.clickOndropDownBtn();
		Thread.sleep(4000);
		homePageAgrivilleObj.clickOnDropDownAgrivilleCommunity();
		String Str1=testUtilObj.SwitchToChildTab_ReturnTitleOfChildTab_BackToParentTab();
		Assert.assertEquals(Str1, "Farming and Agriculture Discussion Forum | Agriville.com");
		homePageAgrivilleObj.clickOnAgrivilleLogo();
		System.out.println("Verified Navigation to Agriville Community Page and Verified user is back to Agriville Page");
	}	
	
	@Test(priority=14)
	public void verifyNavigationToRealEstateFromDropDown() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		homePageAgrivilleObj.clickOndropDownBtn();
		Thread.sleep(4000);
		homePageAgrivilleObj.clickOnDropDownRealEstate();
		testUtilObj.Switch_To_ChildTab();
		String Str1=homePageAgrivilleObj.RealEstateH1();
		String Str2=testUtil.getTitleOfPage();
		S1.assertEquals(Str1, "Farm Real Estate","First Soft Assert Failed");
		S1.assertEquals(Str2, "Farm Real Estate | Farms.com","Second Soft Assert Failed");
		testUtilObj.Switch_To_ParentTab();
		homePageAgrivilleObj.clickOnAgrivilleLogo();
		S1.assertAll();
		System.out.println("Verified Navigation to Farm Real Estate Page of Farms.com and Verified user is back to Agriville Page");
	
	}	
	
	@Test(priority=15)
	public void verifyNavigationToPigChampFromDropDown() throws InterruptedException
	{
		homePageAgrivilleObj.clickOndropDownBtn();
		Thread.sleep(4000);
		homePageAgrivilleObj.clickOnDropDownPigCHAMP();
		String Str1=testUtilObj.SwitchToChildTab_ReturnTitleOfChildTab_BackToParentTab();
		Assert.assertEquals(Str1, "Swine Management Software | PigCHAMP.com");
		homePageAgrivilleObj.clickOnAgrivilleLogo();
		System.out.println("Verified Navigation to PigChamp Page and Verified user is back to Agriville Page");
	}	
	
	@Test(priority=16)
	public void verifyNavigationToAgCareersFromDropDown() throws InterruptedException
	{
		homePageAgrivilleObj.clickOndropDownBtn();
		Thread.sleep(4000);
		homePageAgrivilleObj.clickOnDropDownAgCareers();
		String Str1=testUtilObj.SwitchToChildTab_ReturnTitleOfChildTab_BackToParentTab();
		Assert.assertEquals(Str1, "AgCareers.com - Agriculture Jobs & Agriculture Careers");
		homePageAgrivilleObj.clickOnAgrivilleLogo();
		System.out.println("Verified Navigation to AgCareers Page and Verified user is back to Agriville Page");
	}
	
	@Test(priority=17)
	public void verifyNavigationToFarmsAppsFromDropDown() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		homePageAgrivilleObj.clickOndropDownBtn();
		Thread.sleep(4000);
		homePageAgrivilleObj.clickOnDropDownAgApps();
		testUtilObj.Switch_To_ChildTab();
		String Str1=homePageAgrivilleObj.FarmsAndAgriAppsH1();
		Assert.assertEquals(Str1, "Farming and Agriculture Apps");
		String Str2=testUtil.getTitleOfPage();
		S1.assertEquals(Str1, "Farming and Agriculture Apps","First Soft Assert Failed");
		S1.assertEquals(Str2, "Farming and Agriculture Apps | Farms.com","Second Soft Assert Failed");
		testUtilObj.Switch_To_ParentTab();
		homePageAgrivilleObj.clickOnAgrivilleLogo();
		S1.assertAll();
		System.out.println("Verified Navigation to Farming and Agriculture Appse Page of Farms.com and Verified user is back to Agriville Page");
		
	}	
	
	@Test(priority=18)
	public void verifyLoginAndRegisterLinkisDisplayed() throws InterruptedException
	{
		Thread.sleep(4000);
		for(int i=0;i<homePageAgrivilleObj.LoginAndRegisterLinkisDisplayed().size();i++)
		{
			boolean flag=homePageAgrivilleObj.LoginAndRegisterLinkisDisplayed().get(i);
			Assert.assertTrue(flag);
			
		}
		System.out.println("Login and Register Link is Displayed");
		homePageAgrivilleObj.clickOnAgrivilleLogo();
	}
	
	@Test(priority=19)
	public void verifyNavigationToRegisterPage()
	{
		SoftAssert S1=new SoftAssert();
		homePageAgrivilleObj.clickOnRegisterLink();
		String Str1=homePageAgrivilleObj.RegisterNowH1();
		S1.assertEquals(Str1, "Register","First Soft Assert Failed");
		String Str2=testUtil.getTitleOfPage();
		S1.assertEquals(Str2, "Register at Farming and Agriculture Discussion Forum | Agriville.com","Second Soft Assert Failed");
		S1.assertAll();
		System.out.println("Verified Navigation to Register Page and Verfied user is back to Agriville Home Page");
		homePageAgrivilleObj.clickOnAgrivilleLogo();
	}
	
	@Test(priority=20)
	public void verifyLoginForm() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		homePageAgrivilleObj.clickOnLoginLink();
		Thread.sleep(4000);
		for(int i=0;i<homePageAgrivilleObj.UserNameAndPassword().size();i++)
		{
			boolean flag=homePageAgrivilleObj.UserNameAndPassword().get(i);
			S1.assertTrue(flag,"SoftAssert Failed on Loop");
			
		}
		
		
		String Str1=homePageAgrivilleObj.RemeberMeLbl();
		S1.assertEquals(Str1, "Remember Me?","First SoftAssert Failed");
		
		String Str2=homePageAgrivilleObj.ForgotPwdText();
		S1.assertEquals(Str2, "Forgot your password?","Second SoftAssert Failed");
		
		String Str3=homePageAgrivilleObj.DoNotHaveAgrivilleAcc();
		S1.assertEquals(Str3, "Don’t have an Agriville account?","Third SoftAssert Failed");
		
		String Str4=homePageAgrivilleObj.RegisterNowLink();
		S1.assertEquals(Str4, "Register Now","Fourth SoftAssert Failed");
		S1.assertAll();
		System.out.println("Verified Login Form in DropDown");
		homePageAgrivilleObj.clickOnAgrivilleLogo();
		
	}

	@Test(priority=21)
	public void verifyNavigationToForgotYourPwdFrmDropDwn() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		homePageAgrivilleObj.clickOnLoginLink();
		Thread.sleep(4000);
		homePageAgrivilleObj.clickOnForgotPwdLink();
		Thread.sleep(4000);
		String Str1=homePageAgrivilleObj.ForgotPwdH1();
		S1.assertEquals(Str1, "Lost Password Recovery Form","First SoftAssert Failed");
		String Str2=testUtil.getTitleOfPage();
		S1.assertEquals(Str2, "Lost Password Recovery Form - Farming and Agriculture Discussion Forum | Agriville.com","Second SoftAssert Failed");
		S1.assertAll();
		System.out.println("User is navigated to Forgot your Password Screen and  Verified user is back to Agriville Page");
		homePageAgrivilleObj.clickOnAgrivilleLogo();
		
		
	}
	
	@Test(priority=22)
	public void verifyNavigationToRegisterNowFrmDropDwn() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		homePageAgrivilleObj.clickOnLoginLink();
		Thread.sleep(4000);
		homePageAgrivilleObj.clickOnRegisterNowLink();
		String Str1=homePageAgrivilleObj.RegisterNowH1();
		S1.assertEquals(Str1, "Register","First SoftAssert Failed");
		String Str2=testUtil.getTitleOfPage();
		S1.assertEquals(Str2, "Register at Farming and Agriculture Discussion Forum | Agriville.com","Second SoftAssert Failed");
		S1.assertAll();
		System.out.println("User is navigated to Registration Screen and  Verified user is back to Agriville Page");
		
		homePageAgrivilleObj.clickOnAgrivilleLogo();
		
		
	}
	
	@Test(priority=23)
	public void verifySearchField()
	{
		SoftAssert S1=new SoftAssert();
		for(int i=0;i<homePageAgrivilleObj.searchField().size();i++)
		{
			boolean flag=homePageAgrivilleObj.searchField().get(i);
			S1.assertTrue(flag);
			
		}
		S1.assertAll();
		System.out.println("Search Box and Search Button is Present on Agriville HomePage");
		homePageAgrivilleObj.clickOnAgrivilleLogo();
	}
	
	
	
	@Test(priority=24)
	public void verifyDiscussionCategories()
	{
		SoftAssert S1=new SoftAssert();
		String Str1=homePageAgrivilleObj.DiscCategoriesH1();
		S1.assertEquals(Str1, "DISCUSSION CATEGORIES", "First SoftAssert Failed");
	
//		ArrayList<Object> A1=homePageAgrivilleObj.getTextOnDiscSubCategory();
//		ArrayList<String> l1=(ArrayList<String>) A1.get(0);
//		ArrayList<String> l2=(ArrayList<String>) A1.get(1);
//		
	
		@SuppressWarnings("rawtypes")
		HashMap<Integer, ArrayList> HMALDiscCategory= homePageAgrivilleObj.getTextOnDiscSubCategory();
	
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
		homePageAgrivilleObj.clickOnAgrivilleLogo();
		System.out.println("Verified Discussion Categories on Home Page and Verified Header, Title and BreadCrumb");
			
	}
	

	@Test(priority=25)
	public void verifyMostRecentThreads()
	{
		SoftAssert S1=new SoftAssert();
		@SuppressWarnings("rawtypes")
		HashMap<Integer, ArrayList> HMALMostRecentThread= homePageAgrivilleObj.getTextOnMostRecentThreads();
	
		@SuppressWarnings("unchecked")
		ArrayList<String> H1OnMostRecentThreadHP=HMALMostRecentThread.get(0);
		
		@SuppressWarnings("unchecked")
		ArrayList<String> H1OnMostRecentThreadSubPage=HMALMostRecentThread.get(1);
	
		@SuppressWarnings("unchecked")
		ArrayList<String> titleOnMostRecentThreadSubPage=HMALMostRecentThread.get(2);
		
		@SuppressWarnings("unchecked")
		ArrayList<String> breadCrumpMostRecentThreadSubPage=HMALMostRecentThread.get(3);
		
		String Str1=homePageAgrivilleObj.MostRecentThreadsH2OnHP();
		S1.assertEquals(Str1,"MOST RECENT THREADS" );
		
		
		
		
		for(int i=0;i<H1OnMostRecentThreadHP.size();i++)
		{
			
			S1.assertTrue(H1OnMostRecentThreadSubPage.get(i).contains(H1OnMostRecentThreadHP.get(i)),"Title do not Match for "+H1OnMostRecentThreadHP.get(i));
			S1.assertTrue(titleOnMostRecentThreadSubPage.get(i).contains(H1OnMostRecentThreadHP.get(i)),"Title do not Match for "+H1OnMostRecentThreadHP.get(i));
			S1.assertTrue(breadCrumpMostRecentThreadSubPage.get(i).contains(H1OnMostRecentThreadHP.get(i)),"Title do not Match for "+H1OnMostRecentThreadHP.get(i));
			
		}
		S1.assertAll();
		homePageAgrivilleObj.clickOnAgrivilleLogo();
		System.out.println("Verified Most Recent Threads on Home Page and Verified Header, Title and BreadCrumb");
	}
	
	
	@Test(priority=26)
	public void verifyMostPopularThreads()
	
	{	
		SoftAssert S1=new SoftAssert();
		String Str1=homePageAgrivilleObj.MostPopularTopicsH2OnHP();
		S1.assertEquals(Str1,"MOST POPULAR TOPICS" );
		@SuppressWarnings("rawtypes")
		HashMap<Integer, ArrayList> HMALMostRecentThread= homePageAgrivilleObj.getTextOnMostPopularTopics();
	
		@SuppressWarnings("unchecked")
		ArrayList<String> H1OnMostPopularTopicHP=HMALMostRecentThread.get(0);
		
		@SuppressWarnings("unchecked")
		ArrayList<String> H1OnMostPopularTopicSubPage=HMALMostRecentThread.get(1);
	
		@SuppressWarnings("unchecked")
		ArrayList<String> titleOnMostPopularTopicSubPage=HMALMostRecentThread.get(2);
		
		@SuppressWarnings("unchecked")
		ArrayList<String> breadCrumpMostPopularTopicSubPage=HMALMostRecentThread.get(3);
		
	
		
		
		
		for(int i=0;i<H1OnMostPopularTopicHP.size();i++)
		{
			
			S1.assertTrue(H1OnMostPopularTopicSubPage.get(i).contains(H1OnMostPopularTopicHP.get(i)),"Title do not Match for "+H1OnMostPopularTopicHP.get(i));
			S1.assertTrue(titleOnMostPopularTopicSubPage.get(i).contains(H1OnMostPopularTopicHP.get(i)),"Title do not Match for "+H1OnMostPopularTopicHP.get(i));
			S1.assertTrue(breadCrumpMostPopularTopicSubPage.get(i).contains(H1OnMostPopularTopicHP.get(i)),"Title do not Match for "+H1OnMostPopularTopicHP.get(i));
			
		}
		S1.assertAll();
		homePageAgrivilleObj.clickOnAgrivilleLogo();
		System.out.println("Verified Most Popular Topics on Home Page and Verified Header, Title and BreadCrumb");
	}
	
	@Test(priority=27)
	public void verifyBtmAgrivilleLogo()
	{
		SoftAssert S1=new SoftAssert();
		testUtil.Scroll_DownFull_Page();
		boolean flag=homePageAgrivilleObj.BtmAgrivilleLogoisDisplayed();
		S1.assertTrue(flag,"First SoftAssert Failed");
		String Str1=testUtil.getTitleOfPage();
		homePageAgrivilleObj.clickOnBtmAgrvilleLogo();
		S1.assertEquals(Str1, "Farming and Agriculture Discussion Forum | Agriville.com","Second SoftAssert Failed");
		S1.assertAll();
		homePageAgrivilleObj.clickOnAgrivilleLogo();
		System.out.println("Verfiied the Agriville Logo at the Bottom");
		
		
	}
	
	@Test(priority=28)
	public void verifyTermsOfUse() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		testUtil.Scroll_DownFull_Page();
		homePageAgrivilleObj.clickOnBtmTermsOfUse();
		testUtilObj.Switch_To_ChildTab();
		String Str1=homePageAgrivilleObj.H1TermsOfAccess();
		S1.assertEquals(Str1, "Terms of Access","First SoftAssert Failed");
		String Str2=testUtil.getTitleOfPage();
		S1.assertEquals(Str2,"Terms of Access | Farms.com","Second SoftAssert Failed");
		testUtilObj.Switch_To_ParentTab();
		S1.assertAll();
		homePageAgrivilleObj.clickOnAgrivilleLogo();
		System.out.println("Verified the Navigation to Terms Of Use and Verified user is Back to Home Page");
		
	}
	
	@Test(priority=29)
	public void verifyPrivacyPolicy() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		testUtil.Scroll_DownFull_Page();
		homePageAgrivilleObj.clickOnBtmPrivacyPolicy();
		testUtilObj.Switch_To_ChildTab();
		String Str1=homePageAgrivilleObj.H1PrivacyPolicy();
		S1.assertEquals(Str1, "Privacy Policy","First SoftAssert Failed");
		String Str2=testUtil.getTitleOfPage();
		S1.assertEquals(Str2,"Privacy Policy | Farms.com","Second SoftAssert Failed");
		testUtilObj.Switch_To_ParentTab();
		S1.assertAll();
		homePageAgrivilleObj.clickOnAgrivilleLogo();
		System.out.println("Verified the Navigation to Privacy Policy and Verified user is Back to Home Page");
		
	}
	
	
	@Test(priority=30)
	public void verifyContactUS() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		testUtil.Scroll_DownFull_Page();
		homePageAgrivilleObj.clickOnBtmContactUS();
		
		String Str1=homePageAgrivilleObj.H1ContactUS();
		S1.assertEquals(Str1, "Contact Us","First SoftAssert Failed");
		String Str2=testUtil.getTitleOfPage();
		S1.assertEquals(Str2,"ContactDetails","Second SoftAssert Failed");
		testUtil.navigateToPreviouPage();
		homePageAgrivilleObj.clickOnAgrivilleLogo();
		S1.assertAll();
		System.out.println("Verified the Navigation to Contact US and Verified user is Back to Home Page");
		
	}
	
	@Test(priority=30)
	public void verifyAboutUS() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		testUtil.Scroll_DownFull_Page();
		homePageAgrivilleObj.clickOnBtmAboutUS();
		String Str1=homePageAgrivilleObj.H1AboutUS();
		S1.assertEquals(Str1, "Welcome to the new Agriville!","First SoftAssert Failed");
		String Str2=testUtil.getTitleOfPage();
		S1.assertEquals(Str2,"Farming and Agriculture Discussion Forum | Agriville.com - About Us","Second SoftAssert Failed");
		testUtil.navigateToPreviouPage();
		homePageAgrivilleObj.clickOnAgrivilleLogo();
		S1.assertAll();
		System.out.println("Verified the Navigation to About US and Verified user is Back to Home Page");
		
	}
	
	@Test(priority=31)
	public void verifyCopyRight()
	{
		testUtil.Scroll_DownFull_Page();
		String Str1=homePageAgrivilleObj.BtmCopyRight();
		Assert.assertEquals(Str1, "© 2019 FARMS.COM - ALL RIGHTS RESERVED");
		homePageAgrivilleObj.clickOnAgrivilleLogo();
		System.out.println("Verified Copyright for Agriville Page");
	}
	
	@Test(priority=32)
	public void verifyChatPostGuideLines()
	{
		SoftAssert S1=new SoftAssert();
		testUtil.Scroll_DownFull_Page();
		homePageAgrivilleObj.clickOnBtmChatPostGuidelines();
		String Str1=homePageAgrivilleObj.H1ChatPostGuidelines();
		S1.assertEquals(Str1, "Chat Guide Lines","First SoftAssert Failed");
		String Str2=testUtil.getTitleOfPage();
		S1.assertEquals(Str2, "Farming and Agriculture Discussion Forum | Agriville.com - Chat Guide Lines","Second SoftAssert Failed");
		homePageAgrivilleObj.clickOnAgrivilleLogo();
		S1.assertAll();
		System.out.println("Verified the navigation to Chat Post Guide Line and verified user is back to Agriville Home Page");
	}
	
//	@Test(priority=33)
//	public void verifyAdvertisementIsDisplayed()
//	{
//		ArrayList<Boolean> AdverArrayList=homePageAgrivilleObj.AdvtBoxIsDisplayed();
//		for(int i=0;i<AdverArrayList.size();i++)
//		{
//			boolean flag=AdverArrayList.get(i);
//			Assert.assertTrue(flag);
//			System.out.println("The Advertisment Banners are displayed on Home Page");
//			
//		}
//	}
	
	
	
	@Test(priority=33)
	public void verifySwitchDropDown()
	{
		List<WebElement> listPrint=homePageAgrivilleObj.QuickStyleChooser();
		int i=1;
//		System.out.println(listPrint.get(i).getText());
//		System.out.println(listPrint.get(i+1).getText());
		Assert.assertEquals(listPrint.get(i).getText(), "-- Desktop Site");
		Assert.assertEquals(listPrint.get(i+1).getText(), "-- Mobile Site");
		System.out.println("Verified Switch Dropdown is present on Desktop Site");
		homePageAgrivilleObj.clickOnAgrivilleLogo();
		
	}
	
	@Test(priority=34)
	public void verifyNavigateToMobileSite() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		homePageAgrivilleObj.selectMobileSite();
		String Str1=homePageAgrivilleObj.DiscCategoryOnMobile();
		S1.assertEquals(Str1, "Discussion","First SoftAssert Failed");
		
		homePageAgrivilleObj.clickOnMostRecentThreadsMobile();
		String Str2=homePageAgrivilleObj.TextForActiveTabMobile();
		S1.assertEquals(Str2, "Most Recent","Second SoftAssert Failed");
		
		homePageAgrivilleObj.clickOnMostPopularTopicsMobile();
		String Str3=homePageAgrivilleObj.TextForActiveTabMobile();
		S1.assertEquals(Str3, "Most Popula","Third SoftAssert Failed");
		
		homePageAgrivilleObj.clickOnBackToDiscCategoryMobile();
		String Str4=homePageAgrivilleObj.DiscCategoryOnMobile();
		S1.assertEquals(Str4, "Discussion","Fourth SoftAssert Failed");
		
		homePageAgrivilleObj.clickOnAgrivilleLogoMobile();
		homePageAgrivilleObj.clickOnDesktopLinkMobileSite();
		testUtilObj.Switch_To_ParentTab();
		homePageAgrivilleObj.clickOnAgrivilleLogo();
		String Str5=homePageAgrivilleObj.DiscCategoriesH1();
		S1.assertEquals(Str5, "DISCUSSION CATEGORIES", "Fifth SoftAssert Failed");
		System.out.println("User is Navigated to Mobile Site and Back To Desktop Site");
		S1.assertAll();
	}
	
	
		
	
	
	
	@AfterClass
	public void TearDown()
	{
		driver.quit();
	}
	
}
