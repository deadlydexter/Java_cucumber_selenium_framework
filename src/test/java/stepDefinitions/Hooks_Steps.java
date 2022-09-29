package stepDefinitions;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import cucumber.ScenarioContext;
import cucumber.TestContext;
import dataProvider.LogFile;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;

public class Hooks_Steps {
	HomePage homePage;
	TestContext testContext;
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter sparkReport = new ExtentSparkReporter("reports/BDDSparkReport.html");
	String scenario_name = ScenarioContext.getScenario().getName();

	public Hooks_Steps(TestContext context){ testContext = context;}
	@Given("^this is the first step$")
	public void This_Is_The_First_Step() throws InterruptedException {
		System.out.println("This is the first step");
//		ExtentTestManager.startTestByName(scenario_name);
//		ExtentTestManager.getTestByName(scenario_name).info("Navigating to loginPage");

	}

	@When("^this is the second step$")
	public void This_Is_The_Second_Step(){
		System.out.println("This is the second step");
	}

	@Then("^this is the third step$")
	public void This_Is_The_Third_Step() throws InterruptedException {
		System.out.println("This is the third step");
	}

	@Given("this is the first step one")
	public void this_is_the_first_step_one() {
		System.out.println("Running step one");
		LogFile.info("this is a log for step one");

	}

	@When("this is the second step two")
	public void this_is_the_second_step_two() {
		System.out.println("Running step two");
		LogFile.info("this is a log for step 2");
	}

	@Then("this is the third step three")
	public void this_is_the_third_step_three() {
		System.out.println("Running step Three");
		LogFile.info("this is a log for step 3");
	}


}
