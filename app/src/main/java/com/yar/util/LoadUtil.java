package com.yar.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.media.Image;

import com.yar.main.MainActivity;
import com.yar.main.R;
import com.yar.widget.GameSoundPool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yar on 16-1-8.
 */
public class LoadUtil {

    public static int total = 111;

    public static int index=0;




    public static List<Bitmap> map=new ArrayList<Bitmap>();

    public static List<Bitmap> smallMario=null;

    private static List<Bitmap> mario1=new ArrayList<Bitmap>();

    private static List<Bitmap> mario2=new ArrayList<Bitmap>();

    private static List<Bitmap> mario3=new ArrayList<Bitmap>();



    public static Bitmap marioDie=null;

    public static Bitmap marioWin=null;


    public static Bitmap marioLogo=null;


    public static List <Bitmap>tile = new ArrayList<Bitmap>();

    public static ArrayList <Bitmap>coins = new ArrayList<Bitmap>();

    public static ArrayList <Bitmap>enemy = new ArrayList<Bitmap>();

    public static ArrayList <Bitmap>weapon = new ArrayList<Bitmap>();


    public static ArrayList <Bitmap>button = new ArrayList<Bitmap>();


    public static ArrayList <Bitmap> food = new ArrayList<Bitmap>();

    public static ArrayList <Bitmap> blast = new ArrayList<Bitmap>();


    public static GameSoundPool gs = new GameSoundPool(17);

    public  static Bitmap ladder ;


    public static Typeface mFace;


    public static ArrayList <Bitmap> study0 = new ArrayList<Bitmap>();

    public static ArrayList <Bitmap> study1 = new ArrayList<Bitmap>();



    public static void upMarioBitMap(int lev){
        if(lev==1)
            smallMario=mario1;
        else if(lev==2)
            smallMario=mario2;
        else
            smallMario=mario3;


    }

    public static Typeface getTypeface(Context context) {
        if (mFace == null)
            mFace = Typeface.createFromAsset(context.getAssets(), "fonts/font.ttf");
        return mFace;
    }


    public static void loadResource(Context context) {
       if(index==0){
           LoadImage(context);
           LoadMusic(context);
           AplactionUtil.loadDbData(context);
           index++;
       }



    }

    private static void LoadImage(Context context) {


        Bitmap m = null;
        try {
            for(int i=1; i<=4; i++) {
                m = BitmapFactory.decodeStream(context.getAssets().open("map/map"+i+".jpg"));
                m = ImageUtil.FitTheScreenSizeImage(m, MainActivity.ScreenWidth, MainActivity.ScreenHeight);
                map.add(m);
                index++;
            }

            for(int i=0; i<3; i++) {
                m = BitmapFactory.decodeStream(context.getAssets().open("mario/smallmario" + i + ".png"));
                mario1.add(m);
                index++;
            }

            marioLogo= mario1.get(0);
            smallMario=mario1;


            for(int i=0; i<3; i++) {
                m = BitmapFactory.decodeStream(context.getAssets().open("mario/midmario" + i + ".png"));
                mario2.add(m);
                index++;
            }

            for(int i=1; i<=14; i++)
            {
                enemy.add(BitmapFactory.decodeStream(context.getAssets().open("enemy/enemy" + i + ".png")));
                index++;
            }


            for(int i=0; i<3; i++) {
                m = BitmapFactory.decodeStream(context.getAssets().open("mario/bigmario" + i + ".png"));
                mario3.add(m);
                index++;
            }



            m = BitmapFactory.decodeStream(context.getAssets().open("mario/die.png"));
            marioDie=m;
            index++;


            m = BitmapFactory.decodeStream(context.getAssets().open("mario/win.png"));
            marioWin=m;
            index++;

            for(int i=1; i<=35; i++)
            {
                tile.add(BitmapFactory.decodeStream(context.getAssets().open("tile/tile" + i + ".png")));
                index++;
            }


            for(int i=1; i<=5; i++)
            {
                Bitmap image = BitmapFactory.decodeStream(context.getAssets().open("button/button" + i + ".png"));
                float rate =MarioUtil.setButtonSize(MainActivity.ScreenWidth, MainActivity.ScreenHeight);
                image = ImageUtil.FitTheImage(image, rate, rate);
                button.add(image);
                index++;
            }

            for(int i=1; i<=2; i++)
            {
                weapon.add(BitmapFactory.decodeStream(context.getAssets().open("weapon/weapon" + i + ".png")));
                index++;
            }


            ladder = BitmapFactory.decodeStream(context.getAssets().open("tool/tool.jpg"));
            index++;


            for(int i=1; i<=3; i++)
            {
                blast.add(BitmapFactory.decodeStream(context.getAssets().open("blast/blast" + i + ".png")));
                index++;
            }

            for(int i=1; i<=4; i++)
            {
                coins.add(BitmapFactory.decodeStream(context.getAssets().open("coin/coin" + i + ".png")));
                index++;
            }


            for(int i=1; i<=3; i++)
            {
                food.add(BitmapFactory.decodeStream(context.getAssets().open("food/food" + i + ".png")));
                index++;
            }



            for(int i=1; i<=6; i++)
            {
                study0.add(BitmapFactory.decodeStream(context.getAssets().open("study/study0_game0"+i+"_0.png")));
                index++;
            }

            for(int i=1; i<=6; i++)
            {
                study1.add(BitmapFactory.decodeStream(context.getAssets().open("study/study0_game0"+i+"_1.png")));
                index++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }






    }

    private static void LoadMusic(Context context) {
        gs.loadGameMusic(context,R.raw.bullet_2);index++;
        gs.loadGameMusic(context,R.raw.bullet_1);index++;
        gs.loadGameMusic(context,R.raw.bullet_or_tortoise_hit);index++;
        gs.loadGameMusic(context,R.raw.coin);index++;
        gs.loadGameMusic(context,R.raw.dead);index++;
        gs.loadGameMusic(context,R.raw.eatfood);index++;
        gs.loadGameMusic(context,R.raw.gameover);index++;
        gs.loadGameMusic(context,R.raw.hit);index++;
        gs.loadGameMusic(context,R.raw.jump);index++;
        gs.loadGameMusic(context,R.raw.level_1);index++;
        gs.loadGameMusic(context,R.raw.level_2);index++;
        gs.loadGameMusic(context,R.raw.level_win);index++;
        gs.loadGameMusic(context,R.raw.no_time);index++;
        gs.loadGameMusic(context,R.raw.pluslife);index++;
        gs.loadGameMusic(context,R.raw.step_on_enemy);index++;
        gs.loadGameMusic(context,R.raw.top_of_food);index++;
    }
}