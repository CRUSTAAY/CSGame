package com.krowcraft.javagame.client;

public enum Direction {
	UP(1),
	UPRIGHT(2),
	RIGHT(3),
	DOWNRIGHT(4),
	DOWN(5),
	DOWNLEFT(6),
	LEFT(7),
	UPLEFT(8),
	NONE(0);
	public int D;
	private Direction(int z){
		this.D = z;
	}
}
