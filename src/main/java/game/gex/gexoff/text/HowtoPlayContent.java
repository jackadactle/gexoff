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

public class HowtoPlayContent extends GexObject {

	public HowtoPlayContent(int x, int y, GexID id, GexMenuID menuID) {
		super(x, y, id, menuID);
	}

	@Override
	public void tick() {
	}

	@Override
	public void render(Graphics g) {
		BufferedImage line1 = Font.text01(English.HOW_TO_PLAY_LN1);
		BufferedImage line2 = Font.text01(English.HOW_TO_PLAY_LN2);
		BufferedImage line3 = Font.text01(English.HOW_TO_PLAY_LN3);
		BufferedImage line4 = Font.text01(English.HOW_TO_PLAY_LN4);
		BufferedImage moreInfo = Font.text01(English.MORE_INFO_HTP);
		
		g.drawImage(
			line1, 
			70, 
			198, 
			(int) Math.round(line1.getWidth() / 3.3), 
			(int) Math.round(line1.getHeight() / 3.3), 
			null
		);
		
		g.drawImage(line2,
			70,
			((int) Math.round(line1.getHeight() / 3.3) + 198) + 10,
			(int) Math.round(line2.getWidth() / 3.3), 
			(int) Math.round(line2.getHeight() / 3.3), 
			null
		);
		
		g.drawImage(line3,
			70,
			((int) Math.round(line1.getHeight() / 3.3) + (198 + (int) Math.round(line2.getHeight() / 3.3) + 10)) + 10,
			(int) Math.round(line2.getWidth() / 3.3), 
			(int) Math.round(line2.getHeight() / 3.3), 
			null
		);
		
		g.drawImage(line4,
			70,
			((int) Math.round(line1.getHeight() / 3.3) + (198 + ((int) Math.round(line2.getHeight() / 3.3) * 2) + 20)) + 10,
			(int) Math.round(line2.getWidth() / 3.3), 
			(int) Math.round(line2.getHeight() / 3.3), 
			null
		);
		
		g.drawImage(moreInfo, 
			GexGame.WIDTH / 2 - (((int) Math.round(moreInfo.getWidth() / 2.9)) / 2),
			GexGame.HEIGHT / 2 + 100,
			(int) Math.round(moreInfo.getWidth() / 2.9), 
			(int) Math.round(moreInfo.getHeight() / 2.9), 
			null
		);
	}

	@Override
	public void click(MouseEvent e, GexHandler handler) {
	}

}
