package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class DBresults extends AppCompatActivity {

    DatabaseAdapter db = new DatabaseAdapter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.db_results);

        db.open();
        ArrayList<String> array =  new ArrayList<>(db.selectData());

        ListView arrayList = findViewById(R.id.databank);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, array);
        arrayList.setAdapter(adapter);
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


            case R.id.preferences:
                Intent intent4 = new Intent(this, UserPreference.class);
                startActivity(intent4);
                return true;

            case R.id.databank:
                Intent intent5 = new Intent(this, DBresults.class);
                startActivity(intent5);
                return true;

            default:
                return super.onOptionsItemSelected(menuItem);

        }
    }
}
