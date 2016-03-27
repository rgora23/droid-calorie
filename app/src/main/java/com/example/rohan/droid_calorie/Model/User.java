package com.example.rohan.droid_calorie.Model;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Rohan on 3/26/16.
 */
public class User {

    private String userName;
    private double bodyWeight;
    private String height;
    private double bmi;
    private String mealPlan;

    public User(){

    }

    public User(String userName, double bodyWeight, String height, double bmi, String mealPlan){
        this.userName = userName;
        this.bodyWeight = bodyWeight;
        this.height = height;
        this.bmi = bmi;
        this.mealPlan = mealPlan;
    }

    public static ArrayList<User> loadSampleUsers() {
        ArrayList<User> users = new ArrayList<>();
        User rohan = new User("Rohan Gorawala", 160, "5'9", 22.8, "cutting");
        User josh = new User("Josh Sexton", 198, "6'0", 22, "maintaining");
        User obama = new User("Barack Obama", 178, "5'10", 45, "bulking");
        users.add(rohan);
        users.add(josh);
        users.add(obama);
        return users;
    }

    @Override
    public String toString(){
        return userName;
    }

    public String getUserName(){
        return userName;
    }

    public void setUserName(String firstName){
        this.userName = firstName;
    }

    public double getBodyWeight(){
        return bodyWeight;
    }

    public void setBodyWeight(double bodyWeight){
        this.bodyWeight = bodyWeight;
    }

    public String getHeight(){
        return height;
    }

    public void setHeight(String height){
        this.height = height;
    }

    public double getBmi(){
        return bmi;
    }

    public void setBmi(double bmi){
        this.bmi = bmi;
    }

    public String getMealPlan(){
        return mealPlan;
    }

    public void setMealPlan(String mealPlan){
        this.mealPlan = mealPlan;
    }

}

