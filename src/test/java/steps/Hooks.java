package steps;

import java.net.MalformedURLException;

import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends Step {
    
    private RemoteWebDriver driver;

    @Before
    public void before() throws MalformedURLException {
        super.setUp();
    }

    @After
    public void after() {
        super.tearDown();
    }
    
}
