package com.Scenario2Test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.Scenario2.AdminClass;
import com.Scenario2.LoginClass;

public class BaseClass 
{
	
	public WebDriver driver;
	public LoginClass lc;
	public AdminClass ac;
	
	
	@BeforeTest
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		lc=new LoginClass(driver);
		ac=new AdminClass(driver);
	}
	
	@BeforeClass
	public void pageSetUp()
	{
		System.out.println("LoginTest");
		lc.doLogin("Admin","admin123");
	}


	
	}


