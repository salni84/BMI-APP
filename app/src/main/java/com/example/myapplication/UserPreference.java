package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UserPreference extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.user_preference);


        SharedPreferences prefs = getSharedPreferences("Special Prefs", 0);
        SharedPreferences.Editor editor = prefs.edit();

        EditText vorname = findViewById(R.id.firstname);
        EditText nachname = findViewById(R.id.nachname);
        EditText gebatum = findViewById(R.id.gebDate);

        vorname.setText(prefs.getString("vorname", ""));
        nachname.setText(prefs.getString("nachname", ""));
        gebatum.setText(prefs.getString("gebdate", ""));


        Button clearButton = findViewById(R.id.deleteUser);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getSharedPreferences("Special Prefs", 0);
                prefs.edit().clear().apply();
                EditText vorname = findViewById(R.id.firstname);
                EditText nachname = findViewById(R.id.nachname);
                EditText gebatum = findViewById(R.id.gebDate);
                vorname.setText("");
                nachname.setText("");
                gebatum.setText("");
            }
        });
    }

    public void next(View view) {

        EditText vorname = findViewById(R.id.firstname);

        EditText nachname = findViewById(R.id.nachname);

        EditText gebatum = findViewById(R.id.gebDate);

        SharedPreferences prefs = getSharedPreferences("Special Prefs", 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("vorname", vorname.getText().toString());
        editor.putString("nachname", nachname.getText().toString());
        editor.putString("gebdate", gebatum.getText().toString());
        editor.apply();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
