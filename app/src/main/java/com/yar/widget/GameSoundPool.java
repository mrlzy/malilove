package com.yar.widget;

import android.content.Context;
import android.media.SoundPool;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yar on 16-1-11.
 */
public class GameSoundPool {
    private  SoundPool sp;
    private int musicID[];
    private int index=0;


    public  float effectSize = 1.0F;

    public GameSoundPool(int maxStream) {
        this.sp = new SoundPool(maxStream, 4, 100);
        this.musicID=new int[maxStream];
    }

    public GameSoundPool() {
        this.sp = new SoundPool(1, 4, 100);
        this.musicID=new int[1];

    }

    public void loadGameMusic(Context context, int MusicID) {
        int ID = this.sp.load(context, MusicID, 1);
        Log.i("yoyo",this.index+","+ID);
        this.musicID[this.index]=ID;
        this.index++;
    }

    public void Play(int i) {
        int ID=musicID[i];
        this.sp.play(ID, effectSize, effectSize, 0, 0, 1.0F);
    }

    public void setVolumes(float EffectSize) {
        effectSize = EffectSize;

        for(int i = 0; i <this.musicID.length; ++i) {
            if(this.sp != null) {
                int ID=this.musicID[i];
                this.sp.setVolume(ID, effectSize, effectSize);
            }
        }

    }

    public  void removeAllMusic() {
        int len=this.musicID.length;
        this.musicID=new  int[len];
        this.index=0;
        this.sp.release();
    }
}
