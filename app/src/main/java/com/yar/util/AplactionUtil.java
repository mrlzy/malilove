package com.yar.util;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yar on 16-1-17.
 */
public class AplactionUtil {

    public static String[] ss={"运动","踏青","旅游","影视","现有","已用"};

    public static int[] nn={0,0,0,0,0,0};

    public static int tt=0;

    public static  SimpleDateFormat format = new SimpleDateFormat("yyyyMM");


    public static String lastdd="";

    public static String nowdd="";

    static {
        nowdd = format.format(new Date());
        lastdd = nowdd;
    }




    public static void setValue(int index,Context cc){
        nn[5]+=nn[index];
        nn[index]=0;
        updateDb(cc,false);
    }

    public static void setValue2(int index ,Context cc){
        nn[index]+=nn[4];
        nn[4]=0;
        updateDb(cc,false);
    }

    public static boolean addValue(Context cc,int v){
       if(nowdd.equals(lastdd)&&tt>3) {
           return false;
        }else{
            tt= nowdd.equals(lastdd)?tt+1:1;
            nn[4]+= v;
            updateDb(cc, true);
        }

       return true;
    }



    private static void updateDb(Context cc,boolean isUpdate){
        SQLiteDatabase db = cc.openOrCreateDatabase("test.db", Context.MODE_PRIVATE, null);

        String sql="update nn set ";

        for(int i=0;i<nn.length;i++){
            sql+=" c"+i+"="+nn[i]+",";
        }

        sql+=" tt="+tt;

        if(isUpdate){
            sql+=",dd='"+nowdd+"'";
            lastdd=nowdd;
        }

        sql+=" where _id=1";

        db.execSQL(sql);

        db.close();


    }

    public static String  getValue(int index){
       return  nn[index]+"";
    }


    public static void loadDbData(Context cc){
        SQLiteDatabase db = cc.openOrCreateDatabase("test.db", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE if not exists  nn (_id INTEGER PRIMARY KEY, c0 INTEGER, c1 INTEGER,c2 INTEGER,c3 INTEGER,c4 INTEGER,c5 INTEGER,tt INTEGER,dd VARCHAR)");
        boolean isload=false;

        Cursor c = db.rawQuery("SELECT * FROM nn WHERE _id = ?", new String[]{"1"});
        if (c.moveToNext()) {
            isload=true;
            for(int i=0;i<nn.length;i++){
                nn[i]= c.getInt(c.getColumnIndex("c"+i));
            }
            lastdd=c.getString(c.getColumnIndex("dd"));
            tt= c.getInt(c.getColumnIndex("tt"));

        }
        c.close();

        if(!isload){
            db.execSQL("INSERT INTO nn VALUES (1,0,0,0,0,0,0,0,?)",new String[]{nowdd});
        }


        db.close();
    }

}
