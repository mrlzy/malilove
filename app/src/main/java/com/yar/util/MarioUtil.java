package com.yar.util;

import android.content.Context;
import android.graphics.Bitmap;

import com.yar.bean.Mario;
import com.yar.bean.Tile;
import com.yar.main.MainActivity;

import java.io.DataInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yar on 16-1-11.
 */
public class MarioUtil {


    public static int[][] ReadMap(Context context, String path) {
        int[][] map = (int[][])null;

        try {
            InputStream e = context.getResources().getAssets().open(path);
            DataInputStream dis = new DataInputStream(e);
            int row = dis.readInt();
            int col = dis.readInt();
            map = new int[row][col];

            for(int i = 0; i < map.length; ++i) {
                for(int j = 0; j < map[i].length; ++j) {
                    map[i][j] = dis.readInt();
                }
            }
        } catch (Exception var9) {
            var9.printStackTrace();
        }

        return map;
    }



 private static float setTileY(int i)
    {
        if(MainActivity.ScreenHeight == 240) return i*16f;
        return i*16f+(MainActivity.ScreenHeight - 240);
 }
    public static float setCoinY(float y)
    {
        if(MainActivity.ScreenHeight == 240) return y;
        return y+(MainActivity.ScreenHeight - 240);
    }



    public static List<Tile> creatTile(int map[][], int k,Mario mario)
    {

        List<Tile> tileList=new ArrayList<>();
        for(int i=0; i<map.length; i++)
        {
            for(int j=0; j<map[i].length; j++)
            {
                if(map[i][j] > 0)
                {
                    Tile t = new Tile(j*16, setTileY(i),selectImage(map[i][j]),map[i][j],mario);
                    tileList.add(t);
                }
            }
        }
        return tileList;
    }


    public static float setButtonSize(int w, int h)
    {
        if     (w==320 && h==240 || w==400 && h==240 || w==432 && h==240) return 0.3f;
        else if(w==480 && h==320) return 0.35f;
        else if(w==800 && h==480 || w==854 && h==480) return 0.5f;
        else if(w==960 && h==540 || w==960 && h==640) return 0.6f;
        else if(w>1000 && h >=600 ||w>=600 && h>1000) return 0.8f;
        return 0.4f;
    }

    public static Bitmap selectImage(int index)
    {
        if(index == 130)  return LoadUtil.tile.get(0);
        if(index == 146)  return LoadUtil.tile.get(1);
        if(index == 11 )  return LoadUtil.tile.get(2);
        if(index == 12 )  return LoadUtil.tile.get(3);
        if(index == 27 )  return LoadUtil.tile.get(4);
        if(index == 28 )  return LoadUtil.tile.get(5);
        if(index == 37 )  return LoadUtil.tile.get(6);
        if(index == 21 )  return LoadUtil.tile.get(8);
        if(index == 15 )  return LoadUtil.tile.get(12);
        if(index == 31 )  return LoadUtil.tile.get(13);
        if(index == 47 )  return LoadUtil.tile.get(14);
        if(index == 77 )  return LoadUtil.tile.get(15);
        if(index == 93 )  return LoadUtil.tile.get(17);
        if(index == 10 )  return LoadUtil.tile.get(19);
        if(index == 131 ) return LoadUtil.tile.get(20);
        if(index == 145 ) return LoadUtil.tile.get(21);
        if(index == 129 ) return LoadUtil.tile.get(22);
        if(index == 133 ) return LoadUtil.tile.get(23);
        if(index == 134 ) return LoadUtil.tile.get(24);
        if(index == 135 ) return LoadUtil.tile.get(25);
        if(index == 149 ) return LoadUtil.tile.get(26);
        if(index == 150 ) return LoadUtil.tile.get(27);
        if(index == 151 ) return LoadUtil.tile.get(28);
        if(index == 147 ) return LoadUtil.tile.get(29);
        if(index == 152 ) return LoadUtil.tile.get(30);
        if(index == 17 )  return LoadUtil.tile.get(31);
        if(index == 18 )  return LoadUtil.tile.get(32);
        if(index == 19 )  return LoadUtil.tile.get(33);
        if(index == 20 )  return LoadUtil.tile.get(34);
        return null;
    }


}
