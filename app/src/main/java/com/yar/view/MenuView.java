package com.yar.view;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.yar.main.MainActivity;
import com.yar.main.MarioActivity;
import com.yar.main.OpoinsActivity;
import com.yar.main.R;
import com.yar.main.SettingActivity;
import com.yar.util.AplactionUtil;
import com.yar.util.LoadUtil;
import com.yar.widget.GameButton;
import com.yar.widget.GameMediaPlayers;


public class MenuView extends GameView implements Runnable
{
    private int textSize = 20;

    private int x1,x2 = MainActivity.ScreenWidth;


    private GameButton StartGame,Options,Score,Exit;

    private GameMediaPlayers gm;

    private Bitmap  background;


    public MenuView(Context context) {
        super(context);



        StartGame = new GameButton((MainActivity.ScreenWidth - 100)/2 , MainActivity.ScreenHeight/2 - 90, textSize,"start my love",context, R.raw.button);
        Options   = new GameButton(StartGame.x, StartGame.y  + 60, textSize, "settings love ",context, R.raw.button);
        Score     = new GameButton(StartGame.x, Options.y  + 60, textSize, "how much love",context, R.raw.button);
        Exit      = new GameButton(StartGame.x, Score.y   + 60, textSize, "hit your love",context, R.raw.button);


        paint.setTypeface(LoadUtil.getTypeface(context));
        gm = new GameMediaPlayers();
        gm.LoadMusic(context, R.raw.menu);

        background= LoadUtil.map.get(0);


       /*if(!AplactionUtil.addValue(this.getContext(), 4)){
            Toast.makeText(this.getContext(), "本月零钱存入已超过三次!", Toast.LENGTH_SHORT).show();
        }
        new AlertDialog.Builder(this.getContext())
                .setTitle("提示")
                .setMessage("游戏积分兑换?")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        Intent i = new Intent(getContext(),SettingActivity.class);
                        getContext().startActivity(i);

                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        Activity a = (Activity)getContext();
                        a.finish();
                    }
                })
                .show();*/

    }


    @Override
    public void surfaceCreated(SurfaceHolder holder)
    {

        gm.startMusic(true);

        this.flag = true;
        this.t = new Thread(this);
        this.t.start();
    }




    @Override
    public void surfaceDestroyed(SurfaceHolder holder)
    {

       gm.puaseMusic(false);

        this.flag = false;
    }



    @Override
    public boolean onTouchEvent(MotionEvent event)
    {

        if(this.StartGame.OnTouch(event.getX(), event.getY()))
        {

            Intent i = new Intent(this.getContext(),MarioActivity.class);
            MenuView.this.getContext().startActivity(i);

        }
        else if(this.Options.OnTouch(event.getX(), event.getY()))
        {
            Intent i = new Intent(this.getContext(),SettingActivity.class);
            MenuView.this.getContext().startActivity(i);
        }
        else if(this.Score.OnTouch(event.getX(), event.getY()))
        {
            Intent i = new Intent(this.getContext(),OpoinsActivity.class);
            MenuView.this.getContext().startActivity(i);
        }
        else if(this.Exit.OnTouch(event.getX(), event.getY()))
        {
            Activity a = (Activity)this.getContext();
            a.finish();
            this.flag = false;
            System.exit(0);
        }
        return super.onTouchEvent(event);
    }




    public void Draw()
    {
        this.canvas = sh.lockCanvas();

        if(canvas != null)
        {
            paint.setColor(Color.YELLOW);

           canvas.drawBitmap(background, x1 -= 2, 0, null);
           canvas.drawBitmap(background, x2-=2 ,0, null);
           if(x1 <= -MainActivity.ScreenWidth)
            {
                x1 = MainActivity.ScreenWidth;
            }
            if(x2 <= -MainActivity.ScreenWidth)
            {
                x2 = MainActivity.ScreenWidth;
            }
            this.StartGame.Draw(canvas, paint);
            this.Options.Draw(canvas, paint);
            this.Score.Draw(canvas, paint);
            this.Exit.Draw(canvas, paint);

            this.sh.unlockCanvasAndPost(canvas);
        }
    }

    @Override
    public void run() {
        while(flag)
        {
            Long start = System.currentTimeMillis();
            this.Draw();
            Long end   = System.currentTimeMillis();
            try
            {
                if(end - start < 50)
                {
                    Thread.sleep(50 - (end - start));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
