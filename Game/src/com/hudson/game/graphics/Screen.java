package com.hudson.game.graphics;

import java.util.Random;

import com.hudson.game.entity.mob.Player;
import com.hudson.game.level.tile.Tile;

public class Screen {
	
	public int width;
	public int height;
	public int[] pixels;
	public final int MAP_SIZE = 64;
	public final int MAP_SIZE_MASK = MAP_SIZE - 1;
	
	public int xOffset, yOffset;
	public int[] tiles = new int[MAP_SIZE * MAP_SIZE];
	
	private Random random = new Random();
	
	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		
		for (int i = 0; i < MAP_SIZE * MAP_SIZE; i++) {
			tiles[i] = random.nextInt(0xffffff);
		}
		
	}
	
	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}
	
	

	public void renderTile(int xP, int yP, Tile tile) {
		xP -= xOffset;
		yP -= yOffset;
		for (int y = 0; y < tile.sprite.SIZE; y++) {
			int yA = y + yP;
			for (int x = 0; x < tile.sprite.SIZE; x++) {
				int xA = x + xP;
				if(xA < -tile.sprite.SIZE || xA >= width || yA < 0 || yA >= height) break;
				if (xA < 0) xA = 0;
				pixels[xA+yA*width] = tile.sprite.pixels[x + y*tile.sprite.SIZE];
			}
		}
	}
	
	public void renderPlayer(int xP, int yP, Sprite sprite, int flip) {
		xP -= xOffset;
		yP -= yOffset;
		for (int y = 0; y < 32; y++) {
			int yA = y + yP;
			int yS = y;
			if (flip == 2 || flip == 3) yS = 31 - y;
			for (int x = 0; x < 32; x++) {
				int xA = x + xP;
				int xS = x;
				if (flip == 1 || flip == 3) xS = 31 - x;
				if(xA < -32 || xA >= width || yA < 0 || yA >= height) break;
				if (xA < 0) xA = 0;
				int color = sprite.pixels[xS + yS * 32];
				if (color != 0xffff00ff)pixels[xA+yA*width] = sprite.pixels[xS+yS*32];
			}
		}
	}
	
	public void setOffset(int xOffset, int yOffset)
	{
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	
	
	
	
	
	
	
}









