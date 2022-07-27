package Testcase;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DependsOn {
  @Test(dependsOnMethods= {"registration"})
  public void login() {
	  System.out.println("login completed");
  }
  @Test
  public void registration() {
	  SoftAssert sf=new SoftAssert();
	  sf.assertEquals("sucess","sucess!");
	  //Assert.assertEquals("sucess","sucess!");
	  System.out.println("Registration completed");
  }
}
