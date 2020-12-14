package com.bupt.recommend;

import com.bupt.recommend.DAO.PO.BusinessPO;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class gsonTest {
    static String  businessPath = "C:\\Users\\dd\\Desktop\\yelp\\business.json";
    static String  userPath = "C:\\Users\\dd\\Desktop\\yelp\\user.json";
    @Test
    public void gsTest(){
        File file = new File(businessPath);
        BufferedReader reader = null;
        String temp = null;
        try{
            reader = new BufferedReader(new FileReader(file));
            while((temp=reader.readLine())!=null){
                JsonObject r = (JsonObject) new JsonParser().parse(temp);
                String businessId = r.get("business_id").getAsString();
                String at = r.get("attributes").getAsJsonObject().toString();
                System.out.println(at);
                JsonArray ca = r.getAsJsonArray("categories");
                for(JsonElement e:ca){
                    System.out.println(e.getAsString());
                }

            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    @Test
    public void splitTest() {
        String e = "Arts & Entertainment";
        StringBuilder categories = new StringBuilder();
        String pattern = "[a-zA-Z]+('?[a-zA-Z])?";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(e);
        while(m.find()) {
            System.out.println(m.group());
        }

        System.out.println(categories.toString());
    }
}
