package com.example.myapp2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class InstructionsActivity extends AppCompatActivity {

    Button btnPredict, btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);

        btnPredict = findViewById(R.id.btn_predict);
        btnHome = findViewById(R.id.btn_home);

        btnPredict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent predictIntent = new Intent(InstructionsActivity.this, MainActivity.class);
                startActivity(predictIntent);
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(InstructionsActivity.this, LandingActivity.class);
                startActivity(homeIntent);
            }
        });
    }
}
