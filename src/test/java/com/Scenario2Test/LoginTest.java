package com.Scenario2Test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass
{
	
	
	
 
	 @Test(priority=1)
	  public void verifyUrl() 
	  {
		String url =  lc.getUrl();
		Assert.assertTrue(url.contains("login"),"Test fail..Url not matched");
		System.out.println("Test pass...Url Matched");
	  }
	  
	 @Test(priority=2)
	  public void verifyLogin() 
	  {
		lc.doLogin("Admin", "admin123");
	  }
	  
	 
  @Test(priority=3)
  public void verifyTitle() 
  {
	String Title = lc.getAppTitle();
	Assert.assertTrue(Title.contains("HRM"),"Test fail..Title not matched");
	System.out.println("Test pass...Title Matched");
  }
  
  
  
  
  
  
}
