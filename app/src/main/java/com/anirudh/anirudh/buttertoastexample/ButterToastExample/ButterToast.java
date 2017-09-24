package com.anirudh.anirudh.buttertoastexample.ButterToastExample;

import android.content.Context;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.anirudh.anirudh.buttertoastexample.R;


/**
 * Created by anirudh on 05/08/17.
 */

public class ButterToast {

    public static final int LENGTH_SHORT = Toast.LENGTH_SHORT;
    public static final int LENGTH_LONG = Toast.LENGTH_LONG;
    @ColorInt
    public static final int WARNING_COLOR = Color.parseColor("#FFA900");
    @ColorInt
    public static final int DEFAULT_COLOR = Color.parseColor("#BB000000");
    @ColorInt
    public static final int ERROR_COLOR = Color.parseColor("#D50000");
    @ColorInt
    public static final int SUCCESS_COLOR = Color.parseColor("#388E3C");
    @ColorInt
    public static final int NORMAL_COLOR = Color.parseColor("#353A3E");
    public static final Typeface DEFAULT_TYPEFACE = Typeface.DEFAULT_BOLD;
    public static final float DEFAULT_CORNER_RADIUS = 80;
    public static final float DEFAULT_TEXT_SIZE = 16;
    public static final int DEFAULT_TEXT_COLOR = Color.WHITE;


    private ButterToast() {
        //user cannot construct reference
    }

    //defaultToast
    public static Toast defaultToast(Context context, CharSequence text, int duration) {
        return Toast.makeText(context, text, duration);
    }

    //Success Toast

    public static Toast successToast(@NonNull Context context, CharSequence text, int duration) {
        return successToast(context, text, duration, DEFAULT_TYPEFACE, DEFAULT_CORNER_RADIUS);
    }

    public static Toast successToast(@NonNull Context context, CharSequence text, int duration,
                                     @Nullable Typeface tp) {

        return custom(context, text, context.getResources().getDrawable(R.drawable.ic_check_white_36dp),
                SUCCESS_COLOR, duration, R.drawable.background_info, tp == null ? DEFAULT_TYPEFACE : tp
                , DEFAULT_CORNER_RADIUS);
    }

    public static Toast successToast(@NonNull Context context, CharSequence text, int duration,
                                     @Nullable Typeface tp, @NonNull float cornerRadius) {

        return custom(context, text, context.getResources().getDrawable(R.drawable.ic_check_white_36dp),
                SUCCESS_COLOR, duration, R.drawable.background_info,
                tp == null ? DEFAULT_TYPEFACE : tp, cornerRadius);
    }

    // Error toast

    public static Toast errorToast(Context context, CharSequence text, int duration) {

        return errorToast(context, text, duration, DEFAULT_TYPEFACE, DEFAULT_CORNER_RADIUS);
    }

    public static Toast errorToast(Context context, CharSequence text, int duration, @Nullable Typeface tp) {
        return custom(context, text, context.getResources().getDrawable(R.drawable.ic_cancel_white_36dp),
                ERROR_COLOR, duration, R.drawable.background_error, tp == null ? DEFAULT_TYPEFACE : tp, DEFAULT_CORNER_RADIUS);
    }

    public static Toast errorToast(Context context, CharSequence text, int duration, Typeface tp,
                                   float cornerRadius) {
        return custom(context, text, context.getResources().getDrawable(R.drawable.ic_cancel_white_36dp),
                ERROR_COLOR, duration, R.drawable.background_error, tp, cornerRadius);
    }

    //Warning toast

    public static Toast warningToast(Context context, CharSequence text, int duration) {
        return warningToast(context, text, duration, DEFAULT_TYPEFACE, DEFAULT_CORNER_RADIUS);
    }

    public static Toast warningToast(Context context, CharSequence text, int duration, @Nullable Typeface tp) {
        return custom(context, text, context.getResources().getDrawable(R.drawable.ic_warning_white_36dp),
                WARNING_COLOR, duration
                , R.drawable.background_warning, tp == null ? DEFAULT_TYPEFACE : tp, DEFAULT_CORNER_RADIUS);
    }

    public static Toast warningToast(Context context, CharSequence text, int duration, Typeface tp,
                                     float cornerRadius) {
        return custom(context, text, context.getResources().getDrawable(R.drawable.ic_warning_white_36dp),
                WARNING_COLOR, duration
                , R.drawable.background_warning, tp, cornerRadius);
    }

    //info toast
    public static Toast infoToast(Context context, CharSequence text, int duration) {
        return infoToast(context, text, duration, DEFAULT_TYPEFACE, DEFAULT_CORNER_RADIUS);
    }

    public static Toast infoToast(Context context, CharSequence text, int duration, @Nullable Typeface tp) {
        return custom(context, text, context.getResources().getDrawable(R.drawable.ic_info_outline_white_36dp), NORMAL_COLOR, duration
                , R.drawable.background_info, tp == null ? DEFAULT_TYPEFACE : tp, DEFAULT_CORNER_RADIUS);
    }

    public static Toast infoToast(Context context, CharSequence text, int duration, @Nullable Typeface tp,
                                  float cornerRadius) {
        return custom(context, text, context.getResources().getDrawable(R.drawable.ic_info_outline_white_36dp), NORMAL_COLOR, duration
                , R.drawable.background_info, tp == null ? DEFAULT_TYPEFACE : tp, cornerRadius);
    }

    //Custom Toast

    public static Toast custom(Context context, CharSequence text, @Nullable Drawable icon,
                               @ColorInt int color, int duration, @DrawableRes int resid) {
        return custom(context, text, icon, color, duration, resid, DEFAULT_TYPEFACE, DEFAULT_CORNER_RADIUS);
    }

    public static Toast custom(@NonNull Context context, CharSequence text, @Nullable Drawable icon,
                               @ColorInt int backgroundColor, int duration, @DrawableRes int resid,
                               Typeface tp, float cornerRadius) {
        return custom(context, text, icon, backgroundColor, duration, resid, tp, cornerRadius,
                DEFAULT_TEXT_COLOR, DEFAULT_TEXT_SIZE);
    }

    public static Toast custom(@NonNull Context context, CharSequence text, @Nullable Drawable icon,
                               @ColorInt int backgroundColor, int duration, @DrawableRes int resid,
                               @Nullable Typeface tp, float cornerRadius,
                               @ColorInt int textColor, float textSize) {
        Toast toast = new Toast(context);

        View layout = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                .inflate(R.layout.toast_layout, null);
        LinearLayout ll = (LinearLayout) layout.findViewById(R.id.base_layout);
        ll.setBackgroundResource(resid);
        GradientDrawable gd = (GradientDrawable) ll.getBackground().getCurrent();
        gd.setColor(backgroundColor);
        gd.setCornerRadius(cornerRadius);
        TextView tv_message = (TextView) layout.findViewById(R.id.toast_text);
        tv_message.setTextSize(textSize);
        tv_message.setTypeface(tp == null ? DEFAULT_TYPEFACE : tp);
        tv_message.setTextColor(textColor);
        ImageView iv_toast_image = (ImageView) layout.findViewById(R.id.toast_image);
        if (icon != null) {
            iv_toast_image.setImageDrawable(icon);
        }
        tv_message.setText(text);
        toast.setView(layout);
        toast.setDuration(duration);
        return toast;
    }


    /*
        Builder function for fully customizable toast
     */

    public static class Builder {
        private float cornerRadius = DEFAULT_CORNER_RADIUS;
        private Context mContext;
        private Typeface typeface = Typeface.DEFAULT_BOLD;
        private int DURATION = LENGTH_SHORT;
        private CharSequence text = "";
        private Drawable icon = null;
        private
        @ColorInt
        int backgroundColor = DEFAULT_COLOR;
        private
        @DrawableRes
        int shapeResId = R.drawable.background_info;
        private
        @ColorInt
        int textColor = DEFAULT_TEXT_COLOR;
        private float textSize = DEFAULT_TEXT_SIZE;

        public Builder(Context context) {
            this.mContext = context;
        }

        public Builder build() {
            return this;
        }

        public Builder setTypeface(Typeface tp) {
            this.typeface = tp;
            return this;
        }

        public Builder setDuration(int duration) {
            this.DURATION = duration;
            return this;
        }

        public Builder setText(CharSequence text) {
            this.text = text;
            return this;
        }

        public Builder setIcon(Drawable icon) {
            this.icon = icon;
            return this;
        }

        public Builder setShape(@DrawableRes int shapeResId) {
            this.shapeResId = shapeResId;
            return this;
        }

        public Builder setTextSize(float textSize) {
            this.textSize = textSize;
            return this;
        }

        public Builder setBackgroundColor(@ColorInt int backgroundColor) {
            this.backgroundColor = backgroundColor;
            return this;
        }

        public Builder setCornerRadius(float cornerRadius) {
            this.cornerRadius = cornerRadius;
            return this;
        }

        public Builder setTextColor(@ColorInt int textColor) {
            this.setTextColor(textColor);
            return this;
        }

        public Toast makeToast() {
            return custom(this.mContext, text, this.icon, this.backgroundColor,
                    this.DURATION, this.shapeResId, this.typeface, this.cornerRadius,
                    this.textColor, this.textSize);
        }

    }


}
