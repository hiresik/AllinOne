import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class CkhImage {
	WebDriver drv;
  @Test
  public void chkimg() {
	  System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Jars\\chromedriver.exe");
	  drv = new ChromeDriver();
	  Reporter.log("opened chromebrowser");
	  drv.get("http://demoqa.com/");

	 // drv.switchTo().frame("2d29750020000147678082779");

	  Reporter.log("website opened");
	  drv.manage().window().maximize();
	  Reporter.log("maximized chromebrowser");
	  drv.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);  

	 // drv.switchTo().frame("2d29750020000147678082779");
	  
	  
// List <WebElement> r0 = drv.findElements(By.xpath(".//*[@id='post-382']/div/div[3]/table/tbody/tr"));
	  List <WebElement> r0 = drv.findElements(By.xpath("//*"));
	  System.out.println(r0.size()); //will get you all the image urls on the page
	//  drv.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);  
	  for(WebElement imageFromList : r0)
	  {
		     String ImageUrl=imageFromList.getAttribute("src");
		     String Alt=imageFromList.getAttribute("href");
		     String s =imageFromList.getText();
		     String gt = imageFromList.getTagName().equals("input");
		  // if (s.length()!= 0)
		   {
		     System.out.println(ImageUrl+" "+s+" "+Alt); //will get you all the image urls on the page
		     }
		}
	
	  
	
	  
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("Quitting"); //will get you all the image urls on the page
	  drv.switchTo().defaultContent();
	  drv.quit();
  }

}
