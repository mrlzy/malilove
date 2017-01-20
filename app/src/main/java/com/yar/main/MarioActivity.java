package com.yar.main;

import android.app.Activity;
import android.os.Bundle;

import com.yar.view.MarioView;

/**
 * Created by yar on 16-1-11.
 */
public class MarioActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(new MarioView(this));
    }
}
