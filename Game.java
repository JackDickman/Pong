package pong;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game extends JPanel{
	Paddle p1 = new Paddle(this);
	Paddle p2 = new Paddle(this);
	Ball ball = new Ball(this);
	GameBoard board = new GameBoard();
	private static final int SCORE = 5;
	
	public Game() {
		addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}

			public void keyReleased(KeyEvent e) {
				p1.keyReleased(e);
				p2.keyReleased(e);
			}

			public void keyPressed(KeyEvent e) {
				p1.keyPressed(e);
				p2.keyPressed(e);
			}
		});
		
		setFocusable(true);
		
		p1.setX(50);
		p1.setUp(KeyEvent.VK_W);
		p1.setDown(KeyEvent.VK_S);
		
		p2.setX(450 - p2.getWidth());
		p2.setUp(KeyEvent.VK_UP);
		p2.setDown(KeyEvent.VK_DOWN);
	}
	
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		board.paint(g2d);
		ball.paint(g2d);
		p1.paint(g2d);
		p2.paint(g2d);
	}
	
	public void move() {
		p1.move();
		p2.move();
		ball.move();
	}
	
	public int getScore() {
		return SCORE;
	}
	
	public void gameOver() {
		String s = "";
		if(board.getLeft() == SCORE) {
			s = "Player 1 Wins!";
		} else if(board.getRight() == SCORE) {
			s = "Player 2 Wins!";
		}
		JOptionPane.showMessageDialog(this, s, "Game Over", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}
}
