package Steps;

import Utils.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.io.IOException;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class apiSteps{

    String url="https://api.github.com/";

    Response response =  given().accept(ContentType.JSON)
            .and().pathParam("username","PhotoBox")
            .when().get(url + "users/{username}");

    String actualName=response.path("name");
    int actualStatusCode=response.statusCode();

    @Given("User landed to Github page")
    public void userLandedToGithubPage() {

                 given().accept(ContentType.JSON)
                .and().pathParam("username","PhotoBox")
                .when().get(url + "users/{username}");
    }


    @And("user pass a username as {string}")
    public void userPassAUsernameAs(String usernameValue) {

                 given().accept(ContentType.JSON)
                .and().pathParam("username",usernameValue);
    }

    @When("I GET request to {string}")
    public void iGETRequestTo(String endPoint) {

                given().accept(ContentType.JSON)
                .and().pathParam("username","PhotoBox")
                .when().get(url + endPoint );
    }

    @Then("response status code should be {int}")
    public void responseStatusCodeShouldBe(int statusCode) {

        assertEquals(statusCode,actualStatusCode);

    }

    @And("I verify name as a {string}")
    public void iverifyNameAsA(String usernameValue){

        assertEquals(usernameValue,actualName);

    }

}
