package org.example;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RestAPI_18_JsonPath {
    public static void main(String[] args) throws IOException {
        /*
        JsonPath is the method use for extracting the values of the parameter
        ex.    "place_id": "2fabb30f34f58c8f4c4a5805ec60e17b",
        for place_id we have to extract its value 2fabb30f34f58c8f4c4a5805ec60e17b
         */
        RestAssured.baseURI  = "https://rahulshettyacademy.com";
       String response = given().log().all().queryParam("key", "qaclick123")
                .header("Content-Type","application/json")
                .body(Body.body()) // HERE WE HAVE USE THE Body.body() method to called the body this make the steps minimum.
                .when().post("maps/api/place/add/json").then()
                .assertThat().statusCode(200).body("scope",equalTo("APP"))
                .header("Connection", "Keep-Alive")
                .extract().response().asString();

// .extract().response().asString(); = this will return the response in String format now using JsonPath method we can extract the place_id value.

        System.out.println(response);  // this will give the response in string format
        JsonPath jp = new JsonPath(response);
        String placeID = jp.getString("place_id");     // this give the place_id
        System.out.println(placeID + "   :  is the place id");

// HERE WE HAVE SUCCESSFULLY EXTRACTED PLACE NOW WE HAVE TO UPDATE THE PLACE

        given().log().all().queryParam("key", "qaclick123")
                .header("Content-Type","application/json")
                .body("{\n" +
                        "\"place_id\":\""+placeID+"\",\n" +
                        "\"address\":\"90 winter running, UK\",\n" +
                        "\"key\":\"qaclick123\"\n" +
                        "}").put("maps/api/place/update/json").then().assertThat().statusCode(200)
                .body("msg", equalTo("Address successfully updated"));

// NOW WE ARE GETTING THE PLACE
    String res  =    given().queryParam("key", "qaclick123")
                .queryParam("place_id", placeID) // this place id is generated when we add the new place in above class
                // now need of header
                .when().get("maps/api/place/get/json").then().log().all()
                .body("address", equalTo("90 winter running, UK")).extract().response().asString();


        JsonPath fj = new JsonPath(res);
        Assert.assertEquals(fj.getString("address"), "90 winter running, UK");
        System.out.println(fj.getString("address"));

    }
}
