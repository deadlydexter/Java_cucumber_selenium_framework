package cucumber;

import enums.Context;
import io.cucumber.java.Scenario;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
//This is a HasMap object which store the information in the Key-Value pair. Key type is String and Value can be of any Object Type.
	private Map<String, Object> scenarioContext;
	public static Scenario scenario;
	
	public ScenarioContext() {
		scenarioContext = new HashMap<>();
	}
	public static Scenario getScenario() {
		return scenario;
	}
	public static void setScenario(Scenario scenario) {
		ScenarioContext.scenario = scenario;
	}

	//This method takes two parameters,  key as String and value as object. Key is nothing but a Context enum.
	public void setContext(Context key, Object value) {
		scenarioContext.put(key.toString(), value);
	}
	//This method takes key as parameter and returned the object which match the key
	public Object getContext(Context key) {
		return scenarioContext.get(key.toString());
	}
	//This method performs a check on the complete Map that if it contains the key or not
	public Boolean isContains(Context key) {
		return scenarioContext.containsKey(key.toString());
	}
	//Important Note:
	//Include ScenarioContext in TextContext, so that it can be shared across all the Cucumber Steps using Pico-Container library. 
	//Also, to make sure to add a getter method as getScenarioContext() to get the scenarioContext object.
}
