package com.krowcraft.javagame.client;

public class Mob extends Entity {
	private int health, speed;
	private boolean alive = true;
	private boolean moving;
	private double g;
	private int targetx, targety;
	private double tdx, tdy;
	
	public Mob(int x, int y, int w, int h, GameApplet game) {
		super(x, y);
		util.print(game.iomanager.entitymanageractive);
		game.iomanager.entitymanager.addMob(this);
		moving = false;
		setSize(w, h);
	}
	
	public void setHealth(int newhealth){
		health = newhealth;
		checkAlive();
	}

	private void checkAlive() {
		if(health <= 0){
			alive = false;
		}
	}
	public boolean isAlive(){
		checkAlive();
		return alive;
		
	}
	
	public void moveto(int xt, int yt){ // x++ => y + g
		
		if((getX() != xt) && (getY() != yt)){
			targety = yt;
			targetx = xt;
			tdy = (double)yt - (double)getY();
			tdx = (double)xt - (double)getX();
			g = (tdy/ tdx);
			util.print(g);
			moving = true;
		} else {
			
			
		}
		
	}
	
	public void moveStep(){
		if(moving){
			if(tdx > 0){
			moveTo((getX() + 1),(int) (getY() + g));
			} else if (tdx < 0){
			moveTo((getX() - 1),(int) (getY() + g));	
				
			}
		}
		
	}
	
	public void update(){
		moveStep();
		
	}
	
}
