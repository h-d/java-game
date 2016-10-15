package com.hudson.game.entity.mob;

import com.hudson.game.entity.Entity;
import com.hudson.game.graphics.Sprite;

public abstract class Mob extends Entity{
	
	protected Sprite sprite;
	protected int dir = 0;
	protected boolean moving = false;
	
	public void move(int xA, int yA) {
		if(xA > 0) dir = 1;
		if(xA < 0) dir = 3;
		if(yA > 0) dir = 2;
		if(yA < 0) dir = 0;
		
		if (!collision()) {
			x += xA;
			y += yA;
		}
	}
	
	public void update() {
		
	}
	
	private boolean collision() {
		return false;
	}
	
	public void render() {
		
	}
	
}
