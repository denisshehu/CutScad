package com.project.cutscad;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class InventoryActivity extends AppCompatActivity {

    static String header = ""; // This is the header/title of the activity.

    public static void setHeader(String text) {
        header = text;
    }

    private ArrayList<String> headers = new ArrayList<>();
    private ArrayList<String> redProducts = new ArrayList<>();
    private ArrayList<String> orangeProducts = new ArrayList<>();
    private ArrayList<String> greenProducts = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);

        recyclerViewData();

        // Link the header of the activity and change it dependent on what button was pressed.
        TextView textHeader = findViewById(R.id.textHeaderInventory);
        textHeader.setText(header);

        // Link the add category button and change its text.
        Button addButton = findViewById(R.id.addButtonInventory);

        // A click listener is added to the button, when click the pop up window starts.
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InventoryActivity.this,
                        PopUpCategoryActivity.class));
            }
        });
    }

    private void recyclerViewData() {
        headers.add("Milk");
        redProducts.add("2");
        orangeProducts.add("2");
        greenProducts.add("2");

        headers.add("Yoghurt");
        redProducts.add("1");
        orangeProducts.add("2");
        greenProducts.add("1");

        headers.add("Feta cheese");
        redProducts.add("3");
        orangeProducts.add("1");
        greenProducts.add("4");

        headers.add("Butter");
        redProducts.add("3");
        orangeProducts.add("1");
        greenProducts.add("1");

        headers.add("Sour cream");
        redProducts.add("1");
        orangeProducts.add("1");
        greenProducts.add("1");

        headers.add("Cream cheese");
        redProducts.add("0");
        orangeProducts.add("1");
        greenProducts.add("1");

        headers.add("Cottage cheese");
        redProducts.add("0");
        orangeProducts.add("0");
        greenProducts.add("2");

        initializeRecyclerView();
    }

    private void initializeRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerViewInventory);
        InventoryRecyclerViewAdapter adapter = new InventoryRecyclerViewAdapter(headers,
                redProducts, orangeProducts, greenProducts, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
