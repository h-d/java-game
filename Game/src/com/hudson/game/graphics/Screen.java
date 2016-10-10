package com.hudson.game.graphics;

import java.util.Random;

import com.hudson.game.level.tile.Tile;

public class Screen {
	
	public int width;
	public int height;
	public int[] pixels;
	public final int MAP_SIZE = 64;
	public final int MAP_SIZE_MASK = MAP_SIZE - 1;
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
	
	public void render(int xOffset, int yOffset) {
		for (int y = 0; y < height; y++) {
			int yP = y + yOffset;
			if (yP < 0 ||yP >= height) continue;
			for (int x = 0; x < width; x++) {
				int xP = x + xOffset;
				if (xP < 0 || xP >= width) continue;
				pixels[xP + yP * width] = Sprite.grass.pixels[(x&15) + (y&15) * Sprite.grass.SIZE];
			}
		}
	}

	public void renderTile(int xP, int yP, Tile tile) {
		
		for (int y = 0; y < tile.sprite.SIZE; y++) {
			int yA = y + yP;
			for (int x = 0; x < tile.sprite.SIZE; x++) {
				int xA = x + xP;
				if(xA < 0 || xA >= width || yA < 0 || y >= height) break;
				pixels[xA+yA*width] = tile.sprite.pixels[x + y*tile.sprite.SIZE];
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}









