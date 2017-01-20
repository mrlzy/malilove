package com.yar.bean;

import android.graphics.Bitmap;

import com.yar.main.MainActivity;

public class Ladder extends Sprite
{

	public int movedir;


	public Ladder(float x, float y, Bitmap image, int movedir,Mario mario)
	{
		super(x, y, image,mario);
		this.startX = x;
		this.startY = y;
		this.movedir = movedir;
	}

	
	public void move()
	{

		if(this.movedir == 2)
		{
			this.y-=2;
			if(this.y + this.image.getHeight() < 0) this.y = (float) (MainActivity.ScreenHeight*1.5);
		}
		else
		{
			this.y+=2;
			if(this.y > MainActivity.ScreenHeight) this.y = (float) (-MainActivity.ScreenHeight/2);
		}

	}
	
	


}
