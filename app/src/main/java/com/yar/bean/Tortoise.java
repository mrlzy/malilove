package com.yar.bean;

import android.graphics.Bitmap;

import com.yar.main.MainActivity;
import com.yar.util.LoadUtil;

public class Tortoise extends Enemy implements Runnable
{
	private int changeStateTime = 150;

	public boolean isWaitDie=false;


	public Tortoise(float x, float y, Bitmap image,Mario m)
	{
		super(x, y, image,m);
		this.name = "Tortoise";
		this.hp = 1;
		this.index = 7;
		this.xSpeed = 2;
		this.changeTime = 4;
		this.dir = 2;
	}
	
	
	public void ChangeImage()
	{
		this.changeTime --;

		if(!isWaitDie)
		{
			this.image = LoadUtil.enemy.get(index);
			this.IsTimeOver();
			if(this.index == 9) this.index = 7;
		}
		else
		{
			this.image = LoadUtil.enemy.get(9);
		}
	}

	
	public void Dead()
	{
		this.xSpeed = 0;
		this.isWaitDie = true;
		if(this.changeStateTime == 150)
		  new Thread(this).start();
        else
			this.changeStateTime = 150	;
	}

	
	

	@Override
	public void run()
	{
		while(this.changeStateTime > 0)
		{
			this.changeStateTime --;

			if(this.changeStateTime <= 0 )
			{
				this.changeStateTime = 150;
				this.xSpeed = 2;
				this.isWaitDie=false;
				break;
			}
			if(this.y> MainActivity.ScreenHeight*3/2||this.hitbullet_or_tortoise){
				this.hp--;
				this.mario.score+=3;
				break;
			}

			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
	@Override
	public void CollisionWithEnemy(Level level){
		if(!this.isWaitDie){
			super.CollisionWithEnemy(level);
		}else{

			if(this.xSpeed==0){
				int flag=this.MoreRectangle_CollisionWithSpriteXY(this.mario,this.mario.getRect());
				switch (flag){
					case 1:
						dir=2;
						this.xSpeed=8;
						break;
					case 2:
						this.mario.ySpeed=-10;
						this.Dead();
						break;
					case 3:
						dir=1;
						this.xSpeed=8;
						break;
					case 4:
						break;
					default:

				}
			}else{

				if(this.isCollsionWithRect(this.mario,this.mario.getRect())){
						if(!this.hitOning){
									this.hitOning=true;
									this.mario.downLev();
						}else{
							this.hitOning=false;

						}
				}

				for(int i=0; i<level.enemy.size(); i++)
				{
					Enemy e = level.enemy.get(i);

					if(!e.equals(this)){
						if(e.MoreRectangle_CollisionWithSpriteXY(this)>0){
							 e.hitbullet_or_tortoise=true;
							 e.Dead();
						}
					}

				}



			}



		}


	}

}
