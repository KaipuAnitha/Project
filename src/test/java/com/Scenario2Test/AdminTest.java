package com.Scenario2Test;

import org.testng.annotations.Test;

public class AdminTest extends BaseClass
{
  @Test(priority=1)
  public void verifyAdmin() 
  {
	  ac.getListOfMenu();
  }
  
  @Test(priority=2)
  public void verifySearchWithUserName() 
  {
	  ac.searchEmpByUserName("Admin");
  }
  
  @Test(priority=3)
  public void verifySearchWithUserRole() 
  {
	  ac.searchEmoByUserRole("Admin");
  }
  

  @Test(priority=4)
  public void verifySearchWithStatus() 
  {
	 ac.searchEmpByStatus("Enabled");
  }
  
}
