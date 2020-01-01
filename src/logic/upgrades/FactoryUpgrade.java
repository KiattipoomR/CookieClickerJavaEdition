package logic.upgrades;

import java.math.BigDecimal;

import logic.PathStorage;
import logic.generators.Factory;
import logic.upgrades.base.Upgrade;

public class FactoryUpgrade extends Upgrade {

	private static final FactoryUpgrade INSTANCE = new FactoryUpgrade();

	private FactoryUpgrade() {
		super("Conveyor Belts", Factory.getInstance(),
				new BigDecimal[] { new BigDecimal("1300000"), new BigDecimal("6500000"), new BigDecimal("13000000"),
						new BigDecimal("65000000"), new BigDecimal("130000000") },
				PathStorage.FACTORYUPGRADE_PATH);
	}

	public static FactoryUpgrade getInstance() {
		return INSTANCE;
	}
}
