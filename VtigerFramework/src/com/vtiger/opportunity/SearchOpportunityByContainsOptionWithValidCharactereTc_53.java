package com.vtiger.opportunity;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
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
import com.vtiger.GenericLib.FileLib;
/**
 * Search the Opportunity using Contains Option With a Valid Character.
 * @author Manoj
 *
 */
@Listeners(com.vtiger.GenericLib.ListnerImplClass.class)
public class SearchOpportunityByContainsOptionWithValidCharactereTc_53 extends BaseClass {
	
	@Test 
	public void SearchOpportunityByContainsOptionWithValidCharacterTc_53Test () throws EncryptedDocumentException, FileNotFoundException, IOException {
														
		/*Login into application using url				
		login to CRM with valid data*/
				
		/*navigate to opportunity & click.*/				
		WebDriverWait wait1=new WebDriverWait(dr, 20);
		try {
				WebElement opportunity = wait1.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("(//a[text()='Opportunities'])[1]"))));
				Actions a=new Actions(dr);
				a.moveToElement(opportunity).perform();
				opportunity.click();
		}
		catch(NoSuchElementException ex) {	}
		Reporter.log("navigated to opportunity & clicked successfully.. ",true);
		
		/*click in go to advance search icon.*/
		WebDriverWait wait2 =new WebDriverWait(dr, 20);
		try {
			    WebElement advance =wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Go to Advanced Search']")));			    			    
			    advance.click();
		}
		catch(NoSuchElementException ex) {	}
		Reporter.log("clicked on advance search icon succesfully..",true);
		
		/*select opportunity name  from dropdown list*/
			String searchby = FileLib.getExcelData("Sheet1", 9, 2);
			WebElement name = dr.findElement(By.id("fcol0"));
			Select s1=new Select(name);
			s1.selectByVisibleText(searchby);
			Reporter.log("Opportunity name selected from dropdown list succesfully..",true);
			
		/*select contains option from another dropdown  box*/
			String searchcriteria = FileLib.getExcelData("Sheet1", 9, 3);
			WebElement option = dr.findElement(By.id("fop0"));
			Select s2=new Select(option);
			s2.selectByVisibleText(searchcriteria);			
			Reporter.log("Contains option selected from dropdown list succesfully..",true);
			
		/*enter any valid character name of opportunity related to into text box.*/
				String orgname = FileLib.getExcelData("Sheet1", 9, 4);
				WebDriverWait wait5=new WebDriverWait(dr, 20);
				try {
						WebElement input = wait5.until(ExpectedConditions.visibilityOfElementLocated((By.name("fval0"))));				
						input.sendKeys(orgname);				
				}
				catch(NoSuchElementException ex) {   }
				Reporter.log("Opportunity character name entered in textbox",true);

		/*click on search now button*/
				dr.findElement(By.xpath("(//input[@value=' Search Now '])[2]")).click();
				Reporter.log("Search button clicked succesfully..",true);
		/*logout and close browser.*/
				
	}
}

/*
Reporter.log("Navigated to opportunity & clicked successfully.. ",true); 
Reporter.log("Clicked on advance search icon succesfully..",true);
Reporter.log("Opportunity name selected from dropdown list succesfully..",true);
Reporter.log("Search option selected from dropdown list succesfully..",true);
Reporter.log("Opportunity character name entered in textbox",true);
Reporter.log("Search button clicked succesfully..",true);
*/