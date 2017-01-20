package com.yar.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;

import java.io.InputStream;

/**
 * Created by yar on 16-1-8.
 */
public class ImageUtil {

    /**
     * 把图片按比例缩放
     * @param m
     * @param ScreenWidth
     * @param ScreenHeight
     * @return
     */
    public static Bitmap FitTheScreenSizeImage(Bitmap m, int ScreenWidth, int ScreenHeight) {
        float width = (float)ScreenWidth / (float)m.getWidth();
        float height = (float)ScreenHeight / (float)m.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(width, height);
        return Bitmap.createBitmap(m, 0, 0, m.getWidth(), m.getHeight(), matrix, true);
    }

    public static Bitmap FitTheImage(Bitmap m, float width, float height) {
        Matrix matrix = new Matrix();
        matrix.postScale(width, height);
        return Bitmap.createBitmap(m, 0, 0, m.getWidth(), m.getHeight(), matrix, true);
    }

    public static Bitmap CreateMap(Bitmap m, int col, int w, int h) {
        Bitmap image = Bitmap.createBitmap(w * col, h, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(image);
        canvas.drawColor(-1);

        for(int i = 0; i < col; ++i) {
            canvas.drawBitmap(m, (float)(w * i), 0.0F, (Paint)null);
        }

        return image;
    }

    public static Bitmap BitmapClipBitmap(Bitmap bitmap, int x, int y, int w, int h) {
        return Bitmap.createBitmap(bitmap, x, y, w, h);
    }

    public static Bitmap ReadBitMap(Context context, String path) {
        InputStream is = null;
        BitmapFactory.Options opt = new BitmapFactory.Options();
        opt.inPreferredConfig = Bitmap.Config.RGB_565;
        opt.inPurgeable = true;
        opt.inInputShareable = true;

        try {
            is = context.getAssets().open(path);
        } catch (Exception var5) {
            var5.printStackTrace();
        }

        return BitmapFactory.decodeStream(is, (Rect)null, opt);
    }

    public static BitmapDrawable Drs(Context c, String path) {
        Bitmap bitmap = ReadBitMap(c, path);
        BitmapDrawable bd = new BitmapDrawable(bitmap);
        bd.setDither(true);
        return bd;
    }

}




