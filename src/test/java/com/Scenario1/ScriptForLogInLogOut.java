package com.Scenario1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ScriptForLogInLogOut 
{
	public static WebDriver driver;
  @Test(dataProvider="Excel",dataProviderClass=CustomData.class)
  public void testDataDriven(String username,String password) throws InterruptedException 
  {
	  driver=new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  
	  driver.findElement(By.name("username")).sendKeys(username);
	  driver.findElement(By.name("password")).sendKeys(password);
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	  Thread.sleep(3000);
	  Utility.captureScreenShot(driver);
	  System.out.println("Screenshot Captured");
	  
	 
	  
	  
	  Thread.sleep(3000);
	  
	  //Assertion
	  
	  Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"),"Test fail Url not Matched");
	  System.out.println("Test pass Url Matched");
	  
	 
	 
	 WebElement welcomeMenu = driver.findElement(By.className("oxd-userdropdown-tab"));
     welcomeMenu.click();

     // Wait for the dropdown to appear and click the logout link
     WebElement logoutLink = driver.findElement(By.xpath("//a[text()='Logout']"));
     logoutLink.click();
     
     //Assertion
     Assert.assertTrue(driver.getCurrentUrl().contains("login"),"LogOut not completed");
	 System.out.println("LogOut successfully completed");
	 
	 
	  
	 
  }
  
   // Capture a screenshot
  
  //public void captureScreenShot()
  //{
	//  TakesScreenshot ts=(TakesScreenshot) driver;
	 // File src = ts.getScreenshotAs(OutputType.FILE);
	  //File dest=new File(System.getProperty("user.dir")+"//Screenshots//ORANGEHRM"+System.currentTimeMillis()+".png");
	 // try {
		//FileHandler.copy(src, dest);
	//} catch (IOException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
	//}
	  
	  //System.out.println("Screenshot Captured");
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  

