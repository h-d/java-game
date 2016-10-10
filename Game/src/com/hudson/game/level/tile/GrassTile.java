package com.hudson.game.level.tile;

import com.hudson.game.graphics.Screen;
import com.hudson.game.graphics.Sprite;

public class GrassTile extends Tile{

	public GrassTile(Sprite sprite) {
		super(sprite);
	}

public void render(int x, int y, Screen screen) {
		screen.renderTile(x, y, this);
	}
}
