package com.vtiger.opportunity;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.vtiger.GenericLib.BaseClass;
import com.vtiger.GenericLib.FileLib;
/**
 * Search the Opportunity Using Not Contains Option With a Valid Name.
 * @author Manoj
 *
 */
public class SearchOpportunityByNotContainsOptionWithValidNameTc_49 extends BaseClass{
	
	@Test
	public void SearchOpportunityByNotContainsOptionWithValidNameTc_49Test() throws EncryptedDocumentException, FileNotFoundException, IOException {

		 /*Login into application using url		
		 login to CRM with valid data*/
		
         /* navigate to opportunity & click.*/
				Actions a = new Actions(dr);
				WebDriverWait wait1=new WebDriverWait(dr, 20);
				try {
						WebElement opportunity = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Opportunities'])[1]")));
						a.moveToElement(opportunity).perform();
						opportunity.click();			    
				}
				catch(NoSuchElementException ex) {	}
				Reporter.log("Navigated to opportunity & clicked successfully.. ",true); 

	    /*  click in go to advance search icon.*/
			    WebDriverWait wait2 = new WebDriverWait(dr, 20);
			    try {
			    		WebElement advance =wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Go to Advanced Search']")));			    			    
			    		advance.click();
			    }
			    catch(NoSuchElementException ex) {	} 
			    Reporter.log("Clicked on advance search icon succesfully..",true);

        /*  select opportunity name from dropdown list*/
			    String searchby = FileLib.getExcelData("Sheet1", 5, 2); 
			    WebElement name = dr.findElement(By.id("fcol0"));
			    Select s = new Select(name);
			    s.selectByVisibleText(searchby);
			    Reporter.log("Opportunity name selected from dropdown list succesfully..",true);

	    /*  select does not equal to option from another dropdown box*/	
			    String searchcriteria = FileLib.getExcelData("Sheet1", 5, 3);
			    WebElement type = dr.findElement(By.id("fop0"));
			    Select s1=new Select(type);
			    //s.selectByValue("n");
			    s1.selectByVisibleText(searchcriteria);
			    Reporter.log("Search option selected from dropdown list succesfully..",true);
			    
	    /*  enter any invalid name of opportunity related to into text box*/
			    String oppname = FileLib.getExcelData("Sheet1", 5, 4);
			    WebDriverWait wait5 = new WebDriverWait(dr, 20);
			    try {
			    		WebElement input = wait5.until(ExpectedConditions.visibilityOfElementLocated(By.id("fval0")));
			    		input.sendKeys(oppname);
			    }
			    catch(NoSuchElementException ex) {	}
			    Reporter.log("Opportunity character name entered in textbox",true);
			    
        /*  click on search now button*/
			    dr.findElement(By.xpath("(//input[@value=' Search Now '])[2]")).click();
			    Reporter.log("Search button clicked succesfully..",true);			    			    	
			    
   	     /* logout and close browser.*/

	}	
}