package com.yar.bean;

import android.graphics.Bitmap;

import com.yar.util.LoadUtil;

public class Blast extends Sprite
{
	private int index;


	public Blast(float x, float y, Bitmap image,Mario m)
	{
		super(x, y, image,m);
		this.hp = 1;
	}	

	public void ChangeImage()
	{
		this.image = LoadUtil.blast.get(index);
		index++;
		if(index > 2)
		{
			this.hp = 0;
		}
	}
	

}
