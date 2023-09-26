package pageObjects;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;


import utilities.MobileActions;

public class MobileHomePage {
	MobileActions MA=new MobileActions();
	public By breadCrumbs=By.xpath("//div[contains(@class,'breadcrumbs')]/ul");
	public By Mainmenu=By.xpath("//*[@class='menuIcon']");
	
	public By MarketNewsandReportMenu=By.xpath("//*[contains(text(),'Market News & Reports')]");
	
	public By issuerandfinancial=By.xpath("//*[@class='subMenu3']/child::a[contains(text(),'Issuer & Financial Advisor Announcements')]");
	
	public By PageNavigatorbtn=By.xpath("//*[@id='pagination-ul']/descendant::a[@data-page='3']");
	
	public By language=By.xpath("(//*[@class=\"nav-link lag\"])[2]");
	public boolean languageSelect() throws Exception {
		
		Thread.sleep(4000);
		if(MA.isDisplayed(language))
		{
			if(MA.gettext(language).equalsIgnoreCase("English")) {
				
				Thread.sleep(1000);
				MA.click(language);
				MA.click(Mainmenu);
				
				
				
				return true;
			}
			else
			{
				return false;
			}
			
		}
		return false;
		
		
	}
	public void selectMainMenu() throws Exception {
		Thread.sleep(4000);
		System.out.println("selectMainMenu");
    Thread.sleep(2000);
	MA.click(Mainmenu);
	System.out.println("Mainmenu Clicked");
	Thread.sleep(2000);
	}
	public void selectMarketNewsMenu() throws Exception {
		Thread.sleep(1000);
		MA.click( MarketNewsandReportMenu);
		System.out.println("MarketNews and Report menu selected");
		
	}
	public void selectIssuerMenu() throws Exception {
		Thread.sleep(1000);
		MA.click(issuerandfinancial);
		System.out.println("Issuer and Financial menu clicked");
		
	}
	public void scrolltonavigate() throws Exception {
		Thread.sleep(1000);
		
		
		MA.scrolltoelement(PageNavigatorbtn);
    
	}
	public void verifyPagination() throws Exception {
		
		MA.isDisplayed(PageNavigatorbtn);
	}
}
