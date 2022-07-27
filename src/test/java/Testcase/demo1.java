package Testcase;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;

public class demo1 {
	WebDriver driver;
  @Test
  @Parameters({"user","pass"})
  public void f(String user_name,String pass_word) {
	  
	  driver.findElement(By.id("txtUsername")).sendKeys(user_name);
	  driver.findElement(By.id("txtPassword")).sendKeys(pass_word);
	  driver.findElement(By.id("btnLogin")).click();
	  String ele=driver.findElement(By.id("spanMessage")).getText();
  }
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.edgedriver().setup();
	  driver=new EdgeDriver();
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
