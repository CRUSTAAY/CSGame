package com.krowcraft.javagame.client;

import java.applet.Applet;
import java.awt.Graphics;


public class GameApplet extends Applet{
	private static final long serialVersionUID = -2131413523377786640L;
	public IOManager iomanager;

	public RenderEngine engine;
	
	public void init() {
		Startup();
		
		Player play = new Player(60,60,16,16,this, true);
		play.setSprite(6, 1, false, this);
		Mob m = new Mob(200,200,16,16, this);
		m.setSprite(2, 1, false, this);
		m.setSpeed(2);
		
		
	}
	
	
	private void Startup() {
		iomanager = new IOManager(this);
		iomanager.initSprite("sprite.png", 32, 32, 16, 16);
		iomanager.initEntityManager();
		engine = new RenderEngine(this);
		iomanager.initKeyManager();
		iomanager.initMouseManager();
		
	}


	public void paint(Graphics g){
		g.drawImage(engine.getImage(), 0, 0, null);
	}
	public void update(Graphics g) {paint(g);}
	
	public void appPaint(){repaint();}
}
