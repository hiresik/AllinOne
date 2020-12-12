import java.util.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

		
	public class DataProviderWithExcel_001 {
 
		WebDriver driver;
 
	    @BeforeMethod
 
	    public void beforeMethod() throws Exception {
 
	    	 System.setProperty("webdriver.chrome.driver","D:\\Selenium_Jars\\ChromeDriver\\chromedriver.exe");
	 		
	    	 driver = new ChromeDriver(); 
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        driver.get("https://choicetechlab.com/careers/test/");
			     	 
 
		}
 
	@Test(dataProvider="Authentication")
 
	 public void Regisstration_data(String sname, String semail,String sselect,String schkbox,String stextarea) throws  Exception{
    
	   String tempselect="",tempchkbox="";
		driver.findElement(By.id("name")).sendKeys(sname);
	 
	      driver.findElement(By.id("email")).sendKeys(semail);
	  	
	      tempselect = sselect.substring(0, sselect.indexOf("."));
	      
	      Select ddl = new Select(driver.findElement(By.id("selectbasic")));
	       ddl.selectByValue(tempselect);
	      
		  tempchkbox = schkbox.substring(0, schkbox.indexOf("."));

	      List<WebElement> li = driver.findElements(By.xpath("//input[@type='checkbox']"));
	    li.get(Integer.parseInt(tempchkbox)).click();
 
	    driver.findElement(By.id("textarea")).clear();
	    driver.findElement(By.id("textarea")).sendKeys(stextarea);
	    driver.findElement(By.xpath(".//*[@id='upload']")).click();
	    
	    Runtime.getRuntime().exec("C:\\Users\\Rizan\\Desktop\\AutoIT\\FileUpload.exe");


	    driver.findElement(By.id("textarea")).submit();
	
  
		}
 
    @DataProvider
 
    public Object[][] Authentication() throws Exception{
 
      Object[][] testObjArray = ExcelUtils.getTableArray("D:\\Downloads\\Docs\\Excel Data.xlsx","Sheet1");
    	//  Object[][] testObjArray = ObtainingCellType.getTableArray("D:\\Downloads\\Docs\\Excel Data.xlsx","Sheet1");
   // 	 Object[][] testObjArray = ReadExcel.getCellData("D:\\Downloads\\Docs\\Excel Data.xlsx","Sheet1");
         return (testObjArray);
 
		}
 
    @AfterMethod
 
    public void afterMethod() {
 
  	   driver.close();
 
    	}
 
}
