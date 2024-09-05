package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/cucumber", glue = "steps/cucumber", plugin = { "json:target/cucumber.json",
                "pretty"})
                
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
}