package com.kelvin.wakkenenijsberenktj;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.FacebookSdk;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareButton;

public class LevelComplete extends AppCompatActivity {

    String name;
    int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_complete);
        FacebookSdk.sdkInitialize(getApplicationContext());

        ShareButton shareButton = (ShareButton)findViewById(R.id.sharefbBtn);
        ShareLinkContent content = new ShareLinkContent.Builder()
                .setContentTitle(name + " heeft een level gehaald in Wakken en Ijsberen")
                .setContentDescription(
                        name + " heeft een score van " + score + " behaald en heeft de nieuwe highscore op zijn/haar naam staan!")
                .setContentUrl(Uri.parse("http://developers.facebook.com/android"))
                .build();
        shareButton.setShareContent(content);
    }
}
