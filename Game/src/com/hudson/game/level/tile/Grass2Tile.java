package com.hudson.game.level.tile;

import com.hudson.game.graphics.Screen;
import com.hudson.game.graphics.Sprite;

public class Grass2Tile extends Tile{

	public Grass2Tile(Sprite sprite) {
		super(sprite);
		// TODO Auto-generated constructor stub
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}

}
