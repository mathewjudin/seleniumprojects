package Testcase;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class demo {
  @Test(dependsOnMethods= {"registration"})
  public void login() {
	  System.out.println("login completed");
  }
  
  @Test(invocationCount=2)
  public void registration() {
	//SoftAssert softAssert = new SoftAssert();
	//Assert.assertEquals("sucess", "sucess!");
	 
	  //softAssert.assertEquals("sucess","sucess!");
	  System.out.println("Registration completed");
  
  }
}
