package org.example;

import java.io.IOException;

public class Body {
    public static String body() throws IOException {
       // new String(Files.readAllBytes(Paths.get("C:\\driver\\folderName\\fileName.json")));
        // we can use above method to read the Json file without writing it as below
        return "{\n" +
                "  \"location\": {\n" +
                "    \"lat\": -38.383494,\n" +
                "    \"lng\": 33.427362\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \"Lixmi niwas\",\n" +
                "  \"phone_number\": \"(+91) 983 56 851 853\",\n" +
                "  \"address\": \"Issarawadi paithan Aurangabad\",\n" +
                "  \"pin_code\": \"431148\",\n" +
                "  \"types\": [\n" +
                "    \"glossary park\",\n" +
                "    \"shop\"\n" +
                "  ],\n" +
                "  \"website\": \"http://google.com\",\n" +
                "  \"language\": \"French-IN\"\n" +
                "}";
    }


    public static String Complex_22_NestedJson(){
        return "{\n" +
                "\"dashboard\": {\n" +
                                      "\"purchaseAmount\": 910,\n" +
                                      "\"website\": \"rahulshettyacademy.com\"\n" +
                              "},\n" +

                "\"courses\": [\n" +
                                   "{\n" +
                                         "\"title\": \"Selenium Python\",\n" +
                                         "\"price\": 50,\n" +
                                         "\"copies\": 6\n" +

                                    "}," +
                                    "{" +

                                         "\"title\": \"Cypress\",\n" +
                                         "\"price\": 40,\n" +
                                         "\"copies\": 4\n" +
                                    "},\n" +
                                    "{\n" +

                                         "\"title\": \"RPA\",\n" +
                                         "\"price\": 45,\n" +
                                         "\"copies\": 10\n" +

                                   "}\n" +

                             "]\n" +

                "}\n";

        /*
        {
  "dashboard": {
    "purchaseAmount": "910",
    "website": "rahulshettyacademy.com"
  },
  "courses": [
    {
      "title": "Selenium Python",
      "price": "50",
      "copies": "6"
    },
    {
      "title": "Cypress",
      "price": "40",
      "copies": "4"
    },
    {
      "title": "RPA",
      "price": "45",
      "copies": "10"
    }
  ]
}
         */
    }
}
