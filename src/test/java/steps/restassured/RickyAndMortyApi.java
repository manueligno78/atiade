package steps.restassured;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RickyAndMortyApi {

    private static final String BASE_URL = "https://rickandmortyapi.com/api";
    private static final String GRAPHQL_URL = "https://rickandmortyapi.com/graphql";
    private Response response;
    private long startTime;
    private long endTime;

    @Given("the Rest API endpoint {string}")
    public void theRestApiEndpoint(String endpoint) {
        startTime = System.currentTimeMillis();
        response = RestAssured.get(BASE_URL + endpoint);
        endTime = System.currentTimeMillis();
    }

    @When("I send a GET request")
    public void iSendAGETRequest() {
        // The request is already sent in the @Given step
    }

    @Then("the status code should be {int}")
    public void theStatusCodeShouldBe(int statusCode) {
        Assert.assertEquals(response.getStatusCode(), statusCode);
    }

    @Then("the response body should contain {string}")
    public void theResponseBodyShouldContain(String content) {
        Assert.assertTrue(response.getBody().asString().contains(content));
    }

    @Then("the response time should be less than {int} second")
    public void theResponseTimeShouldBeLessThanSecond(int seconds) {
        Assert.assertTrue(endTime - startTime < seconds * 1000);
    }

    @Given("the GraphQL endpoint")
    public void theGraphQLEndpoint() {
        // No action needed, the endpoint is fixed
    }

    @Given("the query {string}")
    public void theQuery(String query) {
        startTime = System.currentTimeMillis();
        response = RestAssured.given()
                .contentType("application/json")
                .body("{\"query\": \"" + query + "\"}")
                .post(GRAPHQL_URL);
        endTime = System.currentTimeMillis();
    }

    @When("I send a POST request")
    public void iSendAPOSTRequest() {
        // The request is already sent in the @Given step
    }

    @Then("the response body should contain {string} for {string}")
    public void theResponseBodyShouldContainFor(String content, String path) {
        if (content.equals("null")) {
            content = null;
        }
        Assert.assertEquals(response.getBody().jsonPath().getString(path), content);
    }
}