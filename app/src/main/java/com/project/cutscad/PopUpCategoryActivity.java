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
import android.widget.Toast;

import com.project.cutscad.Models.ProductList;

public class PopUpCategoryActivity extends Activity {

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
        RadioButton daysRadioButton = findViewById(R.id.daysRadioButton);
        RadioButton weeksRadioButton = findViewById(R.id.weeeksRadioButton);

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

        final EditText nameField = findViewById(R.id.nameFieldPUL);
        final EditText lifespanField = findViewById(R.id.lifespanFieldPUL);

        Button cancel = findViewById(R.id.cancelButtonPUL);
        Button add = findViewById(R.id.addButtonPUL);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                    ProductList a = new ProductList(name, InventoryActivity.header, lifespan);
                    finish();
                }
            }
        });
    }
}
