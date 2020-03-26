package libary;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import excel.read_excel;


public class utility extends read_excel {
	protected WebDriver d;
//	public utility(WebDriver d)
//	{
//		this.d=d;
//	}
	
		// TODO Auto-generated constructor stub
	
	public void ScreenShot(int i)
	{
		
		File f1=((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
	    File f2=new File("C:\\Users\\UTTAM BALA\\eclipse-workspace\\TASK_MANGER_LOGIN\\src\\test\\resources\\SCREENSHOT\\"+i+".png");
	try {
		FileUtils.copyFile(f1, f2);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		
	}
	public WebDriver lunchBroser(String br,String url)
	{
		
		if(br.contains("CHROME") ) {
			System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\DRIVER\\chromedriver_v79.exe");
			 d=new ChromeDriver();
		}
			 else  if(br.contains("FIREFOX") ) {
			System.setProperty("webdriver.gecko.driver","src\\test\\resources\\DRIVER\\geckodriver.exe");
			 d= new FirefoxDriver();
			 }
			 
				 
		
		d.get(url);
		 d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return d;
			
	}
	public WebElement waitForElement(WebDriver d,By loc,int timeout) {
		try{
			WebDriverWait wait =new WebDriverWait(d,timeout);
		     WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(loc));
		     return element;
		     }
		catch(Exception e)
		{}
		return null;
	}
	
	public WebElement elementclick(WebDriver d,By loc,int timeout) {
		try {
		WebDriverWait wait=new WebDriverWait(d,timeout);
		 WebElement element =wait.until(ExpectedConditions.elementToBeClickable(loc));
		 return element;
		}
		catch(Exception e) {}
		return null;
	}

}
