package game.gex.gexoff.menus;

import java.awt.event.KeyEvent;
import java.util.LinkedList;

import game.gex.gexoff.GexAudio;
import game.gex.gexoff.GexHandler;
import game.gex.gexoff.GexMenu;
import game.gex.gexoff.audio.SoundManager;
import game.gex.gexoff.identifiers.AudioID;
import game.gex.gexoff.identifiers.GexMenuID;

public class MainMenu extends GexMenu {

	public MainMenu(GexMenuID MenuID) {
		super(MenuID);
	}

	@Override
	public void keyPress(KeyEvent e, GexHandler handler) {
		
	}

	@Override
	public void onLoad(LinkedList<GexAudio> allAudio) {
		SoundManager.loopSound(AudioID.MenuLoop);
	}

}
