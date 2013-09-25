package com.krowcraft.javagame.client;


import com.krowcraft.javagame.client.util;

import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;

public class Sprite{
	@SuppressWarnings("unused")
	private int width, height, rows, cols;
	private boolean success = true;
	private BufferedImage[] sprite;
	
	
	public Sprite(String file, int col, int row, int w, int h){
		width = w;
		height = h;
		rows = row;
		cols = col;
		BufferedImage image = new BufferedImage(col * h, row * w, BufferedImage.TYPE_4BYTE_ABGR);
		image = loadImage(image, file);
		
		sprite = new BufferedImage[col * row];
		giveChop(image, col, row, w, h);
		util.print("Sprite ready");
	}

	
	//chop up into array of images
	private void giveChop(BufferedImage image, int col, int row, int w, int h) {
		
		for(int a = 0; a < row; a++){
			
			for(int b = 0; b < col; b++){
				
				sprite[(b * col) + a] = image.getSubimage(a * w, b * h, w, h);
				
			}
			
		}
		
	}
	
	
	//Load image
	private BufferedImage loadImage(BufferedImage image, String file) {
		
		boolean loop = true;
		int retry = 0;
		
		
		while(loop){
			try {
				image = ImageIO.read(new File(file)); //read file
			} catch (IOException e) {
				e.printStackTrace(); //printout error
				success = false;	 // boolean to indicate failed
			} finally {
				if (!success){ // keep trying to get file
					loop = true;
					retry++;
					if(retry == 5){ //give up after 5 attempts
						loop = false;
					}
					
				} else {
					loop = false; // great success
				}
			}
		}
		return image;
	}
	private BufferedImage makeTrans(BufferedImage output) {
		for(int z = 0; z < output.getHeight(); z++){
			for(int x = 0; x < output.getWidth(); x++){
				int col = output.getRGB(x, z);
				if(col == -65281 || col == -8454017){
					output.setRGB(x, z, 0);
				}
			}
		}
		return output;
	}
	
	public BufferedImage getImage(int pos, boolean trans){
		BufferedImage output = sprite[pos];
		if(trans){
			output = makeTrans(output);
		}
		return output;
	}
	
	
	public boolean status() {return success;}


	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}

	public int getRows(){
		return rows;
	}
	
	public int getCols(){
		return rows;
	}

	
	
	
}
