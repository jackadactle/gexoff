package game.gex.gexoff.text;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import game.gex.gexoff.Font;
import game.gex.gexoff.GexGame;
import game.gex.gexoff.GexHandler;
import game.gex.gexoff.GexObject;
import game.gex.gexoff.identifiers.GexID;
import game.gex.gexoff.identifiers.GexMenuID;
import game.gex.gexoff.lang.English;

public class HowtoPlayText extends GexObject {
	
	BufferedImage text = Font.text02(English.HOW_TO_PLAY);

	public HowtoPlayText(int x, int y, GexID id, GexMenuID menuID) {
		super(x, y, id, menuID);
		
		width = (int) Math.round(text.getWidth()*1.8);
		height = (int) Math.round(text.getHeight()*1.8);
		
		setX(GexGame.WIDTH / 2 - (int) Math.round(width / 2));
		setY(50);
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(text, x, y, width, height, null);
	}

	@Override
	public void click(MouseEvent e, GexHandler handler) {
		
	}

}
