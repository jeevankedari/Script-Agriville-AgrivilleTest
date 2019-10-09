package com.agriville.qa.testcases;

import org.testng.annotations.BeforeClass;

import com.agriville.qa.base.TestBase;
import com.agriville.qa.pages.AddEditDeleteReply;
import com.agriville.qa.pages.AddEditDeleteTopic;
import com.agriville.qa.pages.loginPage;
import com.agriville.qa.pages.searchTopic;
import com.agriville.qa.pages.topicDetails;
import com.agriville.qa.util.ExcelDataUtil;
import com.agriville.qa.util.testUtil;

public class AddEditDeleteReplyTest extends TestBase 
{
	topicDetails topicDetailsObj;
	ExcelDataUtil ExcelDataUtilObj;
	loginPage loginPageObj;
	
	searchTopic searchTopicObj;
	testUtil testUtilObj;
	AddEditDeleteReply AddEditDeleteReplyObj;
	String Path="E://Script Agriville//AgrivilleTest//src//main//java//com//agriville//qa//testdata//Agriville.xlsx";
	String sheetName="Disc_Categories";
	String sheetName1="Disc_CategoriesLogin";
	String sheetName2="PostThread";
	String sheetName3="Reply";
	
	public AddEditDeleteReplyTest()
	{
		super();
	}
	
	@BeforeClass
	public void SetUp()
	{
		intialization();
		topicDetailsObj = new topicDetails();
		searchTopicObj=new searchTopic();
		//testUtilObj=new testUtil();
		loginPageObj=new loginPage();
		testUtilObj=new testUtil();
		AddEditDeleteReplyObj=new AddEditDeleteReply();
		ExcelDataUtilObj=new ExcelDataUtil(Path);
		
	}
	
	//Reply from search page and reply to this thread at bottom
	//Reply from search result page
	//Reply from View Button
	
	
	
	
}
