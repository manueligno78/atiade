package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", glue = "steps", plugin = { "json:target/cucumber.json",
                "pretty", "html:target/cucumber-reports" })
                
public class TestRunner extends AbstractTestNGCucumberTests {
}