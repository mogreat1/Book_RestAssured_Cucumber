package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class StepDefinition extends Utils {

    private RequestSpecification res;
    private Response response;

    TestDataBuild data = new TestDataBuild();

    @Given("Add Book Payload with {string} and {string} and {string} and {string}")
    public void add_book_payload_with_and_and_and(String name, String isbn, String aisle, String author) throws IOException {
        res = given()
                .spec(requestSpecification())
                .body(data.addBookPayload(name, isbn, aisle, author));
    }

    @When("user calls {string} method with POST request")
    public void user_calls_method_with_post_request(String resource) {
            response = res
                    .when()
                    .post(APIResources.valueOf(resource).getResource());
    }

    @Then("response {string} and has {string} and has {string}")
    public void response_and_has_and_has(String code, String message, String ID) {
        assertEquals(response.getStatusCode(), Integer.parseInt(code));

        assertEquals(getJsonPath(response, "Msg"), message);
        assertEquals(getJsonPath(response, "ID"), ID);
    }
}
