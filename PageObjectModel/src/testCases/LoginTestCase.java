package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginPageObjects;


public class LoginTestCase {

	WebDriver driver=null;

	@BeforeMethod
	public void setupBeforeMethod(){

		WebDriverManager.chromedriver().setup();

		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");


	}

	@Test(priority=0)
	public void verifyLoginFunctionality()throws InterruptedException{

		LoginPageObjects login=new LoginPageObjects(driver);

		login.loginAdminUser();

	}




	@AfterTest
	public void afterTest(){

		driver.quit();
	}

}
