package com.yar.widget;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;

/**
 * Created by yar on 16-1-11.
 */
public class GameMediaPlayers extends MediaPlayer {
    public MediaPlayer mp;

    public GameMediaPlayers() {
    }

    public void LoadMusic(Context context, int musicID) {
        this.mp = MediaPlayer.create(context, musicID);
    }

    public void startMusic(boolean isLoop) {
        if(this.mp != null) {
            this.mp.start();
        }

        if(isLoop) {
            this.mp.setLooping(true);
        }

    }

    public void puaseMusic(boolean isBack) {
        if(this.mp != null) {
            this.mp.pause();
        }

        if(isBack) {
            this.mp.seekTo(0);
        }

    }

    public static void setVolumeSize(Activity activity, int value) {
        AudioManager ad = (AudioManager)activity.getSystemService(Context.AUDIO_SERVICE);
        activity.setVolumeControlStream(3);
        ad.setStreamVolume(3, value, 0);
    }
}
