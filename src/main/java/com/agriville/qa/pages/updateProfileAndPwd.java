package com.agriville.qa.pages;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.agriville.qa.base.TestBase;
import com.agriville.qa.util.testUtil;

public class updateProfileAndPwd extends TestBase 
{
	public updateProfileAndPwd()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//a[contains(text(),'Update Profile')]")
	WebElement updateProfileLink;
	
	@FindBy(xpath="//span[@id='login_toggle1']//a//img")
	WebElement downArrow;
	
	@FindBy(xpath="//div[@class='editor-title']")
	WebElement HeaderEditProfile;
	
	@FindBy(xpath="//div[@class='titlebar']/h1")
	WebElement H1EditProfile;
	
	@FindBy(xpath="//input[@type='submit'][@value='Edit Password']")
	WebElement BtnEditPwd;
	
	@FindBy(xpath="//input[@id='cfield_10']")
	WebElement TxtBxFName;
	
	@FindBy(xpath="//input[@id='cfield_11']")
	WebElement TxtBxLName;
	
	@FindBy(xpath="//input[@id='cfield_13']")
	WebElement TxtBxZip;
	
	@FindBy(xpath="//input[@type='submit'][@value='Save Changes']")
	WebElement BtnSaveChanges;
	
	@FindBy(xpath="//input[@type='reset'][@value='Reset Fields']")
	WebElement BtnResetFields;
	
	@FindBy(xpath="//div[@class='editor-title']")
	WebElement HeaderEditPwd;
	
	@FindBy(xpath="//h1[contains(text(),'Edit Password')]")
	WebElement H1EditPwd;
	
	@FindBy(xpath="//input[@id='currentpassword']")
	WebElement TxtBxCurrentPwd;
	
	@FindBy(xpath="//input[@id='newpassword']")
	WebElement TxtBxNewPwd;
	
	@FindBy(xpath="//input[@id='newpasswordconfirm']")
	WebElement TxtBxConfirmPwd;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement TxtBxEmail;
	
	@FindBy(xpath="//div[@class='blockrow restore']/em")
	WebElement MsgNoDataUniversal;
	
	@FindBy(xpath="//h1[contains(text(),'Message')]")
	WebElement H1Msg;
	
	@FindBy(xpath="//div[@class='blockrow restore']")
	WebElement MsgInvalidZip;
	
	@FindBy(xpath="//div[@class='blockrow restore']")
	WebElement MsgPasswordValidation;
	
	

	
	
	//Actions
	
	public void clickupdateProfileLink()
	{
		testUtil.ElementIsClickable(updateProfileLink);
		updateProfileLink.click();
	}
	
	public void clickdownArrow()
	{
		testUtil.ElementIsClickable(downArrow);
		downArrow.click();
	}
	
	public String HeaderEditProfile()
	{
		return HeaderEditProfile.getText().trim();
	}
	
	public String H1EditProfile()
	{
		return H1EditProfile.getText().trim();
	}
	
	
	public ArrayList<Boolean> EditProfilePageElements()
	{
		ArrayList<Boolean> listObj=new ArrayList<>();
		listObj.add(BtnEditPwd.isDisplayed());
		listObj.add(TxtBxFName.isDisplayed());
		listObj.add(TxtBxLName.isDisplayed());
		listObj.add(TxtBxZip.isDisplayed());
		listObj.add(BtnSaveChanges.isDisplayed());
		listObj.add(BtnResetFields.isDisplayed());
		return listObj;
		
	}
	
	public void clickBtnEditPwd()
	{
		testUtil.ElementIsClickable(BtnEditPwd);
		BtnEditPwd.click();
	}
	
	public String HeaderEditPwd()
	{
		return HeaderEditPwd.getText().trim();
	}
	
	public String H1EditPwd()
	{
		return H1EditPwd.getText().trim();
	}
	
	
	public ArrayList<Boolean> EditPasswordPageElements()
	{
		ArrayList<Boolean> listObj=new ArrayList<>();
		listObj.add(TxtBxCurrentPwd.isDisplayed());
		listObj.add(TxtBxNewPwd.isDisplayed());
		listObj.add(TxtBxConfirmPwd.isDisplayed());
		listObj.add(TxtBxEmail.isDisplayed());
		listObj.add(BtnSaveChanges.isDisplayed());
		listObj.add(BtnResetFields.isDisplayed());
		return listObj;
		
	}
	
	
	public String MsgNoDataUniversal()
	{
		return MsgNoDataUniversal.getText().trim();
	}
	
	public void clearTxtBxFName()
	{
		TxtBxFName.clear();
	}
	
	public String valueTxtBxFName()
	{
		return TxtBxFName.getAttribute("value");
		
	}
	
	public String valueTxtBxLName()
	{
		return TxtBxLName.getAttribute("value");
		
	}
	
	public String valueTxtBxZip()
	{
		return TxtBxZip.getAttribute("value");
		
	}
	
	public void clearTxtBxLName()
	{
		TxtBxLName.clear();
	}
	
	
	
	public void clearTxtBxZip()
	{
		TxtBxZip.clear();
	}
	
	public void clickBtnSaveChanges()
	{
		testUtil.ElementIsClickable(BtnSaveChanges);
		BtnSaveChanges.click();
	}
	
	public String H1Msg()
	{
		return H1Msg.getText().trim();
	}
	
	public void clickBtnResetFields()
	{
		testUtil.ElementIsClickable(BtnResetFields);
		BtnResetFields.click();
	}
	
	
	public String MsgInvalidZip()
	{
		return MsgInvalidZip.getText().trim();
	}
	
//	public void invalidZip()
//	{
//		TxtBxZip.clear();
//		TxtBxZip.sendKeys("123456789");
//	}
	
	public void FName(String fname)
	{
		testUtil.ElementIsDisplayed(TxtBxFName);
		TxtBxFName.clear();
		TxtBxFName.sendKeys(fname);
	}
	
	public void LName(String lname)
	{
		testUtil.ElementIsDisplayed(TxtBxLName);
		TxtBxLName.clear();
		TxtBxLName.sendKeys(lname);
	}
	
	public void ZipCode(String zipcode)
	{
		testUtil.ElementIsDisplayed(TxtBxZip);
		TxtBxZip.clear();
		TxtBxZip.sendKeys(zipcode);
	}
	
	public void CurrentPwd(String currentpwd)
	{
		testUtil.ElementIsDisplayed(TxtBxCurrentPwd);
		TxtBxCurrentPwd.clear();
		TxtBxCurrentPwd.sendKeys(currentpwd);
	}
	
	
	public void NewPwd(String newpwd)
	{
		testUtil.ElementIsDisplayed(TxtBxNewPwd);
		TxtBxNewPwd.clear();
		TxtBxNewPwd.sendKeys(newpwd);
	}
	
	
	public void ConfirmPwd(String confirmPwd)
	{
		testUtil.ElementIsDisplayed(TxtBxConfirmPwd);
		TxtBxConfirmPwd.clear();
		TxtBxConfirmPwd.sendKeys(confirmPwd);
	}
	
	public String MsgCurrentPasswordValidation()
	{
		return MsgPasswordValidation.getText().substring(0, 62);
	}
	
	public String MsgPasswordValidation()
	{
		return MsgPasswordValidation.getText().substring(0, 48);
	}
	
	
}
