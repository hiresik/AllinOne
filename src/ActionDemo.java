
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

class a {
	 WebDriver drv;
	// ProfilesIni listprofiles = new ProfilesIni();
	//	FirefoxProfile profile = listprofiles.getProfile("default");
	
	 
  @Test
  public void f() {
	  System.setProperty("webdriver.chrome.driver", "D:\\SeleniumCode\\Jar Files\\chromedriver.exe");
	  drv = new ChromeDriver();
	  drv.get("http://html.com/tables/");
	  drv.manage().window().maximize();

  
  }


  @AfterSuite
  public void afterSuite() {
	  drv.quit();
  }

}
