package com.vtiger.opportunity;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.GenericLib.BaseClass;
/**
 * Edit leads using edit Without Modification and verify the lead information.
 * @author Manoj
 *
 */
@Listeners(com.vtiger.GenericLib.ListnerImplClass.class)
public class EditleadsusingeditWithoutModificationandverifytheleadinformationTc_31 extends BaseClass {
	
	@Test
	public void EditleadsusingeditWithoutModificationandverifytheleadinformationTc_31Test() {		
		
        // navigate to opportunity & click.
				WebDriverWait wait=new WebDriverWait(dr, 20);
				Actions a = new Actions(dr);
				try {
						WebElement opportunity = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("(//a[text()='Opportunities'])[1]"))));
						a.moveToElement(opportunity).perform();
						opportunity.click();
				}catch(NoSuchElementException e) {	}
				

	    // click on Edit in the left Side above the Opportunities List
			    WebDriverWait wait1 =new WebDriverWait(dr, 20);
			    try {
			    		WebElement edit = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Sakshi']/../../td[10]/a[1]")));
			    		edit.click();
			    }
			    catch(NoSuchElementException e) { }
        // Don’t  edit any Data And save
			    dr.findElement(By.xpath("//input[@value='  Save  ']")).click();
			    
	}
}
			    
			    
			    
			    
    /*

		System.setProperty("webdriver.gecko.driver", "../Selenium3.0/DriverExe/geckodriver.exe");
		WebDriver dr = new FirefoxDriver();
		//					dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// login to vtiger app. using url.
		dr.get("http://localhost:8888/index.php?action=Login&module=Users");

		// login to CRM with valid data.		
				dr.findElement(By.name("user_name")).sendKeys("admin");
				dr.findElement(By.name("user_password")).sendKeys("manager");
				dr.findElement(By.id("submitButton")).click(); 
			//
			    
			    
			    
	    // Logout
			    WebElement user = dr.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			    Actions ua=new Actions(dr);
			    ua.moveToElement(user).perform();
			    
			    dr.findElement(By.xpath("//a[text()='Sign Out']")).click();
			    
			    System.out.println("User Successfully Loged Out..");
			    
			    dr.close();
	*/