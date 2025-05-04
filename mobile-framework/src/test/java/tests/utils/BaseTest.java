package tests.utils;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;
import utils.DriverUtils;

public class BaseTest {

    @Before
    public static void setUp() {
        ConfigReader configReader = new ConfigReader();
        configReader.loadConfig();
        DriverUtils.initializeDriver();
    }

    @AfterStep
    public static void attachScreenshot(Scenario scenario) {
        scenario.attach(DriverUtils.takeScreenshot(), "image/png", scenario.getName() + "_Screenshot");
    }


    @After
    public static void tearDown() {
        DriverUtils.quitDriver();
    }

}
