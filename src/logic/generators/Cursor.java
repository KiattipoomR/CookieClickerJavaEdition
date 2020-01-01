package logic.generators;

import java.math.BigDecimal;

import logic.PathStorage;
import logic.Player;
import logic.generators.base.Generator;

public class Cursor extends Generator {

	private static final Cursor INSTANCE = new Cursor();
	
	private Cursor() {
		super("Cursor", "15", "0.1", PathStorage.CURSOR_PATH);
	}
	
	public void upgrade() {
		Player.getInstance().setPerClick(Player.getInstance().getPerClick().multiply(UPGRADE_MULTIPLIER));
		Player.getInstance().setTotalPerSecond(Player.getInstance().getTotalPerSecond().add(totalPerSecond));
		currentPerSecond = currentPerSecond.multiply(UPGRADE_MULTIPLIER);
		totalPerSecond = currentPerSecond.multiply(new BigDecimal(amountOwned));
	}
	
	public static Cursor getInstance() {
		return INSTANCE;
	}
}
