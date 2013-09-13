package com.krowcraft.javagame.client;

public abstract class util {
	public static void print(Object s){
		System.out.println(s);
	}
	
	public static long getnano(){
		return System.nanoTime();
	}
	
	public static long getMicro(){
		return System.currentTimeMillis();
	}

	
}
