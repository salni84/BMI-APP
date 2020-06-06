package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    DatabaseAdapter db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseAdapter(this);

        SharedPreferences sb = getSharedPreferences("Special Prefs", 0);
        TextView begruessung = findViewById(R.id.begruessung);
        begruessung.setText(sb.getString("vorname", "") + " " + sb.getString("nachname", ""));

        Button button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText editText = findViewById(R.id.height);
                String text = editText.getText().toString();

                EditText editText2 = findViewById(R.id.weight);
                String text2 = editText2.getText().toString();

                long gewicht = Long.parseLong(text2);
                long groesse = Long.parseLong(text);
                String value = new BMICalculator().BMI(gewicht, groesse);
                TextView textView = findViewById(R.id.bmi);
                textView.setText(getString(R.string.resultBMI) + value);
            }
        });

        Button clearButton = findViewById(R.id.button3);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = findViewById(R.id.bmi);
                textView.setText("");
                TextView textView1 = findViewById(R.id.weight);
                textView1.setText("");
                TextView textView2 = findViewById(R.id.height);
                textView2.setText("");
            }
        });
    }


    public void nextPage(View view){

            EditText editText = findViewById(R.id.weight);
            String gewicht = editText.getText().toString();

            EditText editText2 = findViewById(R.id.height);
            String groesse = editText2.getText().toString();

            TextView editText3 = findViewById(R.id.bmi);
            String bmi = editText3.getText().toString();

            Intent intent = new Intent(this, summary.class);
            intent.putExtra("Grösse", groesse);
            intent.putExtra("Gewicht", gewicht);
            intent.putExtra("BMI", bmi );
            startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_app, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {

            case R.id.ratings:
                Intent intent = new Intent(this, BMI_Ratings.class);
                startActivity(intent);
                return true;

            case R.id.input:
                Intent intent2 = new Intent(this, MainActivity.class);
                startActivity(intent2);
                return true;

            case R.id.home:
                Intent intent3 = new Intent(this, homescreen.class);
                startActivity(intent3);
                return true;

            case R.id.exit:
                finishAndRemoveTask();
                return true;

            case R.id.preferences:
                Intent intent4 = new Intent(this, UserPreference.class);
                startActivity(intent4);
                return true;

            default:
                return super.onOptionsItemSelected(menuItem);

        }
    }
}
