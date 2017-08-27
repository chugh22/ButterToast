package com.example.anirudh.buttertoast;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.anirudh.buttertoast.ButterToast.ButterToast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button info = (Button) findViewById(R.id.button2);
        Button warning = (Button) findViewById(R.id.button);
        Button error = (Button) findViewById(R.id.button3) ;
        Button success = (Button) findViewById(R.id.button4) ;

            info.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ButterToast.infoToast(
                            MainActivity.this ,
                            "My custom toast" ,
                            Toast.LENGTH_LONG
                    ).show();
                }
            });
            warning.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ButterToast.warningToast(
                            MainActivity.this ,
                            "My custom toast" ,
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


                 new ButterToast.Builder(this)
                .setColor(Color.GREEN)
                .setText("BuilderToast").makeText().show();




    }
}
