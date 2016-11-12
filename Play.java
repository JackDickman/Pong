package pong;

import javax.swing.JFrame;

public class Play {
	public static void main(String[] args) throws InterruptedException {
		final int TIMER = 5; //count down from value to 1

		JFrame frame = new JFrame("Pong");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//INTRO------------------------------------------------
		IntroBoard intro = new IntroBoard();
		frame.add(intro);
		frame.setVisible(true);

		timer(TIMER, intro);
		
		//GAME-------------------------------------------------
		Game game = new Game();
		frame.add(game);
		frame.setVisible(true);

		while(game.board.getLeft() < game.getScore() && game.board.getRight() < game.getScore()) {
			game.move();
			game.repaint();
			Thread.sleep(10);
		}

		game.gameOver();
	}
	
	public static void timer(int x, IntroBoard i) {
		int list[] = new int[x];
		for(int j = 0; j < x; j++) {
			list[j] = 666;
		}

		long start = System.currentTimeMillis();

		for(long time = (System.currentTimeMillis() - start) / 1000; time <= x + 1; time = (System.currentTimeMillis() - start) / 1000) {
			long t = x + 2 - time;
			if(t >= 1 && t <= x && time % 1 == 0 && list[(int)time - 2] == 666) {
				list[(int)time - 2] = (int)time;
				i.setTime((int)t);
			}
			i.repaint();
		}
	}
}