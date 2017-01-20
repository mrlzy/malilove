package com.yar.bean;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

import com.yar.widget.AbsIMG;

/**
 * Created by yar on 16-1-11.
 */
public class Sprite extends AbsIMG {
    public float xSpeed;
    public float ySpeed;
    public float startX;
    public float startY;
    public int hp;
    public Mario mario;

    public Sprite(float x, float y, Bitmap image,Mario mario) {
        this.x = x;
        this.y = y;
        this.startX = x;
        this.startY = y;
        this.image = image;
        this.hp = 1;
        this.mario=mario;
    }

    public void Sprite(float x, float y, Bitmap image,Mario mario) {
        this.x = x;
        this.y = y;
        this.startX = x;
        this.startY = y;
        this.image = image;
        this.hp = 1;
        this.mario=mario;
    }

    public void draw(Canvas canvas) {
        if(this.image != null) {
            canvas.drawBitmap(this.image, this.x, this.y, (Paint)null);
        }

    }





    public boolean isCollsionWithRect(Sprite s, Rect r) {
        float x1 = (float)r.left + s.x;
        float y1 = (float)r.top + s.y;
        float w1 = (float)(r.right - r.left);
        float h1 = (float)(r.bottom - r.top);

        float x2 = (float)this.x;
        float y2 = (float)this.y;
        float w2 = (float)(this.image.getWidth());
        float h2 = (float)(this.image.getHeight());

        if ( x1 >= x2 + w2) {  // 当矩形 1 位于矩形 2 的右侧
            return false;
        }else if (x1 + w1 <= x2){  // 当矩形 1 位于矩形 2 的左侧
           return false;
        }else if(y1+h1<= y2){// 当矩形 1 位于矩形 2 的上侧
            return false;
        }else if(y2+h2<= y1){// 当矩形 1 位于矩形 2 的下侧
            return false;
        }else{
            return true;
        }
    }




    public int MoreRectangle_CollisionWithSpriteXY(Sprite s) {
       return MoreRectangle_CollisionWithSpriteXY(s,new Rect(0,0,0+s.image.getWidth(),0+s.image.getHeight()));
    }


    public int MoreRectangle_CollisionWithSpriteXY2(Sprite s, Rect r) {
        if(this.mario.isDieding) return 0;
        float x = (float)r.left + s.x;
        float y = (float)r.top + s.y;
        float w = (float)(r.right - r.left);
        float h = (float)(r.bottom - r.top);
        int p=0;

        if(isCollsionWithRect(s,r)){
            float lastx=x-s.xSpeed;
            float lasty=y-s.ySpeed;
            if(lastx+w<=this.x&&x+w>this.x){
                p=1;
            }else if(lasty+h <=this.y && y+h>this.y){
                p= 2;
            }else if(lastx>=this.x+(float)this.image.getWidth()&&
                    x<this.x+(float)this.image.getWidth()){
                p=3;
            }else if(lasty>=this.y+(float)this.image.getHeight()&&y<this.y+(float)this.image.getHeight()){
                p=4;
            }else{
                p=5;
            }


        }
        return p;
    }


    public int MoreRectangle_CollisionWithSpriteXY(Sprite s, Rect r) {
        if(this.mario.isDieding) return 0;
        float x = (float)r.left + s.x;
        float y = (float)r.top + s.y;
        float w = (float)(r.right - r.left);
        float h = (float)(r.bottom - r.top);
        int p=0;

        if(isCollsionWithRect(s,r)){
            float lastx=x-s.xSpeed;
            float lasty=y-s.ySpeed;
            if(lastx+w<=this.x&&x+w>this.x){
                  p=1;
              }else if(lasty+h <=this.y && y+h>this.y){
                  p= 2;
              }else if(lastx>=this.x+(float)this.image.getWidth()&&
                      x<this.x+(float)this.image.getWidth()){
                 p=3;
              }else if(lasty>=this.y+(float)this.image.getHeight()&&y<this.y+(float)this.image.getHeight()){
                 p=4;
              }else{
                p=5;
            }


        }
        return p;
    }
}