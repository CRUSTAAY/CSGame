package com.krowcraft.javagame.client;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class RenderEngine implements Runnable { //NOTE flickering occurs at about 3200 entity's, buffer fails at 4000

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 518891768722222542L;
	private boolean terrainbuild = false;
	@SuppressWarnings("unused")
	private boolean haschanged = false;
	private boolean alive, startup;
	public Thread renderthread;
	protected BufferedImage img;
	protected Graphics2D g2d;
	private long CFlastnanotime, FClastnanotime;
	private int FPS;
	private BufferedImage terrain, buffered;
	GameApplet game;
	
	public RenderEngine(GameApplet gameapp){
		startup = true;
		game = gameapp;
		alive = true;
		renderthread = new Thread(this);
		haschanged = true;
		img = new BufferedImage(512, 512, BufferedImage.TYPE_4BYTE_ABGR);
		buffered = new BufferedImage(512, 512, BufferedImage.TYPE_4BYTE_ABGR);
		terrain = new BufferedImage(512,512,BufferedImage.TYPE_4BYTE_ABGR);
		g2d = (Graphics2D) buffered.getGraphics();
		renderthread.start();
	}
	

	public BufferedImage drawTerrain(int pos){
		if(!terrainbuild && game.iomanager.spriteactive){
			Graphics2D G =(Graphics2D) terrain.getGraphics();
			for(int z = 0; z < game.iomanager.sprite.getRows();z++){
				for(int y = 0; y <  game.iomanager.sprite.getCols();y++){
					G.drawImage(game.iomanager.sprite.getImage(pos, false),z * game.iomanager.sprite.getWidth(),y * game.iomanager.sprite.getHeight(),null);
				}
			}
			terrainbuild = true;
			return terrain;
		}else{return terrain;}
	}
	
	
	@Override
	public void run() {
		while(alive){
			if(startup){
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				startup = false;
			}
			if(canframe()){
				clear();
				draw(drawTerrain(0),0,0);
				game.iomanager.entitymanager.update();
				game.appPaint();
				img = buffered;
				
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
		if(dif >= 10000000){
			framecount();
			CFlastnanotime = CFcurrentNano;
			return true;
		} else{
			return false;
		}
	}
	
	

}
