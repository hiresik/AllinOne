import java.util.Collections;
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
import org.testng.annotations.Test;

public class AllElements {
	WebDriver drv;

	@Test
	public void Elements() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Jars\\ChromeDriver\\chromedriver.exe");
		drv = new ChromeDriver(options);
		drv.get("https://docs.google.com/forms/d/e/1FAIpQLSecyZje-mciEkh-yopWWhhGa_YqI-HYIlNwlFX6NpUBCBD7CA/viewform");

		// drv.switchTo().frame("2d29750020000147678082779");

		drv.manage().window().maximize();
		//drv.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

		// drv.switchTo().frame("2d29750020000147678082779");

		// List <WebElement> r0 =
		// drv.findElements(By.xpath(".//*[@id='post-382']/div/div[3]/table/tbody/tr"));
		List<WebElement> r0 = drv.findElements(By.xpath("//*"));
		int z = r0.size();
		System.out.println(z); // will get you all the image urls on the page
		// drv.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		int c=0,d=0;
		String s1="";
		for (WebElement r:r0) {
			s1=r.getTagName();
			//System.out.println(s1);
			if (("input".equals(s1.toLowerCase()) || "select".equals(s1.toLowerCase()) || "textarea".equals(s1.toLowerCase()) || "table".equals(s1.toLowerCase()))&& !"hidden".equals(r.getAttribute("type")) )
			{
			System.out.println(((c+1)+". "+s1+"  : "+r.getAttribute("type")+"  : "+r.getAttribute("id")+"  : "+r.getAttribute("name")));
		c++;
			}
			else
			{
		//	System.out.println(s1);
			//	System.out.println(((c+1)+". "+s1+"  : "+r.getAttribute("type")+"  : "+r.getAttribute("id")+"  : "+r.getAttribute("name")));

				d++;
			}
		}
		System.out.println(c);
		System.out.println(d);
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
		System.out.println("Quitting"); // will get you all the image urls on
										// the page
		// drv.switchTo().defaultContent();
		//drv.quit();
	}

}
