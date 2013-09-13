package com.krowcraft.javagame.client;

import java.awt.image.BufferedImage;


public abstract class Entity {
	private int x, y, w, h;
	private BufferedImage[] sprite;
	private int currentsprite;
	
	public Entity(int x,int y){
		this.x = x;
		this.y = y;
		sprite = new BufferedImage[0];
		
	}
	
	protected void moveTo(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	protected void setSize(int w, int h){
		this.w = w;
		this.h = h;
	}
	
	protected BufferedImage getSprite(){
		return sprite[currentsprite];
	}
	

	protected void setSprite(int spritepos, int spriteno, boolean trans, GameApplet game){
		sprite = new BufferedImage[spriteno];
		for(int z = 0;z < spriteno; z++){
			BufferedImage i = game.iomanager.sprite.getImage(spritepos, trans);
			
			sprite[z] = i;
		}
	}
	
	
	
	protected int getX(){return x;}
	protected int getY(){return y;}
	protected int getW(){return w;}
	protected int getH(){return h;}
	
}
