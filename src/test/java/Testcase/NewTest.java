package Testcase;

import org.testng.annotations.Test;

import ObjectRepository.LoginPagepf;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class NewTest {
	WebDriver driver;
	File f;
	FileInputStream fis;
	Properties p;
	LoginPagepf l;
	File f1;
	FileInputStream fis1;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	Row r;
	Row r1;
	Cell c;
	Cell c1;
	Cell c2;
	Cell c3;
	String user_name;
	String pass_word;
  @Test
  public void valid() {
	  // page factory model
	 /* l=PageFactory.initElements(driver,LoginPagepf.class);
	  user_name=c.getStringCellValue();
	  pass_word=c1.getStringCellValue();
	 l.login(user_name, pass_word); 
	  */
	  // Config.properties model
	// l.login(p.getProperty("username_value"),p.getProperty("password_value"));
	  
	//Normal model		 
	 driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	  driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	  driver.findElement(By.id("btnLogin")).click();
	  System.out.println("Welcome to the Website");
	  
  }
  @Test
   public void invalid() {
	  //page factory model
	  /*l=PageFactory.initElements(driver,LoginPagepf.class);
	  user_name=c2.getStringCellValue();
	  pass_word=c3.getStringCellValue();
	 l.login(user_name, pass_word);
	  */
	 //config.properties model
	  l=PageFactory.initElements(driver,LoginPagepf.class);
	 //l.login(p.getProperty("invalid_user_value"), p.getProperty("invalid_pass_value"));
 
	  //Normal model
	  driver.findElement(By.id("txtUsername")).sendKeys("Admin1");
	  driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	  driver.findElement(By.id("btnLogin")).click();
	  String ele=driver.findElement(By.id("spanMessage")).getText();
	 //System.out.println(ele);
	   if(ele.contains("Csrf token validation failed"))
	  {
		  System.out.println("valid");
	  }
	  else
	  {System.out.println("Not valid");
	  }
	  
  } 
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.edgedriver().setup();
	  driver=new EdgeDriver();
	  Reporter.log("Web Browser launched");
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	  Reporter.log("WebSite got Opened");
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
  }

  @AfterMethod
  public void afterMethod() throws Exception {
	// Thread.sleep(3000);
	//driver.close();
	  driver.quit();
  }

  @BeforeClass
  public  void beforeClass() throws IOException {
	 // l=PageFactory.initElements(driver,LoginPagepf.class);
	  f=new File("D:\\QA Automation\\selenium\\FrameWork\\TestNG_HRM\\src\\test\\java\\config.properties");
	  fis=new FileInputStream(f);
	  p=new Properties();
	  p.load(fis);
	  f1=new File("D:\\login.xlsx");
	  fis1=new FileInputStream(f1);
	  workbook=new XSSFWorkbook(fis1);
	  sheet=workbook.getSheetAt(0);
	  r=sheet.getRow(1);
	  c=r.getCell(0);
	  //String user_name=c.getStringCellValue();
	 // System.out.println(user_name);
	  c1=r.getCell(1);
	  //String pass_word=c1.getStringCellValue();
	 // System.out.println(pass_word);
	  r1=sheet.getRow(2);
	  c2=r1.getCell(0);
	  c3=r1.getCell(1);
  }

  @AfterClass
  public void afterClass() throws Exception {
	  fis1.close();
  }

}
