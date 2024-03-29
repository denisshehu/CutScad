package com.project.cutscad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.project.cutscad.Models.FoodCategory;
import com.project.cutscad.Models.ProductList;
import java.util.ArrayList;

public class InventoryActivity extends AppCompatActivity {

    private static ArrayList<ProductList> lists;
    private static FoodCategory foodCategory;
    private static String header = ""; // This is the header/title of the activity.

    public static void setData(ArrayList<ProductList> data, FoodCategory category) {
        lists = data;
        foodCategory = category;
    }

    public static void setHeader(String text) {
        header = text;
    }

    public static String getHeader() {
        return header;
    }

    static LinearLayout noListsText;
    static RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);

        buildRecyclerView();

        noListsText = findViewById(R.id.noListsText);
        checkVisibility();

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
                        PopUpListActivity.class));
                PopUpListActivity.setFoodCategory(foodCategory);
            }
        });
    }

    @Override
    public void onRestart() {
        super.onRestart();
        this.recreate();
    }

    private void buildRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerViewInventory);
        adapter = new ListRecyclerViewAdapter(lists, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public static void addProductList(ProductList productList) {
        StartActivity.data.add(productList);
        lists.add(productList);
        adapter.notifyItemInserted(lists.size() - 1);
        checkVisibility();
    }

    public static void removeProductList(ProductList productList) {
        remove(StartActivity.data, productList, false);
        remove(lists, productList, true);
    }

    public static void remove(ArrayList<ProductList> lists, ProductList productList,
                             boolean notifyAdapter) {
        int position = -1;
        ProductList list;

        for (int i = 0; i < lists.size(); i++) {
            list = lists.get(i);
            if (list == productList) {
                position = i;
                break;
            }
        }

        if (position != -1) {
            lists.remove(productList);
            if (notifyAdapter) {
                adapter.notifyItemRemoved(position);
                checkVisibility();
            }
        }
    }

    private static void checkVisibility() {
        if (lists.size() == 0) {
            noListsText.setVisibility(View.VISIBLE);
        } else {
            noListsText.setVisibility(View.INVISIBLE);
        }
    }
}
