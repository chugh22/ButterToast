package com.anirudh.anirudh.buttertoastexample;

import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.Shape;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.anirudh.buttertoast.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button info = (Button) findViewById(R.id.button2);
        Button warning = (Button) findViewById(R.id.button);
        Button error = (Button) findViewById(R.id.button3) ;
        Button success = (Button) findViewById(R.id.button4) ;
        Button custom1 = (Button) findViewById(R.id.btnCustom1) ;
        Button custom2 = (Button) findViewById(R.id.btnCustom2) ;

            info.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ButterToast.infoToast(
                            MainActivity.this ,
                            "Info   " ,
                            Toast.LENGTH_LONG
                    ).show();

                }
            });
            warning.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ButterToast.warningToast(
                            MainActivity.this ,
                            "Warning" ,
                            Toast.LENGTH_LONG
                    ).show();
                }
            });
            error.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ButterToast.errorToast(
                            MainActivity.this ,
                            "Error !! " ,
                            ButterToast.LENGTH_LONG
                    ).show();
                }
            });
        success.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButterToast.successToast(MainActivity.this , "Success" , Toast.LENGTH_LONG).show(); ;
            }
        });
        custom1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ButterToast.Builder(MainActivity.this)
                        .build()
                        .setCornerRadius(10.5f)
                        .setTextColor(Color.WHITE)
                        .setIcon(MainActivity.this.getResources().getDrawable(R.drawable.ic_check_white_36dp))
                        .setText("Custom toast").makeToast().show() ;
            }
        });
        custom2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ButterToast.Builder(MainActivity.this)
                        .setBackgroundColor(Color.GREEN)
                        .setText("BuilderToast").makeToast().show();
            }
        });






    }
}
