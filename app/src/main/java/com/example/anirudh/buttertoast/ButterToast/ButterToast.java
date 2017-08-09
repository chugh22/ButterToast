package com.example.anirudh.buttertoast.ButterToast;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anirudh.buttertoast.R;



/**
 * Created by anirudh on 05/08/17.
 */

public class ButterToast {


    private ButterToast() {
       //user cannot construct reference
    }

    public static Toast makeText(Context context , String text , int duration){
        Toast toast  = new Toast(context);

        View layout = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                .inflate(R.layout.toast_layout , null);
        TextView tv_message = (TextView) layout.findViewById(R.id.toast_text);
        tv_message.setText(text);
        toast.setView(layout);
        toast.setDuration(duration);




        return toast ;
    }

}
