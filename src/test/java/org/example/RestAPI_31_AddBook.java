package org.example;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RestAPI_31_AddBook {
    @Test(dataProvider = "BooksOfData")
    public void AddBooks(String isbn,String aisle){
        RestAssured.baseURI = "http://216.10.245.166";
        String respon =
        given().header("Content-Type","application/json")
                .body(AddBook.addbook(isbn,aisle)).when().post("Library/Addbook.php").then().assertThat().statusCode(200)
                .extract().response().asString();

        JsonPath js = new JsonPath(respon);
        String id = js.get("ID").toString();
        System.out.println(id);

    }

    @DataProvider(name = "BooksOfData")
    public Object[][] getDate(){
       return new Object[][]  {{"sdfd","99dl6"},{"aesd2","9342"},{"eowc","5655"}};
    }
}
