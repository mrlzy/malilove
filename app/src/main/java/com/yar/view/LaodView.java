package com.yar.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.view.SurfaceHolder;


import com.yar.view.GameView;
import com.yar.main.MainActivity;
import com.yar.util.ImageUtil;
import com.yar.util.LoadUtil;

import java.io.IOException;

/**
 * Created by yar on 16-1-8.
 */
public class LaodView extends GameView implements Runnable {

    private Bitmap red,yellow;

    private int x,y;

    private int width;

    private int alpha[] = {255,255,255,255,255,255,255,255,255,255,230,210,190,170,150,130,
            110,90,70,50,30,10,0,10,30,50,70,90,110,130,150,170,190,210,230};

    private int index=0;

    public LaodView(Context context) {
        super(context);

        try
        {
            red    = BitmapFactory.decodeStream(context.getAssets().open("progressbar/red.png"));
            red    = ImageUtil.FitTheImage(red, (float) MainActivity.ScreenWidth / (red.getWidth() * 1.5f), 1.0f);
            yellow = BitmapFactory.decodeStream(context.getAssets().open("progressbar/yellow.png"));
            yellow = ImageUtil.FitTheImage(yellow, (float) MainActivity.ScreenWidth / (yellow.getWidth() * 1.5f), 1.0f);

        } catch (IOException e) {
            e.printStackTrace();
        }

        this.x= (MainActivity.ScreenWidth-red.getWidth())/2;
        this.y=MainActivity.ScreenHeight-30;

        this.width=red.getWidth()/ LoadUtil.total;

        paint.setTypeface(LoadUtil.getTypeface(getContext()));

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder)
    {
        this.flag = true;
        this.t = new Thread(this);
        this.t.start();
    }




    @Override
    public void surfaceDestroyed(SurfaceHolder holder)
    {
        this.flag = false;
    }


    private String getLogoText(int index){
        String temp=".";
        for(int i=0;i<index;i++){
            temp+=".";
        }
        return "loading"+temp;
    }

    public void Draw()
    {
        this.canvas = sh.lockCanvas();
        if(canvas != null)
        {
            canvas.drawColor(Color.BLACK);


            canvas.drawBitmap(red, this.x, this.y, null);
            canvas.save();

            canvas.clipRect(x, y, x + (LoadUtil.index*width < red.getWidth() ? LoadUtil.index*width  :red.getWidth()) , y + yellow.getHeight());
            canvas.drawBitmap(yellow, x, y, null);
            canvas.restore();


            index++;
            paint.setAlpha(alpha[index % alpha.length]);
            paint.setColor(Color.YELLOW);
            paint.setTextSize(16);

            canvas.drawText(getLogoText(index % 5), x, y - 10, paint);
            paint.setAlpha(255);
            canvas.drawText("dedicated to my lover whose name is fangfang from yar", 0,20, paint);
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
