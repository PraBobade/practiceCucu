package Practice;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class _01_AddEmployee {
    public static void main(String[] args) {


      RestAssured.baseURI = ("http://localhost:3000");
      String respon =  given().log().all().body("{\n" +
                "\t\t\"name\": \"Dinesh Kartik\",\n" +
                "\t\t\"location\": \"dil se delhi\",\n" +
                "\t\t\"phone\": \"dont no\",\n" +
                "\t\t\"courses\": [\n" +
                "\t\t\t\"Capital wali delhi\",\n" +
                "\t\t\t\"quarter day internation\"\n" +
                "\t\t]\n" +
                "}\n").when().post("employees").then().log().all().assertThat().statusCode(201).extract().response().asString();


    }
}
