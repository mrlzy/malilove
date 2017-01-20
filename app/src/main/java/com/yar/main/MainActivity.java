package com.yar.main;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.widget.Toast;

import com.yar.util.AplactionUtil;
import com.yar.util.LoadUtil;
import com.yar.view.LaodView;

public class MainActivity extends Activity implements  Runnable {

    public static  int ScreenWidth;
    public static  int ScreenHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        this.setContentView(new LaodView(this));
        new Thread(this).start();

    }

    private void init(){
        Display display = this.getWindowManager().getDefaultDisplay();
        this.ScreenWidth = display.getWidth();
        this.ScreenHeight = display.getHeight();

    }


    @Override
    public void run() {
        LoadUtil.loadResource(this);

        Intent i = new Intent(this,MenuActivity.class);
        this.startActivity(i);
        this.finish();
    }



}
