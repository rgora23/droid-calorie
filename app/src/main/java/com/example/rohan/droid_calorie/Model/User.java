package com.example.rohan.droid_calorie.Model;

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

    public User(String userName){
        this.userName = userName;
        this.bodyWeight = 160;
        this.height = "5'9";
        this.bmi = 22.8;
        this.mealPlan = "Cutting";
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

