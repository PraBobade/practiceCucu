package Practice;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class _02_DeleteEmployee {
    public static void main(String[] args) {
        RestAssured.baseURI =("http://localhost:3000");

      String  ja =  given().when().delete("employees/6").then().log().body()
              .assertThat().statusCode(200).extract().response().asString();
    }
}
