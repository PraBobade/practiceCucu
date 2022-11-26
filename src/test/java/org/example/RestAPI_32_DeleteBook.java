package org.example;

import io.restassured.RestAssured;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RestAPI_32_DeleteBook {

    @Test(dataProvider = "iD")
    public void Delete(String isbn){
        RestAssured.baseURI = "http://216.10.245.166";
        String respon =
                given().log().all().header("Content-Type","application/json")
                        .body("{\n" +
                                "\"ID\" : \""+isbn+"\"\n" +
                                "}\n").when().post("Library/DeleteBook.php").then().log().all()
                        .extract().response().asString();
        System.out.println(respon);
    }

    @DataProvider(name = "iD")
    public Object[][] ID(){
        return new Object[][]  {{"aesd29342"},{"eowc5655"},{"sdfd99dl6"}};
    }



}
