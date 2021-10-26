package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProductListingPage {

	public ProductListingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(how = How.ID, using = "Bentley")
	private WebElement btn_AddToCart;

	
	public void clickOn_AddToCart() {
		btn_AddToCart.click();
	}

}
