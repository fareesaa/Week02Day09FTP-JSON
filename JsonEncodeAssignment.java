package Comp.Json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

class JsonEncodeAssignment {
    public static void main(String[] args){
        JSONArray jaCars1 = new JSONArray();
        jaCars1.add("Fiesta");
        jaCars1.add("Focus");
        jaCars1.add("Fanta");

        JSONObject obj1 = new JSONObject();
        obj1.put("name", "Ford");
        obj1.put("models",jaCars1);

        System.out.println(obj1);

        JSONArray jaCars2 = new JSONArray();
        jaCars2.add("X1");
        jaCars2.add("X3");
        jaCars2.add("X5");

        JSONObject obj2 = new JSONObject();
        obj2.put("name", "BMW");
        obj2.put("models",jaCars2);
        System.out.println(obj2);

        JSONArray jaCars3 = new JSONArray();
        jaCars3.add("Panda");
        jaCars3.add("500");

        JSONObject obj3 = new JSONObject();
        obj3.put("name", "Fiat");
        obj3.put("models",jaCars3);
        System.out.println(obj3);

        JSONArray arrCars = new JSONArray();
        arrCars.add(obj1);
        arrCars.add(obj2);
        arrCars.add(obj3);

        JSONObject obj = new JSONObject();
        obj.put("name","John");
        obj.put("age",30);
        obj.put("cars",arrCars);
        System.out.println(obj);

    }
}


