package Testcase;

import org.testng.annotations.Test;

public class TestNGDemo {
  @Test(priority=3,enabled=true)
  public void Test1() {
	  System.out.println("Test1");
  }
  @Test(priority=2,enabled=true)
  public void Test2() {
	  System.out.println("Test2");
  }
  @Test(priority=5,enabled=true)
  public void Test3() {
	  System.out.println("Test3");
  }
  @Test(priority=4,enabled=true)
  public void Test4() {
	  System.out.println("Test4");
  }
  @Test(priority=1,enabled=true)
  public void Test5() {
	  System.out.println("Test5");
  }
}
