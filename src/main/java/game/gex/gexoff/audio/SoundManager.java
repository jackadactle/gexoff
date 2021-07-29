package game.gex.gexoff.audio;

import game.gex.gexoff.GexAudio;
import game.gex.gexoff.InitAudio;
import game.gex.gexoff.identifiers.AudioID;

public class SoundManager {

	public static void playSound(AudioID id) {
		for (int i = 0; i < InitAudio.allAudio.size(); i++) {
			GexAudio a = InitAudio.allAudio.get(i);
			if (a.getID() == id) {
				a.start();
				a.restart();
			}
		}
	}
	
	public static void loopSound(AudioID id) {
		for (int i = 0; i < InitAudio.allAudio.size(); i++) {
			GexAudio a = InitAudio.allAudio.get(i);
			if (a.getID() == id) {
				a.loop();
			}
		}
	}
	
	public static void stopSound(AudioID id) {
		for (int i = 0; i < InitAudio.allAudio.size(); i++) {
			GexAudio a = InitAudio.allAudio.get(i);
			if (a.getID() == id) {
				a.stop();
				a.restart();
			}
		}
	}
	
	public static void resetSound(AudioID id) {
		for (int i = 0; i < InitAudio.allAudio.size(); i++) {
			GexAudio a = InitAudio.allAudio.get(i);
			if (a.getID() == id) {
				a.restart();
			}
		}
	}
	
}
