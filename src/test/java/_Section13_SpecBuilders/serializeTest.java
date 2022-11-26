package _Section13_SpecBuilders;

import _Section12_Serialization.AddPlace;
import _Section12_Serialization.ChildLocation;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.util.ArrayList;
import java.util.List;
import static io.restassured.RestAssured.given;

public class serializeTest {
    public static void main(String[] args) {
        List<String> typelist = new ArrayList<>();
        typelist.add("shoe park");
        typelist.add("shoe");
        ChildLocation ch = new ChildLocation();
        ch.setLat(-38.383494);
        ch.setLat(33.427362);


        AddPlace add = new AddPlace();   // adding body
        add.setAccuracy(50);
        add.setName("pradip bobade");
        add.setPhone_number("(+91)985 652 36528");
        add.setAddress("90, by pass, kokan 96");
        add.setWebsite("http://google.com");
        add.setLanguage("Marathi");
        add.setTypes(typelist);     // this accepts the list so above we have created type list
        add.setLocation(ch);        // this accepts the class so we have created class ch

/*
RequestSpecBuilder  and   ResponseSpecBuilder   :
                      there are BaseUri, queryParam and many more these are common fields that are use many times in code so this is useful for it.
                      Request is useful for BaseUri and queryParam {After given() all parameters}
                      RequestSpecification req = new RequestSpecBuilder()

                      Response is useful for expected Status code expected content Type {After the then() all parameters}
                       ResponseSpecification res = new ResponseSpecBuilder()

                      like following way we can use Request and Response Spec Builders

 */
        RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
                .addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build(); //here ContentType is Optional
// do not forget    .build()    at last for both Request and Response
        ResponseSpecification res = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build(); //here ContentType is Optional



        RequestSpecification Re = given().spec(req).body(add);
        Response re = Re.when().post("/maps/api/place/add/json");
        String response = re.then().spec(res).extract().response().asString();

// we can write also as
        //       String response =  given().spec(req).body(add)when().post("/maps/api/place/add/json").then().spec(res).extract().response().asString();

        System.out.println(response);


    }
}
