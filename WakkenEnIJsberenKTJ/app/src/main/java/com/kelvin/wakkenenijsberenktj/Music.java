package com.kelvin.wakkenenijsberenktj;

import android.app.Activity;
import android.media.MediaPlayer;

/**
 * Created by Jordy on 2-12-2016.
 */

public class Music {

    private MediaPlayer mp;

    public void initMediaPlayer(Activity ac, int soundID){
        mp = MediaPlayer.create(ac, soundID);
    }

    public void play(){
        mp.start();
    }

    public void pause(){
        mp.pause();
    }

    public void resume(){
        mp.start();
    }

    public void stop(){
        mp.pause();
        mp.seekTo(0);
    }

    public void looping() {
        mp.setLooping(true);
    }
}