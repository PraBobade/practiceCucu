package Jira;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import java.io.File;
import static io.restassured.RestAssured.given;


public class _44_Add_Attachment {
    public static void main(String[] args) {
        RestAssured.baseURI = "http://localhost:8080";

        SessionFilter session = new SessionFilter();

        String response =
                given().header("Content-Type","application/json")
                        .body("{ \"username\": \"BobadePradip\", \"password\": \"Boba@1808\" }")
                        .log().all().filter(session).when().post("/rest/auth/1/session")
                        .then().log().all().extract().response().asString();

        given().header("X-Atlassian-Token","no-check").filter(session)
                .pathParam("Key", "10101")
                .header("Content-Type","multipart/form-data")
                .multiPart("file",new File("C:\\Users\\LENOVO\\Desktop\\API\\JIRA\\AddingFile.txt")).when()
                .post("/rest/api/2/issue/{Key}/attachments").then().log().all().assertThat().statusCode(200);




    }
}
