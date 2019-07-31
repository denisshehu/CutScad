package com.project.cutscad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.project.cutscad.Models.FoodCategory;
import com.project.cutscad.Models.Frequency;
import com.project.cutscad.Models.Product;
import com.project.cutscad.Models.ProductList;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class StartActivity extends AppCompatActivity {

    static ArrayList<ProductList> dairy = new ArrayList<>();
    static ArrayList<ProductList> cereals = new ArrayList<>();
    static ArrayList<ProductList> vegetables = new ArrayList<>();
    static ArrayList<ProductList> fruits = new ArrayList<>();
    static ArrayList<ProductList> meat = new ArrayList<>();
    static ArrayList<ProductList> seafood = new ArrayList<>();
    static ArrayList<ProductList> sugar = new ArrayList<>();
    static ArrayList<ProductList> alcohol = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        // All the buttons present in this activity are linked below.
        final Button dairyButton = findViewById(R.id.dairyButton);
        final Button cerealsButton = findViewById(R.id.cerealsButton);
        final Button vegetablesButton = findViewById(R.id.vegetablesButton);
        final Button fruitsButton = findViewById(R.id.fruitsButton);
        final Button meatButton = findViewById(R.id.meatButton);
        final Button seafoodButton = findViewById(R.id.seafoodButton);
        final Button sugarButton = findViewById(R.id.sugarButton);
        final Button alcoholButton = findViewById(R.id.alcoholButton);

//        Date expired = new Date(119, 6, 15);
//        Date notFresh = new Date(119, 6, 25);
//        Date fresh = new Date(119, 6, 30);
//        Product red = new Product(expired, 10, Frequency.DAY);
//        Product yellow = new Product(notFresh, 10, Frequency.DAY);
//        Product green = new Product(fresh, 10, Frequency.DAY);
//
//        ArrayList<Product> milks = new ArrayList<>();
//        milks.add(yellow);
//        milks.add(yellow);
//        milks.add(yellow);
//        milks.add(green);
//        milks.add(green);
//        milks.add(green);
//        milks.add(green);
//        milks.add(green);
//        ProductList milk = new ProductList("Milk", FoodCategory.DAIRY, 10, Frequency.DAY, milks);
//        dairy.add(milk);
//
//        ArrayList<Product> butters = new ArrayList<>();
//        butters.add(red);
//        butters.add(red);
//        butters.add(red);
//        butters.add(yellow);
//        butters.add(yellow);
//        butters.add(green);
//        butters.add(green);
//        butters.add(green);
//        ProductList butter = new ProductList("Butter", FoodCategory.DAIRY, 10, Frequency.DAY,  butters);
//        dairy.add(butter);
//
//        ArrayList<Product> yogurts = new ArrayList<>();
//        yogurts.add(red);
//        yogurts.add(red);
//        yogurts.add(yellow);
//        yogurts.add(green);
//        yogurts.add(green);
//        yogurts.add(green);
//        ProductList yogurt = new ProductList("Yogurt", FoodCategory.DAIRY, 10, Frequency.DAY,  yogurts);
//        dairy.add(yogurt);
//
//        ArrayList<Product> fetaCheeses = new ArrayList<>();
//        fetaCheeses.add(yellow);
//        fetaCheeses.add(yellow);
//        fetaCheeses.add(yellow);
//        fetaCheeses.add(green);
//        fetaCheeses.add(green);
//        ProductList fetaCheese = new ProductList("Feta cheese", FoodCategory.DAIRY, 10, Frequency.DAY, fetaCheeses);
//        dairy.add(fetaCheese);
//
//        ArrayList<Product> cottageCheeses = new ArrayList<>();
//        cottageCheeses.add(red);
//        cottageCheeses.add(yellow);
//        cottageCheeses.add(yellow);
//        cottageCheeses.add(green);
//        cottageCheeses.add(green);
//        ProductList cottageCheese = new ProductList("Cottage cheese", FoodCategory.DAIRY, 10, Frequency.DAY,  cottageCheeses);
//        dairy.add(cottageCheese);
//
//        ArrayList<Product> whiteBreads = new ArrayList<>();
//        whiteBreads.add(red);
//        whiteBreads.add(red);
//        whiteBreads.add(yellow);
//        whiteBreads.add(green);
//        whiteBreads.add(green);
//        whiteBreads.add(green);
//        ProductList whiteBread = new ProductList("White bread", FoodCategory.DAIRY, 10, Frequency.DAY, whiteBreads);
//        cereals.add(whiteBread);
//
//        ArrayList<Product> brownBreads = new ArrayList<>();
//        brownBreads.add(red);
//        brownBreads.add(red);
//        brownBreads.add(red);
//        brownBreads.add(red);
//        brownBreads.add(red);
//        brownBreads.add(yellow);
//        brownBreads.add(yellow);
//        brownBreads.add(green);
//        ProductList brownBread = new ProductList("Brown bread", FoodCategory.DAIRY, 10, Frequency.DAY,  brownBreads);
//        cereals.add(brownBread);
//
//        ArrayList<Product> baguettes = new ArrayList<>();
//        baguettes.add(red);
//        baguettes.add(yellow);
//        baguettes.add(yellow);
//        baguettes.add(yellow);
//        baguettes.add(green);
//        ProductList baguette = new ProductList("Baguette", FoodCategory.DAIRY, 10, Frequency.DAY,  baguettes);
//        cereals.add(baguette);
//
//        ArrayList<Product> bagels = new ArrayList<>();
//        bagels.add(red);
//        bagels.add(red);
//        bagels.add(green);
//        bagels.add(green);
//        bagels.add(green);
//        ProductList bagel = new ProductList("Bagel", FoodCategory.DAIRY, 10, Frequency.DAY, bagels);
//        cereals.add(bagel);
//
//        ArrayList<Product> breadRolls = new ArrayList<>();
//        breadRolls.add(yellow);
//        breadRolls.add(green);
//        breadRolls.add(green);
//        breadRolls.add(green);
//        breadRolls.add(green);
//        ProductList breadRoll = new ProductList("Bread roll", FoodCategory.DAIRY, 10, Frequency.DAY,  breadRolls);
//        cereals.add(breadRoll);
//
//        ArrayList<Product> tomatos = new ArrayList<>();
//        tomatos.add(red);
//        tomatos.add(red);
//        tomatos.add(red);
//        tomatos.add(yellow);
//        tomatos.add(yellow);
//        tomatos.add(yellow);
//        tomatos.add(green);
//        tomatos.add(green);
//        ProductList tomato = new ProductList("Tomato", FoodCategory.DAIRY, 10, Frequency.DAY,  tomatos);
//        vegetables.add(tomato);
//
//        ArrayList<Product> cucumbers = new ArrayList<>();
//        cucumbers.add(red);
//        cucumbers.add(yellow);
//        cucumbers.add(yellow);
//        cucumbers.add(yellow);
//        cucumbers.add(yellow);
//        cucumbers.add(green);
//        cucumbers.add(green);
//        cucumbers.add(green);
//        ProductList cucumber = new ProductList("Cucumber", FoodCategory.DAIRY, 10, Frequency.DAY,  cucumbers);
//        vegetables.add(cucumber);
//
//        ArrayList<Product> eggplants = new ArrayList<>();
//        eggplants.add(yellow);
//        eggplants.add(yellow);
//        eggplants.add(yellow);
//        eggplants.add(green);
//        eggplants.add(green);
//        eggplants.add(green);
//        eggplants.add(green);
//        eggplants.add(green);
//        eggplants.add(green);
//        ProductList eggplant = new ProductList("Eggplant", FoodCategory.DAIRY, 10, Frequency.DAY, eggplants);
//        vegetables.add(eggplant);
//
//        ArrayList<Product> garlics = new ArrayList<>();
//        garlics.add(red);
//        garlics.add(red);
//        garlics.add(yellow);
//        garlics.add(green);
//        garlics.add(green);
//        garlics.add(green);
//        garlics.add(green);
//        garlics.add(green);
//        ProductList garlic = new ProductList("Garlic", FoodCategory.DAIRY, 10, Frequency.DAY,  garlics);
//        vegetables.add(garlic);

        /*
        A click listener is assigned to each button.
         */

        dairyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startInventoryActivity(dairyButton); // This method is at the end of this file.
                InventoryActivity.setData(dairy);
            }
        });

        cerealsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startInventoryActivity(cerealsButton);
                InventoryActivity.setData(cereals);
            }
        });

        vegetablesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startInventoryActivity(vegetablesButton);
                InventoryActivity.setData(vegetables);
            }
        });

        fruitsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startInventoryActivity(fruitsButton);
                InventoryActivity.setData(fruits);
            }
        });

        meatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startInventoryActivity(meatButton);
                InventoryActivity.setData(meat);
            }
        });

        seafoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startInventoryActivity(seafoodButton);
                InventoryActivity.setData(seafood);
            }
        });

        sugarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startInventoryActivity(sugarButton);
                InventoryActivity.setData(sugar);
            }
        });

        alcoholButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startInventoryActivity(alcoholButton);
                InventoryActivity.setData(alcohol);
            }
        });
    }

    // This method sets the header of the inventory activity based on what button was pressed
    // and then starts the activity.
    public void startInventoryActivity(Button button) {
        InventoryActivity.setHeader(button.getText().toString());
        startActivity(new Intent(StartActivity.this, InventoryActivity.class));
    }

    public static ArrayList<ProductList> getData(String header) {
        FoodCategory foodCategory = ProductList.findCategory(header);
        switch (foodCategory) {
            case DAIRY:
                return dairy;
            case CEREALS:
                return cereals;
            case VEGETABLES:
                return vegetables;
            case FRUITS:
                return fruits;
            case MEAT:
                return meat;
            case SEAFOOD:
                return seafood;
            case SUGARY_FOODS:
                return sugar;
            case ALCOHOL:
                return alcohol;
        }
        return new ArrayList<>();
    }
}
