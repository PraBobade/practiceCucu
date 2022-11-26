package _Section12_Serialization;
import io.restassured.RestAssured;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;


public class serializeTest {
    public static void main(String[] args) {
        List<String> typelist = new ArrayList<String>();
        typelist.add("shoe park");
        typelist.add("shoe");
        ChildLocation ch = new ChildLocation();
        ch.setLat(-38.383494);
        ch.setLng(33.427362);



        AddPlace add = new AddPlace();   // adding body
        add.setAccuracy(50);
        add.setName("pradip bobade");
        add.setPhone_number("(+91)985 652 36528");
        add.setAddress("90, by pass, kokan 96");
        add.setWebsite("http://google.com");
        add.setLanguage("Marathi");
        add.setTypes(typelist);     // this accepts the list so above we have created typelist
        add.setLocation(ch);        // this accepts the class so we have created class ch


        RestAssured.baseURI="https://rahulshettyacademy.com";
String res =
        given().queryParam("key", "qaclick123")
                .body(add).when().post("/maps/api/place/add/json").then().log().all() // in body, we have provided the object of the AddPlace
                .assertThat().statusCode(200).extract().response().asString();




    }
}
