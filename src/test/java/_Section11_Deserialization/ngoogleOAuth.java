package _Section11_Deserialization;

import _Section11_Deserialization.POJO.mainPOJO;
import io.restassured.parsing.Parser;

import static io.restassured.RestAssured.given;

public class ngoogleOAuth {
    public static void main(String[] args) throws InterruptedException {
        /*
   https://accounts.google.com/o/oauth2/v2/auth/identifier
   ?scope=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&auth_url=https%3A%2F%2Faccounts.google.com%2Fo%2Foauth2%2Fv2%2Fauth
   &client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com
   &response_type=code&redirect_uri=https%3A%2F%2Frahulshettyacademy.com%2FgetCourse.php&flowName=GeneralOAuthFlow

      copy this link and paste in chrome we get following url because we already signIn so NO need of email and password

         */

        String url = "https://rahulshettyacademy.com/getCourse.php?code=4%2F0AX4XfWh6Mey3MKyXoiLlBpHeZ5zKxr0GA9dhXbLTMt5-YkF0zMiYA3jui37N1GNNW9cSCw&scope=email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&authuser=0&prompt=none";

        String code = url.split("code=")[1].split("&scope")[0]; // here we have extracted code from above link
        String client_id = "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com";  // this is already defined given by company
        String client_secret = "erZOWM9g3UtwNRj340YYaK_W";   // this is already defined given by company
        String redirect_uri = "https://rahulshettyacademy.com/getCourse.php"; // after sending email and password we are re-direct to this url

        String Accesscode =    // here we have sent that code and get the AccessCode
                given().urlEncodingEnabled(false)    // in intellij if we have to pass some character like " such type of character intellij treat as /" then with this we can stop it.
                        .queryParam("code", code)
                        .queryParam("client_id", client_id)
                        .queryParam("client_secret", client_secret)
                        .queryParam("redirect_uri", redirect_uri)
                        .queryParam("grant_type", "authorization_code").when().post("https://www.googleapis.com/oauth2/v4/token")
                        .then().extract().response().asString();

        String AccessToken = Accesscode.split(",")[0].split(":")[1].trim().split("\"")[1];
        // here we have extracted the AccessToken from the above AccessCode1(response)

        mainPOJO response = // here we have sent AccessCode and get the response and this response we directly send to the mainPOJO class
        given().queryParam("access_token", AccessToken)
                .expect().defaultParser(Parser.JSON)    // this will treat the response as JSON otherwise it gets confuse.
                .when().get("https://rahulshettyacademy.com/getCourse.php")
                .then().extract().response().as(mainPOJO.class);

        int sizeOfApi = response.getCourses().getApi().size();
        for (int i =0;i<sizeOfApi;i++){
            if (response.getCourses().getApi().get(i).getCourseTitle().contains("SoapUI Webservices testing")){
                System.out.println(response.getCourses().getApi().get(i).getPrice());
            }
        }

        int sizeOfWeb= response.getCourses().getWebAutomation().size();
        for (int i=0;i<sizeOfWeb;i++){
            System.out.println(response.getCourses().getWebAutomation().get(i).getCourseTitle());
        }









    }
}
