package com.example.fooddiary;

public class Food {

    private String name;
    private String calories;
    private String protein;
    private String fat;
    private String carbohydrates;

    public Food(String name, String calories, String protein, String fat, String carbohydrates) {
        this.name = name;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.carbohydrates = carbohydrates;
    }

    public String getName() {
        return name;
    }

    public String getCalories() {
        return calories;
    }

    public String getProtein() {
        return protein;
    }

    public String getFat() {
        return fat;
    }

    public String getCarbohydrates() {
        return carbohydrates;
    }
}
