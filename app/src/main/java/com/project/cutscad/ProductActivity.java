package com.project.cutscad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.project.cutscad.Models.Product;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {

    static ArrayList<Product> products;
    static String header = "";

    public static void setInformation(ArrayList<Product> list, String text) {
        products = list;
        header = text;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        TextView headerText = findViewById(R.id.textHeaderProduct);
        headerText.setText(header);

        ImageButton editButton = findViewById(R.id.editButtonProduct);

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProductActivity.this,
                        PopUpListActivity.class));
            }
        });
    }
}
