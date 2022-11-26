package Practice;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class _00_GetAllEmployees {
/*
pre-Requisite for following Api

1. open command Prompt
2. Run: json-server firstApi.json                   firstApi is the fake Api that we have created on default location C:\Users\LENOVO>
3. then we get
  Resources
  http://localhost:3000/employees

  Home
  http://localhost:3000

  these are the Home and Resources by using this we can run following actions
 */


    public static void main(String[] args) {
        RestAssured.baseURI = "http://localhost:3000";
        Practice.pojo.Root response = given().log().all().when().get("employees").then().log().all().assertThat().statusCode(200)
                .extract().response().as(Practice.pojo.Root.class);



    }
}
