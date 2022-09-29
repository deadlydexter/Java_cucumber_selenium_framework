package stepDefinitions;

import cucumber.ScenarioContext;
import cucumber.TestContext;
import dataProvider.LogFile;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import pageObjects.BasePage;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Hooks extends BasePage {

	TestContext testContext;
	public Hooks(TestContext context) {
		super();
		testContext = context;
	}

	@Before("@NON-UI")
    public void setupNonUITests(Scenario scenario){
		LogFile.startTestCase(scenario.getName());
		ScenarioContext.setScenario(scenario);
		System.out.println("This will run before the Scenario");
    }

	@Before("@UI")
	public void setupUITests(Scenario scenario) {
		LogFile.startTestCase(scenario.getName());
		ScenarioContext.setScenario(scenario);

		testContext.getDriverManager().getDriver();
		System.out.println("This will run before UI Scenario");
	}



	@After("@UI")
	public void tearDownUITests(Scenario scenario) {
		LogFile.endTestCase(scenario.getName());
		WebDriver driver = testContext.getDriverManager().getDriver();
		if(scenario.isFailed()) try {
			selenium.Helper.get_screenshot_after_step(driver, "FAIL");
		} catch (ClassCastException cce){
			cce.printStackTrace();

		}
			testContext.getDriverManager().closeDriver();
	}
	@After("@NON-UI")
	public void tearDownNonUITests(Scenario scenario) {
		LogFile.endTestCase(scenario.getName());
		System.out.println("End of test - Non UI");
	}

	private static String timestamp() {
		return new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
	}
}
