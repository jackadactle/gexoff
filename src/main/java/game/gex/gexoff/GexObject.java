package game.gex.gexoff;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

import game.gex.gexoff.identifiers.GexID;
import game.gex.gexoff.identifiers.GexMenuID;

public abstract class GexObject {
	
	protected int x, y;
	protected GexID id;
	protected GexMenuID MenuID;
	protected int velX, velY;
	protected int width, height;
	
	public GexObject(int x, int y, GexID id, GexMenuID menuID) {
		this.x = x;
		this.y = y;
		this.id = id;
		this.MenuID = menuID;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract void click(MouseEvent e, GexHandler handler);
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getX() {
		return x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getY() {
		return y;
	}
	
	public void setID(GexID id) {
		this.id = id;
	}
	
	public GexID getID() {
		return id;
	}
	
	public void setVelX(int velX) {
		this.velX = velX;
	}
	
	public int getVelX() {
		return velX;
	}
	
	public void setVelY(int velY) {
		this.velY = velY;
	}
	
	public int getVelY() {
		return velY;
	}
	
	public void setWidth(int w) {
		this.width = w;
	}
	
	public void setHeight(int h) {
		this.height = h;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
}
