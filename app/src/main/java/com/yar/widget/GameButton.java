package com.yar.widget;

/**
 * Created by yar on 16-1-11.
 */
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.media.SoundPool;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.media.SoundPool;


public class GameButton extends AbsIMG {
    public SoundPool sp;
    public int musicID;
    public int type;
    public int textSize;
    public String name;

    public GameButton(float x, float y, Bitmap image, Context context, int MusicID) {
        this.x = x;
        this.y = y;
        this.image = image;
        this.sp = new SoundPool(1, 4, 100);
        this.musicID = this.sp.load(context, MusicID, 1);
        this.type = 1;
    }

    public GameButton(float x, float y, Bitmap image) {
        this.x = x;
        this.y = y;
        this.image = image;
        this.type = 1;
    }

    public GameButton(float x, float y, int textSize, String name, Context context, int MusicID) {
        this.x = x;
        this.y = y;
        this.textSize = textSize;
        this.name = name;
        this.sp = new SoundPool(1, 4, 100);
        this.musicID = this.sp.load(context, MusicID, 1);
        this.type = 2;
    }

    public GameButton(float x, float y, int textSize, String name) {
        this.x = x;
        this.y = y;
        this.textSize = textSize;
        this.name = name;
        this.type = 2;
    }

    public void Draw(Canvas canvas, Paint paint) {
        if(this.type == 1) {
            canvas.drawBitmap(this.image, this.x, this.y, paint);
        } else {
            paint.setTextSize((float)this.textSize);
            canvas.drawText(this.name, this.x, this.y, paint);
        }

    }

    public void ChangeImage(Bitmap m) {
        this.image = m;
    }

    public boolean OnTouch(float onTouchX, float onTouchY) {
        if(this.type == 1) {
            if(onTouchX >= this.x && onTouchX <= this.x + (float)this.image.getWidth() && onTouchY >= this.y && onTouchY <= this.y + (float)this.image.getHeight()) {
                this.PlayButtonSound();
                return true;
            }
        } else if(onTouchX >= this.x && onTouchX <= this.x + (float)(this.name.length() / 2 * this.textSize) && onTouchY >= this.y - (float)this.textSize && onTouchY <= this.y) {
            this.PlayButtonSound();
            return true;
        }

        return false;
    }

    public void PlayButtonSound() {
        /*if(this.sp != null) {
            this.sp.play(this.musicID, 1.0F, 1.0F, 0, 0, 1.0F);
        }
*/
    }
}
