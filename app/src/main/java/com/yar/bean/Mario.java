package com.yar.bean;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import com.yar.main.MainActivity;
import com.yar.util.AplactionUtil;
import com.yar.util.LoadUtil;
import com.yar.widget.AbsIMG;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yar on 16-1-11.
 */
public class Mario extends Sprite {


    public int score;
    public int coin;
    public Level level;
    public int life;
    public Context context;


    public boolean onland = false;
    public boolean lastOnland = false;

    public boolean onLadderland=false;
    public boolean onhitRight=false;
    public boolean onhitLeft=false;
    public boolean onhitTop=false;
    public boolean isleaf = false;
    public int changeTime=0;

    public boolean isWin=false;
    public boolean isDied=false;
    public boolean isDieding=false;
    public String status="left" ;
    public int  lev=1;
    private Rect rect;



    public ArrayList<Bullet> bullet = new ArrayList<Bullet>();





    public Mario(int score, int coin, int level, int life, Context context, float x, float y, Bitmap image) {
        super(x, y, image, null);
        this.score = score;
        this.coin = coin;
        this.context = context;
        this.level = new Level(level, this);
        this.life = life;
        rect = new Rect(0, 11, 16, 31);
    }


    public Mario(Context context) {
        this(0, 0, 1, 3, context, 80, 0, LoadUtil.smallMario.get(2));
    }

    public void draw(Canvas canvas, Paint paint) {
        this.onhitRight=false;
        this.onhitLeft=false;
        this.onhitTop=false;
        this.onland=false;
        this.level.draw(canvas);


        if (isleaf) {
            canvas.save();
            canvas.scale(-1, 1, this.x + this.image.getWidth() / 2, this.y + this.image.getHeight() / 2);
            canvas.drawBitmap(image, x, y, null);
            canvas.restore();
        } else {
            canvas.drawBitmap(image, x, y, null);
        }

        changeImage();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
    }


    public Rect getRect() {
        return this.rect;
    }


    private void goOnload(){
        if(this.xSpeed!=0){
            this.changeTime++;
        }else{
            this.changeTime=0;
        }
        if(changeTime%4<2)
            this.image= LoadUtil.smallMario.get(0);
        else
            this.image= LoadUtil.smallMario.get(1);
    }



    public void goNextLevel(){
        this.level=new Level(this.level.level+1,this);
        this.isWin=false;
        this.isDieding=false;
        this.xSpeed=0;
        this.ySpeed=0;
        Tile.shell.clear();
        Sprite(this.startX,this.startY, image, this);
    }


    public void goCurrentLevel(){
        this.level=new Level(this.level.level,this);
        this.isDied=false;
        this.xSpeed=0;
        this.ySpeed=0;
        this.life--;
        this.isDieding=false;
        this.isWin=false;
        Tile.shell.clear();
        Sprite(this.startX, this.startY, image, this);
    }


    public void goDie(){

        if(this.isDieding) return;
        this.image=LoadUtil.marioDie;
        this.xSpeed=0;
        this.ySpeed=-11;
        this.onland=false;
        this.isDieding=true;
        this.hp=0;

    }

    public void upLev(){

        if(this.lev<3){
            this.hp++;
            this.lev++;
            LoadUtil.upMarioBitMap(this.lev);
            this.rect=new Rect(0,5, 16, 31);
        }else{
            this.score+=10;
        }
    }

    public void downLev(){
        if(this.lev>1){
            this.hp--;
            this.lev--;
            LoadUtil.upMarioBitMap(this.lev);
            if(this.lev==1){
                this.rect=new Rect(0,11, 16, 31);
            }
        }else{
            goDie();
        }


    }


    private void changeStatus(){
        float tempx=this.x+this.xSpeed;
        float tempy=this.y+this.ySpeed;
        if(tempx<MainActivity.ScreenWidth/2&&tempx>-16){
            this.status="left";
            if((!onhitLeft&&this.xSpeed>0)|| (!onhitRight&&this.xSpeed<0) )
                this.x+=this.xSpeed;
        }else{
            this.status="center";
        }

        if(tempy<-16||tempy>MainActivity.ScreenHeight*3/2){
              this.isDied=true;  // chu jie died
        }

    }

    public void changeImage(){
        lastOnland=onland;
        if(!onland){
            if(this.ySpeed!=1&&this.ySpeed!=0&&!isDieding){//判断临界点
                 this.image= LoadUtil.smallMario.get(2);
            }
            if(this.ySpeed < 11) this.ySpeed++;

            if(!onhitTop)
               this.y+=this.ySpeed;
            else
               this.ySpeed=0;
        }else{
            if(!this.onLadderland){
                this.ySpeed=1;
            }
            this.y+=this.ySpeed;
            goOnload();
        }
        changeStatus();
    }


    public void fril()
    {
        if(this.lev >= 3 && this.bullet.size() < 3 )
        {
            this.bullet.add(new Bullet(this.x + this.image.getWidth() / 2,
                    this.y + this.image.getHeight() / 2,LoadUtil.weapon.get(0),isleaf ? -6 : 6,this));
        }
    }

}
