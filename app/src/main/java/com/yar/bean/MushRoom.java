package com.yar.bean;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.yar.main.MainActivity;
import com.yar.util.LoadUtil;

public class MushRoom extends Sprite
{

	private Tile t;
		

	private int count;


	private int dir;
	

	private boolean onLand;
	

	private int move[] = {1,2,3,4,5,6,7,8};
	

	private int index;
		
	
	
	
	
	
	
	public int getCount()
	{
		return count;
	}




	public MushRoom(float x, float y, Bitmap image, Tile t,Mario mario)
	{
		super(x, y, image,mario);
		this.t = t;
		this.dir = 2;
		this.hp = 1;
	}
	
	
	


	public void Move()
	{
		if(count < 16)
		{
			this.y-=2;
			count+=2;
			this.x = t.x;
		}
		
		else
		{		
			if(count<18) count++;
			
			if(dir == 1)
			{
				this.xSpeed=-2;
			}
			else
			{
				this.xSpeed=2;

			}
		}
		
	}
	
	
	


	public void Logic(Level level)
	{
		if(this.count < 18) return;
		
		this.onLand = false;

		for(int i=0; i<level.b_tile.size(); i++)
		{
			Tile tile = level.b_tile.get(i);

			if(tile.x >= -16 && tile.x <= MainActivity.ScreenWidth)
			{


					int flag=tile.MoreRectangle_CollisionWithSpriteXY(this);
					switch (flag){
						case 1:
							this.x=tile.x-tile.image.getWidth();
							dir=1;
							break;
						case 2:
							this.y=tile.y-this.image.getHeight();
							this.onLand=true;
							break;
						case 3:
							this.x=tile.x+this.image.getWidth();
							dir=2;
							break;
						case 4:
							break;
						default:

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
						this.x=tile.x-tile.image.getWidth();
						dir=1;
						break;
					case 2:
						this.y=tile.y-this.image.getHeight();
						this.onLand=true;
						break;
					case 3:
						this.x=tile.x+this.image.getWidth();
						dir=2;
						break;
					case 4:
						break;
					default:

				}

			}
		}




		if(!onLand)
		{
			if(this.ySpeed<6)
			this.ySpeed++;
 		}else {
			this.ySpeed = 0;
		}
		this.y+=this.ySpeed;

		this.x+=this.xSpeed;

	}

	
	

}
