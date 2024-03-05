package CommonUtills;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	
	WebDriver d = new ChromeDriver();
	webDriverUtills wutil = new webDriverUtills();
	PropertyFileUtil putil = new PropertyFileUtil();

	@BeforeSuite
	public void BS() {

		System.out.println("Connect to Data Base");
	}
	
	@BeforeClass
	public void BC() throws IOException {
   
		//TO launch the application
		String URL = putil.getDataFromPropertyFile("Url");
		
		WebDriver d = new ChromeDriver();
		wutil.maximize(d);
		wutil.implicitwait(d);
		
		d.get(URL);
		

	}
	
	@BeforeMethod
	public void BM() throws IOException {
		
		//It is used to login to the application 
		String USERNAME = putil.getDataFromPropertyFile("Username");
		String PASSWORD = putil.getDataFromPropertyFile("Password");
		
		// login to apllication
		d.findElement(By.name("user_name")).sendKeys(USERNAME);
		d.findElement(By.name("user_password")).sendKeys(PASSWORD);
		d.findElement(By.id("submitButton")).click();
		
	}
	
	@AfterMethod
	public void AM() throws InterruptedException {
		// It is used to signout from the application
		
		 Thread.sleep(2000);
		// mouseover on image
		WebElement img = d.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		 wutil.mousehover(d, img);
		
		 // click on signout
		d.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}
	
	@AfterClass
	public void Ac() {
		// It is used to close the browser
		d.quit();
	}
	

	@AfterSuite
	public void AS() {
		System.out.println("Disconnect from Data Base");
	}
	

}
