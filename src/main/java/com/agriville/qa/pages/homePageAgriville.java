package com.agriville.qa.pages;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.agriville.qa.base.TestBase;
import com.agriville.qa.util.testUtil;

public class homePageAgriville extends TestBase
{
	
	
	public homePageAgriville()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Page Factory or Object Repository
	@FindBy(xpath="//div[@class='logo']/a")
	WebElement AgrivilleLogo;
	
	@FindBy(xpath="//div[@id='logo']/div/a")
	WebElement farmsLogo;
	
	@FindBy(xpath="//li/a[contains(text(),'Home / Forums')]")
	WebElement MenuHomeForums;
	
	
	@FindBy(xpath="//li/a[contains(text(),'News')]")
	WebElement MenuNews;
	
	@FindBy(xpath="//div/h1[contains(text(),'News')]")
	WebElement NEWSHeader1;
	
	@FindBy(xpath="//li/a[contains(text(),'Markets')]")
	WebElement MenuMarkets;
	
	@FindBy(xpath="//table[@id='dnn_ctr2371_merger_tblhomepage']//h1[contains(text(),'Ag Markets')]")
	WebElement AgMarketsH1;
	
	@FindBy(xpath="//li/a[contains(text(),'Classifieds')]")
	WebElement MenuClassifieds;
	
	@FindBy(xpath="//span[@id='apps_toggle']/a")
	WebElement dropDownBtn;
	
	@FindBy(xpath="//td[@class='app_label']/a[contains(text(),'News')]")
	WebElement DropDownNews;
	
	@FindBy(xpath="//td[@class='app_label']/a[contains(text(),'Markets')]")
	WebElement DropDownMarkets;
	
	@FindBy(xpath="//td[@class='app_label']/a[contains(text(),'Classifieds')]")
	WebElement DropDownClassifieds;
	
	@FindBy(xpath="//div/h1[contains(text(),'Classifieds')]")
	WebElement H1Classifieds;
	
	@FindBy(xpath="//td[@class='app_label']/a[contains(text(),'Used Farm Equipment')]")
	WebElement DropDownUsedFarmEquipment;
	
	@FindBy(xpath="//div[@id='used_intro_content_area']/h1[contains(text(),'Used Farm Equipment')]")
	WebElement UsedFarmEquipmentH1;
	
	@FindBy(xpath="//td[@class='app_label']/a[contains(text(),'AgSearch')]")
	WebElement DropDownAgSearch;
	
	@FindBy(xpath="//td[@class='app_label']/a[contains(text(),'Risk mgmt')]")
	WebElement DropDownRiskMgmt;
	
	@FindBy(xpath="//td[@class='app_label']/a[contains(text(),'Agriville Community')]")
	WebElement DropDownAgrivilleCommunity;
	
	@FindBy(xpath="//td[@class='app_label']/a[contains(text(),'Real Estate')]")
	WebElement DropDownRealEstate;
	
	@FindBy(xpath="//div[@id='used_intro_content_area']/h1[contains(text(),'Farm Real Estate')]")
	WebElement RealEstateH1;
	
	
	@FindBy(xpath="//td[@class='app_label']/a[contains(text(),'PigCHAMP')]")
	WebElement DropDownPigCHAMP;
	
	@FindBy(xpath="//td[@class='app_label']/a[contains(text(),'AgCareers')]")
	WebElement DropDownAgCareers;
	
	@FindBy(xpath="//td[@class='app_label']/a[contains(text(),'Ag Apps')]")
	WebElement DropDownAgApps;
	
	@FindBy(xpath="//h1[contains(text(),'Farming and Agriculture Apps')]")
	WebElement FarmsAndAgriAppsH1;
	
	@FindBy(xpath="//span[@class='login-links']/a[contains(text(),'Login')]")
	WebElement LoginLink;
	
	
	@FindBy(xpath="//input[@id='navbar_username']")
	WebElement UserName;
	
	@FindBy(xpath="//input[@id='navbar_password']")
	WebElement Password;
	
	@FindBy(xpath="//input[@id='cb_cookieuser_navbar']")
	WebElement RememberMeChKBx;
	
	@FindBy(xpath="//td/label")
	WebElement RemeberMeLbl;
	
	@FindBy(xpath="//td[@class='forgot_text']")
	WebElement ForgotPwdLink;
	
	@FindBy(xpath="//h1[@class='left']")
	WebElement ForgotPwdH1;
	
	@FindBy(xpath="//input[@value='Log in']")
	WebElement LoginBtnOnLoginScreen;
	
	@FindBy(xpath="//tr/td[contains(text(),'Don’t have an Agriville account?')]")
	WebElement DoNotHaveAgrivilleAcc;
	
	@FindBy(xpath="//td[@class='bolded']/a[contains(text(),'Register Now')]")
	WebElement RegisterNowLink;
	
	@FindBy(xpath="//h1[contains(text(),'Register')]")
	WebElement RegisterNowH1;
	
	@FindBy(xpath="//input[@id='textfield']")
	WebElement searchTextBx;
	
	@FindBy(xpath="//input[@name='submit']")
	WebElement searchBtn;
	
	@FindBy(xpath="//h2[contains(text(),'discussion categories')]")
	WebElement DiscCategoriesH1;
	
	@FindBy(xpath="//div[@class='col']/div/span/a")
	List<WebElement> AllDiscCategories;
	
	@FindBy(xpath="//h1")
	WebElement DiscussionCategoriesH1;
	
	@FindBy(xpath="//div[@class='breadcrumbs']")
	WebElement breadCrumbDiscCategoriesH1;
	
	@FindBy(xpath="//div[@class='post-col']/div[@class='row']/span/a")
	List<WebElement> AllMostRecentThreads;
	
	@FindBy(xpath="//div[@class='topic-col']/div[@class='row']/span/a")
	List<WebElement> AllMostPopularTopics;
	
	@FindBy(xpath="//h1")
	WebElement MostRecentThreadsH1;
	
	@FindBy(xpath="//h1")
	WebElement MostPopularTopicsH1;
	
	@FindBy(xpath="//h2[contains(text(),'Most Recent Threads')]")
	WebElement MostRecentThreadsH2OnHP;
	
	@FindBy(xpath="//h2[contains(text(),'Most popular topics')]")
	WebElement MostPopularTopicsH2OnHP;
	
	@FindBy(xpath="//div[@class='breadcrumbs']")
	WebElement breadCrumbMostRecentThreadH1;
	
	@FindBy(xpath="//div[@class='breadcrumbs']")
	WebElement breadCrumbMostPopularTopicsH1;
	
	@FindBy(xpath="//span[@class='login-links']/a[contains(text(),'Register')]")
	WebElement RegisterLink;
	
	@FindBy(xpath="//h1[contains(text(),'Register')]")
	WebElement RegisterH1;
	
	
	@FindBy(xpath="//div[@id='footer-left-col']/a/img[@class='footer-agriville-logo']")
	WebElement BtmAgrvilleLogo;
	
	@FindBy(xpath="//ul[@class='footer-links']/li/a[contains(text(),'terms of use')]")
	WebElement BtmTermsOfUse;
	
	@FindBy(xpath="//tr/td[@class='ContentTitle']")
	WebElement H1termsOfAccess;
	
	@FindBy(xpath="//ul[@class='footer-links']/li/a[contains(text(),'privacy policy')]")
	WebElement BtmPrivacyPolicy;
	
	@FindBy(xpath="//div[@id='dnn_ctr648_HtmlModule_lblContent']/p[contains(text(),'Privacy Policy')]")
	WebElement H1PrivacyPolicy;
	
	
	@FindBy(xpath="//ul[@class='footer-links']/li/a[contains(text(),'contact us')]")
	WebElement BtmContactUs;
	
	@FindBy(xpath="//td[@class='ContentTitle']")
	WebElement H1ContactUS;
	
	@FindBy(xpath="//ul[@class='footer-links']/li/a[contains(text(),'About / Help')]")
	WebElement BtmAboutUs;
	
	@FindBy(xpath="//h1[contains(text(),'Welcome to the new Agriville!')]")
	WebElement H1AboutUS;
	
	@FindBy(xpath="//span[@class='copyright']")
	WebElement BtmCopyRight;
	
	@FindBy(xpath="//span[@class='guideline']/a")
	WebElement BtmChatPostGuidelines;
	
	@FindBy(xpath="//h1[@class='left']")
	WebElement H1ChatPostGuidelines;
	
	//@FindBy(xpath="//div[@id='google_image_div']/a//img")
	
	@FindBy(xpath="//img[@class='i-amphtml-fill-content i-amphtml-replaced-content']")
	List<WebElement> AdvtBox;
	
	@FindBy(xpath="//form/select[@name='styleid']")
	WebElement QuickStyleChooser;
	
	@FindBy(xpath="//li[@class='category active']/a")
	WebElement DiscCategoryOnMobile;
	
	@FindBy(xpath="//li[@class='category']/a")
	WebElement BackToDiscCategoryMobile;
	
	@FindBy(xpath="//li[2]/a/img")
	WebElement MostRecentThreadsMobile;
	
	@FindBy(xpath="//li[3]/a/img")
	WebElement MostPopularTopicsMobile;
	
	@FindBy(xpath="//li[@class='active']/a")
	WebElement TextForActiveTabMobile;
	
	@FindBy(xpath="//div[@id='logo']/a")
	WebElement AgrivilleLogoMobile;
	
	@FindBy(xpath="//li/a[contains(text(),'Desktop Site')]")
	WebElement DesktopLinkMobileSite;
	
	
	
	
	//Actions
	
	
	
	

	public void clickOnAgrivilleLogo()
	{
		AgrivilleLogo.click();
	}
	
			
	public boolean agrivilleLogoisDisplayed()
	{
		return AgrivilleLogo.isDisplayed();
	}
	
	public boolean farmsLogoisDisplayed()
	{
		return farmsLogo.isDisplayed();
	}
	
	public void clickOnfarmsLogoisDisplayed()
	{
		farmsLogo.click();
	}
	
	public void clickOnMenuHomeForums()
	{
		MenuHomeForums.click();
	}
	
	public void clickOnMenuNews()
	{
		MenuNews.click();
	}
	
	public String NEWSHeader1()
	{
		return NEWSHeader1.getText().trim();
	}
	
	public void clickOnDropDownMarkets()
	{
		JavascriptExecutor jsclick =(JavascriptExecutor) driver;
		jsclick.executeScript("arguments[0].click();", DropDownMarkets);
	}
	
	
	public void clickOnMenuMarkets()
	{
		MenuMarkets.click();
	}
	
	public String AgMarketsH1()
	{
		return AgMarketsH1.getText().trim();
	}
	
	public void clickOnMenuClassifieds()
	{
		MenuClassifieds.click();
	}
	
	public void clickOndropDownBtn()
	{
		dropDownBtn.click();
	}
	
	public void clickOnDropDownNews()
	{
		JavascriptExecutor jsclick =(JavascriptExecutor) driver;
		jsclick.executeScript("arguments[0].click();", DropDownNews);
	}
	
	public void clickOnDropDownClassifieds()
	{
		JavascriptExecutor jsclick =(JavascriptExecutor) driver;
		jsclick.executeScript("arguments[0].click();", DropDownClassifieds);
	}
	public String H1Classifieds()
	{
		return H1Classifieds.getText().trim();
	}
	
	
	public void clickOnDropDownUsedFarmEquipment()
	{
		JavascriptExecutor jsclick =(JavascriptExecutor) driver;
		jsclick.executeScript("arguments[0].click();", DropDownUsedFarmEquipment);
		
	}
	
	public String UsedFarmEquipmentH1()
	{
		return UsedFarmEquipmentH1.getText().trim();
	}
	
	public void clickOnDropDownAgSearch()
	{
		JavascriptExecutor jsclick =(JavascriptExecutor) driver;
		jsclick.executeScript("arguments[0].click();", DropDownAgSearch);
		
	}
	
	public void clickOnDropDownRiskMgmt()
	{
		JavascriptExecutor jsclick =(JavascriptExecutor) driver;
		jsclick.executeScript("arguments[0].click();", DropDownRiskMgmt);
	}
	
	public void clickOnDropDownAgrivilleCommunity()
	{
		
		JavascriptExecutor jsclick =(JavascriptExecutor) driver;
		jsclick.executeScript("arguments[0].click();", DropDownAgrivilleCommunity);
		
	}
	
	public String RealEstateH1()
	{
		return RealEstateH1.getText().trim();
	}
	public void clickOnDropDownRealEstate()
	{
		JavascriptExecutor jsclick =(JavascriptExecutor) driver;
		jsclick.executeScript("arguments[0].click();", DropDownRealEstate);
	}
	public void clickOnDropDownPigCHAMP()
	{
		JavascriptExecutor jsclick =(JavascriptExecutor) driver;
		jsclick.executeScript("arguments[0].click();", DropDownPigCHAMP);
	}
	
	public void clickOnDropDownAgCareers()
	{
		
		JavascriptExecutor jsclick =(JavascriptExecutor) driver;
		jsclick.executeScript("arguments[0].click();", DropDownAgCareers);
	}
	public void clickOnDropDownAgApps()
	{
		JavascriptExecutor jsclick =(JavascriptExecutor) driver;
		jsclick.executeScript("arguments[0].click();", DropDownAgApps);
	}
	public String FarmsAndAgriAppsH1()
	{
		return FarmsAndAgriAppsH1.getText().trim();
	}
	
	public ArrayList<Boolean> LoginAndRegisterLinkisDisplayed()
	{
		ArrayList<Boolean> listObj=new ArrayList<Boolean>();
		listObj.add(LoginLink.isDisplayed());
		listObj.add(RegisterLink.isDisplayed());
		return listObj;
	}
	
	public void clickOnLoginLink()
	{
		LoginLink.click();
	}
	
	public void clickOnRegisterLink()
	{
		RegisterLink.click();
	}
	public ArrayList<Boolean> UserNameAndPassword()
	{
		ArrayList<Boolean> listObj=new ArrayList<Boolean>();
		listObj.add(UserName.isDisplayed());
		listObj.add(Password.isDisplayed());
		listObj.add(RememberMeChKBx.isSelected());
		listObj.add(ForgotPwdLink.isDisplayed());
		listObj.add(ForgotPwdLink.isEnabled());
		listObj.add(LoginBtnOnLoginScreen.isDisplayed());
		listObj.add(DoNotHaveAgrivilleAcc.isDisplayed());
		listObj.add(RegisterNowLink.isDisplayed());
		listObj.add(RegisterNowLink.isEnabled());
		return listObj;
	}
	
	public void clickOnForgotPwdLink()
	{
		ForgotPwdLink.click();
	}
	public String ForgotPwdH1()
	{
		return ForgotPwdH1.getText().trim();
	}
	
	public void clickOnRegisterNowLink()
	{
		RegisterNowLink.click();
	}
	
	
	public String RegisterNowH1()
	{
		return RegisterNowH1.getText().trim();
	}
	
	
	public String RemeberMeLbl()
	{
		return RemeberMeLbl.getText().trim() ;
		
	}
	
	public String ForgotPwdText()
	{
		return ForgotPwdLink.getText().trim();
	}
	 
	
	public String DoNotHaveAgrivilleAcc()
	{
		return DoNotHaveAgrivilleAcc.getText().trim();
	}
	
	public String RegisterNowLink()
	{
		return RegisterNowLink.getText().trim();
	}
	
	public ArrayList<Boolean> searchField()
	{
		ArrayList<Boolean> listObj=new ArrayList<Boolean>();
		listObj.add(searchTextBx.isDisplayed());
		listObj.add(searchBtn.isDisplayed());
		return listObj;
	}
	
	public String DiscCategoriesH1()
	{
		return DiscCategoriesH1.getText().trim();
	}
//	public List<WebElement> getWebElementForAllDiscCategory()
//	{
//		return AllDiscCategories;
//		
//	}
	
//	public WebElement getH1OnDiscCategorySubPages()
//	{
//
//		return DiscussionCategoriesH1;
//		
//	}
//	
//	public String getTitleOnDiscCategorySubPages()
//	{
//		return driver.getTitle();
//	}
//	public WebElement getBreadCrumbsOnDiscCategory()
//	{
//		return breadCrumpDiscCategoriesH1;
//		
//	}
//	public ArrayList<String> getH1OnHP()
//	{
//		ArrayList<String> listObj= new ArrayList<String>();
//		for(int i=0;i<AllDiscCategories.size();i++)
//		{
//			String Str1=AllDiscCategories.get(i).getText();
//			listObj.add(Str1);
//		}
//		
//		return listObj;
//	}
//	
	
	
	@SuppressWarnings("rawtypes")
	public HashMap<Integer,ArrayList> getTextOnDiscSubCategory()
	{
		
		ArrayList<String> h1OnHP=new ArrayList<String>();
		ArrayList<String> h1OnSubPage=new ArrayList<String>();
		ArrayList<String> titleOnSubPage=new ArrayList<String>();
		ArrayList<String> breadCrumbsOnSubPage=new ArrayList<String>();
		HashMap<Integer, ArrayList> listMap = new HashMap<Integer, ArrayList>();
		for(int i=0;i<AllDiscCategories.size();i++)
		{
			String Str1=AllDiscCategories.get(i).getText();
			h1OnHP.add(Str1);
			
			JavascriptExecutor jsclick =(JavascriptExecutor) driver;
			jsclick.executeScript("arguments[0].click();", AllDiscCategories.get(i));
			
			//AllDiscCategories.get(i).click();
			String Str2=DiscussionCategoriesH1.getText();
			h1OnSubPage.add(Str2);
			
			String Str3=driver.getTitle();
			titleOnSubPage.add(Str3);
			
			String Str4=breadCrumbDiscCategoriesH1.getText();
			breadCrumbsOnSubPage.add(Str4);
			
			listMap.put(0, h1OnHP);
			listMap.put(1,h1OnSubPage);
			listMap.put(2,titleOnSubPage);
			listMap.put(3,breadCrumbsOnSubPage);
			driver.navigate().back();
					
		}
		return listMap;
		
		
		
	}
	
//	public ArrayList<Object> getTextOnDiscSubCategory()
//	{
//		ArrayList<String> listStr2=new ArrayList<String>();
//		ArrayList<String> listStr2=new ArrayList<String>();
//		ArrayList<Object> listObj=new ArrayList<Object>();
//		for(int i=0;i<AllDiscCategories.size();i++)
//			{
//				
//				AllDiscCategories.get(i).click();
//				String Str2=DiscussionCategoriesH1.getText();
//				listStr1.add(Str2);
//				String Str3=driver.getTitle();
//				listStr2.add(Str3);
//				
//				listObj.add(listStr2);
//				listObj.add(listStr2);
//				driver.navigate().back();
//						
//			}
//			return listObj;
//	}
//	
	
//	public ArrayList<String> getTextMostRecentAndPopularThreadsOnHP()
//	{
//		ArrayList<String> listObj=new ArrayList<String>();
//		for(int i=0;i<AllMostRecentAndPopularThreads.size();i++)
//		{
//			String Str1=AllMostRecentAndPopularThreads.get(i).getText().substring(0, 2);
//			listObj.add(Str1);
//		}
//		return listObj;
//		
//	}
	
	
//	public ArrayList<String> getTextOnClickingMostRecentAndPopularThreads()
//	{
//		ArrayList<String> listObj=new ArrayList<String>();
//		for(int i=0;i<AllMostRecentAndPopularThreads.size();i++)
//		{
//			AllMostRecentAndPopularThreads.get(i).click();
//			
//			String Str1=MostRecentAndPopularThreadsH1.getText().substring(0, 2);
//			listObj.add(Str1);
//			driver.navigate().back();
//			testUtil.Scroll_DownFull_Page();
//			
//		}
//		return listObj;
//		
//	}
	
	@SuppressWarnings("rawtypes")
	public HashMap<Integer,ArrayList> getTextOnMostRecentThreads()
	{
		
		ArrayList<String> h1OnHP=new ArrayList<String>();
		ArrayList<String> h1OnSubPage=new ArrayList<String>();
		ArrayList<String> titleOnSubPage=new ArrayList<String>();
		ArrayList<String> breadCrumbsOnSubPage=new ArrayList<String>();
		HashMap<Integer, ArrayList> listMap = new HashMap<Integer, ArrayList>();
		for(int i=0;i<AllMostRecentThreads.size();i++)
		{
			String Str1=AllMostRecentThreads.get(i).getText();
			h1OnHP.add(Str1);
			
			JavascriptExecutor jsclick =(JavascriptExecutor) driver;
			jsclick.executeScript("arguments[0].click();", AllMostRecentThreads.get(i));
			
			//AllMostRecentThreads.get(i).click();
			String Str2=MostRecentThreadsH1.getText();
			h1OnSubPage.add(Str2);
			
			String Str3=driver.getTitle();
			titleOnSubPage.add(Str3);
			
			String Str4=breadCrumbMostRecentThreadH1.getText();
			breadCrumbsOnSubPage.add(Str4);
			
			listMap.put(0, h1OnHP);
			listMap.put(1,h1OnSubPage);
			listMap.put(2,titleOnSubPage);
			listMap.put(3,breadCrumbsOnSubPage);
		
			AgrivilleLogo.click();
			testUtil.Scroll_DownFull_Page();
					
		}
		return listMap;
		
		
		
	}
	
	public String MostRecentThreadsH2OnHP()
	{
		return MostRecentThreadsH2OnHP.getText().trim();
	}
	
	public String MostPopularTopicsH2OnHP()
	{
		return MostPopularTopicsH2OnHP.getText().trim();
	}
	
	
	@SuppressWarnings("rawtypes")
	public HashMap<Integer,ArrayList> getTextOnMostPopularTopics()
	{
		
		ArrayList<String> h1OnHP=new ArrayList<String>();
		ArrayList<String> h1OnSubPage=new ArrayList<String>();
		ArrayList<String> titleOnSubPage=new ArrayList<String>();
		ArrayList<String> breadCrumbsOnSubPage=new ArrayList<String>();
		HashMap<Integer, ArrayList> listMap = new HashMap<Integer, ArrayList>();
		for(int i=0;i<AllMostPopularTopics.size();i++)
		{
			String Str1=AllMostPopularTopics.get(i).getText();
			h1OnHP.add(Str1);
			
			
			JavascriptExecutor jsclick =(JavascriptExecutor) driver;
			jsclick.executeScript("arguments[0].click();", AllMostPopularTopics.get(i));
			
			
			//AllMostPopularTopics.get(i).click();
			String Str2=MostPopularTopicsH1.getText();
			h1OnSubPage.add(Str2);
			
			String Str3=driver.getTitle();
			titleOnSubPage.add(Str3);
			
			String Str4=breadCrumbMostPopularTopicsH1.getText();
			breadCrumbsOnSubPage.add(Str4);
			
			listMap.put(0, h1OnHP);
			listMap.put(1,h1OnSubPage);
			listMap.put(2,titleOnSubPage);
			listMap.put(3,breadCrumbsOnSubPage);
		
			AgrivilleLogo.click();
			testUtil.Scroll_DownFull_Page();
					
		}
		return listMap;
		
		
		
	}
	
	public void clickOnBtmAgrvilleLogo()
	{
		BtmAgrvilleLogo.click();
	}
	public boolean BtmAgrivilleLogoisDisplayed()
	{
		return BtmAgrvilleLogo.isDisplayed();
	}
	
	public void clickOnBtmTermsOfUse()
	{
		BtmTermsOfUse.click();
	}
	
	public String H1TermsOfAccess()
	{
		return H1termsOfAccess.getText().trim();
	}
	
	public void clickOnBtmPrivacyPolicy()
	{
		BtmPrivacyPolicy.click();
	}
	
	public String H1PrivacyPolicy()
	{
		return H1PrivacyPolicy.getText().trim();
	}
	
	
	public void clickOnBtmContactUS()
	{
		BtmContactUs.click();
	}
	
	public String H1ContactUS()
	{
		return H1ContactUS.getText().trim();
	}
	public void clickOnBtmAboutUS()
	{
		BtmAboutUs.click();
	}
	
	public String H1AboutUS()
	{
		return H1AboutUS.getText().trim();
	}
	
	public String BtmCopyRight()
	{
		return BtmCopyRight.getText().trim();
	}
		
	
	public void clickOnBtmChatPostGuidelines()
	{
		BtmChatPostGuidelines.click();
	}
	
	public String H1ChatPostGuidelines()
	{
		return H1ChatPostGuidelines.getText().trim();
	}
	
	public ArrayList<Boolean> AdvtBoxIsDisplayed()
	{
		ArrayList<Boolean> listObj=new ArrayList<Boolean>();
		testUtil.Scroll_DownFull_Page();
		for(int i=0;i<AdvtBox.size();i++)
		{
			listObj.add(AdvtBox.get(i).isDisplayed());	
		}
		
		return listObj;
		
	}
	
	public List<WebElement> QuickStyleChooser()
	{
		testUtil.Scroll_DownFull_Page();
		Select selectObj=new Select(QuickStyleChooser);
		
		List<WebElement> list=selectObj.getOptions();
		return list;
	}
	
	public void selectMobileSite()
	{
		testUtil.Scroll_DownFull_Page();
		Select selectObj=new Select(QuickStyleChooser);
		selectObj.selectByVisibleText("-- Mobile Site");
		
	}
	
	public String DiscCategoryOnMobile()
	{
		return DiscCategoryOnMobile.getText().substring(0,10);
	}
	
	
	public void clickOnMostRecentThreadsMobile()
	{
		MostRecentThreadsMobile.click();
	}
	
	public void clickOnMostPopularTopicsMobile()
	{
		MostPopularTopicsMobile.click();
	}
	
	public String TextForActiveTabMobile()
	{
		return TextForActiveTabMobile.getText().substring(0, 11);
	}
	
	public void clickOnBackToDiscCategoryMobile()
	{
		BackToDiscCategoryMobile.click();
	}
	
	public void clickOnAgrivilleLogoMobile()
	{
		AgrivilleLogoMobile.click();
	}

	
	public void clickOnDesktopLinkMobileSite()
	{
		testUtil.Scroll_DownFull_Page();
		DesktopLinkMobileSite.click();
		
	}
	
	}
	
	

	


