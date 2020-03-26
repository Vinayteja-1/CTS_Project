package TESTCASES;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import libary.utility;
import pages.add_task_page;
import pages.login;
import pages.serch;

public class task_firefox extends utility {
	add_task_page ad;
	login l;
	serch s;
	int c=5;
  @Test(dataProvider = "dp")
  public void f(String user, String pass,String expt_result) {
	  l=new login(d);
	  l.do_login(user,pass);//login with data
	  ScreenShot(c);//taking Screen shot 
	  String act_result=l.error_check();
	  Assert.assertTrue(act_result.contains(expt_result));//compare result of actual and expected
  }
  @BeforeMethod
  public void beforeMethod() {
	  d=lunchBroser("FIREFOX", "http://examples.codecharge.com/TaskManager/Default.php");//Launch of Browser

  }

  @AfterMethod
  public void afterMethod() {
	  d.close();//close Broser
	  c++;
  }
  @DataProvider
  public String[][] dp() {
	  get_data();//getting data from excel
	  return data;

  }
}
