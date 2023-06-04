package com.example.t;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FoodActivity extends AppCompatActivity {

    private EditText etName, etDate, etAmount;
    private Button btnSave, btnReturn;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        etName = findViewById(R.id.et_name);
        etDate = findViewById(R.id.et_date);
        etAmount = findViewById(R.id.et_amount);
        btnSave = findViewById(R.id.btn_save);
        btnReturn = findViewById(R.id.btn_return);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveToFirebase();
            }
        });

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FoodActivity.this, home.class));
            }
        });
    }

    private void saveToFirebase() {
        String name = etName.getText().toString().trim();
        String date = etDate.getText().toString().trim();
        String amount = etAmount.getText().toString().trim();

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(date) || TextUtils.isEmpty(amount)) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        String id = mDatabase.child("expenses").child("food").push().getKey();
        Expense expense = new Expense(name, date, Double.parseDouble(amount));
        mDatabase.child("expenses").child("food").child(id).setValue(expense);
        Toast.makeText(this, "Expense saved", Toast.LENGTH_SHORT).show();
        etName.setText("");
        etDate.setText("");
        etAmount.setText("");
    }

    private static class Expense {
        private String name;
        private String date;
        private double amount;

        public Expense() {
            // Default constructor required for calls to DataSnapshot.getValue(Expense.class)
        }

        public Expense(String name, String date, double amount) {
            this.name = name;
            this.date = date;
            this.amount = amount;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }
    }
}

