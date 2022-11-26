package Jira;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import static io.restassured.RestAssured.given;

public class _42_Adding_comment {
    public static void main(String[] args) {
        RestAssured.baseURI = "http://localhost:8080";

        SessionFilter session = new SessionFilter();
        // this is use for collect the cookie and send it in to the following command send.
        // this step we can also do with JsonPath but here we have use this method.

        String response =
        given().header("Content-Type","application/json")
                .body("{ \"username\": \"BobadePradip\", \"password\": \"Boba@1808\" }")
                .log().all().filter(session).when().post("/rest/auth/1/session").then().log().all().extract().response().asString();
/*
above we have login to the jira and below we have sends command
.filter(session) here we have sends the cookie and its value we can also do this as
                       .header("cookie"."JSESSIONID=02280B053F871C4728B5AF2FE798FF1C")

 */

        given().pathParam("key", "10101").header("Content-Type","application/json")
                .body("{\n" +
                        "    \"body\": \"This is a comment last now we have to get id of this comment \",\n" +
                        "    \"visibility\": {\n" +
                        "        \"type\": \"role\",\n" +
                        "        \"value\": \"Administrators\"\n" +
                        "    }\n" +
                        "}").filter(session).when().post("/rest/api/2/issue/{key}/comment")
                .then().log().all().assertThat().statusCode(201).extract().response().asString();

// in .post we can direct send key of issue but here we have use .pathParam



    }
}
