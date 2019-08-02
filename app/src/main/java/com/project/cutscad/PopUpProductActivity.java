package com.project.cutscad;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.project.cutscad.Models.Frequency;
import com.project.cutscad.Models.Product;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PopUpProductActivity extends AppCompatActivity {

    private static Integer lifespan;
    private static Frequency frequency;
    private DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    private static Product product;
    private static boolean updateMode;

    TextView header;
    TextView purchaseDateField;
    TextView weightField;
    Button cancelButton;
    Button addButton;

    public static void setLifespan(Integer number, Frequency period) {
        lifespan = number;
        frequency = period;
    }

    public static void update(Product p) {
        updateMode = true;
        product = p;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_product);

        header = findViewById(R.id.headerTextPUP);
        purchaseDateField = findViewById(R.id.purchaseDateField);
        weightField = findViewById(R.id.weightField);
        cancelButton = findViewById(R.id.cancelButtonPUP);
        addButton = findViewById(R.id.addButtonPUP);

        showPopUp();

        if (updateMode) {
            setUpdateMode();
        }

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                updateMode = false;
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String purchaseDate = purchaseDateField.getText().toString().trim();
                String weight = weightField.getText().toString().trim();

                boolean weightPresent = weight.length() != 0;

                java.util.Date purchase;
                format.setLenient(false);

                if (purchaseDate.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please fill in the purchase date.",
                            Toast.LENGTH_LONG).show();
                } else {
                    try {
                        purchase = format.parse(purchaseDate);

                        long milliseconds = purchase.getTime();

                        if (Calendar.getInstance().getTimeInMillis() - milliseconds < 0) {
                            Toast.makeText(getApplicationContext(),
                                    "Invalid date input. The purchase day you provided is in the future.",
                                    Toast.LENGTH_LONG).show();
                        } else {
                            if (updateMode) {
                                product.setPurchaseDate(purchase);
                                if (weight.trim().length() != 0) {
                                    product.setWeight(Double.valueOf(weight));
                                } else {
                                    product.setWeight(null);
                                }
                                product.setExpirationDate();
                                ProductActivity.adapter.notifyDataSetChanged();
                            } else {
                                if (weightPresent) {
                                    Product product = new Product(purchase, lifespan, frequency,
                                            Double.valueOf(weight));
                                    ProductActivity.addProduct(product);
                                } else {
                                    Product product = new Product(purchase, lifespan, frequency);
                                    ProductActivity.addProduct(product);
                                }

                                Toast.makeText(getApplicationContext(),
                                        "New product added.",
                                        Toast.LENGTH_LONG).show();
                            }

                            finish();
                            updateMode = false;
                        }
                    } catch (ParseException e) {
                        Toast.makeText(getApplicationContext(),
                                "Invalid date input. Please write it in the dd/mm/yyyy format.",
                                Toast.LENGTH_LONG).show();
                    }
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

    private void setUpdateMode() {
        header.setText("Update product");
        addButton.setText("Update");

        purchaseDateField.setText(product.fillPurchaseField());
        if (product.getWeight() != null) {
            weightField.setText(product.fillWeightField());
        }
    }
}
