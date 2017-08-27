package com.example.anirudh.buttertoast.ButterToast;

import android.content.Context;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anirudh.buttertoast.R;



/**
 * Created by anirudh on 05/08/17.
 */

public class ButterToast {

    public static final int LENGTH_SHORT = Toast.LENGTH_SHORT ;
    public static final int LENGTH_LONG = Toast.LENGTH_LONG ;
    public static final int WARNING_COLOR = Color.parseColor("#FFA900") ;
    public static final int DEFAULT_COLOR = Color.parseColor("#BB000000") ;
    public static final int ERROR_COLOR = Color.parseColor("#D50000") ;
    public static final int SUCCESS_COLOR = Color.parseColor("#388E3C") ;
    public static final int NORMAL_COLOR = Color.parseColor("#353A3E") ;
    private ButterToast() {
       //user cannot construct reference
    }



    public static Toast errorToast(Context context , String text , int duration){

        return makeText(context , text , context.getResources().getDrawable(R.drawable.ic_cancel_white_36dp) ,
                 duration , R.drawable.background_error) ;
    }
    public static Toast warningToast(Context context , String text , int duration){
        return makeText(context , text , context.getResources().getDrawable(R.drawable.ic_warning_white_36dp) , duration
         , R.drawable.background_warning) ;
    }

    public static Toast infoToast(Context context , String text , int duration){
        return makeText(context , text , context.getResources().getDrawable(R.drawable.ic_info_outline_white_36dp) ,duration
        , R.drawable.background_info) ;
    }

    public static Toast makeText(Context context , String text , Drawable icon ,
                                 int duration , @DrawableRes int resid ){
        Toast toast  = new Toast(context);

        View layout = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                .inflate(R.layout.toast_layout , null);
        LinearLayout ll = (LinearLayout) layout.findViewById(R.id.base_layout);
        ll.setBackgroundResource(resid);
        TextView tv_message = (TextView) layout.findViewById(R.id.toast_text);
        ImageView iv_toast_image = (ImageView)layout.findViewById(R.id.toast_image) ;
        iv_toast_image.setImageDrawable(icon);
        tv_message.setText(text);
        toast.setView(layout);
        toast.setDuration(duration);
        return toast ;
    }



}
