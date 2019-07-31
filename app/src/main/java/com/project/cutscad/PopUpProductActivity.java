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

    public static void setLifespan(Integer number, Frequency period) {
        lifespan = number;
        frequency = period;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_product);

        showPopUp();

        final TextView purchaseDateField = findViewById(R.id.purchaseDateField);
        final TextView weightField = findViewById(R.id.weightField);
        Button cancelButton = findViewById(R.id.cancelButtonPUP);
        Button addButton = findViewById(R.id.addButtonPUP);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
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
                            finish();
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
}
