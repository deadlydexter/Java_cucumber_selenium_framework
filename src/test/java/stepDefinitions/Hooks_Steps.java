package stepDefinitions;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import cucumber.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;

public class Hooks_Steps {
	HomePage homePage;
	TestContext testContext;
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter sparkReport = new ExtentSparkReporter("reports/BDDSparkReport.html");

	public Hooks_Steps(TestContext context){ testContext = context;}
	@Given("^this is the first step$")
	public void This_Is_The_First_Step(){
		System.out.println("This is the first step");
		homePage = testContext.getPageObjectManager().getHomePage();
		homePage.navigateTo_HomePage();
	}

	@When("^this is the second step$")
	public void This_Is_The_Second_Step(){
		System.out.println("This is the second step");
	}

	@Then("^this is the third step$")
	public void This_Is_The_Third_Step(){
		System.out.println("This is the third step");
	}
}
