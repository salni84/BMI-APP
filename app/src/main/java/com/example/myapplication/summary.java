package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Date;


public class summary extends AppCompatActivity {

    DatabaseAdapter db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        db = new DatabaseAdapter(this);

        String pattern = "dd.MM.yyyy HH:mm";
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        Intent intent = getIntent();

        final String gewicht = intent.getStringExtra("Gewicht");
        TextView textView = findViewById(R.id.gewicht_result);
        textView.setText(gewicht);

        Intent intent2 = getIntent();
        final String groesse = intent2.getStringExtra("Grösse");
        TextView textView2 = findViewById(R.id.groesse_result);
        textView2.setText(groesse);

        Intent intent3 = getIntent();
        String bmi = intent3.getStringExtra("BMI");
        TextView textView3 = findViewById(R.id.bmi_result);
        textView3.setText(bmi);


        final SharedPreferences prefs = getSharedPreferences("Special Prefs", 0);
        final String name = prefs.getString("vorname", "");
        final DatabaseAdapter db = new DatabaseAdapter(this);


        Button saveButton = findViewById(R.id.save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db.open();
                String date = simpleDateFormat.format(new Date());
                db.insertData(date, name, groesse, gewicht);

                Toast.makeText(summary.this, "Erfolgreich eingetragen!",
                        Toast.LENGTH_LONG).show();

               System.out.println(db.selectData());
            }
        });
    }

    public void ratingPage(View view){
        Intent intent = new Intent(this, BMI_Ratings.class);
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

            case R.id.exit:
                finishAndRemoveTask();
                return true;

            default:
                return super.onOptionsItemSelected(menuItem);

        }
    }
}
