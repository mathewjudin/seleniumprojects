package Testcase;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNGgroupdemo {
  @Test(groups= {"odd"})
  public void Test1() {
	  System.out.println("Odd");
  }
  @Test(groups= {"even"})
  public void Test2() {
	  System.out.println("Even");
  }
  @Test(groups= {"odd"})
  public void Test3() {
	  System.out.println("odd");
	  Reporter.log("Hello welcome to the Test");
  }
  @Test(groups= {"even"})
  public void Test4() {
	  System.out.println("Even");
  }
  @Test(groups= {"odd"})
  public void Test5() {
	  System.out.println("odd");
  }
}
