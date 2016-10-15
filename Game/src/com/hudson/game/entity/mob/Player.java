package com.hudson.game.entity.mob;

import com.hudson.game.graphics.Screen;
import com.hudson.game.graphics.Sprite;
import com.hudson.game.input.Keyboard;

public class Player extends Mob{
	
	private Keyboard input;
	private Sprite sprite;
	private int anim = 0;
	boolean walking = false;
	
	public Player(Keyboard input) {
		this.input = input;
	}
	
	public Player(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
		sprite = Sprite.player_up;
	}
	
	public void update() {
		int xA = 0, yA = 0;
		if (anim < 7500) anim += 1;
		else anim = 0;
		if(input.up) yA--;
		if(input.down) yA++;
		if(input.left) xA--;
		if(input.right) xA++;
		
		if(xA != 0 || yA != 0) {
			move(xA,yA);
			walking = true;
		} else {
			walking = false;
		}
	}
	
	public void render(Screen screen) {
		int flip = 0;
		if(dir == 0){
			sprite = Sprite.player_up;
			if(walking) {
				if (anim % 20 > 10)
				{
					sprite = Sprite.player_up_1;
				} else {
					sprite = Sprite.player_up_2;
				}
			}
		}
		if(dir == 1){
			sprite = Sprite.player_side;
			if(walking) {
				if (anim % 20 > 10)
				{
					sprite = Sprite.player_side_1;
				} else {
					sprite = Sprite.player_side_2;
				}
			}
		}
		if(dir == 2) {
			sprite = Sprite.player_down;
			if(walking) {
				if (anim % 20 > 10)
				{
					sprite = Sprite.player_down_1;
				} else {
					sprite = Sprite.player_down_2;
				}
			}
		}
		if(dir == 3) {
			sprite = Sprite.player_side;
			if(walking) {
				if (anim % 20 > 10)
				{
					sprite = Sprite.player_side_1;
				} else {
					sprite = Sprite.player_side_2;
				}
			}
			flip = 1;
		}
		screen.renderPlayer(x-16, y-16, sprite, flip);
	}
}
