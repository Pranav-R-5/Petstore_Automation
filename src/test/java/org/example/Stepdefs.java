package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;

public class Stepdefs {

    String baseUrl="https://petstore.swagger.io/v2/pet";
    PestStoreAPITest petstore=new PestStoreAPITest();
    Response response;
    JSONObject pet;

    @io.cucumber.java.en.Given("I hit the Url of the PetStore")
    public void iHitTheUrlOfThePetStore() {

        RestAssured.baseURI = baseUrl;
    }


    @When("I send the petobject in the request")
    public void iSendThePetobjectInTheRequest() {
       response= petstore.createPet(pet);
    }

    @Then("I recieve the response code as {int}")
    public void iRecieveTheResponseCodeAs(int statuscode) {
        petstore.assertion(statuscode,response);
    }

    @When("I send the id {string} in the request")
    public void iSendTheIdInTheRequest(String id) {
       response= petstore.getPet(id);
    }

//    @And("I create a pet JsonObject")
//    public void iCreateAPetJsonObject() {
//        pet=petstore.createPetObject();
//    }

    @When("I send the Updated petobject in request")
    public void iSendTheUpdatedPetobjectInRequest() {
       response= petstore.updateExisting(pet);
    }

    @And("I create a updated pet JsonObject")
    public void iCreateAUpdatedPetJsonObject() {
        pet=petstore.updatePetObj();
    }

    @When("I send the status {string} in the request")
    public void iSendTheStatusInTheRequest(String status) {
        response=petstore.getStatus(status);
    }

    @When("I send the id {string} in the deleterequest")
    public void iSendTheIdInTheDeleterequest(String id) {
        response=petstore.deletePet(id);
    }

    @When("I send the id {string} name {string} status {string}available")
    public void iSendTheIdNameStatusAvailable(String id, String name, String status) {
        petstore.updatepet(id,name,status);
    }

    @And("I create a pet JsonObject id {int} categoryId {int} categoryname {string} name {string} Photo {string} tagid {int} tagname {string} status {string}")
    public void iCreateAPetJsonObjectIdCategoryIdCategorynameNamePhotoTagidTagnameStatus(int arg0, int arg1, String arg2, String arg3, String arg4, int arg5, String arg6, String arg7) {
       pet= petstore.createPetObject(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    }
}
