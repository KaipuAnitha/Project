package com.listeners;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Scenario1.ScriptForLogInLogOut;
import com.Scenario1.Utility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentTestNGListeners extends ScriptForLogInLogOut implements ITestListener
{

 public ExtentReports extent=ExtentManager.getInstance();
	
	public ThreadLocal<ExtentTest> parentTest=new ThreadLocal<ExtentTest>();
	
	
	public void onTestStart(ITestResult result) 
	{
		ExtentTest extentTest=extent.createTest(result.getMethod().getMethodName());
	
		parentTest.set(extentTest);
	}
	
	
	public void onTestSuccess(ITestResult result) {
	   
		
		
		parentTest.get().pass("Test Passed");
		String pass=result.getName();
		//Utility.captureScreenShot(result.getTestClass().getRealClass().getSimpleName()+"_"+pass+"_"+timestamp()+".png");

	  }
	
	private String timestamp()
	{
		return new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	}

	public void onTestFailure(ITestResult result) 
	{
		
		
		parentTest.get().fail("Test Failed "+result.getThrowable().getMessage());
		String fail=result.getName();
		//captureScreenshot(result.getTestClass().getRealClass().getSimpleName()+"_"+fail+"_"+timestamp()+".png");

		
	   
	  }
	
	
	 public void onTestSkipped(ITestResult result) {
		parentTest.get().skip("Test Skipped "+result.getThrowable().getMessage());
	   
	  }
	
	
	public  void onFinish(ITestContext context) {
		extent.flush();
	    
	  }


}
