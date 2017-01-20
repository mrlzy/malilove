package com.yar.bean;

import android.graphics.Bitmap;


import com.yar.util.LoadUtil;
import com.yar.util.MarioUtil;

import java.util.ArrayList;
import java.util.Random;

public class Tile extends Sprite
{
	private float startX,startY;
	

	private int type;
	

	private int index,index2;
	

	private int changeTime = 4;
	
	static int count;
	

	private int jumpTime;
			
	
	static int move[] = {-4,-3,-2,-1,0,1,2,3,4};
	static ArrayList <Shell>shell = new ArrayList<Shell>();

	static ArrayList <Sprite>food = new ArrayList<Sprite>();


	public int value;
	
	private int frilTime;
	

	
	
	
	
	public int getType() 
	{
		return type;
	}

	public void setJumpTime(int jumpTime)
	{
		this.jumpTime = jumpTime;
	}



	public Tile(float x, float y, Bitmap image, int type,Mario mario)
	{
		super(x, y, image,mario);
		this.startX = x;
		this.startY = y;
		this.type = type;
		
		switch(type)
		{
		case 21:
			this.index = 8;
			this.value = 1;
		break;
		
		case 17:
			this.index = 31;
		break;
		
		case 37:
			this.value = new Random().nextInt(6) + 1;
		break;
		
		case 77:
			this.index =15;
		break;
		
		case 93:
			this.index =17;
		break;
		}

	}


	public void Jump()
	{
		if(this.jumpTime > 0)
		{
			this.y += move[index2];
			if(index2 < move.length - 1)
			{
				index2++;
			}
			else
			{
				this.jumpTime = 0;
				index2 = 0;
			}
		}
	}



	public void ChangeImage()
	{
		this.changeTime -- ;
		switch(type)
		{
			case 21:
				if(this.value > 0)
				{
					this.image = LoadUtil.tile.get(index);
					this.IsTimeOver();
					if(index > 11 ) index = 8;
				}
				else
				{
					this.image = LoadUtil.tile.get(7);
				}
				break;

			case 17:
				this.image = LoadUtil.tile.get(index);
				this.IsTimeOver();
				if(index > 34 ) index = 31;
				break;

			case 37:
				if(this.value > 0) this.image = LoadUtil.tile.get(6);
				else this.image = LoadUtil.tile.get(7);
				break;

			case 77:
				this.image = LoadUtil.tile.get(index);
				index++;
				if(index > 16 ) index = 15;
				break;

			case 93:
				this.image = LoadUtil.tile.get(index);
				index++;
				if(index > 18 ) index = 17;
				break;
		}
	}


	public void IsTimeOver()
	{
		if(this.changeTime <= 0)
		{
			this.index++;
			this.changeTime = 4;
		}
	}
	public void Fril()
	{
		this.frilTime ++;
		if(this.type == 15 && this.frilTime > 50)
		{
			shell.add(new Shell(this.x, this.y+1, LoadUtil.weapon.get(1),mario.x > this.x ? 6 : -6,this.mario));
			this.frilTime = 0;
		}
	}


}
