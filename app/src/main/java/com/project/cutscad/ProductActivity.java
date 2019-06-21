package com.project.cutscad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.project.cutscad.Models.Product;
import com.project.cutscad.Models.ProductList;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {

    static ProductList products;
    static String header = "";

    static TextView headerText;
    static LinearLayout noProductsText;
    static RecyclerView.Adapter adapter;

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

        buildRecyclerView();

        noProductsText = findViewById(R.id.noProductsText);
        checkVisibility();

        ImageButton editButton = findViewById(R.id.editButtonProduct);
        ImageButton deleteButton = findViewById(R.id.deleteButtonProduct);
        Button addButton = findViewById(R.id.addButtonProduct);

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
                PopUpDeleteActivity.productListInformation(products, false);
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProductActivity.this,
                        PopUpProductActivity.class));
                PopUpProductActivity.setLifespan(products.getLifespan());
            }
        });
    }

    private void buildRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerViewProduct);
        adapter = new ProductRecyclerViewAdapter(products, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public static void addProduct(Product product) {
        products.getProducts().add(product);
        adapter.notifyItemInserted(products.getProducts().size() - 1);
        checkVisibility();
    }

    public static void removeProduct(Product product) {
        int position = -1;
        ArrayList<Product> items = products.getProducts();

        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) == product) {
                position = i;
                break;
            }
        }

        products.getProducts().remove(product);
        adapter.notifyItemRemoved(position);
        checkVisibility();
    }

    private static void checkVisibility() {
        if (products.getProducts().size() == 0) {
            noProductsText.setVisibility(View.VISIBLE);
        } else {
            noProductsText.setVisibility(View.INVISIBLE);
        }
    }
}
