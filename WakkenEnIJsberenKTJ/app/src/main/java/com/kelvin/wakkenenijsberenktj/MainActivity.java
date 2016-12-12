package com.kelvin.wakkenenijsberenktj;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Music music = new Music();
    int state = 0;
    Button playBtn;
    Button guideBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button songButton = (Button)findViewById(R.id.songButton);
        playBtn = (Button)findViewById(R.id.playBtn);
        guideBtn = (Button)findViewById(R.id.guideBtn);
        music.initMediaPlayer(MainActivity.this, R.raw.seinfield);
        music.play();
        music.looping();

        songButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(state == 0) {
                    music.stop();
                    songButton.setBackgroundResource(R.drawable.icon);
                    state++;

                } else {
                    music.resume();
                    songButton.setBackgroundResource(R.drawable.unmute);
                    state--;
                }
            }
        });

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), LevelSelect.class);
                startActivity(i);
            }
        });

        guideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), GameGuide.class);
                startActivity(i);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);

        return  true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.settings:
                    Intent intent = new Intent(this,SettingsActivity.class);
                    startActivity(intent);
                break;

        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        music.pause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        music.resume();
        super.onResume();
    }
}