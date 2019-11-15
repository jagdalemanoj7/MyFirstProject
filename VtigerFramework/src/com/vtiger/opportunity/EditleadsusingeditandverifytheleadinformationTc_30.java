package com.vtiger.opportunity;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.GenericLib.BaseClass;
/**
 * Edit leads using edit and verify the lead information.
 * @author Manoj
 * 
 */

@Listeners(com.vtiger.GenericLib.ListnerImplClass.class)
public class EditleadsusingeditandverifytheleadinformationTc_30 extends BaseClass {

	@Test
	public void EditleadsusingeditandverifytheleadinformationTc_30Test()
	{
						
		/*Navigate to Opportunity.*/
		WebElement opportunity = dr.findElement(By.xpath("(//a[text()='Opportunities'])[1]"));
		Actions a = new Actions(dr);
		a.moveToElement(opportunity).perform();
		opportunity.click();
		Reporter.log("Navigated to opportunity..");
		
		/*choose one Opportunity click on Edit in the right Side corner.*/
		dr.findElement(By.xpath("//a[text()='Kiran']/../../td[10]/a[1]")).click();  
		Reporter.log("Edit option selected for one opportunity.");
		
		//Modify the Data And save
		dr.findElement(By.name("description")).sendKeys("KK Enterprices");
		Reporter.log("Discription data inserted..");
		
	    dr.findElement(By.xpath("//input[@value='  Save  ']")).click();
	    Reporter.log("Record saved successfully..");
	    
	}
}


/*
		//	Open vtiger webapplication using Url.
		WebDriver dr = new FirefoxDriver();
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		dr.get("http://localhost:8888/index.php?action=Login&module=Users");
		
		//	login to CRM with Valid data.
		dr.findElement(By.name("user_name")).sendKeys("admin");
		dr.findElement(By.name("user_password")).sendKeys("manager");
		dr.findElement(By.id("submitButton")).click();
		==================================================================
	    // Logout
	    WebElement user = dr.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	    Actions ua=new Actions(dr);
	    ua.moveToElement(user).perform();
	    
	    dr.findElement(By.xpath("//a[text()='Sign Out']")).click();
	    
	    System.out.println("User Successfully Loged Out..");
	    
	    dr.close();
*/