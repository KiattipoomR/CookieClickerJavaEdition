package application;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import logic.PrintBigNum;
import logic.generators.Bank;
import logic.generators.Cursor;
import logic.generators.Factory;
import logic.generators.Farm;
import logic.generators.Grandma;
import logic.generators.Mine;
import logic.upgrades.BankUpgrade;
import logic.upgrades.CursorUpgrade;
import logic.upgrades.FactoryUpgrade;
import logic.upgrades.FarmUpgrade;
import logic.upgrades.GrandmaUpgrade;
import logic.upgrades.MineUpgrade;
import logic.upgrades.PlayerUpgrade;

public class UpgradeStatBlock extends VBox {

	private static final UpgradeStatBlock INSTANCE = new UpgradeStatBlock();

	private SmallStatBox playerLevel;
	private SmallStatBox cursorPerSecond;
	private SmallStatBox cursorLevel;
	private SmallStatBox grandmaPerSecond;
	private SmallStatBox grandmaLevel;
	private SmallStatBox farmPerSecond;
	private SmallStatBox farmLevel;
	private SmallStatBox minePerSecond;
	private SmallStatBox mineLevel;
	private SmallStatBox factoryPerSecond;
	private SmallStatBox factoryLevel;
	private SmallStatBox bankPerSecond;
	private SmallStatBox bankLevel;

	private UpgradeStatBlock() {
		Label upgradeTitle = new Label("Upgrades");
		upgradeTitle.setStyle("-fx-font-size: 23px;");
		upgradeTitle.setTextFill(Color.WHITE);
		upgradeTitle.setPadding(new Insets(0, 0, 5, 0));

		playerLevel = new SmallStatBox("Clicking level :");
		cursorPerSecond = new SmallStatBox("Cursor's cookie(s) per second :");
		cursorLevel = new SmallStatBox("Cursor's level :");
		grandmaPerSecond = new SmallStatBox("Grandma's cookie(s) per second :");
		grandmaLevel = new SmallStatBox("Grandma's level :");
		farmPerSecond = new SmallStatBox("Farm's cookie(s) per second :");
		farmLevel = new SmallStatBox("Farm's level :");
		minePerSecond = new SmallStatBox("Mine's cookie(s) per second :");
		mineLevel = new SmallStatBox("Mine's level :");
		factoryPerSecond = new SmallStatBox("Factory's cookie(s) per second :");
		factoryLevel = new SmallStatBox("Factory's level :");
		bankPerSecond = new SmallStatBox("Bank's cookie(s) per second :");
		bankLevel = new SmallStatBox("Bank's level :");

		VBox upgradeDetail = new VBox();
		upgradeDetail.setSpacing(5);
		upgradeDetail.setPadding(new Insets(0, 0, 10, 0));
		upgradeDetail.getChildren().addAll(playerLevel, cursorPerSecond, cursorLevel, grandmaPerSecond, grandmaLevel,
				farmPerSecond, farmLevel, minePerSecond, mineLevel, factoryPerSecond, factoryLevel, bankPerSecond,
				bankLevel);

		this.getChildren().addAll(upgradeTitle, upgradeDetail);
	}

	public static UpgradeStatBlock getInstance() {
		return INSTANCE;
	}

	public void setPlayerLevel() {
		playerLevel.setAmount(Integer.toString(PlayerUpgrade.getInstance().getUpgradeLevel()));
	}

	public void setCursorPerSecond() {
		cursorPerSecond.setAmount(PrintBigNum.PrintBigNumForPerSecond(Cursor.getInstance().getCurrentPerSecond()));
	}

	public void setCursorLevel() {
		cursorLevel.setAmount(Integer.toString(CursorUpgrade.getInstance().getUpgradeLevel()));
	}

	public void setGrandmaPerSecond() {
		grandmaPerSecond.setAmount(PrintBigNum.PrintBigNumForPerSecond(Grandma.getInstance().getCurrentPerSecond()));
	}

	public void setGrandmaLevel() {
		grandmaLevel.setAmount(Integer.toString(GrandmaUpgrade.getInstance().getUpgradeLevel()));
	}

	public void setFarmPerSecond() {
		farmPerSecond.setAmount(PrintBigNum.PrintBigNumForPerSecond(Farm.getInstance().getCurrentPerSecond()));
	}

	public void setFarmLevel() {
		farmLevel.setAmount(Integer.toString(FarmUpgrade.getInstance().getUpgradeLevel()));
	}

	public void setMinePerSecond() {
		minePerSecond.setAmount(PrintBigNum.PrintBigNumForPerSecond(Mine.getInstance().getCurrentPerSecond()));
	}

	public void setMineLevel() {
		mineLevel.setAmount(Integer.toString(MineUpgrade.getInstance().getUpgradeLevel()));
	}

	public void setFactoryPerSecond() {
		factoryPerSecond.setAmount(PrintBigNum.PrintBigNumForPerSecond(Factory.getInstance().getCurrentPerSecond()));
	}

	public void setFactoryLevel() {
		factoryLevel.setAmount(Integer.toString(FactoryUpgrade.getInstance().getUpgradeLevel()));
	}

	public void setBankPerSecond() {
		bankPerSecond.setAmount(PrintBigNum.PrintBigNumForPerSecond(Bank.getInstance().getCurrentPerSecond()));
	}

	public void setBankLevel() {
		bankLevel.setAmount(Integer.toString(BankUpgrade.getInstance().getUpgradeLevel()));
	}

	public void update() {
		setPlayerLevel();
		setCursorPerSecond();
		setCursorLevel();
		setGrandmaPerSecond();
		setGrandmaLevel();
		setFarmPerSecond();
		setFarmLevel();
		setMinePerSecond();
		setMineLevel();
		setFactoryPerSecond();
		setFactoryLevel();
		setBankPerSecond();
		setBankLevel();
	}
}
