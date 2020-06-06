package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class homescreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);
    }


    public void startApp(View view) {
        Intent intent = new Intent(this, UserPreference.class);
        SharedPreferences sb = getSharedPreferences("Special Prefs", 0);

        if (sb.getAll().isEmpty()){
            startActivity(intent);
        }

        else {
            Intent intent1 = new Intent(this, MainActivity.class);
            startActivity(intent1);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
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


            case R.id.preferences:
                Intent intent4 = new Intent(this, UserPreference.class);
                startActivity(intent4);
                return true;

            case R.id.dbresults:
                Intent intent5 = new Intent(this, DBresults.class);
                startActivity(intent5);
                return true;

            default:
                return super.onOptionsItemSelected(menuItem);

        }
    }
}
