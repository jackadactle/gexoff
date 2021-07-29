package game.gex.gexoff;

import game.gex.gexoff.identifiers.AudioID;

public abstract class GexAudio {
	
	protected AudioID id;
	
	public GexAudio (AudioID id) {
		this.id = id;
	}
	
	public abstract void init();
	public abstract void start();
	public abstract void stop();
	public abstract void loop();
	public abstract void pause();
	public abstract void restart();
	
	public AudioID getID() {
		return id;
	}
	
}
