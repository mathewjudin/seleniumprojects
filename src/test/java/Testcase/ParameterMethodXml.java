package Testcase;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class ParameterMethodXml {
	WebDriver driver;
  @Test
  @Parameters({"txtuser","txtpass","user","pass"})
  public void login(String user_txt_locator,String pass_txt_locator,String user_name,String pass_word) {
	  driver.findElement(By.id(user_txt_locator)).sendKeys(user_name);
	  driver.findElement(By.id(pass_txt_locator)).sendKeys(pass_word);
	  driver.findElement(By.id("btnLogin")).click();
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  Reporter.log("Chrome Browser launghed");
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	  Reporter.log("WebSite is opened");
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
  }

  @AfterMethod
  public void afterMethod() throws Exception {
	  Thread.sleep(2000);
	  driver.quit();
  }

}
