package steps;

import java.net.MalformedURLException;

import org.openqa.selenium.By;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CAHomePage;

public class CAHome extends Step {
    CAHomePage caHomePage;

    @Given("I am on the Cloud Academy home page")
    public void i_am_on_the_cloud_academy_home_page() {
        caHomePage = new CAHomePage(driver,wait);
        caHomePage.get();
    }

    @When("I search for {string}")
    public void i_search_for(String query) {
        caHomePage.search(query);
    }
    
    @Then("I should see a list of courses related to {string}")
    public void i_should_see_a_list_of_courses_related_to(String query) {
        wait.until(driver -> !driver.findElements(By.xpath("//h1[@data-cy='search-result-title']")).isEmpty());
        Assert.assertFalse(driver.findElements(By.xpath("//h1[@data-cy='search-result-title'][contains(text(),'" + query + "')]")).isEmpty());
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