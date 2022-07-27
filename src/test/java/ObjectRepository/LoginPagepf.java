package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPagepf {
	WebDriver driver;
	public LoginPagepf(WebDriver driver)
	{
		this.driver=driver;
	}
	@FindBy(id="txtUsername")
	WebElement username;
	@FindBy(id="txtPassword")
	WebElement password;
	@FindBy(id="btnLogin")
	WebElement loginbutton;
	
	public void login(String user,String pass)
	{
		username.sendKeys(user);
		password.sendKeys(pass);
		loginbutton.click();
		System.out.println(user);
		System.out.println(pass);
	}

}
