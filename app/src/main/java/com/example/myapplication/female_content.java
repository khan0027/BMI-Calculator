package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.button.MaterialButton;

public class female_content extends AppCompatActivity {
    SeekBar Height_seek;
    TextView height;
    TextView Weight_text;

    ImageButton sub_weight;
    ImageButton add_weight;
    MaterialButton calculate_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_female_content);


        Height_seek = findViewById(R.id.height_seek);
        height = findViewById(R.id.height);
        Weight_text = findViewById(R.id.Weight_text);
        sub_weight = findViewById(R.id.sub_weight);
        add_weight = findViewById(R.id.add_weight);
        calculate_btn = findViewById(R.id.calculate_btn);



        Height_seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                height.setText(progress + "cm");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        sub_weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(Weight_text.getText().toString());
                if(x <= 0){
                    Toast.makeText(female_content.this, "!! Weight cannot be subtracted less than this !!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    x -= 1;
                }
                Weight_text.setText(String.valueOf(x));
            }
        });
        add_weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(Weight_text.getText().toString());
                if(x >= 500){
                    Toast.makeText(female_content.this, "!! Weight cannot be more than  !!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    x += 1;
                    Weight_text.setText(String.valueOf(x));
                }
            }
        });

        calculate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}