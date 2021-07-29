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
import game.gex.gexoff.identifiers.*;

public class Logo extends GexObject {

	public Logo(int x, int y, GexID id, GexMenuID MenuID) {
		super(x, y, id, MenuID);
		width = (int) Math.round((303 * 3) * 1.2);
		height = (int) Math.round((68 * 3) * 1.2);
	}

	public void tick() {
	}

	public void render(Graphics g) {
		try {
			BufferedImage logo = ImageIO.read(new File("Resources/GexoffLogo.png"));
			g.drawImage(logo, (GexGame.WIDTH / 2) - (width / 2), (GexGame.HEIGHT / 4) - (height / 2), width, height, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void click(MouseEvent e, GexHandler handler) {
		// TODO Auto-generated method stub
		
	}

}
