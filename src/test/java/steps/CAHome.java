package steps;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CAHomePage;

public class CAHome extends Step {
    CAHomePage caHomePage;

    @Given("I am on the Cloud Academy home page")
    public void i_am_on_the_cloud_academy_home_page() throws MalformedURLException {
        setUp();
        driver.get("https://platform.qa.com/library/");
        caHomePage = new CAHomePage(driver);
    }

    @When("I search for {string}")
    public void i_search_for(String query) {
        caHomePage.search(query);
    }
    
    @Then("I should see a list of courses related to {string}")
    public void i_should_see_a_list_of_courses_related_to(String query) {
        //cerca il div dei risultati suggeriti possiede la classe "react-autowhatever-1", e verifica che al suo interno ci siano elementi figli che contengono il testo del risultato atteso
        Assert.assertTrue(driver.findElements(By.xpath("//div[@class='react-autowhatever-1']//*[contains(text(),'" + query + "')]")).size() > 0);
        //Assert.assertTrue(driver.findElements(By.xpath("//div[@class='react-autowhatever-1']//*[]")).size() > 0);
        tearDown(null);
    }
}