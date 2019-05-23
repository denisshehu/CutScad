package com.project.cutscad.Models;

public class ProductList {

    private String listName;
    private FoodCategory foodCategory;
    private int lifespan;

    public ProductList(String listName, String foodCategory, String lifespan) {
        this.listName = listName;
        this.foodCategory = findCategory(foodCategory);
        this.lifespan = Integer.parseInt(lifespan);
    }

    public String getListName() {
        return listName;
    }

    public FoodCategory getFoodCategory() {
        return foodCategory;
    }

    public int getLifespan() {
        return lifespan;
    }

    private FoodCategory findCategory(String foodCategory) {
        switch (foodCategory.charAt(0)) {
            case 'd':
                return FoodCategory.DAIRY;
            case 'c':
                return FoodCategory.CEREALS;
            case 'v':
                return FoodCategory.VEGETABLES;
            case 'f':
                return FoodCategory.FRUITS;
            case 'm':
                return FoodCategory.MEAT;
            case 's':
                if (foodCategory.charAt(1) == 'e') {
                    return FoodCategory.SEAFOOD;
                } else {
                    return FoodCategory.SUGARY_FOODS;
                }
            default:
                return FoodCategory.ALCOHOL;
        }
    }
}
