package game.gex.gexoff;

import java.awt.event.KeyEvent;
import java.util.LinkedList;

import game.gex.gexoff.identifiers.GexMenuID;
import game.gex.gexoff.menus.*;

public class GexMenuHandler {
	
	static LinkedList<GexMenu> all = new LinkedList<GexMenu>();
	
	public void init() {
		all.add(new MainMenu(GexMenuID.MainMenu));
		all.add(new Settings(GexMenuID.Settings));
		all.add(new GameMenu(GexMenuID.Game));
		all.add(new HowtoPlayMenu(GexMenuID.HowtoPlay));
	}
	
	public void keyPress(KeyEvent e, GexHandler handler) {
		for (int i = 0; i < all.size(); i++) {
			GexMenu menu = all.get(i);
			if (menu.MenuID == GexInit.currentMenu) menu.keyPress(e, handler);
		}
	}
	
	public static void onChange(GexMenuID newmenu, GexHandler handler) {
		for (int i = 0; i < all.size(); i++) {
			GexMenu obj = all.get(i);
			if (obj.MenuID == newmenu) obj.onLoad(InitAudio.allAudio);
		}
	}
	
}
