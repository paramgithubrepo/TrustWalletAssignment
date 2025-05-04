package utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverUtils {

    private static AppiumDriver driver;

    public static void initializeDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", System.getProperty("user.dir") + ConfigReader.getProperty("apk.path"));
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appPackage", ConfigReader.getProperty("app.package"));
        capabilities.setCapability("fullReset", true);
        try {
            driver = new AppiumDriver(new URL(ConfigReader.getProperty("appium.url")), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Appium server URL is invalid", e);
        }
    }

    public static AppiumDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("Driver not initialized. Please call initializeDriver first.");
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static byte[] takeScreenshot() {
        try {
            byte[] screenshot = ((TakesScreenshot) DriverUtils.driver).getScreenshotAs(OutputType.BYTES);
            return screenshot;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
