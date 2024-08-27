package com.Scenario2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginClass 
{
	private WebDriver driver;
	
	public LoginClass(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//locators
	
	private By name=By.name("username");
	private By psw=By.name("password");
	private By btn=By.xpath("//button[@type='submit']");
	
	//methods
	
	public void doLogin(String un,String pwd)
	{
		driver.findElement(name).sendKeys(un);
		driver.findElement(psw).sendKeys(pwd);
		driver.findElement(btn).click();
	}
	public String getUrl()
	{
		return driver.getCurrentUrl();
	}
	
	public String getAppTitle()
	{
		return driver.getTitle();
	}
	
	

}
