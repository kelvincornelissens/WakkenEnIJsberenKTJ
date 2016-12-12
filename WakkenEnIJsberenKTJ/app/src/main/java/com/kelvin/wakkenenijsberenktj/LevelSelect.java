package com.kelvin.wakkenenijsberenktj;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import GameClasses.Level;

public class LevelSelect extends AppCompatActivity {

    Button buttonLevel1, buttonLevel2, buttonLevel3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_select);

        buttonLevel1 = (Button) findViewById(R.id.buttonLevel1);
        buttonLevel2 = (Button) findViewById(R.id.buttonLevel2);
        buttonLevel3 = (Button) findViewById(R.id.buttonLevel3);

        buttonLevel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LevelActivity.class);

                Level level = new Level(4,true,180,3);

                intent.putExtra("level",level);
                startActivity(intent);

                if (buttonLevel1.isEnabled())
                buttonLevel1.setBackgroundResource(R.drawable.icebutton);
                else {
                    buttonLevel1.setBackgroundResource(R.drawable.icebutton2);
                }
            }
        });
    }
}
