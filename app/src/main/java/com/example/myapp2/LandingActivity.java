package com.example.myapp2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class LandingActivity extends AppCompatActivity {

    Button startPredictionButton, instructionsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        startPredictionButton = findViewById(R.id.start_prediction_button);
        instructionsButton = findViewById(R.id.instructions_button);

        startPredictionButton.setOnClickListener(v -> {
            Intent intent = new Intent(LandingActivity.this, MainActivity.class);
            startActivity(intent);
        });

        instructionsButton.setOnClickListener(v -> {
            Intent intent = new Intent(LandingActivity.this, InstructionsActivity.class);
            startActivity(intent);

        });
    }
}

