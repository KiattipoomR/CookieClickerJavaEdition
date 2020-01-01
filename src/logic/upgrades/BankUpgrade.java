package logic.upgrades;

import java.math.BigDecimal;

import logic.PathStorage;
import logic.generators.Bank;
import logic.upgrades.base.Upgrade;

public class BankUpgrade extends Upgrade {

	private static final BankUpgrade INSTANCE = new BankUpgrade();

	private BankUpgrade() {
		super("Edible Money", Bank.getInstance(),
				new BigDecimal[] { new BigDecimal("14000000"), new BigDecimal("70000000"), new BigDecimal("140000000"),
						new BigDecimal("700000000"), new BigDecimal("1400000000") },
				PathStorage.BANKUPGRADE_PATH);
	}

	public static BankUpgrade getInstance() {
		return INSTANCE;
	}

}
