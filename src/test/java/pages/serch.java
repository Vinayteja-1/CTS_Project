package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import libary.utility;

public class serch {
	WebDriver d;
	public serch(WebDriver d)
	{
		this.d=d;
	}
	utility u=new utility();
	By assign_to=By.xpath("//select[@name='assign_to']");
	By project=By.xpath("//select[@name='project_id']");
	By priority=By.xpath("//select[@name='priority_id']");
	By status=By.xpath("//select[@name='status_id']");
	By type=By.xpath("//select[@name='type_id']");
	By search_btn=By.xpath("//input[@name='DoSearch']");
	By table=By.xpath("//input[@name='DoSearch']");
	
	public void sec_pro(String a) {
		WebElement we=u.waitForElement(d,project, 20);
		Select s=new Select(we);
		s.selectByVisibleText(a);
		
	}
	public void sec_pri(String a) {
		WebElement we=u.waitForElement(d,priority, 20);
		Select s=new Select(we);
		s.selectByVisibleText(a);
		
	}
	public void sec_stu(String a) {
		WebElement we=u.waitForElement(d,status, 20);
		Select s=new Select(we);
		s.selectByVisibleText(a);
		
	}
	public void sec_typ(String a) {
		WebElement we=u.waitForElement(d,type, 20);
		Select s=new Select(we);
		s.selectByVisibleText(a);
		
	}
	public void sec_ass(String a) {
		WebElement we=u.waitForElement(d,assign_to, 20);
		Select s=new Select(we);
		s.selectByVisibleText(a);
		
	}
	public void ck_ser_b() {
		WebElement we=u.elementclick(d,search_btn, 20);
		we.click();
	}
	public void do_serch(String pro,String pri,String stu,String typ,String assi)
	{
		this.sec_pro(pro);
		this.sec_pri(pri);
		this.sec_stu(stu);
		this.sec_typ(typ);
		this.sec_ass(assi);
		this.ck_ser_b();
		
	}
}
