package managers;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

public class ExtentManager {
    private static ExtentReports extent;
    private static final String reportFileName = "Test-Auto-report"+".html";
    private static final String fileSeperator = System.getProperty("file.seperator");
    private static final String reportFilePath = System.getProperty("user.dir")+fileSeperator+"TestReport";
    private static final String reportFileLocation = reportFilePath+fileSeperator+reportFileName;

    public static ExtentReports getInstance(){
        if(extent == null)
            createInstance();
        return extent;
    }
    public static ExtentReports createInstance(){
        String fileName = getReportPath(reportFilePath);
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle(reportFileName);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(reportFileName);
        htmlReporter.config().setTimeStampFormat("EEEE MMMM dd yyyy, hh:mm a '('zzz')'");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("OS", "Windows 10");
        extent.setSystemInfo("App Name", "Env: QA");
        return extent;
    }
    private static String getReportPath(String path){
        File testDirectory = new File(path);
        if(!testDirectory.exists()){
            if(testDirectory.mkdir()){
                System.out.println("Directory: "+path + "is created !");
                return reportFileLocation;
            } else{
                System.out.println("Failed to create directory: "+ path);
                return System.getProperty("user.dir");
            }
        } else{
            System.out.println("Directory already exists: "+ path);
        }
        return reportFileLocation;
    }

}
