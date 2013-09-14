package com.krowcraft.javagame.client;

public class Mob extends Entity {
	private double health, speed;
	private boolean alive = true;
	private boolean moving;
	private double g;
	private int targetx, targety;
	private double angle, xvel, yvel;
	
	public Mob(int x, int y, int w, int h, GameApplet game) {
		super(x, y);
		
		util.print(this + "is Active!");
		util.print(game.iomanager.entitymanageractive);
		game.iomanager.entitymanager.addMob(this);
		moving = false;
		setSize(w, h);
	}
	
	public void setHealth(int newhealth){
		health = newhealth;
		checkAlive();
	}
	
	public void setSpeed(double sp){
		speed = sp;
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
	
	public void moveto(int xt, int yt){
		targety = yt;		//make it objectwide
		targetx = xt;
		angle = Math.atan2(targety - getY(), targetx - getX()); //get me teh angle
		xvel = speed*Math.cos(angle); //get us teh velocity's
		yvel = speed*Math.sin(angle);
		moving = true;	//we be moving
	}
	
	public void moveStep(){
		if(moving){ //are we moving?
			moveTo((x += xvel),(y += yvel)); //go that way
			if((targetx - getX()) == 0){
				moving = false;
			}
		}
	}
	
	public void update(){
		moveStep();
		
	}
	
}
