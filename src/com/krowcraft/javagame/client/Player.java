package com.krowcraft.javagame.client;

public class Player extends Entity {
	
	private boolean localplayer;
	private GameApplet game;
	private double speed;
	private boolean canFire;
	private long lastattack;
	public Player(int x, int y, int w, int h,GameApplet g, boolean isLocalUser) {
		super(x, y);
		game = g;
		game.iomanager.entitymanager.addPlayer(this);
		speed = 1.2;
		setSize(w, h);
		localplayer = isLocalUser;
		canFire = true;
	}

	public void update() {
		move();
		checkAttack();
		}

	private void checkAttack() {
	if(localplayer){
		long time = util.getMicro();
		if((time - lastattack) > 50){ //100
			canFire = true;
		}
		
		if(game.iomanager.mousemanager.getLeftMouse() && canFire){
			RangedAttack a = new RangedAttack(x,y,game);
			a.setSpeed(5);
			a.moveto(game.iomanager.mousemanager.getMouseX(), game.iomanager.mousemanager.getMouseY());
			a.setSprite(8, 1, false, game);
			lastattack = time;
			canFire = false;
		}
	//} else if(){
		
	} else{
		
	}
	
	
	}

	private void move() {
		if(localplayer){
			localmove();
		}
		
	}

	private void localmove() {
		switch(game.iomanager.keymanager.getDirection()){
		case DOWN:
			moveTo(x, y + speed);
			break;
		case DOWNLEFT:
			moveTo(x - speed,y + speed);
			break;
		case DOWNRIGHT:
			moveTo(x + speed,y + speed);
			break;
		case LEFT:
			moveTo(x - speed,y);
			break;
		case RIGHT:
			moveTo(x + speed,y);
			break;
		case UP:
			moveTo(x,y - speed);
			break;
		case UPLEFT:
			moveTo(x - speed,y - speed);
			break;
		case UPRIGHT:
			moveTo(x + speed,y - speed);
			break;
		case NONE:
			break;
		default:
			break;
		}
	}

	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean Die() {
		// TODO Auto-generated method stub
		return false;
	}
}
