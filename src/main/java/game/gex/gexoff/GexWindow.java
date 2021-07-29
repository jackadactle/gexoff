package game.gex.gexoff;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GexWindow extends Canvas {

	private static final long serialVersionUID = 1L;
	
	public JFrame gexwindow;
	
	public GexWindow(int width, int height, String title, GexGame game) {
		gexwindow = new JFrame(title);
		
		ImageIcon icon = new ImageIcon("Resources/GameIcon.png");
		
		gexwindow.setSize(new Dimension(width, height));
		gexwindow.setResizable(false);
		gexwindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gexwindow.setLocationRelativeTo(null);
		gexwindow.add(game);
		gexwindow.setIconImage(icon.getImage());
		gexwindow.setVisible(true);
		
		game.start();
	}

}
