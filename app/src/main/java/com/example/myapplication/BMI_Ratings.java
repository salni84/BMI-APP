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

public class BMI_Ratings extends AppCompatActivity {


@Override
    protected void onCreate (Bundle saveInstanceState){
    super.onCreate(saveInstanceState);
    setContentView(R.layout.bmi_ratings);

    ListView listView = findViewById(R.id.bmi_list);
    String[] array = new BMICalculator().bmiRatings;

    ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, array);
    listView.setAdapter(adapter);

    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Intent intent = new Intent(BMI_Ratings.this, BMI_Details.class);
            intent.putExtra("Clicked", position);
            startActivity(intent);
        }
    });
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

            case R.id.home:
                Intent intent3 = new Intent(this, homescreen.class);
                startActivity(intent3);
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

            default:
                return super.onOptionsItemSelected(menuItem);

        }
    }



}
