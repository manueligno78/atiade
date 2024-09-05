package steps;

import java.net.MalformedURLException;

import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.GoogleHomePage;

public class GoogleSearchSteps extends Step {
    GoogleHomePage googleHomePage;

    @Given("I open Google homepage")
    public void i_open_google_homepage() throws MalformedURLException {
        googleHomePage = new GoogleHomePage(driver);
        googleHomePage.get();
    }

    @Then("I should see the search box")
    public void i_should_see_the_search_box() {
        Assert.assertTrue(googleHomePage.isSearchBoxDisplayed());
    }
    
    @Then("I should assert false")
    public void i_should_assert_false() {
        Assert.assertFalse(true);
    }
    
    @Before
    public void beforeScenario() throws MalformedURLException {
        setUp();
    }

    @After
    public void afterScenario() {
        tearDown();
    }
}