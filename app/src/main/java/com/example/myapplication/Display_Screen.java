package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class Display_Screen extends AppCompatActivity {
    ProgressBar progress_bar;
    TextView answer;
    TextView descriptive_text;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_screen);

        answer = findViewById(R.id.answer);
        descriptive_text = findViewById(R.id.descriptive_text);
        progress_bar = findViewById(R.id.progress_bar);

        //getting intent value
        Intent get = getIntent();

        //putting intent value in integer by get extra method
        int weight_val = get.getIntExtra("weight",0);
        int height_val = get.getIntExtra("height",10000);

        //converting height and weight value in double because BMI can be in decimals
        double val = Double.valueOf(weight_val);//here weight value is converted in double named as val

        double x = Double.valueOf(height_val);//here height value is converted in double named x
        x/=100;//here height in (cm) is converted in (m)
        double last = Math.pow(x,2.0);//here the 'last' double is made to square the height value

        double ans = val/last;//here 'ans' is the actual BMI

        //here something new named locale i have used
        Locale inloc = new Locale("en","IN");
        String disp = String.format(inloc,"%.2f",ans);



        if(ans < 18.5){
            answer.setText(disp);
            descriptive_text.setText(R.string.underweight);
        } else if (ans >= 18.5 && ans <= 24.9) {
            answer.setText(disp);
            descriptive_text.setText(R.string.normal);
        } else if (ans > 24.9 && ans <= 29.9) {
            answer.setText(disp);
            descriptive_text.setText(R.string.overweight);
        } else if (ans > 29.9 && ans <=34.9) {
            answer.setText(disp);
            descriptive_text.setText(R.string.obesity1);
        } else if (ans > 34.9 && ans >= 39.9) {
            answer.setText(disp);
            descriptive_text.setText(R.string.obesity2);
        }
        else
        {
            answer.setText(disp);
            descriptive_text.setText(R.string.obesity3);
        }





        progress_bar.setMax(50);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(counter <= ans){
                        counter++;
                        progress_bar.setProgress(counter);
                        Thread.sleep(250);
                        if(counter >= 50.0)  break;
                    }
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();





//        Toast.makeText(this, "ans : "+ ans, Toast.LENGTH_SHORT).show();



    }
}