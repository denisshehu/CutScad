package com.project.cutscad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.project.cutscad.Models.FoodCategory;
import com.project.cutscad.Models.ProductList;

import java.util.ArrayList;

public class StartActivity extends AppCompatActivity {

    static ArrayList<ProductList> data = new ArrayList<>();
    static ArrayList<ProductList> inventoryData = new ArrayList<>();

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

        /*
        A click listener is assigned to each button.
         */

        dairyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startInventoryActivity(dairyButton); // This method is at the end of this file.
                getInventoryData(FoodCategory.DAIRY);
            }
        });

        cerealsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startInventoryActivity(cerealsButton);
                getInventoryData(FoodCategory.CEREALS);
            }
        });

        vegetablesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startInventoryActivity(vegetablesButton);
                getInventoryData(FoodCategory.VEGETABLES);
            }
        });

        fruitsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startInventoryActivity(fruitsButton);
                getInventoryData(FoodCategory.FRUITS);
            }
        });

        meatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startInventoryActivity(meatButton);
                getInventoryData(FoodCategory.MEAT);
            }
        });

        seafoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startInventoryActivity(seafoodButton);
                getInventoryData(FoodCategory.SEAFOOD);
            }
        });

        sugarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startInventoryActivity(sugarButton);
                getInventoryData(FoodCategory.SUGARY_FOODS);
            }
        });

        alcoholButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startInventoryActivity(alcoholButton);
                getInventoryData(FoodCategory.ALCOHOL);
            }
        });
    }

    // This method sets the header of the inventory activity based on what button was pressed
    // and then starts the activity.
    public void startInventoryActivity(Button button) {
        InventoryActivity.setHeader(button.getText().toString());
        startActivity(new Intent(StartActivity.this, InventoryActivity.class));
    }

    public void getInventoryData(FoodCategory foodCategory) {
        inventoryData.clear();
        for (ProductList productList: data) {
            if (productList.getFoodCategory().equals(foodCategory)) {
                inventoryData.add(productList);
            }
        }
        InventoryActivity.setData(inventoryData, foodCategory);
    }
}
