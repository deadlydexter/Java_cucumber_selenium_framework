package runner;

//import com.cucumber.listener.Reporter;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources",
		glue = "stepDefinitions",
		tags = "@Run",
		plugin =  {
//				"html:target/cucumber-html-report/report.html",
				"json:target/cucumber-reports/Cucumber.json",
				"pretty","summary","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		} )
public class TestRunner_Smokes {

	@AfterClass
	public static void writeExtentReport() {
//		Reporter.loadXMLConfig(FileReaderManager.getInstance().getConfigFileReader().getReportConfigPath());
//		Reporter.setSystemInfo("User name", System.getProperty("user.name"));
//		Reporter.setSystemInfo("TimeZone", System.getProperty("user.timeZone"));
//		Reporter.setSystemInfo("Machine", 	"Windows 10" + "64 Bit");
//		Reporter.setSystemInfo("Selenium", "3.7.0");
//		Reporter.setSystemInfo("Maven", "3.5.3");
//		Reporter.setSystemInfo("Java Version", "1.8.0_151");
	}
}
