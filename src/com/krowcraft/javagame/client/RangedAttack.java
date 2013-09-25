package com.krowcraft.javagame.client;

public class RangedAttack extends Entity {

	
	private int targetx, targety, ID;
	private double xvel, yvel, angle, speed;
	private boolean moving, toDie;
	private GameApplet game;
	public RangedAttack(double x, double y,GameApplet g) {
		super(x, y);
		game = g;
		//ID = game.iomanager.entitymanager.getRangedAttackID(); //most random bug ever was caused by this!
		game.iomanager.entitymanager.addRangedAttack(this);
		
	}
	
	public void moveto(int xt, int yt){
		targety = yt;		//make it objectwide
		targetx = xt;

		angle = Math.atan2(targety - getY(), targetx - getX()); //get me teh angle
		xvel = 2*Math.cos(angle); //get us teh velocity's
		yvel = 2*Math.sin(angle);
		moving = true;	//we be moving
	}
	
	public void setSpeed(double sp){
		speed = sp;
	}
	
	public void moveStep(){
		if(moving){ //are we moving?
			moveTo((x += xvel),(y += yvel)); //go that way
			
			int distance;
			{
				double tempa = Math.abs(targetx);
				double tempb = Math.abs(targety);
				double tempc = Math.abs(x);
				double tempd = Math.abs(y);
				
				double tempe = tempa - tempc;
				double tempf = tempb - tempd;
				distance =(int) Math.sqrt((tempe * tempe)*(tempf * tempf));
				if((distance > 5 ) == false){
					this.moving = false;
					
				}
			}
			
		}
		
		if(!moving){
			toDie = true;
		}
	}

	public boolean Die(){
		return toDie;
	}
	
	public void update(){
		for(int z = 1; z <= speed; z++){
			moveStep();
		}
	}
	public int getID(){
		return ID;
	}


	}


