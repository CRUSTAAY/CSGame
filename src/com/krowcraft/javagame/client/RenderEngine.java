package com.krowcraft.javagame.client;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class RenderEngine implements Runnable {

	private static final long serialVersionUID = 518891768722222542L;
	private boolean haschanged = false;
	private boolean alive, startup;
	public Thread renderthread;
	protected BufferedImage img;
	protected Graphics2D g2d;
	private long CFlastnanotime, FClastnanotime;
	private int FPS;
	GameApplet game;
	
	public RenderEngine(GameApplet gameapp){
		startup = true;
		game = gameapp;
		alive = true;
		renderthread = new Thread(this);
		haschanged = true;
		img = new BufferedImage(512, 512, BufferedImage.TYPE_4BYTE_ABGR);
		g2d = (Graphics2D) img.getGraphics();
		renderthread.start();
	}
	

	
	
	
	@Override
	public void run() {
		while(alive){
			if(startup){
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				startup = false;
			}
			if(canframe()){
				clear();
				game.iomanager.entitymanager.updateMob();
				game.appPaint();
				
				haschanged = false;
			}
		}
	}
	
	private void clear() {
		Color temp = g2d.getColor();
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, 512, 512);
		g2d.setColor(temp);
	}





	public BufferedImage getImage(){
		return img;
	}

	
	public void draw(BufferedImage drawimg, int x, int y){
		haschanged = true;
		g2d.drawImage(drawimg, x, y, null);
	}
	
	
	private void framecount(){ //fps counter
		FPS++;
		Long FCcurrentNano = util.getnano();
		if ((FCcurrentNano - FClastnanotime) >= 1000000000){
			FClastnanotime = FCcurrentNano;
			util.print("FPS = " + FPS);
			FPS = 0;
		}
	
	}
	
	private boolean canframe(){ //should the game render a frame this time?
		Long CFcurrentNano = util.getnano();
		Long dif = CFcurrentNano - CFlastnanotime;
		if(dif >= 20000000){
			framecount();
			CFlastnanotime = CFcurrentNano;
			return true;
		} else{
			return false;
		}
	}
	
	

}
