package com.krowcraft.javagame.client;

import java.applet.Applet;
import java.awt.Graphics;


public class GameApplet extends Applet{
	private static final long serialVersionUID = -2131413523377786640L;
	public IOManager iomanager;
	public Player playerz;
	public Mob mob;
	public RenderEngine engine;
	
	public void init() {
		
		iomanager = new IOManager(this);
		iomanager.initEntityManager();
		engine = new RenderEngine(this);
		iomanager.initSprite("sprite.png", 32, 32, 16, 16);
		
		
		
		mob = new Mob(30, 20, 16, 16, this);
		mob.setSprite(5, 1, false, this);
		mob.moveto(40, 62);
		
		
		

		
		
//		for(Mob arraymob:mobs){
//			engine.draw(arraymob.getSprite(), arraymob.getX(), arraymob.getY());
//		}
		
		
//		engine.draw(mob.getSprite(), mob.getX(), mob.getY());
		
	}
	
	
	public void paint(Graphics g){
		g.drawImage(engine.getImage(), 0, 0, null);
	}
	public void update(Graphics g) {paint(g);}
	
	public void appPaint(){repaint();}
}
