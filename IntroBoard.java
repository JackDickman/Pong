package pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class IntroBoard extends JPanel{
	private int time;

	public IntroBoard() {
	}

	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 500, 500);

		g.setColor(Color.WHITE);
		Font f1 = new Font("Arial Black", Font.PLAIN, 40);
		Font f2 = new Font("Arial Black", Font.PLAIN, 30);
		Font f3 = new Font("Arial Black", Font.PLAIN, 20);

		g.setFont(f1);
		drawString(g, "TWO PLAYER PONG", 30, 100);

		if(time != 0) {
			g.setFont(f2);
			drawString(g, "" + time, 240, 180);
		}

		g.setFont(f3);
		drawString(g, "       Player 1 use \"w\" and \"s\"\nPlayer 2 use up and down arrows", 75, 250);
	}

	private void drawString(Graphics g, String text, int x, int y) {
		for(String line : text.split("\n")) {
			g.drawString(line, x, y += g.getFontMetrics().getHeight());
		}
	}

	public void setTime(int x) {
		time = x;
	}
}
