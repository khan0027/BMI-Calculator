package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    AppCompatImageButton img_male;
    AppCompatImageButton img_female;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img_male = findViewById(R.id.img_male);
        img_female = findViewById(R.id.img_female);

        Intent icalc = new Intent(MainActivity.this,Male_Content.class);
//        Intent ifemale = new Intent(MainActivity.this,female_content.class);
        img_male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(icalc);
            }
        });
        img_female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(icalc);
            }
        });



    }
}