package com.krowcraft.javagame.client;

import java.awt.image.BufferedImage;


public abstract class Entity {
	private int w, h;
	protected double x, y;
	private BufferedImage[] sprite;
	private int currentsprite;
	
	public Entity(double x,double y){
		this.x = x;
		this.y = y;
		sprite = new BufferedImage[0];
		
	}
	
	protected void moveTo(double x, double y){
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
	
	public void setSprite() {
		
		for(int z = 0; z < sprite.length; z++){
			sprite[z] = null;
		}
		
	}
	
	protected double getX(){return x;}
	protected double getY(){return y;}
	protected int getW(){return w;}
	protected int getH(){return h;}
	
}
