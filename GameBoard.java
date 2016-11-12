package pong;

import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JFrame;

import java.awt.Font;

public class GameBoard {
	private static final int WIDTH = 3;
	private static final int HEIGHT = 10;
	private int left = 0;
	private int right = 0;

	public GameBoard() {
	}
	
	public void pointLeft() {
		left++;
	}
	
	public void pointRight() {
		right++;
	}
	
	public void paint(Graphics2D g) {
		//black background
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 500, 500);
		
		//white mid lines
		g.setColor(Color.WHITE);
		for(int y = 0; y <= 500; y += 20) {
			g.fillRect(250 - (WIDTH / 2), y, WIDTH, HEIGHT);
		}
		
		//left, right score
		Font font = new Font("Arial Black", Font.PLAIN, 40);
		g.setFont(font);
	    g.drawString("" + left, 250 - 115 - 10, 50);
	    g.drawString("" + right, 250 + 115 - 10, 50);
	}
	
	public int getLeft() {
		return left;
	}
	
	public int getRight() {
		return right;
	}
}
