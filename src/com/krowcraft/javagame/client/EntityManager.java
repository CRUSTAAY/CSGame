package com.krowcraft.javagame.client;

import java.util.ArrayList;
import java.util.Iterator;


public class EntityManager {
	private int playerID, attackID,mobID;
	private GameApplet game;
	private ArrayList<Mob> mobarray;
	private ArrayList<Player> playerarray;
	private ArrayList<RangedAttack> rangedattackarray;
	private MobManager mobmanager;
	
	public EntityManager(GameApplet gameapplet){
		game = gameapplet;
		mobarray = new ArrayList<Mob>();
		playerarray = new ArrayList<Player>();
		rangedattackarray = new ArrayList<RangedAttack>();
	}
	
	public void addMob(Mob m){
		mobarray.add(m.getID(), m);
	}
	public void addPlayer(Player p){
		playerarray.add(p.getID(), p);
	}
	public void addRangedAttack(RangedAttack a){
		rangedattackarray.add(a.getID(), a);
	}
	public void removeRangedAttack(int id) {
		rangedattackarray.remove(id);
	}
	public ArrayList<Player> getPlayerArray(){
		return playerarray;
	}
	public void initMobManager(){mobmanager = new MobManager();}
	
	public void update(){
		util.print(rangedattackarray.size());
			for(Mob m:mobarray){
				try{
					m.update();
				} catch (Exception e){}
			}
		for(Player p:playerarray){
			try{
				p.update();
			} catch (Exception e){
				
			}
		}
		for(Iterator<Player> e = playerarray.iterator();e.hasNext();){
			Player a = e.next();
			a.update();
				if(a.Die()){
				e.remove();	
				}
		}
		
		
		
			for(Iterator<RangedAttack> e = rangedattackarray.iterator();e.hasNext();){
				RangedAttack a = e.next();
				a.update();
				
					if(a.Die()){
					e.remove();	
					}
			}
		ImageDraw();
	}
	
	public void ImageDraw(){
		for(Mob m: mobarray){
			game.engine.draw(m.getSprite(),(int) m.getX(),(int) m.getY());
		}
		for(Player p: playerarray){
			game.engine.draw(p.getSprite(),(int) p.getX(),(int) p.getY());
		}
		for(RangedAttack a:rangedattackarray){
			game.engine.draw(a.getSprite(),(int) a.getX(),(int) a.getY());
		}
		
	}

	public int getMobID() {
		int mob = mobID;
		mobID++;
		return mob;
	}
	public int getPlayerID() {
		int pl = playerID;
		playerID++;
		return pl;
	}
	public int getRangedAttackID() {
		int at = attackID;
		attackID++;
		return at;
	}



	
	


}