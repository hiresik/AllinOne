 
import java.util.List;
import java.util.concurrent.TimeUnit;
 
import org.openqa.selenium.By;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
 
import org.testng.annotations.Test;
 
public class DataProviderTest {
 
	
	WebDriver driver;
   
  @DataProvider(name = "Authentication")
 
  public static Object[][] credentials() {
 
        // The number of times data is repeated, test will be executed the same no. of times
 
        // Here it will execute two times
 
        return new Object[][] { { "testuser_1", "Test@123.com","1",2,"dfgdfg dfg dgd gd " }};
 
  }
 
  // Here we are calling the Data Provider object with its Name
 
  @Test(dataProvider = "Authentication")
 
  public void test(String sname, String semail,String sselect,int schkbox,String stextarea) {
	  System.setProperty("webdriver.chrome.driver","D:\\Selenium_Jars\\chromedriver.exe");
		
 
      driver = new ChromeDriver();
 
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
      driver.get("https://choicetechlab.com/careers/test/");
 
    
      // Argument passed will be used here as String Variable
 
      driver.findElement(By.id("name")).sendKeys(sname);
 
      driver.findElement(By.id("email")).sendKeys(semail);
    
      Select drpbasic = new Select(driver.findElement(By.id("selectbasic")));
       drpbasic.selectByValue(sselect);
      
      List<WebElement> li = driver.findElements(By.xpath("//input[@type='checkbox']"));
  //    System.out.println("li Size"+li.size());
    li.get(schkbox).click();
  //    driver.findElement(By.id("email")).sendKeys(sselect);
 
    driver.findElement(By.id("textarea")).sendKeys(stextarea);
 
//      driver.findElement(By.xpath(".//*[@id='account_logout']/a")).click();
      
      
 
  //    driver.quit();
 
  }
 
}
 
