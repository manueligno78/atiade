package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", glue = "steps", plugin = { "json:target/cucumber.json",
                "pretty"})
                
public class TestRunner extends AbstractTestNGCucumberTests {
}