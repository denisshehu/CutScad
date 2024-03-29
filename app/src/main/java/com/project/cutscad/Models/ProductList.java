package com.project.cutscad.Models;

import android.widget.RadioButton;
import java.util.ArrayList;

public class ProductList {

    private String listName;
    private FoodCategory foodCategory;
    private Integer lifespan;
    private Frequency frequency;
    private ArrayList<Product> products;

    public ProductList(String listName, FoodCategory foodCategory, Integer lifespan,
                      Frequency frequency, ArrayList<Product> products) {
        this.listName = listName;
        this.foodCategory = foodCategory;
        this.lifespan = lifespan;
        this.frequency = frequency;
        this.products = products;
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

    public Frequency getFrequency() {
        return frequency;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public void setFoodCategory(FoodCategory foodCategory) {
        this.foodCategory = foodCategory;
    }

    public void setLifespan(Integer lifespan) {
        this.lifespan = lifespan;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public static Frequency findFrequency(RadioButton daysRadioButton) {
        if (daysRadioButton.isChecked()) {
            return Frequency.DAY;
        } else {
            return Frequency.WEEK;
        }
    }

    public ColoredProducts filterProducts() {
        return new ColoredProducts(products, lifespan);
    }
}
