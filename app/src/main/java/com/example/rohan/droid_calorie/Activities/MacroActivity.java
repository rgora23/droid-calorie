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


        private RelativeLayout mainLayout;
        private PieChart pieChart;
        private float[] yData = { 5, 10, 15, 30, 40 };
        private String[] xData = { "Sony", "Huawei", "LG", "Apple", "Samsung" };

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_macro);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            mainLayout = (RelativeLayout) findViewById(R.id.mainLayout);
            pieChart = new PieChart(this);
            mainLayout.addView(pieChart,900,900);
            pieChart.setUsePercentValues(true);
            pieChart.setDescription("");
            pieChart.setDrawHoleEnabled(true);
            pieChart.setHoleColorTransparent(true);
            pieChart.setHoleRadius(7);
            pieChart.setTransparentCircleRadius(10);

            RelativeLayout.LayoutParams layoutParams =
                    (RelativeLayout.LayoutParams)pieChart.getLayoutParams();
            layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
            pieChart.setLayoutParams(layoutParams);


            pieChart.setRotationAngle(0);
            pieChart.setRotationEnabled(true);

            // set a chart value selected listener
            pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {

                @Override
                public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {
                    // display msg when value selected
                    if (e == null)
                        return;

                    Toast.makeText(MacroActivity.this,
                            xData[e.getXIndex()] + " = " + e.getVal() + "%", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onNothingSelected() {

                }

            });

            //addData
            addData();

            //Legend
            Legend l = pieChart.getLegend();
            l.setEnabled(false);

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

            pieChart.setData(data);
            //undo all highlights
            pieChart.highlightValue(null);

            //update pie chart
            pieChart.invalidate();


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
