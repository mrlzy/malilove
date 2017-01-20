package com.yar.bean;

import android.graphics.Bitmap;

import com.yar.util.LoadUtil;

public class Thorn extends Enemy 
{

	private int index2 = 5;
	
	public Thorn(float x, float y, Bitmap image,Mario m)
	{
		super(x, y, image,m);
		this.hp = 1;
		this.name = "Thorn";
		this.index = 3;
		this.changeTime = 4;
		this.dir = 2;
		this.xSpeed = 2;
	}

	public Thorn(float x, float y, Bitmap image,Mario m,boolean noset)
	{
		super(x, y, image,m,noset);
		this.hp = 1;
		this.name = "Thorn";
		this.index = 3;
		this.changeTime = 4;
		this.dir = 2;
		this.xSpeed = 2;
	}


	public void ChangeImage()
	{
		this.changeTime -- ;
		if(this.onLand)
		{
			this.image = LoadUtil.enemy.get(index);
			this.IsTimeOver();
			if(this.index == 5) this.index = 3;
		}
		else
		{
			this.image = LoadUtil.enemy.get(index2++);
			if(this.index2 == 7) this.index2 = 5;
		}
	}


	@Override
	public void CollisionWithEnemy(Level l){
		if(this.isCollsionWithRect(this.mario,this.mario.getRect())){
			if(!this.hitOning){
				this.hitOning=true;
				this.mario.downLev();
			}
		}else{
			this.hitOning=false;
		}
	}

	public void Dead()
	{
		this.hp--;
		this.mario.score+=5;
	}




}
