package com.vtiger.opportunity;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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
 * Search the Opportunity By Not Equal Option With an Invalid Name.
 * @author admin
 *
 */
public class SearchOpportunityByNotEqualOptionWithInvalidNameTc_46 extends BaseClass {

	@Test
	public void SearchOpportunityByNotEqualOptionWithInvalidNameTc_46Test() throws EncryptedDocumentException, FileNotFoundException, IOException {
		//  Open Browser and Login into application using url		
		
        //  navigate to opportunity & click.
				Actions a=new Actions(dr);
				WebDriverWait wait1=new WebDriverWait(dr, 20);
				try {
						WebElement opportunity = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Opportunities'])[1]")));
						a.moveToElement(opportunity).perform();
						opportunity.click();			    
				}
				catch(NoSuchElementException e) {	}
				Reporter.log("Navigated to opportunity & clicked successfully.. ",true); 

	    //  click in go to advance search icon.
			    WebDriverWait wait2 = new WebDriverWait(dr, 20);
			    try {
			    		WebElement advance =wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Go to Advanced Search']")));			    			    
			    		advance.click();
			    }
			    catch(NoSuchElementException e) {	}			    
			    Reporter.log("Clicked on advance search icon succesfully..",true);		
			    
        //  select opportunity name  from dropdown list
			    String searchby = FileLib.getExcelData("Sheet1", 4, 2); 
			    WebElement name = dr.findElement(By.id("fcol0"));
			    Select s=new Select(name);
			    s.selectByVisibleText(searchby);
			    Reporter.log("Opportunity name selected from dropdown list succesfully..",true);

	    //	select starts with option from another dropdown box		    
			    String searchcriteria = FileLib.getExcelData("Sheet1", 4, 3);
			    WebElement type = dr.findElement(By.id("fop0"));
			    Select s1=new Select(type);
			    //s.selectByValue("n");
			    s1.selectByVisibleText(searchcriteria);
			    Reporter.log("Search option selected from dropdown list succesfully..",true);
			    
	    //  enter any valid character of opportunity related to into text box
			    String oppname = FileLib.getExcelData("Sheet1", 4, 4);
			    WebDriverWait wait5 = new WebDriverWait(dr, 20);
			    try {
			    		WebElement input = wait5.until(ExpectedConditions.visibilityOfElementLocated(By.id("fval0")));
			    		input.sendKeys(oppname);
			    }
			    catch(NoSuchElementException e) { }
			    Reporter.log("Opportunity character name entered in textbox",true);

        //  click on search now button
			    dr.findElement(By.xpath("(//input[@value=' Search Now '])[2]")).click();
			    Reporter.log("Search button clicked succesfully..",true);			    
			    //Thread.sleep(15000);			    			    	
			    
   	    // logout and close browser.
			    
	}
}

//		not equal to		Marvel corp