package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class UserRolePageObjects {

	WebDriver driver;

	public  UserRolePageObjects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	@FindBy(xpath="//*[@class='oxd-main-menu-item']")
	public static WebElement adminlink;

	@FindBy(xpath="//nav[@role='navigation' and @aria-label='Topbar Menu']/ul/li")
	public static WebElement userrolemanagement1;

	@FindBy(xpath="//a[@class='oxd-topbar-body-nav-tab-link' and @role='menuitem']")
	public static WebElement users;

	@FindBy(xpath="//*[@class='oxd-input-group__label-wrapper']/following::input")
	public static WebElement username;

	@FindBy(xpath="//*[@class='oxd-select-text-input' and @tabindex='0']")
	public static WebElement userrole;

	@FindBy(xpath="//*[@class='oxd-select-text-input']/following::i[2]")
	public static WebElement userstatus;

	@FindBy(xpath="//*[@type='submit']")
	public static WebElement searchbutton;

	@FindBy(xpath="//*[@class='oxd-select-text-input']")
	public static WebElement userstatusvalue;

	@FindBy(xpath="//*[@class='oxd-select-text-input']")
	public static WebElement userrolevalue;

	public void moveToUsersPage() throws InterruptedException{
		Actions actions=new Actions(driver);
		actions.moveToElement(adminlink);
		actions.click().build().perform();
		Thread.sleep(7000);		
		actions.moveToElement(userrolemanagement1);
		actions.click().build().perform();
		actions.moveToElement(users);
		actions.click().build().perform();
		Thread.sleep(7000);	
	}
	
	public void selectUsrRole(){
		Actions actions=new Actions(driver);
		Select selectRole=new Select(UserRolePageObjects.userrole);
		selectRole.selectByIndex(1);
		actions.click().build().perform();
		String actualRole =UserRolePageObjects.userrolevalue.getText();
		Assert.assertEquals(actualRole, "Admin");
	}

	public void selectStatus(){
		Actions actions=new Actions(driver);
		Select selectStatus=new Select(UserRolePageObjects.userstatus);
		selectStatus.selectByIndex(1);
		actions.click().build().perform();

		String actualStatus=UserRolePageObjects.userstatusvalue.getText();
		Assert.assertEquals(actualStatus,"Enabled");

	}

	public void checkUserRole() throws InterruptedException{
		Thread.sleep(5000);	    
		moveToUsersPage();
	}
}
