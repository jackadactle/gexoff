package game.gex.gexoff;

import java.util.LinkedList;

import game.gex.gexoff.audio.ButtonClick;
import game.gex.gexoff.audio.MenuLoop;
import game.gex.gexoff.identifiers.AudioID;

public class InitAudio {
	
	public static LinkedList<GexAudio> allAudio = new LinkedList<GexAudio>();
	
	public static void init(GexHandler handler, GexMenuHandler menuHandler) {
		// defining everything
		MenuLoop ml = new MenuLoop(AudioID.MenuLoop);
		ButtonClick bc = new ButtonClick(AudioID.ButtonClick);
		
		//adding everything to the audio list
		allAudio.add(ml);
		allAudio.add(bc);
		
		//initializing everything
		ml.init();
		bc.init();
		
		// starting necessary audio files
		ml.loop();
		
		Font.init();
		GexInit.init(handler);
		menuHandler.init();
	}
	
}
