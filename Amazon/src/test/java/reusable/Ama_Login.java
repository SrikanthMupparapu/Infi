package reusable;

import org.testng.annotations.Test;

import ama.config.BaseClass;
import ama.custom.Actiondriver;
import ama.objectrepositories.Login_Xpath;

public class Ama_Login extends BaseClass {
	
	public void login() throws Exception
	{
		Actiondriver a = new Actiondriver();
		a.launchApplication("https://www.amazon.in/");
		a.mousehover(Login_Xpath.Hello, "Hello & Sign-in");
		a.Click_Button(Login_Xpath.HelloSignIn, "HelloSignIn");
		a.Click_Button(Login_Xpath.username, "Username");
		
		String username = excel.getStringdata1("Sheet1", 1, 0);
		System.out.println(username);
		
		String password = excel.getStringdata1("Sheet1", 1, 1);
		System.out.println(password);
		
		a.Type(Login_Xpath.username, excel.getStringdata1("Sheet1", 1, 0),"Username");
		a.Click_Button(Login_Xpath.Continue, "Continue");
		a.Click_Button(Login_Xpath.password, "Password");
		a.Type(Login_Xpath.password, excel.getStringdata1("Sheet1", 1, 1),"Password");
		a.Click_Button(Login_Xpath.SignIn, "SignIn");
	}
}
