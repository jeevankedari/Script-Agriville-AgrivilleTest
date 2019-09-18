package com.agriville.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.agriville.qa.base.TestBase;
import com.agriville.qa.pages.loginPage;
import com.agriville.qa.util.ExcelDataUtil;
import com.agriville.qa.util.testUtil;

public class loginPageTest extends TestBase
{
	loginPage loginPageObj;
	testUtil testUtilObj;
	ExcelDataUtil ExcelDataUtilObj;
	String Path="E://Script Agriville//AgrivilleTest//src//main//java//com//agriville//qa//testdata//Agriville.xlsx";
	String sheetName="Login";
	
	
	
	
	public loginPageTest()
	{
		super();
	}
	
	@BeforeClass
	public void SetUp()
	{
		intialization();
		loginPageObj = new loginPage();
		testUtilObj=new testUtil();
		ExcelDataUtilObj=new ExcelDataUtil(Path);
		
		
		
	}

	
	@Test(priority=1)
	public void verifyLoginAndRegisterLinkisDisplayed() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		Thread.sleep(4000);
		for(int i=0;i<loginPageObj.LoginAndRegisterLinkisDisplayed().size();i++)
		{
			boolean flag=loginPageObj.LoginAndRegisterLinkisDisplayed().get(i);
			S1.assertTrue(flag,"The Assertion Failed in Loop");
			
		}
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Login and Register Link is Displayed");
	}

	
	@Test(priority=2)
	public void verifyLoginForm() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		loginPageObj.clickLogin();
		Thread.sleep(4000);
		for(int i=0;i<loginPageObj.UserNameAndPassword().size();i++)
		{
			boolean flag=loginPageObj.UserNameAndPassword().get(i);
			S1.assertTrue(flag,"SoftAssert Failed on Loop");
			
		}
		
		
		String Str1=loginPageObj.RemeberMeLbl();
		S1.assertEquals(Str1, "Remember Me?","First SoftAssert Failed");
		
		String Str2=loginPageObj.ForgotPwdText();
		S1.assertEquals(Str2, "Forgot your password?","Second SoftAssert Failed");
		
		String Str3=loginPageObj.DoNotHaveAgrivilleAcc();
		S1.assertEquals(Str3, "Don’t have an Agriville account?","Third SoftAssert Failed");
		
		String Str4=loginPageObj.RegisterNowLink();
		S1.assertEquals(Str4, "Register Now","Fourth SoftAssert Failed");
		
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Verified Login Form in DropDown");
		
	}

	
	
	@Test(priority=3)
	public void verifyLoginWithNoUserNameAndPasswordHP() throws InterruptedException, IOException
	{
		
			SoftAssert S1=new SoftAssert();
			loginPageObj.clickLogin();
			Thread.sleep(4000);
		
			loginPageObj.UserName(ExcelDataUtilObj.getData(sheetName, 1, 0));
			loginPageObj.Password(ExcelDataUtilObj.getData(sheetName, 1, 1));
			loginPageObj.clickLoginBtnOnLoginFrame();	
			String Str1=loginPageObj.MsgLoginNewPage();
			S1.assertEquals(Str1, "Message","First SoftAssert Failed");
			
			String Str2=loginPageObj.H1LoginNewPage();
			S1.assertEquals(Str2, "Log in","Seconde SoftAssert Failed");
			
			
			String Str3=loginPageObj.MsgForInvalidDetails();
			S1.assertEquals(Str3, "You have entered an invalid username or password. Please try again.","Third SoftAssert Failed");
			loginPageObj.clickAgrivilleLogo();
			S1.assertAll();
			System.out.println("Login on Home Page: User is not able to Login without Username and Password");
	}
	
	
	@Test(priority=4)
	public void verifyLoginWithNoUserNameHP() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		loginPageObj.clickLogin();
		Thread.sleep(4000);
		loginPageObj.UserName(ExcelDataUtilObj.getData(sheetName, 2, 0));
		loginPageObj.Password(ExcelDataUtilObj.getData(sheetName, 2, 1));
		loginPageObj.clickLoginBtnOnLoginFrame();	
		String Str1=loginPageObj.MsgLoginNewPage();
		S1.assertEquals(Str1, "Message","First SoftAssert Failed");
		
		String Str2=loginPageObj.H1LoginNewPage();
		S1.assertEquals(Str2, "Log in","Second SoftAssert Failed");
		
		String Str3=loginPageObj.MsgForInvalidDetails();
		S1.assertEquals(Str3, "You have entered an invalid username or password. Please try again.","Third SoftAssert Failed");
		
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Login on Home Page: User is not able to Login without Username");
		
		
	}
	
	@Test(priority=5)
	public void verifyLoginWithNoPasswordHP() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		loginPageObj.clickLogin();
		Thread.sleep(4000);
		loginPageObj.UserName(ExcelDataUtilObj.getData(sheetName, 3, 0));
		loginPageObj.Password(ExcelDataUtilObj.getData(sheetName, 3, 1));
		loginPageObj.clickLoginBtnOnLoginFrame();	
		String Str1=loginPageObj.MsgLoginNewPage();
		S1.assertEquals(Str1, "Message","First SoftAssert Failed");
		
		String Str2=loginPageObj.H1LoginNewPage();
		S1.assertEquals(Str2, "Log in","Second SoftAssert Failed");
		
		String Str3=loginPageObj.MsgForInvalidDetails();
		S1.assertEquals(Str3, "You have entered an invalid username or password. Please enter the ","Third  SoftAssert Failed");
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Login on Home Page: User is not able to Login without Password");
		
	}

	
	@Test(priority=6)
	public void LoginToApplication1() throws InterruptedException
	{
		
		loginPageObj.clickLogin();
		Thread.sleep(4000);
		loginPageObj.UserName(ExcelDataUtilObj.getData(sheetName, 5, 0));
		loginPageObj.Password(ExcelDataUtilObj.getData(sheetName, 5, 1));
		loginPageObj.clickLoginBtnOnLoginFrame();
		loginPageObj.clickArrowBtn();
		loginPageObj.clickLogOutBtn();
		testUtil.Switch_To_Alert_Accept();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("User is Logged and Logged out in Successful");
	}
	
	@Test(priority=7)
	public void verifyLoginInvalidUserNameHP() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		loginPageObj.clickLogin();
		Thread.sleep(4000);
		loginPageObj.UserName(ExcelDataUtilObj.getData(sheetName, 4, 0));
		loginPageObj.Password(ExcelDataUtilObj.getData(sheetName, 4, 1));
		loginPageObj.clickLoginBtnOnLoginFrame();	
		String Str1=loginPageObj.MsgLoginNewPage();
		S1.assertEquals(Str1, "Message","First SoftAssert Failed");
		
		String Str2=loginPageObj.H1LoginNewPage();
		S1.assertEquals(Str2, "Log in","Second SoftAssert Failed");
		
		String Str3=loginPageObj.MsgForInvalidDetails();
		S1.assertEquals(Str3, "You have entered an invalid username or password. Please enter the ","Third SoftAssert Failed");
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Login on Home Page: User is not able to Login with Invalid UserName");
		
	}
	
	@Test(priority=8)
	public void verifyLoginValidUserNameAndPwdHP() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		loginPageObj.clickLogin();
		Thread.sleep(4000);
		loginPageObj.UserName(ExcelDataUtilObj.getData(sheetName, 5, 0));
		loginPageObj.Password(ExcelDataUtilObj.getData(sheetName, 5, 1));
		loginPageObj.clickLoginBtnOnLoginFrame();	
		String Str1=loginPageObj.MsgWelcome();
		S1.assertEquals(Str1, "WELCOME","First SoftAssert Failed");
		
		Thread.sleep(4000);
		loginPageObj.clickArrowBtn();
		Thread.sleep(4000);
		loginPageObj.clickLogOutBtn();
		Thread.sleep(4000);
		testUtil.Switch_To_Alert_Dismiss();
		String Str2=loginPageObj.MsgWelcome();
		S1.assertEquals(Str2, "WELCOME","Second SoftAssert Failed");
		loginPageObj.clickAgrivilleLogo();
		
		Thread.sleep(4000);
		loginPageObj.clickArrowBtn();
		Thread.sleep(4000);
		loginPageObj.clickLogOutBtn();
		Thread.sleep(4000);
		testUtil.Switch_To_Alert_Accept();
		
		String Str3=loginPageObj.MsgLoginNewPage();
		S1.assertEquals(Str3, "Message","Third SoftAssert Failed");
		
		String Str4=loginPageObj.H1LoginNewPage();
		S1.assertEquals(Str4, "Log in","Fourth SoftAssert Failed");
		
		String Str5=loginPageObj.MsgForCookies();
		S1.assertEquals(Str5, "All cookies cleared!","Fifth SoftAssert Failed");
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Login on Home Page: User is able to Login with Valid UserName and Password");
		
	}
	
	
	@Test(priority=9)
	public void verifyLoginInvalidPasswordHP() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		loginPageObj.clickLogin();
		Thread.sleep(4000);
		loginPageObj.UserName(ExcelDataUtilObj.getData(sheetName, 6, 0));
		loginPageObj.Password(ExcelDataUtilObj.getData(sheetName, 6, 1));
		
		loginPageObj.clickLoginBtnOnLoginFrame();	
		String Str1=loginPageObj.MsgLoginNewPage();
		S1.assertEquals(Str1, "Message","First SoftAssert Failed");
		
		String Str2=loginPageObj.H1LoginNewPage();
		S1.assertEquals(Str2, "Log in","Second SoftAssert Failed");
		
		String Str3=loginPageObj.MsgForInvalidDetails();
		S1.assertEquals(Str3, "You have entered an invalid username or password. Please enter the ","Third SoftAssert Failed");
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Login on Home Page: User is not able to Login with Invalid Password");
		
	}
	
	@Test(priority=10)
	public void verifyLoginPageLP() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		loginPageObj.clickLogin();
		Thread.sleep(4000);
		loginPageObj.clickLoginBtnOnLoginFrame();
		String Str1=loginPageObj.MsgLoginNewPage();
		S1.assertEquals(Str1, "Message","First SoftAssert Failed");
		String Str2=loginPageObj.H1LoginNewPage();
		S1.assertEquals(Str2, "Log in","Second SoftAssert Failed");
		String Str3=loginPageObj.MsgForInvalidDetails();
		S1.assertEquals(Str3, "You have entered an invalid username or password. Please try again.","Third SoftAssert Failed");
		
		for(int i=0;i<loginPageObj.verifyFullLoginPage().size();i++)
		{
			boolean flag=loginPageObj.verifyFullLoginPage().get(i);
			S1.assertTrue(flag,"SoftAssert Failed on Loop");
			
		}
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Login Screen from Login Link: Verified the Login Page");
	}
	
	@Test(priority=11)
	public void verifyLoginWithNoUserNameAndPasswordLP() throws InterruptedException, IOException
	{
			SoftAssert S1=new SoftAssert();
			loginPageObj.clickLogin();
			Thread.sleep(4000);
			loginPageObj.clickLoginBtnOnLoginFrame();
		
			loginPageObj.EmailLP(ExcelDataUtilObj.getData(sheetName, 1, 0));
			loginPageObj.PasswordLP(ExcelDataUtilObj.getData(sheetName, 1, 1));
			testUtil.Scroll_DownFull_Page();
			loginPageObj.clickLoginBtnLP();	
			String Str1=loginPageObj.MsgLoginNewPage();
			S1.assertEquals(Str1, "Message","First SoftAssert Failed");
			String Str2=loginPageObj.H1LoginNewPage();
			S1.assertEquals(Str2, "Log in","Second SoftAssert Failed");
			String Str3=loginPageObj.MsgForInvalidDetails();
			S1.assertEquals(Str3, "You have entered an invalid username or password. Please try again.","Third SoftAssert Failed");
			loginPageObj.clickAgrivilleLogo();
		
			
			S1.assertAll();
			System.out.println("Login Screen from Login Link: User is not able to Login without Username and Password");
	}
	
	@Test(priority=12)
	public void LoginToApplication2() throws InterruptedException
	{
		
		loginPageObj.clickLogin();
		Thread.sleep(4000);
		loginPageObj.UserName(ExcelDataUtilObj.getData(sheetName, 5, 0));
		loginPageObj.Password(ExcelDataUtilObj.getData(sheetName, 5, 1));
		loginPageObj.clickLoginBtnOnLoginFrame();
		loginPageObj.clickArrowBtn();
		loginPageObj.clickLogOutBtn();
		testUtil.Switch_To_Alert_Accept();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("User is Logged and Logged out in Successful");
	}
	
	
	
	
	
	@Test(priority=13)
	public void verifyLoginWithNoUserNameLP() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		loginPageObj.clickLogin();
		Thread.sleep(4000);
		loginPageObj.clickLoginBtnOnLoginFrame();
	
		loginPageObj.EmailLP(ExcelDataUtilObj.getData(sheetName, 2, 0));
		loginPageObj.PasswordLP(ExcelDataUtilObj.getData(sheetName, 2, 1));
		testUtil.Scroll_DownFull_Page();
		loginPageObj.clickLoginBtnLP();	
		String Str1=loginPageObj.MsgLoginNewPage();
		S1.assertEquals(Str1, "Message","First SoftAssert Failed");
		String Str2=loginPageObj.H1LoginNewPage();
		S1.assertEquals(Str2, "Log in","Second SoftAssert Failed");
		String Str3=loginPageObj.MsgForInvalidDetails();
		S1.assertEquals(Str3, "You have entered an invalid username or password. Please try again.","Third SoftAssert Failed");
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Login Screen from Login Link: User is not able to Login without Username");
	}

	@Test(priority=14)
	public void verifyLoginWithNoPasswordLP() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		loginPageObj.clickLogin();
		Thread.sleep(4000);
		loginPageObj.clickLoginBtnOnLoginFrame();
	
		loginPageObj.EmailLP(ExcelDataUtilObj.getData(sheetName, 3, 0));
		loginPageObj.PasswordLP(ExcelDataUtilObj.getData(sheetName, 3, 1));
		testUtil.Scroll_DownFull_Page();
		loginPageObj.clickLoginBtnLP();	
		String Str1=loginPageObj.MsgLoginNewPage();
		S1.assertEquals(Str1, "Message","First SoftAssert Failed");
		String Str2=loginPageObj.H1LoginNewPage();
		S1.assertEquals(Str2, "Log in","Second SoftAssert Failed");
		String Str3=loginPageObj.MsgForInvalidDetails();
		S1.assertEquals(Str3, "You have entered an invalid username or password. Please enter the ","Third SoftAssert Failed");
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Login Screen from Login Link: User is not able to Login without Password");
	}

	@Test(priority=15)
	public void verifyLoginInvalidUserNameLP() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		loginPageObj.clickLogin();
		Thread.sleep(4000);
		loginPageObj.clickLoginBtnOnLoginFrame();
	
		loginPageObj.EmailLP(ExcelDataUtilObj.getData(sheetName, 7, 0));
		loginPageObj.PasswordLP(ExcelDataUtilObj.getData(sheetName, 7, 1));
		testUtil.Scroll_DownFull_Page();
		loginPageObj.clickLoginBtnLP();	
		String Str1=loginPageObj.MsgLoginNewPage();
		S1.assertEquals(Str1, "Message","First SoftAssert Failed");
		String Str2=loginPageObj.H1LoginNewPage();
		S1.assertEquals(Str2, "Log in","Second SoftAssert Failed");
		String Str3=loginPageObj.MsgForInvalidDetails();
		S1.assertEquals(Str3, "You have entered an invalid username or password. Please enter the ","Third SoftAssert Failed");
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Login Screen from Login Link: User is not able to Login with Invalid UserName");
	}

	
	@Test(priority=16)
	public void verifyLoginValidUserNameAndPwdLP() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		loginPageObj.clickLogin();
		Thread.sleep(4000);
		loginPageObj.clickLoginBtnOnLoginFrame();
		
		loginPageObj.EmailLP(ExcelDataUtilObj.getData(sheetName, 5, 0));
		loginPageObj.PasswordLP(ExcelDataUtilObj.getData(sheetName, 5, 1));
		testUtil.Scroll_DownFull_Page();
		loginPageObj.clickLoginBtnLP();		
		String Str1=loginPageObj.MsgWelcome();
		S1.assertEquals(Str1, "WELCOME","First SoftAssert Failed");
		
		Thread.sleep(4000);
		loginPageObj.clickArrowBtn();
		Thread.sleep(4000);
		loginPageObj.clickLogOutBtn();
		Thread.sleep(4000);
		testUtil.Switch_To_Alert_Dismiss();
		String Str2=loginPageObj.MsgWelcome();
		S1.assertEquals(Str2, "WELCOME","Second SoftAssert Failed");
		loginPageObj.clickAgrivilleLogo();
		
		Thread.sleep(4000);
		loginPageObj.clickArrowBtn();
		Thread.sleep(4000);
		loginPageObj.clickLogOutBtn();
		Thread.sleep(4000);
		testUtil.Switch_To_Alert_Accept();
		
		String Str3=loginPageObj.MsgLoginNewPage();
		S1.assertEquals(Str3, "Message","Third SoftAssert Failed");
		
		String Str4=loginPageObj.H1LoginNewPage();
		S1.assertEquals(Str4, "Log in","Fourth SoftAssert Failed");
		
		String Str5=loginPageObj.MsgForCookies();
		S1.assertEquals(Str5, "All cookies cleared!","Fifth SoftAssert Failed");
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Login Screen from Login Link: User is able to Login with Valid UserName and Password");
		
	}
	
	@Test(priority=17)
	public void verifyLoginInvalidPasswordLP() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		loginPageObj.clickLogin();
		Thread.sleep(4000);
		loginPageObj.clickLoginBtnOnLoginFrame();
		
		loginPageObj.EmailLP(ExcelDataUtilObj.getData(sheetName, 6, 0));
		loginPageObj.PasswordLP(ExcelDataUtilObj.getData(sheetName, 6, 1));
		testUtil.Scroll_DownFull_Page();
		loginPageObj.clickLoginBtnLP();	
		String Str1=loginPageObj.MsgLoginNewPage();
		S1.assertEquals(Str1, "Message","First SoftAssert Failed");
		
		String Str2=loginPageObj.H1LoginNewPage();
		S1.assertEquals(Str2, "Log in","Second SoftAssert Failed");
		
		String Str3=loginPageObj.MsgForInvalidDetails();
		S1.assertEquals(Str3, "You have entered an invalid username or password. Please enter the ","Third SoftAssert Failed");
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Login Screen from Login Link: User is not able to Login with Invalid Password");
		
	}
	
	@Test(priority=18)
	public void verifyLoginPageDCPostThread() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		loginPageObj.clickFirstDiscCategory();
		Thread.sleep(4000);
		loginPageObj.clickPostThread();
		String Str1=loginPageObj.MsgLoginNewPage();
		S1.assertEquals(Str1, "Message","First SoftAssert Failed");
		String Str2=loginPageObj.H1LoginNewPage();
		S1.assertEquals(Str2, "Log in","Second SoftAssert Failed");
		String Str3=loginPageObj.MsgForInvalidDetails();
		S1.assertEquals(Str3, "Welcome to Agriville! You need to login to post messages in the Agr","Third SoftAssert Failed");
		
		for(int i=0;i<loginPageObj.verifyFullLoginPage().size();i++)
		{
			boolean flag=loginPageObj.verifyFullLoginPage().get(i);
			S1.assertTrue(flag,"SoftAssert Failed on Loop");
			
		}
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Login Post A Thread: Verified the Login Page ");
	}
	
	@Test(priority=19)
	public void verifyLoginWithNoUserNameAndPasswordDCPostThread() throws InterruptedException, IOException
	{
		SoftAssert S1=new SoftAssert();
		loginPageObj.clickFirstDiscCategory();
		Thread.sleep(4000);
		loginPageObj.clickPostThread();
		
			loginPageObj.EmailLP(ExcelDataUtilObj.getData(sheetName, 1, 0));
			loginPageObj.PasswordLP(ExcelDataUtilObj.getData(sheetName, 1, 1));
			testUtil.Scroll_DownFull_Page();
			loginPageObj.clickLoginBtnLP();	
			String Str1=loginPageObj.MsgLoginNewPage();
			S1.assertEquals(Str1, "Message","First SoftAssert Failed");
			String Str2=loginPageObj.H1LoginNewPage();
			S1.assertEquals(Str2, "Log in","Second SoftAssert Failed");
			String Str3=loginPageObj.MsgForInvalidDetails();
			S1.assertEquals(Str3, "You have entered an invalid username or password. Please try again.","Third SoftAssert Failed");
			loginPageObj.clickAgrivilleLogo();
		
			
			S1.assertAll();
			System.out.println("Login Post A Thread: User is not able to Login without Username and Password");
	}
	
	@Test(priority=20)
	public void LoginToApplication3() throws InterruptedException
	{
		
		loginPageObj.clickLogin();
		Thread.sleep(4000);
		loginPageObj.UserName(ExcelDataUtilObj.getData(sheetName, 5, 0));
		loginPageObj.Password(ExcelDataUtilObj.getData(sheetName, 5, 1));
		loginPageObj.clickLoginBtnOnLoginFrame();
		loginPageObj.clickArrowBtn();
		loginPageObj.clickLogOutBtn();
		testUtil.Switch_To_Alert_Accept();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("User is Logged and Logged out in Successful");
	}
	
	
	
	@Test(priority=21)
	public void verifyLoginWithNoUserNameDCPostThread() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		loginPageObj.clickFirstDiscCategory();
		Thread.sleep(4000);
		loginPageObj.clickPostThread();
	
		loginPageObj.EmailLP(ExcelDataUtilObj.getData(sheetName, 2, 0));
		loginPageObj.PasswordLP(ExcelDataUtilObj.getData(sheetName, 2, 1));
		testUtil.Scroll_DownFull_Page();
		loginPageObj.clickLoginBtnLP();	
		String Str1=loginPageObj.MsgLoginNewPage();
		S1.assertEquals(Str1, "Message","First SoftAssert Failed");
		String Str2=loginPageObj.H1LoginNewPage();
		S1.assertEquals(Str2, "Log in","Second SoftAssert Failed");
		String Str3=loginPageObj.MsgForInvalidDetails();
		S1.assertEquals(Str3, "You have entered an invalid username or password. Please try again.","Third SoftAssert Failed");
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Login Post A Thread: User is not able to Login without Username");
	}

	@Test(priority=22)
	public void verifyLoginWithNoPasswordDCPostThread() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		loginPageObj.clickFirstDiscCategory();
		Thread.sleep(4000);
		loginPageObj.clickPostThread();
	
		loginPageObj.EmailLP(ExcelDataUtilObj.getData(sheetName, 3, 0));
		loginPageObj.PasswordLP(ExcelDataUtilObj.getData(sheetName, 3, 1));
		testUtil.Scroll_DownFull_Page();
		loginPageObj.clickLoginBtnLP();	
		String Str1=loginPageObj.MsgLoginNewPage();
		S1.assertEquals(Str1, "Message","First SoftAssert Failed");
		String Str2=loginPageObj.H1LoginNewPage();
		S1.assertEquals(Str2, "Log in","Second SoftAssert Failed");
		String Str3=loginPageObj.MsgForInvalidDetails();
		S1.assertEquals(Str3, "You have entered an invalid username or password. Please enter the ","Third SoftAssert Failed");
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Login Post A Thread: User is not able to Login without Password");
	}

	@Test(priority=23)
	public void verifyLoginInvalidUserNameDCPostThread() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		loginPageObj.clickFirstDiscCategory();
		Thread.sleep(4000);
		loginPageObj.clickPostThread();
	
		loginPageObj.EmailLP(ExcelDataUtilObj.getData(sheetName, 8, 0));
		loginPageObj.PasswordLP(ExcelDataUtilObj.getData(sheetName, 8, 1));
		testUtil.Scroll_DownFull_Page();
		loginPageObj.clickLoginBtnLP();	
		String Str1=loginPageObj.MsgLoginNewPage();
		S1.assertEquals(Str1, "Message","First SoftAssert Failed");
		String Str2=loginPageObj.H1LoginNewPage();
		S1.assertEquals(Str2, "Log in","Second SoftAssert Failed");
		String Str3=loginPageObj.MsgForInvalidDetails();
		S1.assertEquals(Str3, "You have entered an invalid username or password. Please enter the ","Third SoftAssert Failed");
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Login Post A Thread: User is not able to Login with Invalid UserName");
	}

	
	@Test(priority=24)
	public void verifyLoginValidUserNameAndPwdDCPostThread() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		loginPageObj.clickFirstDiscCategory();
		Thread.sleep(4000);
		loginPageObj.clickPostThread();
		
		loginPageObj.EmailLP(ExcelDataUtilObj.getData(sheetName, 5, 0));
		loginPageObj.PasswordLP(ExcelDataUtilObj.getData(sheetName, 5, 1));
		testUtil.Scroll_DownFull_Page();
		loginPageObj.clickLoginBtnLP();		
		String Str1=loginPageObj.MsgWelcome();
		S1.assertEquals(Str1, "WELCOME","First SoftAssert Failed");
		
						
		String Str2=loginPageObj.TitlePostANewThread();
		S1.assertEquals(Str2, "Post a New Thread","First SoftAssert Failed");
		
		Thread.sleep(4000);
		loginPageObj.clickArrowBtn();
		Thread.sleep(4000);
		loginPageObj.clickLogOutBtn();
		Thread.sleep(4000);
		testUtil.Switch_To_Alert_Dismiss();
		String Str3=loginPageObj.MsgWelcome();
		S1.assertEquals(Str3, "WELCOME","Second SoftAssert Failed");
		loginPageObj.clickAgrivilleLogo();
		
		Thread.sleep(4000);
		loginPageObj.clickArrowBtn();
		Thread.sleep(4000);
		loginPageObj.clickLogOutBtn();
		Thread.sleep(4000);
		testUtil.Switch_To_Alert_Accept();
		
		String Str4=loginPageObj.MsgLoginNewPage();
		S1.assertEquals(Str4, "Message","Third SoftAssert Failed");
		
		String Str5=loginPageObj.H1LoginNewPage();
		S1.assertEquals(Str5, "Log in","Fourth SoftAssert Failed");
		
		String Str6=loginPageObj.MsgForCookies();
		S1.assertEquals(Str6, "All cookies cleared!","Fifth SoftAssert Failed");
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Login Post A Thread: User is able to Login with Valid UserName and Password");
		
	}
	
	
	@Test(priority=25)
	public void verifyLoginInvalidPasswordDCPostThread() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		loginPageObj.clickFirstDiscCategory();
		Thread.sleep(4000);
		loginPageObj.clickPostThread();
		
		loginPageObj.EmailLP(ExcelDataUtilObj.getData(sheetName, 6, 0));
		loginPageObj.PasswordLP(ExcelDataUtilObj.getData(sheetName, 6, 1));
		testUtil.Scroll_DownFull_Page();
		loginPageObj.clickLoginBtnLP();	
		String Str1=loginPageObj.MsgLoginNewPage();
		S1.assertEquals(Str1, "Message","First SoftAssert Failed");
		
		String Str2=loginPageObj.H1LoginNewPage();
		S1.assertEquals(Str2, "Log in","Second SoftAssert Failed");
		
		String Str3=loginPageObj.MsgForInvalidDetails();
		S1.assertEquals(Str3, "You have entered an invalid username or password. Please enter the ","Third SoftAssert Failed");
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Login Post A Thread: User is not able to Login with Invalid Password");
		
	}
	
	@Test(priority=26)
	public void verifyLoginPageMostRecentThread() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		loginPageObj.clickFirstMostRecentThread();
		Thread.sleep(4000);
		loginPageObj.clickPostMessage();
		String Str1=loginPageObj.MsgLoginNewPage();
		S1.assertEquals(Str1, "Message","First SoftAssert Failed");
		String Str2=loginPageObj.H1LoginNewPage();
		S1.assertEquals(Str2, "Log in","Second SoftAssert Failed");
		String Str3=loginPageObj.MsgForInvalidDetails();
		S1.assertEquals(Str3, "Welcome to Agriville! You need to login to post messages in the Agr","Third SoftAssert Failed");
		
		for(int i=0;i<loginPageObj.verifyFullLoginPage().size();i++)
		{
			boolean flag=loginPageObj.verifyFullLoginPage().get(i);
			S1.assertTrue(flag,"SoftAssert Failed on Loop");
			
		}
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Login Post A Message: Verified the Login Page ");
	}
	
	@Test(priority=27)
	public void verifyLoginWithNoUserNameAndPasswordMostRecentThread() throws InterruptedException, IOException
	{
		SoftAssert S1=new SoftAssert();
		loginPageObj.clickFirstMostRecentThread();
		Thread.sleep(4000);
		loginPageObj.clickPostMessage();
		
			loginPageObj.EmailLP(ExcelDataUtilObj.getData(sheetName, 1, 0));
			loginPageObj.PasswordLP(ExcelDataUtilObj.getData(sheetName, 1, 1));
			testUtil.Scroll_DownFull_Page();
			loginPageObj.clickLoginBtnLP();	
			String Str1=loginPageObj.MsgLoginNewPage();
			S1.assertEquals(Str1, "Message","First SoftAssert Failed");
			String Str2=loginPageObj.H1LoginNewPage();
			S1.assertEquals(Str2, "Log in","Second SoftAssert Failed");
			String Str3=loginPageObj.MsgForInvalidDetails();
			S1.assertEquals(Str3, "You have entered an invalid username or password. Please try again.","Third SoftAssert Failed");
			loginPageObj.clickAgrivilleLogo();
		
			
			S1.assertAll();
			System.out.println("Login Post A Message: User is not able to Login without Username and Password");
	}
	
	@Test(priority=28)
	public void LoginToApplication4() throws InterruptedException
	{
		
		loginPageObj.clickLogin();
		Thread.sleep(4000);
		loginPageObj.UserName(ExcelDataUtilObj.getData(sheetName, 5, 0));
		loginPageObj.Password(ExcelDataUtilObj.getData(sheetName, 5, 1));
		loginPageObj.clickLoginBtnOnLoginFrame();
		loginPageObj.clickArrowBtn();
		loginPageObj.clickLogOutBtn();
		testUtil.Switch_To_Alert_Accept();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("User is Logged and Logged out in Successful");
	}
	
	
	
	@Test(priority=29)
	public void verifyLoginWithNoUserNameMostRecentThread() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		loginPageObj.clickFirstMostRecentThread();
		Thread.sleep(4000);
		loginPageObj.clickPostMessage();
	
		loginPageObj.EmailLP(ExcelDataUtilObj.getData(sheetName, 2, 0));
		loginPageObj.PasswordLP(ExcelDataUtilObj.getData(sheetName, 2, 1));
		testUtil.Scroll_DownFull_Page();
		loginPageObj.clickLoginBtnLP();	
		String Str1=loginPageObj.MsgLoginNewPage();
		S1.assertEquals(Str1, "Message","First SoftAssert Failed");
		String Str2=loginPageObj.H1LoginNewPage();
		S1.assertEquals(Str2, "Log in","Second SoftAssert Failed");
		String Str3=loginPageObj.MsgForInvalidDetails();
		S1.assertEquals(Str3, "You have entered an invalid username or password. Please try again.","Third SoftAssert Failed");
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Login Post A Message: User is not able to Login without Username");
	}

	@Test(priority=30)
	public void verifyLoginWithNoPasswordMostRecentThread() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		loginPageObj.clickFirstMostRecentThread();
		Thread.sleep(4000);
		loginPageObj.clickPostMessage();
	
		loginPageObj.EmailLP(ExcelDataUtilObj.getData(sheetName, 3, 0));
		loginPageObj.PasswordLP(ExcelDataUtilObj.getData(sheetName, 3, 1));
		testUtil.Scroll_DownFull_Page();
		loginPageObj.clickLoginBtnLP();	
		String Str1=loginPageObj.MsgLoginNewPage();
		S1.assertEquals(Str1, "Message","First SoftAssert Failed");
		String Str2=loginPageObj.H1LoginNewPage();
		S1.assertEquals(Str2, "Log in","Second SoftAssert Failed");
		String Str3=loginPageObj.MsgForInvalidDetails();
		S1.assertEquals(Str3, "You have entered an invalid username or password. Please enter the ","Third SoftAssert Failed");
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Login Post A Message: User is not able to Login without Password");
	}

	@Test(priority=31)
	public void verifyLoginInvalidUserNameMostRecentThread() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		loginPageObj.clickFirstMostRecentThread();
		Thread.sleep(4000);
		loginPageObj.clickPostMessage();
	
		loginPageObj.EmailLP(ExcelDataUtilObj.getData(sheetName, 9, 0));
		loginPageObj.PasswordLP(ExcelDataUtilObj.getData(sheetName, 9, 1));
		testUtil.Scroll_DownFull_Page();
		loginPageObj.clickLoginBtnLP();	
		String Str1=loginPageObj.MsgLoginNewPage();
		S1.assertEquals(Str1, "Message","First SoftAssert Failed");
		String Str2=loginPageObj.H1LoginNewPage();
		S1.assertEquals(Str2, "Log in","Second SoftAssert Failed");
		String Str3=loginPageObj.MsgForInvalidDetails();
		S1.assertEquals(Str3, "You have entered an invalid username or password. Please enter the ","Third SoftAssert Failed");
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Login Post A Message: User is not able to Login with Invalid UserName");
	}

	
	@Test(priority=32)
	public void verifyLoginValidUserNameAndPwdMostRecentThread() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		loginPageObj.clickFirstMostRecentThread();
		Thread.sleep(4000);
		loginPageObj.clickPostMessage();
		
		loginPageObj.EmailLP(ExcelDataUtilObj.getData(sheetName, 5, 0));
		loginPageObj.PasswordLP(ExcelDataUtilObj.getData(sheetName, 5, 1));
		testUtil.Scroll_DownFull_Page();
		loginPageObj.clickLoginBtnLP();		
		String Str1=loginPageObj.MsgWelcome();
		S1.assertEquals(Str1, "WELCOME","First SoftAssert Failed");
		
						
		String Str2=loginPageObj.TitlePostReply();
		S1.assertEquals(Str2, "Post a New Reply","First SoftAssert Failed");
		
		Thread.sleep(4000);
		loginPageObj.clickArrowBtn();
		Thread.sleep(4000);
		loginPageObj.clickLogOutBtn();
		Thread.sleep(4000);
		testUtil.Switch_To_Alert_Dismiss();
		String Str3=loginPageObj.MsgWelcome();
		S1.assertEquals(Str3, "WELCOME","Second SoftAssert Failed");
		loginPageObj.clickAgrivilleLogo();
		
		Thread.sleep(4000);
		loginPageObj.clickArrowBtn();
		Thread.sleep(4000);
		loginPageObj.clickLogOutBtn();
		Thread.sleep(4000);
		testUtil.Switch_To_Alert_Accept();
		
		String Str4=loginPageObj.MsgLoginNewPage();
		S1.assertEquals(Str4, "Message","Third SoftAssert Failed");
		
		String Str5=loginPageObj.H1LoginNewPage();
		S1.assertEquals(Str5, "Log in","Fourth SoftAssert Failed");
		
		String Str6=loginPageObj.MsgForCookies();
		S1.assertEquals(Str6, "All cookies cleared!","Fifth SoftAssert Failed");
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Login Post A Message: User is able to Login with Valid UserName and Password");
		
	}
	
	
	@Test(priority=33)
	public void verifyLoginInvalidPasswordMostRecentThread() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		loginPageObj.clickFirstMostRecentThread();
		Thread.sleep(4000);
		loginPageObj.clickPostMessage();
		
		loginPageObj.EmailLP(ExcelDataUtilObj.getData(sheetName, 6, 0));
		loginPageObj.PasswordLP(ExcelDataUtilObj.getData(sheetName, 6, 1));
		testUtil.Scroll_DownFull_Page();
		loginPageObj.clickLoginBtnLP();	
		String Str1=loginPageObj.MsgLoginNewPage();
		S1.assertEquals(Str1, "Message","First SoftAssert Failed");
		
		String Str2=loginPageObj.H1LoginNewPage();
		S1.assertEquals(Str2, "Log in","Second SoftAssert Failed");
		
		String Str3=loginPageObj.MsgForInvalidDetails();
		S1.assertEquals(Str3, "You have entered an invalid username or password. Please enter the ","Third SoftAssert Failed");
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Login Post A Message: User is not able to Login with Invalid Password");
		
	}

	
	
	
	////////////////////////////////
	
	@Test(priority=34)
	public void verifyLoginPageReplyBtn() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		loginPageObj.clickFirstMostRecentThread();
		
		
		Thread.sleep(4000);
		loginPageObj.clickReplyBtn();
		
		
		String Str1=loginPageObj.MsgLoginNewPage();
		S1.assertEquals(Str1, "Message","First SoftAssert Failed");
		String Str2=loginPageObj.H1LoginNewPage();
		S1.assertEquals(Str2, "Log in","Second SoftAssert Failed");
		String Str3=loginPageObj.MsgForInvalidDetails();
		S1.assertEquals(Str3, "Welcome to Agriville! You need to login to post messages in the Agr","Third SoftAssert Failed");
		
		for(int i=0;i<loginPageObj.verifyFullLoginPage().size();i++)
		{
			boolean flag=loginPageObj.verifyFullLoginPage().get(i);
			S1.assertTrue(flag,"SoftAssert Failed on Loop");
			
		}
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Login Post A New Reply: Verified the Login Page ");
	}
	
	@Test(priority=35)
	public void verifyLoginWithNoUserNameAndPasswordReplyBtn() throws InterruptedException, IOException
	{
		SoftAssert S1=new SoftAssert();
		loginPageObj.clickFirstMostRecentThread();
		Thread.sleep(4000);
		loginPageObj.clickReplyBtn();
		
			loginPageObj.EmailLP(ExcelDataUtilObj.getData(sheetName, 1, 0));
			loginPageObj.PasswordLP(ExcelDataUtilObj.getData(sheetName, 1, 1));
			
			loginPageObj.clickLoginBtnLP();	
			String Str1=loginPageObj.MsgLoginNewPage();
			S1.assertEquals(Str1, "Message","First SoftAssert Failed");
			String Str2=loginPageObj.H1LoginNewPage();
			S1.assertEquals(Str2, "Log in","Second SoftAssert Failed");
			String Str3=loginPageObj.MsgForInvalidDetails();
			S1.assertEquals(Str3, "You have entered an invalid username or password. Please try again.","Third SoftAssert Failed");
			loginPageObj.clickAgrivilleLogo();
		
			
			S1.assertAll();
			System.out.println("Login Post A New Reply: User is not able to Login without Username and Password");
	}
	
	@Test(priority=36)
	public void LoginToApplication5() throws InterruptedException
	{
		
		loginPageObj.clickLogin();
		Thread.sleep(4000);
		loginPageObj.UserName(ExcelDataUtilObj.getData(sheetName, 5, 0));
		loginPageObj.Password(ExcelDataUtilObj.getData(sheetName, 5, 1));
		loginPageObj.clickLoginBtnOnLoginFrame();
		loginPageObj.clickArrowBtn();
		loginPageObj.clickLogOutBtn();
		testUtil.Switch_To_Alert_Accept();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("User is Logged and Logged out in Successful");
	}
	
	
	
	@Test(priority=37)
	public void verifyLoginWithNoUserNameReplyBtn() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		loginPageObj.clickFirstMostRecentThread();
		Thread.sleep(4000);
		loginPageObj.clickReplyBtn();
	
		loginPageObj.EmailLP(ExcelDataUtilObj.getData(sheetName, 2, 0));
		loginPageObj.PasswordLP(ExcelDataUtilObj.getData(sheetName, 2, 1));
		
		loginPageObj.clickLoginBtnLP();	
		String Str1=loginPageObj.MsgLoginNewPage();
		S1.assertEquals(Str1, "Message","First SoftAssert Failed");
		String Str2=loginPageObj.H1LoginNewPage();
		S1.assertEquals(Str2, "Log in","Second SoftAssert Failed");
		String Str3=loginPageObj.MsgForInvalidDetails();
		S1.assertEquals(Str3, "You have entered an invalid username or password. Please try again.","Third SoftAssert Failed");
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Login Post A New Reply: User is not able to Login without Username");
	}

	@Test(priority=38)
	public void verifyLoginWithNoPasswordReplyBtn() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		loginPageObj.clickFirstMostRecentThread();
		Thread.sleep(4000);
		loginPageObj.clickReplyBtn();
	
		loginPageObj.EmailLP(ExcelDataUtilObj.getData(sheetName, 3, 0));
		loginPageObj.PasswordLP(ExcelDataUtilObj.getData(sheetName, 3, 1));
		
		loginPageObj.clickLoginBtnLP();	
		String Str1=loginPageObj.MsgLoginNewPage();
		S1.assertEquals(Str1, "Message","First SoftAssert Failed");
		String Str2=loginPageObj.H1LoginNewPage();
		S1.assertEquals(Str2, "Log in","Second SoftAssert Failed");
		String Str3=loginPageObj.MsgForInvalidDetails();
		S1.assertEquals(Str3, "You have entered an invalid username or password. Please enter the ","Third SoftAssert Failed");
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Login Post A New Reply: User is not able to Login without Password");
	}

	@Test(priority=39)
	public void verifyLoginInvalidUserNameReplyBtn() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		loginPageObj.clickFirstMostRecentThread();
		Thread.sleep(4000);
		loginPageObj.clickReplyBtn();
	
		loginPageObj.EmailLP(ExcelDataUtilObj.getData(sheetName, 10, 0));
		loginPageObj.PasswordLP(ExcelDataUtilObj.getData(sheetName, 10, 1));
		
		loginPageObj.clickLoginBtnLP();	
		String Str1=loginPageObj.MsgLoginNewPage();
		S1.assertEquals(Str1, "Message","First SoftAssert Failed");
		String Str2=loginPageObj.H1LoginNewPage();
		S1.assertEquals(Str2, "Log in","Second SoftAssert Failed");
		String Str3=loginPageObj.MsgForInvalidDetails();
		S1.assertEquals(Str3, "You have entered an invalid username or password. Please enter the ","Third SoftAssert Failed");
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Login Post A New Reply: User is not able to Login with Invalid UserName");
	}

	
	@Test(priority=40)
	public void verifyLoginValidUserNameAndPwdReplyBtn() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		loginPageObj.clickFirstMostRecentThread();
		Thread.sleep(4000);
		loginPageObj.clickReplyBtn();
		
		loginPageObj.EmailLP(ExcelDataUtilObj.getData(sheetName, 5, 0));
		loginPageObj.PasswordLP(ExcelDataUtilObj.getData(sheetName, 5, 1));
		
		loginPageObj.clickLoginBtnLP();		
		String Str1=loginPageObj.MsgWelcome();
		S1.assertEquals(Str1, "WELCOME","First SoftAssert Failed");
		
						
		String Str2=loginPageObj.TitlePostReplyfrmBtn();
		S1.assertEquals(Str2, "Post a New Reply","First SoftAssert Failed");
		
		Thread.sleep(4000);
		loginPageObj.clickArrowBtn();
		Thread.sleep(4000);
		loginPageObj.clickLogOutBtn();
		Thread.sleep(4000);
		testUtil.Switch_To_Alert_Dismiss();
		String Str3=loginPageObj.MsgWelcome();
		S1.assertEquals(Str3, "WELCOME","Second SoftAssert Failed");
		loginPageObj.clickAgrivilleLogo();
		
		Thread.sleep(4000);
		loginPageObj.clickArrowBtn();
		Thread.sleep(4000);
		loginPageObj.clickLogOutBtn();
		Thread.sleep(4000);
		testUtil.Switch_To_Alert_Accept();
		
		String Str4=loginPageObj.MsgLoginNewPage();
		S1.assertEquals(Str4, "Message","Third SoftAssert Failed");
		
		String Str5=loginPageObj.H1LoginNewPage();
		S1.assertEquals(Str5, "Log in","Fourth SoftAssert Failed");
		
		String Str6=loginPageObj.MsgForCookies();
		S1.assertEquals(Str6, "All cookies cleared!","Fifth SoftAssert Failed");
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Login Post A New Reply: User is able to Login with Valid UserName and Password");
		
	}
	
	
	@Test(priority=41)
	public void verifyLoginInvalidPasswordReplyBtn() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		loginPageObj.clickFirstMostRecentThread();
		Thread.sleep(4000);
		loginPageObj.clickReplyBtn();
		
		loginPageObj.EmailLP(ExcelDataUtilObj.getData(sheetName, 6, 0));
		loginPageObj.PasswordLP(ExcelDataUtilObj.getData(sheetName, 6, 1));
		
		loginPageObj.clickLoginBtnLP();	
		String Str1=loginPageObj.MsgLoginNewPage();
		S1.assertEquals(Str1, "Message","First SoftAssert Failed");
		
		String Str2=loginPageObj.H1LoginNewPage();
		S1.assertEquals(Str2, "Log in","Second SoftAssert Failed");
		
		String Str3=loginPageObj.MsgForInvalidDetails();
		S1.assertEquals(Str3, "You have entered an invalid username or password. Please enter the ","Third SoftAssert Failed");
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Login Post A New Reply: User is not able to Login with Invalid Password");
		
	}
	
	
		
	
	
	
	
	@AfterClass
	public void TearDown()
	{
		driver.quit();
	}
	
}
