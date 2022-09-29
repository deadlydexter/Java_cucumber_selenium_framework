package selenium;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

public class Helper {
    public static void get_screenshot(WebDriver driver,String screenshot_name ) throws IOException {
        byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        BufferedImage img = ImageIO.read(new ByteArrayInputStream(screenshot));
        File outputFile = new File(System.getProperty("user.dir")+"target/cucumber-reports"+"/"+screenshot_name+".png");
        ImageIO.write(img, "png", outputFile);
    }
    public static void get_screenshot_after_step(WebDriver driver, String log_level) {
//        Grab a screenshot after every step, available log status levels: PASS, FAIL, SKIP, WARN, INFO
        switch (log_level.toUpperCase()) {
            case "PASS":  ExtentCucumberAdapter.getCurrentStep().log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromBase64String(((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64)).build());
                break;
            case "FAIL":  ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromBase64String(((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64)).build());
                break;
            case "SKIP":  ExtentCucumberAdapter.getCurrentStep().log(Status.SKIP, MediaEntityBuilder.createScreenCaptureFromBase64String(((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64)).build());
                break;
            case "WARN":  ExtentCucumberAdapter.getCurrentStep().log(Status.WARNING, MediaEntityBuilder.createScreenCaptureFromBase64String(((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64)).build());
                break;
            case "INFO":  ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromBase64String(((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64)).build());
                break;
        }
    }


}
