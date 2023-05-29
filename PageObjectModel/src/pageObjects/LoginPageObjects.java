package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects {

	WebDriver driver;

	public LoginPageObjects(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}


	//Page-Objects

	@FindBy(xpath="//*[@name='username']")
	public static WebElement username;

	@FindBy(xpath="//*[@name='password']")
	public static WebElement password;

	@FindBy(xpath="//*[@type='submit']")
	public static WebElement loginButton;

	public void loginAdminUser() throws InterruptedException
	{
		Thread.sleep(5000);
		username.sendKeys("Admin");
		password.sendKeys("admin123");
		loginButton.click();
		Thread.sleep(5000);

	}
}
