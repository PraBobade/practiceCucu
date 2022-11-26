package org.example;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RestAPI_17_AssertionResponceCheck {
    public static void main(String[] args) {
     /*    {
    "status": "OK",
    "place_id": "58ab2f5947661d64185c52e62bd04a0e",
    "scope": "APP",
    "reference": "6b51d1aa767c09d572eb417d9c925d1f6b51d1aa767c09d572eb417d9c925d1f",
    "id": "6b51d1aa767c09d572eb417d9c925d1f"
}
        after adding the place we get above response we have to check "scope": "APP", is this true for "scope" response.
         or we can do as is "status" is equal to "OK"
         */
     // if we put .header() after given then it acts as the input but if we put it after .then() then it acts as the output
        RestAssured.baseURI  = "https://rahulshettyacademy.com";
        given().log().all().queryParam("key", "qaclick123")
                .header("Content-Type","application/json")
                .body("{\n" +
                        "  \"location\": {\n" +
                        "    \"lat\": -38.383494,\n" +
                        "    \"lng\": 33.427362\n" +
                        "  },\n" +
                        "  \"accuracy\": 50,\n" +
                        "  \"name\": \"Lixmi niwas\",\n" +
                        "  \"phone_number\": \"(+91) 983 56 851 853\",\n" +
                        "  \"address\": \"Issarawadi paithan Aurangabad\",\n" +
                        "  \"pin_code\": \"431148\",\n" +
                        "  \"types\": [\n" +
                        "    \"glossary park\",\n" +
                        "    \"shop\"\n" +
                        "  ],\n" +
                        "  \"website\": \"http://google.com\",\n" +
                        "  \"language\": \"French-IN\"\n" +
                        "}")
                .when().post("maps/api/place/add/json").then().log().all()
                .assertThat().statusCode(200).body("scope",equalTo("APP"))
                .header("Connection", "Keep-Alive");

    }
}
