package com.yar.bean;

import android.graphics.Bitmap;

import com.yar.util.LoadUtil;

public class Triangle extends Enemy implements Runnable
{

	private int deadTime = 20;

	private boolean isWaitDie=false;
	
	public Triangle(float x, float y, Bitmap image,Mario m)
	{
		super(x, y, image,m);
		this.hp = 1;
		this.name = "Triangle";
		this.index = 0;
		this.changeTime = 4;
		this.dir = 2;
		this.xSpeed = 2;
	}


	
	public void ChangeImage()
	{
		this.changeTime --;
		
		if(!isWaitDie)
		{
			this.image = LoadUtil.enemy.get(index);
			this.IsTimeOver();
			if(this.index == 2) this.index = 0;
		}
		else
		{
			this.image = LoadUtil.enemy.get(2);
		}
	}



	public void Dead()
	{
		this.xSpeed = 0;
		isWaitDie = true;
		this.mario.score+=3;
		new Thread(this).start();
	}





	@Override
	public void run()
	{
		while(this.deadTime > 0)
		{
			this.deadTime --;
			
			if(this.deadTime <= 0)
			{
				this.hp = 0;
			}
			
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	
	
	
}
