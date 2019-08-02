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
    static int updateMode = 0;

    TextView windowHeader;
    EditText nameField;
    EditText lifespanField;
    RadioButton daysRadioButton;
    RadioButton weeksRadioButton;
    Button cancel;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_category);

        windowHeader = findViewById(R.id.headerTextPUL);
        nameField = findViewById(R.id.nameFieldPUL);
        lifespanField = findViewById(R.id.lifespanFieldPUL);
        daysRadioButton = findViewById(R.id.daysRadioButton);
        weeksRadioButton = findViewById(R.id.weeeksRadioButton);
        cancel = findViewById(R.id.cancelButtonPUL);
        add = findViewById(R.id.addButtonPUL);

        showPopUp();
        setRadioButtons();

        if (updateMode != 0) {
            setUpdateMode();
        }

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateMode = 0;
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
                    if (updateMode != 0) {
                        updateInformation(name, lifespan);

                        if (updateMode == 2) {
                            ProductActivity.updatePage(productList);
                        }
                    } else {
                        ProductList productList = new ProductList(name,
                                ProductList.findCategory(InventoryActivity.getHeader()),
                                Integer.parseInt(lifespan),
                                ProductList.findFrequency(daysRadioButton),
                                new ArrayList<Product>());

                        InventoryActivity.addProductList(productList);

                        Toast.makeText(getApplicationContext(), "New list added.",
                                Toast.LENGTH_LONG).show();
                    }

                    updateMode = 0;
                    finish();
                }
            }
        });
    }

    private void showPopUp() {
        // This part of the code makes it possible for the pop up window to appear on the screen.
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        getWindow().setLayout(width, height);

        // Whatever was on the screen before the pop up window appeared
        // and what is not behind the window will still be visible.
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }

    // Link the radio buttons and make the color of their circle change to red when checked
    // and black otherwise.
    private void setRadioButtons() {
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
    }

    public static void update(ProductList products, Boolean inInventory) {
        header = "Update list";
        productList = products;
        if (inInventory) {
            updateMode = 1;
        } else {
            updateMode = 2;
        }
    }

    private void setUpdateMode() {
        windowHeader.setText(header);
        nameField.setText(productList.getListName());
        lifespanField.setText(Integer.toString(productList.getLifespan()));
        add.setText(R.string.updateButton);

        if (productList.getFrequency() == Frequency.DAY) {
            daysRadioButton.setChecked(true);
            weeksRadioButton.setChecked(false);
        } else {
            daysRadioButton.setChecked(false);
            weeksRadioButton.setChecked(true);
        }
    }

    private void updateInformation(String name, String lifespan) {
        Integer intLifespan = Integer.parseInt(lifespan);
        Frequency frequency = ProductList.findFrequency(daysRadioButton);
        productList.setListName(name);
        productList.setLifespan(intLifespan);
        productList.setFrequency(frequency);

        for (Product product : productList.getProducts()) {
            product.setLifespanInDays(product.initialLifespan(intLifespan, frequency));
            product.setExpirationDate();
            ProductActivity.adapter.notifyDataSetChanged();
        }

        InventoryActivity.adapter.notifyDataSetChanged();

        Toast.makeText(getApplicationContext(), "List information updated.",
                Toast.LENGTH_LONG).show();
    }
}
