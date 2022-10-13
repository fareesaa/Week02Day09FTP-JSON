package Comp.Json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;

public class JsonDecodeAssignment {
    public static void main(String args[]) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        Reader reader = new StringReader("{\n" +
                " \"name\":\"John\",\n" +
                " \"age\":30,\n" +
                " \"cars\": [\n" +
                " { \"name\":\"Ford\", \"models\":[ \"Fiesta\", \"Focus\", \"Mustang\" ] },\n" +
                " { \"name\":\"BMW\", \"models\":[ \"320\", \"X3\", \"X5\" ] },\n" +
                " { \"name\":\"Fiat\", \"models\":[ \"500\", \"Panda\" ] }\n" +
                " ]\n" +
                " }\n");

        Object jsonObj = jsonParser.parse(reader);
        JSONObject jsonObject = (JSONObject) jsonObj;

        String name = (String) jsonObject.get("name");
        System.out.println("Name = " + name);

        long age = (Long) jsonObject.get("age");
        System.out.println("Age = " + age);

        JSONArray jsonArray = (JSONArray) jsonObject.get("cars");
        for(int i =0;i<jsonArray.size();i++){
            JSONObject objCars = (JSONObject) jsonArray.get(i);
/*            System.out.println(objCars);*/
            String name1 =(String) objCars.get("name");
            System.out.println("Brand = "+name1);
            JSONArray jsonArrayModel =(JSONArray) objCars.get("models");
            for (int j = 0; j < jsonArrayModel.size(); j++) {
                String objType = (String) jsonArrayModel.get(j);
                System.out.println("Type = "+objType);

            }
        }


        /*Iterator<Object> iterator = jsonArray.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
            JSONObject jsonObject1 = (JSONObject) iterator.next();

            JSONArray jsonArray1 = (JSONArray) jsonObject1.get("models");
            Iterator<Object> iterator1 = jsonArray.iterator();
            while (iterator1.hasNext()){
                System.out.println(iterator1.next());
            }
        }*/
        /*ArrayList<String> arCars = new ArrayList<>();
        arCars = (ArrayList<String>) jsonArray;

        for (String el:arCars) {
            System.out.println(el);
        }*/
    }

}
