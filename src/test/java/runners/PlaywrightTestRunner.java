package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/playwright", glue = { "steps.playwright" }, plugin = { "pretty",
        "json:target/playwright.json", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" })
public class PlaywrightTestRunner extends AbstractTestNGCucumberTests {
}