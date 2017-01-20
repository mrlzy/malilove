package com.yar.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by yar on 16-1-7.
 */
public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    public SurfaceHolder sh = super.getHolder();
    public Canvas canvas;
    public Paint paint = new Paint(1);
    public boolean flag;
    public Thread t;

    public GameView(Context context) {
        super(context);
        this.paint.setAntiAlias(true);
        this.setFocusable(true);
        this.sh.addCallback(this);
    }

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.paint.setAntiAlias(true);
        this.setFocusable(true);
        this.sh.addCallback(this);

    }

    public void surfaceCreated(SurfaceHolder holder) {
    }

    public void surfaceDestroyed(SurfaceHolder holder) {
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }


}
