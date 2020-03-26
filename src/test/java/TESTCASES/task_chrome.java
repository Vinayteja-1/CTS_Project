package TESTCASES;

import org.testng.annotations.Test;

import libary.utility;
import pages.add_task_page;
import pages.login;
import pages.serch;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class task_chrome extends utility {
	add_task_page ad;
	login l;
	serch s;
	int c=0;
  @Test(dataProvider = "dp")
  public void f(String user, String pass,String expt_result) {
	  l=new login(d);
	  l.do_login(user,pass);//provide login data
	  ScreenShot(c);//taking Screen shot
	  String act_result=l.error_check();
	  Assert.assertTrue(act_result.contains(expt_result));//compare the result actual and expected
  }
  @BeforeMethod
  public void beforeMethod() {
	  d=lunchBroser("CHROME", "http://examples.codecharge.com/TaskManager/Default.php");//Launch of Browser

  }

  @AfterMethod
  public void afterMethod() {
	  d.close();//Close Browser
	  c++;
  }


  @DataProvider
  public String[][] dp() {
	  get_data();//Getting Data From Excel
	  return data;

  }
}
