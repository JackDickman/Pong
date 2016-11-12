package pong;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Paddle {
	private static final int WIDTH = 16;
	private static final int HEIGHT = 60;
	int x;
	int y = 250 - (HEIGHT / 2);
	int ya = 0;
	int up;
	int down;
	private Game game;

	public Paddle(Game game) {
		this.game = game;
	}

	public void move() {
		if(y + ya > 0 && y + ya < game.getHeight() - HEIGHT) {
			y = y + ya;
		}
	}

	public void paint(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, WIDTH, HEIGHT);
	}

	public void keyReleased(KeyEvent e) {
		ya = 0;
	}
	
	public void setUp(int u) {
		up = u;
	}
	
	public void setDown(int d) {
		down = d;
	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == up) {
			ya = -3;
		} else if(e.getKeyCode() == down) {
			ya = 3;
		}
	}

	public Rectangle getBoundsLeft() {
		return new Rectangle(x + WIDTH, y, 1, HEIGHT);
	}
	
	public Rectangle getBoundsRight() {
		return new Rectangle(x, y, 1, HEIGHT);
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getY() {
		return y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getHeight() {
		return HEIGHT;
	}
	
	public int getWidth() {
		return WIDTH;
	}
}