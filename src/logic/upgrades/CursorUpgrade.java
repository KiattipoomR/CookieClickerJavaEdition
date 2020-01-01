package logic.upgrades;

import java.math.BigDecimal;

import logic.PathStorage;
import logic.generators.Cursor;
import logic.upgrades.base.Upgrade;

public class CursorUpgrade extends Upgrade {

	private static final CursorUpgrade INSTANCE = new CursorUpgrade();

	private CursorUpgrade() {
		super("Enhanced Cursor", Cursor.getInstance(), new BigDecimal[] { new BigDecimal("100"), new BigDecimal("500"),
				new BigDecimal("1000"), new BigDecimal("5000"), new BigDecimal("10000") },
				PathStorage.CURSORUPGRADE_PATH);
	}

	public static CursorUpgrade getInstance() {
		return INSTANCE;
	}
}