package ama.custom;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import ama.config.BaseClass;

public class Actiondriver {
	
	public WebDriver driver;
	WebDriverWait wait;
	
	public Actiondriver() {
		driver = BaseClass.driver;
	}
	
	public void implicitlywait(int i) {
		driver.manage().timeouts().implicitlyWait(i, TimeUnit.SECONDS);
	}
	
	public void launchApplication(String appURL) throws IOException {
			driver.get(appURL);
			//BaseClass.childTest.pass("Navigated to Application URL:  "+ appURL);
		
	}
	
	public String gettitle() {
		return driver.getTitle();		
		
	}
	
	public String getCurrentURL() {
		return driver.getCurrentUrl();		
		
	}
	
	
	public String getText(By locator) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return driver.findElement(locator).getText(); 
	}
	
	public String getAttributevalue(By locator, String plchlder) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		WebElement emailField = driver.findElement(locator);
		return emailField.getAttribute(plchlder); 
	}
	
	
	public void Type(By locator, String text, String elmname) throws IOException {
		
			driver.findElement(locator).clear();
			driver.findElement(locator).sendKeys(text);
			//BaseClass.childTest.pass("Successfully entered in:  " +elmname);		
	}
	
	public void Clear(By locator) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		driver.findElement(locator).clear();
	}
	
	public void Click_Button(By locator, String elmname) throws IOException {
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			driver.findElement(locator).click();
	}
	
	public void SelectDropdown(By locator, String visibletext) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		Select dropdownvalue = new Select(driver.findElement(locator));
		dropdownvalue.selectByVisibleText(visibletext);	
	}
	
	//Drop down sorting
	public void AllElementsPresentIndropdown(By locator, String text)
	{
		Select cat = new Select(driver.findElement(locator));
		List<WebElement> catlist = cat.getOptions();
		
		boolean ordered = true;
		String item1,item2;
		for(int i=1;i<catlist.size();i++)
		{
			item1 = catlist.get(i-1).getText();
			item2 = catlist.get(i).getText();
			if(item2.compareToIgnoreCase(item1)<0)
			{
				ordered = false;
				break;
			}
		}	
		if(ordered)
		{
			System.out.println("All values are displayed in ascending order, test pass");
		}else
		{
			System.out.println("values are not displayed in ascending order, test fail");
		}
	}
	
	public void isdisplayed(By locator, String elename) throws IOException{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		 driver.findElement(locator).isDisplayed();

    }
	public boolean isSelected(By locator){
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		 return driver.findElement(locator).isSelected();
		}
	
	public void Alert(){
		 Alert alert = driver.switchTo().alert();
		 alert.dismiss();

	}
	
	public void mousehover(By locator, String element){
		Actions b = new Actions(driver);
		WebElement Ele = driver.findElement(locator);
		//driver.findElement(locator).sendKeys(testdata);
		b.moveToElement(Ele).build().perform();
	}
	
	public void Scroll_webpage(){
		JavascriptExecutor jse = (JavascriptExecutor)driver;	
		jse.executeScript("window.scrollBy(0,-1000)");
	}
	
	public void ByVisibleElement(By locator, String element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Locating element by link text and store in variable "Element"        		
        WebElement Element = driver.findElement(locator);
        // Scrolling down the page till the element is found		
        js.executeScript("arguments[0].scrollIntoView();", Element);
    }
	
	public void selectframes(int i){
		driver.switchTo().frame(i);	
	}
	public void selectdefaultframes(){
		driver.switchTo().defaultContent();
	}
	
	public int GetElementcount(By locator) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		List<WebElement> web = driver.findElements(locator);
		System.out.println("Elements count is:" +web.size());
		return web.size(); 
	}
	
	public void GetElementcountText(By locator) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		List<WebElement> web = driver.findElements(locator);
		for(WebElement text : web)
		{
		String texts = text.getText();
		System.out.println(texts);
		}
//		System.out.println("Elements count is:" +web.size());
//		return web.size(); 
	}
	
	public WebElement getWebelement(By locator) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		WebElement element= driver.findElement(locator);
		return element;
		
	}
	
	public String getCssvalues(By locator,String cssattrname)
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return driver.findElement(locator).getCssValue(cssattrname);
	}
	
	public String getCSSValues(By locator , String csstype) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		WebElement element= driver.findElement(locator);
		String s = element.getCssValue(csstype);
		String c = Color.fromString(s).asHex();
		return c;
		
	}
	
	// public static String capturescreenshot(WebDriver driver) {
		/*File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileHandler.copy(src, new File("./ScreenShots/" + getcurrentdateandtime() + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to capture screenshot " + e.getMessage());
		}*/
		/*String src_path = "./ScreenShots/";
		UUID uuid = UUID.randomUUID();
		File src_file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try{
			FileUtils.copyFile(src_file, new File(src_path+uuid+".jpeg"));
		}catch(Exception e){
			System.out.println("Unable to capture screenshot");
		}
		return src_path+uuid+".jpeg";
	} */
	
	public static String getcurrentdateandtime() {
		DateFormat currentdateformat = new SimpleDateFormat("MM_dd_yy_HH_mm_ss");
		
		Date currentdate = new Date();
		
		return currentdateformat.format(currentdate);
	}
}
