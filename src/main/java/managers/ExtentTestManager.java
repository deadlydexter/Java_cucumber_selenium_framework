package managers;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import java.util.HashMap;
import java.util.Map;

public class ExtentTestManager {
    static Map<String, ExtentTest> extentTestMap = new HashMap<>();
    static Map<Integer, ExtentTest> extentTestMapOld = new HashMap<>();
    static ExtentReports extent = ExtentManager.getInstance();

    public static synchronized ExtentTest getTest(){
        return extentTestMapOld.get((int) (Thread.currentThread().getId()));
    }
    public static synchronized ExtentTest getTestByName(String testName){
        return extentTestMap.get(testName);
    }
    public static synchronized void endTest(){
        extent.flush();
    }
    public static synchronized ExtentTest startTest(String testName){
        ExtentTest test = extent.createTest(testName);
        extentTestMapOld.put((int) (long) (Thread.currentThread().getId()), test);
        return test;

    }

    public static synchronized ExtentTest startTestByName(String testName){
        ExtentTest test = extent.createTest(testName);
        extentTestMap.put(testName, test);
        return test;

    }
}
