package com.bupt.recommend.service.impl;

import com.bupt.recommend.DAO.BusinessPOMapper;
import com.bupt.recommend.DAO.PO.BusinessPO;
import com.bupt.recommend.DAO.PO.UserPO;
import com.bupt.recommend.DAO.UserPOMapper;
import com.bupt.recommend.service.DataIntoMysqlService;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Transactional
public class DataIntoMysqlServiceImpl implements DataIntoMysqlService {
    static String  businessPath = "C:\\Users\\dd\\Desktop\\yelp\\business.json";
    static String  userPath = "C:\\Users\\dd\\Desktop\\yelp\\user.json";
    static String  businessUserPath = "C:\\Users\\dd\\Desktop\\yelp\\user-business.txt";
    public static HashSet<String> userList = new HashSet<>();
    public static HashSet<String> businessList = new HashSet<>();

    @Autowired
    private  BusinessPOMapper businessPOMapper;
    @Autowired
    private UserPOMapper userPOMapper;
    @Override
    public void DataInsert() {
        File file = new File(businessUserPath);
        BufferedReader reader = null;
        String temp = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            while((temp=reader.readLine())!=null){
                String[] all = temp.split(" ");
                userList.add(all[1]);
                businessList.add(all[2]);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(userList.size()+" "+businessList.size());
        importBusiness();
        //importUser();
    }

    public  void importBusiness(){
        File file = new File(businessPath);
        BufferedReader reader = null;
        String temp = null;

        try{
            reader = new BufferedReader(new FileReader(file));
            while((temp=reader.readLine())!=null){
                JsonObject r = (JsonObject) new JsonParser().parse(temp);
                String businessId = r.get("business_id").getAsString();
                String pattern = "[a-zA-Z]+('?[a-zA-Z])?";
                Pattern p = Pattern.compile(pattern);
                if(businessList.contains(businessId)){
                    String full_address = r.get("full_address").getAsString();
                    int open = r.get("open").getAsBoolean()==true?1:0;
                    JsonArray categoriesArray = r.get("categories").getAsJsonArray();
                    StringBuilder categories = new StringBuilder();
                    for(JsonElement element:categoriesArray){
                        String e = element.getAsString().trim();
                        Matcher m = p.matcher(e);
                        while(m.find()){
                            categories.append(m.group()+".");
                        }
                    }
                    String category;
                    if(categories.length()>0){
                        category = categories.substring(0,categories.length()-1);
                    }else{
                        category = "";
                    }
                    //System.out.println(category);
                    String city = r.get("city").getAsString();
                    String name = r.get("name").getAsString();
                    int review_count = r.get("review_count").getAsInt();
                    Double longitude = r.get("longitude").getAsDouble();
                    Double latitude = r.get("latitude").getAsDouble();
                    int star = r.get("stars").getAsInt();
                    String state = r.get("state").getAsString();
                    //String attributes = r.get("attributes").getAsJsonObject().toString();
                    BusinessPO businessPO = new BusinessPO();
                    businessPO.setBusinessId(businessId);
                    businessPO.setFullAddress(full_address);
                    businessPO.setCategories(category);
                    businessPO.setCity(city);
                    businessPO.setName(name);
                    businessPO.setName(name);
                    businessPO.setReviewCount(review_count);
                    businessPO.setLongitude(longitude);
                    businessPO.setLatitude(latitude);
                    businessPO.setStars(star);
                    businessPO.setState(state);
                    //businessPO.setAttributes(attributes);
                    businessPO.setOpen(open);
                    businessPOMapper.insert(businessPO);
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void importUser(){
        File file = new File(userPath);
        BufferedReader reader = null;
        String temp = null;
        try{
            reader = new BufferedReader(new FileReader(file));
            while((temp=reader.readLine())!=null){
                JsonObject r = (JsonObject) new JsonParser().parse(temp);
                String userId = r.get("user_id").getAsString();
                if(userList.contains(userId)){
                    UserPO userPO = new UserPO();
                    userPO.setUserId(userId);
                    String name = r.get("name").getAsString();
                    int review_count = r.get("review_count").getAsInt();
                    double average_stars = r.get("average_stars").getAsDouble();
                    userPO.setAverageStars(average_stars);
                    userPO.setReviewCount(review_count);
                    userPO.setName(name);
                    userPOMapper.insert(userPO);
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
