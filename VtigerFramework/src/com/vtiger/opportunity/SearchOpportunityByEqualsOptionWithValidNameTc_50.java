package com.vtiger.opportunity;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
 * Search the Opportunity using Equals Option With a Valid Name.
 * @author admin
 *
 */
@Listeners(com.vtiger.GenericLib.ListnerImplClass.class)
public class SearchOpportunityByEqualsOptionWithValidNameTc_50 extends BaseClass{

	@Test
	public void SearchOpportunityByEqualsOptionWithValidNameTc_50Test() throws EncryptedDocumentException, FileNotFoundException, IOException {
				
				 /* Login into application using url		
				login to CRM with valid data*/
				
		        /*  navigate to opportunity & click.*/
						Actions a=new Actions(dr);
						WebDriverWait wait1=new WebDriverWait(dr, 20);
						try {
								WebElement opportunity = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Opportunities'])[1]")));
								a.moveToElement(opportunity).perform();
								opportunity.click();			    
						}
						catch(NoSuchElementException e) {	}
						Reporter.log("Navigated to opportunity & clicked successfully.. ",true); 
						
			    /*  click in go to advance search icon.*/
					    WebDriverWait wait2 = new WebDriverWait(dr, 20);
					    try {
					    WebElement advance =wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Go to Advanced Search']")));			    			    
					    advance.click();
					    }
					    catch(NoSuchElementException ex) {
					    	System.out.println(ex);
					    }
					    Reporter.log("Clicked on advance search icon succesfully..",true);
					    
		        /*  select opportunity name from dropdown list*/
					    String searchby = FileLib.getExcelData("Sheet1", 6, 2);					    
					    WebElement name = dr.findElement(By.id("fcol0"));
					    Select s=new Select(name);
					    s.selectByVisibleText(searchby);
					    Reporter.log("Opportunity name selected from dropdown list succesfully..",true);

			    /*	select equals to option from another dropdown box*/		   					    
					    String searchcriteria = FileLib.getExcelData("Sheet1", 6, 3);					    
					    WebElement type = dr.findElement(By.id("fop0"));
					    Select s1=new Select(type);
					    //s.selectByValue("n");
					    s1.selectByVisibleText(searchcriteria);
					    Reporter.log("Search option selected from dropdown list succesfully..",true);

			    /* enter any valid name of opportunity related to into text box*/
					    String oppname = FileLib.getExcelData("Sheet1", 6, 4);
					    WebDriverWait wait5 = new WebDriverWait(dr, 20);
					    try {
					    WebElement input = wait5.until(ExpectedConditions.visibilityOfElementLocated(By.id("fval0")));
					    input.sendKeys(oppname);
					    }
					    catch(NoSuchElementException e) { }
					    Reporter.log("Opportunity character name entered in textbox",true);
					    
		        /*  click on search now button*/
					    dr.findElement(By.xpath("(//input[@value=' Search Now '])[2]")).click();
					    Reporter.log("Search button clicked succesfully..",true);
					    
		   	    /* logout and close browser.*/

	}
}

// 		equals			Marvel corp