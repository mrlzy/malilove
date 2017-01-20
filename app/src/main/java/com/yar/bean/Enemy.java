package com.yar.bean;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.yar.main.MainActivity;
import com.yar.util.LoadUtil;
import com.yar.util.MarioUtil;


public class Enemy extends Sprite
{


	
	public String name;
	
	
	public int index;
	

	public int changeTime;
	

	public int dir;
	


	public boolean onLand;

	public boolean hitOning=false;
	
	public boolean hitbullet_or_tortoise=false;


	
	
	
	
	

	public Enemy(float x, float y_, Bitmap image,Mario m)
	{
		super(x, MarioUtil.setCoinY(y_), image,m);
	}



	public Enemy(float x, float y_, Bitmap image,Mario m,boolean noset)
	{
		super(x, y_, image,m);
	}







	public void Move()
	{
		if(dir == 1)
		{
			if(this.xSpeed>0)
			   this.xSpeed=-1*this.xSpeed;
		}
		else
		{
			if(this.xSpeed<0)
				this.xSpeed=-1*this.xSpeed;

		}
	}


	public void draw(Canvas canvas){
       if(dir==1){
		canvas.save();
		canvas.scale(-1, 1, this.x + this.image.getWidth() / 2, this.y + this.image.getHeight() / 2);
		canvas.drawBitmap(image, x, y, null);
		canvas.restore();}
		else
		canvas.drawBitmap(image, x, y, null);

	}

	public void ChangeImage(){}

	public void IsTimeOver()
	{
		if(this.changeTime <= 0)
		{
			this.index++;
			this.changeTime = 4;
		}
	}
	public void Dead(){}
	public void CollisionWithEnemy(Level l){

		if(this.isCollsionWithRect(this.mario,this.mario.getRect())){

			if(this.mario.y+this.mario.image.getHeight()<this.y+this.image.getHeight()){
				this.mario.ySpeed=-10;
				this.Dead();
			}else{
				if(!this.hitOning){
					this.hitOning=true;
					this.mario.downLev();
				}
			}

		}else{
			this.hitOning=false;
		}




	}



	public void Logic(Level level)
	{

		if(this.hitbullet_or_tortoise) return;

		this.onLand = false;



		for(int i=0; i<level.b_tile.size(); i++)
		{
			Tile tile = level.b_tile.get(i);
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





		for(int i=0; i<level.q_tile.size(); i++)
		{
			Tile tile = level.q_tile.get(i);
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



		this.x+=this.xSpeed;


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


		if(this.onLand)
		{
			this.ySpeed=0;
		}else{
			this.ySpeed ++;
		}


		this.y+=this.ySpeed;




	}




		
	
}
