package Jira;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.given;


public class _45_Get_Issue {
    public static void main(String[] args) {
        /*     here we have to get issue we can get all issue, but we have to get only command having id=10107       */

        RestAssured.baseURI = "http://localhost:8080";

        SessionFilter session = new SessionFilter();

        String response =
                given().header("Content-Type","application/json")
                        .body("{ \"username\": \"BobadePradip\", \"password\": \"Boba@1808\" }")
                        .filter(session).when().post("/rest/auth/1/session")
                        .then().extract().response().asString();
String issues =
        given().filter(session).pathParam("Key", "10101")
                .queryParam("fields", "comment")// this will get only comment section and if we remove this line then all issue will generate
                .when().get("/rest/api/2/issue/{Key}").then()
                .extract().response().asString();

       System.out.println(issues);
        /*  https://jsoneditoronline.org/#right=local.yiwusu&left=local.wuqine
        above link help to convert the response to the tree format
        That will help for getting the response.
         */

        JsonPath js = new JsonPath(issues);
        int count = js.getInt("fields.comment.comments.size()");

        for (int i =0;i<count;i++){
            System.out.println(js.getInt("fields.comment.comments["+i+"].id"));
            int idss = js.getInt("fields.comment.comments["+i+"].id");
            if (idss == 10106){
                System.out.println(js.getString("fields.comment.comments["+i+"].body"));
            }
        }







    }
}
