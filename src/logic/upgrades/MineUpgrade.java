package logic.upgrades;

import java.math.BigDecimal;

import logic.PathStorage;
import logic.generators.Mine;
import logic.upgrades.base.Upgrade;

public class MineUpgrade extends Upgrade {

	private static final MineUpgrade INSTANCE = new MineUpgrade();

	private MineUpgrade() {
		super("Super Drill", Mine.getInstance(), new BigDecimal[] { new BigDecimal("120000"), new BigDecimal("600000"),
				new BigDecimal("1200000"), new BigDecimal("6000000"), new BigDecimal("12000000") },
				PathStorage.MINEUPGRADE_PATH);
	}

	public static MineUpgrade getInstance() {
		return INSTANCE;
	}
}
