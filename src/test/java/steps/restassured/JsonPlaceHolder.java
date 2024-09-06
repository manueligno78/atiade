package steps.restassured;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;


public class JsonPlaceHolder {
  
    @Given("check sanity of jsonplaceholder API")
    public static void setUp() {
    RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    Response response = RestAssured.get("/posts/1");
    Assert.assertEquals(response.getStatusCode(), 200);
    }
}
