package com.project.cutscad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

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
            }
        });

        cerealsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startInventoryActivity(cerealsButton);
            }
        });

        vegetablesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startInventoryActivity(vegetablesButton);
            }
        });

        fruitsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startInventoryActivity(fruitsButton);
            }
        });

        meatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startInventoryActivity(meatButton);
            }
        });

        seafoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startInventoryActivity(seafoodButton);
            }
        });

        sugarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startInventoryActivity(sugarButton);
            }
        });

        alcoholButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startInventoryActivity(alcoholButton);
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
