package ama.testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import ama.config.BaseClass;
import ama.custom.Actiondriver;
import ama.objectrepositories.AllGrid_Xpath;
import reusable.Ama_Login;

public class All_Grid extends BaseClass{
	
	@Test(priority = 0)
	public void AllGrid() throws Exception
	{
		Actiondriver a = new Actiondriver();
		//a.launchApplication(config.getURL());
		Ama_Login lp = new Ama_Login();
		lp.login();
		String AllText = a.getText(AllGrid_Xpath.All);
		System.out.println(AllText);
		Assert.assertEquals(AllText, excel.getStringdata("Sheet2", 1, 0));
		a.Click_Button(AllGrid_Xpath.All, "All grid View");
//		Thread.sleep(3000);
//        a.ByVisibleElement(AllGrid_Xpath.Mensfashion, "Men's fashion");
//		String mensfashion = a.getText(AllGrid_Xpath.Mensfashion);
//		System.out.println(mensfashion);
//		Thread.sleep(3000);
	//	Assert.assertEquals(mensfashion, excel.getStringdata("Sheet2", 1, 1));
       // a.Click_Button(AllGrid_Xpath.Mensfashion, "Men's fashion");
	}
	
	@Test(priority = 1)
	public void Mensfashion() throws Exception
	{
		Actiondriver a = new Actiondriver();
		Thread.sleep(3000);
        a.ByVisibleElement(AllGrid_Xpath.Mensfashion, "Men's fashion");
		String mensfashion = a.getText(AllGrid_Xpath.Mensfashion);
		System.out.println("Men's fashion values is:" +mensfashion);
		Thread.sleep(3000);
        a.Click_Button(AllGrid_Xpath.Mensfashion, "Men's fashion");
//        a.GetElementcountText(AllGrid_Xpath.Alllists);
//        a.GetElementcount(AllGrid_Xpath.Mensclothing);      
	}
}


