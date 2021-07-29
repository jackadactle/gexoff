package game.gex.gexoff.menus;

import java.awt.event.KeyEvent;
import java.util.LinkedList;

import game.gex.gexoff.GexAudio;
import game.gex.gexoff.GexHandler;
import game.gex.gexoff.GexMenu;
import game.gex.gexoff.audio.SoundManager;
import game.gex.gexoff.identifiers.AudioID;
import game.gex.gexoff.identifiers.GexMenuID;

public class HowtoPlayMenu extends GexMenu {

	public HowtoPlayMenu(GexMenuID MenuID) {
		super(MenuID);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void keyPress(KeyEvent e, GexHandler handler) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onLoad(LinkedList<GexAudio> allAudio) {
		SoundManager.stopSound(AudioID.MenuLoop);
	}

}
