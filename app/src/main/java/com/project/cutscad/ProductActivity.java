package com.project.cutscad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ProductActivity extends AppCompatActivity {

    static String header = "";

    public static void setHeader(String text) {
        header = text;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        TextView headerText = findViewById(R.id.textHeaderProduct);
        headerText.setText(header);
    }
}
