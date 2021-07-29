package game.gex.gexoff;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import game.gex.gexoff.identifiers.GexMenuID;

public class GexGame extends Canvas implements Runnable, KeyListener, MouseListener {

	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 1400, HEIGHT = ((WIDTH / 12) * 9) - 92;
	
	private Thread thread;
	private boolean running = false;
	
	public static int fps;
	
	private GexHandler handler;
	private GexMenuHandler menuHandler;

	public GexGame() {
		handler = new GexHandler();
		menuHandler = new GexMenuHandler();
		
		new GexWindow(WIDTH, HEIGHT, "GEXOFF", this);
		this.addKeyListener(this);
		this.addMouseListener(this);
		
		InitAudio.init(handler, menuHandler);
	}
	
	public static void main(String[] args) {
		new GexGame();
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
		this.requestFocus();
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int clamp(int var, int min, int max) {
		if (var >= max)
			return var = max;
		if (var <= min)
			return var = min;
		else return var;
	}

	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
			}
			if(running)
				render();
			fps++;
			
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				fps = 0;
			}
		}
		
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		try {
			BufferedImage loadingScreen = ImageIO.read(new File("Resources/LoadingScreen.png"));
			g.drawImage(loadingScreen, 0, 0, WIDTH, HEIGHT, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		handler.render(g);
		
		g.dispose();
		bs.show();
	}

	private void tick() {
		handler.tick();
	}
	
	private String keyToText(int key) {
		return KeyEvent.getKeyText(key);
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (keyToText(key).equalsIgnoreCase("b")) GexInit.showMenu(GexMenuID.MainMenu, handler);
		
		menuHandler.keyPress(e, handler);
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseClicked(MouseEvent e) {
		handler.click(e);
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {
		
	}
	
}
