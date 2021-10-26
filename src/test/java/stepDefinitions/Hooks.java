package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hooks {

	TestContext testContext;
	public Hooks(TestContext context) {
		testContext = context;
	}

	@Before("@NON-UI")
    public void setupNonUITests(){
		System.out.println("This will run before the Scenario");
    }

	@Before("@UI")
	public void setupUITests(){
		testContext.getDriverManager().getDriver();
		System.out.println("This will run before UI Scenario");
	}

	@After("@UI")
	public void tearDownUITests() {
		testContext.getDriverManager().closeDriver();
	}
	@After("@NON-UI")
	public void tearDownNonUITests() {
		System.out.println("End of test - Non UI");
	}
}
