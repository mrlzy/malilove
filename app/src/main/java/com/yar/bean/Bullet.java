package com.yar.bean;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.yar.main.MainActivity;
import com.yar.util.LoadUtil;

public class Bullet extends Sprite
{

	private int degrees;
	

	boolean onLand;
	

	int jumpTime;
	

	String state="";
	
	

	public Bullet(float x, float y, Bitmap image, int xSpeed,Mario mario)
	{
		super(x, y, image, mario);
		this.xSpeed = xSpeed;
		this.hp = 1;
	}
	
	
	
	

	public void draw(Canvas canvas)
	{

		canvas.save();
		canvas.rotate(degrees, this.x + this.image.getWidth() / 2, this.y + this.image.getHeight() / 2);
		canvas.drawBitmap(image, x, y, null);
		canvas.restore();
	}
	
	
	
	

	public void DegreesPlus()
	{
		this.degrees+=60;
		if(this.degrees>=360)
		{
			this.degrees=0;
		}
	}




	public void Logic(Level level)
	{
		if(this.mario.bullet.isEmpty()) return;

		this.onLand = false;


		for(int i=0; i<level.b_tile.size(); i++)
		{
			Tile tile = level.b_tile.get(i);

			if(tile.x >= -16 && tile.x <= MainActivity.ScreenWidth)
			{

				if(tile.getType() == 133 || tile.getType() == 134 || tile.getType() == 135)
				{
					int flag=tile.MoreRectangle_CollisionWithSpriteXY(this);
					switch (flag){
						case 1:
							break;
						case 2:
							this.y=tile.y-this.image.getHeight();
							this.onLand=true;
							break;
						case 3:

							break;
						case 4:
							break;
						default:

					}
				}



			}


		}





		for(int i=0; i<level.q_tile.size(); i++)
		{
			Tile tile = level.q_tile.get(i);

			if(tile.x >= -16 && tile.x <= MainActivity.ScreenWidth)
			{

				int flag=tile.MoreRectangle_CollisionWithSpriteXY(this);
				switch (flag){
					case 1:
						this.hp=0;
						level.blast.add(new Blast(this.x,this.y, LoadUtil.blast.get(0),this.mario));
						break;
					case 2:
						this.y=tile.y-this.image.getHeight();
						this.onLand=true;
						break;
					case 3:
						this.hp=0;
						level.blast.add(new Blast(this.x,this.y, LoadUtil.blast.get(0),this.mario));
						break;
					case 4:
						this.hp=0;
						level.blast.add(new Blast(this.x,this.y, LoadUtil.blast.get(0),this.mario));
						break;
					default:

				}

			}
		}


		if(this.onLand)
		{
			this.ySpeed=-6;
		}else{
			this.ySpeed ++;
		}

		this.y+=this.ySpeed;


		if(this.x + this.image.getWidth() < 0 || this.x > MainActivity.ScreenWidth || this.y > MainActivity.ScreenHeight)
		{
			this.hp = 0;
		}

		this.x+=this.xSpeed;


	}


}
