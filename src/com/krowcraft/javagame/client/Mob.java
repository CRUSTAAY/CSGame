package com.krowcraft.javagame.client;

public class Mob extends Entity {
	private double health, speed;
	private boolean alive = true;
	private boolean moving, following;
	private int targetx, targety;
	private int ID;
	private double angle, xvel, yvel;
	private GameApplet game;
	private Player targetplayer;
	
	public Mob(int x, int y, int w, int h, GameApplet g) {
		super(x, y);
		game = g;
		util.print(this + "is Active!");
		ID = game.iomanager.entitymanager.getMobID();
		game.iomanager.entitymanager.addMob(this);
		moving = false;
		setSize(w, h);
		targetNearPlayer();
		
	}
	
	public void targetNearPlayer(){
		targetplayer = findTarget();
		following = true;
	}
	
	private Player findTarget() {
		int SmallDist = 0;
		Player target = null;
		boolean first = true;
		for(Player p:game.iomanager.entitymanager.getPlayerArray()){
			int distance;
				{ // get distance block
					double thatx = p.getX();
					double thaty = p.getY();
					int tempx, tempy;
					tempx = (int) (thatx - x);
					tempy = (int) (thaty - y);
					distance =(int) Math.sqrt((tempx * tempx)*(tempy * tempy));
					
				}
				
			if(first){ // first check?
				target = p;
				SmallDist = distance;
				first = false;
			} else { // do the test
				if(!(Math.min(SmallDist, distance) == SmallDist)){
					SmallDist = distance;
					target = p;
				} else{
					//nothing, continue loop
				}
				
			}
		}
		return target;
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
		if(alive == false){
			moving = false;
		}
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
					moving = false;
					
				}
			}
			if((targetx - getX()) == 0){
				moving = false;
			}
		}
	}
	
	public void update(){
		if(following){moveto((int) targetplayer.x,(int) targetplayer.getY());}
		moveStep();
		
	}
	public int getID(){
		return ID;
	}
	
	public boolean kill(){
		isAlive();
	return !alive;
	}
}
