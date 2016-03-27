package com.example.rohan.droid_calorie.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.rohan.droid_calorie.Model.User;
import com.example.rohan.droid_calorie.R;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private RelativeLayout mainLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.userView);
        ArrayList<User> user = User.loadSampleUsers();

        UserAdapter adapter = new UserAdapter(this);
        adapter.addAll(user);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.food_activity_menu_button:
                startActivityForResult(new Intent(MainActivity.this, FoodActivity.class), 0);
                return true;

            case R.id.user_activity_menu_button:
                startActivityForResult(new Intent(MainActivity.this, MainActivity.class), 0);
                return true;

            case R.id.macro_activity_menu_button:
                startActivityForResult(new Intent(MainActivity.this, MacroActivity.class), 0);
                return true;

            case R.id.dash_activity_menu_button:
                startActivityForResult(new Intent(MainActivity.this, DashActivity.class), 0);
                return true;

            case R.id.day_activity_menu_button:
                startActivityForResult(new Intent(MainActivity.this, DayDetail.class), 0);
                return true;

        }


        return true;
    }
}
