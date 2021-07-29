package game.gex.gexoff;

import java.awt.event.KeyEvent;
import java.util.LinkedList;

import game.gex.gexoff.identifiers.GexMenuID;

public abstract class GexMenu {

	protected GexMenuID MenuID;
	
	public GexMenu(GexMenuID MenuID) {
		this.MenuID = MenuID;
	}
	
	public abstract void keyPress(KeyEvent e, GexHandler handler);
	public abstract void onLoad(LinkedList<GexAudio> allAudio);
	
}
