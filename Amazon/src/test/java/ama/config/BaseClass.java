package ama.config;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import ama.Utils.BrowserFactory;
import ama.Utils.Config;
import ama.Utils.ExcelDataReader;
import ama.custom.Actiondriver;

public class BaseClass {
	
	public static WebDriver driver;
	public static ExcelDataReader excel;
	public Config config; 
	
	String Method;
	  public ExtentHtmlReporter htmlreport;
	  public static ExtentReports extents;
	  public static ExtentTest parentTest;
	  public static ExtentTest childTest;
	  
//	  @BeforeTest
//	  public void report(){
//		  htmlreport = new ExtentHtmlReporter("./Reports/MyHtmlReport.html"); 
//		  extents = new ExtentReports();
//		  extents.attachReporter(htmlreport);
//	  }
	  
//	  @BeforeMethod
//	  public void MethodName(Method  method){
//		  
//		  parentTest = extents.createTest(method.getName());
//	  }
	
	@BeforeSuite
	public void setupsuiteinput() {
	  excel = new ExcelDataReader();
	  config = new Config();
	  
	}
	
	@BeforeClass
	public void launchbrowser() {		
		driver = BrowserFactory.Browsers(driver, "Chrome");
	}
	
	@AfterClass
	public void quitbrowser() {
		BrowserFactory.quitBrowser(driver);
		extents.flush();
	} 
	
//	@AfterMethod
//	public void teardownMethod(ITestResult result) {
//		if(result.getStatus()==ITestResult.FAILURE) {
//			Actiondriver.capturescreenshot(driver);
//		}
//	}

}
