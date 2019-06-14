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

public class StartActivity extends AppCompatActivity {

    ArrayList<ProductList> dairy = new ArrayList<>();
    ArrayList<ProductList> cereals = new ArrayList<>();
    ArrayList<ProductList> vegetables = new ArrayList<>();
    ArrayList<ProductList> fruits = new ArrayList<>();
    ArrayList<ProductList> meat = new ArrayList<>();
    ArrayList<ProductList> seafood = new ArrayList<>();
    ArrayList<ProductList> sugar = new ArrayList<>();
    ArrayList<ProductList> alcohol = new ArrayList<>();

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

        ProductList milk = new ProductList("Milk", FoodCategory.DAIRY, 10, Frequency.DAY, new ArrayList<Product>());
        dairy.add(milk);

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
}
