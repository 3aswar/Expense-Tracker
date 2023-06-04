package com.example.t;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    private TextView paragraphTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        // Find the Paragraph TextView by its ID
        paragraphTextView = findViewById(R.id.paragraphTextView);

        // Customize the Paragraph TextView
        paragraphTextView.setLineSpacing(0, 1.5f);
    }
}
