package com.yar.main;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.yar.view.MenuView;

public class MenuActivity extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		super.setContentView(new MenuView(this));


		Toast.makeText(MenuActivity.this, "dedicated to my lover whose name is fangfang from yar", Toast.LENGTH_SHORT).show();

	}
	
}
