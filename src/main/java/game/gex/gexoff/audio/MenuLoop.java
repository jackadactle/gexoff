package game.gex.gexoff.audio;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import game.gex.gexoff.GexAudio;
import game.gex.gexoff.identifiers.AudioID;

public class MenuLoop extends GexAudio {
	
	public MenuLoop(AudioID id) {
		super(id);
	}

	Clip audio;

	@Override
	public void start() {
		audio.start();
	}

	@Override
	public void stop() {
		audio.stop();
	}

	@Override
	public void loop() {
		audio.loop(Clip.LOOP_CONTINUOUSLY);
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void init() {
		try {
			File musicPath = new File("Resources/Audio/menuLoop.wav");
			if (musicPath.exists()) {
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
				Clip f = AudioSystem.getClip();
				f.open(audioInput);
				audio = f;
			} else System.out.println("missing audio file");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void restart() {
		audio.setFramePosition(0);
	}

}
