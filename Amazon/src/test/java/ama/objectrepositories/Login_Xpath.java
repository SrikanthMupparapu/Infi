package ama.objectrepositories;

import org.openqa.selenium.By;

public class Login_Xpath {

	public static By Hello = By.xpath("//a[@id='nav-link-accountList']");
    public static By HelloSignIn = By.xpath("(//span[@class='nav-action-inner'])[1]");		
	public static By username = By.xpath("//input[@id='ap_email']");
	public static By Continue = By.xpath("//input[@id='continue']");
	public static By password = By.xpath("//input[@id='ap_password']");
	public static By SignIn = By.xpath("//input[@id='signInSubmit']");
	
}
