package Testcase;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class DataProviderDemo {
	WebDriver driver;
  @Test(dataProvider="TestData")
  
	  public void login(String user_name,String pass_word) {
		  driver.findElement(By.id("txtUsername")).sendKeys(user_name);
		  driver.findElement(By.id("txtPassword")).sendKeys(pass_word);
		  driver.findElement(By.id("btnLogin")).click();
		
  }
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  Reporter.log("Browser Initiated");
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	  Reporter.log("The website is opened");
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
  }

  @AfterMethod
  public void afterMethod() throws Exception {
	  Thread.sleep(2000);
	  driver.quit();
  }
  
  @DataProvider (name="TestData")
  public Object[][] data()
  {
	  return new Object[][] {{"Admin","admin123"},{" "," "}};
  
  }

}
