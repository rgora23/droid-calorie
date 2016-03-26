package com.example.rohan.droid_calorie.Model;

/**
 * Created by Rohan on 3/26/16.
 */
public class Food {

    private String foodName;
    private int calories;
    private double fat;
    private double carbs;
    private int protein;

    public Food(){

    }

    public Food(String foodName, int calories, float fat, float carbs, int protein){
        this.foodName = foodName;
        this.calories = calories;
        this.fat = fat;
        this.carbs = carbs;
        this.protein = protein;
    }

    public String getFoodName(){
        return foodName;
    }

    public void setFoodName(String foodName){
        this.foodName = foodName;
    }

    public int getCalories(){
        return calories;
    }

    public void setCalories(int calories){
        this.calories = calories;
    }

    public double getFat(){
        return fat;
    }

    public void setFat(int fat){
        this.fat = fat;
    }

    public double getCarbs(){
        return carbs;
    }

    public void setCarbs(float carbs){
        this.carbs = carbs;
    }

    public int getProtein(){
        return protein;
    }

    public void setProtein(int protein){
        this.protein = protein;
    }



}
