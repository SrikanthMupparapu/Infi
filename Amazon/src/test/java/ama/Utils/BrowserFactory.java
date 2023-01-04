package ama.Utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

	public static WebDriver driver;
	
	public static WebDriver Browsers(WebDriver driver, String browsername) {
		
		if(browsername == "Chrome") {
			WebDriverManager.chromedriver().setup();
		//	System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver");
			driver = new ChromeDriver();
		//	driver.get(AppURL);
			
		}
		else if(browsername == "Firefox") {
			WebDriverManager.firefoxdriver().setup();
			//System.setProperty("webdriver.gecho.driver", "./Drivers/gechodriver");
			driver = new FirefoxDriver();
			
		}
		else {
			System.out.println("We are not supporting this browser");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return driver;
		
	}
	
	public static void quitBrowser(WebDriver driver) {
		driver.close();
	}
	
}
