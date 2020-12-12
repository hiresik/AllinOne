
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.asserts.SoftAssert;

public class WebTable {
	 WebDriver drv;
	// ProfilesIni listprofiles = new ProfilesIni();
	//	FirefoxProfile profile = listprofiles.getProfile("default");
	
	 
  @Test
  public void f() {
	  SoftAssert sa = new SoftAssert();
	  System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Jars\\chromedriver.exe");
	  drv = new ChromeDriver();
	  Reporter.log("opened chromebrowser");
	  drv.get("http://html.com/tables/");
	  Reporter.log("website opened");
	  drv.manage().window().maximize();
	  Reporter.log("maximized chromebrowser");
 List <WebElement> r0 = drv.findElements(By.xpath(".//*[@id='post-382']/div/div[3]/table/tbody/tr"));
 List <WebElement> c0 = drv.findElements(By.xpath(".//*[@id='post-382']/div/div[3]/table/tbody/tr/th"));
//	 List <WebElement> r1 = drv.findElements(By.xpath(".//*[@id='post-382']/div/div[5]/table/tbody/tr"));
	// List <WebElement> c1 = drv.findElements(By.xpath(".//*[@id='post-382']/div/div[5]/table/tbody/tr/th"));
	 
	 Reporter.log("couting row and column of the tables");
	 
	 Reporter.log("entering for loop");
	 
	 for(int i=1;i<=r0.size();i++)
	 {
		 
		 for (int j=1;j<=c0.size();j++)
		 {
			 if (i==1){
				 System.out.println("Printing Headers");
				 Reporter.log("printing headers");
			 System.out.println(drv.findElement(By.xpath(".//*[@id='post-382']/div/div[3]/table/tbody/tr["+i+"]/th["+j+"]")).getText());
			 }
			 else
			 {
				 System.out.println("Printing Rows value");
				 Reporter.log("printing row & col values");
				 System.out.println(drv.findElement(By.xpath(".//*[@id='post-382']/div/div[3]/table/tbody/tr["+i+"]/td["+j+"]")).getText());
			
			 }
			 	 
		 }
		 Reporter.log("Assert");
		 sa.assertTrue(true);
		sa.assertAll();
		 
	 }
	 

	/* for(int i=1;i<=r1.size();i++)
	 {
		 
		 for (int j=1;j<=c1.size();j++)
		 {
			 if (i==1){
				 System.out.println("Printing Headers");
			 System.out.println(drv.findElement(By.xpath(".//*[@id='post-382']/div/div[5]/table/tbody/tr["+i+"]/th["+j+"]")).getText());
			 }
			 else
			 {
				 System.out.println("Printing Rows value");

				 System.out.println(drv.findElement(By.xpath(".//*[@id='post-382']/div/div[5]/table/tbody/tr["+i+"]/td["+j+"]")).getText());
			
			 }
			 	Assert.assertTrue(false);
		 }
		
		 
	 }*/
  
  }
  @BeforeMethod
  public void beforeMethod() {
  }


  @AfterMethod (enabled = true)
  public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
	  Reporter.log("entered aftermethod");
	  SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy_HHmmss");
	  String des="";
	  //get current date time with Date()
	  Date date = new Date();
	  
	  // Now format the date
	  String date1= dateFormat.format(date);
	  Reporter.log("entering if testResult.getStatus");
 	if (testResult.getStatus() == ITestResult.FAILURE) 
  	{ 
  		File scrFile = ((TakesScreenshot)drv).getScreenshotAs(OutputType.FILE);
  		 des=("errorScreenshots\\"+testResult.getInstanceName()+"_" + testResult.getName() + "_" 
  		  		 +date1+  ".jpg");
  	  	System.out.println("Reporter.log(des)  :  " +des);

  		FileUtils.copyFile(scrFile,new File(des) );
  	//	Reporter.log(des);
  	}
  	System.out.println("testResult.getStatus()  :  "+testResult.getStatus());
  	System.out.println("ITestResult.FAILURE  : " +ITestResult.FAILURE);
  	System.out.println("testResult.getParameters() : " +testResult.getParameters());
  	System.out.println("testResult.getName() : " +testResult.getName());
  	System.out.println("date1 : " +date1);
  	System.out.println("testResult.getTestName : " +testResult.getInstanceName());
  	System.out.println("Reporter.log(des)  :  " +des);
  
  //	 Reporter.log("<a href=" + des + "><p align=left> f  screenshot </p>");
  Reporter.log("<xsl:attribute name=href><xsl:value-of select="+des+"></xsl:attribute><xsl:value-of select="+des+" /></a>");
  }

  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
	  
	
  }

  @AfterSuite
  public void afterSuite() {
	  drv.quit();
  }

}
