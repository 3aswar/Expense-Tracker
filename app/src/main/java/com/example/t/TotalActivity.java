package com.example.t;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Locale;

public class TotalActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private TextView groceriesTotal, foodTotal, shoppingTotal, travelTotal, otherTotal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("expenses");
        groceriesTotal = findViewById(R.id.groceries_total);
        foodTotal = findViewById(R.id.food_total);
        shoppingTotal = findViewById(R.id.shopping_total);
        travelTotal = findViewById(R.id.travel_total);
        otherTotal = findViewById(R.id.other_total);

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                double groceriesSum = 0;
                double foodSum = 0;
                double shoppingSum = 0;
                double travelSum = 0;
                double otherSum = 0;

                for (DataSnapshot categorySnapshot : dataSnapshot.getChildren()) {
                    String category = categorySnapshot.getKey();
                    if (category.equals("Groceries")) {
                        for (DataSnapshot expenseSnapshot : categorySnapshot.getChildren()) {
                            double amount = expenseSnapshot.child("amount").getValue(Double.class);
                            groceriesSum += amount;
                        }
                        groceriesTotal.setText(String.format(Locale.getDefault(), "%.2f", groceriesSum));
                    } else if (category.equals("food")) {
                        for (DataSnapshot expenseSnapshot : categorySnapshot.getChildren()) {
                            double amount = expenseSnapshot.child("amount").getValue(Double.class);
                            foodSum += amount;
                        }
                        foodTotal.setText(String.format(Locale.getDefault(), "%.2f", foodSum));
                    } else if (category.equals("shopping")) {
                        for (DataSnapshot expenseSnapshot : categorySnapshot.getChildren()) {
                            double amount = expenseSnapshot.child("amount").getValue(Double.class);
                            shoppingSum += amount;
                        }
                        shoppingTotal.setText(String.format(Locale.getDefault(), "%.2f", shoppingSum));
                    } else if (category.equals("travel")) {
                        for (DataSnapshot expenseSnapshot : categorySnapshot.getChildren()) {
                            double amount = expenseSnapshot.child("amount").getValue(Double.class);
                            travelSum += amount;
                        }
                        travelTotal.setText(String.format(Locale.getDefault(), "%.2f", travelSum));
                    } else if (category.equals("other")) {
                        for (DataSnapshot expenseSnapshot : categorySnapshot.getChildren()) {
                            double amount = expenseSnapshot.child("amount").getValue(Double.class);
                            otherSum += amount;
                        }
                        otherTotal.setText(String.format(Locale.getDefault(), "%.2f", otherSum));
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("TotalActivity", "Failed to read value.", databaseError.toException());
            }
        });
    }
}
