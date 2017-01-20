package com.yar.bean;

import android.graphics.Bitmap;
import android.graphics.Canvas;


import com.yar.main.MainActivity;
import com.yar.util.LoadUtil;

public class SmokeMonster extends Enemy
{
	private int throwTime;
	

	public SmokeMonster(float x, float y, Bitmap image,Mario m)
	{
		super(x, y, image,m);
		this.startX = x;
		this.startY = y;
		this.name = "SmokeMonster";
		this.hp = 1;
		this.dir = 1;
		this.xSpeed = 4;
	}
	
	
	
	
	
	
	/*@Override
	public void draw(Canvas canvas)
	{
		canvas.save();
		canvas.scale(1, !isWaitDie && !this.hitbullet_or_tortoise ? 1 : -1, this.x+this.image.getWidth()/2, this.y+ this.image.getHeight()/2);
		canvas.drawBitmap(image, x, y, null);
		canvas.restore();
	}
*/





	@Override
	public void Move()
	{
		if(this.y > MainActivity.ScreenHeight) this.hp = 0;
		

			if(this.x >this.mario.x + 50)
			{
				this.dir = 1;
			}
			if(this.x < this.mario.x - 50)
			{
				this.dir = 2;
			}
			
			if(dir == 2)
			{
				this.x+= this.xSpeed;
				if(this.xSpeed < 4) this.xSpeed++;
			}
			else if(dir == 1)
			{
				this.x+= this.xSpeed;
				if(this.xSpeed > -4) this.xSpeed--;	
			}

	}
	
	
	



	@Override
	public void ChangeImage() 
	{


		if(this.throwTime >=80)
		{
			this.image = LoadUtil.enemy.get(12);
		}
		else
		{
			this.image =  LoadUtil.enemy.get(13);
		}
	}






	public void ThrowThornBlame(Level l)
	{
		this.throwTime ++;
		if(dir==1||this.throwTime < 80 ) return;
		l.enemy.add(new Thorn(this.x, this.y, LoadUtil.enemy.get(3),this.mario,true));
		this.throwTime=0;
	}


	@Override
	public void CollisionWithEnemy(Level l){
		super.CollisionWithEnemy(l);
		ThrowThornBlame(l);
	}


	@Override
	public void Dead()
	{
		this.mario.score+=20;
		this.y-=8;
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
