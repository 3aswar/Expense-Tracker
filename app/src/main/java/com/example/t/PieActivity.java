package com.example.t;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PieActivity extends AppCompatActivity {

    private Button weeklyReportButton, dailyReportButton, monthlyReportButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie);

        weeklyReportButton = findViewById(R.id.weeklyReportButton);
        dailyReportButton = findViewById(R.id.dailyReportButton);
        monthlyReportButton = findViewById(R.id.monthlyReportButton);

        weeklyReportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PieActivity.this, "Weekly Report Button Clicked", Toast.LENGTH_SHORT).show();
                // Add your logic for the weekly report button here
            }
        });

        dailyReportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PieActivity.this, "Daily Report Button Clicked", Toast.LENGTH_SHORT).show();
                // Add your logic for the daily report button here
            }
        });

        monthlyReportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PieActivity.this, "Monthly Report Button Clicked", Toast.LENGTH_SHORT).show();
            }});}}

            //
