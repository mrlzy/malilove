package com.yar.bean;

import android.graphics.Bitmap;
import com.yar.util.LoadUtil;
import com.yar.util.MarioUtil;

public class Coin extends Sprite
{
	private float startX, startY; 
	
	private int type;
	
	
	private int index,index2;
	

	private int move[] = {-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7,8,9,10};
	
	private int changeTime;
	 

	
	public int getType() 
	{
		return type;
	}


	public Coin(float x, float y_, Bitmap image, int type,Mario mario)
	{
		super(x, MarioUtil.setCoinY(y_), image,mario);
		this.startX = x;
		this.startY =MarioUtil.setCoinY(y_);
		this.type = type;
		this.hp = 1;
	}


	public Coin(float x, float y_, Bitmap image, int type,Mario mario,boolean noreset)
	{
		super(x, y_, image,mario);
		this.startX = x;
		this.startY =y_;
		this.type = type;
		this.hp = 1;
	}



	public void ChangeImage()
	{
		this.changeTime ++;
		if(this.changeTime > 1)
		{
			this.changeTime = 0;
			this.image = LoadUtil.coins.get(index2);
			index2++;
			if(index2==3) index2=0;
		}
	}
	
	
	
	
	
	public void Jump()
	{
		if(this.type == 1)
		{
			this.y+=this.move[index];
			if(index < this.move.length - 1)
			{
				this.index++;
			}
			else
			{
				this.hp = 0;
			}
		}
	}

	


}
