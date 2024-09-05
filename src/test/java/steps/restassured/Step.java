package steps.restassured;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;


public class Step {
  
    @Given("setup")
    public static void setUp() {

        // setup restassured
    RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    Response response = RestAssured.get("/posts/1");
    System.out.println("Response status code: " + response.getStatusCode());
    System.out.println("Response body: " + response.getBody().asString());

    }


    public static void tearDown() {
        // teardown restassured
    }
}
