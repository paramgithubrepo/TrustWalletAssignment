package tests.utils;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = "tests",
    plugin = {"json:target/cucumber.json", "pretty", "html:target/cucumber-html-report.html"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
