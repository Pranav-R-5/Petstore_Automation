package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;
import org.json.JSONObject;

import java.util.Collections;

import static io.restassured.RestAssured.given;

public class PestStoreAPITest {


    public static JSONObject createPetObject(int petid,int cid,String  cname,String name,String photourl,int tid,String tname,String status){
        JSONObject pet=new JSONObject();
        JSONObject category=new JSONObject();
        JSONObject tag=new JSONObject();

        pet.put("id",petid);
        category.put("id",cid);
        category.put("name",cname);
        pet.put("category",category);
        pet.put("name",name);
        pet.put("photoUrls",Collections.singletonList(photourl));
        tag.put("id",tid);
        tag.put("name",tname);
        pet.put("tags",Collections.singletonList(tag));
        pet.put("status",status);
        return pet;
    }
    public  static Response createPet ( JSONObject pet) {

//        RestAssured.baseURI = baseUrl;
        Response response = given()
                .contentType(ContentType.JSON)
                .and()
                .body(pet.toString())
                .when()
                .post()
                .then()
                .extract().response();
        response.prettyPrint();
//        Assert.assertEquals(200, response.statusCode());
//        System.out.println(response);
        return response;
    }

    public void assertion(int statuscode,Response response){

        Assert.assertEquals(statuscode, response.statusCode());
    }

    public static Response getPet(String id){
//        RestAssured.baseURI=baseUrl;
        Response response=given()
                .contentType(ContentType.JSON)
                .when()
                .get("/"+id)
                .then()
                .extract().response();
        response.prettyPrint();
//        org.junit.Assert.assertEquals(200,response.statusCode());
        return response;

    }

    public static void updatepet(String id,String name,String status){

//            RestAssured.baseURI = baseUrl;
            JSONObject obj = new JSONObject();
//            obj.put("id", Integer.parseInt(id));
            obj.put("name", name);
            obj.put("status", status);
            System.out.println(obj);

            Response response = given()
//                    .contentType(ContentType.JSON)
                    .contentType("multipart/form-data")
                    .multiPart("name",name)
                    .multiPart("status",status)
//                    .and()
//                    .body(obj.toString())
                    .when()
                    .post("/" + id)
                    .then()
                    .extract().response();
            response.prettyPrint();
            org.junit.Assert.assertEquals(200, response.statusCode());

    }

    public static JSONObject updatePetObj(){
        JSONObject pet=new JSONObject();
        JSONObject category=new JSONObject();
        JSONObject tag=new JSONObject();

        pet.put("id",9223);
        category.put("id",13);
        category.put("name","doberman");
        pet.put("category",category);
        pet.put("name","puggy");
        pet.put("photoUrls",Collections.singletonList("photourl5"));
        tag.put("id",13);
        tag.put("name","Tag15");
        pet.put("tags",Collections.singletonList(tag));
        pet.put("status","available");
        return  pet;
    }

    public static Response updateExisting(JSONObject pet){


//        RestAssured.baseURI = baseUrl;
        Response response = given()
                .contentType(ContentType.JSON)
                .and()
                .body(pet.toString())
                .when()
                .put()
                .then()
                .extract().response();
        response.prettyPrint();
//        Assert.assertEquals(200, response.statusCode());
//        System.out.println(response);
        return response;
    }

    public static Response getStatus(String status){
//        RestAssured.baseURI=baseUrl;
        Response response=given()
                .contentType(ContentType.JSON)
                .when()
                .get("/findByStatus?status="+status)
                .then()
                .extract().response();
        response.prettyPrint();
//        org.junit.Assert.assertEquals(200,response.statusCode());
        return response;

    }

    public static Response deletePet(String id){
//        RestAssured.baseURI=baseUrl;
        Response response=given()
                .contentType(ContentType.JSON)
                .when()
                .delete("/"+id)
                .then()
                .extract().response();
        response.prettyPrint();
//        org.junit.Assert.assertEquals(200,response.statusCode());
        return response;

    }



}
