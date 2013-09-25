package com.krowcraft.javagame.client;

public class IOManager extends GameApplet{
	
	private static final long serialVersionUID = -8159387095461864339L;
	public boolean spriteactive, keymanageractive, mousemanageractive, entitymanageractive;
	public Sprite sprite;
	public KeyManager keymanager;
	public MouseManager mousemanager;
	public EntityManager entitymanager;
	public GameApplet game;
	
	public IOManager(GameApplet gameapp) {
		game = gameapp;
		spriteactive = false;
		keymanageractive = false;
	}
	
	//Startup Sprite Object
	public void initSprite(String loc, int row, int col, int w, int h){
		sprite = new Sprite(loc, row, col, w, h);
		spriteactive = sprite.status();
	}public boolean spriteStatus(){return spriteactive;}
	
	//Startup Key Listener
	public void initKeyManager(){
		keymanager = new KeyManager(game);
		keymanageractive = true;
		addKeyListener(keymanager);
	}public boolean keymanagerStatus(){return keymanageractive;}
	
	//Startup Entity Manager
	public void initEntityManager(){
		entitymanager = new EntityManager(game);
		entitymanageractive = true;
	}public boolean EntityManagerStatus(){return entitymanageractive;}
	
	//Startup Mouse Listener
	public void initMouseManager(){
		mousemanager = new MouseManager(game);
		mousemanageractive = true;
	}public boolean MouseManagerStatus(){return mousemanageractive;}
	
}
