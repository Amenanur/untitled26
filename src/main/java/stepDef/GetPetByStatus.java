package stepDef;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class GetPetByStatus {
   Response response;


    @When("^I send get request to get all pet which has status (|available|pending|sold|)$")
   public void iSendGetRequestToGetAllPetWhichHasValidStatus(String status) {

        String url = "https://petstore.swagger.io/v2/pet/findByStatus";

        response= RestAssured.given()
                .accept(ContentType.JSON)
                   .contentType(ContentType.JSON)
                .queryParam("status",status)
                .when().log().all()
                .get(url);

response.then().log().all();
    }


    @When("^I send get request to get  pet which has (.*) status$")
    public void iSendGetRequestToGetPetWhichHasInvalidStatus(String status) {

        String url = "https://petstore.swagger.io/v2/pet/findByStatus";

        response= RestAssured.given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .queryParam("status",status)
                .when().log().all()
                .get(url);

        response.then().log().all();

    }

    @Then("I validate the successful response get by status")
    public void iValidateTheSuccessfulResponseGetByStatus() {
     response.then().statusCode(200);

    }

    @Then("^I validate the successful response get by invalid status")
    public void iValidateTheSuccessfulResponseGetByInvalidStatus() {
        response.then().statusCode(200);

    }




}
