package com.example.t;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

 class monthlyActivity extends AppCompatActivity {
    private TextView foodTextView, travelTextView, shoppingTextView, groceriesTextView, otherTextView;
    private EditText foodEditText, travelEditText, shoppingEditText, groceriesEditText, otherEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_month);

        foodTextView = findViewById(R.id.foodTextView);
        travelTextView = findViewById(R.id.travelTextView);
        shoppingTextView = findViewById(R.id.shoppingTextView);
        groceriesTextView = findViewById(R.id.groceriesTextView);
        otherTextView = findViewById(R.id.otherTextView);

        foodEditText = findViewById(R.id.foodEditText);
        travelEditText = findViewById(R.id.travelEditText);
        shoppingEditText = findViewById(R.id.shoppingEditText);
        groceriesEditText = findViewById(R.id.groceriesEditText);
        otherEditText = findViewById(R.id.otherEditText);
    }

}