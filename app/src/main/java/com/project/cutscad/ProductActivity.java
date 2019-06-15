package com.project.cutscad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.project.cutscad.Models.Product;
import com.project.cutscad.Models.ProductList;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {

    static ProductList products;
    static String header = "";

    static TextView headerText;

    public static void setInformation(ProductList list) {
        products = list;
        header = list.getListName();
    }

    public static void updatePage(ProductList list) {
        setInformation(list);
        headerText.setText(header);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        headerText = findViewById(R.id.textHeaderProduct);
        headerText.setText(header);

        ImageButton editButton = findViewById(R.id.editButtonProduct);
        ImageButton deleteButton = findViewById(R.id.deleteButtonProduct);

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProductActivity.this,
                        PopUpListActivity.class));
                PopUpListActivity.update(products, false);
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProductActivity.this,
                        PopUpDeleteActivity.class));
                PopUpDeleteActivity.getInformation(products, false);
            }
        });
    }
}
