package TESTCASES;

import org.testng.annotations.Test;

import libary.Utility;
import pages.Add_Task_Page;
import pages.Login_page;
import pages.Search_page;


import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class Test1 extends Utility {
	Add_Task_Page ad;
	Login_page l;
	Search_page s;
	int num=2;
	 @BeforeMethod
	  public void lanuchBrowser() {
		  d=launchBroser("CHROME", "http://examples.codecharge.com/TaskManager/Default.php");//Launch of Browser with Chrome
	  }
	
	@Test(dataProvider="valid_login_data",priority=0)
	public void login_valid(String userName,String password,String expected_result)
	{
		l=new Login_page(d);
		  l.do_login(userName,password);//Login with Valid data
		  String actual_result=l.log();//Get result of login
		  l.ck_task();//click on search 
		  s=new Search_page(d);
		  s.do_serch("CodeCharge", "High", "Closed", "Task", "Peter Larsen");//search task 
		  ScreenShot();//take screenshot
		  Assert.assertTrue(actual_result.contains(expected_result));//compare result
		  

	}
	@DataProvider
	  public String[][] valid_login_data() {
		  get_data("valid",1,3);//Get data from login excel
		 return data;
	   
	  }
	@Test(dataProvider="invalid_login_data",priority=1)
	public void login_invalid(String userName,String password,String expected_message)
	{
		l=new Login_page(d);
		  l.do_login(userName,password);//Login with invalid data
		  String actual_message=l.error();//Get result of login
		  ScreenShot();//take screenshot
		  Assert.assertTrue(actual_message.contains(expected_message));//compare result
		  

	}
	@DataProvider
	  public String[][] invalid_login_data() {
		  get_data("invalid",3,3);//Get data from login excel
		 return data;
	   
	  }
	@Test(dataProvider="blank_login_data",priority=2)
	public void login_blank(String userName,String password,String expected_message)
	{
		l=new Login_page(d);
		  l.do_login(userName,password);//Login with blank data
		  String actual_message=l.error();//Get result of login
		  System.out.println(actual_message);
		  ScreenShot();//take screenshot
		  Assert.assertTrue(actual_message.contains(expected_message));//compare result
		  

	}
	@DataProvider
	  public String[][] blank_login_data() {
		  get_data("blank",2,3);//Get data from blank excel
		 return data;
	   
	  }

  @AfterMethod
  public void closeBrowser() {
	  d.close();//close Browser
	  
	  
	  
  }


  
 

}
