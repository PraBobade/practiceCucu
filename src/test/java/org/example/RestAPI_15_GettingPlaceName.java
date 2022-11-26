package org.example;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

public class RestAPI_15_GettingPlaceName {
    public static void main(String[] args) {
// GET, POST, DELETE all these come after  .when()

        RestAssured.baseURI  = "https://rahulshettyacademy.com";

        given().queryParam("key", "qaclick123")
                .queryParam("place_id", "fada0cd0223fdf3d8ea8e0eef47e1891") // this place id is generated when we add the new place in above class
                .header("User-Agent","PostmanRuntime/7.28.4")
                .header("Connection","keep-alive")
                .when().get("maps/api/place/get/json").then().log().all();
    }
}
