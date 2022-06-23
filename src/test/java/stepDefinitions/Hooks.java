package stepDefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import cucumber.ScenarioContext;
import cucumber.TestContext;
import dataProvider.LogFile;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import pageObjects.BasePage;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Hooks extends BasePage {

	TestContext testContext;
	ExtentTest test;
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
	public void setupUITests(Scenario scenario) throws IOException {
		LogFile.startTestCase(scenario.getName());
		ScenarioContext.setScenario(scenario);

		testContext.getDriverManager().getDriver();
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+ "/test-output/ExtentReports/Test-CustomExtentReport"+timestamp()+".html");
		extent = new ExtentReports();
		final File CONF = new File("configs/spark-config.xml");
		htmlReporter.loadXMLConfig(CONF);
		extent.attachReporter(htmlReporter);
		test = extent.createTest(scenario.getName());
		System.out.println("This will run before UI Scenario");
	}



	@After("@UI")
	public void tearDownUITests(Scenario scenario) {
		LogFile.endTestCase(scenario.getName());
		WebDriver driver = testContext.getDriverManager().getDriver();
		if(scenario.isFailed()) try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			scenario.log("Take Screenshot");
			FileHandler.copy(source, new File(System.getProperty("user.dir")+"\\test-output\\screenshots\\screenshot1.png"));
			System.out.println(System.getProperty("user.dir"));
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(System.getProperty("user.dir")+"\\test-output\\screenshots\\screenshot1.png").build());
		} catch (ClassCastException | IOException cce){
			cce.printStackTrace();

		}
			extent.flush();
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
