package com.yar.bean;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.yar.main.MainActivity;

public class Shell extends Sprite
{





	public Shell(float x, float y, Bitmap image, int xSpeed,Mario mario)
	{
		super(x, y, image,mario);
		this.xSpeed = xSpeed;
		this.hp = 1;
	}

	

	public void Draw(Canvas canvas)
	{
		if(this.xSpeed > 0)
		{
			canvas.save();
			canvas.scale(-1, 1, this.x + this.image.getWidth()/2, this.y + this.image.getHeight()/2);
			canvas.drawBitmap(image, x, y, null);
			canvas.restore();
		}
		else
		{
			canvas.drawBitmap(image, x, y, null);
		}
	}
	
	
	public void Move()
	{

			this.x +=this.xSpeed;

			if(this.x + this.image.getWidth() < 0 || this.x > MainActivity.ScreenWidth)
			{
				this.hp = 0;
			}

	}

	
}
