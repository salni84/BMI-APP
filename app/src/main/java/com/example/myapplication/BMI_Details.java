package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BMI_Details extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.bmi_details);

        Intent intent = getIntent();

        int position  = intent.getIntExtra("Clicked", -1);

        TextView textView = findViewById(R.id.description);
        textView.setText(BMICalculator.details[position]);

        TextView textView2 = findViewById(R.id.bmi_rating);
        textView2.setText(BMICalculator.bmiRatings[position]);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_app, menu);

        return true;
    }



}