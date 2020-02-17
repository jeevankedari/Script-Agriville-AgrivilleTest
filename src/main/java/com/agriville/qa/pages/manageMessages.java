package com.agriville.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.agriville.qa.base.TestBase;
import com.agriville.qa.util.testUtil;

public class manageMessages extends TestBase
{
	
	public manageMessages()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h2[contains(text(),'Your Message')]")
	WebElement h1YourMsg;
	
	@FindBy(xpath="//a[contains(text(),'BCC Recipients')]")
	WebElement bccRecipients;
	
	@FindBy(xpath="//div[@id='pmrecips']/textarea")
	WebElement Recipients;
	
	@FindBy(xpath="//input[@id='title']")
	WebElement Title;
	
	@FindBy(xpath="//td[@id='cke_contents_vB_Editor_001_editor']/textarea")
	WebElement RTBxEditor;
	
	@FindBy(xpath="//p[contains(text(),'You may choose an icon for your message from this')]")
	WebElement postIconsMsg;
	
	@FindBy(xpath="//div[@id='shell-subpage']//div[2]//div[@class='group']//input[@id='vB_Editor_001_save']")
	WebElement FirstBtnSubmit;
	
	@FindBy(xpath="//div[@class='body-left-col']//div[4]//div[@class='group']//input[@id='vB_Editor_001_save']")
	WebElement SecondBtnSubmit;
	
	@FindBy(xpath="//div[@id='shell-subpage']//div[2]//div[@class='group']//input[@name='preview']")
	WebElement FirstBtnPreview;
	
	@FindBy(xpath="//div[@class='body-left-col']//div[4]//div[@class='group']//input[@name='preview']")
	WebElement SecondBtnPreview;
	
//	@FindBy(xpath="//label[@for='cb_receipt']/input[@id='cb_receipt']")
//	WebElement requestReadReceipt;
	
	@FindBy(xpath="//input[@id='cb_savecopy']")
	WebElement SaveMsgInSentFolder;
	
	@FindBy(xpath="//input[@id='cb_parseurl']")
	WebElement autoParseLink;
	
	@FindBy(xpath="//input[@id='cb_disablesmilies']")
	WebElement disableSmile;
	
	@FindBy(xpath="//li[contains(text(),'Please complete both the subject and message fields.')]")
	WebElement msgDescription;
	
	@FindBy(xpath="//h2[contains(text(),'Errors')]")
	WebElement msgErrors;
	
	@FindBy(xpath="//a[contains(text(),'Inbox')]")
	WebElement linkInbox;
	
	@FindBy(xpath="//h5[contains(text(),'Icon Legend')]")
	WebElement iconLegend;
	
	@FindBy(xpath="//dd[contains(text(),'Unread Message')]")
	WebElement msgUnread;
	
	@FindBy(xpath="//dd[contains(text(),'Read Message')]")
	WebElement msgRead;
	
	@FindBy(xpath="//dd[contains(text(),'Replied-to Message')]")
	WebElement msgReplied;

	@FindBy(xpath="//dd[contains(text(),'Forwarded Message')]")
	WebElement msgForward;
	
	@FindBy(xpath="//strong[contains(text(),'Download all Private Messages as')]")
	WebElement msgDownload;
	
	@FindBy(xpath="//a[contains(text(),'XML')]")
	WebElement linkXML;
	
	@FindBy(xpath="//a[contains(text(),'CSV')]")
	WebElement linkCSV;
	
	@FindBy(xpath="//a[contains(text(),'Text')]")
	WebElement linkText;
	
	@FindBy(xpath="//a[contains(text(),'Sent Items')]")
	WebElement sentItems;
	
	@FindBy(xpath="//a[contains(text(),'Title')]")
	WebElement title;
	
	@FindBy(xpath="//a[contains(text(),'Sender')]")
	WebElement sender;
	
	@FindBy(xpath="//a[contains(text(),'Date')]")
	WebElement date;
	
	@FindBy(xpath="//span[@class='ctrlcontainer']")
	WebElement msgSelected;
	
	@FindBy(xpath="//input[@id='searchuser_ctrl']")
	WebElement txtSender;
	
	@FindBy(xpath="//a[contains(text(),'Title')]")
	WebElement txtTitle;
	
	@FindBy(xpath="//select[@id='searchread']")
	WebElement drpDownReadRepStatus;
	
	@FindBy(xpath="//select[@id='startdate_month']")
	WebElement startMonth;
	
	@FindBy(xpath="//input[@id='startdate_date']")
	WebElement startDay;
	
	@FindBy(xpath="//input[@id='startdate_year']")
	WebElement startYear;
	
	
	@FindBy(xpath="//select[@id='enddate_month']")
	WebElement endMonth;
	
	@FindBy(xpath="//input[@id='enddate_date']")
	WebElement endDay;
	
	@FindBy(xpath="//input[@id='enddate_year']")
	WebElement endYear;
	
	@FindBy(xpath="//div[@class='group']//input[@class='button']")
	WebElement applyFilter;
	
	@FindBy(xpath="//ul[@id='yui-gen1']//label")
	List<WebElement> listselectMsg;
	
	@FindBy(xpath="//a[contains(text(),'Track Messages')]")
	WebElement trackMsgs;
	
	@FindBy(xpath="//h2[@id='list1']")
	WebElement h1TrackMsgs;
	
	@FindBy(xpath="//a[contains(text(),'Edit Folders')]")
	WebElement editFolder;
	
	@FindBy(xpath="//div[@class='labellink']/a[contains(text(),'Inbox')]")
	WebElement linkInboxFolder;
	
	@FindBy(xpath="//li[1]//div[@class='labellink']/a[contains(text(),'Empty Folder')]")
	WebElement linkemptyFolder1;
	
	@FindBy(xpath="//div[@class='labellink']/a[contains(text(),'Sent Items')]")
	WebElement linkSentItems;
	
	@FindBy(xpath="//li[2]//div[@class='labellink']/a[contains(text(),'Empty Folder')]")
	WebElement linkemptyFolder2;
	
	@FindBy(xpath="//input[@id='folder_1']")
	WebElement folder1;
	
	@FindBy(xpath="//input[@id='folder_2']")
	WebElement folder2;
	
	@FindBy(xpath="//input[@id='folder_3']")
	WebElement folder3;
	
	@FindBy(xpath="//div[@class='blockfoot actionbuttons']//input[@type='submit']")
	WebElement saveChanges;
	
	@FindBy(xpath="//div[@class='blockfoot actionbuttons']//input[@type='reset']")
	WebElement resetFields;
	
	@FindBy(xpath="//div[@class='editor-title']")
	WebElement editorTitle;
	
	@FindBy(xpath="//h2[contains(text(),'Confirm Deletion')]")
	WebElement msgConfirmDeletion;
	
	@FindBy(xpath="//div[@class='group']/input[@type='submit']")
	WebElement btnYesConfirmDeletion;
	
	@FindBy(xpath="//h2[contains(text(),'Standard Folders')]")
	WebElement h2StdFolder;
	
	
	public String h1YourMsg()
	{
		return h1YourMsg.getText().trim();
	}
	
	public String postIconsMsg()
	{
		return postIconsMsg.getText().trim();
	}
	
	public ArrayList<Boolean> verifySendNMsg()
	{
		ArrayList<Boolean> listObj=new ArrayList<Boolean>();
		listObj.add(Recipients.isDisplayed());
		listObj.add(Title.isDisplayed());
		listObj.add(RTBxEditor.isDisplayed());
		listObj.add(FirstBtnSubmit.isDisplayed());
		listObj.add(SecondBtnSubmit.isDisplayed());
		listObj.add(FirstBtnPreview.isDisplayed());
		listObj.add(SecondBtnPreview.isDisplayed());
//		listObj.add(requestReadReceipt.isDisplayed());
		listObj.add(SaveMsgInSentFolder.isDisplayed());
		listObj.add(SaveMsgInSentFolder.isSelected());
		listObj.add(autoParseLink.isDisplayed());
		listObj.add(autoParseLink.isSelected());
		listObj.add(disableSmile.isDisplayed());
		
		
		
		return listObj;
	}

	public void clickFirstBtnSubmit()
	{
		//testUtil.ElementIsClickable(FirstBtnSubmit);
		//FirstBtnSubmit.click();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", FirstBtnSubmit);
	}
	
	public String msgDescription()
	{
		return msgDescription.getText().trim();
	}
	
	public String msgErrors()
	{
		return msgErrors.getText().trim();
	}
	
	public void clickSecondBtnSubmit()
	{
		//testUtil.ElementIsClickable(FirstBtnSubmit);
		//FirstBtnSubmit.click();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", SecondBtnSubmit);
	}
	
	public void clickFirstBtnPreview()
	{
		//testUtil.ElementIsClickable(FirstBtnSubmit);
		//FirstBtnSubmit.click();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", FirstBtnPreview);
	}
	
	public void clickSecondBtnPreview()
	{
		//testUtil.ElementIsClickable(FirstBtnSubmit);
		//FirstBtnSubmit.click();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", SecondBtnPreview);
	}
	
	public void clicklinkInbox()
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", linkInbox);
	}
	
	public String iconLegend()
	{
		return iconLegend.getText().trim();
	}
	
	public void clicksentItems()
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", sentItems);
	}
	
	
	public String msgUnread()
	{
		return msgUnread.getText().trim();
	}
	
	public String msgRead()
	{
		return msgRead.getText().trim();
	}
	
	public String msgReplied()
	{
		return msgReplied.getText().trim();
	}
	public String msgForward()
	{
		return msgForward.getText().trim();
	}
	public String msgDownload()
	{
		return msgDownload.getText().trim();
	}
	
	public String linkXML()
	{
		return linkXML.getText().trim();
	}
	
	public String linkCSV()
	{
		return linkCSV.getText().trim();
	}
	
	public String linkText()
	{
		return linkText.getText().trim();
	}
	
	
	public ArrayList<Boolean> verifySentItems()
	{
		ArrayList<Boolean> listObj=new ArrayList<Boolean>();
		listObj.add(title.isDisplayed());
		listObj.add(sender.isDisplayed());
		listObj.add(date.isDisplayed());
		listObj.add(msgSelected.isDisplayed());
		listObj.add(txtSender.isDisplayed());
		listObj.add(txtTitle.isDisplayed());
//		listObj.add(drpDownReadRepStatus.isDisplayed());
		
		
		listObj.add(startMonth.isDisplayed());
		listObj.add(startDay.isDisplayed());
		listObj.add(startYear.isDisplayed());
		
		listObj.add(endDay.isDisplayed());
//		listObj.add(drpDownReadRepStatus.isDisplayed());
		listObj.add(endYear.isDisplayed());
		
		listObj.add(applyFilter.isDisplayed());
		
		return listObj;
	}
	
	public ArrayList<String> verifySelectedMsg()
	{
		ArrayList<String> listObj=new ArrayList<String>();
		testUtil.ElementIsClickable(msgSelected);
		msgSelected.click();
		for(int i=0;i<listselectMsg.size()-1;i++)
		{
			listObj.add(listselectMsg.get(i).getText().trim());
			
		}
		return listObj;
	}
	
	public List<WebElement> verifyReadReply()
	{
		Select selectObj=new Select(drpDownReadRepStatus);
		List<WebElement> list=selectObj.getOptions();
		return list;
	}
	
	public List<WebElement> verifyStartMonth()
	{
		Select selectObj=new Select(startMonth);
		List<WebElement> list=selectObj.getOptions();
		return list;
	}
	
	public List<WebElement> verifyEndMonth()
	{
		Select selectObj=new Select(endMonth);
		List<WebElement> list=selectObj.getOptions();
		return list;
	}

	public void clicktrackMsgs()
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", trackMsgs);
	}
	
	public String h1TrackMsgs()
	{
		return h1TrackMsgs.getText().trim();
	}
	
	public void clickeditFolder()
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", editFolder);
	}
	
	public ArrayList<Boolean> verifyEditFolders()
	{
		ArrayList<Boolean> listObj=new ArrayList<Boolean>();
		listObj.add(linkInboxFolder.isDisplayed());
		listObj.add(linkemptyFolder1.isDisplayed());
		listObj.add(linkSentItems.isDisplayed());
		listObj.add(linkemptyFolder2.isDisplayed());
		listObj.add(folder1.isDisplayed());
		listObj.add(folder2.isDisplayed());
		listObj.add(folder3.isDisplayed());
		listObj.add(saveChanges.isDisplayed());
		listObj.add(resetFields.isDisplayed());
		return listObj;
		
	}
	
	public void clicklinkInboxFolder()
	{
		testUtil.ElementIsClickable(linkInboxFolder);
		linkInboxFolder.click();
	}
	
	public void clicklinkemptyFolder1()
	{
		testUtil.ElementIsClickable(linkemptyFolder1);
		linkemptyFolder1.click();
	}
	
	public void clicklinkSentItems()
	{
		testUtil.ElementIsClickable(linkSentItems);
		linkSentItems.click();
	}
	
	public void clicklinkemptyFolder2()
	{
		testUtil.ElementIsClickable(linkemptyFolder2);
		linkemptyFolder2.click();
	}
	
	public String editorTitle()
	{
		return editorTitle.getText().trim();
	}
	
	public String msgConfirmDeletion()
	{
		return msgConfirmDeletion.getText().trim();
	}
	
	public boolean btnYesConfirmDeletion()
	{
		return btnYesConfirmDeletion.isDisplayed();
	}
	
	
	public String h2StdFolder()
	{
		return h2StdFolder.getText().trim();
	}
	
	
}


