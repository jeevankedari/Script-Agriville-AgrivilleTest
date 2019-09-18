package com.agriville.qa.pages;


import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.agriville.qa.base.TestBase;
import com.agriville.qa.util.testUtil;

public class disCategories  extends TestBase 
{

	public disCategories()
	{
		PageFactory.initElements(driver, this);
	}
	//Page Factory or Object Repository
	
	@FindBy(xpath="//a[contains(text(),'Beef Production')]")
	WebElement BeefProd;
	
	@FindBy(xpath="//div[@class='logo']/a")
	WebElement AgrivilleLogo;
	
	@FindBy(xpath="//input[@id='textfield']")
	WebElement TxtBxSearch;
	
	@FindBy(xpath="//input[@class='search-btn']")
	WebElement BtnSearch;
	
	@FindBy(xpath="//h1[contains(text(),'Beef Production')]")
	WebElement H1BeefProd;
	
	@FindBy(xpath="//div[@class='commodity_container']//a//img")
	WebElement DropDownArrow;
	
	@FindBy(xpath="//div[@class='breadcrumbs']")
	WebElement BreadCrumbs;
	
	@FindBy(xpath="//div[@class='breadcrumbs']//a[contains(text(),'Forum')]")
	WebElement BCrumbsForum;
	
	@FindBy(xpath="//ul[@class='tool-menu']//div[@class='options_input_block']/select[@id='sel_sort']")
	WebElement SelectSortThreads;
	
	@FindBy(xpath="//input[@id='button']")
	WebElement BtnPostAThread;
	
	@FindBy(xpath="//div[@class='body-left-col']//th[contains(text(),'Title / Thread Starter')]")
	WebElement ColThreadTitleStarter;
	
	@FindBy(xpath="//div[@class='body-left-col']//th[contains(text(),'Author')]")
	WebElement ColAuthor;
	
	@FindBy(xpath="//div[@class='body-left-col']//th[contains(text(),'Replies / Views')]")
	WebElement ColRepliesView;
	
	@FindBy(xpath="//div[@class='body-left-col']//th[contains(text(),'Last Post By')]")
	WebElement ColLastPostBy;
	
	@FindBy(xpath="//div[contains(text(),'thread display options')]")
	WebElement BtmDispOptionsThread;
	
	@FindBy(xpath="//div[@id='thread-expand-row']//select[@id='sel_daysprune']")
	WebElement BtmBeginning;
	
	@FindBy(xpath="//div[@id='thread-expand-row']//select[@id='sel_sort']")
	WebElement BtmThreadStartTime;
	
	@FindBy(xpath="//ul[@class='tool-menu']//input[@id='radio_asc']")
	WebElement BtmAscOrder;
	
	@FindBy(xpath="//ul[@class='tool-menu']//input[@id='radio_dsc']")
	WebElement BtmDescOrder;
	
	@FindBy(xpath="//div[@class='options_input_wrapper']//input[@class='button']")
	WebElement BtmBtnShowThreads;
	
	@FindBy(xpath="//div[contains(text(),'icon legend')]")
	WebElement BtmOptionsIcon;
	
	@FindBy(xpath="//dl[@id='icon_legends']//dd")
	WebElement BtmIconDetails;
	
	@FindBy(xpath="//form[@id='yui-gen0']//li/a")
	List<WebElement> PagingTop;
	
	@FindBy(xpath="//div[@class='pagi']//a[@rel='start']")
	WebElement FirstBtnTop;
	
	@FindBy(xpath="//form[@id='yui-gen0']//li[@class='current']")
	WebElement BtnFontWeight;
	
	@FindBy(xpath="//form[@id='yui-gen26']//a")
	List<WebElement> PagingBottom;
	
	@FindBy(xpath="//form[@id='yui-gen11']//a")
	List<WebElement> PagingBottomLastPage;
	
	
	@FindBy(xpath="//form[@id='yui-gen0']//a[contains(text(),'2')]")
	WebElement SecondPageTop;
	
	@FindBy(xpath="//form[@id='yui-gen26']//a[contains(text(),'2')]")
	WebElement SecondPageBottom;
	
	@FindBy(xpath="//form[@id='yui-gen0']//a[contains(text(),'1')]")
	WebElement FirstPageTop;
	
	@FindBy(xpath="//form[@id='yui-gen26']//a[contains(text(),'1')]")
	WebElement FirstPageBottom;
	
	@FindBy(xpath="//div[@class='titlebar']//li[8]//a[1]//img")
	WebElement NextBtn;
	
	@FindBy(xpath="//div[@class='leftcol']//a")
	List<WebElement> AllDiscCategories;
	
	@FindBy(xpath="//h1")
	WebElement DiscussionCategoriesH1;
	
	@FindBy(xpath="//div[@class='breadcrumbs']")
	WebElement breadCrumbDiscCategoriesH1;
	
	@FindBy(xpath="//h1[contains(text(),'Message')]")
	WebElement MsgLoginPage;
	
	@FindBy(xpath="//h1[contains(text(),'Log in')]")
	WebElement MsgH1Login;
	
	@FindBy(xpath="//span[@class='login-links']/a[contains(text(),'Login')]")
	WebElement LoginLink;
	
	@FindBy(xpath="//h1[contains(text(),'Message')]")
	WebElement MsgAccountNotActivated;
	
	@FindBy(xpath="//th[contains(text(),'Post a New Thread')]")
	WebElement H1PostNewThread;
	
	@FindBy(xpath="//span[@class='label']")
	List<WebElement> AuthorDateTime;
	
	@FindBy(xpath="//div[@class='body-left-col']//th[contains(text(),'Last Post By')]//parent::tr//following-sibling::tr//td[5]")
	List<WebElement> LastPostBy;
	
	@FindBy(xpath="//ul[@class='threadstats td alt']/li[contains(text(),'Replies')]")
	List<WebElement> Replies;
	
	@FindBy(xpath="//ul[@class='threadstats td alt']/li[contains(text(),'Views')]")
	List<WebElement> Views;
	
	@FindBy(xpath="//div[@class='body-left-col']//th[contains(text(), 'Title / Thread Starter')]//parent::tr//following-sibling::tr[1]//h2")
	WebElement H2FirstSubCategory;
	
	@FindBy(xpath="//div[@class='breadcrumbs']//a[2]")
	WebElement linkToSubPage;
	
	@FindBy(xpath="//h1")
	WebElement h1OnThreadPage;
	
	@FindBy(xpath="//div[@class='body-left-col']//th[contains(text(),'Author')]//parent::tr//following-sibling::tr[1]//span[@class='label']/a")
	WebElement FirstAuthor;
	
	@FindBy(xpath="//span[@class='member_username']")
	WebElement NameOfMember;
	
	@FindBy(xpath="//div[@id='yui-gen1']")
	WebElement FirstLastPostBy;
	
	//Actions
	
	public void clickBeefProd()
	{
		BeefProd.click();
	}
	
	public void clickOnAgrivilleLogo()
	{
		AgrivilleLogo.click();
	}
	
	
	public ArrayList<Boolean> verifySearchResults()
	{
		ArrayList<Boolean> listObj=new ArrayList<Boolean>();
		listObj.add(AgrivilleLogo.isDisplayed());
		listObj.add(TxtBxSearch.isDisplayed());
		listObj.add(BtnSearch.isDisplayed());
		listObj.add(DropDownArrow.isDisplayed());
		listObj.add(SelectSortThreads.isDisplayed());
		listObj.add(BtnPostAThread.isDisplayed());
		return listObj;
		
	}
	

	
	public String TxtBxSearch()
	{
		testUtil.waitForElement(TxtBxSearch);
		return TxtBxSearch.getAttribute("placeholder");
	}
	
	public String H1BeefProd()
	{
		//testUtil.waitForElement(H1BeefProd);
		return H1BeefProd.getText().trim();
	}
	
	public String BreadCrumbs()
	{
		//testUtil.waitForElement(BreadCrumbs);
		return BreadCrumbs.getText().trim();
	}
	public String ColThreadTitleStarter()
	{
		return ColThreadTitleStarter.getText().trim();
	}
	
	public String ColAuthor()
	{
		return ColAuthor.getText().trim();
	}
	
	
	public String ColRepliesView()
	{
		return ColRepliesView.getText().trim();
	}
	

	public String ColLastPostBy()
	{
		return ColLastPostBy.getText().trim();
	}
	
	public void BtmDispOptionsThread()
	{
		BtmDispOptionsThread.click();
	}
	
	public ArrayList<String> SelectSortThreads()
	{
		ArrayList<String> listObj=new ArrayList<String>();
		Select SelectDD=new Select(SelectSortThreads);
		
		List<WebElement> dropDownValue = SelectDD.getOptions();
		
		for(int i=0;i<dropDownValue.size();i++)
		{
			listObj.add(dropDownValue.get(i).getText());
		}
		return listObj;

	}
	
	public boolean isEmptyPagingTop()
	{
		return PagingTop.isEmpty();
	}
	
	public boolean isEmptyPagingBottom()
	{
				
		return PagingBottom.isEmpty();
	}
	
//	public String clickOnSecondPage()
//	{
//		String FontWeight = null;
//	
//			for(int i=0;i<1;i++)
//			{
//				Paging.get(i+1).click();
//				FontWeight = Paging.get(i+1).getCssValue("font-weight");
//			}
//			return FontWeight;
//		
//	}
//	
//	public String clickPreviosPage()
//	{
//		String FontWeight = null;
//		for(int i=1;i>0;i--)
//		{
//			Paging.get(i-1).click();
//			FontWeight = Paging.get(i-1).getCssValue("font-weight");
//		}
//		return FontWeight;
//	}
//	
	public String clickBtnNextTop()
	{
		
		String FontWeight = null;
		
			for(int i=3;i<4;i++)
			{
				PagingTop.get(i).click();
			FontWeight = PagingTop.get(i).getCssValue("font-weight");
			}
	
		return FontWeight;
	}
	
	public String clickBtnNextBottom()
	{
		
		String FontWeight = null;
		
			for(int i=3;i<4;i++)
			{
				JavascriptExecutor jsclick =(JavascriptExecutor) driver;
				jsclick.executeScript("arguments[0].click();", PagingBottom.get(i));
				//PagingBottom.get(i).click();
				FontWeight = PagingBottom.get(i).getCssValue("font-weight");
			}
	
		return FontWeight;
	}
	
	
	
	
	public String clickLastBtnTop()
	{
		
		String FontWeight = null;
		
			for(int i=4;i<=4;i++)
			{
			PagingTop.get(i).click();
			FontWeight = PagingTop.get(i).getCssValue("font-weight");
			}
	
		return FontWeight;
	}
	
	
	public String clickLastBtnBottom()
	{
		
		String FontWeight = null;
		
			for(int i=4;i<=4;i++)
			{
			PagingBottom.get(i).click();
			FontWeight = PagingBottomLastPage.get(i).getCssValue("font-weight");
			}
			
			
		return FontWeight;
	}
			
			public String SecondPageTop()
			{
				SecondPageTop.click();
				return SecondPageTop.getCssValue("font-weight");
			}
			
			public String SecondPageBottom()
			{
				
				//SecondPageBottom.click();
				testUtil.Scroll_DownFull_Page();
				JavascriptExecutor jsclick =(JavascriptExecutor) driver;
				jsclick.executeScript("arguments[0].click();", SecondPageBottom);
				
				
				return SecondPageBottom.getCssValue("font-weight");
				
			}
			

			public String FirstPageTop()
			{
				FirstPageTop.click();
				return FirstPageTop.getCssValue("font-weight");
			}
			
			
			
			public String FirstPageBottom()
			{
				//FirstPageBottom.click();
				testUtil.Scroll_DownFull_Page();
				JavascriptExecutor jsclick =(JavascriptExecutor) driver;
				jsclick.executeScript("arguments[0].click();", FirstPageBottom);
				return FirstPageBottom.getCssValue("font-weight");
			}
			
			public String clickFirstBtnTop()
			{
				String FontWeight = null;
				
				JavascriptExecutor jsclick =(JavascriptExecutor) driver;
				jsclick.executeScript("arguments[0].click();", FirstBtnTop);
				//
				FontWeight = BtnFontWeight.getCssValue("font-weight");
				
			
				return FontWeight;
			}	
			public void clickBCrumbsForum()
			{
				BCrumbsForum.click();
			}
			public String clickPagingBottomLastPage()
			{
				
				String FontWeight = null;
				
				for(int i=0;i<1;i++)
				{
					JavascriptExecutor jsclick =(JavascriptExecutor) driver;
					jsclick.executeScript("arguments[0].click();", PagingBottomLastPage.get(i));
					//PagingBottomLastPage.get(i).click();
					FontWeight = PagingBottom.get(i).getCssValue("font-weight");
				}
			
			
				return FontWeight;
			}	
			
			
			
			
			public String clickBtnPreviousTop()
			{
				
				String FontWeight = null;
				
					for(int i=2;i<3;i++)
					{
						PagingTop.get(i).click();
					FontWeight = PagingTop.get(i).getCssValue("font-weight");
					}
			
				return FontWeight;
			}
			
			
			public String clickBtnPreviousBottom()
			{
				
				String FontWeight = null;
				
					for(int i=2;i<3;i++)
					{
						JavascriptExecutor jsclick =(JavascriptExecutor) driver;
						jsclick.executeScript("arguments[0].click();", PagingBottom.get(i));
						//PagingBottom.get(i).click();
					FontWeight = PagingBottom.get(i).getCssValue("font-weight");
					}
			
				return FontWeight;
			}
			
			public void clickDropDownArrow()
			{
				DropDownArrow.click();
			}
			
			
			public void clickBtnPostAThread()
			{
				BtnPostAThread.click();
				
			}
			@SuppressWarnings("rawtypes")
			public HashMap<Integer,ArrayList> getTextOnDiscCategory()
			{
				
				ArrayList<String> h1OnCurrentPage=new ArrayList<String>();
				ArrayList<String> h1OnSubPage=new ArrayList<String>();
				ArrayList<String> titleOnSubPage=new ArrayList<String>();
				ArrayList<String> breadCrumbsOnSubPage=new ArrayList<String>();
				HashMap<Integer, ArrayList> listMap = new HashMap<Integer, ArrayList>();
				for(int i=0;i<AllDiscCategories.size();i++)
				{
					DropDownArrow.click();
					String Str1=AllDiscCategories.get(i).getText();
					h1OnCurrentPage.add(Str1);
					
					JavascriptExecutor jsclick =(JavascriptExecutor) driver;
					jsclick.executeScript("arguments[0].click();", AllDiscCategories.get(i));
					
					
					String Str2=DiscussionCategoriesH1.getText();
					h1OnSubPage.add(Str2);
					
					
					String Str3=driver.getTitle();
					titleOnSubPage.add(Str3);
					
					String Str4=breadCrumbDiscCategoriesH1.getText();
					breadCrumbsOnSubPage.add(Str4);
					
					listMap.put(0, h1OnCurrentPage);
					listMap.put(1,h1OnSubPage);
					listMap.put(2,titleOnSubPage);
					listMap.put(3,breadCrumbsOnSubPage);
					driver.navigate().back();
					
					
				}
				return listMap;
			}
			
			
			public String MsgLoginPage()
			{
				return MsgLoginPage.getText().trim();
			}
			public String MsgH1Login()
			{
				return MsgH1Login.getText().trim();
			}
			
			
			public String MsgAccountNotActivated()
			{
				return MsgAccountNotActivated.getText().trim();
			}
			
			public String H1PostNewThread()
			{
				return H1PostNewThread.getText().trim();
			}

	
			
			public ArrayList<Date> AuthorDateTime() throws ParseException
			{
				ArrayList<Date> listObj=new ArrayList<Date>();
				for(int i=0;i<AuthorDateTime.size();i++)
				{
					String Str1=AuthorDateTime.get(i).getText();
					int j=Str1.indexOf('\n');
					String DateTime=Str1.substring(j+2);
					
					
					SimpleDateFormat  formatter1=new SimpleDateFormat("MMM dd, yyyy HH:mm");
					//SimpleDateFormat  formatter1=new SimpleDateFormat("MM DD YYYY");
					Date d1=formatter1.parse(DateTime);
					listObj.add(d1);
				
					
						
					
				}
			return listObj;
				
				
			}
			
			public ArrayList<Date> LastPostBy() throws ParseException
			{
				ArrayList<Date> listObj=new ArrayList<Date>();
				for(int i=0;i<LastPostBy.size();i++)
				{
					String Str1=LastPostBy.get(i).getText();
					int j=Str1.indexOf('\n');
					String DateTime=Str1.substring(j+1);
					
					
					SimpleDateFormat  formatter1=new SimpleDateFormat("MMM dd, yyyy HH:mm");
					Date d1=formatter1.parse(DateTime);
					listObj.add(d1);
				}
			return listObj;
		}
			
			
			public ArrayList<Integer> MostRecentReplies() throws ParseException
			{
				ArrayList<Integer> listObj=new ArrayList<Integer>();
				for(int i=0;i<Replies.size();i++)
				{
					String Str1=Replies.get(i).getText();
					int j=Str1.indexOf(' ');
					String num=Str1.substring(0,j);
					int result=Integer.parseInt(num);
					listObj.add(result);
			
				}
				
			return listObj;
			
		}
			
			
			public ArrayList<Integer> MostRecentViews() throws ParseException
			{
				ArrayList<Integer> listObj=new ArrayList<Integer>();
				for(int i=0;i<Views.size();i++)
				{
					NumberFormat format = NumberFormat.getInstance(Locale.US);
					String Str1=Views.get(i).getText();
					int j=Str1.indexOf(' ');
					String num=Str1.substring(0,j);
					Number num1= format.parse(num);
					int result=num1.intValue();
					listObj.add(result);
				
				}
				
			return listObj;
			
		}
			
			public void SelectMostRecentPost()
			{
				Select SelectRecentPost=new Select(SelectSortThreads);
				SelectRecentPost.selectByVisibleText("Most Recent Post");
			}
			
			
			public void SelectMostRecentThread()
			{
				Select SelectRecentPost=new Select(SelectSortThreads);
				SelectRecentPost.selectByVisibleText("Most Recent Thread");
			}
			
			
			public void SelectMostRecentReplies()
			{
				Select SelectRecentPost=new Select(SelectSortThreads);
				SelectRecentPost.selectByVisibleText("Number of Replies");
			}
			
			public void SelectMostRecentViews()
			{
				Select SelectRecentPost=new Select(SelectSortThreads);
				SelectRecentPost.selectByVisibleText("Number of Views");
			}
			
			public String H2FirstSubCategory()
			{
				return H2FirstSubCategory.getText().trim();
			}
			
			
			public void clickH2FirstSubCategory()
			{
				H2FirstSubCategory.click();
			}
			
			public void clicklinkToSubPage()
			{
				linkToSubPage.click();
			}
			public String h1OnThreadPage()
			{
				return h1OnThreadPage.getText().trim();
			}
			
			public void clickFirstAuthor()
			{
				FirstAuthor.click();
			}
			
			public String FirstAuthor()
			{
				return FirstAuthor.getText().trim();
			}
			
			public String NameOfMember()
			{
				return NameOfMember.getText().trim();
			}
			
			public void clickFirstLastPostBy()
			{
				FirstLastPostBy.click();
			}
			
			public String FirstLastPostBy()
			{
				return FirstLastPostBy.getText().trim();
			}
}
	
	

