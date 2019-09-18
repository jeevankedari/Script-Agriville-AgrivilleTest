package com.agriville.qa.testcases;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.agriville.qa.base.TestBase;
import com.agriville.qa.pages.registerAgriville;
import com.agriville.qa.util.ExcelDataUtil;
import com.agriville.qa.util.excelUtils;
import com.agriville.qa.util.testUtil;

public class registerAgrivilleTest extends TestBase
{
	registerAgriville registerAgrivilleObj;
	testUtil testUtilObj;
	ExcelDataUtil ExcelDataUtilObj;
	//String Path="E://Script Agriville//AgrivilleTest//src//main//java//com//agriville//qa//testdata//Agriville.xlsx";
	String sheetName="Registration";
	
	
	@DataProvider
	public Object[][] getAgrivilleTestData() throws EncryptedDocumentException, InvalidFormatException
	{
		
		
			Object data[][]=excelUtils.AgrivilleTestData(sheetName);
			
			return data;
			
			
	}
	
	
	
	public registerAgrivilleTest()
	{
		super();
	}
	
	@BeforeClass
	public void SetUp()
	{
		intialization();
		registerAgrivilleObj = new registerAgriville();
		testUtilObj=new testUtil();
		//ExcelDataUtilObj=new ExcelDataUtil(Path);
	}
	@Test(priority=1)
	public void verifyRegistrationPage()
	{
		try
		{
		SoftAssert S1=new SoftAssert();
		registerAgrivilleObj.clickRegisterLink();
		for(int i=0;i<registerAgrivilleObj.FieldsOnRegistrationPage().size();i++)
		{
			boolean flag=registerAgrivilleObj.FieldsOnRegistrationPage().get(i);
			S1.assertTrue(flag,"The Assertion Failed in Loop");
		}
		String Str1=registerAgrivilleObj.H1Register();
		S1.assertEquals(Str1, "Register","Header for Registration Page is Incorrect");
		
		String Str2=registerAgrivilleObj.NoteDescUserName();
		S1.assertEquals(Str2, "Please enter the name by which you would like to log-in and be known on this site.","Note Below User Name is Incorrect");
		
		String Str3=registerAgrivilleObj.NoteDescConfirmPwd();
		S1.assertEquals(Str3, "Please enter a password for your user account. Note that passwords are case-sensitive.","Note Below Confirm Password is Incorrect");
		
		String Str4=registerAgrivilleObj.NoteDescConfirmEmail();
		S1.assertEquals(Str4, "Please enter a valid email address for yourself.","Note Below Confirm Email Address is Incorrect");
		
		String Str5=registerAgrivilleObj.NoteImageVerification();
		S1.assertEquals(Str5, "Please enter the six letters or digits that appear in the image opposite.","Note Above Captcha Image is Incorrect");
		
		String Str6=registerAgrivilleObj.H2ForumRules();
		S1.assertEquals(Str6, "Forum Rules","H2 for Forum Rules on Registration Page is Incorrect");
		
		String Str7=registerAgrivilleObj.ForumRulesTxt();
		S1.assertEquals(Str7, "In order to proceed, you must agree with the following rules:","Forum Rules Text is incorrect on Registration Page is Incorrect");
		
		String Str8=registerAgrivilleObj.TitleForumRules();
		S1.assertEquals(Str8, "Forum Rules","The Title for Forum Rules is incorrect");
		
		String Str9=registerAgrivilleObj.TxtIAgree();
		S1.assertEquals(Str9, "I have read, and agree to abide by the Farming and Agriculture Discussion Forum | Agriville.com rules.","The I agree Terms are incorrect");
		
		String Str10=registerAgrivilleObj.TxtQuestions();
		S1.assertEquals(Str10, "Questions? Contact us: agriville@farms.com","Questions and Contacts are incorrect are incorrect");
		
		String Str11=registerAgrivilleObj.EmailTo();
		S1.assertEquals(Str11, "agriville@farms.com","The Email To Link is missing");
		S1.assertAll();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
	}
	
	
	@Test(priority=2)
	public void verifyNoRegistrationData() throws InterruptedException
	{
		try
		{
		SoftAssert S1=new SoftAssert();
		registerAgrivilleObj.clickRegisterLink();
		registerAgrivilleObj.clickCompleteRegistrationBtn();
		String Str1=testUtil.Switch_ToAlert_GetText_And_Accept_Alert();
		S1.assertEquals(Str1, "Please fill out both password fields.", "The Message displayed on Alert is Incorrect");
		testUtil.RefreshCurrentPage();
		
		registerAgrivilleObj.EnterPwd();
		registerAgrivilleObj.clickCompleteRegistrationBtn();
		
		String Str2=testUtil.Switch_ToAlert_GetText_And_Accept_Alert();
		S1.assertEquals(Str2, "Please fill out both password fields.", "The Message displayed on Alert is Incorrect");
		testUtil.RefreshCurrentPage();
		
		
		registerAgrivilleObj.EnterConfirmPwd();
		registerAgrivilleObj.clickCompleteRegistrationBtn();
		
		String Str3=testUtil.Switch_ToAlert_GetText_And_Accept_Alert();
		S1.assertEquals(Str3, "Please fill out both password fields.", "The Message displayed on Alert is Incorrect");
		
		testUtil.RefreshCurrentPage();
		
		registerAgrivilleObj.EnterPwd();
		registerAgrivilleObj.InvalidConfirmPwd();
		registerAgrivilleObj.clickCompleteRegistrationBtn();
		
		String Str4=testUtil.Switch_ToAlert_GetText_And_Accept_Alert();
		S1.assertEquals(Str4, "The entered passwords do not match.", "The Message displayed on Alert is Incorrect");
		testUtil.RefreshCurrentPage();
		
		
		registerAgrivilleObj.InvalidEnterPwd();
		registerAgrivilleObj.EnterConfirmPwd();
		registerAgrivilleObj.clickCompleteRegistrationBtn();
		
		String Str5=testUtil.Switch_ToAlert_GetText_And_Accept_Alert();
		S1.assertEquals(Str5, "The entered passwords do not match.", "The Message displayed on Alert is Incorrect");
		
		testUtil.RefreshCurrentPage();
		
		registerAgrivilleObj.EnterPwd();
		registerAgrivilleObj.EnterConfirmPwd();
		registerAgrivilleObj.clickCompleteRegistrationBtn();
		String Str6=registerAgrivilleObj.H1ErrorsRegistration();
		S1.assertEquals(Str6, "The following errors occurred during your registration","Error is incorrectly displayed on Registration page");
		
		String Str7=registerAgrivilleObj.MsgRequiredFieldsBlank();
		S1.assertEquals(Str7, "You have left a required field blank.","Error is incorrectly displayed on Registration page");
		
		String Str8=registerAgrivilleObj.MsgEmail();
		S1.assertEquals(Str8, "Please complete the required field \"Email\".","Message for Email is not displayed");
		
		String Str9=registerAgrivilleObj.MsgUserName();
		S1.assertEquals(Str9, "Please complete the required field \"Username\".","Message for UserName is not displayed");
		
		String Str10=registerAgrivilleObj.MsgCaptcha();
		S1.assertEquals(Str10, "The string you entered for the image verification did not match what was displayed.","Message for Captcha is not displayed");
		
		String Str11=registerAgrivilleObj.MsgFName();
		S1.assertEquals(Str11, "First Name","Message for First Name is not displayed");
		
		String Str12=registerAgrivilleObj.MsgLName();
		S1.assertEquals(Str12, "Last Name","Message for Last Name is not displayed");
		
		String Str13=registerAgrivilleObj.MsgZipPostal();
		S1.assertEquals(Str13, "Zip / Postal Code","Message for Zip Postal Code is not displayed");
		S1.assertAll();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test(priority=3,dataProvider="getAgrivilleTestData")
	public void verifyFName(String TC_Id, String FName, String LName, String Zip, String UserName, String Password,
			String ConfirmPwd, String Email, String ConfirmEmail)
	{
		
		SoftAssert S1=new SoftAssert();
		if(TC_Id.equals("TC_0001"))
		{
			try
			{
			registerAgrivilleObj.clickRegisterLink();
			registerAgrivilleObj.EnterData(TC_Id, FName, LName, Zip, UserName, Password, ConfirmPwd, Email, ConfirmEmail);
			registerAgrivilleObj.clickCompleteRegistrationBtn();
			String Str1=registerAgrivilleObj.MsgFName();
			S1.assertEquals(Str1, "First Name","Message for First Name is not displayed");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		else
		{
			throw new SkipException("");
		}
		S1.assertAll();
		registerAgrivilleObj.clickAgrivilleLogo();
		System.out.println("First Name is Mandatory");
		
		
	}
	
	
	@Test(priority=4,dataProvider="getAgrivilleTestData")
	public void verifyLName(String TC_Id, String FName, String LName, String Zip, String UserName, String Password,
			String ConfirmPwd, String Email, String ConfirmEmail)
	{
		
		SoftAssert S1=new SoftAssert();
		if(TC_Id.equals("TC_0002"))
		{
			try
			{
			registerAgrivilleObj.clickRegisterLink();
			registerAgrivilleObj.EnterData(TC_Id, FName, LName, Zip, UserName, Password, ConfirmPwd, Email, ConfirmEmail);
			registerAgrivilleObj.clickCompleteRegistrationBtn();
			String Str1=registerAgrivilleObj.MsgLName();
			S1.assertEquals(Str1, "Last Name","Message for Last Name is not displayed");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		else
		{
			throw new SkipException("");
		}
		S1.assertAll();
		registerAgrivilleObj.clickAgrivilleLogo();
		System.out.println("Last Name is Mandatory");
		
		
		
	}
	
	@Test(priority=5,dataProvider="getAgrivilleTestData")
	public void verifyBlankZipCode(String TC_Id, String FName, String LName, String Zip, String UserName, String Password,
			String ConfirmPwd, String Email, String ConfirmEmail)
	{
		SoftAssert S1=new SoftAssert();
		if(TC_Id.equals("TC_0003"))
		{
			try
			{
			registerAgrivilleObj.clickRegisterLink();
			registerAgrivilleObj.EnterData(TC_Id, FName, LName, Zip, UserName, Password, ConfirmPwd, Email, ConfirmEmail);
			registerAgrivilleObj.clickCompleteRegistrationBtn();
			String Str1=registerAgrivilleObj.MsgZipPostal();
			S1.assertEquals(Str1, "Zip / Postal Code","Message for Zip Postal Code is not displayed");
			registerAgrivilleObj.clickAgrivilleLogo();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
			
				
		else
		{
			throw new SkipException("");
		}
		
		S1.assertAll();
		registerAgrivilleObj.clickAgrivilleLogo();
		System.out.println("Zip is Mandatory and Invalid Zip is not accepted");
		
		
		
	}
	
	
	@Test(priority=6,dataProvider="getAgrivilleTestData")
	public void verifyInvalidZipCode(String TC_Id, String FName, String LName, String Zip, String UserName, String Password,
			String ConfirmPwd, String Email, String ConfirmEmail)
	{
	
		SoftAssert S1=new SoftAssert();
		if(TC_Id.equals("TC_0004"))
		{
			try
			{
			registerAgrivilleObj.clickRegisterLink();
			registerAgrivilleObj.EnterData(TC_Id, FName, LName, Zip, UserName, Password, ConfirmPwd, Email, ConfirmEmail);
			registerAgrivilleObj.clickCompleteRegistrationBtn();
			String Str1=registerAgrivilleObj.MsgZipPostal();
			S1.assertEquals(Str1, "Zip / Postal Code","Message for Zip Postal Code is not displayed");
			registerAgrivilleObj.clickAgrivilleLogo();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else 
		{
			throw new SkipException("");
		}
		S1.assertAll();
		registerAgrivilleObj.clickAgrivilleLogo();
		System.out.println("Invalid Zip is not accepted");
		
	}
	
	
	@Test(priority=7,dataProvider="getAgrivilleTestData")
	public void verifyBlankUserName(String TC_Id, String FName, String LName, String Zip, String UserName, String Password,
			String ConfirmPwd, String Email, String ConfirmEmail)
	{
		SoftAssert S1=new SoftAssert();
		if(TC_Id.equals("TC_0005"))
		{
			try
			{
			registerAgrivilleObj.clickRegisterLink();
			registerAgrivilleObj.EnterData(TC_Id, FName, LName, Zip, UserName, Password, ConfirmPwd, Email, ConfirmEmail);
			registerAgrivilleObj.clickCompleteRegistrationBtn();
			String Str1=registerAgrivilleObj.MsgUserName();
			S1.assertEquals(Str1, "Please complete the required field \"Username\".","Message for UserName is not displayed\"");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		else
		{
			throw new SkipException("");
		}
		S1.assertAll();
		registerAgrivilleObj.clickAgrivilleLogo();
		System.out.println("User Name is Mandatory");
		
	}
	
	@Test(priority=8,dataProvider="getAgrivilleTestData")
	public void verifyShortUserName(String TC_Id, String FName, String LName, String Zip, String UserName, String Password,
			String ConfirmPwd, String Email, String ConfirmEmail)
	{
		
		SoftAssert S1=new SoftAssert();
		if(TC_Id.equals("TC_0006"))
		{
			try
			{
			registerAgrivilleObj.clickRegisterLink();
			registerAgrivilleObj.EnterData(TC_Id, FName, LName, Zip, UserName, Password, ConfirmPwd, Email, ConfirmEmail);
		
			String Str1=registerAgrivilleObj.MsgShortUserName();
			S1.assertEquals(Str1, "Your username cannot be shorter than 3 characters.","UserName accepts less than 3 Characters");
			registerAgrivilleObj.clickCompleteRegistrationBtn();
			String Str2=registerAgrivilleObj.MsgTopforShortUserName();
			S1.assertEquals(Str2, "Your username cannot be shorter than 3 characters.","UserName accepts less than 3 Characters");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			
		}
		else
		{
			throw new SkipException("");
		}
		S1.assertAll();
		registerAgrivilleObj.clickAgrivilleLogo();
		System.out.println("User cannot be shorter than 3 Characters");
		
		
		
	}
	
	
	
	@Test(priority=9,dataProvider="getAgrivilleTestData")
	public void verifyExistingUserName(String TC_Id, String FName, String LName, String Zip, String UserName, String Password,
			String ConfirmPwd, String Email, String ConfirmEmail)
	{
		
		SoftAssert S1=new SoftAssert();
		if(TC_Id.equals("TC_0007"))
		{
			try
			{
			registerAgrivilleObj.clickRegisterLink();
			registerAgrivilleObj.EnterData(TC_Id, FName, LName, Zip, UserName, Password, ConfirmPwd, Email, ConfirmEmail);
			
			String Str1=registerAgrivilleObj.MsgUserNameTBX();
			S1.assertEquals(Str1, "That username is already in use or does not meet the administrator's standards.");
			
			registerAgrivilleObj.ClickTBXClickHere();
			String Str2=registerAgrivilleObj.H1LostPassword();
			S1.assertEquals(Str2, "Lost Password Recovery Form");
			String Str3=testUtil.getTitleOfPage();
			S1.assertEquals(Str3, "Lost Password Recovery Form - Farming and Agriculture Discussion Forum | Agriville.com","The User is not Lost Password Screen");
			registerAgrivilleObj.clickAgrivilleLogo();
			
			registerAgrivilleObj.clickRegisterLink();
			registerAgrivilleObj.EnterData(TC_Id, FName, LName, Zip, UserName, Password, ConfirmPwd, Email, ConfirmEmail);
			String Str4=registerAgrivilleObj.MsgExistingUserName();
			S1.assertEquals(Str4, "That username is already in use or does not meet the administrator's standards. "
					+ "If you are Test and you have forgotten your password, click here.","Account Can be created Using Existing User Name");
			
			registerAgrivilleObj.ClickTopClickHere();
			String Str5=registerAgrivilleObj.H1LostPassword();
			S1.assertEquals(Str5, "Lost Password Recovery Form");
			String Str6=testUtil.getTitleOfPage();
			S1.assertEquals(Str6, "Lost Password Recovery Form - Farming and Agriculture Discussion Forum | Agriville.com","The User is not Lost Password Screen");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			throw new SkipException("");
		}
		S1.assertAll();
		registerAgrivilleObj.clickAgrivilleLogo();
		System.out.println("User Name is Mandatory");
		
		
		
	}
	
	@Test(priority=10,dataProvider="getAgrivilleTestData")
	public void verifyBlankPassword(String TC_Id, String FName, String LName, String Zip, String UserName, String Password,
			String ConfirmPwd, String Email, String ConfirmEmail) throws InterruptedException
	{
		
		SoftAssert S1=new SoftAssert();
		if(TC_Id.equals("TC_0008"))
			{
				try
				{
					registerAgrivilleObj.clickRegisterLink();
					registerAgrivilleObj.EnterData(TC_Id, FName, LName, Zip, UserName, Password, ConfirmPwd, Email, ConfirmEmail);
					registerAgrivilleObj.clickCompleteRegistrationBtn();
					String Str1=testUtil.Switch_ToAlert_GetText_And_Accept_Alert();
					S1.assertEquals(Str1, "Please fill out both password fields.", "The Message displayed on Alert is Incorrect");
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			} 
		else
		{
			throw new SkipException("");
		}
		S1.assertAll();
		registerAgrivilleObj.clickAgrivilleLogo();
		System.out.println("Password Field cannot be Blank");
		
	}
	
	
	@Test(priority=11,dataProvider="getAgrivilleTestData")
	public void verifyInvalidPassword(String TC_Id, String FName, String LName, String Zip, String UserName, String Password,
			String ConfirmPwd, String Email, String ConfirmEmail) throws InterruptedException
	{
		
		SoftAssert S1=new SoftAssert();
		if(TC_Id.equals("TC_0009"))
			{
				try 
				{
					registerAgrivilleObj.clickRegisterLink();
					registerAgrivilleObj.EnterData(TC_Id, FName, LName, Zip, UserName, Password, ConfirmPwd, Email, ConfirmEmail);
					registerAgrivilleObj.clickCompleteRegistrationBtn();
					String Str1=testUtil.Switch_ToAlert_GetText_And_Accept_Alert();
					S1.assertEquals(Str1, "The entered passwords do not match.", "The Message displayed on Alert is Incorrect");
				
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		else
		{
			throw new SkipException("");
		}
		S1.assertAll();
		registerAgrivilleObj.clickAgrivilleLogo();
		System.out.println("Password and Confirm Password do not Match");
		
		
		
	}
	
	@Test(priority=12,dataProvider="getAgrivilleTestData")
	public void verifyBlankConfirmPassword(String TC_Id, String FName, String LName, String Zip, String UserName, String Password,
			String ConfirmPwd, String Email, String ConfirmEmail) throws InterruptedException
	{
		
		SoftAssert S1=new SoftAssert();
		if(TC_Id.equals("TC_0010"))
			{
			try 
			{
					registerAgrivilleObj.clickRegisterLink();
					registerAgrivilleObj.EnterData(TC_Id, FName, LName, Zip, UserName, Password, ConfirmPwd, Email, ConfirmEmail);
					registerAgrivilleObj.clickCompleteRegistrationBtn();
					String Str1=testUtil.Switch_ToAlert_GetText_And_Accept_Alert();
					S1.assertEquals(Str1, "Please fill out both password fields.", "The Message displayed on Alert is Incorrect");
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			}
			
		else
		{
			throw new SkipException("");
		}
		S1.assertAll();
		registerAgrivilleObj.clickAgrivilleLogo();
		System.out.println("Confirm Password Field cannot be Blank");
	
		
		
	}
	
	
	
	@Test(priority=13,dataProvider="getAgrivilleTestData")
	public void verifyInvalidConfirmPassword(String TC_Id, String FName, String LName, String Zip, String UserName, String Password,
			String ConfirmPwd, String Email, String ConfirmEmail) throws InterruptedException
	{
		
		SoftAssert S1=new SoftAssert();
		if(TC_Id.equals("TC_0011"))
		{
			try 
			{
					registerAgrivilleObj.clickRegisterLink();
					registerAgrivilleObj.EnterData(TC_Id, FName, LName, Zip, UserName, Password, ConfirmPwd, Email, ConfirmEmail);
					registerAgrivilleObj.clickCompleteRegistrationBtn();
					String Str1=testUtil.Switch_ToAlert_GetText_And_Accept_Alert();
					S1.assertEquals(Str1, "The entered passwords do not match.", "The Message displayed on Alert is Incorrect");
			} 
			catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		}
		
			
		else
		{
			throw new SkipException("");
		}
		
		S1.assertAll();
		registerAgrivilleObj.clickAgrivilleLogo();
		System.out.println("Password and Confirm Password do not Match");
	}

	
	@Test(priority=14,dataProvider="getAgrivilleTestData")
	public void verifyBlankEmail(String TC_Id, String FName, String LName, String Zip, String UserName, String Password,
			String ConfirmPwd, String Email, String ConfirmEmail) throws InterruptedException
	{
		
		SoftAssert S1=new SoftAssert();
		if(TC_Id.equals("TC_0012"))
		{
			try 
			{
					registerAgrivilleObj.clickRegisterLink();
					registerAgrivilleObj.EnterData(TC_Id, FName, LName, Zip, UserName, Password, ConfirmPwd, Email, ConfirmEmail);
					registerAgrivilleObj.clickCompleteRegistrationBtn();
					
					String Str1=registerAgrivilleObj.MsgRequiredFieldsBlank();
					S1.assertEquals(Str1, "You have left a required field blank.", "Required Field is filled with Characters");
					
					String Str2=registerAgrivilleObj.MsgTwoMisMatchEmail();
					S1.assertEquals(Str2, "The two email addresses that you entered do not match.", "Two Different Email addresses are Matched");
					
					String Str3=registerAgrivilleObj.MsgEmail();
					S1.assertEquals(Str3, "Please complete the required field \"Email\".", "Blank Email is accepted");
			} 
			catch (Exception e) 
			{
			
				e.printStackTrace();
			}
		}
		else
		{
			throw new SkipException("");
		}
		
		S1.assertAll();
		registerAgrivilleObj.clickAgrivilleLogo();
		System.out.println("Email Field Cannot be Blank");
			
	}
		
	@Test(priority=15,dataProvider="getAgrivilleTestData")
	public void verifyInvalidEmail(String TC_Id, String FName, String LName, String Zip, String UserName, String Password,
			String ConfirmPwd, String Email, String ConfirmEmail) throws InterruptedException
	{
		
		SoftAssert S1=new SoftAssert();
		if(TC_Id.equals("TC_0013"))
		{
			try 
			{
					registerAgrivilleObj.clickRegisterLink();
					registerAgrivilleObj.EnterData(TC_Id, FName, LName, Zip, UserName, Password, ConfirmPwd, Email, ConfirmEmail);
					registerAgrivilleObj.clickCompleteRegistrationBtn();
					
					String Str1=registerAgrivilleObj.MsgTwoMisMatchEmail();
					S1.assertEquals(Str1, "The two email addresses that you entered do not match.", "Two Different Email addresses are Matched");
					
					String Str2=registerAgrivilleObj.MsgInvalidEmail();
					S1.assertEquals(Str2, "You entered an invalid email address.", "Invalid Email is accepted");
					
			} 
			catch (Exception e) 
			{
			
			e.printStackTrace();
			}
		}
	
		
	else
	{
		throw new SkipException("");
	}
	
	S1.assertAll();
	registerAgrivilleObj.clickAgrivilleLogo();
	System.out.println("Invalid Email is not Accepted");
}		
	
	
		
		@Test(priority=16,dataProvider="getAgrivilleTestData")
		public void verifyBlankConfirmEmail(String TC_Id, String FName, String LName, String Zip, String UserName, String Password,
				String ConfirmPwd, String Email, String ConfirmEmail) throws InterruptedException
		{
			
			SoftAssert S1=new SoftAssert();
			if(TC_Id.equals("TC_0014"))
			{
				try 
				{
						registerAgrivilleObj.clickRegisterLink();
						registerAgrivilleObj.EnterData(TC_Id, FName, LName, Zip, UserName, Password, ConfirmPwd, Email, ConfirmEmail);
						registerAgrivilleObj.clickCompleteRegistrationBtn();
						
						String Str1=registerAgrivilleObj.MsgRequiredFieldsBlank();
						S1.assertEquals(Str1, "You have left a required field blank.", "Required Field is filled with Characters");
						
						String Str2=registerAgrivilleObj.MsgTwoMisMatchEmail();
						S1.assertEquals(Str2, "The two email addresses that you entered do not match.", "Two Different Email addresses are Matched");
						
						
				} 
				catch (Exception e) 
				{
				
				e.printStackTrace();
				}
			}
		
			
		else
		{
			throw new SkipException("");
		}
		
		S1.assertAll();
		registerAgrivilleObj.clickAgrivilleLogo();
		System.out.println("Confirm Password Field cannot be Blank");
	}	
	
		
	
		
		
		@Test(priority=17,dataProvider="getAgrivilleTestData")
		public void verifyInvalidConfirmEmail(String TC_Id, String FName, String LName, String Zip, String UserName, String Password,
				String ConfirmPwd, String Email, String ConfirmEmail) throws InterruptedException
		{
			
			SoftAssert S1=new SoftAssert();
			if(TC_Id.equals("TC_0015"))
			{
				try 
				{
						registerAgrivilleObj.clickRegisterLink();
						registerAgrivilleObj.EnterData(TC_Id, FName, LName, Zip, UserName, Password, ConfirmPwd, Email, ConfirmEmail);
						registerAgrivilleObj.clickCompleteRegistrationBtn();
						
						String Str1=registerAgrivilleObj.MsgTwoMisMatchEmail();
						S1.assertEquals(Str1, "The two email addresses that you entered do not match.", "Two Different Email addresses are Matched");
						
				} 
				catch (Exception e) 
				{
				
				e.printStackTrace();
				}
			}
		
			
		else
		{
			throw new SkipException("");
		}
		
		S1.assertAll();
		registerAgrivilleObj.clickAgrivilleLogo();
		System.out.println("Invalid Confirm Email is not Accepted");
	}	
		
		
		
		
		@Test(priority=17,dataProvider="getAgrivilleTestData")
		public void verifyUnCheckAgreement(String TC_Id, String FName, String LName, String Zip, String UserName, String Password,
				String ConfirmPwd, String Email, String ConfirmEmail) throws InterruptedException
		{
			
			SoftAssert S1=new SoftAssert();
			if(TC_Id.equals("TC_0016"))
			{
				try 
				{
						registerAgrivilleObj.clickRegisterLink();
						registerAgrivilleObj.EnterData(TC_Id, FName, LName, Zip, UserName, Password, ConfirmPwd, Email, ConfirmEmail);
						registerAgrivilleObj.UnCheckForumRulesChkBx();
						registerAgrivilleObj.clickCompleteRegistrationBtn();
						
						String Str1=registerAgrivilleObj.MsgDidNotAcceptTC();
						S1.assertEquals(Str1, "here", "User Account Can be created without Accepting Terms and Conditions");
						registerAgrivilleObj.ClickMsgDidNotAcceptTC();
						String Str2=testUtil.getTitleOfPage();
						Assert.assertEquals(Str2, "Farming and Agriculture Discussion Forum | Agriville.com","User is not on Agriville Page");
					
					
				} 
				catch (Exception e) 
				{
				
				e.printStackTrace();
				}
			}
		
			
		else
		{
			throw new SkipException("");
		}
		
		S1.assertAll();
		registerAgrivilleObj.clickAgrivilleLogo();
		System.out.println("Terms and Conditions are Mandatory");
	}	
		
		
		@Test(priority=18,dataProvider="getAgrivilleTestData")
		public void verifyCaptcha(String TC_Id, String FName, String LName, String Zip, String UserName, String Password,
				String ConfirmPwd, String Email, String ConfirmEmail) throws InterruptedException
		{
			
			SoftAssert S1=new SoftAssert();
			if(TC_Id.equals("TC_0016"))
			{
				try 
				{
						registerAgrivilleObj.clickRegisterLink();
						registerAgrivilleObj.EnterData(TC_Id, FName, LName, Zip, UserName, Password, ConfirmPwd, Email, ConfirmEmail);
						
						registerAgrivilleObj.clickCompleteRegistrationBtn();
						String Str1=registerAgrivilleObj.MsgCaptcha();
						Assert.assertEquals(Str1, "The string you entered for the image verification did not match what was displayed.","The String Matched without Entering in Captcha Text Box");
						
						
						
				} 
				catch (Exception e) 
				{
				
				e.printStackTrace();
				}
			}
		else
		{
			throw new SkipException("");
		}
		
		S1.assertAll();
		registerAgrivilleObj.clickAgrivilleLogo();
		System.out.println("Capthcha Field is Mandatory");
	}	
		
		
		
		@Test(priority=18,dataProvider="getAgrivilleTestData")
		public void verifySuccessFullRegistration(String TC_Id, String FName, String LName, String Zip, String UserName, String Password,
				String ConfirmPwd, String Email, String ConfirmEmail) throws InterruptedException
		{
			
			SoftAssert S1=new SoftAssert();
			if(TC_Id.equals("TC_0016"))
			{
				try 
				{
						registerAgrivilleObj.clickRegisterLink();
						registerAgrivilleObj.EnterData(TC_Id, FName, LName, Zip, UserName, Password, ConfirmPwd, Email, ConfirmEmail);
						
						registerAgrivilleObj.clickCompleteRegistrationBtn();
						String Str1=registerAgrivilleObj.MsgSuccessFullACReg();
						Assert.assertEquals(Str1, "here","Message for Successful registration do not Match");
						
						
						
				} 
				catch (Exception e) 
				{
				
				e.printStackTrace();
				}
			}
		else
		{
			throw new SkipException("");
		}
		
		S1.assertAll();
		registerAgrivilleObj.clickAgrivilleLogo();
		System.out.println("Agriville Account is Created");
	}		
		
		
		
		
		
		
		
		
		
	@AfterClass
	public void TearDown()
	{
		driver.quit();
	}
	
	
	
}
