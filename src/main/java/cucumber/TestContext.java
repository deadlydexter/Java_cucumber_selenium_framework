package cucumber;

import managers.DriverManager;
import managers.PageObjectManager;

public class TestContext {

	private final DriverManager drivermanager;
	private PageObjectManager pageObjectManager;
	public ScenarioContext scenarioContext;
	
	public TestContext() {
		drivermanager = new DriverManager();

		System.out.println("hello3");
		scenarioContext = new ScenarioContext();
	}
	public DriverManager getDriverManager() {

		return drivermanager;
	}
	public PageObjectManager getPageObjectManager() {
		pageObjectManager = new PageObjectManager(drivermanager.getDriver());
		return pageObjectManager;
	}
	
	public ScenarioContext getScenarioContext() {
		return scenarioContext;
	}


}
