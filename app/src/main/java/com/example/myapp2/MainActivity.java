package com.example.myapp2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import org.tensorflow.lite.Interpreter;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    Interpreter tflite;

    // EditTexts
    EditText bmiInput, genHlthInput, mentHlthInput, physHlthInput, ageInput, educationInput;

    // RadioGroups
    RadioGroup highbpGroup, highcholGroup, cholcheckGroup, smokerGroup, strokeGroup,
            heartGroup, physActivityGroup, alcoholGroup, anyhealthcareGroup,
            nodoccostGroup, sexGroup;

    // Output
    TextView statusText, confidenceText;
    Button predictBtn, dietBtn; // New button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Load model
        try {
            tflite = new Interpreter(loadModelFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Initialize EditTexts
        bmiInput = findViewById(R.id.bmi_input);
        genHlthInput = findViewById(R.id.genhlth_input);
        mentHlthInput = findViewById(R.id.menthlth_input);
        physHlthInput = findViewById(R.id.physhlth_input);
        ageInput = findViewById(R.id.age_input);
        educationInput = findViewById(R.id.education_input);

        // Initialize RadioGroups
        highbpGroup = findViewById(R.id.highbp_group);
        highcholGroup = findViewById(R.id.highchol_group);
        cholcheckGroup = findViewById(R.id.cholcheck_group);
        smokerGroup = findViewById(R.id.smoker_group);
        strokeGroup = findViewById(R.id.stroke_group);
        heartGroup = findViewById(R.id.heart_group);
        physActivityGroup = findViewById(R.id.physactivity_group);
        alcoholGroup = findViewById(R.id.alcohol_group);
        anyhealthcareGroup = findViewById(R.id.anyhealthcare_group);
        nodoccostGroup = findViewById(R.id.nodoccost_group);
        sexGroup = findViewById(R.id.sex_group);

        // Initialize outputs
        statusText = findViewById(R.id.status);
        confidenceText = findViewById(R.id.confidence);
        predictBtn = findViewById(R.id.predict_button);
        dietBtn = findViewById(R.id.diet_button); // New Button

        // Hide diet button initially
        dietBtn.setVisibility(View.GONE);

        predictBtn.setOnClickListener(view -> doInference());

        dietBtn.setOnClickListener(v -> {
            // Navigate to dietary recommendations page
            Intent intent = new Intent(MainActivity.this, DietaryRecommendationsActivity.class);
            startActivity(intent);
        });
    }

    private MappedByteBuffer loadModelFile() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(getAssets().openFd("diabetes_model.tflite").getFileDescriptor());
        FileChannel fileChannel = fileInputStream.getChannel();
        long startOffset = getAssets().openFd("diabetes_model.tflite").getStartOffset();
        long declaredLength = getAssets().openFd("diabetes_model.tflite").getDeclaredLength();
        return fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength);
    }

    private int getSelectedRadioValue(RadioGroup group) {
        int selectedId = group.getCheckedRadioButtonId();
        if (selectedId == -1) return 0;
        RadioButton selected = findViewById(selectedId);
        return Objects.equals(selected.getText().toString().toLowerCase(), "yes") ||
                Objects.equals(selected.getText().toString().toLowerCase(), "male") ? 1 : 0;
    }

    private void doInference() {
        float[] input = new float[17];

        input[0] = getSelectedRadioValue(highbpGroup);
        input[1] = getSelectedRadioValue(highcholGroup);
        input[2] = getSelectedRadioValue(cholcheckGroup);
        input[3] = getFloatValue(bmiInput);
        input[4] = getSelectedRadioValue(smokerGroup);
        input[5] = getSelectedRadioValue(strokeGroup);
        input[6] = getSelectedRadioValue(heartGroup);
        input[7] = getSelectedRadioValue(physActivityGroup);
        input[8] = getSelectedRadioValue(alcoholGroup);
        input[9] = getSelectedRadioValue(anyhealthcareGroup);
        input[10] = getSelectedRadioValue(nodoccostGroup);
        input[11] = getFloatValue(genHlthInput);
        input[12] = getFloatValue(mentHlthInput);
        input[13] = getFloatValue(physHlthInput);
        input[14] = getSelectedRadioValue(sexGroup);
        input[15] = getFloatValue(ageInput);
        input[16] = getFloatValue(educationInput);

        float[][] output = new float[1][1];
        tflite.run(input, output);

        float prediction = output[0][0];
        boolean isDiabetic = prediction > 0.3;

        statusText.setText("Status: " + (isDiabetic ? "Diabetic" : "Non-Diabetic"));
        confidenceText.setText(String.format("Confidence: %.2f%%", prediction * 100));

        if (isDiabetic) {
            dietBtn.setVisibility(View.VISIBLE);
        } else {
            dietBtn.setVisibility(View.GONE);
        }
    }

    private float getFloatValue(EditText editText) {
        String text = editText.getText().toString().trim();
        if (text.isEmpty()) return 0f;
        try {
            return Float.parseFloat(text);
        } catch (NumberFormatException e) {
            return 0f;
        }
    }
}
