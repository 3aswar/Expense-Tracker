package com.example.t;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class home extends AppCompatActivity{

    Button btnFood, btnTravel, btnGroceries, btnShopping, btnOther, btnAnalyze;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnFood = findViewById(R.id.btn_food);
        btnTravel = findViewById(R.id.btn_travel);
        btnGroceries = findViewById(R.id.btn_groceries);
        btnShopping = findViewById(R.id.btn_shopping);
        btnOther = findViewById(R.id.btn_other);
        btnAnalyze = findViewById(R.id.btn_analyze);


        btnFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ab=new Intent(home.this, FoodActivity.class);
                startActivity(ab);
            }
        });
        btnTravel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ab=new Intent(home.this, TravelActivity.class);
                startActivity(ab);
            }
        });
        btnGroceries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ab=new Intent(home.this, GroceriesActivity.class);
                startActivity(ab);
            }
        });
        btnShopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ab=new Intent(home.this, ShoppingActivity.class);
                startActivity(ab);
            }
        });
        btnOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ab=new Intent(home.this, OtherActivity.class);
                startActivity(ab);
            }
        });
        btnAnalyze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ab=new Intent(home.this, PieActivity.class);
                startActivity(ab);
            }
        });



    }

}