package com.example.rohan.droid_calorie.Utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import com.example.rohan.droid_calorie.R;

/**
 * Created by Rohan on 3/26/16.*/
public abstract class BaseAdapter<T> extends ArrayAdapter<T> {

    protected BaseAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout view = (LinearLayout) getActualView(convertView);
        populateViewWithData(view, position);
        return view;
    }

    public View getActualView(View convertView) {
        LinearLayout view = (LinearLayout) convertView;
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = (LinearLayout) inflater.inflate(R.layout.user_list_item, null);
        }
        return view;
    }

    public abstract void populateViewWithData(View view, int position);


}