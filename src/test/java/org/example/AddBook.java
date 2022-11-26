package org.example;

public class AddBook {
    public static String addbook(String isbn,String aisle){
       String st = "{\n" +
               "\n" +
               "\"name\":\" Appium Aution Java\",\n" +
               "\"isbn\":\""+isbn+"\",\n" +
               "\"aisle\":\""+aisle+"\",\n" +
               "\"author\":\"Jon foek\"\n" +
               "}\n";
        return st;
    }
}
