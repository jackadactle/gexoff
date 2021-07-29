package game.gex.gexoff.buttons;

import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;

import javax.imageio.ImageIO;

import game.gex.gexoff.GexGame;
import game.gex.gexoff.GexHandler;
import game.gex.gexoff.GexObject;
import game.gex.gexoff.audio.SoundManager;
import game.gex.gexoff.identifiers.AudioID;
import game.gex.gexoff.identifiers.GexID;
import game.gex.gexoff.identifiers.GexMenuID;

public class MoreInfoHTP extends GexObject {
	
	BufferedImage button;

	public MoreInfoHTP(int x, int y, GexID id, GexMenuID menuID) {
		super(x, y, id, menuID);
		
		try {
			button = ImageIO.read(new File("Resources/Buttons/MoreInfoButton.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		setWidth((int) Math.round(button.getWidth() / 1.4));
		setHeight((int) Math.round(button.getHeight() / 1.4));
		
		setX(GexGame.WIDTH / 2 - ((int) width / 2));
		setY(GexGame.HEIGHT / 2 + 150);
		
	}

	@Override
	public void tick() {
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(button, 
			x,
			y,
			width, 
			height, 
			null
		);
	}

	@Override
	public void click(MouseEvent e, GexHandler handler) {
		SoundManager.playSound(AudioID.ButtonClick);
		try {
			URI uri = new URI("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
			Desktop.getDesktop().browse(uri);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

}
