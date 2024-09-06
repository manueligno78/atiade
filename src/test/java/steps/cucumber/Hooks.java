package steps.cucumber;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import utils.ScreenshotUtil;

public class Hooks extends Step {

    @Before
    public void before() throws MalformedURLException {
        setUp();
    }

    @After
    public void after(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            String screenshotPath = "target/screenshots/" + scenario.getName() + ".jpg";
            byte[] screenshot = ScreenshotUtil.takeScreenshot(driver);
            scenario.attach(screenshot, "image/png", "Screenshot");
            Allure.addAttachment("Screenshot", "image/png", Files.newInputStream(new File(screenshotPath).toPath()), "png");
        }
        tearDown();
    }
}
