package managers;

import enums.DriverType;
import enums.EnvironmentType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverManager {

    private WebDriver driver;
    private static DriverType driverType;
    private static EnvironmentType environmentType;
    private final static String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

    public DriverManager() {
        driverType = FileReaderManager.getInstance().getConfigFileReader().getBrowser();
        environmentType = FileReaderManager.getInstance().getConfigFileReader().getEnvironment();
    }

    public WebDriver getDriver() {
        if (driver == null) {
            driver = createDriver();
        }
        return driver;
    }

    private WebDriver createDriver() {
        switch (environmentType) {
            case LOCAL:
                createLocalDriver();
                break;
            case REMOTE:
                createRemoteDriver();
                break;
        }
        return driver;
    }

    private WebDriver createRemoteDriver() {
        throw new RuntimeException("RemoteWebDriver is not yet implemented");
    }

    private WebDriver createLocalDriver() {
        switch (driverType) {
            case CHROME:
                System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigFileReader().getDriverPath());
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                options.addArguments("--disable-gpu");
                driver = new ChromeDriver(options);

                break;
            case FIREFOX:
                WebDriverManager.chromedriver().setup();
                ChromeOptions optionz = new ChromeOptions();
                optionz.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors","--disable-extensions","--no-sandbox","--disable-dev-shm-usage");
                driver = new ChromeDriver(optionz);
                break;
            case INTERNETEXPLORER:
                driver = new InternetExplorerDriver();
                break;
        }

        return driver;
    }

    public void closeDriver() {
        if (driver != null) {
            driver.close();
        }
    }
}
