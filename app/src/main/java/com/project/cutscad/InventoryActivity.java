package com.project.cutscad;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InventoryActivity extends AppCompatActivity {

    static String header = "Inventory"; // This is the header/title of the activity.

    public static void setHeader(String text) {
        header = text;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);

        // Link the header of the activity and change it dependent on what button was pressed.
        TextView textHeader = findViewById(R.id.textHeaderInventory);
        textHeader.setText(header);

        // Link the add category button and change its text.
        Button addButton = findViewById(R.id.addButtonInventory);
        String buttonText = "Add " + header + " category";
        addButton.setText(buttonText);

        // A click listener is added to the button, when click the pop up window starts.
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pop up window title depends on which button was pressed on the start activity.
                PopUpCategoryActivity.setHeader(header.toLowerCase());
                startActivity(new Intent(InventoryActivity.this,
                        PopUpCategoryActivity.class));
            }
        });
    }
}
