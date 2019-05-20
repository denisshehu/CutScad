package com.project.cutscad;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.RadioButton;
import android.widget.TextView;

public class PopUpCategoryActivity extends Activity {

    static String header = "New inventory category"; // Pop up window header

    public static void setHeader(String text) {
        header = text;
    }

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

        // Link the header of the pop up window and change it dependent on the food category.
        TextView textHeader = findViewById(R.id.textHeaderPopUpC);
        String text = "New " + header + " category";
        textHeader.setText(text);

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
    }
}
