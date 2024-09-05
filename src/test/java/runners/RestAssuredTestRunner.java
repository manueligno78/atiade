package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/restassured", glue = "steps/restassured", plugin = { "json:target/cucumber.json",
                "pretty"})
                
public class RestAssuredTestRunner extends AbstractTestNGCucumberTests {
}