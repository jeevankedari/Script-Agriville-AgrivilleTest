package com.agriville.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.agriville.qa.base.TestBase;
import com.agriville.qa.util.testUtil;

public class LatestPost extends TestBase 
{
	public LatestPost()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//a[contains(text(),'Send Private Message')]")
	WebElement SendPrivateMsg;
	
	@FindBy(xpath="//a[contains(text(),'Find latest posts')]")
	WebElement FindLatestPost;
	
	@FindBy(xpath="//a[contains(text(),'Find latest started threads')]")
	WebElement FindLatestStartedThread;
	
	@FindBy(xpath="//a[@id='activitystream-tab']")
	WebElement myActivity;
	
	@FindBy(xpath="//a[@id='visitor_messaging-tab']")
	WebElement visitorMsgs;
	
	@FindBy(xpath="//a[@id='aboutme-tab']")
	WebElement aboutMe;

	@FindBy(xpath="//dd[@id='asuser']")
	WebElement User;
	
	@FindBy(xpath="//dd[@id='asfriend']")
	WebElement Friends;
	
	@FindBy(xpath="//a[contains(text(),'Subscriptions')]")
	WebElement Subscriptions;
	
	@FindBy(xpath="//div[@class='blockrow restore']")
	WebElement MsgNoPost;
	
	
	public String SendPrivateMsg()
	{
		return SendPrivateMsg.getText().trim();
	}
	
	public String FindLatestPost()
	{
		return FindLatestPost.getText().trim();
	}
	
	public String FindLatestStartedThread()
	{
		return FindLatestStartedThread.getText().trim();
	}
	
	public String myActivity()
	{
		return myActivity.getText().trim();
	}
	
	public String visitorMsgs()
	{
		return visitorMsgs.getText().trim();
	}
	
	public String aboutMe()
	{
		return aboutMe.getText().trim();
	}
	
	public String User()
	{
		return User.getText().trim();
	}
	
	public String Friends()
	{
		return Friends.getText().trim();
	}
	
	public String Subscriptions()
	{
		return Subscriptions.getText().trim();
	}
	
	public void clickFindLatestPost()
	{
		testUtil.ElementIsClickable(FindLatestPost);
		FindLatestPost.click();
	}
	
	public String MsgNoPost()
	{
		return MsgNoPost.getText().trim();
	}
}
