package org.example;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

public class RestAPI_15_AddingPlace {
    public static void main(String[] args) {
        /*
       1)  given() :  all input methods   (key and key value, header,body)
                      in given we have to give key, key_value, header(Content-Type, application/json), body as shown in below line
       2)  when()  :  submit the API  (resources, http method)
                      in when we have to give resources and http method
       3)  Then()  :  validate the response
                      this will save the all detail

         */

       RestAssured.baseURI  = "https://rahulshettyacademy.com";
        given().queryParam("key", "qaclick123")
                .header("Content-Type","application/json")
                .body("{\n" +
                        "  \"location\": {\n" +        //  HERE WE CAN USE Body.body() method also in next class we have used it
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
                .when().post("maps/api/place/add/json").then().log().body().assertThat().statusCode(200);



//.assertThat().statusCode(200);  = if status code is not 200 then test will fail here if we remove this test will not fail here
// .log().all()  = this is use for to see all parameter in o/p no need of this if we remove this then only response is viewed in o/p





    }
}
//