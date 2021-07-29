package game.gex.gexoff.buttons;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import game.gex.gexoff.GexGame;
import game.gex.gexoff.GexHandler;
import game.gex.gexoff.GexObject;
import game.gex.gexoff.audio.SoundManager;
import game.gex.gexoff.identifiers.AudioID;
import game.gex.gexoff.identifiers.GexID;
import game.gex.gexoff.identifiers.GexMenuID;

public class InventoryButton extends GexObject {
	
	int lx;
	int ly;

	public InventoryButton(int x, int y, GexID id, GexMenuID menuID) {
		super(x, y, id, menuID);
		width = (int) Math.round(182*2.1);
		height = (int) Math.round(34*2.1);
		
		lx = (GexGame.WIDTH / 2) + 20;
		ly = ((GexGame.HEIGHT / 2) - height) + 75;
		
		setX(lx);
		setY(ly);
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		try {
			BufferedImage button = ImageIO.read(new File("Resources/Buttons/InventoryButton.png"));
			g.drawImage(
				button, 
				lx, 
				ly, 
				width, 
				height,
				null
			);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void click(MouseEvent e, GexHandler handler) {
		SoundManager.playSound(AudioID.ButtonClick);
	}

}
