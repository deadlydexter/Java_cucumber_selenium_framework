package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.Given;
import pageObjects.HomePage;

public class HomePageSteps {

	HomePage homePage;
	TestContext testContext;
	public HomePageSteps(TestContext context) {
		testContext = context;

	}

	@Given("^user is on home page$")
	public void user_is_on_home_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		homePage = testContext.getPageObjectManager().getHomePage();
		homePage.navigateTo_HomePage();

	}


}
