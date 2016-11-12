package pong;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {
	private static final int SIZE = 15;
	int x = 250;
	int y = 250;
	int xa = 3;
	int ya = 0;
	private Game game;

	public Ball(Game game) {
		this.game = game;
	}

	void move() {
		int c;

		if(y + ya < 0 || y + ya > game.getHeight() - SIZE) { //if hits top or bottom
			ya = ya * -1;
		} else if(x + xa < 0) { //if hits left
			game.board.pointRight();
			reset("right");
		} else if(x + xa > game.getWidth() - SIZE) { //if hits right
			game.board.pointLeft();
			reset("left");
		} else if((c = collision()) != 666) { //if hits a paddle
			ya = c;
			xa = xa * -1;
		}

		x += xa;
		y += ya;
	}

	public void paint(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, SIZE, SIZE);
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, SIZE, SIZE);
	}

	public int collision() {
		if(!game.p1.getBoundsLeft().intersects(getBounds()) && !game.p2.getBoundsRight().intersects(getBounds())) {
			return 666;
		} else if(game.p1.getBoundsLeft().intersects(getBounds())) {
			int n = game.p1.getY();
			int h = game.p1.getHeight();
			
			if(y >= n && y < n + (h / 5)) {
				return -4;
			} else if(y < n + (2 * (h / 5))) {
				return -2;
			} else if(y < n + (3 * (h / 5))) {
				return 0;
			} else if(y < n + (4 * (h / 5))) {
				return 2;
			} else if(y < n + h) {
				return 4;
			}
		} else if(game.p2.getBoundsRight().intersects(getBounds())) {
			int m = game.p2.getY();
			int o = game.p2.getHeight();
			
			if(y >= m && y < m + (o / 5)) {
				return -4;
			} else if(y < m + (2 * (o / 5))) {
				return -2;
			} else if(y < m + (3 * (o / 5))) {
				return 0;
			} else if(y < m + (4 * (o / 5))) {
				return 2;
			} else if(y < m + o) {
				return 4;
			}
		}
		return 666;
	}

	public void reset(String s) {
		if(s.equals("left")) {
			x = 250;
			y = 250;
			xa = -3;
			ya = 0;
		} else if(s.equals("right")) {
			x = 250;
			y = 250;
			xa = 3;
			ya = 0;
		}
	}
}
