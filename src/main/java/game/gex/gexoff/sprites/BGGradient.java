package game.gex.gexoff.sprites;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import game.gex.gexoff.GexGame;
import game.gex.gexoff.GexHandler;
import game.gex.gexoff.GexObject;
import game.gex.gexoff.identifiers.GexID;
import game.gex.gexoff.identifiers.GexMenuID;

public class BGGradient extends GexObject {

	public BGGradient(int x, int y, GexID id, GexMenuID menuID) {
		super(x, y, id, menuID);
	}

	@Override
	public void tick() {
	}

	@Override
	public void render(Graphics g) {
		try {
			BufferedImage gradient = ImageIO.read(new File("Resources/MenuGradient.png"));
			g.drawImage(gradient, 0, 0, GexGame.WIDTH, GexGame.HEIGHT, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void click(MouseEvent e, GexHandler handler) {
		// TODO Auto-generated method stub
		
	}

}
