package tests.api;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ReqresApiTest {
    @Test
    public void simpleStepByStepApiTest(){

        //Setup RestAssred
        RestAssured.baseURI = "https://reques.in/";

        //Setup endpoint
        int userID = 2;
        String endpoint = "/api/users/"+ userID;

        //
        RequestSpecification httpRequest = given();

        //Setup Responce object
        Response response = httpRequest.request(Method.GET, endpoint);

        //Get
        int statusCode = response.getStatusCode();
        System.out.println(statusCode);
        Assert.assertEquals(statusCode, 200);
        Assert.assertEquals(statusCode, HttpStatus.SC_OK);

        //Get Responce body
        String responceBody = response.getBody().asPrettyString();
        System.out.println(responceBody);



    }

    @Test
    public void simpleShortApiTest(){
        RestAssured.baseURI = "https://reques.in/";

        //Setup endpoint
        int userID = 2;
        String endpoint = "/api/users/"+ userID;

        given()
                .when()
                .get(endpoint)
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .log().body();


    }
}
