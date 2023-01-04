package ama.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class Config {
	
	public WebDriver driver;
	public Properties pro;
	
	public Config() {
		
		File src = new File("./Config/Config.properties");
		FileInputStream fis;
		try {
			fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} 
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	public String getconfigdata(String configvalue) {

		return pro.getProperty(configvalue);
	}
	
	public String getChromeBrowser() {
		return pro.getProperty("ChromeBrowser");
	}
	
	public String getURL() {
		return pro.getProperty("URL");
	}

	public String getURLContains() {
		return pro.getProperty("searchpageurlcontains");
	}
	
	public String getusername()
	{
		return pro.getProperty("Username");
	}
	
	public String password()
	{
		return pro.getProperty("Passsword");
	}

}
