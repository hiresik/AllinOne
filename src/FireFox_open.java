import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFox_open {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	//	System.setProperty("webdriver.firefox.marionette", "D:\\Selenium_Jars\\geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", "D:\\Selenium_Jars\\geckodriver.exe");

		WebDriver drv = new FirefoxDriver();
		
		drv.get("http://www.abc.com");

	}

}
