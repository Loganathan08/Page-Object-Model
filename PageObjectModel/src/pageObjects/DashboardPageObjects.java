package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DashboardPageObjects {

	WebDriver driver;

	public DashboardPageObjects(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//img[@src='/web/images/dashboard_empty_widget_watermark.png' and @class='orangehrm-dashboard-widget-img']/following::p[1]")

	public static WebElement employeessleaveontoday;

	public void chkDashboard() throws InterruptedException{

		Thread.sleep(5000);

		String actualMessage=DashboardPageObjects.employeessleaveontoday.getText();


		Assert.assertEquals(actualMessage, "No Employees are on Leave Today");

	}


}
