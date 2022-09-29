package pageObjects;

import dataProvider.LogFile;
import managers.FileReaderManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import testDataTypes.Items;

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(how = How.XPATH, using="//input[@id='user-name']")
	private WebElement username_field;
	@FindBy(how = How.ID, using="password")
	private WebElement password_field;
	@FindBy(how = How.XPATH, using="//span[@class='title']")
	private WebElement title;
	@FindBy(how = How.ID, using="login-button")
	private WebElement login_btn;

	public void perform_Search(Items item) {
		driver.navigate().to(FileReaderManager.getInstance().getConfigFileReader().getApplicationUrl() + "/?s=" + item.itemName + "&post_type=product");
	}
	
	public void navigateTo_HomePage() {
		driver.get(FileReaderManager.getInstance().getConfigFileReader().getApplicationUrl());
		LogFile.info("Navigate to homepage");

	}

	public void enter_username() {
		username_field.sendKeys("standard_user");
	}
	public void enter_password() {
		password_field.sendKeys("secret_sauce");
		selenium.Helper.get_screenshot_after_step(driver, "info");
	}
	public void validate_login() {
		LogFile.info("User is on Page : "+title.getAttribute("innerHTML"));
		Assert.assertEquals("Products",title.getAttribute("innerHTML"));
		selenium.Helper.get_screenshot_after_step(driver, "info");
	}
	public void click_login_btn() {
		login_btn.click();
		selenium.Helper.get_screenshot_after_step(driver, "info");
	}

	public void navigate_to_login_page() {
		driver.get(FileReaderManager.getInstance().getConfigFileReader().getApplicationUrl());
		LogFile.info("Navigate to homepage");
		//		--------Attach screenshot after each step------------
		selenium.Helper.get_screenshot_after_step(driver,"info");
		//		--------/Attach screenshot after each step-----------
	}
}
