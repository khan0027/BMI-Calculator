package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class Male_Content extends AppCompatActivity {

    //initializing views
    SeekBar Height_seek;
    TextView height;
    TextView Weight_text;
    ImageButton sub_weight;
    ImageButton add_weight;
    MaterialButton calculate_btn;

    //declaring integer values for calculating height and weight
    public String check = "";
    public int weightbuttoninteger = 50;
    public int heightbuttoninteger = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_male_content);


        //find view by id
        Height_seek = findViewById(R.id.height_seek);
        height = findViewById(R.id.height);
        Weight_text = findViewById(R.id.Weight_text);
        sub_weight = findViewById(R.id.sub_weight);
        add_weight = findViewById(R.id.add_weight);
        calculate_btn = findViewById(R.id.calculate_btn);


        //on change of seekbar listner

        Height_seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                heightbuttoninteger = progress;
                height.setText(progress+"cm");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        //on click listener of decreasing weight

        sub_weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weightbuttoninteger = Integer.parseInt(Weight_text.getText().toString());
                if(weightbuttoninteger <= 0){
                    Toast.makeText(Male_Content.this, "!! Weight cannot be subtracted less than this !!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    weightbuttoninteger -= 1;
                    Weight_text.setText(String.valueOf(weightbuttoninteger));
                }

            }
        });

        //on click listener of adding weight

        add_weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weightbuttoninteger = Integer.parseInt(Weight_text.getText().toString());
                if(weightbuttoninteger >= 500){
                    Toast.makeText(Male_Content.this, "!! Weight cannot be more than  !!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    weightbuttoninteger += 1;
                    Weight_text.setText(String.valueOf(weightbuttoninteger));
                }
            }
        });





        Intent idisplay = new Intent(Male_Content.this,Display_Screen.class);

        idisplay.putExtra("weight",weightbuttoninteger);
        idisplay.putExtra("height",heightbuttoninteger);

        calculate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                idisplay.putExtra("weight",weightbuttoninteger);
                idisplay.putExtra("height",heightbuttoninteger);
                startActivity(idisplay);
            }
        });
    }
}