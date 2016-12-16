package com.kelvin.wakkenenijsberenktj;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

import GameClasses.Level;

public class LevelSelect extends AppCompatActivity {

    Button buttonLevel1, buttonLevel2, buttonLevel3;
    ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_select);

        buttonLevel1 = (Button) findViewById(R.id.buttonLevel1);
        buttonLevel2 = (Button) findViewById(R.id.buttonLevel2);
        buttonLevel3 = (Button) findViewById(R.id.buttonLevel3);
        toggleButton = (ToggleButton) findViewById(R.id.toggleButtonPinguins);
        toggleButton.setChecked(true);
        toggleButton.setText("Pinguins zijn aan");

        buttonLevel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LevelActivity.class);

                Level level = new Level(4,toggleButton.isChecked(),180,3,1);

                intent.putExtra("level",level);
                startActivity(intent);


            }
        });


        buttonLevel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LevelActivity.class);
                Level level = new Level(8,toggleButton.isChecked(),100,4,2);

                intent.putExtra("level",level);
                startActivity(intent);
            }
        });


        buttonLevel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LevelActivity.class);
                Level level = new Level(77,toggleButton.isChecked(),70,12,3);

                intent.putExtra("level",level);
                startActivity(intent);
            }
        });

        toggleButton.setTextOff("Pinguins zijn uit");
        toggleButton.setTextOn("Pinguins zijn aan");
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(toggleButton.isChecked()){

                    toggleButton.setChecked(true);
                }else{
                    toggleButton.setChecked(false);

                }

            }
        });
    }
}
