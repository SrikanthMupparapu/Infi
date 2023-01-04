package ama.testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import ama.config.BaseClass;
import ama.custom.Actiondriver;
import ama.objectrepositories.AllGrid_Xpath;
import ama.objectrepositories.BestSellers_Xpath;
import reusable.Ama_Login;

public class All_BestSellers extends BaseClass {
	
	@Test(priority = 2)
	public void bestsellers() throws Exception
	{
		Actiondriver a = new Actiondriver();
		//a.launchApplication(config.getURL());
		Ama_Login lp = new Ama_Login();
		lp.login();
		String AllText = a.getText(AllGrid_Xpath.All);
		System.out.println(AllText);
		Assert.assertEquals(AllText, excel.getStringdata("Sheet2", 1, 0));
		a.Click_Button(BestSellers_Xpath.Allgrid, "All grid View");
		String bestsellers = a.getText(BestSellers_Xpath.bestsellers);
		System.out.println(bestsellers);
		a.Click_Button(BestSellers_Xpath.bestsellers, "Best Sellers");
		Assert.assertEquals(bestsellers, excel.getStringdata("Sheet2", 2, 1));
		Thread.sleep(5000);
		String title = a.gettitle();
		System.out.println("Tite of the best sellers is:" +title);
		
	}
	
	@Test(priority = 3)
	public void Alldept() throws Exception
	{
		Actiondriver a = new Actiondriver();
		Thread.sleep(5000);
		a.GetElementcountText(BestSellers_Xpath.Alldept);
		a.GetElementcount(BestSellers_Xpath.Alldept);
	}
	
	@Test(priority = 4)
	public void Electronics() throws Throwable
	{
		Actiondriver a = new Actiondriver();
		String attr = a.getAttributevalue(BestSellers_Xpath.Electronics, "href");
		System.out.println("Attribute value is:" +attr);
		String text = a.getText(BestSellers_Xpath.Electronics);
		System.out.println("Text of the Electronics is :" +text);
		Assert.assertEquals(text, excel.getStringdata("Sheet2", 3, 1));
		Thread.sleep(3000);
		String lineheight = a.getCssvalues(BestSellers_Xpath.Electronics, "line-height");
		System.out.println("line-height of the Element is:" +lineheight);
		Assert.assertEquals(lineheight, excel.getStringdata("Sheet2", 5, 1));
		Thread.sleep(3000);
		String fontsize = a.getCssvalues(BestSellers_Xpath.Electronics, "font-size");
		System.out.println("Font-size of the Element is:" +fontsize);
		Thread.sleep(3000);
		Assert.assertEquals(fontsize, excel.getStringdata("Sheet2", 6, 1));
		Thread.sleep(3000);
		String fontfamily = a.getCssvalues(BestSellers_Xpath.Electronics, "font-family");
		System.out.println("font-family of the Element is:" +fontfamily);
		Assert.assertEquals(fontfamily, excel.getStringdata("Sheet2", 4, 1));
		Thread.sleep(3000);
        a.Click_Button(BestSellers_Xpath.Electronics, "Electronics");
	}
}
