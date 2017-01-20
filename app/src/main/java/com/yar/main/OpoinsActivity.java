package com.yar.main;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.yar.util.AplactionUtil;

/**
 * Created by yar on 16-2-22.
 */
public class OpoinsActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        Button back =(Button)findViewById(R.id.back);
        back.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                }

        );


        Button item0 =(Button)findViewById(R.id.button0);
        EditText text0 =(EditText)findViewById(R.id.editText0);
        text0.setText(AplactionUtil.getValue(0));
        item0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText text =(EditText)findViewById(R.id.editText0);
                text.setText(0+"");
                AplactionUtil.setValue(0,OpoinsActivity.this);
            }
        });


        Button item1 =(Button)findViewById(R.id.button1);
        EditText text1 =(EditText)findViewById(R.id.editText1);
        text1.setText(AplactionUtil.getValue(0));
        item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText text =(EditText)findViewById(R.id.editText1);
                text.setText(0+"");
                AplactionUtil.setValue(1,OpoinsActivity.this);

            }
        });


        Button item2 =(Button)findViewById(R.id.button2);
        EditText text2 =(EditText)findViewById(R.id.editText2);
        text2.setText(AplactionUtil.getValue(2));
        item2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText text =(EditText)findViewById(R.id.editText2);
                text.setText(0+"");
                AplactionUtil.setValue(2,OpoinsActivity.this);
            }
        });

        Button item3 =(Button)findViewById(R.id.button3);
        EditText text3 =(EditText)findViewById(R.id.editText3);
        text3.setText(AplactionUtil.getValue(3));
        item3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText text = (EditText) findViewById(R.id.editText3);
                text.setText(0+"");
                AplactionUtil.setValue(3,OpoinsActivity.this);
            }
        });


        EditText text4 =(EditText)findViewById(R.id.editText4);
        text4.setText(AplactionUtil.getValue(4));

        EditText text5 =(EditText)findViewById(R.id.editText5);
        text5.setText(AplactionUtil.getValue(5));


    }
}
