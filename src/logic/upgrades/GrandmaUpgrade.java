package logic.upgrades;

import java.math.BigDecimal;

import logic.PathStorage;
import logic.generators.Grandma;
import logic.upgrades.base.Upgrade;

public class GrandmaUpgrade extends Upgrade {

	private static final GrandmaUpgrade INSTANCE = new GrandmaUpgrade();
	
	private GrandmaUpgrade() {
		super("Rolling Pins", Grandma.getInstance(), new BigDecimal[] { new BigDecimal("1000"), new BigDecimal("5000"),
				new BigDecimal("10000"), new BigDecimal("50000"), new BigDecimal("100000") },
				PathStorage.GRANDMAUPGRADE_PATH);
	}
	
	public static GrandmaUpgrade getInstance() {
		return INSTANCE;
	}
}
