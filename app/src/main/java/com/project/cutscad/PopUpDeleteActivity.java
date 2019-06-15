package com.project.cutscad;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.project.cutscad.Models.ProductList;

public class PopUpDeleteActivity extends AppCompatActivity {

    static ProductList productList;
    static Boolean inInventory;

    public static void getInformation(ProductList list, Boolean value) {
        productList = list;
        inInventory = value;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_delete);

        // This part of the code makes it possible for the pop up window to appear on the screen.
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        getWindow().setLayout(width, height);

        // Whatever was on the screen before the pop up window appeared
        // and what is not behind the window will still be visible.
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        Button cancelButton = findViewById(R.id.cancelButtonPUD);
        Button deleteButton = findViewById(R.id.deleteButtonPUD);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InventoryActivity.removeProductList(productList);
                Toast.makeText(getApplicationContext(), "List permanently deleted.",
                        Toast.LENGTH_LONG).show();
                finish();

                if (!inInventory) {
                    startActivity(new Intent(PopUpDeleteActivity.this,
                            InventoryActivity.class));
                }
            }
        });
    }
}
