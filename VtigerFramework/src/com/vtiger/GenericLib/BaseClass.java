package com.vtiger.GenericLib;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

/**
 * Baseclass class contains common code which used again and again. e.g. Launch browser, login, logout, close browser.
 * @author Manoj
 * 
 */
public class BaseClass {

	public static WebDriver dr;
	
	
	/* Launch the browser.*/
	@BeforeClass
	public void configBC() throws IOException {	
				
		String pbrowser = FileLib.getPropertyvalue("browser");
		
		if(pbrowser.equals("firefox"))
		dr=new FirefoxDriver();
		else if(pbrowser.equals("chrome"))
		dr=new ChromeDriver();
		else if(pbrowser.equals("ie"))
		dr=new InternetExplorerDriver();
				
		/*System.out.println("Browser Launched..");*/
		Reporter.log("Browser Launched..");
	}

	/*	LogIn into application.*/
	@BeforeMethod
	public void configBM() throws IOException {
					
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		dr.manage().window().maximize();
		
		String currentUrl = FileLib.getPropertyvalue("url");
		String uname=FileLib.getPropertyvalue("username");
		String psd=FileLib.getPropertyvalue("password");

		dr.get(currentUrl);		
		
		dr.findElement(By.name("user_name")).sendKeys(uname);
		dr.findElement(By.name("user_password")).sendKeys(psd);
		dr.findElement(By.id("submitButton")).click();
		/*System.out.println("User Succesfully LogIn");*/
		Reporter.log("User Succesfully LogedIn");
	}
	
	/* Logout browser */	
	@AfterMethod
	public void configAM() {
	    
	    WebElement user = dr.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	    Actions ua=new Actions(dr);
	    ua.moveToElement(user).perform();
	    
	    dr.findElement(By.xpath("//a[text()='Sign Out']")).click();
	    
	    /*System.out.println("User Successfully Loged Out..");*/
	    Reporter.log("User Successfully Loged Out..");
	}

	
	/* Closing browser*/
	@AfterClass
	public void configAC() {		
		
		try 
	    { 
			Alert al= dr.switchTo().alert(); 
	         al.accept();
	    }   
	    catch (NoAlertPresentException Ex) 
	    {  } 
		
		dr.close();
	    /*System.out.println("Browser Closed...");*/
		Reporter.log("Browser Closed..");
		
	}	
}



/*
		SoftAssert softassert=new SoftAssert();
		softassert.assertEquals(pbrowser, "firefox");
		dr=new FirefoxDriver();
		softassert.assertEquals(pbrowser, "chrome");
		dr=new ChromeDriver();
		softassert.assertEquals(pbrowser, "ie");
		dr=new InternetExplorerDriver();
		
		softassert.assertAll();


 /*		
		Alert al = dr.switchTo().alert();
		String alertmsg = al.getText();
		Assert.assertEquals(alertmsg, "undefined");
		Assert.assertTrue(true);
	    al.accept();
		
	    Assert.assertTrue(false);
	    Assert.assertEquals(alertmsg, "under");

					// OR		

   if(alertmsg.equals("undefined")) {
	    	al.accept();
	    }
	    else {
		dr.close();
	    }
 */