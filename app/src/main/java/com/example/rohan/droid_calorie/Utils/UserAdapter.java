package com.example.rohan.droid_calorie.Utils;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.example.rohan.droid_calorie.Model.User;
import com.example.rohan.droid_calorie.R;

/**
 * Created by Rohan on 3/26/16.
 */
public class UserAdapter extends BaseAdapter{

    public UserAdapter(Context context){
        super(context, R.layout.user_list_item);
    }

    public void populateViewWithData(View view, int position) {
        User user = (User) getItem(position);
        ((TextView) view.findViewById(R.id.userName)).setText(user.getUserName());
        ((TextView) view.findViewById(R.id.userWeight)).setText(user.getMealPlan());
    }
}
