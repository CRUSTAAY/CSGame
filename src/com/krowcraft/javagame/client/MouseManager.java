package com.krowcraft.javagame.client;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class MouseManager implements MouseListener, MouseMotionListener{
	
	private int mouseX, mouseY;
	private boolean LeftBTN, MiddleBTN, RightBTN, MouseEntered;
	
	public MouseManager(GameApplet game){
		game.addMouseListener(this);
		game.addMouseMotionListener(this);
		reset();
	}
	
	
	private void reset() {
		MouseEntered = false;
		mouseX = 0;
		mouseY = 0;
		LeftBTN = false;
		MiddleBTN = false;
		RightBTN = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.MouseEntered = true;
	}
	

	@Override
	public void mouseExited(MouseEvent e) {
		this.MouseEntered = false;
	}
	

	@Override
	public void mousePressed(MouseEvent e) {
		switch(e.getButton()){
		case 1:
			LeftBTN = true;
			break;
		case 2:
			MiddleBTN = true;
			break;
		case 3:
			RightBTN = true;
			break;
		default:
			break;
		}
	}
	

	@Override
	public void mouseReleased(MouseEvent e) {
		switch(e.getButton()){
		case 1:
			LeftBTN = false;
			break;
		case 2:
			MiddleBTN = false;
			break;
		case 3:
			RightBTN = false;
			break;
		default:
			break;
		}
	}


	@Override
	public void mouseMoved(MouseEvent e) {
		this.mouseX = e.getX();
		this.mouseY = e.getY();
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		this.mouseX = e.getX();
		this.mouseY = e.getY();
	}

	public int getMouseX(){
		return this.mouseX;
	}
	public int getMouseY(){
		return this.mouseY;
	}
	public boolean getLeftMouse(){
		return this.LeftBTN;
	}
	public boolean getMiddleMouse(){
		return this.MiddleBTN;
	}
	public boolean getRightMouse(){
		return this.RightBTN;
	}
	public boolean mouseInScreen(){
		return this.MouseEntered;
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {}
}
