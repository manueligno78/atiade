package steps.cucumber;

import java.net.MalformedURLException;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends Step {

    @Before
    public void before() throws MalformedURLException {
        super.setUp();
    }

    @After
    public void after() {
        super.tearDown();
    }
    
}
