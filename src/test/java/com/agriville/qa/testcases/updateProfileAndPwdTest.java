package com.agriville.qa.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.agriville.qa.base.TestBase;
import com.agriville.qa.pages.AddEditDeleteReply;
import com.agriville.qa.pages.AddEditDeleteTopic;
import com.agriville.qa.pages.LatestPost;
import com.agriville.qa.pages.loginPage;
import com.agriville.qa.pages.searchTopic;
import com.agriville.qa.pages.topicDetails;
import com.agriville.qa.pages.updateProfileAndPwd;
import com.agriville.qa.util.ExcelDataUtil;
import com.agriville.qa.util.testUtil;

public class updateProfileAndPwdTest extends TestBase
{
	
	topicDetails topicDetailsObj;
	ExcelDataUtil ExcelDataUtilObj;
	loginPage loginPageObj;
	AddEditDeleteTopic AddEditDeleteTopicObj;
	searchTopic searchTopicObj;
	testUtil testUtilObj;
	LatestPost LatestPostObj;
	updateProfileAndPwd updateProfileAndPwdObj;
	
	AddEditDeleteReply AddEditDeleteReplyObj;
	String Path = "E://Script Agriville//AgrivilleTest//src//main//java//com//agriville//qa//testdata//Agriville.xlsx";
	String sheetName = "Disc_Categories";
	String sheetName1 = "Disc_CategoriesLogin";
	String sheetName2 = "PostThread";
	String sheetName3 = "Reply";
	String sheetName4 = "EditProfile";
	String sheetName5 = "EditPassword";

	public updateProfileAndPwdTest()
	{
		super();
	}
	
	@BeforeClass
	public void SetUp() 
	{
		intialization();
		topicDetailsObj = new topicDetails();
		searchTopicObj = new searchTopic();
		// testUtilObj=new testUtil();
		loginPageObj = new loginPage();
		testUtilObj = new testUtil();
		AddEditDeleteReplyObj = new AddEditDeleteReply();
		ExcelDataUtilObj = new ExcelDataUtil(Path);
		AddEditDeleteTopicObj = new AddEditDeleteTopic();
		LatestPostObj=new LatestPost();
		updateProfileAndPwdObj= new updateProfileAndPwd();
	}

	
	//Verify Edit Profile Page
	//Navigate to Update Profile page and verify the Edit Profile Page
	@Test(priority=1)
	public void EditProfilePage() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		updateProfileAndPwdObj.clickdownArrow();
		updateProfileAndPwdObj.clickupdateProfileLink();
		String HeaderEditProfile=updateProfileAndPwdObj.HeaderEditProfile();
		S1.assertEquals(HeaderEditProfile,"EDIT PROFILE");
		String H1EditProfile=updateProfileAndPwdObj.H1EditProfile();
		S1.assertTrue(H1EditProfile.contains("Edit Profile"));
		
		for(int i=0;i<updateProfileAndPwdObj.EditProfilePageElements().size();i++)
		{
			S1.assertTrue(updateProfileAndPwdObj.EditProfilePageElements().get(i));
		}
		testUtilObj.logOut();
		S1.assertAll();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified Edit Profile Page");
	
		
	}
	
	//Verify Edit Password Page
	//Navigate to Update Profile page-->Click On Edit Password Page and Verify the Edit password Page
	@Test(priority=2)
	public void EditPasswordPage() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		updateProfileAndPwdObj.clickdownArrow();
		updateProfileAndPwdObj.clickupdateProfileLink();
		updateProfileAndPwdObj.clickBtnEditPwd();
		String HeaderEditPwd=updateProfileAndPwdObj.HeaderEditPwd();
		S1.assertEquals(HeaderEditPwd,"EDIT PASSWORD");
		String H1EditPwd=updateProfileAndPwdObj.H1EditPwd();
		S1.assertEquals(H1EditPwd,"Edit Password");
		
		for(int i=0;i<updateProfileAndPwdObj.EditPasswordPageElements().size();i++)
		{
			S1.assertTrue(updateProfileAndPwdObj.EditPasswordPageElements().get(i));
		}
		testUtilObj.logOut();
		S1.assertAll();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("Verified Edit Password Page");
	}	
	
	//Verify First Name field
	//Navigate to Update Profile Page-->Click On Edit Profile Page
	@Test(priority=3)
	public void verifyFirstName() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		updateProfileAndPwdObj.clickdownArrow();
		updateProfileAndPwdObj.clickupdateProfileLink();
		String BeforeUpdateFName=updateProfileAndPwdObj.valueTxtBxFName();
		updateProfileAndPwdObj.clearTxtBxFName();
		updateProfileAndPwdObj.clickBtnSaveChanges();
		String H1MsgFName=updateProfileAndPwdObj.H1Msg();
		S1.assertEquals(H1MsgFName,"Message");
		String MsgNoDataFName=updateProfileAndPwdObj.MsgNoDataUniversal();
		S1.assertEquals(MsgNoDataFName,"First Name");
		testUtil.navigateToPreviouPage();
		updateProfileAndPwdObj.clickBtnResetFields();
		String AfterUpdateFName=updateProfileAndPwdObj.valueTxtBxFName();
		S1.assertEquals(BeforeUpdateFName, AfterUpdateFName);
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Verified First Name is Mandatory");
	}
	
		
	//Verify Last Name field
	//Navigate to Update Profile Page-->Click On Edit Profile Page
	@Test(priority=4)
	public void verifyLastName() throws InterruptedException
	{
		
		SoftAssert S1=new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		updateProfileAndPwdObj.clickdownArrow();
		updateProfileAndPwdObj.clickupdateProfileLink();
		String BeforeUpdateLName=updateProfileAndPwdObj.valueTxtBxLName();
		updateProfileAndPwdObj.clearTxtBxLName();
		updateProfileAndPwdObj.clickBtnSaveChanges();
		String H1MsgLName=updateProfileAndPwdObj.H1Msg();
		S1.assertEquals(H1MsgLName,"Message");
		String MsgNoDataLName=updateProfileAndPwdObj.MsgNoDataUniversal();
		S1.assertEquals(MsgNoDataLName,"Last Name");
		testUtil.navigateToPreviouPage();
		updateProfileAndPwdObj.clickBtnResetFields();
		String AfterUpdateLName=updateProfileAndPwdObj.valueTxtBxLName();
		S1.assertEquals(BeforeUpdateLName, AfterUpdateLName);
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Verified Last Name is Mandatory");
	}
	
	
	
	
	//Verify Zip Code field
	//Navigate to Update Profile Page-->Click On Edit Profile Page
	@Test(priority=5)
	public void verifyZipCode() throws InterruptedException
	{
		
		SoftAssert S1=new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		updateProfileAndPwdObj.clickdownArrow();
		updateProfileAndPwdObj.clickupdateProfileLink();
		String BeforeUpdateZip=updateProfileAndPwdObj.valueTxtBxZip();
		updateProfileAndPwdObj.clearTxtBxZip();
		updateProfileAndPwdObj.clickBtnSaveChanges();
		String H1MsgZip=updateProfileAndPwdObj.H1Msg();
		S1.assertEquals(H1MsgZip,"Message");
		String MsgNoDataZipCode=updateProfileAndPwdObj.MsgNoDataUniversal();
		S1.assertEquals(MsgNoDataZipCode,"Zip / Postal Code");
		testUtil.navigateToPreviouPage();
		updateProfileAndPwdObj.clickBtnResetFields();
		String AfterUpdateZip=updateProfileAndPwdObj.valueTxtBxZip();
		S1.assertEquals(BeforeUpdateZip, AfterUpdateZip);
		
		String BeforeInvalidZip=updateProfileAndPwdObj.valueTxtBxZip();
		updateProfileAndPwdObj.ZipCode(ExcelDataUtilObj.getData(sheetName4, 1, 2));
		updateProfileAndPwdObj.clickBtnSaveChanges();
		String invalidZip=updateProfileAndPwdObj.MsgInvalidZip();
		S1.assertEquals(invalidZip, "You did not enter the correct format for the Zip / Postal Code field.");
		testUtil.navigateToPreviouPage();
		updateProfileAndPwdObj.clickBtnResetFields();
		String AfterInvalidZip=updateProfileAndPwdObj.valueTxtBxZip();
		S1.assertEquals(BeforeInvalidZip, AfterInvalidZip);
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Verified Zip Code is Mandatory");
		
		
		
	}
	//Verify Save Changes Button is updating the Profile Details
	//Navigate to Update Profile Page-->Click On Edit Profile Page
	//Enter Data and Click on Save Changes Button
	@Test(priority=6)
	public void verifyUpdateProfile() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		updateProfileAndPwdObj.clickdownArrow();
		updateProfileAndPwdObj.clickupdateProfileLink();
		updateProfileAndPwdObj.FName(ExcelDataUtilObj.getData(sheetName4, 2, 0));
		updateProfileAndPwdObj.LName(ExcelDataUtilObj.getData(sheetName4, 2, 1));
		updateProfileAndPwdObj.ZipCode(ExcelDataUtilObj.getData(sheetName4, 2, 2));
		String FNameBE=ExcelDataUtilObj.getData(sheetName4, 2, 0);
		String LNameBE=(ExcelDataUtilObj.getData(sheetName4, 2, 1));
		String ZipCodeBE=ExcelDataUtilObj.getData(sheetName4, 2, 2);
		updateProfileAndPwdObj.clickBtnSaveChanges();
		updateProfileAndPwdObj.clickBtnResetFields();
		String FNameAE=updateProfileAndPwdObj.valueTxtBxFName();
		String LNameAE=updateProfileAndPwdObj.valueTxtBxLName();
		String ZipCodeAE=updateProfileAndPwdObj.valueTxtBxZip();
		S1.assertEquals(FNameBE, FNameAE);
		S1.assertEquals(LNameBE, LNameAE);
		S1.assertEquals(ZipCodeBE, ZipCodeAE);
		loginPageObj.clickAgrivilleLogo();
		updateProfileAndPwdObj.clickdownArrow();
		updateProfileAndPwdObj.clickupdateProfileLink();
		updateProfileAndPwdObj.FName(ExcelDataUtilObj.getData(sheetName4, 3, 0));
		updateProfileAndPwdObj.LName(ExcelDataUtilObj.getData(sheetName4, 3, 1));
		updateProfileAndPwdObj.ZipCode(ExcelDataUtilObj.getData(sheetName4, 3, 2));
		updateProfileAndPwdObj.clickBtnSaveChanges();
		testUtilObj.logOut();
		loginPageObj.clickAgrivilleLogo();
		S1.assertAll();
		System.out.println("Verified the Profile is Updated Successfully");
		
	}
	
	//Verify Current Password
	//Current Password Validation needs to be Implemented
	//for e.g. Password should be combination with numbers and Letters with one upper case
	@Test(priority=7)
	public void verifyCurrentPwd() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		updateProfileAndPwdObj.clickdownArrow();
		updateProfileAndPwdObj.clickupdateProfileLink();
		updateProfileAndPwdObj.clickBtnEditPwd();
		
		updateProfileAndPwdObj.CurrentPwd(ExcelDataUtilObj.getData(sheetName5, 1, 0));
		updateProfileAndPwdObj.NewPwd(ExcelDataUtilObj.getData(sheetName5, 1, 1));
		updateProfileAndPwdObj.ConfirmPwd(ExcelDataUtilObj.getData(sheetName5, 1, 2));
		
		updateProfileAndPwdObj.clickBtnSaveChanges();
		String MsgCurrentPassword=updateProfileAndPwdObj.MsgCurrentPasswordValidation();
		S1.assertEquals(MsgCurrentPassword, "The password you have entered does not match your current one.");
		S1.assertAll();
	}
	
	//Verify New Password
	//New Password Validation needs to be Implemented for Blank New Password
	@Test(priority=8)
	public void verifyNewPwd() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		updateProfileAndPwdObj.clickdownArrow();
		updateProfileAndPwdObj.clickupdateProfileLink();
		updateProfileAndPwdObj.clickBtnEditPwd();

		
		//I will remove the comments once the Code is Updated on Staging and Production
		//The Site is not updated for Blank New Password
		
		
//		updateProfileAndPwdObj.CurrentPwd(ExcelDataUtilObj.getData(sheetName5, 3, 0));
//		updateProfileAndPwdObj.NewPwd(ExcelDataUtilObj.getData(sheetName5, 3, 1));
//		updateProfileAndPwdObj.ConfirmPwd(ExcelDataUtilObj.getData(sheetName5, 3, 2));
//		updateProfileAndPwdObj.clickBtnSaveChanges();
//		String MsgCurrentPassword1=updateProfileAndPwdObj.MsgPasswordValidation();
//		S1.assertEquals(MsgCurrentPassword1, "The two passwords that you entered do not match.");
//		testUtil.navigateToPreviouPage();
		
		
	
		updateProfileAndPwdObj.CurrentPwd(ExcelDataUtilObj.getData(sheetName5, 4, 0));
		updateProfileAndPwdObj.NewPwd(ExcelDataUtilObj.getData(sheetName5, 4, 1));
		updateProfileAndPwdObj.ConfirmPwd(ExcelDataUtilObj.getData(sheetName5, 4, 2));
		updateProfileAndPwdObj.clickBtnSaveChanges();
		String MsgCurrentPassword2=updateProfileAndPwdObj.MsgPasswordValidation();
		S1.assertEquals(MsgCurrentPassword2, "The two passwords that you entered do not match.");
		testUtil.navigateToPreviouPage();
		
		
		updateProfileAndPwdObj.CurrentPwd(ExcelDataUtilObj.getData(sheetName5, 5, 0));
		updateProfileAndPwdObj.NewPwd(ExcelDataUtilObj.getData(sheetName5, 5, 1));
		updateProfileAndPwdObj.ConfirmPwd(ExcelDataUtilObj.getData(sheetName5, 5, 2));
		updateProfileAndPwdObj.clickBtnSaveChanges();
		String MsgCurrentPassword3=updateProfileAndPwdObj.MsgPasswordValidation();
		S1.assertEquals(MsgCurrentPassword3, "The two passwords that you entered do not match.");
		testUtil.navigateToPreviouPage();
		
		
		updateProfileAndPwdObj.CurrentPwd(ExcelDataUtilObj.getData(sheetName5, 6, 0));
		updateProfileAndPwdObj.NewPwd(ExcelDataUtilObj.getData(sheetName5, 6, 1));
		updateProfileAndPwdObj.ConfirmPwd(ExcelDataUtilObj.getData(sheetName5, 6, 2));
		updateProfileAndPwdObj.clickBtnSaveChanges();
		String MsgCurrentPassword4=updateProfileAndPwdObj.MsgPasswordValidation();
		S1.assertEquals(MsgCurrentPassword4, "The two passwords that you entered do not match.");
		testUtil.navigateToPreviouPage();
		testUtilObj.logOut();
		S1.assertAll();
		System.out.println("Verified New Password");
	}
	
	
	
	
	@Test(priority=9)
	public void verifyConfirmPwd() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		updateProfileAndPwdObj.clickdownArrow();
		updateProfileAndPwdObj.clickupdateProfileLink();
		updateProfileAndPwdObj.clickBtnEditPwd();
		updateProfileAndPwdObj.CurrentPwd(ExcelDataUtilObj.getData(sheetName5, 7, 0));
		updateProfileAndPwdObj.NewPwd(ExcelDataUtilObj.getData(sheetName5, 7, 1));
		updateProfileAndPwdObj.ConfirmPwd(ExcelDataUtilObj.getData(sheetName5, 7, 2));
		updateProfileAndPwdObj.clickBtnSaveChanges();
		String MsgCurrentPassword1=updateProfileAndPwdObj.MsgPasswordValidation();
		S1.assertEquals(MsgCurrentPassword1, "The two passwords that you entered do not match.");
		testUtil.navigateToPreviouPage();
		updateProfileAndPwdObj.CurrentPwd(ExcelDataUtilObj.getData(sheetName5, 8, 0));
		updateProfileAndPwdObj.NewPwd(ExcelDataUtilObj.getData(sheetName5, 8, 1));
		updateProfileAndPwdObj.ConfirmPwd(ExcelDataUtilObj.getData(sheetName5, 8, 2));
		updateProfileAndPwdObj.clickBtnSaveChanges();
		String MsgCurrentPassword2=updateProfileAndPwdObj.MsgPasswordValidation();
		S1.assertEquals(MsgCurrentPassword2, "The two passwords that you entered do not match.");
		testUtil.navigateToPreviouPage();
		updateProfileAndPwdObj.CurrentPwd(ExcelDataUtilObj.getData(sheetName5, 9, 0));
		updateProfileAndPwdObj.NewPwd(ExcelDataUtilObj.getData(sheetName5, 9, 1));
		updateProfileAndPwdObj.ConfirmPwd(ExcelDataUtilObj.getData(sheetName5, 9, 2));
		updateProfileAndPwdObj.clickBtnSaveChanges();
		String MsgCurrentPassword3=updateProfileAndPwdObj.MsgPasswordValidation();
		S1.assertEquals(MsgCurrentPassword3, "The two passwords that you entered do not match.");
		testUtil.navigateToPreviouPage();
		updateProfileAndPwdObj.CurrentPwd(ExcelDataUtilObj.getData(sheetName5, 10, 0));
		updateProfileAndPwdObj.NewPwd(ExcelDataUtilObj.getData(sheetName5, 10, 1));
		updateProfileAndPwdObj.ConfirmPwd(ExcelDataUtilObj.getData(sheetName5, 10, 2));
		updateProfileAndPwdObj.clickBtnSaveChanges();
		String MsgCurrentPassword4=updateProfileAndPwdObj.MsgPasswordValidation();
		S1.assertEquals(MsgCurrentPassword4, "The two passwords that you entered do not match.");
		testUtil.navigateToPreviouPage();
		testUtilObj.logOut();
		S1.assertAll();
		System.out.println("Verified Confirm Password");
	}
	
	
	
	@Test(priority=10)
	public void verifyUpdatePwd() throws InterruptedException
	{
		SoftAssert S1=new SoftAssert();
		testUtilObj.loginWithActiveAccount();
		updateProfileAndPwdObj.clickdownArrow();
		updateProfileAndPwdObj.clickupdateProfileLink();
		updateProfileAndPwdObj.clickBtnEditPwd();
		
		updateProfileAndPwdObj.CurrentPwd(ExcelDataUtilObj.getData(sheetName5, 11, 0));
		updateProfileAndPwdObj.NewPwd(ExcelDataUtilObj.getData(sheetName5, 11, 1));
		updateProfileAndPwdObj.ConfirmPwd(ExcelDataUtilObj.getData(sheetName5, 11, 2));
		updateProfileAndPwdObj.clickBtnSaveChanges();
		
		String H1EditProfile=updateProfileAndPwdObj.H1EditProfile();
		S1.assertTrue(H1EditProfile.contains("Edit Profile"));
		String HeaderEditProfile=updateProfileAndPwdObj.HeaderEditProfile();
		S1.assertEquals(HeaderEditProfile,"EDIT PROFILE");
		
		updateProfileAndPwdObj.clickBtnEditPwd();
		updateProfileAndPwdObj.CurrentPwd(ExcelDataUtilObj.getData(sheetName5, 12, 0));
		updateProfileAndPwdObj.NewPwd(ExcelDataUtilObj.getData(sheetName5, 12, 1));
		updateProfileAndPwdObj.ConfirmPwd(ExcelDataUtilObj.getData(sheetName5, 12, 2));
		updateProfileAndPwdObj.clickBtnSaveChanges();
		
		
		
		for(int i=0;i<updateProfileAndPwdObj.EditProfilePageElements().size();i++)
		{
			S1.assertTrue(updateProfileAndPwdObj.EditProfilePageElements().get(i));
		}
		testUtilObj.logOut();
		S1.assertAll();
		loginPageObj.clickAgrivilleLogo();
		System.out.println("Password is updated Successfully");
		
		
		
		
		
	}
	
	
	
	@AfterClass
	public void TearDown()
	{
		driver.quit();
	}
}
