package com.project.cutscad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class InventoryActivity extends AppCompatActivity {

    static String header = "Inventory";

    public static void setHeader(String text) {
        header = text;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);

        TextView textHeader = findViewById(R.id.textHeaderInventory);
        Button addButton = findViewById(R.id.addButtonInventory);

        textHeader.setText(header);
        String buttonText = "Add " + header + " category";
        addButton.setText(buttonText);
    }
}
