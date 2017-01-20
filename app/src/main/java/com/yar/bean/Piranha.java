package com.yar.bean;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.yar.util.LoadUtil;

public class Piranha extends Enemy
{

	private int updownmove[] = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
			 					1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
			 					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0};


	
	private int count;

	public Piranha(float x, float y, Bitmap image,Mario m)
	{
		super(x, y, image,m);
		this.index = 10;
		this.ySpeed = 2;
		this.hp = 1;
		this.name = "Piranha";
	}

	@Override
	public void Move()
	{
		this.y+=this.updownmove[count];
		count++;
		if(count > this.updownmove.length - 1)
		{
			count = 0;
		}
	}

	@Override
	public void draw(Canvas canvas){

			canvas.drawBitmap(image, x, y, null);

	}
	
	public void ChangeImage()
	{
		this.changeTime --;
		
		this.image = LoadUtil.enemy.get(index);
		this.IsTimeOver();
		if(this.index == 12) this.index = 10;
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



	@Override
	public void Logic(Level level){
		for(int i=0; i<this.mario.bullet.size(); i++)
		{
			Bullet b = this.mario.bullet.get(i);
			if(this.MoreRectangle_CollisionWithSpriteXY(b)>0){
				this.mario.bullet.remove(i);
				level.blast.add(new Blast(this.x,this.y, LoadUtil.blast.get(0),this.mario));
				this.Dead();
				this.hitbullet_or_tortoise=true;
			}
		}




		this.CollisionWithEnemy(level);
	}



}
