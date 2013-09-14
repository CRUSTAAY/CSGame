package com.krowcraft.javagame.client;

import java.util.ArrayList;


public class EntityManager {
	private GameApplet game;
	private ArrayList<Mob> mobarray;
	private ArrayList<Player> playerarray;
	//private ArrayList<RangedAttack> rangedattackentity; TODO:
	
	public EntityManager(GameApplet gameapplet){
		game = gameapplet;
		mobarray = new ArrayList<Mob>();
		playerarray = new ArrayList<Player>();
		//rangedattackentity = new Arraylist<RangedAttack>();
	}
	
	public void addMob(Mob m){
		mobarray.add(m);
	}
	public void addPlayer(Player p){
		playerarray.add(p);
	}
	
	public void updateMob(){
		for(Mob m:mobarray){
			m.update();
			ImageMob();
		}
	}

	public void updatePlayer(){
		for(Player p:playerarray){
			p.update();
		}
	}
	
	public void ImageMob(){
		for(Mob m: mobarray){
			game.engine.draw(m.getSprite(),(int) m.getX(),(int) m.getY());
		}
		
	}


}