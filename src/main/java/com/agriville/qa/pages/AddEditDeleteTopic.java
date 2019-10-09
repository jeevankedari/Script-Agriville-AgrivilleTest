package com.agriville.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.agriville.qa.base.TestBase;
import com.agriville.qa.util.testUtil;

public class AddEditDeleteTopic extends TestBase 
{
	public AddEditDeleteTopic()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='subject']")
	WebElement TxtBxTitle;
	
	@FindBy(xpath="//td[@id='cke_contents_vB_Editor_001_editor']/textarea")
	WebElement RTXBXDesc;
	
	@FindBy(xpath="//input[@id='tagpopup_ctrl']")
	WebElement TxtBxTags;
	
	@FindBy(xpath="//input[@id='vB_Editor_001_save']")
	WebElement BtnSubmitNewThread;
	
	@FindBy(xpath="//input[@name='preview']")
	WebElement BtnPreview;
	
	@FindBy(xpath="//p[@class='singledescription']")
	WebElement HTxtTags;

	@FindBy(xpath="//ul[@class='blockrow error']/li")
	WebElement MsgErrors;
	
	@FindBy(xpath="//h2[contains(text(),'Preview')]")
	WebElement TxtPreview;
	
	@FindBy(xpath="//div[@class='floater-box-commodity-inner']//input[@id='button']")
	WebElement BtnPostAMessage;
	
	@FindBy(xpath="//h1")
	WebElement H1ForNewThread;
	
	@FindBy(xpath="//a[@class='username invisible']/strong")
	WebElement UserName;
	
	@FindBy(xpath="//div[@class='blockbody formcontrols']//div/a")
	WebElement UserNameEditPage;
	
	@FindBy(xpath="//span[@id='login_toggle1']/a[1]")
	WebElement ProfileLink;
	
	@FindBy(xpath="//div[@class='title']/a[2]")
	WebElement ThreadLink;
	
	
	@FindBy(xpath="//div[@class='title']/a[1]")
	WebElement UserNameLink;
	
	@FindBy(xpath="//table[@class='message-inner-table']//img[contains(@id,'editimg')]")
	WebElement EditLink;
	
	@FindBy(xpath="//div[@id='pagetitle']")
	WebElement ForumLink;
	
	@FindBy(xpath="//h2[contains(text(),'Delete Post')]")
	WebElement H2DeletePost;
	
	@FindBy(xpath="//input[@id='delete']")
	WebElement ChkBxDelete;
	
	@FindBy(xpath="//input[@id='deltype_soft']")
	WebElement ChkBxDeleteMsg;
	
	@FindBy(xpath="//dd[@id='deltype_soft_deps']//input[@name='reason']")
	WebElement TxtBxReasonDelete;
	
	@FindBy(xpath="//input[@value='Delete Post']")
	WebElement BtnDeletePost;

	@FindBy(xpath="//input[@id='editreason']")
	WebElement TxtBxReasonEdit;
	
	@FindBy(xpath="//input[@id='titlefield']")
	WebElement TxtBxTitleEdit;
	
	@FindBy(xpath="//div[@class='blockbody formcontrols']//div[@class='blockrow']/a")
	WebElement UserOnEditPage;
	
	@FindBy(xpath="//input[@id='vB_Editor_001_save']")
	WebElement BtnSaveChanges;
	
	@FindBy(xpath="//input[@value='Preview Changes']")
	WebElement BtnPreviewChanges;
	
	@FindBy(xpath="//div[@id='pagetitle']/a")
	List<WebElement> ForumList;
	
	@FindBy(xpath="//div[@id='pagetitle']/a[3]")
	WebElement ForumThreadTitle;
	
	@FindBy(xpath="//div[@id='pagetitle']/a[2]")
	WebElement ForumDiscCategories;
	
	@FindBy(xpath="//div[@id='pagetitle']/a[1]")
	WebElement ForumLinkOnEdit;
	
	@FindBy(xpath="//li[contains(text(),'The text that you have entered is too long')]")
	WebElement MsgErrorOnEditPage;
	
	@FindBy(xpath="//blockquote[@class='postcontent lastedited']")
	WebElement LblLastEditedBy;
	
	@FindBy(xpath="//span[@id='noresults']")
	WebElement noResults;
	//Actions
	
	public ArrayList<Boolean> AllElementOnPostThread()
	{
		ArrayList<Boolean> listObj=new ArrayList<>();
		listObj.add(TxtBxTitle.isDisplayed());
		listObj.add(RTXBXDesc.isDisplayed());
		listObj.add(TxtBxTags.isDisplayed());
		listObj.add(BtnSubmitNewThread.isDisplayed());
		listObj.add(BtnPreview.isDisplayed());
		return listObj;
	}
	
	public void EnterTitleForThread(String name)
	{
		TxtBxTitle.sendKeys(name);
		
	}
	
	public void EnterDescription(String description)
	{
		
		RTXBXDesc.sendKeys(description);
		
	}
	
	
	public void EnterTags(String tags)
	{
		TxtBxTags.sendKeys(tags);
		
	}
	
	public void clickBtnSubmitNewThread()
	{
		testUtil.ElementIsClickable(BtnSubmitNewThread);
		BtnSubmitNewThread.click();
	}
	
	public void clickBtnPreview()
	{
		testUtil.ElementIsClickable(BtnPreview);
		BtnPreview.click();
	}
	
	public String HTxtTags()
	{
		return HTxtTags.getText().trim();
	}
	
	public String MsgErrors()
	{
		return MsgErrors.getText().trim();
	}
	
	public String MsgErrors10000()
	{
		return MsgErrors.getText().substring(0, 42);
	}
	
	public String TxtPreview()
	{
		return TxtPreview.getText().trim();
	}
	
	
	
	public String H1ForNewThread()
	{
		return H1ForNewThread.getText().trim();
	}
	
	public String UserName()
	{
		return UserName.getText().trim();
	}
	
	public void clickProfileLink()
	{
		testUtil.ElementIsClickable(ProfileLink);
		ProfileLink.click();
	}
	
	public void clickThreadLink()
	{
		testUtil.ElementIsClickable(ThreadLink);
		ThreadLink.click();
	}
	
	public String ThreadLink()
	{
		return ThreadLink.getText().trim();
	}
	
	
	public void clickEditLink()
	{
		testUtil.ElementIsClickable(EditLink);
		EditLink.click();
	}
	
	public String ForumLink()
	{
		return ForumLink.getText().trim();
	}
	
	
	public String H2DeletePost()
	{
		return H2DeletePost.getText().trim();
	}
	
	public ArrayList<Boolean> AllElementOnEditPage()
	{
		ArrayList<Boolean> listObj=new ArrayList<>();
		listObj.add(ChkBxDelete.isDisplayed());
		listObj.add(ChkBxDeleteMsg.isDisplayed());
		ChkBxDelete.click();
		listObj.add(ChkBxDeleteMsg.isEnabled());
		listObj.add(TxtBxReasonDelete.isDisplayed());
		listObj.add(BtnDeletePost.isDisplayed());
		listObj.add(TxtBxReasonEdit.isDisplayed());
		listObj.add(TxtBxTitleEdit.isDisplayed());
		listObj.add(UserOnEditPage.isDisplayed());
		listObj.add(RTXBXDesc.isDisplayed());
		listObj.add(BtnSaveChanges.isDisplayed());
		listObj.add(BtnPreviewChanges.isDisplayed());
		ChkBxDelete.click();
		return listObj;
	}
	
	public String TxtBxTitleEdit()
	{
		return TxtBxTitleEdit.getAttribute("value");
	}
	
	public String UserNameEditPage()
	{
		return UserNameEditPage.getText().trim();
	}
	
	
	public void clearDescriptionOnEditPage()
	{
		RTXBXDesc.clear();
	}
	
	public void clearTxtBxTitleEdit()
	{
		TxtBxTitleEdit.clear();
	}
	
	public void clickForumThreadTitle()
	{
//		for(int i=2;i<ForumList.size();i++)
//		{
//			ForumList.get(i).click();
//		}
		testUtil.ElementIsClickable(ForumThreadTitle);
		ForumThreadTitle.click();
	}
	
	public String ForumThreadTitle()
	{
//		String ThreadTileOnEditPage = null;
//		for(int i=2;i<ForumList.size();i++)
//		{
//			ThreadTileOnEditPage= ForumList.get(i).getText().trim();
//		}
//		return ThreadTileOnEditPage;
		return ForumThreadTitle.getText().trim();
	}
	
	
	public String ForumDiscCategories()
	{
//		String ThreadTileOnEditPage = null;
//		for(int i=1;i<ForumList.size()-1;i++)
//		{
//			ThreadTileOnEditPage= ForumList.get(i).getText().trim();
//		}
//		return ThreadTileOnEditPage;
		return ForumDiscCategories.getText().trim();
	}
	
	public void clickForumDiscCategories()
	{
//		for(int i=1;i<ForumList.size()-1;i++)
//		{
//			ForumList.get(i).click();
//		}
		testUtil.ElementIsClickable(ForumDiscCategories);
		ForumDiscCategories.click();
	}
	
	public void clickForumLinkOnEdit()
	{
		testUtil.ElementIsClickable(ForumLinkOnEdit);
		ForumLinkOnEdit.click();
	}
	public void clickBtnSaveChanges()
	{
		testUtil.ElementIsClickable(BtnSaveChanges);
		BtnSaveChanges.click();
	}
	
	public void clickBtnPreviewChanges()
	{
		testUtil.ElementIsClickable(BtnPreviewChanges);
		BtnPreviewChanges.click();
	}
	public String MsgErrorOnEditPage()
	{
		return MsgErrorOnEditPage.getText().substring(0, 42).trim();
	}
	
	public String LblLastEditedBy()
	{
		return LblLastEditedBy.getText().trim();
	}
	
	public void EnterTitleForThreadOnEditPage(String name)
	{
		TxtBxTitleEdit.sendKeys(name);
		
	}
	
	public void clearTxtBxReasonEdit()
	{
		TxtBxReasonEdit.clear();
	}
	
	public void EnterReasonForEdit(String ReasonEdit)
	{	TxtBxReasonEdit.sendKeys(ReasonEdit);
	}
	
	
	public void clickBtnDeletePost()
	{
		testUtil.ElementIsClickable(BtnDeletePost);
		BtnDeletePost.click();
	}
	
	public void clickChkBxDelete()
	{
		testUtil.ElementIsClickable(ChkBxDelete);
		ChkBxDelete.click();
	}
	
	public String noResults()
	{
		return noResults.getText().trim();
	}
	
	public boolean UserNameLink() 
	{
		return UserNameLink.isDisplayed();
		 
	}

}
