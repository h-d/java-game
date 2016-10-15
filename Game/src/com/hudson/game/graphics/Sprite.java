package com.hudson.game.graphics;

public class Sprite {

	public final int SIZE;
	private int x, y;
	public int[] pixels;
	private Spritesheet sheet;
	
	public static Sprite grass = new Sprite(16, 0, 0, Spritesheet.tiles);
	public static Sprite grass2 = new Sprite(16,1,0, Spritesheet.tiles);
	public static Sprite rock = new Sprite(16,2,0, Spritesheet.tiles);
	public static Sprite voidSprite = new Sprite(16, 0x1B87E0);

	
	public static Sprite player_up = new Sprite(32,0,5,Spritesheet.tiles);
	public static Sprite player_down = new Sprite(32,2,5,Spritesheet.tiles);
	public static Sprite player_side = new Sprite(32,1,5,Spritesheet.tiles);
	
	public static Sprite player_up_1 = new Sprite(32,0,6,Spritesheet.tiles);
	public static Sprite player_up_2 = new Sprite(32,0,7,Spritesheet.tiles);
	
	public static Sprite player_down_1 = new Sprite(32,2,6,Spritesheet.tiles);
	public static Sprite player_down_2 = new Sprite(32,2,7,Spritesheet.tiles);
	
	public static Sprite player_side_1 = new Sprite(32,1,6,Spritesheet.tiles);
	public static Sprite player_side_2 = new Sprite(32,1,7,Spritesheet.tiles);	
	public Sprite(int size, int x, int y, Spritesheet sheet) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
	}
	
	public Sprite(int size, int color)
	{
		SIZE = size;
		pixels = new int[SIZE*SIZE];
		setColor(color);
	}
	
	public void setColor(int color) {
		for (int i = 0; i < SIZE*SIZE; i++)
		{
			pixels[i] = color;
		}
	}
	
	private void load() {
		for(int y = 0; y < SIZE; y++) {
			for(int x = 0; x < SIZE; x++) {
				pixels[x+y*SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
			}
		}
	}
}
