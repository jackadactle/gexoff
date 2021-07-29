package game.gex.gexoff;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

public class GexHandler {
	
	LinkedList<GexObject> object = new LinkedList<GexObject>();
	LinkedList<GexObject> allObjects = new LinkedList<GexObject>();
	
	public void tick() {
		for(int i = 0; i < object.size(); i++) {
			GexObject tobject = object.get(i);
			
			tobject.tick();
		}
	}
	
	public void click(MouseEvent e) {
		for (int i = 0; i < object.size(); i++) {
			GexObject obj = object.get(i);
			if (e.getX() > obj.x && e.getX() < obj.x + obj.width) {
				if (e.getY() > obj.y && e.getY() < obj.y + obj.height) {
					obj.click(e, this);
				}
			}
		}
	}
	
	public void render(Graphics g) {
		for (int i = 0; i < object.size(); i++) {
			GexObject tobject = object.get(i);
			
			tobject.render(g);
		}
	}
	
	public void addObject(GexObject o) {
		this.allObjects.add(o);
	}
	
	public void showObject(GexObject o) {
		this.object.add(o);
	}
	
	public void hideObject(GexObject o) {
		this.object.remove(o);
	}
	
	public void deleteObject(GexObject o) {
		this.object.remove(o);
		this.allObjects.remove(o);
	}
	
}
