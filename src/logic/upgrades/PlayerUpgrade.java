package logic.upgrades;

import java.math.BigDecimal;

import logic.PathStorage;
import logic.Player;
import logic.exceptions.PurchaseFailedException;
import logic.upgrades.base.Upgrade;

public class PlayerUpgrade extends Upgrade {

	private static final PlayerUpgrade INSTANCE = new PlayerUpgrade();
	
	private BigDecimal[] handmadeCondition;

	private PlayerUpgrade() {
		super("Plastic Mouse", null, new BigDecimal[] { new BigDecimal("5000"), new BigDecimal("50000"),
				new BigDecimal("500000"), new BigDecimal("5000000"), new BigDecimal("50000000") },
				PathStorage.PLAYERUPGRADE_PATH);
		this.handmadeCondition = new BigDecimal[] { new BigDecimal("1000"), new BigDecimal("5000"),
				new BigDecimal("10000"), new BigDecimal("50000"), new BigDecimal("100000") };
	}

	public void buy() throws PurchaseFailedException {
		if (upgradeLevel >= handmadeCondition.length)
			throw new PurchaseFailedException(this, 0);
		else if (Player.getInstance().getHandmadeCookies().compareTo(handmadeCondition[upgradeLevel]) == -1)
			throw new PurchaseFailedException(this, 3);

		if (Player.getInstance().getCurrentCookies().compareTo(upgradePrice[upgradeLevel]) == -1)
			throw new PurchaseFailedException(this, 2);
		Player.getInstance().setCurrentCookies(Player.getInstance().getCurrentCookies().subtract(upgradePrice[upgradeLevel]));
		Player.getInstance().upgrade();
		upgradeLevel++;
	}
	
	public static PlayerUpgrade getInstance() {
		return INSTANCE;
	}

	public BigDecimal getHandmadeCondition() {
		BigDecimal amount = BigDecimal.ZERO;
		if (upgradeLevel < handmadeCondition.length)
			amount = handmadeCondition[upgradeLevel];
		return amount;
	}
}
