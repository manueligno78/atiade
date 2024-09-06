package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/cucumber", glue = "steps/cucumber", plugin = { "json:target/cucumber.json",
                "pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"})
                
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
}