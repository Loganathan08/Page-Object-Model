package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.DashboardPageObjects;
import pageObjects.LoginPageObjects;
import pageObjects.UserRolePageObjects;

public class TestUserRole{

	WebDriver driver;

	@BeforeMethod
	public void setupBeforeMethod(){

		WebDriverManager.chromedriver().setup();

		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}

	@Test(priority=1)
	public void verifyChkUserRole() throws Exception  {

		LoginPageObjects login=new LoginPageObjects(driver);
		login.loginAdminUser();

		DashboardPageObjects verify=new DashboardPageObjects(driver);
		verify.chkDashboard();


		UserRolePageObjects check=new UserRolePageObjects(driver);

		check.checkUserRole();


	}
	@AfterTest
	public void afterTest(){

		driver.quit();	

	}


}
