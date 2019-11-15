package com.vtiger.opportunity;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.GenericLib.BaseClass;
/**
 *	Search all the opportunities using character bar in search menu. 
 * @author Manoj
 *
 */

@Listeners(com.vtiger.GenericLib.ListnerImplClass.class)
public class SearchOpportunityNameByCharTc_55 extends BaseClass{

	@Test
	public void SearchOpportunityNameByCharTc_55Test() {

		/* Login into application using url*/
		
		/* Navigate to opportunity & click.*/
		Actions a=new Actions(dr);
		WebDriverWait wait1=new WebDriverWait(dr, 20);
		try {
				WebElement opportunity = wait1.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("(//a[text()='Opportunities'])[1]"))));						
				a.moveToElement(opportunity).perform();
				opportunity.click();								
		}catch(NoSuchElementException ex) {  }
		Reporter.log("Navigated to opportunity & clicked successfully.. ",true);
		
		/*click initial character related to opportunity name*/ 
		WebDriverWait wait2=new WebDriverWait(dr, 20);
		try {
				WebElement input = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='M']")));
				input.click();
		}catch(NoSuchElementException ex) {  }					
		Reporter.log("Related all Opportunities displayed..",true);
		
		
		/*logout and close browser*/
		
	}
}