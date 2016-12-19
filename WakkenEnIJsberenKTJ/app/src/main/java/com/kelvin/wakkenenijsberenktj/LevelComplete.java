package com.kelvin.wakkenenijsberenktj;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.FacebookSdk;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareButton;

import GameClasses.Level;

public class LevelComplete extends AppCompatActivity {

    String name;
    int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FacebookSdk.sdkInitialize(getApplicationContext());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_complete);

        Level lvl = (Level)getIntent().getExtras().getSerializable("level");
        TextView nameText = (TextView)findViewById(R.id.textName);
        TextView scoreText = (TextView)findViewById(R.id.textScore);
        TextView successText = (TextView)findViewById(R.id.textSucces);
        final int lvlNr = lvl.getLvlNr() + 1;

        SharedPreferences sf = PreferenceManager.getDefaultSharedPreferences(this);
        String name = sf.getString("player_name", "");
        score = getIntent().getExtras().getInt("score",3);

        nameText.setText(getResources().getString(R.string.nameComplete) + " " + name);
        scoreText.setText("Score: "+score);
        successText.setText(name + " " + getResources().getString(R.string.heeftlevel) + " " + lvl.getLvlNr() + " " + getResources().getString(R.string.succesfully));

        Button vlevel = (Button)findViewById(R.id.nextlvlBtn);
        Button menuButton = (Button)findViewById(R.id.mainmenuBtn);

        // Facebook Sharebutton
        ShareButton shareButton = (ShareButton)findViewById(R.id.sharefbBtn);
        ShareLinkContent content = new ShareLinkContent.Builder()
                .setContentTitle(name + " heeft een level gehaald in Wakken en Ijsberen")
                .setContentDescription(
                        name + " heeft een score van " + score + " behaald en heeft de nieuwe highscore op zijn/haar naam staan!")
                .setContentUrl(Uri.parse("http://developers.facebook.com/android"))
                .build();
        shareButton.setShareContent(content);

        vlevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),LevelActivity.class);
                Level level = new Level(4,true,180,3,1);
                if (lvlNr == 2) {
                    level = new Level(8, true, 100, 4, lvlNr);
                }
                else{
                    level = new Level(77,true,70,12,3);
                }

                intent.putExtra("level",level);
                startActivity(intent);
            }
        });
    }
}
