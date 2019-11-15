package com.vtiger.GenericLib;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * 
 * @author Manoj
 *
 */
public class ListnerImplClass implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		
		String current_Date = new Date().toString().replace(":", "_").replace(" ", "_");
		String testCaseName=result.getMethod().getMethodName();
		
		EventFiringWebDriver edr=new EventFiringWebDriver(BaseClass.dr);
		File srcFile=edr.getScreenshotAs(OutputType.FILE);
		File destFile=new File("../VtigerFramework/Screenshots/"+testCaseName+"_"+current_Date+".png");
		try {
				FileUtils.copyFile(srcFile, destFile);				
		}
		catch(Exception e) {	}
	}
	
	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
