package logic.upgrades;

import java.math.BigDecimal;

import logic.PathStorage;
import logic.generators.Farm;
import logic.upgrades.base.Upgrade;

public class FarmUpgrade extends Upgrade {

	private static final FarmUpgrade INSTANCE = new FarmUpgrade();

	private FarmUpgrade() {
		super("Fertilizer", Farm.getInstance(), new BigDecimal[] { new BigDecimal("11000"), new BigDecimal("55000"),
				new BigDecimal("110000"), new BigDecimal("550000"), new BigDecimal("1100000") },
				PathStorage.FARMUPGRADE_PATH);
	}

	public static FarmUpgrade getInstance() {
		return INSTANCE;
	}
}
