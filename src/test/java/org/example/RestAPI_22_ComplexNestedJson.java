package org.example;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

@Test
public class RestAPI_22_ComplexNestedJson {
    public static void main(String[] args) {



        JsonPath js = new JsonPath(Body.Complex_22_NestedJson());

         List<Object> NoCourse = js.getList("courses");
        String purchaseAmount = js.getString("dashboard.purchaseAmount");
        List<Object> CourseName = js.getList("courses.title");
        List<Object> Price = js.getList("courses.price");
        List<Object> copies = js.getList("courses.copies");

        System.out.println("There are "+ NoCourse.size() +" courses"); // Another Method
        System.out.println(js.getInt("courses.size()\n")); // no need of \n

        System.out.println("The purchase amount is : "+purchaseAmount);

        System.out.println("The first course is : "+CourseName.get(0));
        System.out.println(js.getString("courses[0].title"));

        for (int i =0;i< Price.size();i++){
            System.out.println((i+1)+") course : "+CourseName.get(i)+"    Price : "+Price.get(i));
            if (js.get("courses.title["+i+"]").toString().equalsIgnoreCase("Cypress")){
                System.out.println("course is :  "+js.get("courses.title["+i+"]").toString()+" and no of copies are : "+js.get("courses["+i+"].copies").toString());

            }
        }
      int  TotalAmount = 0;
        for (int i =0;i< Price.size();i++){
           int Total = Integer.parseInt(String.valueOf(Price.get(i)))* Integer.parseInt(String.valueOf(copies.get(i)));
            TotalAmount = TotalAmount +Total;
        }

        Assert.assertEquals(Integer.parseInt(purchaseAmount),TotalAmount);
        System.out.println("\n"+TotalAmount);


    }
}
