package Jira;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;

import static io.restassured.RestAssured.given;

public class _40_LoginToJira {
    public static void main(String[] args) {
        RestAssured.baseURI ="http://localhost:8080";

        SessionFilter session = new SessionFilter();  // with this we can connect to the session.

                given().header("Content-Type","application/json")
                        .body("{ \"username\": \"BobadePradip\", \"password\": \"Boba@1808\" }")
                        .log().all().filter(session).when().post("/rest/auth/1/session").then().log().all();

    }
}
