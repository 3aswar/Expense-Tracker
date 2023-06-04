package com.example.t;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

public class AnalyzeActivity extends AppCompatActivity {

    private Button click;
    private PieChart chart;
    private int category1Count = 15;
    private int category2Count = 25;
    private int category3Count = 35;
    private int category4Count = 45;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyze);

        click = findViewById(R.id.btn_click);
        chart = findViewById(R.id.pie_chart);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToPieChart();
            }
        });

    }

    private void addToPieChart() {
        // add to pie chart

        chart.addPieSlice(new PieModel("Category 1", category1Count, Color.parseColor("#FFA726")));
        chart.addPieSlice(new PieModel("Category 2", category2Count, Color.parseColor("#66BB6A")));
        chart.addPieSlice(new PieModel("Category 3", category3Count, Color.parseColor("#EF5350")));
        chart.addPieSlice(new PieModel("Category 4", category4Count, Color.parseColor("#2986F6")));

        chart.startAnimation();
        click.setClickable(false);
    }
}
