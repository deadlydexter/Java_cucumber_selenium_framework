package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(how = How.ID, using = "shopping_cart_link")
	private WebElement btn_Cart;
	
	@FindBy(how = How.ID, using = "checkout_btn")
	private WebElement btn_ContinueToCheckout;
	
	
	public void clickOn_Cart() {
		btn_Cart.click();
	}
	
	public void clickOn_ContinueToCheckout(){
		btn_ContinueToCheckout.click();
		try { Thread.sleep(5000);}
		catch (InterruptedException e) {}
	}
}
