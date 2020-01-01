package logic;

import application.CookieBlock;
import application.StatBlock;
import javafx.application.Platform;

public class GameLoop implements Runnable {

	private static final int SLEEP_TIME = 1000;

	@Override
	public void run() {
		System.out.println("START!!!");
		while (true) {
			try {
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						cookieAutoGen();
						statUpdate();
					}
				});
				Thread.sleep(SLEEP_TIME);
			} catch (InterruptedException e) {
				System.out.println("STOP!!!");
				break;
			}
		}
	}

	private void cookieAutoGen() {
		Player.getInstance().setCurrentCookies(Player.getInstance().getCurrentCookies().add(Player.getInstance().getTotalPerSecond()));
		Player.getInstance().setTotalCookies(Player.getInstance().getTotalCookies().add(Player.getInstance().getTotalPerSecond()));
		CookieBlock.getInstance().setAmount();
	}

	private void statUpdate() {
		StatBlock.getInstance().update();
	}
}
