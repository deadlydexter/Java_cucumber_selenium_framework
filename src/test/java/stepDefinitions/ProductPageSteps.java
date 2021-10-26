package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.When;
import pageObjects.ProductListingPage;

public class ProductPageSteps {

	TestContext testContext;
	ProductListingPage productListingPage;
	
	public ProductPageSteps(TestContext context) {
		testContext = context;
		productListingPage = testContext.getPageObjectManager().getProductListingPage();
	}
	
	@When("^choose to buy first item from search results$")
	public void choose_to_buy_first_item_from_search_results() throws Throwable {
		productListingPage.clickOn_AddToCart();
	}
}
