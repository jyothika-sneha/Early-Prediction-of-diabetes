package com.example.myapp2;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DietaryRecommendationsActivity extends AppCompatActivity {

    TextView dietText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dietary_recommendations);

        dietText = findViewById(R.id.recommendations_text);
        dietText.setText(getString(R.string.diet_recommendations));
    }
}