
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import ExcelUtils;

public class DataFeedingChrome {
	WebDriver drv;

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Jars\\ChromeDriver\\chromedriver.exe");
		drv = new ChromeDriver(options);
	//	drv.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	//	Thread.sleep(5000);
		drv.get("https://docs.google.com/forms/d/e/1FAIpQLSecyZje-mciEkh-yopWWhhGa_YqI-HYIlNwlFX6NpUBCBD7CA/viewform");

	
	}
	
		@Test(dataProvider="entry")
		public void enterdata( String semail,String sn,String sname,String sex,String rand,String mobile,String marr) throws  Exception{
		drv.findElement(By.name("emailAddress")).sendKeys(semail);
		drv.findElement(By.name("entry.1634323380")).sendKeys(sn);
		drv.findElement(By.name("entry.773826951")).sendKeys(sname);
		drv.findElement(By.name("entry.1583436917")).sendKeys(sex);
		drv.findElement(By.name("entry.665800165")).sendKeys(rand);
		drv.findElement(By.name("entry.1239891331")).sendKeys(mobile);
		drv.findElement(By.name("entry.1366022232")).sendKeys(marr);
		
		drv.findElement(By.xpath("//*[@id='mG61Hd']/div/div[2]/div[3]/div[1]/div/div/content/span")).click();
	
		drv.close();
	}


		 @DataProvider
		 
		    public Object[][] entry() throws Exception{
		 
		       Object[][] testObjArray = ExcelUtils.getTableArray("D:\\Downloads\\Docs\\DataFeed\\Data Feeding.xlsx","Sheet1");
	      return (testObjArray);
		 
				}

	@AfterMethod
	public void afterMethod() {
	}

	@BeforeSuite
	public void beforeSuite() {
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("Quitting"); // will get you all the image urls on
										// the page
		// drv.switchTo().defaultContent();
	drv.quit();
	}

}
