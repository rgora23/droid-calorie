package com.example.rohan.droid_calorie.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.rohan.droid_calorie.R;

public class AccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

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
                startActivityForResult(new Intent(AccountActivity.this, FoodActivity.class), 0);
                return true;

            case R.id.user_activity_menu_button:
                startActivityForResult(new Intent(AccountActivity.this, AccountActivity.class), 0);
                return true;

            case R.id.macro_activity_menu_button:
                startActivityForResult(new Intent(AccountActivity.this, MacroActivity.class), 0);
                return true;

            case R.id.dash_activity_menu_button:
                startActivityForResult(new Intent(AccountActivity.this, DashActivity.class), 0);
                return true;

            case R.id.day_activity_menu_button:
                startActivityForResult(new Intent(AccountActivity.this, DayDetail.class), 0);
                return true;

        }


        return true;
    }

}
