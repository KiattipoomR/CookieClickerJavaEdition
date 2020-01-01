package logic.upgrades.base;

import java.math.BigDecimal;

import logic.Player;
import logic.Purchasable;
import logic.exceptions.PurchaseFailedException;
import logic.generators.base.Generator;

public abstract class Upgrade implements Purchasable {

	protected String name;
	protected Generator generator;
	protected BigDecimal[] upgradePrice;
	protected int[] amountCondition;
	protected int upgradeLevel;
	protected String imagePath;

	protected Upgrade(String name, Generator generator, BigDecimal[] upgradePrice, String imagePath) {
		this.name = name;
		this.generator = generator;
		this.upgradePrice = upgradePrice;
		this.amountCondition = new int[] { 1, 5, 25, 50, 100 };
		this.upgradeLevel = 0;
		this.imagePath = imagePath;
	}

	public void buy() throws PurchaseFailedException {
		if (upgradeLevel >= amountCondition.length)
			throw new PurchaseFailedException(this, 0);
		else if (generator.getAmountOwned() < amountCondition[upgradeLevel])
			throw new PurchaseFailedException(this, 1);

		if (Player.getInstance().getCurrentCookies().compareTo(upgradePrice[upgradeLevel]) == -1)
			throw new PurchaseFailedException(this, 2);
		Player.getInstance()
				.setCurrentCookies(Player.getInstance().getCurrentCookies().subtract(upgradePrice[upgradeLevel]));
		generator.upgrade();
		upgradeLevel++;
	}

	public String getName() {
		return name;
	}

	public Generator getGenerator() {
		return generator;
	}

	public BigDecimal getUpgradePrice() {
		BigDecimal price = BigDecimal.ZERO;
		if (upgradeLevel < amountCondition.length)
			price = upgradePrice[upgradeLevel];
		return price;
	}

	public int getAmountCondition() {
		int amount = 0;
		if (upgradeLevel < amountCondition.length)
			amount = amountCondition[upgradeLevel];
		return amount;
	}

	public int getUpgradeLevel() {
		return upgradeLevel;
	}

	public String getImagePath() {
		return imagePath;
	}
}
