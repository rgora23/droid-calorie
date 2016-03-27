package com.example.rohan.droid_calorie.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.Toast;


import com.example.rohan.droid_calorie.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;



public class MacroActivity extends AppCompatActivity {

        private RelativeLayout macroLayout;
        private PieChart macro;
        private float[] yData = {60,45,25};
        private String[] xData = {"Protein", "Carbs", "Fat"};

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_macro);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            macroLayout = (RelativeLayout) findViewById(R.id.macroLayout);
            macro = new PieChart(this);
            //adds macro to macoLayout
            macroLayout.addView(macro);
            macroLayout.setBackgroundColor(Color.MAGENTA);
            //configures PieChar
            macro.setUsePercentValues(true);
            macro.setDescription("The shit you've been eating");
            //set draw hole
            macro.setDrawHoleEnabled(true);
            macro.setHoleColorTransparent(true);
            macro.setHoleRadius(7);
            macro.setTransparentCircleRadius(10);

            //Sets Rotation of the Chart by Touch
            macro.setRotation(0);
            macro.setRotationEnabled(true);

            //Set Chart Value Selected Listener
            macro.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
                @Override
                public void onValueSelected(Entry entry, int i, Highlight highlight) {
                    //selects display message
                    if (entry == null)
                        return;
                    Toast.makeText(MacroActivity.this,
                            xData[entry.getXIndex()] + "=" + entry.getVal() + "%", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onNothingSelected() {

                }


            });

            //addData
            addData();

            //Legend
            Legend l = macro.getLegend();
            l.setPosition(Legend.LegendPosition.ABOVE_CHART_CENTER);
            l.setXEntrySpace(7);
            l.setYEntrySpace(5);
        }

        private void addData() {

            ArrayList<Entry> yVals = new ArrayList<Entry>();
            for (int i = 0; i < yData.length; i++) {
                yVals.add(new Entry(yData[i], i));
            }

            ArrayList<String> xVals = new ArrayList<String>();

            for (int i = 0; i < xData.length; i++) {
                xVals.add(xData[i]);
            }

            //Create Pie Data Set
            PieDataSet dataSet = new PieDataSet(yVals, "Macros");
            dataSet.setSliceSpace(3);
            dataSet.setSelectionShift((5));

            //add Many Colors
            ArrayList<Integer> colors = new ArrayList<Integer>();

            for (int c : ColorTemplate.VORDIPLOM_COLORS)
                colors.add(c);

            for (int c : ColorTemplate.JOYFUL_COLORS)
                colors.add(c);

            for (int c : ColorTemplate.COLORFUL_COLORS)
                colors.add(c);
            for (int c : ColorTemplate.LIBERTY_COLORS)
                colors.add(c);
            for (int c : ColorTemplate.PASTEL_COLORS)
                colors.add(c);
            colors.add(ColorTemplate.getHoloBlue());
            dataSet.setColors(colors);

            //initiate Pie Data now
            PieData data = new PieData(xVals, dataSet);
            data.setValueTextSize(11f);
            data.setValueTextColor(Color.GRAY);

            macro.setData(data);
            //undo all highlights
            macro.highlightValue(null);

            //update pie chart
            macro.invalidate();

            //demo!
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
                startActivityForResult(new Intent(MacroActivity.this, FoodActivity.class), 0);
                return true;

            case R.id.user_activity_menu_button:
                startActivityForResult(new Intent(MacroActivity.this, MainActivity.class), 0);
                return true;

            case R.id.macro_activity_menu_button:
                startActivityForResult(new Intent(MacroActivity.this, MacroActivity.class), 0);
                return true;

            case R.id.dash_activity_menu_button:
                startActivityForResult(new Intent(MacroActivity.this, DashActivity.class), 0);
                return true;

            case R.id.day_activity_menu_button:
                startActivityForResult(new Intent(MacroActivity.this, DayDetail.class), 0);
                return true;

        }


        return true;
    }

}
