package com.project.cutscad;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.project.cutscad.Models.Frequency;
import com.project.cutscad.Models.Product;
import com.project.cutscad.Models.ProductList;
import java.util.ArrayList;

public class PopUpListActivity extends Activity {

    static String header;
    static ProductList productList;
    static Boolean updating = false;

    public static void fillInformation(String headerText, ProductList products) {
        header = headerText;
        productList = products;
        updating = true;
    }

    RadioButton daysRadioButton;
    RadioButton weeksRadioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_category);

        /*
        This part of the code makes it possible for the pop up window to appear on the screen.
         */

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        getWindow().setLayout(width, height);

        // Whatever was on the screen before the pop up window appeared
        // and what is not behind the window will still be visible.
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        // Link the radio buttons and make the color of their circle change to red when checked
        // and black otherwise.
        daysRadioButton = findViewById(R.id.daysRadioButton);
        weeksRadioButton = findViewById(R.id.weeeksRadioButton);

        int red = getResources().getColor(R.color.colorPrimary);
        int black = getResources().getColor(R.color.colorPrimaryDark);
        ColorStateList colorStateList = new ColorStateList(
                new int[][] {
                        new int[] {-android.R.attr.state_checked}, // when not checked
                        new int[] {android.R.attr.state_checked} // when checked
                },
                new int[] {
                        black, // color corresponding to not checked
                        red // when checked
                }
        );

        daysRadioButton.setButtonTintList(colorStateList);
        weeksRadioButton.setButtonTintList(colorStateList);

        TextView windowHeader = findViewById(R.id.headerTextPUL);

        final EditText nameField = findViewById(R.id.nameFieldPUL);
        final EditText lifespanField = findViewById(R.id.lifespanFieldPUL);

        Button cancel = findViewById(R.id.cancelButtonPUL);
        Button add = findViewById(R.id.addButtonPUL);

        if (updating) {
            windowHeader.setText(header);
            nameField.setText(productList.getListName());
            lifespanField.setText(Integer.toString(productList.getLifespan()));
            if (productList.getFrequency() == Frequency.DAY) {
                daysRadioButton.setChecked(true);
                weeksRadioButton.setChecked(false);
            } else {
                daysRadioButton.setChecked(false);
                weeksRadioButton.setChecked(true);
            }
            add.setText(R.string.updateButton);
        }

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updating = false;
                finish();
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = nameField.getText().toString().trim();
                String lifespan = lifespanField.getText().toString().trim();

                if (name.length() == 0 || lifespan.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please fill in both fields.",
                            Toast.LENGTH_LONG).show();
                } else {
                    if (updating) {
                        productList.setListName(name);
                        productList.setLifespan(Integer.parseInt(lifespan));
                        productList.setFrequency(ProductList.findFrequency(daysRadioButton));
                        InventoryActivity.adapter.notifyDataSetChanged();
                        Toast.makeText(getApplicationContext(), "List information updated.",
                                Toast.LENGTH_LONG).show();
                    } else {
                        ProductList productlist = new ProductList(name,
                                ProductList.findCategory(InventoryActivity.getHeader()),
                                Integer.parseInt(lifespan),
                                ProductList.findFrequency(daysRadioButton),
                                new ArrayList<Product>());
                        InventoryActivity.addProductList(productlist);
                        Toast.makeText(getApplicationContext(), "New list added.",
                                Toast.LENGTH_LONG).show();
                    }
                    updating = false;
                    finish();
                }
            }
        });
    }
}
