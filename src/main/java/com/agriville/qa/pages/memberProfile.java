package com.agriville.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.agriville.qa.base.TestBase;
import com.agriville.qa.util.testUtil;

public class memberProfile extends TestBase 
{

	public memberProfile()
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//dl[@class='tabslight']/dt")
	WebElement tabContent;
	
	@FindBy(xpath="//a[@id='activitystream-tab']")
	WebElement myActivity;
	
	@FindBy(xpath="//a[@id='visitor_messaging-tab']")
	WebElement visitorMsg;
	
	@FindBy(xpath="//a[@id='aboutme-tab']")
	WebElement aboutMe;
	
	@FindBy(xpath="//dd[@id='asuser']//a")
	WebElement userNameOnDashBoard;
	
	@FindBy(xpath="//dd[@id='asfriend']//a")
	WebElement friendsDashBoard;
	
	@FindBy(xpath="//dd[@id='assub']//a")
	WebElement subscriptionsDashBoard;
	
	@FindBy(xpath="//span[@class='member_username']")
	WebElement memberUserName;
	
	@FindBy(xpath="//a[contains(text(),'Send Private Message')]")
	WebElement sendPrivateMsg;
	
	@FindBy(xpath="//a[contains(text(),'Find latest posts')]")
	WebElement findLatestPost;
	
	@FindBy(xpath="//a[contains(text(),'Find latest started threads')]")
	WebElement findLatestStartedThread;
	
	@FindBy(xpath="//div[@id='shell-inner']/div[@class='main-body-col']/div[@class='main-body-inner']/div[@class='content-col']/div[@class='post-col']/div[2]/a")
	WebElement ByUNOnMostRecentThread;
	
	@FindBy(xpath="//div[@id='shell-inner']/div[@class='main-body-col']/div[@class='main-body-inner']/div[@class='content-col']/div[@class='topic-col']/div[1]/a")
	WebElement ByUNonMostPopTopics;
	
	@FindBy(xpath="//a[contains(text(),'Add as Friend')]")
	WebElement addAsFriend;
	
	@FindBy(xpath="//a[contains(text(),'Add to Ignore List')]")
	WebElement addToIgnore;
	
	@FindBy(xpath="//li[contains(text(),'You need to login to post m')]")
	WebElement MsgLogin;
	
	@FindBy(xpath="//div[@class='body-left-col']//th[contains(text(),'Author')]//parent::tr//following-sibling::tr[1]//td[3]")
	WebElement firstAuthor;
	
	@FindBy(xpath="//div[@class='body-left-col']//th[contains(text(),'Author')]//parent::tr//following-sibling::tr[1]//td[5]")
	WebElement firstUserName;
	
	@FindBy(xpath="//div[@class='body-left-col']//th[contains(text(), 'Title / Thread Starter')]//parent::tr//following-sibling::tr[1]//span[@class='label']/a")
	WebElement firstUserNameSearchResult;
	
	@FindBy(xpath="//td[1]/table[1]//a[@class='username offline']//strong")
	WebElement firstAuthorOnThreadDetails;
	

	
	
	
	//Actions
	public String tabContent()
	{
		return tabContent.getText().trim();
	}
	
	public String myActivity()
	{
		return myActivity.getText().trim();
	}
	
	public String visitorMsg()
	{
		return visitorMsg.getText().trim();
	}
	
	public String aboutMe()
	{
		return aboutMe.getText().trim();
	}
	
	public String userNameOnDashBoard()
	{
		return userNameOnDashBoard.getText().trim();
	}
	
	public String friendsDashBoard()
	{
		return friendsDashBoard.getText().trim();
	}
	
	public String subscriptionsDashBoard()
	{
		return subscriptionsDashBoard.getText().trim();
	}
	
	
	
	public String memberUserName()
	{
		return memberUserName.getText().trim();
	}
	
	
	public String sendPrivateMsg()
	{
		return sendPrivateMsg.getText().trim();
	}
	
	public void clicksendPrivateMsg()
	{
		testUtil.ElementIsClickable(sendPrivateMsg);
		sendPrivateMsg.click();
	}
	public String findLatestPost()
	{
		return findLatestPost.getText().trim();
	}
	
	public String findLatestStartedThread()
	{
		return findLatestStartedThread.getText().trim();
	}
	
	public void clickByUNOnMostRecentThread()
	{
		testUtil.ElementIsClickable(ByUNOnMostRecentThread);
		ByUNOnMostRecentThread.click();
	}
	
	public void clickByByUNonMostPopTopics()
	{
		testUtil.ElementIsClickable(ByUNonMostPopTopics);
		ByUNonMostPopTopics.click();
	}
	
	public String ByUNOnMostRecentThread()
	{
		return ByUNOnMostRecentThread.getText().trim();
	}
	
	public String ByUNonMostPopTopics()
	{
		return ByUNonMostPopTopics.getText().trim();
	}
	
	public String addAsFriend()
	{
		return addAsFriend.getText().trim();
	}
	
	public String addToIgnore()
	{
		return addToIgnore.getText().trim();
	}
	
	public String MsgLogin()
	{
		return MsgLogin.getText().substring(0,106);
	}
	
	public void clickfirstAuthor()
	{
		testUtil.ElementIsClickable(firstAuthor);
		firstAuthor.click();
	}
	
	public String firstAuthor()
	{
		return firstAuthor.getText().trim();
	}
	
	
	public void clickfirstUserName()
	{
		testUtil.ElementIsClickable(firstUserName);
		firstUserName.click();
	}
	
	public String firstUserName()
	{
		return firstUserName.getText().trim();
	}
	
	public void clickfirstUserNameSearchResult()
	{
		testUtil.ElementIsClickable(firstUserNameSearchResult);
		firstUserNameSearchResult.click();
	}
	
	public String firstUserNameSearchResult()
	{
		return firstUserNameSearchResult.getText().trim();
	}
	
	public void clickfirstAuthorOnThreadDetails()
	{
		testUtil.ElementIsClickable(firstAuthorOnThreadDetails);
		firstAuthorOnThreadDetails.click();
	}
	
	public String firstAuthorOnThreadDetails()
	{
		return firstAuthorOnThreadDetails.getText().trim();
	}
	
	
}
