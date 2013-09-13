package com.krowcraft.javagame.client;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{
	

	private boolean leftkey, rightkey, upkey, downkey;
	private int keypress;
	private Direction direction;
	
	public KeyManager() {reset();}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
		case KeyEvent.VK_UP:
			upkey = true;
			break;
		case KeyEvent.VK_DOWN:
			downkey = true;
			break;
		case KeyEvent.VK_LEFT:
			leftkey = true;
			break;
		case KeyEvent.VK_RIGHT:
			rightkey = true;
			break;
		case KeyEvent.VK_W:
			upkey = true;
			break;
		case KeyEvent.VK_S:
			downkey = true;
			break;
		case KeyEvent.VK_A:
			leftkey = true;
			break;
		case KeyEvent.VK_D:
			rightkey = true;
			break;
		}
		setDirection();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keypress--;
		switch(e.getKeyCode()){
		case KeyEvent.VK_UP:
			upkey = false;
			break;
		case KeyEvent.VK_DOWN:
			downkey = false;
			break;
		case KeyEvent.VK_LEFT:
			leftkey = false;
			break;
		case KeyEvent.VK_RIGHT:
			rightkey = false;
			break;
		case KeyEvent.VK_W:
			upkey = false;
			break;
		case KeyEvent.VK_S:
			downkey = false;
			break;
		case KeyEvent.VK_A:
			leftkey = false;
			break;
		case KeyEvent.VK_D:
			rightkey = false;
			break;
			
		}
		setDirection();
	}

	private void setDirection() {
		keys();
		if(keypress == 1){
			if(rightkey){direction = Direction.RIGHT;}
			else if(leftkey){direction = Direction.LEFT;}
			else if(upkey){direction = Direction.UP;}
			else if(downkey){direction = Direction.DOWN;}
			else{
				direction = Direction.NONE;
			}
		} else if(keypress == 2){
			if(rightkey && upkey){direction = Direction.UPRIGHT;}
			else if(leftkey && upkey){direction = Direction.UPLEFT;}
			else if(downkey && upkey){direction = Direction.NONE;}
			else if(leftkey && rightkey){direction = Direction.NONE;}
			else if(downkey && rightkey){direction = Direction.DOWNRIGHT;}
			else if(downkey && leftkey){direction = Direction.DOWNLEFT;}
			else {direction = Direction.NONE;}
		} else {
			direction = Direction.NONE;
		}
	}

	private void reset() {
		direction = Direction.NONE;
		keypress = 0;
		leftkey = false;
		rightkey = false;
		upkey = false;
		downkey = false;
	}
	
	private void keys(){
		int key = 0;
		if(leftkey){key++;}
		if(rightkey){key++;}
		if(upkey){key++;}
		if(downkey){key++;}
		keypress = key;
	}
	

	public Direction getDirection() {return direction;}

	@Override
	public void keyTyped(KeyEvent e) {} //notused
	
}
