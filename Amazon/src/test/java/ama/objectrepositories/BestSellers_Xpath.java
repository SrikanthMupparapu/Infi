package ama.objectrepositories;

import org.openqa.selenium.By;

public class BestSellers_Xpath {
	
	public static By Allgrid = By.xpath("//a[@id='nav-hamburger-menu']");
	public static By bestsellers = By.xpath("(//a[contains(text(),'Best Sellers')])[2]");
	public static By Alldept = By.xpath("//div[@role='group']/div");
    public static By Electronics = By.xpath("//a[@href='/gp/bestsellers/electronics/ref=zg_bs_nav_0']");
	
}
