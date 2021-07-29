package game.gex.gexoff;

import game.gex.gexoff.buttons.*;
import game.gex.gexoff.identifiers.*;
import game.gex.gexoff.text.*;
import game.gex.gexoff.sprites.*;

public class GexInit {
	
	public static GexMenuID currentMenu;
	
	public static void init(GexHandler handler) {
		// everything for the main menu
		handler.addObject(new BGGradient(0, 0, GexID.Background, GexMenuID.MainMenu));
		handler.addObject(new Logo(0, 0, GexID.Logo, GexMenuID.MainMenu));
		handler.addObject(new SettingsButton(0, 0, GexID.Button, GexMenuID.MainMenu));
		handler.addObject(new StartButton(0, 0, GexID.Button, GexMenuID.MainMenu));
		handler.addObject(new InventoryButton(0, 0, GexID.Button, GexMenuID.MainMenu));
		handler.addObject(new HowtoPlayButton(0, 0, GexID.Button, GexMenuID.MainMenu));
		
		//everything for the settings menu
		handler.addObject(new BGGradient(0, 0, GexID.Background, GexMenuID.Settings));
		handler.addObject(new Dashboard(0, 0, GexID.Background, GexMenuID.Settings));
		handler.addObject(new ReturntoMainMenu(0, 0, GexID.Button, GexMenuID.Settings));
		handler.addObject(new SettingsText(0, 0, GexID.Text, GexMenuID.Settings));
		
		//everything for how to play menu
		handler.addObject(new BGGradient(0, 0, GexID.Background, GexMenuID.HowtoPlay));
		handler.addObject(new Dashboard(0, 0, GexID.Background, GexMenuID.HowtoPlay));
		handler.addObject(new ReturntoMainMenu(0, 0, GexID.Button, GexMenuID.HowtoPlay));
		handler.addObject(new HowtoPlayText(0, 0, GexID.Text, GexMenuID.HowtoPlay));
		handler.addObject(new HowtoPlayContent(0, 0, GexID.Text, GexMenuID.HowtoPlay));
		handler.addObject(new MoreInfoHTP(0, 0, GexID.Button, GexMenuID.HowtoPlay ));
		
		System.out.println(SettingsManager.getSettings());
		
		showMenu(GexMenuID.MainMenu, handler);
	}
	
	public static void showMenu(GexMenuID MenuID, GexHandler handler) {
		GexMenuHandler.onChange(MenuID, handler);
		currentMenu = MenuID;
		for (int i = 0; i < handler.allObjects.size(); i++) {
			GexObject obj = handler.allObjects.get(i);
			if (obj.MenuID == MenuID) handler.showObject(obj);
			else handler.hideObject(obj);
		}
	}
}