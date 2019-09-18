package com.agriville.qa.pages;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.agriville.qa.base.TestBase;
import com.agriville.qa.util.testUtil;

public class registerAgriville extends TestBase 
{

	
	@FindBy(xpath="//div[@class='logo']/a")
	WebElement AgrivilleLogo;
	
	@FindBy(xpath="//input[@id='textfield']")
	WebElement SearchTxtBx;
	
	@FindBy(xpath="//input[@name='submit']")
	WebElement SubmitBtn;
	
	
	@FindBy(xpath="//span[@class='login-links']/a[contains(text(),'Register')]")
	WebElement RegisterLink;
	
	@FindBy(xpath="//h1[contains(text(),'Register')]")
	WebElement H1Register;
	
	@FindBy(xpath="//h2[contains(text(),'Forum Rules')]")
	WebElement H2ForumRules;
	
	@FindBy(xpath="//form[@id='registerform']/div[@class='blockbody formcontrols']/div[@class='section']/div[@class='blockrow']/p[@class='label']")
	WebElement ForumRulesTxt;
	
	@FindBy(xpath="//div[@id='forumrules']/p/strong")
	WebElement TitleForumRules;
	
	
	@FindBy(xpath="//input[@id='cfield_10']")
	WebElement FNameTxtBx;
	
	@FindBy(xpath="//input[@id='cfield_11']")
	WebElement LNameTxtBx;
	
	@FindBy(xpath="//input[@id='cfield_13']")
	WebElement ZipPostalCodeTxtBx;
	
	@FindBy(xpath="//input[@id='regusername']")
	WebElement UserNameTxtBx;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement PasswordTxtBx;
	
	@FindBy(xpath="//input[@id='passwordconfirm']")
	WebElement ConfirmPasswordTxtBx;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement EmailTxtBx;
	
	@FindBy(xpath="//input[@id='emailconfirm']")
	WebElement ConfirmEmailTxtBx;
	
	@FindBy(xpath="//input[@id='imageregt']")
	WebElement CaptchaTxtBx;
	
	@FindBy(xpath="//img[@id='imagereg']")
	WebElement CaptchImg;
	
	@FindBy(xpath="//span[@id='refresh_imagereg']/a")
	WebElement Catchalink;
	
	@FindBy(xpath="//input[@id='cb_rules_agree']")
	WebElement ForumRulesChkBx;
	
	@FindBy(xpath="//div[@class='group']/input[@type='submit']")
	WebElement CompleteRegistrationBtn;
	
	@FindBy(xpath="//div[@class='group']/input[@type='reset']")
	WebElement ResetBtnLP;
	
	@FindBy(xpath="c")
	WebElement NoteDescUserName;
	
	@FindBy(xpath="//p[@class='description'][contains(text(),'Please enter a password for your user account. Note that passwords are case-sensitive.')]")
	WebElement NoteDescConfirmPwd;
	
	@FindBy(xpath="//p[@class='description'][contains(text(),'Please enter a valid email address for yourself.')]")
	WebElement NoteDescConfirmEmail;
	
	@FindBy(xpath="//p[@class='description'][contains(text(),'Please enter the six letters or digits that appear in the image opposite.')]")
	WebElement NoteImageVerification;
	
	@FindBy(xpath="//strong[contains(text(),'I have read, and agree to abide by the Farming and')]")
	WebElement TxtIAgree;
	
	@FindBy(xpath="//b[contains(text(),'Contact us:')]")
	WebElement TxtQuestions;
	
	@FindBy(xpath="//b/a[contains(text(),'agriville@farms.com')]")
	WebElement EmailTo;
	
	@FindBy(xpath="//h1[contains(text(),'The following errors occurred during your registration')]")
	WebElement H1ErrorsRegistration;
	
	
	@FindBy(xpath="//li[contains(text(),'You have left a required field blank.')]")
	WebElement MsgRequiredFieldsBlank;
	
	@FindBy(xpath="//li[contains(text(),'Please complete the required field \"Email\".')]")
	WebElement MsgEmail;
	
	@FindBy(xpath="//li[contains(text(),'The two email addresses that you entered do not match.')]")
	WebElement MsgTwoMisMatchEmail;
	
	@FindBy(xpath="//li[contains(text(),'You entered an invalid email address.')]")
	WebElement MsgInvalidEmail;
	
	
	@FindBy(xpath="//li[contains(text(),'Please complete the required field \"Username\".')]")
	WebElement MsgUserName;
	
	@FindBy(xpath="//li[contains(text(),'The string you entered for the image verification did not match what was displayed.')]")
	WebElement MsgCaptcha;
	
	@FindBy(xpath="//li/em[contains(text(),'First Name')]")
	WebElement MsgFName;
	
	@FindBy(xpath="//li/em[contains(text(),'Last Name')]")
	WebElement MsgLName;
	
	@FindBy(xpath="//li/em[contains(text(),'Zip / Postal Code')]")
	WebElement MsgZipPostal;
	
	@FindBy(xpath="li[contains(text(),'You did not enter the correct format for the Zip / Postal Code field.')]")
	WebElement MsgInvalidZip;
	
	@FindBy(xpath="//li[contains(text(),'Your username cannot be shorter than 3 characters.')]")
	WebElement MsgTopforShortUserName;
	
	@FindBy(xpath="//div[@id='reg_verif_div']")
	WebElement MsgShortUserNameTBX;
	
	@FindBy(xpath="//div[@id='reg_verif_div']")
	WebElement MsgExistingUserName;
	
	@FindBy(xpath="//div[@id='reg_verif_div']")
	WebElement MsgUserNameTBX;
	
	@FindBy(xpath="//div[@class='blockrow restore']/a")
	WebElement HereClick;
	
	@FindBy(xpath="//h1[contains(text(),'Message')]")
	WebElement H1MsgAfterRegistration;
	
	@FindBy(xpath="//h1[contains(text(),'Lost Password Recovery Form')]")
	WebElement H1LostPassword;
	
	@FindBy(xpath="//div[@id='reg_verif_div']/a")
	WebElement TopClickHere;
	
	@FindBy(xpath="//div[@id='reg_verif_div']//a[contains(text(),'here')]")
	WebElement TBXClickHere;
	
	@FindBy(xpath="//div[@class='blockrow restore']/a")
	WebElement MsgDidNotAcceptTC;
	
@FindBy(xpath="//div[@class='blockrow restore']/a")
WebElement MsgSuccessFullACReg;
	
	
	
	
	
	
	
	public registerAgriville()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public void clickRegisterLink()
	{
		RegisterLink.click();
	}
	
	
	public ArrayList<Boolean> FieldsOnRegistrationPage()
	{
		ArrayList<Boolean> listObj=new ArrayList<Boolean>();
		listObj.add(AgrivilleLogo.isDisplayed());
		listObj.add(SearchTxtBx.isDisplayed());
		listObj.add(SubmitBtn.isDisplayed());
		listObj.add(FNameTxtBx.isDisplayed());
		listObj.add(LNameTxtBx.isDisplayed());
		listObj.add(ZipPostalCodeTxtBx.isDisplayed());
		listObj.add(UserNameTxtBx.isDisplayed());
		listObj.add(PasswordTxtBx.isDisplayed());
		listObj.add(ConfirmPasswordTxtBx.isDisplayed());
		listObj.add(EmailTxtBx.isDisplayed());
		listObj.add(ConfirmEmailTxtBx.isDisplayed());
		listObj.add(CaptchaTxtBx.isDisplayed());
		listObj.add(CaptchImg.isDisplayed());
		listObj.add(Catchalink.isDisplayed());
		listObj.add(Catchalink.isEnabled());
		listObj.add(ForumRulesChkBx.isDisplayed());
		listObj.add(ForumRulesChkBx.isSelected());
		listObj.add(CompleteRegistrationBtn.isDisplayed());
		listObj.add(ResetBtnLP.isDisplayed());
		listObj.add(EmailTo.isDisplayed());
		listObj.add(EmailTo.isEnabled());
		return listObj;	
		
	}
	
	public String H1Register()
	{
		return H1Register.getText().trim();
	}
	
	public String H2ForumRules()
	{
		return H2ForumRules.getText().trim();
	}
	
	public String ForumRulesTxt()
	{
		return ForumRulesTxt.getText().trim();
	}
	
	public String TitleForumRules()
	{
		return TitleForumRules.getText().trim();
	}
	
	public String NoteDescUserName()
	{
		return NoteDescUserName.getText().trim();
	}
	
	
	public String NoteDescConfirmPwd()
	{
		return NoteDescConfirmPwd.getText().trim();
	}
	
	public String NoteImageVerification()
	{
		return NoteImageVerification.getText().trim();
	}
	
	public String NoteDescConfirmEmail()
	{
		return NoteDescConfirmEmail.getText().trim();
	}
	
	public String TxtIAgree()
	{
		return TxtIAgree.getText().trim();
	}
	
	public String TxtQuestions()
	{
		return TxtQuestions.getText().trim();
	}
	public String EmailTo()
	{
		return EmailTo.getText().trim();
	}
	
	
	public void EnterPwd()
	{
		PasswordTxtBx.sendKeys("Test1234");
	}
	
	public void EnterConfirmPwd()
	{
		ConfirmPasswordTxtBx.sendKeys("Test1234");
	}
	
	
	public void InvalidEnterPwd()
	{
		PasswordTxtBx.sendKeys("PQRSTUV");
	}
	
	public void InvalidConfirmPwd()
	{
		ConfirmPasswordTxtBx.sendKeys("AbCDEFGH");
	}
	
	
	
	public void clickCompleteRegistrationBtn()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",CompleteRegistrationBtn);
		
		
	}
	
	public String H1ErrorsRegistration()
	{
		testUtil.waitForElement(H1ErrorsRegistration);
		return H1ErrorsRegistration.getText().trim();
	}
	
	
	
	
	public String MsgRequiredFieldsBlank()
	{
		testUtil.waitForElement(MsgRequiredFieldsBlank);
		return MsgRequiredFieldsBlank.getText().trim();
	}
	
	public String MsgEmail()
	{
		testUtil.waitForElement(MsgEmail);
		return MsgEmail.getText().trim();
	}
	
	public String MsgUserName()
	{
		testUtil.waitForElement(MsgUserName);
		return MsgUserName.getText().trim();
	}
	
	public String MsgCaptcha()
	{
		testUtil.waitForElement(MsgCaptcha);
		return MsgCaptcha.getText().trim();
	}
	
	public String MsgFName()
	{
		testUtil.waitForElement(MsgFName);
		return MsgFName.getText().trim();
	}
	
	public String MsgLName()
	{
		testUtil.waitForElement(MsgLName);
		return MsgLName.getText().trim();
	}
	
	public String MsgZipPostal()
	{
		testUtil.waitForElement(MsgZipPostal);
		return MsgZipPostal.getText().trim();
	}
	
	public String MsgInvalidZip()
	{
		testUtil.waitForElement(MsgInvalidZip);
		return MsgInvalidZip.getText().trim();
		
	}
	
	public void EnterData(String TC_Id, String fname, String lname, String zip, String username, String password,
			String confirmpwd, String email, String confirmemail)
	{
		FNameTxtBx.sendKeys(fname);
		LNameTxtBx.sendKeys(lname);
		ZipPostalCodeTxtBx.sendKeys(zip);
		UserNameTxtBx.sendKeys(username);
		PasswordTxtBx.sendKeys(password);
		ConfirmPasswordTxtBx.sendKeys(confirmpwd);
		EmailTxtBx.sendKeys(email);
		ConfirmEmailTxtBx.sendKeys(confirmemail);
		
		
	}
	
	public void HereClick()
	{
		HereClick.click();
	}
	
	public String H1MsgAfterRegistration()
	{
		testUtil.waitForElement(H1MsgAfterRegistration);
		return H1MsgAfterRegistration.getText().trim();
	}
	
	public void clickAgrivilleLogo()
	{
		AgrivilleLogo.click();
	}
	
	
	public String MsgTopforShortUserName()
	{
		testUtil.waitForElement(MsgTopforShortUserName);
		return MsgTopforShortUserName.getText().trim();
	}
	
	public String MsgShortUserName()
	{
		testUtil.waitForElement(MsgShortUserNameTBX);
		return MsgShortUserNameTBX.getText().trim();
	}
	
	public String MsgExistingUserName()
	{
		testUtil.waitForElement(MsgExistingUserName);
		return MsgExistingUserName.getText().trim();
	}
	
	
	public String MsgUserNameTBX()
	{
		testUtil.waitForElement(MsgUserNameTBX);
		return MsgUserNameTBX.getText().trim().substring(0,79);
	}
	
	
	public String H1LostPassword()
	{
		testUtil.waitForElement(H1LostPassword);
		return H1LostPassword.getText().trim();
	}
	
	public void ClickTBXClickHere()
	{
		TBXClickHere.click();
	}
	
	
	public String MsgTwoMisMatchEmail()
	{
		testUtil.waitForElement(MsgTwoMisMatchEmail);
		return MsgTwoMisMatchEmail.getText().trim();
	}
	
	public String MsgInvalidEmail()
	{
		testUtil.waitForElement(MsgInvalidEmail);
		return MsgInvalidEmail.getText().trim();
	}
	
	
	public void ClickTopClickHere()
	{
		TopClickHere.click();
	}
	
	
	public void UnCheckForumRulesChkBx()
	{
		ForumRulesChkBx.click();
	}
	
	public String MsgDidNotAcceptTC()
	{
		testUtil.waitForElement(MsgDidNotAcceptTC);
		return MsgDidNotAcceptTC.getText().trim();
	}
	
	public void ClickMsgDidNotAcceptTC()
	{
		MsgDidNotAcceptTC.click();
	}
	
	public String MsgSuccessFullACReg()
	{
		testUtil.waitForElement(MsgSuccessFullACReg);
		return MsgSuccessFullACReg.getText().trim();
	}
}

