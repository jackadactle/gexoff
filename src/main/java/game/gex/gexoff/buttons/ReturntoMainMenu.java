package game.gex.gexoff.buttons;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import game.gex.gexoff.GexHandler;
import game.gex.gexoff.GexInit;
import game.gex.gexoff.GexObject;
import game.gex.gexoff.audio.SoundManager;
import game.gex.gexoff.identifiers.AudioID;
import game.gex.gexoff.identifiers.GexID;
import game.gex.gexoff.identifiers.GexMenuID;

public class ReturntoMainMenu extends GexObject {
	
	int lx = 32;
	int ly = 32;

	public ReturntoMainMenu(int x, int y, GexID id, GexMenuID menuID) {
		super(x, y, id, menuID);
		
		width = (int) Math.round(128 * 0.7);
		height = (int) Math.round(128 * 0.7);
		
		setX(lx);
		setY(ly);
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		try {
			BufferedImage x = ImageIO.read(new File("Resources/Buttons/XButton.png"));
			g.drawImage(x, lx, ly, width, height, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void click(MouseEvent e, GexHandler handler) {
		GexInit.showMenu(GexMenuID.MainMenu, handler);
		SoundManager.playSound(AudioID.ButtonClick);
	}

}
