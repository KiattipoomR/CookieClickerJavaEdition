package application;

import javafx.scene.layout.VBox;
import logic.upgrades.BankUpgrade;
import logic.upgrades.CursorUpgrade;
import logic.upgrades.FactoryUpgrade;
import logic.upgrades.FarmUpgrade;
import logic.upgrades.GrandmaUpgrade;
import logic.upgrades.MineUpgrade;
import logic.upgrades.PlayerUpgrade;

public class UpgradeBlock extends VBox {

	private static final UpgradeBlock INSTANCE = new UpgradeBlock();
	private static final double BOX_WIDTH = 300;

	private static UpgradeTile cursorUpgradeTile;
	private static UpgradeTile grandmaUpgradeTile;
	private static UpgradeTile farmUpgradeTile;
	private static UpgradeTile mineUpgradeTile;
	private static UpgradeTile factoryUpgradeTile;
	private static UpgradeTile bankUpgradeTile;
	private static UpgradeTile playerUpgradeTile;

	private UpgradeBlock() {
		cursorUpgradeTile = new UpgradeTile(CursorUpgrade.getInstance());
		grandmaUpgradeTile = new UpgradeTile(GrandmaUpgrade.getInstance());
		farmUpgradeTile = new UpgradeTile(FarmUpgrade.getInstance());
		mineUpgradeTile = new UpgradeTile(MineUpgrade.getInstance());
		factoryUpgradeTile = new UpgradeTile(FactoryUpgrade.getInstance());
		bankUpgradeTile = new UpgradeTile(BankUpgrade.getInstance());
		playerUpgradeTile = new UpgradeTile(PlayerUpgrade.getInstance());

		this.setPrefWidth(BOX_WIDTH);
		this.getChildren().addAll(cursorUpgradeTile, grandmaUpgradeTile, farmUpgradeTile, mineUpgradeTile,
				factoryUpgradeTile, bankUpgradeTile, playerUpgradeTile);
	}
	
	public static UpgradeBlock getInstance() {
		return INSTANCE;
	}
}
