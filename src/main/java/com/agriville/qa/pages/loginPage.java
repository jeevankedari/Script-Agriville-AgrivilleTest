package com.agriville.qa.pages;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.agriville.qa.base.TestBase;

public class loginPage extends TestBase
{
	
	public loginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	//Page Factory or Object Repository
	@FindBy(xpath="//div[@class='logo']/a")
	WebElement AgrivilleLogo;
	
	
	@FindBy(xpath="//span[@class='login-links']/a[contains(text(),'Login')]")
	WebElement LoginLink;
	
	@FindBy(xpath="//span[@class='login-links']/a[contains(text(),'Register')]")
	WebElement RegisterLink;
	
	@FindBy(xpath="//input[@id='navbar_username']")
	WebElement UserName;
	
	@FindBy(xpath="//input[@id='navbar_password']")
	WebElement Password;
	
	@FindBy(xpath="//input[@id='cb_cookieuser_navbar']")
	WebElement RememberMeChKBx;
	
	@FindBy(xpath="//td[@class='forgot_text']")
	WebElement ForgotPwdLink;

	
	@FindBy(xpath="//td/input[@value='Log in']")
	WebElement LoginBtnOnLoginScreen;
	
	@FindBy(xpath="//tr/td[contains(text(),'Don’t have an Agriville account?')]")
	WebElement DoNotHaveAgrivilleAcc;
	
	@FindBy(xpath="//td[@class='bolded']/a[contains(text(),'Register Now')]")
	WebElement RegisterNowLink;
	
	@FindBy(xpath="//h1[contains(text(),'Register')]")
	WebElement RegisterNowH1;
	
	@FindBy(xpath="//td/label")
	WebElement RemeberMeLbl;
	
	@FindBy(xpath="//h1[@class='blockhead']")
	WebElement MsgLoginNewPage;

	@FindBy(xpath="//h1[@class='blocksubhead']")
	WebElement H1LoginNewPage;
	
	@FindBy(xpath="//span[@id='login_toggle1']")
	WebElement MsgWelcome;
	
	@FindBy(xpath="//span[@id='login_toggle1']//a/img")
	WebElement ArrowBtn;
	
	@FindBy(xpath="//li/a[contains(text(),'Log Out')]")
	WebElement LogOutBtn;
	
	@FindBy(xpath="//b[contains(text(),'Register')]")
	WebElement RegisterLinkOnLP;
	
	@FindBy(xpath="//b[contains(text(),'Forgot you password?')]")
	WebElement ForgotPwdLP;
	
	@FindBy(xpath="//input[@id='cb_cookieuser']")
	WebElement RememberMeLP;
	
	@FindBy(xpath="//div[@class='group']/input[@type='submit']")
	WebElement LoginBtnLP;
	
	@FindBy(xpath="//div[@class='group']/input[@type='reset']")
	WebElement ResetBtnLP;
	
	@FindBy(xpath="//div[@class='blockrow restore']")
	WebElement MsgForInvalidDetails;
	
	@FindBy(xpath="//input[@id='vb_login_username']")
	WebElement EmailLP;
	
	@FindBy(xpath="//input[@id='vb_login_password']")
	WebElement PasswordLP;
	
	@FindBy(xpath="//div[@class='blockrow restore']")
	WebElement MsgForCookies;
	
	@FindBy(xpath="//div[@class='row 5']/span/a")
	WebElement FirstDiscCategory;
	
	@FindBy(xpath="//input[@id='button']")
	WebElement PostThread;
	
	
	
	@FindBy(xpath="//th[contains(text(),'Post a New Thread')]")
	WebElement TitlePostANewThread;
	
	
	@FindBy(xpath="//div[@id='shell-inner']/div[3]/div[1]/div[1]/div[1]/div[2]/span[1]/a")
	WebElement FirstMostRecentThread;
	
	@FindBy(xpath="//div[@class='body-left-col']//input[@id='button']")
	WebElement PostMessage;
	
	@FindBy(xpath="//th[contains(text(),'Post a New Reply')]")
	WebElement TitlePostReply;
	
	
	
	@FindBy(xpath="//table[@class='message-table']//table[1]//img[contains(@id, 'quoteimg')]")
	WebElement ReplyBtn;
	
	@FindBy(xpath="//th[contains(text(),'Post a New Reply')]")
	WebElement TitlePostReplyfrmBtn;
	
	
	
	
	
	
	
	
	//Actions
	
	public ArrayList<Boolean> LoginAndRegisterLinkisDisplayed()
	{
		ArrayList<Boolean> listObj=new ArrayList<Boolean>();
		listObj.add(LoginLink.isDisplayed());
		listObj.add(RegisterLink.isDisplayed());
		return listObj;
	}
	
	public void clickLogin()
	{
		LoginLink.click();
	}
	
	
	
	public void clickAgrivilleLogo()
	{
		AgrivilleLogo.click();
	}
	
	public void UserName(String username)
	{
		UserName.sendKeys(username);
	}
	
	public void Password(String password)
	{
		Password.sendKeys(password);
	}
	
	public void clickLoginBtnOnLoginFrame()
	{
		LoginBtnOnLoginScreen.click();
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
	
	public String MsgLoginNewPage()
	{
		return MsgLoginNewPage.getText().trim();
	}
	
	public String H1LoginNewPage()
	{
		return H1LoginNewPage.getText().trim();
	}
	
	public String MsgWelcome()
	{
		return MsgWelcome.getText().substring(0,7);
	}
	
	public void clickArrowBtn()
	{
		ArrowBtn.click();
	}
	
	public void clickLogOutBtn()
	{
		
		JavascriptExecutor jsclick =(JavascriptExecutor) driver;
		jsclick.executeScript("arguments[0].click();", LogOutBtn);
	}
	
	public String MsgForInvalidDetails()
	{
		return MsgForInvalidDetails.getText().substring(0, 67);
	}
	
	public ArrayList<Boolean> verifyFullLoginPage()
	{
		ArrayList<Boolean> listObj=new ArrayList<>();
		listObj.add(RegisterLinkOnLP.isDisplayed());
		listObj.add(RegisterLinkOnLP.isEnabled());
		
		listObj.add(ForgotPwdLP.isDisplayed());
		listObj.add(ForgotPwdLP.isEnabled());
		
		listObj.add(EmailLP.isDisplayed());
		listObj.add(EmailLP.isEnabled());
		
		listObj.add(PasswordLP.isDisplayed());
		listObj.add(PasswordLP.isEnabled());
		
		listObj.add(RememberMeLP.isDisplayed());
		listObj.add(RememberMeLP.isSelected());
		
		listObj.add(LoginBtnLP.isDisplayed());
		listObj.add(LoginBtnLP.isEnabled());
		
		return listObj;
				
	}
	
	public void EmailLP(String username)
	{
		EmailLP.sendKeys(username);
	}
	
	public void PasswordLP(String password)
	{
		PasswordLP.sendKeys(password);
	}
	
	public void clickLoginBtnLP()
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", LoginBtnLP);
		
		
	}
	
	public String MsgForCookies()
	{
		return MsgForCookies.getText().substring(0, 20);
	}
	
	public void clickFirstDiscCategory()
	{
		FirstDiscCategory.click();
	}
	
	
	public void clickPostThread()
	{
		PostThread.click();
	}
	

	
	public String TitlePostANewThread()
	{
		return TitlePostANewThread.getText().trim();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void clickFirstMostRecentThread()
	{
		FirstMostRecentThread.click();
	}
	
	
	public void clickPostMessage()
	{
		PostMessage.click();
	}

	
	public String TitlePostReply()
	{
		return TitlePostReply.getText().trim();
	}
	
	public void clickReplyBtn()
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", ReplyBtn);
		
		
	}
	
	public String TitlePostReplyfrmBtn()
	{
		return TitlePostReplyfrmBtn.getText().trim();
	}
	
	
	
}
