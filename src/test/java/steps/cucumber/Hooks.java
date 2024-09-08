package steps.cucumber;

import java.net.MalformedURLException;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ScreenshotUtil;

public class Hooks extends Step {

    @Before
    public void before() throws MalformedURLException {
        setUp();
    }

    @After
    public void after(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotFileName = scenario.getName().replaceAll("[^a-zA-Z0-9.-]", "_").concat(".png");
            byte[] screenshot = ScreenshotUtil.takeScreenshot(driver);
            scenario.attach(screenshot, "image/png", screenshotFileName);
        }
        tearDown();
    }
}
