package com.Scenario1;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility 
{
	 public static void captureScreenShot(WebDriver driver)
	  {
		  TakesScreenshot ts=(TakesScreenshot) driver;
		  File src = ts.getScreenshotAs(OutputType.FILE);
		  File dest=new File(System.getProperty("user.dir")+"//Screenshots//ORANGEHRM"+System.currentTimeMillis()+".png");
		  try {
			FileHandler.copy(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  	

}
}
