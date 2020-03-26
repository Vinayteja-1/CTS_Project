package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import libary.utility;

public class login {
	WebDriver d;
	public login(WebDriver d)
	{
		this.d=d;
	}
	utility u=new utility();
	By admin=By.xpath("//a[@href='Administration.php']");
	By user=By.xpath("//input[@name='login']");
	By pass=By.xpath("//input[@name='password']");
	By login=By.xpath("//input[@name='DoLogin']");
	By logout=By.xpath("//a[@href='Login.php?Logout=True']");
	By error=By.xpath("//tr[@class='Error']");
	public void ck_ad() {
		WebElement we=u.elementclick(d,admin, 20);
		we.click();
	}
	public void se_lo(String a) {
		WebElement we=u.waitForElement(d,user, 20);
		if(a.contains("blank"))
		{
			a="";
			we.sendKeys(a);
			
		}
		else
		   we.sendKeys(a);
	}
	public void se_ps(String a) {
		WebElement we=u.waitForElement(d,pass, 20);
		if(a.contains("blank"))
		{
			a="";
			we.sendKeys(a);
			
		}
		else
		   we.sendKeys(a);
	}
	public void ck_bt() {
		WebElement we=u.elementclick(d,login, 20);
		we.click();
	}
	public String lg()
	{
		WebElement we=u.waitForElement(d,logout, 20);
		return we.getText();
		
	}
	public String er()
	{
		WebElement we=u.waitForElement(d,error, 20);
		return we.getText();
		
	}
	public void do_login(String u,String p)
	{
		this.ck_ad();
		this.se_lo(u);
		this.se_ps(p);
		this.ck_bt();
	}
	public String error_check()
	{
		 try {
			 return this.lg();

		  }  catch(NoSuchElementException e) {
			  return this.er();
		  }
		 catch(NullPointerException e)
		 {
			  return this.er();
		 }
		  
	}
	

}
